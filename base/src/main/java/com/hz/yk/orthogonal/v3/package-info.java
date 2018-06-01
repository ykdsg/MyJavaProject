/**
 * V2 将lambda表达式封装在Factory的设计是及其脆弱的
 * 例如，增加如下的需求：
 * 需求： 查找年龄不等于18岁的女生
 * 最简单的方法就是往StudentPredicates不停地增加「Static Factory Method」，但这样的设计严重违反了「OCP」(开放封闭)原则。
 *
 * @author wuzheng.yk
 * @date 2018/6/1
 */
package com.hz.yk.orthogonal.v3;
