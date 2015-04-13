package com.hz.yk.yk.dynamic;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangke
 *         Date: 12-8-3
 *         Time: 下午3:51
 */
public class InterfaceGenerator {

    private static Method DEFINE_CLASS_METHOD;

    private String name;

    private Set<MethodInfo> methods = new HashSet<MethodInfo>();

    private ConstantPool cp = new ConstantPool();

    static {
        try {
            // String name, byte[] b, int off, int len
            DEFINE_CLASS_METHOD = Class.forName("java.lang.ClassLoader").getDeclaredMethod("defineClass", new Class<?>[] { String.class, (new byte[0]).getClass(), int.class, int.class });
            DEFINE_CLASS_METHOD.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public InterfaceGenerator(String name) {
        super();
        this.name = name;
    }

    /**
     * @param methodName
     * @param returnType
     */
    public void addMethod(String methodName, Class<?>[] parameterTypes, Class<?> returnType) {
        methods.add(new MethodInfo(methodName, parameterTypes, returnType, cp));

    }

    public Class<?> getInterfaceClass(ClassLoader classloader) {
        try {
            // 先尝试直接加载
            return Class.forName(name, true, classloader);
        } catch (ClassNotFoundException ex) {
            try {
                byte[] data = toBytes();
                DEFINE_CLASS_METHOD.invoke(classloader, new Object[] { name, data, 0, data.length });
                return Class.forName(name, true, classloader);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getTargetException());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public byte[] toBytes() {
        cp.getClass(dotToSlash(name));
        cp.getClass(dotToSlash("java.lang.Object"));

        for (MethodInfo methodDesc : methods) {
            cp.getNameAndType(methodDesc.getName(), methodDesc.getDescriptor());
        }
        cp.setReadOnly();


        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream os = new DataOutputStream(bos);
        try {
            // magic
            os.writeInt(0xCAFEBABE);

            // version
            os.writeShort(ClassFileConstants.ClassVersion.MINOR_VERSION);
            os.writeShort(ClassFileConstants.ClassVersion.MAJOR_VERSION);

            // constants pool
            cp.write(os);

            // access_flag
            os.writeShort(ClassFileConstants.JVM_ACC_INTERFACE | ClassFileConstants.JVM_ACC_PUBLIC);

            // this class
            os.writeShort(cp.getClass(dotToSlash(name)));

            // super class
            os.writeShort(cp.getClass(dotToSlash("java.lang.Object")));

            // interface count
            os.writeShort(0); //

            // interfaces
            // nothing

            // fields count
            os.writeShort(0);

            // fields
            // nothing

            // method count
            os.writeShort(methods.size());

            // methods
            for (MethodInfo methodDesc : methods) {
                methodDesc.write(os);
            }

            // attirbutes count
            os.writeShort(0);

            // attributes
            // nothing

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bos.toByteArray();
    }

    private static String dotToSlash(String paramString) {
        return paramString.replace('.', '/');
    }

    private static String getMethodDescriptor(Class<?>[] paramArrayOfClass, Class<?> paramClass) {
        if (paramArrayOfClass == null) {
            paramArrayOfClass = ArrayClassUtil.EMPTY_CLASS_ARRAY;
        }
        return getParameterDescriptors(paramArrayOfClass) + ((paramClass == Void.TYPE) ? "V" : getFieldType(paramClass));
    }

    private static String getParameterDescriptors(Class<?>[] paramArrayOfClass) {
        StringBuilder localStringBuilder = new StringBuilder("(");
        for (int i = 0; i < paramArrayOfClass.length; ++i)
            localStringBuilder.append(getFieldType(paramArrayOfClass[i]));
        localStringBuilder.append(')');
        return localStringBuilder.toString();
    }

    private static String getFieldType(Class<?> paramClass) {
        if (paramClass.isPrimitive())
            return PrimitiveTypeInfo.get(paramClass).baseTypeString;
        if (paramClass.isArray())
            return paramClass.getName().replace('.', '/');
        return "L" + dotToSlash(paramClass.getName()) + ";";
    }

    private static class PrimitiveTypeInfo {
        public String baseTypeString;
        private static Map<Class<?>, PrimitiveTypeInfo> table;

        private static void add(Class<?> paramClass1, Class<?> paramClass2) {
            table.put(paramClass1, new PrimitiveTypeInfo(paramClass1, paramClass2));
        }

        private PrimitiveTypeInfo(Class<?> paramClass1, Class<?> paramClass2) {
            assert (paramClass1.isPrimitive());
            this.baseTypeString = Array.newInstance(paramClass1, 0).getClass().getName().substring(1);
        }

        public static PrimitiveTypeInfo get(Class<?> paramClass) {
            return ((PrimitiveTypeInfo) table.get(paramClass));
        }

        static {
            table = new HashMap<Class<?>, PrimitiveTypeInfo>();
            add(Byte.TYPE, Byte.class);
            add(Character.TYPE, Character.class);
            add(Double.TYPE, Double.class);
            add(Float.TYPE, Float.class);
            add(Integer.TYPE, Integer.class);
            add(Long.TYPE, Long.class);
            add(Short.TYPE, Short.class);
            add(Boolean.TYPE, Boolean.class);
        }
    }

    static class MethodInfo {
        String name;
        String descriptor;
        ConstantPool cp;

        private MethodInfo(String name, Class<?>[] parameterTypes, Class<?> returnType, ConstantPool cp) {
            super();
            this.name = name;
            this.descriptor = getMethodDescriptor(parameterTypes, returnType);
            this.cp = cp;
        }

        public void write(DataOutputStream os) throws IOException {
            // access flags
            os.writeShort(ClassFileConstants.JVM_ACC_ABSTRACT | ClassFileConstants.JVM_ACC_PUBLIC);
            //  name_index;
            os.writeShort(cp.getUtf8(name));
            // descriptor_index;
            os.writeShort(cp.getUtf8(this.descriptor));
            // attributes_count;
            os.writeShort(0);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescriptor() {
            return descriptor;
        }

        public void setDescriptor(String descriptor) {
            this.descriptor = descriptor;
        }

    }

}
