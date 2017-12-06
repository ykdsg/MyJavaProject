grammar Calc;

prog
    : stat+
    ;

//标签可以是和规则名没有冲突的任意标志符。如果选项上没有标签，ANTLR只会为每个规则生成一个visit方法。
//在本例中，我们希望为每个选项生成一个不同的visit方法，以便每种输入短语都能得到不同的事件。在新的语法中，标签出现在选项的右边缘，且以“#”符号开头：
stat
    : expr                   # printExpr
    | ID '=' expr            # assign
    ;

expr
    : expr op=(MUL|DIV) expr # MulDiv
    | expr op=(ADD|SUB) expr # AddSub
    | INT                    # int
    | ID                     # id
    | '(' expr ')'           # parens
    ;

ID  : [a-zA-Z]+ ;

INT : [0-9]+ ;

MUL : '*' ;

DIV : '/' ;

ADD : '+' ;

SUB : '-' ;

WS  : [ \t\r\n]+ -> skip ;    // toss out whitespace
