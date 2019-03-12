package com.hz.yk.javaparser;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * @author wuzheng.yk
 * @date 2018/11/29
 */
public class classUnit extends VoidVisitorAdapter<Object> {

    Logger log = LoggerFactory.getLogger(classUnit.class);
    //alt+shift m 成员方法

    /**
     * 包名
     */
    @Override
    public void visit(PackageDeclaration n, Object arg) {
        System.out.println("package---------" + n.getName());
        super.visit(n, arg);
    }

    /**
     * 支持包
     */
    @Override
    public void visit(ImportDeclaration n, Object arg) {
        log.info("ImportDeclaration-------------" + n.toString());
        super.visit(n, arg);
    }

    /**
     * 类
     */
    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        log.info("arg-----------" + arg);//null
        log.info("n.toString()--------" + n.toString());// 整个类的内容, 不包括 package 和 import
        log.info("n.getNameAsString()---------" + n.getNameAsString());// 类名
        // 获取类的注解
        NodeList<AnnotationExpr> annotations = n.getAnnotations();
        // 判断是否有注解
        if (annotations.size() > 0) {
            for (AnnotationExpr annotation : annotations) {
                log.info(annotation.toString());
            }
        }
        // 获取类的注释
        Optional<JavadocComment> javadocComment = n.getJavadocComment();
        log.info(javadocComment.toString());
        super.visit(n, arg);
    }

    /**
     * 成员方法
     */
    @Override
    public void visit(MethodDeclaration n, Object arg) {
        log.info("***********************************************************");
        log.info("arg-----------" + arg);//null
        log.info("n.toString()--------" + n.toString());// 整个方法的内容
        log.info("n.getNameAsString()---------" + n.getNameAsString());// 方法名
        log.info("n.getParameters()---------" + n.getParameters());// 所有参数
        NodeList<Parameter> parameters = n.getParameters();
        for (Parameter parameter : parameters) {
            log.info(parameter.toString());
        }
        // 获取方法的注解
        NodeList<AnnotationExpr> annotations = n.getAnnotations();
        // 判断是否有注解
        if (annotations.size() > 0) {
            for (AnnotationExpr annotation : annotations) {
                log.info(annotation.toString());
            }
        }
        // 获取方法的注释
        Optional<JavadocComment> javadocComment = n.getJavadocComment();
        log.info(javadocComment.toString());
        // 获取方法里面的方法
        /*CompilationUnit cu = JavaParser.parse(n.toString());
        cu.accept(new methodUnit(), null);*/
        super.visit(n, arg);
    }

    /**
     * 变量
     */
    @Override
    public void visit(VariableDeclarator n, Object arg) {
        log.info("VariableDeclarator--------" + n.toString());
        log.info("VariableDeclarator--------");
        //bContentService  成员变量
        //bContentDO = bContentService.get(cid)  方法内部的变量
        super.visit(n, arg);
    }

    /**
     * 成员变量的注解
     */
    @Override
    public void visit(FieldDeclaration n, Object arg) {
        log.info("FieldDeclaration###############" + n.toString());//@Autowired
        System.out.println("所在位置的行号, int 类型" + n.getRange().get().begin.line);
        super.visit(n, arg);
    }

}
