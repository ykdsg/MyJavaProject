grammar Expr;

program: statement;
statement: expression NEWLINE*;
expression : multExpr (('+' | '-') multExpr)*  ;
multExpr : atom (('*' | '/') atom)* ;
atom:  '(' expression ')' | INT;
ID : ('a'..'z' |'A'..'Z')+ ;
INT : '0'..'9' + ;
NEWLINE:'\r'? '\n' ;
WS : (' ' |'\t' |'\n' |'\r' )+ -> skip;
