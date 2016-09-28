grammar Hello;               // 定义语法的名字

s  : 'hello' ID ;            // 匹配关键字hello，后面跟着一个标志符
ID : [a-z]+ ;                // 匹配小写字母标志符
WS : [ \t\r\n]+ -> skip ;    // 跳过空格、制表符、回车符和换行符