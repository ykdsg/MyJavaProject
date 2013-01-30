package com.hz.yk.swing

import groovy.swing.SwingBuilder

import javax.swing.*

/**
 * @author wuzheng.yk
 * Date: 13-1-23
 * Time: ÏÂÎç6:49
 */
class Gwitter {
    static void main(String[] args){
        def gwitter = new Gwitter()
        gwitter.show()
    }

    void show(){
        def swingBuilder = new SwingBuilder()

        def customMenuBar = {
            swingBuilder.menuBar{
                menu(text: "File", mnemonic: 'F') {
                    menuItem(text: "Exit", mnemonic: 'X', actionPerformed: { dispose() })
                }
            }
        }

        swingBuilder.frame(title:"Gwitter",
                defaultCloseOperation:JFrame.EXIT_ON_CLOSE,
                size:[400,500],
                show:true) {
            customMenuBar()
        }
    }
}
