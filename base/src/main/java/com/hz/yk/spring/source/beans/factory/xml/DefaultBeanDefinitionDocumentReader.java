package com.hz.yk.spring.source.beans.factory.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yangke
 * Date: 13-8-4
 * Time: ����8:10
 */
public class DefaultBeanDefinitionDocumentReader implements BeanDefinitionDocumentReader {

    public static final String BEAN_ELEMENT = BeanDefinitionParserDelegate.BEAN_ELEMENT;

    public static final String ALIAS_ELEMENT = "alias";

    public static final String NAME_ATTRIBUTE = "name";

    public static final String ALIAS_ATTRIBUTE = "alias";

    public static final String IMPORT_ELEMENT = "import";

    public static final String RESOURCE_ATTRIBUTE = "resource";

    protected final Log logger = LogFactory.getLog(getClass());

    private org.springframework.beans.factory.xml.XmlReaderContext readerContext;

    /**
     * Parses bean definitions according to the "spring-beans" DTD.
     * <p>Opens a DOM Document; then initializes the default settings
     * specified at <code>&lt;beans&gt;</code> level; then parses
     * the contained bean definitions.
     */
    public void registerBeanDefinitions(Document doc,
                                        org.springframework.beans.factory.xml.XmlReaderContext readerContext) {
        this.readerContext = readerContext;

        logger.debug("Loading bean definitions");
        Element root = doc.getDocumentElement();

        BeanDefinitionParserDelegate delegate = createHelper(readerContext, root);

        preProcessXml(root);
        parseBeanDefinitions(root, delegate);
        postProcessXml(root);
    }

    protected BeanDefinitionParserDelegate createHelper(
            org.springframework.beans.factory.xml.XmlReaderContext readerContext, Element root) {
        BeanDefinitionParserDelegate delegate = new BeanDefinitionParserDelegate(readerContext);
        delegate.initDefaults(root);
        return delegate;
    }

    /**
     * Return the descriptor for the XML resource that this parser works on.
     */
    protected final org.springframework.beans.factory.xml.XmlReaderContext getReaderContext() {
        return this.readerContext;
    }

    /**
     * Invoke the {@link org.springframework.beans.factory.parsing.SourceExtractor} to pull the
     * source metadata from the supplied {@link Element}.
     */
    protected Object extractSource(Element ele) {
        return this.readerContext.extractSource(ele);
    }

    /**
     * Parse the elements at the root level in the document:
     * "import", "alias", "bean".
     *
     * @param root the DOM root element of the document
     */
    protected void parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate) {
        if (delegate.isDefaultNamespace(root.getNamespaceURI())) {
            NodeList nl = root.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (node instanceof Element) {
                    Element ele = (Element) node;
                    String namespaceUri = ele.getNamespaceURI();
                    if (delegate.isDefaultNamespace(namespaceUri)) {
                        parseDefaultElement(ele, delegate);
                    } else {
                        delegate.parseCustomElement(ele);
                    }
                }
            }
        } else {
            delegate.parseCustomElement(root);
        }
    }

    private void parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) {
        if (DomUtils.nodeNameEquals(ele, IMPORT_ELEMENT)) {
            importBeanDefinitionResource(ele);
        } else if (DomUtils.nodeNameEquals(ele, ALIAS_ELEMENT)) {
            processAliasRegistration(ele);
        } else if (DomUtils.nodeNameEquals(ele, BEAN_ELEMENT)) {
            processBeanDefinition(ele, delegate);
        }
    }

    /**
     * Parse an "import" element and load the bean definitions
     * from the given resource into the bean factory.
     */
    protected void importBeanDefinitionResource(Element ele) {
        String location = ele.getAttribute(RESOURCE_ATTRIBUTE);
        if (!StringUtils.hasText(location)) {
            getReaderContext().error("Resource location must not be empty", ele);
            return;
        }

        // Resolve system properties: e.g. "${user.dir}"
        location = SystemPropertyUtils.resolvePlaceholders(location);

        if (ResourcePatternUtils.isUrl(location)) {
            try {
                Set actualResources = new LinkedHashSet(4);
                int importCount = getReaderContext().getReader().loadBeanDefinitions(location, actualResources);
                if (logger.isDebugEnabled()) {
                    logger.debug("Imported " + importCount + " bean definitions from URL location [" + location + "]");
                }
                Resource[] actResArray = (Resource[]) actualResources.toArray(new Resource[actualResources.size()]);
                getReaderContext().fireImportProcessed(location, actResArray, extractSource(ele));
            } catch (org.springframework.beans.factory.BeanDefinitionStoreException ex) {
                getReaderContext()
                        .error("Failed to import bean definitions from URL location [" + location + "]", ele, ex);
            }
        } else {
            // No URL -> considering resource location as relative to the current file.
            try {
                Resource relativeResource = getReaderContext().getResource().createRelative(location);
                int importCount = getReaderContext().getReader().loadBeanDefinitions(relativeResource);
                if (logger.isDebugEnabled()) {
                    logger.debug(
                            "Imported " + importCount + " bean definitions from relative location [" + location + "]");
                }
                getReaderContext()
                        .fireImportProcessed(location, new Resource[]{ relativeResource }, extractSource(ele));
            } catch (IOException ex) {
                getReaderContext()
                        .error("Invalid relative resource location [" + location + "] to import bean definitions from",
                               ele, ex);
            } catch (org.springframework.beans.factory.BeanDefinitionStoreException ex) {
                getReaderContext()
                        .error("Failed to import bean definitions from relative location [" + location + "]", ele, ex);
            }
        }
    }

    /**
     * Process the given alias element, registering the alias with the registry.
     */
    protected void processAliasRegistration(Element ele) {
        String name = ele.getAttribute(NAME_ATTRIBUTE);
        String alias = ele.getAttribute(ALIAS_ATTRIBUTE);
        boolean valid = true;
        if (!StringUtils.hasText(name)) {
            getReaderContext().error("Name must not be empty", ele);
            valid = false;
        }
        if (!StringUtils.hasText(alias)) {
            getReaderContext().error("Alias must not be empty", ele);
            valid = false;
        }
        if (valid) {
            try {
                getReaderContext().getRegistry().registerAlias(name, alias);
            } catch (Exception ex) {
                getReaderContext()
                        .error("Failed to register alias '" + alias + "' for bean with name '" + name + "'", ele, ex);
            }
            getReaderContext().fireAliasRegistered(name, alias, extractSource(ele));
        }
    }

    /**
     * Process the given bean element, parsing the bean definition
     * and registering it with the registry.
     */
    protected void processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate) {
        BeanDefinitionHolder bdHolder = delegate.parseBeanDefinitionElement(ele);
        if (bdHolder != null) {
            bdHolder = delegate.decorateBeanDefinitionIfRequired(ele, bdHolder);
            try {
                // Register the final decorated instance.
                BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder, getReaderContext().getRegistry());
            } catch (org.springframework.beans.factory.BeanDefinitionStoreException ex) {
                getReaderContext()
                        .error("Failed to register bean definition with name '" + bdHolder.getBeanName() + "'", ele,
                               ex);
            }
            // Send registration event.
            getReaderContext().fireComponentRegistered(new BeanComponentDefinition(bdHolder));
        }
    }

    /**
     * Allow the XML to be extensible by processing any custom element types first,
     * before we start to process the bean definitions. This method is a natural
     * extension point for any other custom pre-processing of the XML.
     * <p>The default implementation is empty. Subclasses can override this method to
     * convert custom elements into standard Spring bean definitions, for example.
     * Implementors have access to the parser's bean definition reader and the
     * underlying XML resource, through the corresponding accessors.
     *
     * @see #getReaderContext()
     */
    protected void preProcessXml(Element root) {
    }

    /**
     * Allow the XML to be extensible by processing any custom element types last,
     * after we finished processing the bean definitions. This method is a natural
     * extension point for any other custom post-processing of the XML.
     * <p>The default implementation is empty. Subclasses can override this method to
     * convert custom elements into standard Spring bean definitions, for example.
     * Implementors have access to the parser's bean definition reader and the
     * underlying XML resource, through the corresponding accessors.
     *
     * @see #getReaderContext()
     */
    protected void postProcessXml(Element root) {
    }
}
