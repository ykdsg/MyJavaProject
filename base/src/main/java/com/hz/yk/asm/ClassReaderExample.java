package com.hz.yk.asm;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import java.io.IOException;

/**
 * Created by wuzheng.yk on 16/9/7.
 */
public class ClassReaderExample {
    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("java.lang.String");
        classReader.accept(new MyClassVisitor(), 0);
    }

    private static class MyClassVisitor implements ClassVisitor {
        @Override
        public void visit(int version, int access, String name,
                          String signature, String superName, String[] interfaces) {
            System.out.println("class name:" + name);
            System.out.println("super class name:" + superName);
            System.out.println("class version:" + version);
            System.out.println("class access:" + access);
            System.out.println("class signature:" + signature);

            if ((interfaces != null) && (interfaces.length > 0)) {
                for (String str : interfaces) {
                    System.out.println("implemented interface name:" + str);
                }
            }
        }

        @Override
        public void visitSource(String source, String debug) {
        }

        @Override
        public void visitOuterClass(String owner, String name, String desc) {
        }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return null;
        }

        @Override
        public void visitAttribute(Attribute attr) {
        }

        @Override
        public void visitInnerClass(String name, String outerName,
                                    String innerName, int access) {
        }

        @Override
        public FieldVisitor visitField(int access, String name, String desc,
                                       String signature, Object value) {
            return null;
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc,
                                         String signature, String[] exceptions) {
            return null;
        }

        @Override
        public void visitEnd() {
        }
    }
}
