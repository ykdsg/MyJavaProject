package com.hz.yk.swing

import groovy.swing.SwingBuilder

import javax.swing.*

/**
 * @author wuzheng.yk
 * Date: 13-1-23
 * Time: обнГ6:42
 */
class HelloGroovySwing {

    static void main(args){
        def swingBuilder = new SwingBuilder()
        swingBuilder.frame(title:"Hello Groovy Swing",
                defaultCloseOperation:JFrame.EXIT_ON_CLOSE,
                size:[200,300],
                show:true) {
            panel(){
                label("Hello Groovy Swing")
            }
        }
    }
}
