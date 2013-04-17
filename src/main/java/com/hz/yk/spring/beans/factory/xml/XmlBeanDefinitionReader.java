package com.hz.yk.spring.beans.factory.xml;


import com.hz.yk.spring.beans.factory.support.BeanDefinitionRegistry;
import com.hz.yk.spring.core.io.Resource;
import com.hz.yk.spring.core.io.ResourceLoader;
import com.hz.yk.spring.core.io.support.EncodedResource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionStoreException;
import org.springframework.core.NamedThreadLocal;
import org.springframework.util.Assert;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.springframework.util.xml.XmlValidationModeDetector;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author wuzheng.yk
 *         Date: 13-2-8
 *         Time: ����11:26
 */
public class XmlBeanDefinitionReader  {

    private final ThreadLocal<Set> resourcesCurrentlyBeingLoaded =
            new NamedThreadLocal("XML bean definition resources currently being loaded");
    /**
     * Indicates that the validation mode should be detected automatically.
     */
    public static final int VALIDATION_AUTO = XmlValidationModeDetector.VALIDATION_AUTO;

    /**
     * Indicates that XSD validation should be used.
     */
    public static final int VALIDATION_XSD = XmlValidationModeDetector.VALIDATION_XSD;

    private final XmlValidationModeDetector validationModeDetector = new XmlValidationModeDetector();

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private int validationMode = VALIDATION_AUTO;
    private DocumentLoader documentLoader = new DefaultDocumentLoader();
    private EntityResolver entityResolver;
    private ResourceLoader resourceLoader;
    private ErrorHandler errorHandler = new SimpleSaxErrorHandler(logger);
    private boolean namespaceAware;
    private Class parserClass;

    /**
     * Create new XmlBeanDefinitionReader for the given bean factory.
     * @param registry the BeanFactory to load bean definitions into,
     * in the form of a BeanDefinitionRegistry
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
//        super(registry);
    }



    /**
     * Load bean definitions from the specified XML file.
     * @param resource the resource descriptor for the XML file
     * @return the number of bean definitions found
     * @throws BeanDefinitionStoreException in case of loading or parsing errors
     */
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        return loadBeanDefinitions(new EncodedResource(resource));
    }


    /**
     * Load bean definitions from the specified XML file.
     * @param encodedResource the resource descriptor for the XML file,
     * allowing to specify an encoding to use for parsing the file
     * @return the number of bean definitions found
     * @throws BeanDefinitionStoreException in case of loading or parsing errors
     */
    public int loadBeanDefinitions(EncodedResource encodedResource) throws BeanDefinitionStoreException {
        Assert.notNull(encodedResource, "EncodedResource must not be null");
        if (logger.isInfoEnabled()) {
            logger.info("Loading XML bean definitions from " + encodedResource.getResource());
        }
        //�̰߳�ȫ �������� currentResourcesӦ�ñ��������̰߳�ȫ�ģ������Ʋⲻ��Ϊ���̰߳�ȫ
        //Ӧ����Ϊ���߳���ʹ��ͬһ�� currentResources  ����������Կ������߶� ThreadLocal ���������
        Set<EncodedResource> currentResources = this.resourcesCurrentlyBeingLoaded.get();
        if (currentResources == null) {
            currentResources = new HashSet<EncodedResource>(4);
            this.resourcesCurrentlyBeingLoaded.set(currentResources);
        }
        //������ʵ����Ϊ�˱���ѭ�����أ�����ظ���������ͬ���ļ��ͻ��׳��쳣
        //���￴�˰�����������set����ͼ�����۰�
        if (!currentResources.add(encodedResource)) {
            throw new BeanDefinitionStoreException(
                    "Detected recursive loading of " + encodedResource + " - check your import definitions!");
        }
        try {
            InputStream inputStream = encodedResource.getResource().getInputStream();
            try {
                InputSource inputSource = new InputSource(inputStream);
                if (encodedResource.getEncoding() != null) {
                    inputSource.setEncoding(encodedResource.getEncoding());
                }
                return doLoadBeanDefinitions(inputSource, encodedResource.getResource());
            }
            finally {
                inputStream.close();
            }
        }
        catch (IOException ex) {
            throw new BeanDefinitionStoreException(
                    "IOException parsing XML document from " + encodedResource.getResource(), ex);
        }
        finally {
            currentResources.remove(encodedResource);
            if (currentResources.isEmpty()) {
                this.resourcesCurrentlyBeingLoaded.set(null);
            }
        }
    }


    /**
     * Actually load bean definitions from the specified XML file.
     * @param inputSource the SAX InputSource to read from
     * @param resource the resource descriptor for the XML file
     * @return the number of bean definitions found
     * @throws BeanDefinitionStoreException in case of loading or parsing errors
     */
    protected int doLoadBeanDefinitions(InputSource inputSource,Resource resource)
            throws BeanDefinitionStoreException {
        try {
            //�ж�xml�ļ���DTD����XSD��ʽ,���û���彫ʹ��XSD
            int validationMode = getValidationModeForResource(resource);
            Document doc = this.documentLoader.loadDocument(
                    inputSource, getEntityResolver(), this.errorHandler, validationMode, isNamespaceAware());
            return registerBeanDefinitions(doc, resource);
        }
        catch (BeanDefinitionStoreException ex) {
            throw ex;
        }
        catch (SAXParseException ex) {
            throw new XmlBeanDefinitionStoreException(resource.getDescription(),
                    "Line " + ex.getLineNumber() + " in XML document from " + resource + " is invalid", ex);
        }
        catch (SAXException ex) {
            throw new XmlBeanDefinitionStoreException(resource.getDescription(),
                    "XML document from " + resource + " is invalid", ex);
        }
        catch (ParserConfigurationException ex) {
            throw new BeanDefinitionStoreException(resource.getDescription(),
                    "Parser configuration exception parsing XML from " + resource, ex);
        }
        catch (IOException ex) {
            throw new BeanDefinitionStoreException(resource.getDescription(),
                    "IOException parsing XML document from " + resource, ex);
        }
        catch (Throwable ex) {
            throw new BeanDefinitionStoreException(resource.getDescription(),
                    "Unexpected exception parsing XML document from " + resource, ex);
        }
    }

    /**
     * Return the EntityResolver to use, building a default resolver
     * if none specified.
     */
    protected EntityResolver getEntityResolver() {
//        if (this.entityResolver == null) {
//            // Determine default EntityResolver to use.
//            ResourceLoader resourceLoader = getResourceLoader();
//            if (resourceLoader != null) {
//                this.entityResolver = new ResourceEntityResolver(resourceLoader);
//            }
//            else {
//                this.entityResolver = new DelegatingEntityResolver(getBeanClassLoader());
//            }
//        }
        return this.entityResolver;
    }


    /**
     * �ж�xml�ļ���DTD����XSD��ʽ,���û���彫ʹ��XSD
     * Gets the validation mode for the specified {@link Resource}. If no explicit
     * validation mode has been configured then the validation mode is
     * {@link #detectValidationMode detected}.
     * <p>Override this method if you would like full control over the validation
     * mode, even when something other than {@link #VALIDATION_AUTO} was set.
     */
    protected int getValidationModeForResource(Resource resource) {
        int validationModeToUse = getValidationMode();
        if (validationModeToUse != VALIDATION_AUTO) {
            return validationModeToUse;
        }
        int detectedMode = detectValidationMode(resource);
        if (detectedMode != VALIDATION_AUTO) {
            return detectedMode;
        }
        // Hmm, we didn't get a clear indication... Let's assume XSD,
        // since apparently no DTD declaration has been found up until
        // detection stopped (before finding the document's root tag).
        return VALIDATION_XSD;
    }

    /**
     * Return the validation mode to use.
     */
    public int getValidationMode() {
        return this.validationMode;
    }

    /**
     * �ж�xml�ļ���DTD����XSD��ʽ
     * @param resource
     * @return
     */
    protected int detectValidationMode(Resource resource) {
        //���Ĭ�Ϸ���false
        if (resource.isOpen()) {
            throw new BeanDefinitionStoreException(
                    "Passed-in Resource [" + resource + "] contains an open stream: " +
                            "cannot determine validation mode automatically. Either pass in a Resource " +
                            "that is able to create fresh streams, or explicitly specify the validationMode " +
                            "on your XmlBeanDefinitionReader instance.");
        }

        InputStream inputStream;
        try {
            inputStream = resource.getInputStream();
        }
        catch (IOException ex) {
            throw new BeanDefinitionStoreException(
                    "Unable to determine validation mode for [" + resource + "]: cannot open InputStream. " +
                            "Did you attempt to load directly from a SAX InputSource without specifying the " +
                            "validationMode on your XmlBeanDefinitionReader instance?", ex);
        }

        try {
            //�ж�xml�ļ���DTD����XSD��ʽ
            return this.validationModeDetector.detectValidationMode(inputStream);
        }
        catch (IOException ex) {
            throw new BeanDefinitionStoreException("Unable to determine validation mode for [" +
                    resource + "]: an error occurred whilst reading from the InputStream.", ex);
        }
    }


    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

    /**
     * Return whether or not the XML parser should be XML namespace aware.
     */
    public boolean isNamespaceAware() {
        return this.namespaceAware;
    }


    public int registerBeanDefinitions(Document doc, Resource resource) throws BeanDefinitionStoreException {
        // Support old XmlBeanDefinitionParser SPI for backwards-compatibility.
//        if (this.parserClass != null) {
//            XmlBeanDefinitionParser parser =
//                    (XmlBeanDefinitionParser) BeanUtils.instantiateClass(this.parserClass);
//            return parser.registerBeanDefinitions(this, doc, resource);
//        }
//        // Read document based on new BeanDefinitionDocumentReader SPI.
//        BeanDefinitionDocumentReader documentReader = createBeanDefinitionDocumentReader();
//        int countBefore = getRegistry().getBeanDefinitionCount();
//        documentReader.registerBeanDefinitions(doc, createReaderContext(resource));
//        return getRegistry().getBeanDefinitionCount() - countBefore;
        return 0;
    }

}