// Generated from /Users/ykdsg/my_workspace/MyJavaProject/antlr/src/main/resources/Java8.g4 by ANTLR 4.7
package com.yk.antlr.gen.java8;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Java8Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ABSTRACT=1, ASSERT=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CATCH=7, CHAR=8, 
		CLASS=9, CONST=10, CONTINUE=11, DEFAULT=12, DO=13, DOUBLE=14, ELSE=15, 
		ENUM=16, EXTENDS=17, FINAL=18, FINALLY=19, FLOAT=20, FOR=21, IF=22, GOTO=23, 
		IMPLEMENTS=24, IMPORT=25, INSTANCEOF=26, INT=27, INTERFACE=28, LONG=29, 
		NATIVE=30, NEW=31, PACKAGE=32, PRIVATE=33, PROTECTED=34, PUBLIC=35, RETURN=36, 
		SHORT=37, STATIC=38, STRICTFP=39, SUPER=40, SWITCH=41, SYNCHRONIZED=42, 
		THIS=43, THROW=44, THROWS=45, TRANSIENT=46, TRY=47, VOID=48, VOLATILE=49, 
		WHILE=50, IntegerLiteral=51, FloatingPointLiteral=52, BooleanLiteral=53, 
		CharacterLiteral=54, StringLiteral=55, NullLiteral=56, LPAREN=57, RPAREN=58, 
		LBRACE=59, RBRACE=60, LBRACK=61, RBRACK=62, SEMI=63, COMMA=64, DOT=65, 
		ASSIGN=66, GT=67, LT=68, BANG=69, TILDE=70, QUESTION=71, COLON=72, EQUAL=73, 
		LE=74, GE=75, NOTEQUAL=76, AND=77, OR=78, INC=79, DEC=80, ADD=81, SUB=82, 
		MUL=83, DIV=84, BITAND=85, BITOR=86, CARET=87, MOD=88, ARROW=89, COLONCOLON=90, 
		ADD_ASSIGN=91, SUB_ASSIGN=92, MUL_ASSIGN=93, DIV_ASSIGN=94, AND_ASSIGN=95, 
		OR_ASSIGN=96, XOR_ASSIGN=97, MOD_ASSIGN=98, LSHIFT_ASSIGN=99, RSHIFT_ASSIGN=100, 
		URSHIFT_ASSIGN=101, Identifier=102, AT=103, ELLIPSIS=104, WS=105, COMMENT=106, 
		LINE_COMMENT=107, NAME=108, NEWLINE=109, SPACE=110, TEXT_CONTENT=111, 
		JAVADOC_START=112, JAVADOC_END=113, INLINE_TAG_START=114;
	public static final int
		RULE_literal = 0, RULE_primitiveType = 1, RULE_numericType = 2, RULE_integralType = 3, 
		RULE_floatingPointType = 4, RULE_referenceType = 5, RULE_classOrInterfaceType = 6, 
		RULE_classType = 7, RULE_classType_lf_classOrInterfaceType = 8, RULE_classType_lfno_classOrInterfaceType = 9, 
		RULE_interfaceType = 10, RULE_interfaceType_lf_classOrInterfaceType = 11, 
		RULE_interfaceType_lfno_classOrInterfaceType = 12, RULE_typeVariable = 13, 
		RULE_arrayType = 14, RULE_dims = 15, RULE_typeParameter = 16, RULE_typeParameterModifier = 17, 
		RULE_typeBound = 18, RULE_additionalBound = 19, RULE_typeArguments = 20, 
		RULE_typeArgumentList = 21, RULE_typeArgument = 22, RULE_wildcard = 23, 
		RULE_wildcardBounds = 24, RULE_packageName = 25, RULE_typeName = 26, RULE_packageOrTypeName = 27, 
		RULE_expressionName = 28, RULE_methodName = 29, RULE_ambiguousName = 30, 
		RULE_compilationUnit = 31, RULE_packageDeclaration = 32, RULE_packageModifier = 33, 
		RULE_importDeclaration = 34, RULE_singleTypeImportDeclaration = 35, RULE_typeImportOnDemandDeclaration = 36, 
		RULE_singleStaticImportDeclaration = 37, RULE_staticImportOnDemandDeclaration = 38, 
		RULE_typeDeclaration = 39, RULE_classDeclaration = 40, RULE_normalClassDeclaration = 41, 
		RULE_classModifier = 42, RULE_typeParameters = 43, RULE_typeParameterList = 44, 
		RULE_superclass = 45, RULE_superinterfaces = 46, RULE_interfaceTypeList = 47, 
		RULE_classBody = 48, RULE_classBodyDeclaration = 49, RULE_classMemberDeclaration = 50, 
		RULE_fieldDeclaration = 51, RULE_fieldModifier = 52, RULE_variableDeclaratorList = 53, 
		RULE_variableDeclarator = 54, RULE_variableDeclaratorId = 55, RULE_variableInitializer = 56, 
		RULE_unannType = 57, RULE_unannPrimitiveType = 58, RULE_unannReferenceType = 59, 
		RULE_unannClassOrInterfaceType = 60, RULE_unannClassType = 61, RULE_unannClassType_lf_unannClassOrInterfaceType = 62, 
		RULE_unannClassType_lfno_unannClassOrInterfaceType = 63, RULE_unannInterfaceType = 64, 
		RULE_unannInterfaceType_lf_unannClassOrInterfaceType = 65, RULE_unannInterfaceType_lfno_unannClassOrInterfaceType = 66, 
		RULE_unannTypeVariable = 67, RULE_unannArrayType = 68, RULE_methodDeclaration = 69, 
		RULE_methodModifier = 70, RULE_methodHeader = 71, RULE_result = 72, RULE_methodDeclarator = 73, 
		RULE_formalParameterList = 74, RULE_formalParameters = 75, RULE_formalParameter = 76, 
		RULE_variableModifier = 77, RULE_lastFormalParameter = 78, RULE_receiverParameter = 79, 
		RULE_throws_ = 80, RULE_exceptionTypeList = 81, RULE_exceptionType = 82, 
		RULE_methodBody = 83, RULE_instanceInitializer = 84, RULE_staticInitializer = 85, 
		RULE_constructorDeclaration = 86, RULE_constructorModifier = 87, RULE_constructorDeclarator = 88, 
		RULE_simpleTypeName = 89, RULE_constructorBody = 90, RULE_explicitConstructorInvocation = 91, 
		RULE_enumDeclaration = 92, RULE_enumBody = 93, RULE_enumConstantList = 94, 
		RULE_enumConstant = 95, RULE_enumConstantModifier = 96, RULE_enumBodyDeclarations = 97, 
		RULE_interfaceDeclaration = 98, RULE_normalInterfaceDeclaration = 99, 
		RULE_interfaceModifier = 100, RULE_extendsInterfaces = 101, RULE_interfaceBody = 102, 
		RULE_interfaceMemberDeclaration = 103, RULE_constantDeclaration = 104, 
		RULE_constantModifier = 105, RULE_interfaceMethodDeclaration = 106, RULE_interfaceMethodModifier = 107, 
		RULE_annotationTypeDeclaration = 108, RULE_annotationTypeBody = 109, RULE_annotationTypeMemberDeclaration = 110, 
		RULE_annotationTypeElementDeclaration = 111, RULE_annotationTypeElementModifier = 112, 
		RULE_defaultValue = 113, RULE_annotation = 114, RULE_normalAnnotation = 115, 
		RULE_elementValuePairList = 116, RULE_elementValuePair = 117, RULE_elementValue = 118, 
		RULE_elementValueArrayInitializer = 119, RULE_elementValueList = 120, 
		RULE_markerAnnotation = 121, RULE_singleElementAnnotation = 122, RULE_arrayInitializer = 123, 
		RULE_variableInitializerList = 124, RULE_block = 125, RULE_blockStatements = 126, 
		RULE_blockStatement = 127, RULE_localVariableDeclarationStatement = 128, 
		RULE_localVariableDeclaration = 129, RULE_statement = 130, RULE_statementNoShortIf = 131, 
		RULE_statementWithoutTrailingSubstatement = 132, RULE_emptyStatement = 133, 
		RULE_labeledStatement = 134, RULE_labeledStatementNoShortIf = 135, RULE_expressionStatement = 136, 
		RULE_statementExpression = 137, RULE_ifThenStatement = 138, RULE_ifThenElseStatement = 139, 
		RULE_ifThenElseStatementNoShortIf = 140, RULE_assertStatement = 141, RULE_switchStatement = 142, 
		RULE_switchBlock = 143, RULE_switchBlockStatementGroup = 144, RULE_switchLabels = 145, 
		RULE_switchLabel = 146, RULE_enumConstantName = 147, RULE_whileStatement = 148, 
		RULE_whileStatementNoShortIf = 149, RULE_doStatement = 150, RULE_forStatement = 151, 
		RULE_forStatementNoShortIf = 152, RULE_basicForStatement = 153, RULE_basicForStatementNoShortIf = 154, 
		RULE_forInit = 155, RULE_forUpdate = 156, RULE_statementExpressionList = 157, 
		RULE_enhancedForStatement = 158, RULE_enhancedForStatementNoShortIf = 159, 
		RULE_breakStatement = 160, RULE_continueStatement = 161, RULE_returnStatement = 162, 
		RULE_throwStatement = 163, RULE_synchronizedStatement = 164, RULE_tryStatement = 165, 
		RULE_catches = 166, RULE_catchClause = 167, RULE_catchFormalParameter = 168, 
		RULE_catchType = 169, RULE_finally_ = 170, RULE_tryWithResourcesStatement = 171, 
		RULE_resourceSpecification = 172, RULE_resourceList = 173, RULE_resource = 174, 
		RULE_primary = 175, RULE_primaryNoNewArray = 176, RULE_primaryNoNewArray_lf_arrayAccess = 177, 
		RULE_primaryNoNewArray_lfno_arrayAccess = 178, RULE_primaryNoNewArray_lf_primary = 179, 
		RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary = 180, RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary = 181, 
		RULE_primaryNoNewArray_lfno_primary = 182, RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary = 183, 
		RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary = 184, 
		RULE_classInstanceCreationExpression = 185, RULE_classInstanceCreationExpression_lf_primary = 186, 
		RULE_classInstanceCreationExpression_lfno_primary = 187, RULE_typeArgumentsOrDiamond = 188, 
		RULE_fieldAccess = 189, RULE_fieldAccess_lf_primary = 190, RULE_fieldAccess_lfno_primary = 191, 
		RULE_arrayAccess = 192, RULE_arrayAccess_lf_primary = 193, RULE_arrayAccess_lfno_primary = 194, 
		RULE_methodInvocation = 195, RULE_methodInvocation_lf_primary = 196, RULE_methodInvocation_lfno_primary = 197, 
		RULE_argumentList = 198, RULE_methodReference = 199, RULE_methodReference_lf_primary = 200, 
		RULE_methodReference_lfno_primary = 201, RULE_arrayCreationExpression = 202, 
		RULE_dimExprs = 203, RULE_dimExpr = 204, RULE_constantExpression = 205, 
		RULE_expression = 206, RULE_lambdaExpression = 207, RULE_lambdaParameters = 208, 
		RULE_inferredFormalParameterList = 209, RULE_lambdaBody = 210, RULE_assignmentExpression = 211, 
		RULE_assignment = 212, RULE_leftHandSide = 213, RULE_assignmentOperator = 214, 
		RULE_conditionalExpression = 215, RULE_conditionalOrExpression = 216, 
		RULE_conditionalAndExpression = 217, RULE_inclusiveOrExpression = 218, 
		RULE_exclusiveOrExpression = 219, RULE_andExpression = 220, RULE_equalityExpression = 221, 
		RULE_relationalExpression = 222, RULE_shiftExpression = 223, RULE_additiveExpression = 224, 
		RULE_multiplicativeExpression = 225, RULE_unaryExpression = 226, RULE_preIncrementExpression = 227, 
		RULE_preDecrementExpression = 228, RULE_unaryExpressionNotPlusMinus = 229, 
		RULE_postfixExpression = 230, RULE_postIncrementExpression = 231, RULE_postIncrementExpression_lf_postfixExpression = 232, 
		RULE_postDecrementExpression = 233, RULE_postDecrementExpression_lf_postfixExpression = 234, 
		RULE_castExpression = 235, RULE_documentation = 236, RULE_documentationContent = 237, 
		RULE_skipWhitespace = 238, RULE_description = 239, RULE_descriptionLine = 240, 
		RULE_descriptionLineStart = 241, RULE_descriptionLineNoSpaceNoAt = 242, 
		RULE_descriptionLineElement = 243, RULE_descriptionLineText = 244, RULE_descriptionNewline = 245, 
		RULE_tagSection = 246, RULE_blockTag = 247, RULE_blockTagName = 248, RULE_blockTagContent = 249, 
		RULE_blockTagText = 250, RULE_blockTagTextElement = 251, RULE_inlineTag = 252, 
		RULE_inlineTagName = 253, RULE_inlineTagContent = 254, RULE_braceExpression = 255, 
		RULE_braceContent = 256, RULE_braceText = 257;
	public static final String[] ruleNames = {
		"literal", "primitiveType", "numericType", "integralType", "floatingPointType", 
		"referenceType", "classOrInterfaceType", "classType", "classType_lf_classOrInterfaceType", 
		"classType_lfno_classOrInterfaceType", "interfaceType", "interfaceType_lf_classOrInterfaceType", 
		"interfaceType_lfno_classOrInterfaceType", "typeVariable", "arrayType", 
		"dims", "typeParameter", "typeParameterModifier", "typeBound", "additionalBound", 
		"typeArguments", "typeArgumentList", "typeArgument", "wildcard", "wildcardBounds", 
		"packageName", "typeName", "packageOrTypeName", "expressionName", "methodName", 
		"ambiguousName", "compilationUnit", "packageDeclaration", "packageModifier", 
		"importDeclaration", "singleTypeImportDeclaration", "typeImportOnDemandDeclaration", 
		"singleStaticImportDeclaration", "staticImportOnDemandDeclaration", "typeDeclaration", 
		"classDeclaration", "normalClassDeclaration", "classModifier", "typeParameters", 
		"typeParameterList", "superclass", "superinterfaces", "interfaceTypeList", 
		"classBody", "classBodyDeclaration", "classMemberDeclaration", "fieldDeclaration", 
		"fieldModifier", "variableDeclaratorList", "variableDeclarator", "variableDeclaratorId", 
		"variableInitializer", "unannType", "unannPrimitiveType", "unannReferenceType", 
		"unannClassOrInterfaceType", "unannClassType", "unannClassType_lf_unannClassOrInterfaceType", 
		"unannClassType_lfno_unannClassOrInterfaceType", "unannInterfaceType", 
		"unannInterfaceType_lf_unannClassOrInterfaceType", "unannInterfaceType_lfno_unannClassOrInterfaceType", 
		"unannTypeVariable", "unannArrayType", "methodDeclaration", "methodModifier", 
		"methodHeader", "result", "methodDeclarator", "formalParameterList", "formalParameters", 
		"formalParameter", "variableModifier", "lastFormalParameter", "receiverParameter", 
		"throws_", "exceptionTypeList", "exceptionType", "methodBody", "instanceInitializer", 
		"staticInitializer", "constructorDeclaration", "constructorModifier", 
		"constructorDeclarator", "simpleTypeName", "constructorBody", "explicitConstructorInvocation", 
		"enumDeclaration", "enumBody", "enumConstantList", "enumConstant", "enumConstantModifier", 
		"enumBodyDeclarations", "interfaceDeclaration", "normalInterfaceDeclaration", 
		"interfaceModifier", "extendsInterfaces", "interfaceBody", "interfaceMemberDeclaration", 
		"constantDeclaration", "constantModifier", "interfaceMethodDeclaration", 
		"interfaceMethodModifier", "annotationTypeDeclaration", "annotationTypeBody", 
		"annotationTypeMemberDeclaration", "annotationTypeElementDeclaration", 
		"annotationTypeElementModifier", "defaultValue", "annotation", "normalAnnotation", 
		"elementValuePairList", "elementValuePair", "elementValue", "elementValueArrayInitializer", 
		"elementValueList", "markerAnnotation", "singleElementAnnotation", "arrayInitializer", 
		"variableInitializerList", "block", "blockStatements", "blockStatement", 
		"localVariableDeclarationStatement", "localVariableDeclaration", "statement", 
		"statementNoShortIf", "statementWithoutTrailingSubstatement", "emptyStatement", 
		"labeledStatement", "labeledStatementNoShortIf", "expressionStatement", 
		"statementExpression", "ifThenStatement", "ifThenElseStatement", "ifThenElseStatementNoShortIf", 
		"assertStatement", "switchStatement", "switchBlock", "switchBlockStatementGroup", 
		"switchLabels", "switchLabel", "enumConstantName", "whileStatement", "whileStatementNoShortIf", 
		"doStatement", "forStatement", "forStatementNoShortIf", "basicForStatement", 
		"basicForStatementNoShortIf", "forInit", "forUpdate", "statementExpressionList", 
		"enhancedForStatement", "enhancedForStatementNoShortIf", "breakStatement", 
		"continueStatement", "returnStatement", "throwStatement", "synchronizedStatement", 
		"tryStatement", "catches", "catchClause", "catchFormalParameter", "catchType", 
		"finally_", "tryWithResourcesStatement", "resourceSpecification", "resourceList", 
		"resource", "primary", "primaryNoNewArray", "primaryNoNewArray_lf_arrayAccess", 
		"primaryNoNewArray_lfno_arrayAccess", "primaryNoNewArray_lf_primary", 
		"primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary", "primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary", 
		"primaryNoNewArray_lfno_primary", "primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary", 
		"primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary", "classInstanceCreationExpression", 
		"classInstanceCreationExpression_lf_primary", "classInstanceCreationExpression_lfno_primary", 
		"typeArgumentsOrDiamond", "fieldAccess", "fieldAccess_lf_primary", "fieldAccess_lfno_primary", 
		"arrayAccess", "arrayAccess_lf_primary", "arrayAccess_lfno_primary", "methodInvocation", 
		"methodInvocation_lf_primary", "methodInvocation_lfno_primary", "argumentList", 
		"methodReference", "methodReference_lf_primary", "methodReference_lfno_primary", 
		"arrayCreationExpression", "dimExprs", "dimExpr", "constantExpression", 
		"expression", "lambdaExpression", "lambdaParameters", "inferredFormalParameterList", 
		"lambdaBody", "assignmentExpression", "assignment", "leftHandSide", "assignmentOperator", 
		"conditionalExpression", "conditionalOrExpression", "conditionalAndExpression", 
		"inclusiveOrExpression", "exclusiveOrExpression", "andExpression", "equalityExpression", 
		"relationalExpression", "shiftExpression", "additiveExpression", "multiplicativeExpression", 
		"unaryExpression", "preIncrementExpression", "preDecrementExpression", 
		"unaryExpressionNotPlusMinus", "postfixExpression", "postIncrementExpression", 
		"postIncrementExpression_lf_postfixExpression", "postDecrementExpression", 
		"postDecrementExpression_lf_postfixExpression", "castExpression", "documentation", 
		"documentationContent", "skipWhitespace", "description", "descriptionLine", 
		"descriptionLineStart", "descriptionLineNoSpaceNoAt", "descriptionLineElement", 
		"descriptionLineText", "descriptionNewline", "tagSection", "blockTag", 
		"blockTagName", "blockTagContent", "blockTagText", "blockTagTextElement", 
		"inlineTag", "inlineTagName", "inlineTagContent", "braceExpression", "braceContent", 
		"braceText"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
		"'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
		"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
		"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
		"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
		"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
		"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
		"'transient'", "'try'", "'void'", "'volatile'", "'while'", null, null, 
		null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
		"';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", 
		"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
		"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'->'", "'::'", "'+='", 
		"'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", 
		"'>>>='", null, "'@'", "'...'", null, null, null, null, null, null, null, 
		null, null, "'{@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", 
		"CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", 
		"ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", 
		"IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", "PACKAGE", 
		"PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", 
		"SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", 
		"TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
		"DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
		"DIV", "BITAND", "BITOR", "CARET", "MOD", "ARROW", "COLONCOLON", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
		"MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", 
		"AT", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT", "NAME", "NEWLINE", 
		"SPACE", "TEXT_CONTENT", "JAVADOC_START", "JAVADOC_END", "INLINE_TAG_START"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Java8.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Java8Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(Java8Parser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(Java8Parser.FloatingPointLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(Java8Parser.BooleanLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(Java8Parser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(Java8Parser.StringLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(Java8Parser.NullLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primitiveType);
		int _la;
		try {
			setState(532);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(518);
					annotation();
					}
					}
					setState(523);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(524);
				numericType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(525);
					annotation();
					}
					}
					setState(530);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(531);
				match(BOOLEAN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericTypeContext extends ParserRuleContext {
		public IntegralTypeContext integralType() {
			return getRuleContext(IntegralTypeContext.class,0);
		}
		public FloatingPointTypeContext floatingPointType() {
			return getRuleContext(FloatingPointTypeContext.class,0);
		}
		public NumericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterNumericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitNumericType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitNumericType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericTypeContext numericType() throws RecognitionException {
		NumericTypeContext _localctx = new NumericTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_numericType);
		try {
			setState(536);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
			case CHAR:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(534);
				integralType();
				}
				break;
			case DOUBLE:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				floatingPointType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegralTypeContext extends ParserRuleContext {
		public IntegralTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integralType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterIntegralType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitIntegralType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitIntegralType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegralTypeContext integralType() throws RecognitionException {
		IntegralTypeContext _localctx = new IntegralTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_integralType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYTE) | (1L << CHAR) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatingPointTypeContext extends ParserRuleContext {
		public FloatingPointTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingPointType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFloatingPointType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFloatingPointType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFloatingPointType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatingPointTypeContext floatingPointType() throws RecognitionException {
		FloatingPointTypeContext _localctx = new FloatingPointTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_floatingPointType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			_la = _input.LA(1);
			if ( !(_la==DOUBLE || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitReferenceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitReferenceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_referenceType);
		try {
			setState(545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(542);
				classOrInterfaceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(543);
				typeVariable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(544);
				arrayType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() {
			return getRuleContext(ClassType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lfno_classOrInterfaceTypeContext interfaceType_lfno_classOrInterfaceType() {
			return getRuleContext(InterfaceType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public List<ClassType_lf_classOrInterfaceTypeContext> classType_lf_classOrInterfaceType() {
			return getRuleContexts(ClassType_lf_classOrInterfaceTypeContext.class);
		}
		public ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType(int i) {
			return getRuleContext(ClassType_lf_classOrInterfaceTypeContext.class,i);
		}
		public List<InterfaceType_lf_classOrInterfaceTypeContext> interfaceType_lf_classOrInterfaceType() {
			return getRuleContexts(InterfaceType_lf_classOrInterfaceTypeContext.class);
		}
		public InterfaceType_lf_classOrInterfaceTypeContext interfaceType_lf_classOrInterfaceType(int i) {
			return getRuleContext(InterfaceType_lf_classOrInterfaceTypeContext.class,i);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(547);
				classType_lfno_classOrInterfaceType();
				}
				break;
			case 2:
				{
				setState(548);
				interfaceType_lfno_classOrInterfaceType();
				}
				break;
			}
			setState(555);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(553);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(551);
						classType_lf_classOrInterfaceType();
						}
						break;
					case 2:
						{
						setState(552);
						interfaceType_lf_classOrInterfaceType();
						}
						break;
					}
					} 
				}
				setState(557);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classType);
		int _la;
		try {
			setState(580);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(558);
					annotation();
					}
					}
					setState(563);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(564);
				match(Identifier);
				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(565);
					typeArguments();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(568);
				classOrInterfaceType();
				setState(569);
				match(DOT);
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(570);
					annotation();
					}
					}
					setState(575);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(576);
				match(Identifier);
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(577);
					typeArguments();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassType_lf_classOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassType_lf_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType_lf_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassType_lf_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassType_lf_classOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassType_lf_classOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType() throws RecognitionException {
		ClassType_lf_classOrInterfaceTypeContext _localctx = new ClassType_lf_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classType_lf_classOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			match(DOT);
			setState(586);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(583);
				annotation();
				}
				}
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(589);
			match(Identifier);
			setState(591);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(590);
				typeArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassType_lfno_classOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassType_lfno_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType_lfno_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassType_lfno_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassType_lfno_classOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassType_lfno_classOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() throws RecognitionException {
		ClassType_lfno_classOrInterfaceTypeContext _localctx = new ClassType_lfno_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classType_lfno_classOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(593);
				annotation();
				}
				}
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(599);
			match(Identifier);
			setState(601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(600);
				typeArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceTypeContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public InterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceTypeContext interfaceType() throws RecognitionException {
		InterfaceTypeContext _localctx = new InterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_interfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			classType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceType_lf_classOrInterfaceTypeContext extends ParserRuleContext {
		public ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType() {
			return getRuleContext(ClassType_lf_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lf_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType_lf_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceType_lf_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceType_lf_classOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceType_lf_classOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceType_lf_classOrInterfaceTypeContext interfaceType_lf_classOrInterfaceType() throws RecognitionException {
		InterfaceType_lf_classOrInterfaceTypeContext _localctx = new InterfaceType_lf_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_interfaceType_lf_classOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			classType_lf_classOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceType_lfno_classOrInterfaceTypeContext extends ParserRuleContext {
		public ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() {
			return getRuleContext(ClassType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lfno_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType_lfno_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceType_lfno_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceType_lfno_classOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceType_lfno_classOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceType_lfno_classOrInterfaceTypeContext interfaceType_lfno_classOrInterfaceType() throws RecognitionException {
		InterfaceType_lfno_classOrInterfaceTypeContext _localctx = new InterfaceType_lfno_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_interfaceType_lfno_classOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			classType_lfno_classOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeVariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeVariableContext typeVariable() throws RecognitionException {
		TypeVariableContext _localctx = new TypeVariableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(609);
				annotation();
				}
				}
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(615);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arrayType);
		try {
			setState(626);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(617);
				primitiveType();
				setState(618);
				dims();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(620);
				classOrInterfaceType();
				setState(621);
				dims();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(623);
				typeVariable();
				setState(624);
				dims();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimsContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public DimsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dims; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDims(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDims(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDims(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimsContext dims() throws RecognitionException {
		DimsContext _localctx = new DimsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dims);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(628);
				annotation();
				}
				}
				setState(633);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(634);
			match(LBRACK);
			setState(635);
			match(RBRACK);
			setState(646);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(639);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(636);
						annotation();
						}
						}
						setState(641);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(642);
					match(LBRACK);
					setState(643);
					match(RBRACK);
					}
					} 
				}
				setState(648);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<TypeParameterModifierContext> typeParameterModifier() {
			return getRuleContexts(TypeParameterModifierContext.class);
		}
		public TypeParameterModifierContext typeParameterModifier(int i) {
			return getRuleContext(TypeParameterModifierContext.class,i);
		}
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(649);
				typeParameterModifier();
				}
				}
				setState(654);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(655);
			match(Identifier);
			setState(657);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(656);
				typeBound();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TypeParameterModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeParameterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeParameterModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeParameterModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterModifierContext typeParameterModifier() throws RecognitionException {
		TypeParameterModifierContext _localctx = new TypeParameterModifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeParameterModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			annotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeBoundContext extends ParserRuleContext {
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeBound);
		int _la;
		try {
			setState(671);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(661);
				match(EXTENDS);
				setState(662);
				typeVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(663);
				match(EXTENDS);
				setState(664);
				classOrInterfaceType();
				setState(668);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(665);
					additionalBound();
					}
					}
					setState(670);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditionalBoundContext extends ParserRuleContext {
		public InterfaceTypeContext interfaceType() {
			return getRuleContext(InterfaceTypeContext.class,0);
		}
		public AdditionalBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionalBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAdditionalBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAdditionalBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAdditionalBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionalBoundContext additionalBound() throws RecognitionException {
		AdditionalBoundContext _localctx = new AdditionalBoundContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_additionalBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			match(BITAND);
			setState(674);
			interfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsContext extends ParserRuleContext {
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			match(LT);
			setState(677);
			typeArgumentList();
			setState(678);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentListContext extends ParserRuleContext {
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TypeArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentListContext typeArgumentList() throws RecognitionException {
		TypeArgumentListContext _localctx = new TypeArgumentListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			typeArgument();
			setState(685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(681);
				match(COMMA);
				setState(682);
				typeArgument();
				}
				}
				setState(687);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardContext wildcard() {
			return getRuleContext(WildcardContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeArgument);
		try {
			setState(690);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(688);
				referenceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(689);
				wildcard();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WildcardContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public WildcardBoundsContext wildcardBounds() {
			return getRuleContext(WildcardBoundsContext.class,0);
		}
		public WildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardContext wildcard() throws RecognitionException {
		WildcardContext _localctx = new WildcardContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_wildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(692);
				annotation();
				}
				}
				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(698);
			match(QUESTION);
			setState(700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==SUPER) {
				{
				setState(699);
				wildcardBounds();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WildcardBoundsContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardBoundsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardBounds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterWildcardBounds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitWildcardBounds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitWildcardBounds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardBoundsContext wildcardBounds() throws RecognitionException {
		WildcardBoundsContext _localctx = new WildcardBoundsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_wildcardBounds);
		try {
			setState(706);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(702);
				match(EXTENDS);
				setState(703);
				referenceType();
				}
				break;
			case SUPER:
				enterOuterAlt(_localctx, 2);
				{
				setState(704);
				match(SUPER);
				setState(705);
				referenceType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public PackageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPackageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPackageName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageNameContext packageName() throws RecognitionException {
		return packageName(0);
	}

	private PackageNameContext packageName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PackageNameContext _localctx = new PackageNameContext(_ctx, _parentState);
		PackageNameContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_packageName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(709);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(716);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PackageNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_packageName);
					setState(711);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(712);
					match(DOT);
					setState(713);
					match(Identifier);
					}
					} 
				}
				setState(718);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeName);
		try {
			setState(724);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(719);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(720);
				packageOrTypeName(0);
				setState(721);
				match(DOT);
				setState(722);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageOrTypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public PackageOrTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageOrTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPackageOrTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPackageOrTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPackageOrTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageOrTypeNameContext packageOrTypeName() throws RecognitionException {
		return packageOrTypeName(0);
	}

	private PackageOrTypeNameContext packageOrTypeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PackageOrTypeNameContext _localctx = new PackageOrTypeNameContext(_ctx, _parentState);
		PackageOrTypeNameContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_packageOrTypeName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(727);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(734);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PackageOrTypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_packageOrTypeName);
					setState(729);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(730);
					match(DOT);
					setState(731);
					match(Identifier);
					}
					} 
				}
				setState(736);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AmbiguousNameContext ambiguousName() {
			return getRuleContext(AmbiguousNameContext.class,0);
		}
		public ExpressionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExpressionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExpressionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExpressionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionNameContext expressionName() throws RecognitionException {
		ExpressionNameContext _localctx = new ExpressionNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expressionName);
		try {
			setState(742);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(737);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(738);
				ambiguousName(0);
				setState(739);
				match(DOT);
				setState(740);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AmbiguousNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AmbiguousNameContext ambiguousName() {
			return getRuleContext(AmbiguousNameContext.class,0);
		}
		public AmbiguousNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ambiguousName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAmbiguousName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAmbiguousName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAmbiguousName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AmbiguousNameContext ambiguousName() throws RecognitionException {
		return ambiguousName(0);
	}

	private AmbiguousNameContext ambiguousName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AmbiguousNameContext _localctx = new AmbiguousNameContext(_ctx, _parentState);
		AmbiguousNameContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_ambiguousName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(747);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(754);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AmbiguousNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ambiguousName);
					setState(749);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(750);
					match(DOT);
					setState(751);
					match(Identifier);
					}
					} 
				}
				setState(756);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Java8Parser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(757);
				packageDeclaration();
				}
				break;
			}
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(760);
				importDeclaration();
				}
				}
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << ENUM) | (1L << FINAL) | (1L << INTERFACE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP) | (1L << SEMI))) != 0) || _la==AT) {
				{
				{
				setState(766);
				typeDeclaration();
				}
				}
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(772);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ParserRuleContext {
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public List<PackageModifierContext> packageModifier() {
			return getRuleContexts(PackageModifierContext.class);
		}
		public PackageModifierContext packageModifier(int i) {
			return getRuleContext(PackageModifierContext.class,i);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPackageDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPackageDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_packageDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(774);
				packageModifier();
				}
				}
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(780);
			match(PACKAGE);
			setState(781);
			packageName(0);
			setState(782);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public PackageModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPackageModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPackageModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPackageModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageModifierContext packageModifier() throws RecognitionException {
		PackageModifierContext _localctx = new PackageModifierContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_packageModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			annotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public SingleTypeImportDeclarationContext singleTypeImportDeclaration() {
			return getRuleContext(SingleTypeImportDeclarationContext.class,0);
		}
		public TypeImportOnDemandDeclarationContext typeImportOnDemandDeclaration() {
			return getRuleContext(TypeImportOnDemandDeclarationContext.class,0);
		}
		public SingleStaticImportDeclarationContext singleStaticImportDeclaration() {
			return getRuleContext(SingleStaticImportDeclarationContext.class,0);
		}
		public StaticImportOnDemandDeclarationContext staticImportOnDemandDeclaration() {
			return getRuleContext(StaticImportOnDemandDeclarationContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_importDeclaration);
		try {
			setState(790);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(786);
				singleTypeImportDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(787);
				typeImportOnDemandDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(788);
				singleStaticImportDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(789);
				staticImportOnDemandDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTypeImportDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public SingleTypeImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTypeImportDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSingleTypeImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSingleTypeImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSingleTypeImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleTypeImportDeclarationContext singleTypeImportDeclaration() throws RecognitionException {
		SingleTypeImportDeclarationContext _localctx = new SingleTypeImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_singleTypeImportDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			match(IMPORT);
			setState(793);
			typeName();
			setState(794);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeImportOnDemandDeclarationContext extends ParserRuleContext {
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public TypeImportOnDemandDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeImportOnDemandDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeImportOnDemandDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeImportOnDemandDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeImportOnDemandDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeImportOnDemandDeclarationContext typeImportOnDemandDeclaration() throws RecognitionException {
		TypeImportOnDemandDeclarationContext _localctx = new TypeImportOnDemandDeclarationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_typeImportOnDemandDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			match(IMPORT);
			setState(797);
			packageOrTypeName(0);
			setState(798);
			match(DOT);
			setState(799);
			match(MUL);
			setState(800);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStaticImportDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public SingleStaticImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStaticImportDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSingleStaticImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSingleStaticImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSingleStaticImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStaticImportDeclarationContext singleStaticImportDeclaration() throws RecognitionException {
		SingleStaticImportDeclarationContext _localctx = new SingleStaticImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_singleStaticImportDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
			match(IMPORT);
			setState(803);
			match(STATIC);
			setState(804);
			typeName();
			setState(805);
			match(DOT);
			setState(806);
			match(Identifier);
			setState(807);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticImportOnDemandDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public StaticImportOnDemandDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticImportOnDemandDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStaticImportOnDemandDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStaticImportOnDemandDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStaticImportOnDemandDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaticImportOnDemandDeclarationContext staticImportOnDemandDeclaration() throws RecognitionException {
		StaticImportOnDemandDeclarationContext _localctx = new StaticImportOnDemandDeclarationContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_staticImportOnDemandDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			match(IMPORT);
			setState(810);
			match(STATIC);
			setState(811);
			typeName();
			setState(812);
			match(DOT);
			setState(813);
			match(MUL);
			setState(814);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_typeDeclaration);
		try {
			setState(819);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(816);
				classDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(817);
				interfaceDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(818);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public NormalClassDeclarationContext normalClassDeclaration() {
			return getRuleContext(NormalClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_classDeclaration);
		try {
			setState(823);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(821);
				normalClassDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(822);
				enumDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public SuperclassContext superclass() {
			return getRuleContext(SuperclassContext.class,0);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public NormalClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalClassDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterNormalClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitNormalClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitNormalClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalClassDeclarationContext normalClassDeclaration() throws RecognitionException {
		NormalClassDeclarationContext _localctx = new NormalClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_normalClassDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
				{
				{
				setState(825);
				classModifier();
				}
				}
				setState(830);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(831);
			match(CLASS);
			setState(832);
			match(Identifier);
			setState(834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(833);
				typeParameters();
				}
			}

			setState(837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(836);
				superclass();
				}
			}

			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(839);
				superinterfaces();
				}
			}

			setState(842);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ClassModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassModifierContext classModifier() throws RecognitionException {
		ClassModifierContext _localctx = new ClassModifierContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_classModifier);
		try {
			setState(852);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(844);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(845);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(846);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(847);
				match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(848);
				match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(849);
				match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(850);
				match(FINAL);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 8);
				{
				setState(851);
				match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParametersContext extends ParserRuleContext {
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_typeParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			match(LT);
			setState(855);
			typeParameterList();
			setState(856);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterListContext extends ParserRuleContext {
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			typeParameter();
			setState(863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(859);
				match(COMMA);
				setState(860);
				typeParameter();
				}
				}
				setState(865);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperclassContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public SuperclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSuperclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSuperclass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSuperclass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperclassContext superclass() throws RecognitionException {
		SuperclassContext _localctx = new SuperclassContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_superclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			match(EXTENDS);
			setState(867);
			classType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperinterfacesContext extends ParserRuleContext {
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public SuperinterfacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superinterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSuperinterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSuperinterfaces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSuperinterfaces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperinterfacesContext superinterfaces() throws RecognitionException {
		SuperinterfacesContext _localctx = new SuperinterfacesContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_superinterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
			match(IMPLEMENTS);
			setState(870);
			interfaceTypeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceTypeListContext extends ParserRuleContext {
		public List<InterfaceTypeContext> interfaceType() {
			return getRuleContexts(InterfaceTypeContext.class);
		}
		public InterfaceTypeContext interfaceType(int i) {
			return getRuleContext(InterfaceTypeContext.class,i);
		}
		public InterfaceTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceTypeListContext interfaceTypeList() throws RecognitionException {
		InterfaceTypeListContext _localctx = new InterfaceTypeListContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_interfaceTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			interfaceType();
			setState(877);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(873);
				match(COMMA);
				setState(874);
				interfaceType();
				}
				}
				setState(879);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_classBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(880);
			match(LBRACE);
			setState(884);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(881);
					classBodyDeclaration();
					}
					} 
				}
				setState(886);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			setState(887);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ClassMemberDeclarationContext classMemberDeclaration() {
			return getRuleContext(ClassMemberDeclarationContext.class,0);
		}
		public InstanceInitializerContext instanceInitializer() {
			return getRuleContext(InstanceInitializerContext.class,0);
		}
		public StaticInitializerContext staticInitializer() {
			return getRuleContext(StaticInitializerContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_classBodyDeclaration);
		try {
			setState(893);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				classMemberDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(890);
				instanceInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(891);
				staticInitializer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(892);
				constructorDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMemberDeclarationContext extends ParserRuleContext {
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public ClassMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberDeclarationContext classMemberDeclaration() throws RecognitionException {
		ClassMemberDeclarationContext _localctx = new ClassMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_classMemberDeclaration);
		try {
			setState(900);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(895);
				fieldDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(896);
				methodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(897);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(898);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(899);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public List<DocumentationContext> documentation() {
			return getRuleContexts(DocumentationContext.class);
		}
		public DocumentationContext documentation(int i) {
			return getRuleContext(DocumentationContext.class,i);
		}
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_fieldDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(902);
					documentation();
					}
					} 
				}
				setState(907);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			setState(911);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0) || _la==AT) {
				{
				{
				setState(908);
				fieldModifier();
				}
				}
				setState(913);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(914);
			unannType();
			setState(915);
			variableDeclaratorList();
			setState(916);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public FieldModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldModifierContext fieldModifier() throws RecognitionException {
		FieldModifierContext _localctx = new FieldModifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_fieldModifier);
		try {
			setState(926);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(918);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(919);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(920);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(921);
				match(PRIVATE);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(922);
				match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(923);
				match(FINAL);
				}
				break;
			case TRANSIENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(924);
				match(TRANSIENT);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(925);
				match(VOLATILE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorListContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public VariableDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorListContext variableDeclaratorList() throws RecognitionException {
		VariableDeclaratorListContext _localctx = new VariableDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_variableDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(928);
			variableDeclarator();
			setState(933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(929);
				match(COMMA);
				setState(930);
				variableDeclarator();
				}
				}
				setState(935);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			variableDeclaratorId();
			setState(939);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(937);
				match(ASSIGN);
				setState(938);
				variableInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			match(Identifier);
			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(942);
				dims();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_variableInitializer);
		try {
			setState(947);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(945);
				expression();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(946);
				arrayInitializer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannTypeContext extends ParserRuleContext {
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public UnannReferenceTypeContext unannReferenceType() {
			return getRuleContext(UnannReferenceTypeContext.class,0);
		}
		public UnannTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannTypeContext unannType() throws RecognitionException {
		UnannTypeContext _localctx = new UnannTypeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_unannType);
		try {
			setState(951);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(949);
				unannPrimitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(950);
				unannReferenceType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannPrimitiveTypeContext extends ParserRuleContext {
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public UnannPrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannPrimitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannPrimitiveTypeContext unannPrimitiveType() throws RecognitionException {
		UnannPrimitiveTypeContext _localctx = new UnannPrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_unannPrimitiveType);
		try {
			setState(955);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(953);
				numericType();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(954);
				match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannReferenceTypeContext extends ParserRuleContext {
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public UnannTypeVariableContext unannTypeVariable() {
			return getRuleContext(UnannTypeVariableContext.class,0);
		}
		public UnannArrayTypeContext unannArrayType() {
			return getRuleContext(UnannArrayTypeContext.class,0);
		}
		public UnannReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannReferenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannReferenceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannReferenceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannReferenceTypeContext unannReferenceType() throws RecognitionException {
		UnannReferenceTypeContext _localctx = new UnannReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_unannReferenceType);
		try {
			setState(960);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(957);
				unannClassOrInterfaceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(958);
				unannTypeVariable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(959);
				unannArrayType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext unannInterfaceType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public List<UnannClassType_lf_unannClassOrInterfaceTypeContext> unannClassType_lf_unannClassOrInterfaceType() {
			return getRuleContexts(UnannClassType_lf_unannClassOrInterfaceTypeContext.class);
		}
		public UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType(int i) {
			return getRuleContext(UnannClassType_lf_unannClassOrInterfaceTypeContext.class,i);
		}
		public List<UnannInterfaceType_lf_unannClassOrInterfaceTypeContext> unannInterfaceType_lf_unannClassOrInterfaceType() {
			return getRuleContexts(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext.class);
		}
		public UnannInterfaceType_lf_unannClassOrInterfaceTypeContext unannInterfaceType_lf_unannClassOrInterfaceType(int i) {
			return getRuleContext(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext.class,i);
		}
		public UnannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() throws RecognitionException {
		UnannClassOrInterfaceTypeContext _localctx = new UnannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_unannClassOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(964);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(962);
				unannClassType_lfno_unannClassOrInterfaceType();
				}
				break;
			case 2:
				{
				setState(963);
				unannInterfaceType_lfno_unannClassOrInterfaceType();
				}
				break;
			}
			setState(970);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(968);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
					case 1:
						{
						setState(966);
						unannClassType_lf_unannClassOrInterfaceType();
						}
						break;
					case 2:
						{
						setState(967);
						unannInterfaceType_lf_unannClassOrInterfaceType();
						}
						break;
					}
					} 
				}
				setState(972);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannClassTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public UnannClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannClassTypeContext unannClassType() throws RecognitionException {
		UnannClassTypeContext _localctx = new UnannClassTypeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_unannClassType);
		int _la;
		try {
			setState(989);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(973);
				match(Identifier);
				setState(975);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(974);
					typeArguments();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(977);
				unannClassOrInterfaceType();
				setState(978);
				match(DOT);
				setState(982);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(979);
					annotation();
					}
					}
					setState(984);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(985);
				match(Identifier);
				setState(987);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(986);
					typeArguments();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannClassType_lf_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassType_lf_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType_lf_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannClassType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannClassType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannClassType_lf_unannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() throws RecognitionException {
		UnannClassType_lf_unannClassOrInterfaceTypeContext _localctx = new UnannClassType_lf_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_unannClassType_lf_unannClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991);
			match(DOT);
			setState(995);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(992);
				annotation();
				}
				}
				setState(997);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(998);
			match(Identifier);
			setState(1000);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(999);
				typeArguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannClassType_lfno_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType_lfno_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannClassType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannClassType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannClassType_lfno_unannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() throws RecognitionException {
		UnannClassType_lfno_unannClassOrInterfaceTypeContext _localctx = new UnannClassType_lfno_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_unannClassType_lfno_unannClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1002);
			match(Identifier);
			setState(1004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1003);
				typeArguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannInterfaceTypeContext extends ParserRuleContext {
		public UnannClassTypeContext unannClassType() {
			return getRuleContext(UnannClassTypeContext.class,0);
		}
		public UnannInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannInterfaceTypeContext unannInterfaceType() throws RecognitionException {
		UnannInterfaceTypeContext _localctx = new UnannInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_unannInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			unannClassType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannInterfaceType_lf_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lf_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lf_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType_lf_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannInterfaceType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannInterfaceType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannInterfaceType_lf_unannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannInterfaceType_lf_unannClassOrInterfaceTypeContext unannInterfaceType_lf_unannClassOrInterfaceType() throws RecognitionException {
		UnannInterfaceType_lf_unannClassOrInterfaceTypeContext _localctx = new UnannInterfaceType_lf_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_unannInterfaceType_lf_unannClassOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1008);
			unannClassType_lf_unannClassOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType_lfno_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext unannInterfaceType_lfno_unannClassOrInterfaceType() throws RecognitionException {
		UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext _localctx = new UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_unannInterfaceType_lfno_unannClassOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1010);
			unannClassType_lfno_unannClassOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannTypeVariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public UnannTypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannTypeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannTypeVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannTypeVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannTypeVariableContext unannTypeVariable() throws RecognitionException {
		UnannTypeVariableContext _localctx = new UnannTypeVariableContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_unannTypeVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1012);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannArrayTypeContext extends ParserRuleContext {
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public UnannTypeVariableContext unannTypeVariable() {
			return getRuleContext(UnannTypeVariableContext.class,0);
		}
		public UnannArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannArrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannArrayTypeContext unannArrayType() throws RecognitionException {
		UnannArrayTypeContext _localctx = new UnannArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_unannArrayType);
		try {
			setState(1023);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1014);
				unannPrimitiveType();
				setState(1015);
				dims();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1017);
				unannClassOrInterfaceType();
				setState(1018);
				dims();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1020);
				unannTypeVariable();
				setState(1021);
				dims();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<DocumentationContext> documentation() {
			return getRuleContexts(DocumentationContext.class);
		}
		public DocumentationContext documentation(int i) {
			return getRuleContext(DocumentationContext.class,i);
		}
		public List<MethodModifierContext> methodModifier() {
			return getRuleContexts(MethodModifierContext.class);
		}
		public MethodModifierContext methodModifier(int i) {
			return getRuleContext(MethodModifierContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_methodDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1028);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1025);
					documentation();
					}
					} 
				}
				setState(1030);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			setState(1034);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED))) != 0) || _la==AT) {
				{
				{
				setState(1031);
				methodModifier();
				}
				}
				setState(1036);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1037);
			methodHeader();
			setState(1038);
			methodBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public MethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodModifierContext methodModifier() throws RecognitionException {
		MethodModifierContext _localctx = new MethodModifierContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_methodModifier);
		try {
			setState(1050);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1040);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1041);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(1042);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1043);
				match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1044);
				match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(1045);
				match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(1046);
				match(FINAL);
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 8);
				{
				setState(1047);
				match(SYNCHRONIZED);
				}
				break;
			case NATIVE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1048);
				match(NATIVE);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 10);
				{
				setState(1049);
				match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodHeaderContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public MethodDeclaratorContext methodDeclarator() {
			return getRuleContext(MethodDeclaratorContext.class,0);
		}
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_methodHeader);
		int _la;
		try {
			setState(1069);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1052);
				result();
				setState(1053);
				methodDeclarator();
				setState(1055);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(1054);
					throws_();
					}
				}

				}
				break;
			case LT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1057);
				typeParameters();
				setState(1061);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1058);
					annotation();
					}
					}
					setState(1063);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1064);
				result();
				setState(1065);
				methodDeclarator();
				setState(1067);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(1066);
					throws_();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_result);
		try {
			setState(1073);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1071);
				unannType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(1072);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public MethodDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclaratorContext methodDeclarator() throws RecognitionException {
		MethodDeclaratorContext _localctx = new MethodDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_methodDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1075);
			match(Identifier);
			setState(1076);
			match(LPAREN);
			setState(1078);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(1077);
				formalParameterList();
				}
			}

			setState(1080);
			match(RPAREN);
			setState(1082);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(1081);
				dims();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_formalParameterList);
		try {
			setState(1090);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1084);
				receiverParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1085);
				formalParameters();
				setState(1086);
				match(COMMA);
				setState(1087);
				lastFormalParameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1089);
				lastFormalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_formalParameters);
		try {
			int _alt;
			setState(1108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1092);
				formalParameter();
				setState(1097);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1093);
						match(COMMA);
						setState(1094);
						formalParameter();
						}
						} 
					}
					setState(1099);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1100);
				receiverParameter();
				setState(1105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1101);
						match(COMMA);
						setState(1102);
						formalParameter();
						}
						} 
					}
					setState(1107);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1110);
				variableModifier();
				}
				}
				setState(1115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1116);
			unannType();
			setState(1117);
			variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_variableModifier);
		try {
			setState(1121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1119);
				annotation();
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1120);
				match(FINAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LastFormalParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public FormalParameterContext formalParameter() {
			return getRuleContext(FormalParameterContext.class,0);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLastFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLastFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_lastFormalParameter);
		int _la;
		try {
			setState(1140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FINAL || _la==AT) {
					{
					{
					setState(1123);
					variableModifier();
					}
					}
					setState(1128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1129);
				unannType();
				setState(1133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1130);
					annotation();
					}
					}
					setState(1135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1136);
				match(ELLIPSIS);
				setState(1137);
				variableDeclaratorId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1139);
				formalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReceiverParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ReceiverParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiverParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterReceiverParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitReceiverParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitReceiverParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiverParameterContext receiverParameter() throws RecognitionException {
		ReceiverParameterContext _localctx = new ReceiverParameterContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_receiverParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1142);
				annotation();
				}
				}
				setState(1147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1148);
			unannType();
			setState(1151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1149);
				match(Identifier);
				setState(1150);
				match(DOT);
				}
			}

			setState(1153);
			match(THIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Throws_Context extends ParserRuleContext {
		public ExceptionTypeListContext exceptionTypeList() {
			return getRuleContext(ExceptionTypeListContext.class,0);
		}
		public Throws_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throws_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterThrows_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitThrows_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitThrows_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Throws_Context throws_() throws RecognitionException {
		Throws_Context _localctx = new Throws_Context(_ctx, getState());
		enterRule(_localctx, 160, RULE_throws_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1155);
			match(THROWS);
			setState(1156);
			exceptionTypeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionTypeListContext extends ParserRuleContext {
		public List<ExceptionTypeContext> exceptionType() {
			return getRuleContexts(ExceptionTypeContext.class);
		}
		public ExceptionTypeContext exceptionType(int i) {
			return getRuleContext(ExceptionTypeContext.class,i);
		}
		public ExceptionTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExceptionTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExceptionTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExceptionTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionTypeListContext exceptionTypeList() throws RecognitionException {
		ExceptionTypeListContext _localctx = new ExceptionTypeListContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_exceptionTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1158);
			exceptionType();
			setState(1163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1159);
				match(COMMA);
				setState(1160);
				exceptionType();
				}
				}
				setState(1165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionTypeContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ExceptionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExceptionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExceptionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExceptionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionTypeContext exceptionType() throws RecognitionException {
		ExceptionTypeContext _localctx = new ExceptionTypeContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_exceptionType);
		try {
			setState(1168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1166);
				classType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1167);
				typeVariable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_methodBody);
		try {
			setState(1172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1170);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(1171);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceInitializerContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InstanceInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInstanceInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInstanceInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInstanceInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceInitializerContext instanceInitializer() throws RecognitionException {
		InstanceInitializerContext _localctx = new InstanceInitializerContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_instanceInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1174);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticInitializerContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StaticInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStaticInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStaticInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStaticInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaticInitializerContext staticInitializer() throws RecognitionException {
		StaticInitializerContext _localctx = new StaticInitializerContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_staticInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1176);
			match(STATIC);
			setState(1177);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public ConstructorDeclaratorContext constructorDeclarator() {
			return getRuleContext(ConstructorDeclaratorContext.class,0);
		}
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public List<ConstructorModifierContext> constructorModifier() {
			return getRuleContexts(ConstructorModifierContext.class);
		}
		public ConstructorModifierContext constructorModifier(int i) {
			return getRuleContext(ConstructorModifierContext.class,i);
		}
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC))) != 0) || _la==AT) {
				{
				{
				setState(1179);
				constructorModifier();
				}
				}
				setState(1184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1185);
			constructorDeclarator();
			setState(1187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(1186);
				throws_();
				}
			}

			setState(1189);
			constructorBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ConstructorModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstructorModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstructorModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstructorModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorModifierContext constructorModifier() throws RecognitionException {
		ConstructorModifierContext _localctx = new ConstructorModifierContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_constructorModifier);
		try {
			setState(1195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1191);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1192);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(1193);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1194);
				match(PRIVATE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclaratorContext extends ParserRuleContext {
		public SimpleTypeNameContext simpleTypeName() {
			return getRuleContext(SimpleTypeNameContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ConstructorDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstructorDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstructorDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstructorDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclaratorContext constructorDeclarator() throws RecognitionException {
		ConstructorDeclaratorContext _localctx = new ConstructorDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_constructorDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1197);
				typeParameters();
				}
			}

			setState(1200);
			simpleTypeName();
			setState(1201);
			match(LPAREN);
			setState(1203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(1202);
				formalParameterList();
				}
			}

			setState(1205);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public SimpleTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSimpleTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSimpleTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSimpleTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeNameContext simpleTypeName() throws RecognitionException {
		SimpleTypeNameContext _localctx = new SimpleTypeNameContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_simpleTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1207);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorBodyContext extends ParserRuleContext {
		public ExplicitConstructorInvocationContext explicitConstructorInvocation() {
			return getRuleContext(ExplicitConstructorInvocationContext.class,0);
		}
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public ConstructorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstructorBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstructorBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstructorBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_constructorBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1209);
			match(LBRACE);
			setState(1211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(1210);
				explicitConstructorInvocation();
				}
				break;
			}
			setState(1214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1213);
				blockStatements();
				}
			}

			setState(1216);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitConstructorInvocationContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExplicitConstructorInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitConstructorInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExplicitConstructorInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExplicitConstructorInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExplicitConstructorInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitConstructorInvocationContext explicitConstructorInvocation() throws RecognitionException {
		ExplicitConstructorInvocationContext _localctx = new ExplicitConstructorInvocationContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_explicitConstructorInvocation);
		int _la;
		try {
			setState(1264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1218);
					typeArguments();
					}
				}

				setState(1221);
				match(THIS);
				setState(1222);
				match(LPAREN);
				setState(1224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1223);
					argumentList();
					}
				}

				setState(1226);
				match(RPAREN);
				setState(1227);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1228);
					typeArguments();
					}
				}

				setState(1231);
				match(SUPER);
				setState(1232);
				match(LPAREN);
				setState(1234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1233);
					argumentList();
					}
				}

				setState(1236);
				match(RPAREN);
				setState(1237);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1238);
				expressionName();
				setState(1239);
				match(DOT);
				setState(1241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1240);
					typeArguments();
					}
				}

				setState(1243);
				match(SUPER);
				setState(1244);
				match(LPAREN);
				setState(1246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1245);
					argumentList();
					}
				}

				setState(1248);
				match(RPAREN);
				setState(1249);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1251);
				primary();
				setState(1252);
				match(DOT);
				setState(1254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1253);
					typeArguments();
					}
				}

				setState(1256);
				match(SUPER);
				setState(1257);
				match(LPAREN);
				setState(1259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1258);
					argumentList();
					}
				}

				setState(1261);
				match(RPAREN);
				setState(1262);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
				{
				{
				setState(1266);
				classModifier();
				}
				}
				setState(1271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1272);
			match(ENUM);
			setState(1273);
			match(Identifier);
			setState(1275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(1274);
				superinterfaces();
				}
			}

			setState(1277);
			enumBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyContext extends ParserRuleContext {
		public EnumConstantListContext enumConstantList() {
			return getRuleContext(EnumConstantListContext.class,0);
		}
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1279);
			match(LBRACE);
			setState(1281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier || _la==AT) {
				{
				setState(1280);
				enumConstantList();
				}
			}

			setState(1284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1283);
				match(COMMA);
				}
			}

			setState(1287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1286);
				enumBodyDeclarations();
				}
			}

			setState(1289);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantListContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public EnumConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumConstantList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumConstantList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantListContext enumConstantList() throws RecognitionException {
		EnumConstantListContext _localctx = new EnumConstantListContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_enumConstantList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1291);
			enumConstant();
			setState(1296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1292);
					match(COMMA);
					setState(1293);
					enumConstant();
					}
					} 
				}
				setState(1298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<EnumConstantModifierContext> enumConstantModifier() {
			return getRuleContexts(EnumConstantModifierContext.class);
		}
		public EnumConstantModifierContext enumConstantModifier(int i) {
			return getRuleContext(EnumConstantModifierContext.class,i);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1299);
				enumConstantModifier();
				}
				}
				setState(1304);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1305);
			match(Identifier);
			setState(1311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(1306);
				match(LPAREN);
				setState(1308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(1307);
					argumentList();
					}
				}

				setState(1310);
				match(RPAREN);
				}
			}

			setState(1314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(1313);
				classBody();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public EnumConstantModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumConstantModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumConstantModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumConstantModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantModifierContext enumConstantModifier() throws RecognitionException {
		EnumConstantModifierContext _localctx = new EnumConstantModifierContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_enumConstantModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1316);
			annotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumBodyDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumBodyDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_enumBodyDeclarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1318);
			match(SEMI);
			setState(1322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1319);
					classBodyDeclaration();
					}
					} 
				}
				setState(1324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
			return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_interfaceDeclaration);
		try {
			setState(1327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1325);
				normalInterfaceDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1326);
				annotationTypeDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalInterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public List<InterfaceModifierContext> interfaceModifier() {
			return getRuleContexts(InterfaceModifierContext.class);
		}
		public InterfaceModifierContext interfaceModifier(int i) {
			return getRuleContext(InterfaceModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ExtendsInterfacesContext extendsInterfaces() {
			return getRuleContext(ExtendsInterfacesContext.class,0);
		}
		public NormalInterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalInterfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterNormalInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitNormalInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitNormalInterfaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalInterfaceDeclarationContext normalInterfaceDeclaration() throws RecognitionException {
		NormalInterfaceDeclarationContext _localctx = new NormalInterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_normalInterfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
				{
				{
				setState(1329);
				interfaceModifier();
				}
				}
				setState(1334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1335);
			match(INTERFACE);
			setState(1336);
			match(Identifier);
			setState(1338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1337);
				typeParameters();
				}
			}

			setState(1341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(1340);
				extendsInterfaces();
				}
			}

			setState(1343);
			interfaceBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public InterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceModifierContext interfaceModifier() throws RecognitionException {
		InterfaceModifierContext _localctx = new InterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_interfaceModifier);
		try {
			setState(1352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1345);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1346);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(1347);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1348);
				match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1349);
				match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(1350);
				match(STATIC);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 7);
				{
				setState(1351);
				match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtendsInterfacesContext extends ParserRuleContext {
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public ExtendsInterfacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsInterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExtendsInterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExtendsInterfaces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExtendsInterfaces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendsInterfacesContext extendsInterfaces() throws RecognitionException {
		ExtendsInterfacesContext _localctx = new ExtendsInterfacesContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_extendsInterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1354);
			match(EXTENDS);
			setState(1355);
			interfaceTypeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyContext extends ParserRuleContext {
		public List<InterfaceMemberDeclarationContext> interfaceMemberDeclaration() {
			return getRuleContexts(InterfaceMemberDeclarationContext.class);
		}
		public InterfaceMemberDeclarationContext interfaceMemberDeclaration(int i) {
			return getRuleContext(InterfaceMemberDeclarationContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_interfaceBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1357);
			match(LBRACE);
			setState(1361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1358);
					interfaceMemberDeclaration();
					}
					} 
				}
				setState(1363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			setState(1364);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMemberDeclarationContext extends ParserRuleContext {
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public InterfaceMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMemberDeclarationContext interfaceMemberDeclaration() throws RecognitionException {
		InterfaceMemberDeclarationContext _localctx = new InterfaceMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_interfaceMemberDeclaration);
		try {
			setState(1371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1366);
				constantDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1367);
				interfaceMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1368);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1369);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1370);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public List<ConstantModifierContext> constantModifier() {
			return getRuleContexts(ConstantModifierContext.class);
		}
		public ConstantModifierContext constantModifier(int i) {
			return getRuleContext(ConstantModifierContext.class,i);
		}
		public ConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstantDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstantDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstantDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDeclarationContext constantDeclaration() throws RecognitionException {
		ConstantDeclarationContext _localctx = new ConstantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_constantDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PUBLIC) | (1L << STATIC))) != 0) || _la==AT) {
				{
				{
				setState(1373);
				constantModifier();
				}
				}
				setState(1378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1379);
			unannType();
			setState(1380);
			variableDeclaratorList();
			setState(1381);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ConstantModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstantModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstantModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstantModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantModifierContext constantModifier() throws RecognitionException {
		ConstantModifierContext _localctx = new ConstantModifierContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_constantModifier);
		try {
			setState(1387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1383);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1384);
				match(PUBLIC);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(1385);
				match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1386);
				match(FINAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<DocumentationContext> documentation() {
			return getRuleContexts(DocumentationContext.class);
		}
		public DocumentationContext documentation(int i) {
			return getRuleContext(DocumentationContext.class,i);
		}
		public List<InterfaceMethodModifierContext> interfaceMethodModifier() {
			return getRuleContexts(InterfaceMethodModifierContext.class);
		}
		public InterfaceMethodModifierContext interfaceMethodModifier(int i) {
			return getRuleContext(InterfaceMethodModifierContext.class,i);
		}
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1392);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1389);
					documentation();
					}
					} 
				}
				setState(1394);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			}
			setState(1398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << DEFAULT) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
				{
				{
				setState(1395);
				interfaceMethodModifier();
				}
				}
				setState(1400);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1401);
			methodHeader();
			setState(1402);
			methodBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public InterfaceMethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceMethodModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceMethodModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMethodModifierContext interfaceMethodModifier() throws RecognitionException {
		InterfaceMethodModifierContext _localctx = new InterfaceMethodModifierContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_interfaceMethodModifier);
		try {
			setState(1410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1404);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1405);
				match(PUBLIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1406);
				match(ABSTRACT);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1407);
				match(DEFAULT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(1408);
				match(STATIC);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 6);
				{
				setState(1409);
				match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public List<InterfaceModifierContext> interfaceModifier() {
			return getRuleContexts(InterfaceModifierContext.class);
		}
		public InterfaceModifierContext interfaceModifier(int i) {
			return getRuleContext(InterfaceModifierContext.class,i);
		}
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_annotationTypeDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1412);
					interfaceModifier();
					}
					} 
				}
				setState(1417);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			}
			setState(1418);
			match(AT);
			setState(1419);
			match(INTERFACE);
			setState(1420);
			match(Identifier);
			setState(1421);
			annotationTypeBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public List<AnnotationTypeMemberDeclarationContext> annotationTypeMemberDeclaration() {
			return getRuleContexts(AnnotationTypeMemberDeclarationContext.class);
		}
		public AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration(int i) {
			return getRuleContext(AnnotationTypeMemberDeclarationContext.class,i);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1423);
			match(LBRACE);
			setState(1427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SEMI))) != 0) || _la==Identifier || _la==AT) {
				{
				{
				setState(1424);
				annotationTypeMemberDeclaration();
				}
				}
				setState(1429);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1430);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeMemberDeclarationContext extends ParserRuleContext {
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,0);
		}
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration() throws RecognitionException {
		AnnotationTypeMemberDeclarationContext _localctx = new AnnotationTypeMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_annotationTypeMemberDeclaration);
		try {
			setState(1437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1432);
				annotationTypeElementDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1433);
				constantDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1434);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1435);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1436);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationTypeElementModifierContext> annotationTypeElementModifier() {
			return getRuleContexts(AnnotationTypeElementModifierContext.class);
		}
		public AnnotationTypeElementModifierContext annotationTypeElementModifier(int i) {
			return getRuleContext(AnnotationTypeElementModifierContext.class,i);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeElementDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeElementDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_annotationTypeElementDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ABSTRACT || _la==PUBLIC || _la==AT) {
				{
				{
				setState(1439);
				annotationTypeElementModifier();
				}
				}
				setState(1444);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1445);
			unannType();
			setState(1446);
			match(Identifier);
			setState(1447);
			match(LPAREN);
			setState(1448);
			match(RPAREN);
			setState(1450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(1449);
				dims();
				}
			}

			setState(1453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(1452);
				defaultValue();
				}
			}

			setState(1455);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public AnnotationTypeElementModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeElementModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeElementModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeElementModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeElementModifierContext annotationTypeElementModifier() throws RecognitionException {
		AnnotationTypeElementModifierContext _localctx = new AnnotationTypeElementModifierContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_annotationTypeElementModifier);
		try {
			setState(1460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1457);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1458);
				match(PUBLIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1459);
				match(ABSTRACT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultValueContext extends ParserRuleContext {
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1462);
			match(DEFAULT);
			setState(1463);
			elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext {
		public NormalAnnotationContext normalAnnotation() {
			return getRuleContext(NormalAnnotationContext.class,0);
		}
		public MarkerAnnotationContext markerAnnotation() {
			return getRuleContext(MarkerAnnotationContext.class,0);
		}
		public SingleElementAnnotationContext singleElementAnnotation() {
			return getRuleContext(SingleElementAnnotationContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_annotation);
		try {
			setState(1468);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1465);
				normalAnnotation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1466);
				markerAnnotation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1467);
				singleElementAnnotation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalAnnotationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ElementValuePairListContext elementValuePairList() {
			return getRuleContext(ElementValuePairListContext.class,0);
		}
		public NormalAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterNormalAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitNormalAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitNormalAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalAnnotationContext normalAnnotation() throws RecognitionException {
		NormalAnnotationContext _localctx = new NormalAnnotationContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_normalAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1470);
			match(AT);
			setState(1471);
			typeName();
			setState(1472);
			match(LPAREN);
			setState(1474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1473);
				elementValuePairList();
				}
			}

			setState(1476);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairListContext extends ParserRuleContext {
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public ElementValuePairListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValuePairList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValuePairList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValuePairList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValuePairListContext elementValuePairList() throws RecognitionException {
		ElementValuePairListContext _localctx = new ElementValuePairListContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_elementValuePairList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478);
			elementValuePair();
			setState(1483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1479);
				match(COMMA);
				setState(1480);
				elementValuePair();
				}
				}
				setState(1485);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1486);
			match(Identifier);
			setState(1487);
			match(ASSIGN);
			setState(1488);
			elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_elementValue);
		try {
			setState(1493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1490);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1491);
				elementValueArrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1492);
				annotation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public ElementValueListContext elementValueList() {
			return getRuleContext(ElementValueListContext.class,0);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValueArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValueArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_elementValueArrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1495);
			match(LBRACE);
			setState(1497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1496);
				elementValueList();
				}
			}

			setState(1500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1499);
				match(COMMA);
				}
			}

			setState(1502);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueListContext extends ParserRuleContext {
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public ElementValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueListContext elementValueList() throws RecognitionException {
		ElementValueListContext _localctx = new ElementValueListContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_elementValueList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1504);
			elementValue();
			setState(1509);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1505);
					match(COMMA);
					setState(1506);
					elementValue();
					}
					} 
				}
				setState(1511);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MarkerAnnotationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public MarkerAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markerAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMarkerAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMarkerAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMarkerAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkerAnnotationContext markerAnnotation() throws RecognitionException {
		MarkerAnnotationContext _localctx = new MarkerAnnotationContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_markerAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1512);
			match(AT);
			setState(1513);
			typeName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleElementAnnotationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public SingleElementAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleElementAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSingleElementAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSingleElementAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSingleElementAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleElementAnnotationContext singleElementAnnotation() throws RecognitionException {
		SingleElementAnnotationContext _localctx = new SingleElementAnnotationContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_singleElementAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1515);
			match(AT);
			setState(1516);
			typeName();
			setState(1517);
			match(LPAREN);
			setState(1518);
			elementValue();
			setState(1519);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public VariableInitializerListContext variableInitializerList() {
			return getRuleContext(VariableInitializerListContext.class,0);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1521);
			match(LBRACE);
			setState(1523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1522);
				variableInitializerList();
				}
			}

			setState(1526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1525);
				match(COMMA);
				}
			}

			setState(1528);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerListContext extends ParserRuleContext {
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public VariableInitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerListContext variableInitializerList() throws RecognitionException {
		VariableInitializerListContext _localctx = new VariableInitializerListContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_variableInitializerList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1530);
			variableInitializer();
			setState(1535);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1531);
					match(COMMA);
					setState(1532);
					variableInitializer();
					}
					} 
				}
				setState(1537);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1538);
			match(LBRACE);
			setState(1540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1539);
				blockStatements();
				}
			}

			setState(1542);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementsContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementsContext blockStatements() throws RecognitionException {
		BlockStatementsContext _localctx = new BlockStatementsContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_blockStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1545); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1544);
				blockStatement();
				}
				}
				setState(1547); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_blockStatement);
		try {
			setState(1552);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1549);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1550);
				classDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1551);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1554);
			localVariableDeclaration();
			setState(1555);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1557);
				variableModifier();
				}
				}
				setState(1562);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1563);
			unannType();
			setState(1564);
			variableDeclaratorList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() {
			return getRuleContext(StatementWithoutTrailingSubstatementContext.class,0);
		}
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public IfThenStatementContext ifThenStatement() {
			return getRuleContext(IfThenStatementContext.class,0);
		}
		public IfThenElseStatementContext ifThenElseStatement() {
			return getRuleContext(IfThenElseStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_statement);
		try {
			setState(1572);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1566);
				statementWithoutTrailingSubstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1567);
				labeledStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1568);
				ifThenStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1569);
				ifThenElseStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1570);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1571);
				forStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementNoShortIfContext extends ParserRuleContext {
		public StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() {
			return getRuleContext(StatementWithoutTrailingSubstatementContext.class,0);
		}
		public LabeledStatementNoShortIfContext labeledStatementNoShortIf() {
			return getRuleContext(LabeledStatementNoShortIfContext.class,0);
		}
		public IfThenElseStatementNoShortIfContext ifThenElseStatementNoShortIf() {
			return getRuleContext(IfThenElseStatementNoShortIfContext.class,0);
		}
		public WhileStatementNoShortIfContext whileStatementNoShortIf() {
			return getRuleContext(WhileStatementNoShortIfContext.class,0);
		}
		public ForStatementNoShortIfContext forStatementNoShortIf() {
			return getRuleContext(ForStatementNoShortIfContext.class,0);
		}
		public StatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementNoShortIfContext statementNoShortIf() throws RecognitionException {
		StatementNoShortIfContext _localctx = new StatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_statementNoShortIf);
		try {
			setState(1579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1574);
				statementWithoutTrailingSubstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1575);
				labeledStatementNoShortIf();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1576);
				ifThenElseStatementNoShortIf();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1577);
				whileStatementNoShortIf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1578);
				forStatementNoShortIf();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementWithoutTrailingSubstatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public AssertStatementContext assertStatement() {
			return getRuleContext(AssertStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public DoStatementContext doStatement() {
			return getRuleContext(DoStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public SynchronizedStatementContext synchronizedStatement() {
			return getRuleContext(SynchronizedStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public StatementWithoutTrailingSubstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWithoutTrailingSubstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatementWithoutTrailingSubstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatementWithoutTrailingSubstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatementWithoutTrailingSubstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() throws RecognitionException {
		StatementWithoutTrailingSubstatementContext _localctx = new StatementWithoutTrailingSubstatementContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_statementWithoutTrailingSubstatement);
		try {
			setState(1593);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1581);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(1582);
				emptyStatement();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case INC:
			case DEC:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1583);
				expressionStatement();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1584);
				assertStatement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 5);
				{
				setState(1585);
				switchStatement();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 6);
				{
				setState(1586);
				doStatement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 7);
				{
				setState(1587);
				breakStatement();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(1588);
				continueStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(1589);
				returnStatement();
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 10);
				{
				setState(1590);
				synchronizedStatement();
				}
				break;
			case THROW:
				enterOuterAlt(_localctx, 11);
				{
				setState(1591);
				throwStatement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 12);
				{
				setState(1592);
				tryStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1595);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLabeledStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLabeledStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_labeledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1597);
			match(Identifier);
			setState(1598);
			match(COLON);
			setState(1599);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public LabeledStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLabeledStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLabeledStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLabeledStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabeledStatementNoShortIfContext labeledStatementNoShortIf() throws RecognitionException {
		LabeledStatementNoShortIfContext _localctx = new LabeledStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_labeledStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1601);
			match(Identifier);
			setState(1602);
			match(COLON);
			setState(1603);
			statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1605);
			statementExpression();
			setState(1606);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PreIncrementExpressionContext preIncrementExpression() {
			return getRuleContext(PreIncrementExpressionContext.class,0);
		}
		public PreDecrementExpressionContext preDecrementExpression() {
			return getRuleContext(PreDecrementExpressionContext.class,0);
		}
		public PostIncrementExpressionContext postIncrementExpression() {
			return getRuleContext(PostIncrementExpressionContext.class,0);
		}
		public PostDecrementExpressionContext postDecrementExpression() {
			return getRuleContext(PostDecrementExpressionContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_statementExpression);
		try {
			setState(1615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1608);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1609);
				preIncrementExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1610);
				preDecrementExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1611);
				postIncrementExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1612);
				postDecrementExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1613);
				methodInvocation();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1614);
				classInstanceCreationExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfThenStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterIfThenStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitIfThenStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitIfThenStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenStatementContext ifThenStatement() throws RecognitionException {
		IfThenStatementContext _localctx = new IfThenStatementContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_ifThenStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1617);
			match(IF);
			setState(1618);
			match(LPAREN);
			setState(1619);
			expression();
			setState(1620);
			match(RPAREN);
			setState(1621);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenElseStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfThenElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterIfThenElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitIfThenElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitIfThenElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenElseStatementContext ifThenElseStatement() throws RecognitionException {
		IfThenElseStatementContext _localctx = new IfThenElseStatementContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_ifThenElseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1623);
			match(IF);
			setState(1624);
			match(LPAREN);
			setState(1625);
			expression();
			setState(1626);
			match(RPAREN);
			setState(1627);
			statementNoShortIf();
			setState(1628);
			match(ELSE);
			setState(1629);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenElseStatementNoShortIfContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementNoShortIfContext> statementNoShortIf() {
			return getRuleContexts(StatementNoShortIfContext.class);
		}
		public StatementNoShortIfContext statementNoShortIf(int i) {
			return getRuleContext(StatementNoShortIfContext.class,i);
		}
		public IfThenElseStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElseStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterIfThenElseStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitIfThenElseStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitIfThenElseStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenElseStatementNoShortIfContext ifThenElseStatementNoShortIf() throws RecognitionException {
		IfThenElseStatementNoShortIfContext _localctx = new IfThenElseStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_ifThenElseStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1631);
			match(IF);
			setState(1632);
			match(LPAREN);
			setState(1633);
			expression();
			setState(1634);
			match(RPAREN);
			setState(1635);
			statementNoShortIf();
			setState(1636);
			match(ELSE);
			setState(1637);
			statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssertStatementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAssertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAssertStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAssertStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertStatementContext assertStatement() throws RecognitionException {
		AssertStatementContext _localctx = new AssertStatementContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_assertStatement);
		try {
			setState(1649);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1639);
				match(ASSERT);
				setState(1640);
				expression();
				setState(1641);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1643);
				match(ASSERT);
				setState(1644);
				expression();
				setState(1645);
				match(COLON);
				setState(1646);
				expression();
				setState(1647);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SwitchBlockContext switchBlock() {
			return getRuleContext(SwitchBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1651);
			match(SWITCH);
			setState(1652);
			match(LPAREN);
			setState(1653);
			expression();
			setState(1654);
			match(RPAREN);
			setState(1655);
			switchBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockContext extends ParserRuleContext {
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_switchBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1657);
			match(LBRACE);
			setState(1661);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1658);
					switchBlockStatementGroup();
					}
					} 
				}
				setState(1663);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			setState(1667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1664);
				switchLabel();
				}
				}
				setState(1669);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1670);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public SwitchLabelsContext switchLabels() {
			return getRuleContext(SwitchLabelsContext.class,0);
		}
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchBlockStatementGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchBlockStatementGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_switchBlockStatementGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1672);
			switchLabels();
			setState(1673);
			blockStatements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelsContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchLabelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchLabels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchLabels(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchLabels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelsContext switchLabels() throws RecognitionException {
		SwitchLabelsContext _localctx = new SwitchLabelsContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_switchLabels);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1675);
			switchLabel();
			setState(1679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1676);
				switchLabel();
				}
				}
				setState(1681);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext {
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumConstantNameContext enumConstantName() {
			return getRuleContext(EnumConstantNameContext.class,0);
		}
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_switchLabel);
		try {
			setState(1692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1682);
				match(CASE);
				setState(1683);
				constantExpression();
				setState(1684);
				match(COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1686);
				match(CASE);
				setState(1687);
				enumConstantName();
				setState(1688);
				match(COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1690);
				match(DEFAULT);
				setState(1691);
				match(COLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public EnumConstantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumConstantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumConstantName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumConstantName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantNameContext enumConstantName() throws RecognitionException {
		EnumConstantNameContext _localctx = new EnumConstantNameContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_enumConstantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1694);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1696);
			match(WHILE);
			setState(1697);
			match(LPAREN);
			setState(1698);
			expression();
			setState(1699);
			match(RPAREN);
			setState(1700);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementNoShortIfContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public WhileStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterWhileStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitWhileStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitWhileStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementNoShortIfContext whileStatementNoShortIf() throws RecognitionException {
		WhileStatementNoShortIfContext _localctx = new WhileStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_whileStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1702);
			match(WHILE);
			setState(1703);
			match(LPAREN);
			setState(1704);
			expression();
			setState(1705);
			match(RPAREN);
			setState(1706);
			statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoStatementContext doStatement() throws RecognitionException {
		DoStatementContext _localctx = new DoStatementContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_doStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1708);
			match(DO);
			setState(1709);
			statement();
			setState(1710);
			match(WHILE);
			setState(1711);
			match(LPAREN);
			setState(1712);
			expression();
			setState(1713);
			match(RPAREN);
			setState(1714);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public BasicForStatementContext basicForStatement() {
			return getRuleContext(BasicForStatementContext.class,0);
		}
		public EnhancedForStatementContext enhancedForStatement() {
			return getRuleContext(EnhancedForStatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_forStatement);
		try {
			setState(1718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1716);
				basicForStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1717);
				enhancedForStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementNoShortIfContext extends ParserRuleContext {
		public BasicForStatementNoShortIfContext basicForStatementNoShortIf() {
			return getRuleContext(BasicForStatementNoShortIfContext.class,0);
		}
		public EnhancedForStatementNoShortIfContext enhancedForStatementNoShortIf() {
			return getRuleContext(EnhancedForStatementNoShortIfContext.class,0);
		}
		public ForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitForStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitForStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementNoShortIfContext forStatementNoShortIf() throws RecognitionException {
		ForStatementNoShortIfContext _localctx = new ForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_forStatementNoShortIf);
		try {
			setState(1722);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1720);
				basicForStatementNoShortIf();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1721);
				enhancedForStatementNoShortIf();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicForStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public BasicForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBasicForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBasicForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBasicForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicForStatementContext basicForStatement() throws RecognitionException {
		BasicForStatementContext _localctx = new BasicForStatementContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_basicForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1724);
			match(FOR);
			setState(1725);
			match(LPAREN);
			setState(1727);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1726);
				forInit();
				}
			}

			setState(1729);
			match(SEMI);
			setState(1731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1730);
				expression();
				}
			}

			setState(1733);
			match(SEMI);
			setState(1735);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1734);
				forUpdate();
				}
			}

			setState(1737);
			match(RPAREN);
			setState(1738);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicForStatementNoShortIfContext extends ParserRuleContext {
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public BasicForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicForStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBasicForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBasicForStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBasicForStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicForStatementNoShortIfContext basicForStatementNoShortIf() throws RecognitionException {
		BasicForStatementNoShortIfContext _localctx = new BasicForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_basicForStatementNoShortIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1740);
			match(FOR);
			setState(1741);
			match(LPAREN);
			setState(1743);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1742);
				forInit();
				}
			}

			setState(1745);
			match(SEMI);
			setState(1747);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1746);
				expression();
				}
			}

			setState(1749);
			match(SEMI);
			setState(1751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (Identifier - 79)) | (1L << (AT - 79)))) != 0)) {
				{
				setState(1750);
				forUpdate();
				}
			}

			setState(1753);
			match(RPAREN);
			setState(1754);
			statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public StatementExpressionListContext statementExpressionList() {
			return getRuleContext(StatementExpressionListContext.class,0);
		}
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_forInit);
		try {
			setState(1758);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1756);
				statementExpressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1757);
				localVariableDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForUpdateContext extends ParserRuleContext {
		public StatementExpressionListContext statementExpressionList() {
			return getRuleContext(StatementExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1760);
			statementExpressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionListContext extends ParserRuleContext {
		public List<StatementExpressionContext> statementExpression() {
			return getRuleContexts(StatementExpressionContext.class);
		}
		public StatementExpressionContext statementExpression(int i) {
			return getRuleContext(StatementExpressionContext.class,i);
		}
		public StatementExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatementExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatementExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatementExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionListContext statementExpressionList() throws RecognitionException {
		StatementExpressionListContext _localctx = new StatementExpressionListContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_statementExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1762);
			statementExpression();
			setState(1767);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1763);
				match(COMMA);
				setState(1764);
				statementExpression();
				}
				}
				setState(1769);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForStatementContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public EnhancedForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnhancedForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnhancedForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnhancedForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnhancedForStatementContext enhancedForStatement() throws RecognitionException {
		EnhancedForStatementContext _localctx = new EnhancedForStatementContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_enhancedForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1770);
			match(FOR);
			setState(1771);
			match(LPAREN);
			setState(1775);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1772);
				variableModifier();
				}
				}
				setState(1777);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1778);
			unannType();
			setState(1779);
			variableDeclaratorId();
			setState(1780);
			match(COLON);
			setState(1781);
			expression();
			setState(1782);
			match(RPAREN);
			setState(1783);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForStatementNoShortIfContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public EnhancedForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnhancedForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnhancedForStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnhancedForStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnhancedForStatementNoShortIfContext enhancedForStatementNoShortIf() throws RecognitionException {
		EnhancedForStatementNoShortIfContext _localctx = new EnhancedForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_enhancedForStatementNoShortIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1785);
			match(FOR);
			setState(1786);
			match(LPAREN);
			setState(1790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1787);
				variableModifier();
				}
				}
				setState(1792);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1793);
			unannType();
			setState(1794);
			variableDeclaratorId();
			setState(1795);
			match(COLON);
			setState(1796);
			expression();
			setState(1797);
			match(RPAREN);
			setState(1798);
			statementNoShortIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_breakStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1800);
			match(BREAK);
			setState(1802);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1801);
				match(Identifier);
				}
			}

			setState(1804);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_continueStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1806);
			match(CONTINUE);
			setState(1808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1807);
				match(Identifier);
				}
			}

			setState(1810);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1812);
			match(RETURN);
			setState(1814);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(1813);
				expression();
				}
			}

			setState(1816);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitThrowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitThrowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1818);
			match(THROW);
			setState(1819);
			expression();
			setState(1820);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynchronizedStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SynchronizedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronizedStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSynchronizedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSynchronizedStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSynchronizedStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynchronizedStatementContext synchronizedStatement() throws RecognitionException {
		SynchronizedStatementContext _localctx = new SynchronizedStatementContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_synchronizedStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1822);
			match(SYNCHRONIZED);
			setState(1823);
			match(LPAREN);
			setState(1824);
			expression();
			setState(1825);
			match(RPAREN);
			setState(1826);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public TryWithResourcesStatementContext tryWithResourcesStatement() {
			return getRuleContext(TryWithResourcesStatementContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTryStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_tryStatement);
		int _la;
		try {
			setState(1840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1828);
				match(TRY);
				setState(1829);
				block();
				setState(1830);
				catches();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1832);
				match(TRY);
				setState(1833);
				block();
				setState(1835);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(1834);
					catches();
					}
				}

				setState(1837);
				finally_();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1839);
				tryWithResourcesStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchesContext extends ParserRuleContext {
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public CatchesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catches; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCatches(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCatches(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCatches(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchesContext catches() throws RecognitionException {
		CatchesContext _localctx = new CatchesContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_catches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1842);
			catchClause();
			setState(1846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(1843);
				catchClause();
				}
				}
				setState(1848);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchClauseContext extends ParserRuleContext {
		public CatchFormalParameterContext catchFormalParameter() {
			return getRuleContext(CatchFormalParameterContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_catchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1849);
			match(CATCH);
			setState(1850);
			match(LPAREN);
			setState(1851);
			catchFormalParameter();
			setState(1852);
			match(RPAREN);
			setState(1853);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchFormalParameterContext extends ParserRuleContext {
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public CatchFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCatchFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCatchFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCatchFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchFormalParameterContext catchFormalParameter() throws RecognitionException {
		CatchFormalParameterContext _localctx = new CatchFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_catchFormalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1858);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1855);
				variableModifier();
				}
				}
				setState(1860);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1861);
			catchType();
			setState(1862);
			variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchTypeContext extends ParserRuleContext {
		public UnannClassTypeContext unannClassType() {
			return getRuleContext(UnannClassTypeContext.class,0);
		}
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCatchType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCatchType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1864);
			unannClassType();
			setState(1869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1865);
				match(BITOR);
				setState(1866);
				classType();
				}
				}
				setState(1871);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Finally_Context extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFinally_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFinally_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFinally_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Finally_Context finally_() throws RecognitionException {
		Finally_Context _localctx = new Finally_Context(_ctx, getState());
		enterRule(_localctx, 340, RULE_finally_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1872);
			match(FINALLY);
			setState(1873);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryWithResourcesStatementContext extends ParserRuleContext {
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public TryWithResourcesStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryWithResourcesStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTryWithResourcesStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTryWithResourcesStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTryWithResourcesStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryWithResourcesStatementContext tryWithResourcesStatement() throws RecognitionException {
		TryWithResourcesStatementContext _localctx = new TryWithResourcesStatementContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_tryWithResourcesStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1875);
			match(TRY);
			setState(1876);
			resourceSpecification();
			setState(1877);
			block();
			setState(1879);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CATCH) {
				{
				setState(1878);
				catches();
				}
			}

			setState(1882);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(1881);
				finally_();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceSpecificationContext extends ParserRuleContext {
		public ResourceListContext resourceList() {
			return getRuleContext(ResourceListContext.class,0);
		}
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitResourceSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitResourceSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1884);
			match(LPAREN);
			setState(1885);
			resourceList();
			setState(1887);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1886);
				match(SEMI);
				}
			}

			setState(1889);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceListContext extends ParserRuleContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public ResourceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterResourceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitResourceList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitResourceList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceListContext resourceList() throws RecognitionException {
		ResourceListContext _localctx = new ResourceListContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_resourceList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1891);
			resource();
			setState(1896);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1892);
					match(SEMI);
					setState(1893);
					resource();
					}
					} 
				}
				setState(1898);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_resource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1902);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1899);
				variableModifier();
				}
				}
				setState(1904);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1905);
			unannType();
			setState(1906);
			variableDeclaratorId();
			setState(1907);
			match(ASSIGN);
			setState(1908);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_primaryContext primaryNoNewArray_lfno_primary() {
			return getRuleContext(PrimaryNoNewArray_lfno_primaryContext.class,0);
		}
		public ArrayCreationExpressionContext arrayCreationExpression() {
			return getRuleContext(ArrayCreationExpressionContext.class,0);
		}
		public List<PrimaryNoNewArray_lf_primaryContext> primaryNoNewArray_lf_primary() {
			return getRuleContexts(PrimaryNoNewArray_lf_primaryContext.class);
		}
		public PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_primaryContext.class,i);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1912);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				{
				setState(1910);
				primaryNoNewArray_lfno_primary();
				}
				break;
			case 2:
				{
				setState(1911);
				arrayCreationExpression();
				}
				break;
			}
			setState(1917);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1914);
					primaryNoNewArray_lf_primary();
					}
					} 
				}
				setState(1919);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArrayContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public MethodReferenceContext methodReference() {
			return getRuleContext(MethodReferenceContext.class,0);
		}
		public PrimaryNoNewArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArrayContext primaryNoNewArray() throws RecognitionException {
		PrimaryNoNewArrayContext _localctx = new PrimaryNoNewArrayContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_primaryNoNewArray);
		int _la;
		try {
			setState(1949);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1920);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1921);
				typeName();
				setState(1926);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1922);
					match(LBRACK);
					setState(1923);
					match(RBRACK);
					}
					}
					setState(1928);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1929);
				match(DOT);
				setState(1930);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1932);
				match(VOID);
				setState(1933);
				match(DOT);
				setState(1934);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1935);
				match(THIS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1936);
				typeName();
				setState(1937);
				match(DOT);
				setState(1938);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1940);
				match(LPAREN);
				setState(1941);
				expression();
				setState(1942);
				match(RPAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1944);
				classInstanceCreationExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1945);
				fieldAccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1946);
				arrayAccess();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1947);
				methodInvocation();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1948);
				methodReference();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lf_arrayAccessContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_arrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lf_arrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lf_arrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lf_arrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccess() throws RecognitionException {
		PrimaryNoNewArray_lf_arrayAccessContext _localctx = new PrimaryNoNewArray_lf_arrayAccessContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_primaryNoNewArray_lf_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lfno_arrayAccessContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public MethodReferenceContext methodReference() {
			return getRuleContext(MethodReferenceContext.class,0);
		}
		public PrimaryNoNewArray_lfno_arrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lfno_arrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lfno_arrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lfno_arrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lfno_arrayAccessContext primaryNoNewArray_lfno_arrayAccess() throws RecognitionException {
		PrimaryNoNewArray_lfno_arrayAccessContext _localctx = new PrimaryNoNewArray_lfno_arrayAccessContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_primaryNoNewArray_lfno_arrayAccess);
		int _la;
		try {
			setState(1981);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1953);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1954);
				typeName();
				setState(1959);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1955);
					match(LBRACK);
					setState(1956);
					match(RBRACK);
					}
					}
					setState(1961);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1962);
				match(DOT);
				setState(1963);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1965);
				match(VOID);
				setState(1966);
				match(DOT);
				setState(1967);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1968);
				match(THIS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1969);
				typeName();
				setState(1970);
				match(DOT);
				setState(1971);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1973);
				match(LPAREN);
				setState(1974);
				expression();
				setState(1975);
				match(RPAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1977);
				classInstanceCreationExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1978);
				fieldAccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1979);
				methodInvocation();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1980);
				methodReference();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lf_primaryContext extends ParserRuleContext {
		public ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lf_primaryContext.class,0);
		}
		public FieldAccess_lf_primaryContext fieldAccess_lf_primary() {
			return getRuleContext(FieldAccess_lf_primaryContext.class,0);
		}
		public ArrayAccess_lf_primaryContext arrayAccess_lf_primary() {
			return getRuleContext(ArrayAccess_lf_primaryContext.class,0);
		}
		public MethodInvocation_lf_primaryContext methodInvocation_lf_primary() {
			return getRuleContext(MethodInvocation_lf_primaryContext.class,0);
		}
		public MethodReference_lf_primaryContext methodReference_lf_primary() {
			return getRuleContext(MethodReference_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_primaryNoNewArray_lf_primary);
		try {
			setState(1988);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1983);
				classInstanceCreationExpression_lf_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1984);
				fieldAccess_lf_primary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1985);
				arrayAccess_lf_primary();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1986);
				methodInvocation_lf_primary();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1987);
				methodReference_lf_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext extends ParserRuleContext {
		public ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lf_primaryContext.class,0);
		}
		public FieldAccess_lf_primaryContext fieldAccess_lf_primary() {
			return getRuleContext(FieldAccess_lf_primaryContext.class,0);
		}
		public MethodInvocation_lf_primaryContext methodInvocation_lf_primary() {
			return getRuleContext(MethodInvocation_lf_primaryContext.class,0);
		}
		public MethodReference_lf_primaryContext methodReference_lf_primary() {
			return getRuleContext(MethodReference_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary);
		try {
			setState(1996);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1992);
				classInstanceCreationExpression_lf_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1993);
				fieldAccess_lf_primary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1994);
				methodInvocation_lf_primary();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1995);
				methodReference_lf_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lfno_primaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lfno_primaryContext.class,0);
		}
		public FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() {
			return getRuleContext(FieldAccess_lfno_primaryContext.class,0);
		}
		public ArrayAccess_lfno_primaryContext arrayAccess_lfno_primary() {
			return getRuleContext(ArrayAccess_lfno_primaryContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() {
			return getRuleContext(MethodInvocation_lfno_primaryContext.class,0);
		}
		public MethodReference_lfno_primaryContext methodReference_lfno_primary() {
			return getRuleContext(MethodReference_lfno_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primaryContext primaryNoNewArray_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_primaryNoNewArray_lfno_primary);
		int _la;
		try {
			setState(2038);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1998);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1999);
				typeName();
				setState(2004);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(2000);
					match(LBRACK);
					setState(2001);
					match(RBRACK);
					}
					}
					setState(2006);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2007);
				match(DOT);
				setState(2008);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2010);
				unannPrimitiveType();
				setState(2015);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(2011);
					match(LBRACK);
					setState(2012);
					match(RBRACK);
					}
					}
					setState(2017);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2018);
				match(DOT);
				setState(2019);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2021);
				match(VOID);
				setState(2022);
				match(DOT);
				setState(2023);
				match(CLASS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2024);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2025);
				typeName();
				setState(2026);
				match(DOT);
				setState(2027);
				match(THIS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2029);
				match(LPAREN);
				setState(2030);
				expression();
				setState(2031);
				match(RPAREN);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2033);
				classInstanceCreationExpression_lfno_primary();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2034);
				fieldAccess_lfno_primary();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2035);
				arrayAccess_lfno_primary();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2036);
				methodInvocation_lfno_primary();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2037);
				methodReference_lfno_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lfno_primaryContext.class,0);
		}
		public FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() {
			return getRuleContext(FieldAccess_lfno_primaryContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() {
			return getRuleContext(MethodInvocation_lfno_primaryContext.class,0);
		}
		public MethodReference_lfno_primaryContext methodReference_lfno_primary() {
			return getRuleContext(MethodReference_lfno_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary);
		int _la;
		try {
			setState(2081);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2042);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2043);
				typeName();
				setState(2048);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(2044);
					match(LBRACK);
					setState(2045);
					match(RBRACK);
					}
					}
					setState(2050);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2051);
				match(DOT);
				setState(2052);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2054);
				unannPrimitiveType();
				setState(2059);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(2055);
					match(LBRACK);
					setState(2056);
					match(RBRACK);
					}
					}
					setState(2061);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2062);
				match(DOT);
				setState(2063);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2065);
				match(VOID);
				setState(2066);
				match(DOT);
				setState(2067);
				match(CLASS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2068);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2069);
				typeName();
				setState(2070);
				match(DOT);
				setState(2071);
				match(THIS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2073);
				match(LPAREN);
				setState(2074);
				expression();
				setState(2075);
				match(RPAREN);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2077);
				classInstanceCreationExpression_lfno_primary();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2078);
				fieldAccess_lfno_primary();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2079);
				methodInvocation_lfno_primary();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2080);
				methodReference_lfno_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInstanceCreationExpressionContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(Java8Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Java8Parser.Identifier, i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ClassInstanceCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassInstanceCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassInstanceCreationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassInstanceCreationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInstanceCreationExpressionContext classInstanceCreationExpression() throws RecognitionException {
		ClassInstanceCreationExpressionContext _localctx = new ClassInstanceCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_classInstanceCreationExpression);
		int _la;
		try {
			setState(2166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2083);
				match(NEW);
				setState(2085);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2084);
					typeArguments();
					}
				}

				setState(2090);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2087);
					annotation();
					}
					}
					setState(2092);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2093);
				match(Identifier);
				setState(2104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(2094);
					match(DOT);
					setState(2098);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(2095);
						annotation();
						}
						}
						setState(2100);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2101);
					match(Identifier);
					}
					}
					setState(2106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2107);
					typeArgumentsOrDiamond();
					}
				}

				setState(2110);
				match(LPAREN);
				setState(2112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2111);
					argumentList();
					}
				}

				setState(2114);
				match(RPAREN);
				setState(2116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2115);
					classBody();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2118);
				expressionName();
				setState(2119);
				match(DOT);
				setState(2120);
				match(NEW);
				setState(2122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2121);
					typeArguments();
					}
				}

				setState(2127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2124);
					annotation();
					}
					}
					setState(2129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2130);
				match(Identifier);
				setState(2132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2131);
					typeArgumentsOrDiamond();
					}
				}

				setState(2134);
				match(LPAREN);
				setState(2136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2135);
					argumentList();
					}
				}

				setState(2138);
				match(RPAREN);
				setState(2140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2139);
					classBody();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2142);
				primary();
				setState(2143);
				match(DOT);
				setState(2144);
				match(NEW);
				setState(2146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2145);
					typeArguments();
					}
				}

				setState(2151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2148);
					annotation();
					}
					}
					setState(2153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2154);
				match(Identifier);
				setState(2156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2155);
					typeArgumentsOrDiamond();
					}
				}

				setState(2158);
				match(LPAREN);
				setState(2160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2159);
					argumentList();
					}
				}

				setState(2162);
				match(RPAREN);
				setState(2164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2163);
					classBody();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInstanceCreationExpression_lf_primaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassInstanceCreationExpression_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassInstanceCreationExpression_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassInstanceCreationExpression_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassInstanceCreationExpression_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() throws RecognitionException {
		ClassInstanceCreationExpression_lf_primaryContext _localctx = new ClassInstanceCreationExpression_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_classInstanceCreationExpression_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2168);
			match(DOT);
			setState(2169);
			match(NEW);
			setState(2171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2170);
				typeArguments();
				}
			}

			setState(2176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(2173);
				annotation();
				}
				}
				setState(2178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2179);
			match(Identifier);
			setState(2181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2180);
				typeArgumentsOrDiamond();
				}
			}

			setState(2183);
			match(LPAREN);
			setState(2185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(2184);
				argumentList();
				}
			}

			setState(2187);
			match(RPAREN);
			setState(2189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
			case 1:
				{
				setState(2188);
				classBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInstanceCreationExpression_lfno_primaryContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(Java8Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Java8Parser.Identifier, i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassInstanceCreationExpression_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassInstanceCreationExpression_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassInstanceCreationExpression_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() throws RecognitionException {
		ClassInstanceCreationExpression_lfno_primaryContext _localctx = new ClassInstanceCreationExpression_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_classInstanceCreationExpression_lfno_primary);
		int _la;
		try {
			setState(2250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(2191);
				match(NEW);
				setState(2193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2192);
					typeArguments();
					}
				}

				setState(2198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2195);
					annotation();
					}
					}
					setState(2200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2201);
				match(Identifier);
				setState(2212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(2202);
					match(DOT);
					setState(2206);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(2203);
						annotation();
						}
						}
						setState(2208);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2209);
					match(Identifier);
					}
					}
					setState(2214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2215);
					typeArgumentsOrDiamond();
					}
				}

				setState(2218);
				match(LPAREN);
				setState(2220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2219);
					argumentList();
					}
				}

				setState(2222);
				match(RPAREN);
				setState(2224);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
				case 1:
					{
					setState(2223);
					classBody();
					}
					break;
				}
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2226);
				expressionName();
				setState(2227);
				match(DOT);
				setState(2228);
				match(NEW);
				setState(2230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2229);
					typeArguments();
					}
				}

				setState(2235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2232);
					annotation();
					}
					}
					setState(2237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2238);
				match(Identifier);
				setState(2240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2239);
					typeArgumentsOrDiamond();
					}
				}

				setState(2242);
				match(LPAREN);
				setState(2244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2243);
					argumentList();
					}
				}

				setState(2246);
				match(RPAREN);
				setState(2248);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
				case 1:
					{
					setState(2247);
					classBody();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeArgumentsOrDiamond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeArgumentsOrDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_typeArgumentsOrDiamond);
		try {
			setState(2255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2252);
				typeArguments();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2253);
				match(LT);
				setState(2254);
				match(GT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldAccessContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public FieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_fieldAccess);
		try {
			setState(2270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2257);
				primary();
				setState(2258);
				match(DOT);
				setState(2259);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2261);
				match(SUPER);
				setState(2262);
				match(DOT);
				setState(2263);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2264);
				typeName();
				setState(2265);
				match(DOT);
				setState(2266);
				match(SUPER);
				setState(2267);
				match(DOT);
				setState(2268);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldAccess_lf_primaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public FieldAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldAccess_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldAccess_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccess_lf_primaryContext fieldAccess_lf_primary() throws RecognitionException {
		FieldAccess_lf_primaryContext _localctx = new FieldAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_fieldAccess_lf_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2272);
			match(DOT);
			setState(2273);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldAccess_lfno_primaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public FieldAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldAccess_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldAccess_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() throws RecognitionException {
		FieldAccess_lfno_primaryContext _localctx = new FieldAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_fieldAccess_lfno_primary);
		try {
			setState(2284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2275);
				match(SUPER);
				setState(2276);
				match(DOT);
				setState(2277);
				match(Identifier);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2278);
				typeName();
				setState(2279);
				match(DOT);
				setState(2280);
				match(SUPER);
				setState(2281);
				match(DOT);
				setState(2282);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccessContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrimaryNoNewArray_lfno_arrayAccessContext primaryNoNewArray_lfno_arrayAccess() {
			return getRuleContext(PrimaryNoNewArray_lfno_arrayAccessContext.class,0);
		}
		public List<PrimaryNoNewArray_lf_arrayAccessContext> primaryNoNewArray_lf_arrayAccess() {
			return getRuleContexts(PrimaryNoNewArray_lf_arrayAccessContext.class);
		}
		public PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccess(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_arrayAccessContext.class,i);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
			case 1:
				{
				setState(2286);
				expressionName();
				setState(2287);
				match(LBRACK);
				setState(2288);
				expression();
				setState(2289);
				match(RBRACK);
				}
				break;
			case 2:
				{
				setState(2291);
				primaryNoNewArray_lfno_arrayAccess();
				setState(2292);
				match(LBRACK);
				setState(2293);
				expression();
				setState(2294);
				match(RBRACK);
				}
				break;
			}
			setState(2305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(2298);
				primaryNoNewArray_lf_arrayAccess();
				setState(2299);
				match(LBRACK);
				setState(2300);
				expression();
				setState(2301);
				match(RBRACK);
				}
				}
				setState(2307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccess_lf_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary() {
			return getRuleContext(PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext> primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary() {
			return getRuleContexts(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext.class);
		}
		public PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext.class,i);
		}
		public ArrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayAccess_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayAccess_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccess_lf_primaryContext arrayAccess_lf_primary() throws RecognitionException {
		ArrayAccess_lf_primaryContext _localctx = new ArrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_arrayAccess_lf_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2308);
			primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary();
			setState(2309);
			match(LBRACK);
			setState(2310);
			expression();
			setState(2311);
			match(RBRACK);
			}
			setState(2320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2313);
					primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary();
					setState(2314);
					match(LBRACK);
					setState(2315);
					expression();
					setState(2316);
					match(RBRACK);
					}
					} 
				}
				setState(2322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccess_lfno_primaryContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() {
			return getRuleContext(PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext.class,0);
		}
		public List<PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext> primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary() {
			return getRuleContexts(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext.class);
		}
		public PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext.class,i);
		}
		public ArrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayAccess_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayAccess_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccess_lfno_primaryContext arrayAccess_lfno_primary() throws RecognitionException {
		ArrayAccess_lfno_primaryContext _localctx = new ArrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_arrayAccess_lfno_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
			case 1:
				{
				setState(2323);
				expressionName();
				setState(2324);
				match(LBRACK);
				setState(2325);
				expression();
				setState(2326);
				match(RBRACK);
				}
				break;
			case 2:
				{
				setState(2328);
				primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary();
				setState(2329);
				match(LBRACK);
				setState(2330);
				expression();
				setState(2331);
				match(RBRACK);
				}
				break;
			}
			setState(2342);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,249,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2335);
					primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary();
					setState(2336);
					match(LBRACK);
					setState(2337);
					expression();
					setState(2338);
					match(RBRACK);
					}
					} 
				}
				setState(2344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,249,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocationContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_methodInvocation);
		int _la;
		try {
			setState(2413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2345);
				methodName();
				setState(2346);
				match(LPAREN);
				setState(2348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2347);
					argumentList();
					}
				}

				setState(2350);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2352);
				typeName();
				setState(2353);
				match(DOT);
				setState(2355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2354);
					typeArguments();
					}
				}

				setState(2357);
				match(Identifier);
				setState(2358);
				match(LPAREN);
				setState(2360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2359);
					argumentList();
					}
				}

				setState(2362);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2364);
				expressionName();
				setState(2365);
				match(DOT);
				setState(2367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2366);
					typeArguments();
					}
				}

				setState(2369);
				match(Identifier);
				setState(2370);
				match(LPAREN);
				setState(2372);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2371);
					argumentList();
					}
				}

				setState(2374);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2376);
				primary();
				setState(2377);
				match(DOT);
				setState(2379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2378);
					typeArguments();
					}
				}

				setState(2381);
				match(Identifier);
				setState(2382);
				match(LPAREN);
				setState(2384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2383);
					argumentList();
					}
				}

				setState(2386);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2388);
				match(SUPER);
				setState(2389);
				match(DOT);
				setState(2391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2390);
					typeArguments();
					}
				}

				setState(2393);
				match(Identifier);
				setState(2394);
				match(LPAREN);
				setState(2396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2395);
					argumentList();
					}
				}

				setState(2398);
				match(RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2399);
				typeName();
				setState(2400);
				match(DOT);
				setState(2401);
				match(SUPER);
				setState(2402);
				match(DOT);
				setState(2404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2403);
					typeArguments();
					}
				}

				setState(2406);
				match(Identifier);
				setState(2407);
				match(LPAREN);
				setState(2409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2408);
					argumentList();
					}
				}

				setState(2411);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocation_lf_primaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvocation_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodInvocation_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodInvocation_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodInvocation_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocation_lf_primaryContext methodInvocation_lf_primary() throws RecognitionException {
		MethodInvocation_lf_primaryContext _localctx = new MethodInvocation_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_methodInvocation_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2415);
			match(DOT);
			setState(2417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2416);
				typeArguments();
				}
			}

			setState(2419);
			match(Identifier);
			setState(2420);
			match(LPAREN);
			setState(2422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(2421);
				argumentList();
				}
			}

			setState(2424);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocation_lfno_primaryContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodInvocation_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodInvocation_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodInvocation_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() throws RecognitionException {
		MethodInvocation_lfno_primaryContext _localctx = new MethodInvocation_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_methodInvocation_lfno_primary);
		int _la;
		try {
			setState(2482);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2426);
				methodName();
				setState(2427);
				match(LPAREN);
				setState(2429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2428);
					argumentList();
					}
				}

				setState(2431);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2433);
				typeName();
				setState(2434);
				match(DOT);
				setState(2436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2435);
					typeArguments();
					}
				}

				setState(2438);
				match(Identifier);
				setState(2439);
				match(LPAREN);
				setState(2441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2440);
					argumentList();
					}
				}

				setState(2443);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2445);
				expressionName();
				setState(2446);
				match(DOT);
				setState(2448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2447);
					typeArguments();
					}
				}

				setState(2450);
				match(Identifier);
				setState(2451);
				match(LPAREN);
				setState(2453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2452);
					argumentList();
					}
				}

				setState(2455);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2457);
				match(SUPER);
				setState(2458);
				match(DOT);
				setState(2460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2459);
					typeArguments();
					}
				}

				setState(2462);
				match(Identifier);
				setState(2463);
				match(LPAREN);
				setState(2465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2464);
					argumentList();
					}
				}

				setState(2467);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2468);
				typeName();
				setState(2469);
				match(DOT);
				setState(2470);
				match(SUPER);
				setState(2471);
				match(DOT);
				setState(2473);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2472);
					typeArguments();
					}
				}

				setState(2475);
				match(Identifier);
				setState(2476);
				match(LPAREN);
				setState(2478);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
					{
					setState(2477);
					argumentList();
					}
				}

				setState(2480);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2484);
			expression();
			setState(2489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2485);
				match(COMMA);
				setState(2486);
				expression();
				}
				}
				setState(2491);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodReferenceContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public MethodReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodReferenceContext methodReference() throws RecognitionException {
		MethodReferenceContext _localctx = new MethodReferenceContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_methodReference);
		int _la;
		try {
			setState(2539);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,281,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2492);
				expressionName();
				setState(2493);
				match(COLONCOLON);
				setState(2495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2494);
					typeArguments();
					}
				}

				setState(2497);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2499);
				referenceType();
				setState(2500);
				match(COLONCOLON);
				setState(2502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2501);
					typeArguments();
					}
				}

				setState(2504);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2506);
				primary();
				setState(2507);
				match(COLONCOLON);
				setState(2509);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2508);
					typeArguments();
					}
				}

				setState(2511);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2513);
				match(SUPER);
				setState(2514);
				match(COLONCOLON);
				setState(2516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2515);
					typeArguments();
					}
				}

				setState(2518);
				match(Identifier);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2519);
				typeName();
				setState(2520);
				match(DOT);
				setState(2521);
				match(SUPER);
				setState(2522);
				match(COLONCOLON);
				setState(2524);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2523);
					typeArguments();
					}
				}

				setState(2526);
				match(Identifier);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2528);
				classType();
				setState(2529);
				match(COLONCOLON);
				setState(2531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2530);
					typeArguments();
					}
				}

				setState(2533);
				match(NEW);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2535);
				arrayType();
				setState(2536);
				match(COLONCOLON);
				setState(2537);
				match(NEW);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodReference_lf_primaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public MethodReference_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodReference_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodReference_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodReference_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodReference_lf_primaryContext methodReference_lf_primary() throws RecognitionException {
		MethodReference_lf_primaryContext _localctx = new MethodReference_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_methodReference_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2541);
			match(COLONCOLON);
			setState(2543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2542);
				typeArguments();
				}
			}

			setState(2545);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodReference_lfno_primaryContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public MethodReference_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodReference_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodReference_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodReference_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodReference_lfno_primaryContext methodReference_lfno_primary() throws RecognitionException {
		MethodReference_lfno_primaryContext _localctx = new MethodReference_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_methodReference_lfno_primary);
		int _la;
		try {
			setState(2587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2547);
				expressionName();
				setState(2548);
				match(COLONCOLON);
				setState(2550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2549);
					typeArguments();
					}
				}

				setState(2552);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2554);
				referenceType();
				setState(2555);
				match(COLONCOLON);
				setState(2557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2556);
					typeArguments();
					}
				}

				setState(2559);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2561);
				match(SUPER);
				setState(2562);
				match(COLONCOLON);
				setState(2564);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2563);
					typeArguments();
					}
				}

				setState(2566);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2567);
				typeName();
				setState(2568);
				match(DOT);
				setState(2569);
				match(SUPER);
				setState(2570);
				match(COLONCOLON);
				setState(2572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2571);
					typeArguments();
					}
				}

				setState(2574);
				match(Identifier);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2576);
				classType();
				setState(2577);
				match(COLONCOLON);
				setState(2579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2578);
					typeArguments();
					}
				}

				setState(2581);
				match(NEW);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2583);
				arrayType();
				setState(2584);
				match(COLONCOLON);
				setState(2585);
				match(NEW);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreationExpressionContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public DimExprsContext dimExprs() {
			return getRuleContext(DimExprsContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayCreationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayCreationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayCreationExpressionContext arrayCreationExpression() throws RecognitionException {
		ArrayCreationExpressionContext _localctx = new ArrayCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_arrayCreationExpression);
		try {
			setState(2611);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2589);
				match(NEW);
				setState(2590);
				primitiveType();
				setState(2591);
				dimExprs();
				setState(2593);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,289,_ctx) ) {
				case 1:
					{
					setState(2592);
					dims();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2595);
				match(NEW);
				setState(2596);
				classOrInterfaceType();
				setState(2597);
				dimExprs();
				setState(2599);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
				case 1:
					{
					setState(2598);
					dims();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2601);
				match(NEW);
				setState(2602);
				primitiveType();
				setState(2603);
				dims();
				setState(2604);
				arrayInitializer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2606);
				match(NEW);
				setState(2607);
				classOrInterfaceType();
				setState(2608);
				dims();
				setState(2609);
				arrayInitializer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimExprsContext extends ParserRuleContext {
		public List<DimExprContext> dimExpr() {
			return getRuleContexts(DimExprContext.class);
		}
		public DimExprContext dimExpr(int i) {
			return getRuleContext(DimExprContext.class,i);
		}
		public DimExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimExprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDimExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDimExprs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDimExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimExprsContext dimExprs() throws RecognitionException {
		DimExprsContext _localctx = new DimExprsContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_dimExprs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2613);
			dimExpr();
			setState(2617);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,292,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2614);
					dimExpr();
					}
					} 
				}
				setState(2619);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,292,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimExprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public DimExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDimExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDimExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDimExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimExprContext dimExpr() throws RecognitionException {
		DimExprContext _localctx = new DimExprContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_dimExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(2620);
				annotation();
				}
				}
				setState(2625);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2626);
			match(LBRACK);
			setState(2627);
			expression();
			setState(2628);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstantExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstantExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2630);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_expression);
		try {
			setState(2634);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2632);
				lambdaExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2633);
				assignmentExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaExpressionContext extends ParserRuleContext {
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public LambdaBodyContext lambdaBody() {
			return getRuleContext(LambdaBodyContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLambdaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2636);
			lambdaParameters();
			setState(2637);
			match(ARROW);
			setState(2638);
			lambdaBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaParametersContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public InferredFormalParameterListContext inferredFormalParameterList() {
			return getRuleContext(InferredFormalParameterListContext.class,0);
		}
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLambdaParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLambdaParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLambdaParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_lambdaParameters);
		int _la;
		try {
			setState(2650);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2640);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2641);
				match(LPAREN);
				setState(2643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier || _la==AT) {
					{
					setState(2642);
					formalParameterList();
					}
				}

				setState(2645);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2646);
				match(LPAREN);
				setState(2647);
				inferredFormalParameterList();
				setState(2648);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InferredFormalParameterListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(Java8Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Java8Parser.Identifier, i);
		}
		public InferredFormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inferredFormalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInferredFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInferredFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInferredFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InferredFormalParameterListContext inferredFormalParameterList() throws RecognitionException {
		InferredFormalParameterListContext _localctx = new InferredFormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_inferredFormalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2652);
			match(Identifier);
			setState(2657);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2653);
				match(COMMA);
				setState(2654);
				match(Identifier);
				}
				}
				setState(2659);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaBodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLambdaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLambdaBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLambdaBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaBodyContext lambdaBody() throws RecognitionException {
		LambdaBodyContext _localctx = new LambdaBodyContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_lambdaBody);
		try {
			setState(2662);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2660);
				expression();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2661);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_assignmentExpression);
		try {
			setState(2666);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,299,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2664);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2665);
				assignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2668);
			leftHandSide();
			setState(2669);
			assignmentOperator();
			setState(2670);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftHandSideContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public LeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLeftHandSide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLeftHandSide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftHandSideContext leftHandSide() throws RecognitionException {
		LeftHandSideContext _localctx = new LeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_leftHandSide);
		try {
			setState(2675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,300,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2672);
				expressionName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2673);
				fieldAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2674);
				arrayAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2677);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (ASSIGN - 66)) | (1L << (ADD_ASSIGN - 66)) | (1L << (SUB_ASSIGN - 66)) | (1L << (MUL_ASSIGN - 66)) | (1L << (DIV_ASSIGN - 66)) | (1L << (AND_ASSIGN - 66)) | (1L << (OR_ASSIGN - 66)) | (1L << (XOR_ASSIGN - 66)) | (1L << (MOD_ASSIGN - 66)) | (1L << (LSHIFT_ASSIGN - 66)) | (1L << (RSHIFT_ASSIGN - 66)) | (1L << (URSHIFT_ASSIGN - 66)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_conditionalExpression);
		try {
			setState(2686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,301,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2679);
				conditionalOrExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2680);
				conditionalOrExpression(0);
				setState(2681);
				match(QUESTION);
				setState(2682);
				expression();
				setState(2683);
				match(COLON);
				setState(2684);
				conditionalExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalOrExpressionContext extends ParserRuleContext {
		public ConditionalAndExpressionContext conditionalAndExpression() {
			return getRuleContext(ConditionalAndExpressionContext.class,0);
		}
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public ConditionalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConditionalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConditionalOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConditionalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalOrExpressionContext conditionalOrExpression() throws RecognitionException {
		return conditionalOrExpression(0);
	}

	private ConditionalOrExpressionContext conditionalOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalOrExpressionContext _localctx = new ConditionalOrExpressionContext(_ctx, _parentState);
		ConditionalOrExpressionContext _prevctx = _localctx;
		int _startState = 432;
		enterRecursionRule(_localctx, 432, RULE_conditionalOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2689);
			conditionalAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2696);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,302,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionalOrExpression);
					setState(2691);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2692);
					match(OR);
					setState(2693);
					conditionalAndExpression(0);
					}
					} 
				}
				setState(2698);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,302,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionalAndExpressionContext extends ParserRuleContext {
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public ConditionalAndExpressionContext conditionalAndExpression() {
			return getRuleContext(ConditionalAndExpressionContext.class,0);
		}
		public ConditionalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConditionalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConditionalAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConditionalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalAndExpressionContext conditionalAndExpression() throws RecognitionException {
		return conditionalAndExpression(0);
	}

	private ConditionalAndExpressionContext conditionalAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalAndExpressionContext _localctx = new ConditionalAndExpressionContext(_ctx, _parentState);
		ConditionalAndExpressionContext _prevctx = _localctx;
		int _startState = 434;
		enterRecursionRule(_localctx, 434, RULE_conditionalAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2700);
			inclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2707);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,303,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionalAndExpression);
					setState(2702);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2703);
					match(AND);
					setState(2704);
					inclusiveOrExpression(0);
					}
					} 
				}
				setState(2709);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,303,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InclusiveOrExpressionContext extends ParserRuleContext {
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInclusiveOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInclusiveOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		return inclusiveOrExpression(0);
	}

	private InclusiveOrExpressionContext inclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, _parentState);
		InclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 436;
		enterRecursionRule(_localctx, 436, RULE_inclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2711);
			exclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2718);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,304,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inclusiveOrExpression);
					setState(2713);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2714);
					match(BITOR);
					setState(2715);
					exclusiveOrExpression(0);
					}
					} 
				}
				setState(2720);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,304,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExclusiveOrExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExclusiveOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExclusiveOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		return exclusiveOrExpression(0);
	}

	private ExclusiveOrExpressionContext exclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, _parentState);
		ExclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 438;
		enterRecursionRule(_localctx, 438, RULE_exclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2722);
			andExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2729);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,305,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exclusiveOrExpression);
					setState(2724);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2725);
					match(CARET);
					setState(2726);
					andExpression(0);
					}
					} 
				}
				setState(2731);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,305,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		return andExpression(0);
	}

	private AndExpressionContext andExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, _parentState);
		AndExpressionContext _prevctx = _localctx;
		int _startState = 440;
		enterRecursionRule(_localctx, 440, RULE_andExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2733);
			equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2740);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,306,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpression);
					setState(2735);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2736);
					match(BITAND);
					setState(2737);
					equalityExpression(0);
					}
					} 
				}
				setState(2742);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,306,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 442;
		enterRecursionRule(_localctx, 442, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2744);
			relationalExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2754);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,308,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2752);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(2746);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2747);
						match(EQUAL);
						setState(2748);
						relationalExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(2749);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2750);
						match(NOTEQUAL);
						setState(2751);
						relationalExpression(0);
						}
						break;
					}
					} 
				}
				setState(2756);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,308,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 444;
		enterRecursionRule(_localctx, 444, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2758);
			shiftExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2777);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,310,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2775);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,309,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2760);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(2761);
						match(LT);
						setState(2762);
						shiftExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2763);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(2764);
						match(GT);
						setState(2765);
						shiftExpression(0);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2766);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2767);
						match(LE);
						setState(2768);
						shiftExpression(0);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2769);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2770);
						match(GE);
						setState(2771);
						shiftExpression(0);
						}
						break;
					case 5:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2772);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2773);
						match(INSTANCEOF);
						setState(2774);
						referenceType();
						}
						break;
					}
					} 
				}
				setState(2779);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,310,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		return shiftExpression(0);
	}

	private ShiftExpressionContext shiftExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, _parentState);
		ShiftExpressionContext _prevctx = _localctx;
		int _startState = 446;
		enterRecursionRule(_localctx, 446, RULE_shiftExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2781);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2798);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,312,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2796);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,311,_ctx) ) {
					case 1:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2783);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2784);
						match(LT);
						setState(2785);
						match(LT);
						setState(2786);
						additiveExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2787);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2788);
						match(GT);
						setState(2789);
						match(GT);
						setState(2790);
						additiveExpression(0);
						}
						break;
					case 3:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2791);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2792);
						match(GT);
						setState(2793);
						match(GT);
						setState(2794);
						match(GT);
						setState(2795);
						additiveExpression(0);
						}
						break;
					}
					} 
				}
				setState(2800);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,312,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 448;
		enterRecursionRule(_localctx, 448, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2802);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2812);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,314,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2810);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,313,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(2804);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2805);
						match(ADD);
						setState(2806);
						multiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(2807);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2808);
						match(SUB);
						setState(2809);
						multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(2814);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,314,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 450;
		enterRecursionRule(_localctx, 450, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2816);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(2829);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,316,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2827);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,315,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2818);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2819);
						match(MUL);
						setState(2820);
						unaryExpression();
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2821);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2822);
						match(DIV);
						setState(2823);
						unaryExpression();
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2824);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2825);
						match(MOD);
						setState(2826);
						unaryExpression();
						}
						break;
					}
					} 
				}
				setState(2831);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,316,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public PreIncrementExpressionContext preIncrementExpression() {
			return getRuleContext(PreIncrementExpressionContext.class,0);
		}
		public PreDecrementExpressionContext preDecrementExpression() {
			return getRuleContext(PreDecrementExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() {
			return getRuleContext(UnaryExpressionNotPlusMinusContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 452, RULE_unaryExpression);
		try {
			setState(2839);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2832);
				preIncrementExpression();
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(2833);
				preDecrementExpression();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 3);
				{
				setState(2834);
				match(ADD);
				setState(2835);
				unaryExpression();
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 4);
				{
				setState(2836);
				match(SUB);
				setState(2837);
				unaryExpression();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2838);
				unaryExpressionNotPlusMinus();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreIncrementExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public PreIncrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preIncrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPreIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPreIncrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPreIncrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreIncrementExpressionContext preIncrementExpression() throws RecognitionException {
		PreIncrementExpressionContext _localctx = new PreIncrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 454, RULE_preIncrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2841);
			match(INC);
			setState(2842);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreDecrementExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public PreDecrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preDecrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPreDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPreDecrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPreDecrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreDecrementExpressionContext preDecrementExpression() throws RecognitionException {
		PreDecrementExpressionContext _localctx = new PreDecrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 456, RULE_preDecrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2844);
			match(DEC);
			setState(2845);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionNotPlusMinusContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public UnaryExpressionNotPlusMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpressionNotPlusMinus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnaryExpressionNotPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnaryExpressionNotPlusMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnaryExpressionNotPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() throws RecognitionException {
		UnaryExpressionNotPlusMinusContext _localctx = new UnaryExpressionNotPlusMinusContext(_ctx, getState());
		enterRule(_localctx, 458, RULE_unaryExpressionNotPlusMinus);
		try {
			setState(2853);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,318,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2847);
				postfixExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2848);
				match(TILDE);
				setState(2849);
				unaryExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2850);
				match(BANG);
				setState(2851);
				unaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2852);
				castExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<PostIncrementExpression_lf_postfixExpressionContext> postIncrementExpression_lf_postfixExpression() {
			return getRuleContexts(PostIncrementExpression_lf_postfixExpressionContext.class);
		}
		public PostIncrementExpression_lf_postfixExpressionContext postIncrementExpression_lf_postfixExpression(int i) {
			return getRuleContext(PostIncrementExpression_lf_postfixExpressionContext.class,i);
		}
		public List<PostDecrementExpression_lf_postfixExpressionContext> postDecrementExpression_lf_postfixExpression() {
			return getRuleContexts(PostDecrementExpression_lf_postfixExpressionContext.class);
		}
		public PostDecrementExpression_lf_postfixExpressionContext postDecrementExpression_lf_postfixExpression(int i) {
			return getRuleContext(PostDecrementExpression_lf_postfixExpressionContext.class,i);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 460, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2857);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
			case 1:
				{
				setState(2855);
				primary();
				}
				break;
			case 2:
				{
				setState(2856);
				expressionName();
				}
				break;
			}
			setState(2863);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,321,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(2861);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INC:
						{
						setState(2859);
						postIncrementExpression_lf_postfixExpression();
						}
						break;
					case DEC:
						{
						setState(2860);
						postDecrementExpression_lf_postfixExpression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(2865);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,321,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostIncrementExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public PostIncrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postIncrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostIncrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostIncrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostIncrementExpressionContext postIncrementExpression() throws RecognitionException {
		PostIncrementExpressionContext _localctx = new PostIncrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 462, RULE_postIncrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2866);
			postfixExpression();
			setState(2867);
			match(INC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostIncrementExpression_lf_postfixExpressionContext extends ParserRuleContext {
		public PostIncrementExpression_lf_postfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postIncrementExpression_lf_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostIncrementExpression_lf_postfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostIncrementExpression_lf_postfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostIncrementExpression_lf_postfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostIncrementExpression_lf_postfixExpressionContext postIncrementExpression_lf_postfixExpression() throws RecognitionException {
		PostIncrementExpression_lf_postfixExpressionContext _localctx = new PostIncrementExpression_lf_postfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 464, RULE_postIncrementExpression_lf_postfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2869);
			match(INC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostDecrementExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public PostDecrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postDecrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostDecrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostDecrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostDecrementExpressionContext postDecrementExpression() throws RecognitionException {
		PostDecrementExpressionContext _localctx = new PostDecrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 466, RULE_postDecrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2871);
			postfixExpression();
			setState(2872);
			match(DEC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostDecrementExpression_lf_postfixExpressionContext extends ParserRuleContext {
		public PostDecrementExpression_lf_postfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postDecrementExpression_lf_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostDecrementExpression_lf_postfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostDecrementExpression_lf_postfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostDecrementExpression_lf_postfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostDecrementExpression_lf_postfixExpressionContext postDecrementExpression_lf_postfixExpression() throws RecognitionException {
		PostDecrementExpression_lf_postfixExpressionContext _localctx = new PostDecrementExpression_lf_postfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 468, RULE_postDecrementExpression_lf_postfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2874);
			match(DEC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastExpressionContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() {
			return getRuleContext(UnaryExpressionNotPlusMinusContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 470, RULE_castExpression);
		int _la;
		try {
			setState(2903);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,324,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2876);
				match(LPAREN);
				setState(2877);
				primitiveType();
				setState(2878);
				match(RPAREN);
				setState(2879);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2881);
				match(LPAREN);
				setState(2882);
				referenceType();
				setState(2886);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(2883);
					additionalBound();
					}
					}
					setState(2888);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2889);
				match(RPAREN);
				setState(2890);
				unaryExpressionNotPlusMinus();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2892);
				match(LPAREN);
				setState(2893);
				referenceType();
				setState(2897);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(2894);
					additionalBound();
					}
					}
					setState(2899);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2900);
				match(RPAREN);
				setState(2901);
				lambdaExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DocumentationContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Java8Parser.EOF, 0); }
		public TerminalNode JAVADOC_START() { return getToken(Java8Parser.JAVADOC_START, 0); }
		public DocumentationContentContext documentationContent() {
			return getRuleContext(DocumentationContentContext.class,0);
		}
		public TerminalNode JAVADOC_END() { return getToken(Java8Parser.JAVADOC_END, 0); }
		public List<SkipWhitespaceContext> skipWhitespace() {
			return getRuleContexts(SkipWhitespaceContext.class);
		}
		public SkipWhitespaceContext skipWhitespace(int i) {
			return getRuleContext(SkipWhitespaceContext.class,i);
		}
		public DocumentationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDocumentation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDocumentation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDocumentation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentationContext documentation() throws RecognitionException {
		DocumentationContext _localctx = new DocumentationContext(_ctx, getState());
		enterRule(_localctx, 472, RULE_documentation);
		try {
			int _alt;
			setState(2926);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2905);
				match(EOF);
				}
				break;
			case JAVADOC_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(2906);
				match(JAVADOC_START);
				setState(2910);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,325,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2907);
						skipWhitespace();
						}
						} 
					}
					setState(2912);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,325,_ctx);
				}
				setState(2913);
				documentationContent();
				setState(2914);
				match(JAVADOC_END);
				setState(2915);
				match(EOF);
				}
				break;
			case LBRACE:
			case RBRACE:
			case MUL:
			case DIV:
			case AT:
			case NAME:
			case NEWLINE:
			case SPACE:
			case TEXT_CONTENT:
			case INLINE_TAG_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(2920);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,326,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2917);
						skipWhitespace();
						}
						} 
					}
					setState(2922);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,326,_ctx);
				}
				setState(2923);
				documentationContent();
				setState(2924);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DocumentationContentContext extends ParserRuleContext {
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public List<SkipWhitespaceContext> skipWhitespace() {
			return getRuleContexts(SkipWhitespaceContext.class);
		}
		public SkipWhitespaceContext skipWhitespace(int i) {
			return getRuleContext(SkipWhitespaceContext.class,i);
		}
		public TagSectionContext tagSection() {
			return getRuleContext(TagSectionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(Java8Parser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(Java8Parser.NEWLINE, i);
		}
		public DocumentationContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentationContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDocumentationContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDocumentationContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDocumentationContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentationContentContext documentationContent() throws RecognitionException {
		DocumentationContentContext _localctx = new DocumentationContentContext(_ctx, getState());
		enterRule(_localctx, 474, RULE_documentationContent);
		int _la;
		try {
			int _alt;
			setState(2956);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,332,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2928);
				description();
				setState(2932);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE || _la==SPACE) {
					{
					{
					setState(2929);
					skipWhitespace();
					}
					}
					setState(2934);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2938);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,329,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2935);
						skipWhitespace();
						}
						} 
					}
					setState(2940);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,329,_ctx);
				}
				setState(2941);
				tagSection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2942);
				description();
				setState(2944); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2943);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2946); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,330,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(2951);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,331,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2948);
						skipWhitespace();
						}
						} 
					}
					setState(2953);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,331,_ctx);
				}
				setState(2954);
				tagSection();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipWhitespaceContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(Java8Parser.SPACE, 0); }
		public TerminalNode NEWLINE() { return getToken(Java8Parser.NEWLINE, 0); }
		public SkipWhitespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipWhitespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSkipWhitespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSkipWhitespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSkipWhitespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipWhitespaceContext skipWhitespace() throws RecognitionException {
		SkipWhitespaceContext _localctx = new SkipWhitespaceContext(_ctx, getState());
		enterRule(_localctx, 476, RULE_skipWhitespace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2958);
			_la = _input.LA(1);
			if ( !(_la==NEWLINE || _la==SPACE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionContext extends ParserRuleContext {
		public List<DescriptionLineContext> descriptionLine() {
			return getRuleContexts(DescriptionLineContext.class);
		}
		public DescriptionLineContext descriptionLine(int i) {
			return getRuleContext(DescriptionLineContext.class,i);
		}
		public List<DescriptionNewlineContext> descriptionNewline() {
			return getRuleContexts(DescriptionNewlineContext.class);
		}
		public DescriptionNewlineContext descriptionNewline(int i) {
			return getRuleContext(DescriptionNewlineContext.class,i);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 478, RULE_description);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2960);
			descriptionLine();
			setState(2970);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,334,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2962); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2961);
						descriptionNewline();
						}
						}
						setState(2964); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(2966);
					descriptionLine();
					}
					} 
				}
				setState(2972);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,334,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionLineContext extends ParserRuleContext {
		public DescriptionLineStartContext descriptionLineStart() {
			return getRuleContext(DescriptionLineStartContext.class,0);
		}
		public List<DescriptionLineElementContext> descriptionLineElement() {
			return getRuleContexts(DescriptionLineElementContext.class);
		}
		public DescriptionLineElementContext descriptionLineElement(int i) {
			return getRuleContext(DescriptionLineElementContext.class,i);
		}
		public InlineTagContext inlineTag() {
			return getRuleContext(InlineTagContext.class,0);
		}
		public DescriptionLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDescriptionLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDescriptionLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDescriptionLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionLineContext descriptionLine() throws RecognitionException {
		DescriptionLineContext _localctx = new DescriptionLineContext(_ctx, getState());
		enterRule(_localctx, 480, RULE_descriptionLine);
		try {
			int _alt;
			setState(2987);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case RBRACE:
			case MUL:
			case DIV:
			case NAME:
			case SPACE:
			case TEXT_CONTENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2973);
				descriptionLineStart();
				setState(2977);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,335,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2974);
						descriptionLineElement();
						}
						} 
					}
					setState(2979);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,335,_ctx);
				}
				}
				break;
			case INLINE_TAG_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(2980);
				inlineTag();
				setState(2984);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,336,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2981);
						descriptionLineElement();
						}
						} 
					}
					setState(2986);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,336,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionLineStartContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(Java8Parser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(Java8Parser.SPACE, i);
		}
		public List<DescriptionLineNoSpaceNoAtContext> descriptionLineNoSpaceNoAt() {
			return getRuleContexts(DescriptionLineNoSpaceNoAtContext.class);
		}
		public DescriptionLineNoSpaceNoAtContext descriptionLineNoSpaceNoAt(int i) {
			return getRuleContext(DescriptionLineNoSpaceNoAtContext.class,i);
		}
		public List<TerminalNode> AT() { return getTokens(Java8Parser.AT); }
		public TerminalNode AT(int i) {
			return getToken(Java8Parser.AT, i);
		}
		public DescriptionLineStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDescriptionLineStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDescriptionLineStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDescriptionLineStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionLineStartContext descriptionLineStart() throws RecognitionException {
		DescriptionLineStartContext _localctx = new DescriptionLineStartContext(_ctx, getState());
		enterRule(_localctx, 482, RULE_descriptionLineStart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2990);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(2989);
				match(SPACE);
				}
			}

			setState(2993); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2992);
					descriptionLineNoSpaceNoAt();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2995); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,339,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(3002);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,341,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(3000);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LBRACE:
					case RBRACE:
					case MUL:
					case DIV:
					case NAME:
					case TEXT_CONTENT:
						{
						setState(2997);
						descriptionLineNoSpaceNoAt();
						}
						break;
					case SPACE:
						{
						setState(2998);
						match(SPACE);
						}
						break;
					case AT:
						{
						setState(2999);
						match(AT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(3004);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,341,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionLineNoSpaceNoAtContext extends ParserRuleContext {
		public TerminalNode TEXT_CONTENT() { return getToken(Java8Parser.TEXT_CONTENT, 0); }
		public TerminalNode NAME() { return getToken(Java8Parser.NAME, 0); }
		public TerminalNode MUL() { return getToken(Java8Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(Java8Parser.DIV, 0); }
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public DescriptionLineNoSpaceNoAtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineNoSpaceNoAt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDescriptionLineNoSpaceNoAt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDescriptionLineNoSpaceNoAt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDescriptionLineNoSpaceNoAt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionLineNoSpaceNoAtContext descriptionLineNoSpaceNoAt() throws RecognitionException {
		DescriptionLineNoSpaceNoAtContext _localctx = new DescriptionLineNoSpaceNoAtContext(_ctx, getState());
		enterRule(_localctx, 484, RULE_descriptionLineNoSpaceNoAt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3005);
			_la = _input.LA(1);
			if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LBRACE - 59)) | (1L << (RBRACE - 59)) | (1L << (MUL - 59)) | (1L << (DIV - 59)) | (1L << (NAME - 59)) | (1L << (TEXT_CONTENT - 59)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionLineElementContext extends ParserRuleContext {
		public InlineTagContext inlineTag() {
			return getRuleContext(InlineTagContext.class,0);
		}
		public DescriptionLineTextContext descriptionLineText() {
			return getRuleContext(DescriptionLineTextContext.class,0);
		}
		public DescriptionLineElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDescriptionLineElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDescriptionLineElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDescriptionLineElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionLineElementContext descriptionLineElement() throws RecognitionException {
		DescriptionLineElementContext _localctx = new DescriptionLineElementContext(_ctx, getState());
		enterRule(_localctx, 486, RULE_descriptionLineElement);
		try {
			setState(3009);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INLINE_TAG_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(3007);
				inlineTag();
				}
				break;
			case LBRACE:
			case RBRACE:
			case MUL:
			case DIV:
			case AT:
			case NAME:
			case SPACE:
			case TEXT_CONTENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3008);
				descriptionLineText();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionLineTextContext extends ParserRuleContext {
		public List<DescriptionLineNoSpaceNoAtContext> descriptionLineNoSpaceNoAt() {
			return getRuleContexts(DescriptionLineNoSpaceNoAtContext.class);
		}
		public DescriptionLineNoSpaceNoAtContext descriptionLineNoSpaceNoAt(int i) {
			return getRuleContext(DescriptionLineNoSpaceNoAtContext.class,i);
		}
		public List<TerminalNode> SPACE() { return getTokens(Java8Parser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(Java8Parser.SPACE, i);
		}
		public List<TerminalNode> AT() { return getTokens(Java8Parser.AT); }
		public TerminalNode AT(int i) {
			return getToken(Java8Parser.AT, i);
		}
		public DescriptionLineTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDescriptionLineText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDescriptionLineText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDescriptionLineText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionLineTextContext descriptionLineText() throws RecognitionException {
		DescriptionLineTextContext _localctx = new DescriptionLineTextContext(_ctx, getState());
		enterRule(_localctx, 488, RULE_descriptionLineText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3014); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(3014);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LBRACE:
					case RBRACE:
					case MUL:
					case DIV:
					case NAME:
					case TEXT_CONTENT:
						{
						setState(3011);
						descriptionLineNoSpaceNoAt();
						}
						break;
					case SPACE:
						{
						setState(3012);
						match(SPACE);
						}
						break;
					case AT:
						{
						setState(3013);
						match(AT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3016); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,344,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionNewlineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(Java8Parser.NEWLINE, 0); }
		public DescriptionNewlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionNewline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDescriptionNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDescriptionNewline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDescriptionNewline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionNewlineContext descriptionNewline() throws RecognitionException {
		DescriptionNewlineContext _localctx = new DescriptionNewlineContext(_ctx, getState());
		enterRule(_localctx, 490, RULE_descriptionNewline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3018);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagSectionContext extends ParserRuleContext {
		public List<BlockTagContext> blockTag() {
			return getRuleContexts(BlockTagContext.class);
		}
		public BlockTagContext blockTag(int i) {
			return getRuleContext(BlockTagContext.class,i);
		}
		public TagSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTagSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTagSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTagSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagSectionContext tagSection() throws RecognitionException {
		TagSectionContext _localctx = new TagSectionContext(_ctx, getState());
		enterRule(_localctx, 492, RULE_tagSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3021); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3020);
				blockTag();
				}
				}
				setState(3023); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AT || _la==SPACE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockTagContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Java8Parser.AT, 0); }
		public BlockTagNameContext blockTagName() {
			return getRuleContext(BlockTagNameContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(Java8Parser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(Java8Parser.SPACE, i);
		}
		public List<BlockTagContentContext> blockTagContent() {
			return getRuleContexts(BlockTagContentContext.class);
		}
		public BlockTagContentContext blockTagContent(int i) {
			return getRuleContext(BlockTagContentContext.class,i);
		}
		public BlockTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockTagContext blockTag() throws RecognitionException {
		BlockTagContext _localctx = new BlockTagContext(_ctx, getState());
		enterRule(_localctx, 494, RULE_blockTag);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3026);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(3025);
				match(SPACE);
				}
			}

			setState(3028);
			match(AT);
			setState(3029);
			blockTagName();
			setState(3031);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,347,_ctx) ) {
			case 1:
				{
				setState(3030);
				match(SPACE);
				}
				break;
			}
			setState(3036);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,348,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3033);
					blockTagContent();
					}
					} 
				}
				setState(3038);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,348,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockTagNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Java8Parser.NAME, 0); }
		public BlockTagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockTagNameContext blockTagName() throws RecognitionException {
		BlockTagNameContext _localctx = new BlockTagNameContext(_ctx, getState());
		enterRule(_localctx, 496, RULE_blockTagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3039);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockTagContentContext extends ParserRuleContext {
		public BlockTagTextContext blockTagText() {
			return getRuleContext(BlockTagTextContext.class,0);
		}
		public InlineTagContext inlineTag() {
			return getRuleContext(InlineTagContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(Java8Parser.NEWLINE, 0); }
		public BlockTagContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTagContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockTagContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockTagContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockTagContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockTagContentContext blockTagContent() throws RecognitionException {
		BlockTagContentContext _localctx = new BlockTagContentContext(_ctx, getState());
		enterRule(_localctx, 498, RULE_blockTagContent);
		try {
			setState(3044);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case RBRACE:
			case MUL:
			case DIV:
			case NAME:
			case SPACE:
			case TEXT_CONTENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3041);
				blockTagText();
				}
				break;
			case INLINE_TAG_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(3042);
				inlineTag();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(3043);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockTagTextContext extends ParserRuleContext {
		public List<BlockTagTextElementContext> blockTagTextElement() {
			return getRuleContexts(BlockTagTextElementContext.class);
		}
		public BlockTagTextElementContext blockTagTextElement(int i) {
			return getRuleContext(BlockTagTextElementContext.class,i);
		}
		public BlockTagTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTagText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockTagText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockTagText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockTagText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockTagTextContext blockTagText() throws RecognitionException {
		BlockTagTextContext _localctx = new BlockTagTextContext(_ctx, getState());
		enterRule(_localctx, 500, RULE_blockTagText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3047); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3046);
					blockTagTextElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3049); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,350,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockTagTextElementContext extends ParserRuleContext {
		public TerminalNode TEXT_CONTENT() { return getToken(Java8Parser.TEXT_CONTENT, 0); }
		public TerminalNode NAME() { return getToken(Java8Parser.NAME, 0); }
		public TerminalNode SPACE() { return getToken(Java8Parser.SPACE, 0); }
		public TerminalNode MUL() { return getToken(Java8Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(Java8Parser.DIV, 0); }
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public BlockTagTextElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTagTextElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockTagTextElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockTagTextElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockTagTextElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockTagTextElementContext blockTagTextElement() throws RecognitionException {
		BlockTagTextElementContext _localctx = new BlockTagTextElementContext(_ctx, getState());
		enterRule(_localctx, 502, RULE_blockTagTextElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3051);
			_la = _input.LA(1);
			if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LBRACE - 59)) | (1L << (RBRACE - 59)) | (1L << (MUL - 59)) | (1L << (DIV - 59)) | (1L << (NAME - 59)) | (1L << (SPACE - 59)) | (1L << (TEXT_CONTENT - 59)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineTagContext extends ParserRuleContext {
		public TerminalNode INLINE_TAG_START() { return getToken(Java8Parser.INLINE_TAG_START, 0); }
		public InlineTagNameContext inlineTagName() {
			return getRuleContext(InlineTagNameContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public List<TerminalNode> SPACE() { return getTokens(Java8Parser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(Java8Parser.SPACE, i);
		}
		public InlineTagContentContext inlineTagContent() {
			return getRuleContext(InlineTagContentContext.class,0);
		}
		public InlineTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInlineTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInlineTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInlineTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTagContext inlineTag() throws RecognitionException {
		InlineTagContext _localctx = new InlineTagContext(_ctx, getState());
		enterRule(_localctx, 504, RULE_inlineTag);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3053);
			match(INLINE_TAG_START);
			setState(3054);
			inlineTagName();
			setState(3058);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,351,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3055);
					match(SPACE);
					}
					} 
				}
				setState(3060);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,351,_ctx);
			}
			setState(3062);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LBRACE - 59)) | (1L << (MUL - 59)) | (1L << (DIV - 59)) | (1L << (NAME - 59)) | (1L << (NEWLINE - 59)) | (1L << (SPACE - 59)) | (1L << (TEXT_CONTENT - 59)))) != 0)) {
				{
				setState(3061);
				inlineTagContent();
				}
			}

			setState(3064);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineTagNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Java8Parser.NAME, 0); }
		public InlineTagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInlineTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInlineTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInlineTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTagNameContext inlineTagName() throws RecognitionException {
		InlineTagNameContext _localctx = new InlineTagNameContext(_ctx, getState());
		enterRule(_localctx, 506, RULE_inlineTagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3066);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineTagContentContext extends ParserRuleContext {
		public List<BraceContentContext> braceContent() {
			return getRuleContexts(BraceContentContext.class);
		}
		public BraceContentContext braceContent(int i) {
			return getRuleContext(BraceContentContext.class,i);
		}
		public InlineTagContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTagContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInlineTagContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInlineTagContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInlineTagContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTagContentContext inlineTagContent() throws RecognitionException {
		InlineTagContentContext _localctx = new InlineTagContentContext(_ctx, getState());
		enterRule(_localctx, 508, RULE_inlineTagContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3069); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3068);
				braceContent();
				}
				}
				setState(3071); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LBRACE - 59)) | (1L << (MUL - 59)) | (1L << (DIV - 59)) | (1L << (NAME - 59)) | (1L << (NEWLINE - 59)) | (1L << (SPACE - 59)) | (1L << (TEXT_CONTENT - 59)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BraceExpressionContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public List<BraceContentContext> braceContent() {
			return getRuleContexts(BraceContentContext.class);
		}
		public BraceContentContext braceContent(int i) {
			return getRuleContext(BraceContentContext.class,i);
		}
		public BraceExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBraceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBraceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBraceExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BraceExpressionContext braceExpression() throws RecognitionException {
		BraceExpressionContext _localctx = new BraceExpressionContext(_ctx, getState());
		enterRule(_localctx, 510, RULE_braceExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3073);
			match(LBRACE);
			setState(3077);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LBRACE - 59)) | (1L << (MUL - 59)) | (1L << (DIV - 59)) | (1L << (NAME - 59)) | (1L << (NEWLINE - 59)) | (1L << (SPACE - 59)) | (1L << (TEXT_CONTENT - 59)))) != 0)) {
				{
				{
				setState(3074);
				braceContent();
				}
				}
				setState(3079);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3080);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BraceContentContext extends ParserRuleContext {
		public BraceExpressionContext braceExpression() {
			return getRuleContext(BraceExpressionContext.class,0);
		}
		public List<BraceTextContext> braceText() {
			return getRuleContexts(BraceTextContext.class);
		}
		public BraceTextContext braceText(int i) {
			return getRuleContext(BraceTextContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(Java8Parser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(Java8Parser.NEWLINE, i);
		}
		public BraceContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBraceContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBraceContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBraceContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BraceContentContext braceContent() throws RecognitionException {
		BraceContentContext _localctx = new BraceContentContext(_ctx, getState());
		enterRule(_localctx, 512, RULE_braceContent);
		try {
			int _alt;
			setState(3096);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3082);
				braceExpression();
				}
				break;
			case MUL:
			case DIV:
			case NAME:
			case NEWLINE:
			case SPACE:
			case TEXT_CONTENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3083);
				braceText();
				setState(3093);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,356,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(3087);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,355,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(3084);
								match(NEWLINE);
								}
								} 
							}
							setState(3089);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,355,_ctx);
						}
						setState(3090);
						braceText();
						}
						} 
					}
					setState(3095);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,356,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BraceTextContext extends ParserRuleContext {
		public TerminalNode TEXT_CONTENT() { return getToken(Java8Parser.TEXT_CONTENT, 0); }
		public TerminalNode NAME() { return getToken(Java8Parser.NAME, 0); }
		public TerminalNode SPACE() { return getToken(Java8Parser.SPACE, 0); }
		public TerminalNode MUL() { return getToken(Java8Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(Java8Parser.DIV, 0); }
		public TerminalNode NEWLINE() { return getToken(Java8Parser.NEWLINE, 0); }
		public BraceTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBraceText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBraceText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBraceText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BraceTextContext braceText() throws RecognitionException {
		BraceTextContext _localctx = new BraceTextContext(_ctx, getState());
		enterRule(_localctx, 514, RULE_braceText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3098);
			_la = _input.LA(1);
			if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (MUL - 83)) | (1L << (DIV - 83)) | (1L << (NAME - 83)) | (1L << (NEWLINE - 83)) | (1L << (SPACE - 83)) | (1L << (TEXT_CONTENT - 83)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return packageName_sempred((PackageNameContext)_localctx, predIndex);
		case 27:
			return packageOrTypeName_sempred((PackageOrTypeNameContext)_localctx, predIndex);
		case 30:
			return ambiguousName_sempred((AmbiguousNameContext)_localctx, predIndex);
		case 216:
			return conditionalOrExpression_sempred((ConditionalOrExpressionContext)_localctx, predIndex);
		case 217:
			return conditionalAndExpression_sempred((ConditionalAndExpressionContext)_localctx, predIndex);
		case 218:
			return inclusiveOrExpression_sempred((InclusiveOrExpressionContext)_localctx, predIndex);
		case 219:
			return exclusiveOrExpression_sempred((ExclusiveOrExpressionContext)_localctx, predIndex);
		case 220:
			return andExpression_sempred((AndExpressionContext)_localctx, predIndex);
		case 221:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 222:
			return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		case 223:
			return shiftExpression_sempred((ShiftExpressionContext)_localctx, predIndex);
		case 224:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 225:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean packageName_sempred(PackageNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean packageOrTypeName_sempred(PackageOrTypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean ambiguousName_sempred(AmbiguousNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionalOrExpression_sempred(ConditionalOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionalAndExpression_sempred(ConditionalAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusiveOrExpression_sempred(InclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusiveOrExpression_sempred(ExclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpression_sempred(AndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftExpression_sempred(ShiftExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 3);
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 3);
		case 21:
			return precpred(_ctx, 2);
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}

	private static final int _serializedATNSegments = 2;
	private static final String _serializedATNSegment0 =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3t\u0c1f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"+
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc\4\u00cd"+
		"\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1\t\u00d1"+
		"\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4\t\u00d4\4\u00d5\t\u00d5\4\u00d6"+
		"\t\u00d6\4\u00d7\t\u00d7\4\u00d8\t\u00d8\4\u00d9\t\u00d9\4\u00da\t\u00da"+
		"\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd\t\u00dd\4\u00de\t\u00de\4\u00df"+
		"\t\u00df\4\u00e0\t\u00e0\4\u00e1\t\u00e1\4\u00e2\t\u00e2\4\u00e3\t\u00e3"+
		"\4\u00e4\t\u00e4\4\u00e5\t\u00e5\4\u00e6\t\u00e6\4\u00e7\t\u00e7\4\u00e8"+
		"\t\u00e8\4\u00e9\t\u00e9\4\u00ea\t\u00ea\4\u00eb\t\u00eb\4\u00ec\t\u00ec"+
		"\4\u00ed\t\u00ed\4\u00ee\t\u00ee\4\u00ef\t\u00ef\4\u00f0\t\u00f0\4\u00f1"+
		"\t\u00f1\4\u00f2\t\u00f2\4\u00f3\t\u00f3\4\u00f4\t\u00f4\4\u00f5\t\u00f5"+
		"\4\u00f6\t\u00f6\4\u00f7\t\u00f7\4\u00f8\t\u00f8\4\u00f9\t\u00f9\4\u00fa"+
		"\t\u00fa\4\u00fb\t\u00fb\4\u00fc\t\u00fc\4\u00fd\t\u00fd\4\u00fe\t\u00fe"+
		"\4\u00ff\t\u00ff\4\u0100\t\u0100\4\u0101\t\u0101\4\u0102\t\u0102\4\u0103"+
		"\t\u0103\3\2\3\2\3\3\7\3\u020a\n\3\f\3\16\3\u020d\13\3\3\3\3\3\7\3\u0211"+
		"\n\3\f\3\16\3\u0214\13\3\3\3\5\3\u0217\n\3\3\4\3\4\5\4\u021b\n\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\7\5\7\u0224\n\7\3\b\3\b\5\b\u0228\n\b\3\b\3\b\7\b"+
		"\u022c\n\b\f\b\16\b\u022f\13\b\3\t\7\t\u0232\n\t\f\t\16\t\u0235\13\t\3"+
		"\t\3\t\5\t\u0239\n\t\3\t\3\t\3\t\7\t\u023e\n\t\f\t\16\t\u0241\13\t\3\t"+
		"\3\t\5\t\u0245\n\t\5\t\u0247\n\t\3\n\3\n\7\n\u024b\n\n\f\n\16\n\u024e"+
		"\13\n\3\n\3\n\5\n\u0252\n\n\3\13\7\13\u0255\n\13\f\13\16\13\u0258\13\13"+
		"\3\13\3\13\5\13\u025c\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\7\17\u0265\n"+
		"\17\f\17\16\17\u0268\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u0275\n\20\3\21\7\21\u0278\n\21\f\21\16\21\u027b\13\21"+
		"\3\21\3\21\3\21\7\21\u0280\n\21\f\21\16\21\u0283\13\21\3\21\3\21\7\21"+
		"\u0287\n\21\f\21\16\21\u028a\13\21\3\22\7\22\u028d\n\22\f\22\16\22\u0290"+
		"\13\22\3\22\3\22\5\22\u0294\n\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\7"+
		"\24\u029d\n\24\f\24\16\24\u02a0\13\24\5\24\u02a2\n\24\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\7\27\u02ae\n\27\f\27\16\27\u02b1\13"+
		"\27\3\30\3\30\5\30\u02b5\n\30\3\31\7\31\u02b8\n\31\f\31\16\31\u02bb\13"+
		"\31\3\31\3\31\5\31\u02bf\n\31\3\32\3\32\3\32\3\32\5\32\u02c5\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\7\33\u02cd\n\33\f\33\16\33\u02d0\13\33\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u02d7\n\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35"+
		"\u02df\n\35\f\35\16\35\u02e2\13\35\3\36\3\36\3\36\3\36\3\36\5\36\u02e9"+
		"\n\36\3\37\3\37\3 \3 \3 \3 \3 \3 \7 \u02f3\n \f \16 \u02f6\13 \3!\5!\u02f9"+
		"\n!\3!\7!\u02fc\n!\f!\16!\u02ff\13!\3!\7!\u0302\n!\f!\16!\u0305\13!\3"+
		"!\3!\3\"\7\"\u030a\n\"\f\"\16\"\u030d\13\"\3\"\3\"\3\"\3\"\3#\3#\3$\3"+
		"$\3$\3$\5$\u0319\n$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\5)\u0336\n)\3*\3*\5*\u033a\n*\3"+
		"+\7+\u033d\n+\f+\16+\u0340\13+\3+\3+\3+\5+\u0345\n+\3+\5+\u0348\n+\3+"+
		"\5+\u034b\n+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0357\n,\3-\3-\3-\3-\3."+
		"\3.\3.\7.\u0360\n.\f.\16.\u0363\13.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\7\61\u036e\n\61\f\61\16\61\u0371\13\61\3\62\3\62\7\62\u0375\n\62"+
		"\f\62\16\62\u0378\13\62\3\62\3\62\3\63\3\63\3\63\3\63\5\63\u0380\n\63"+
		"\3\64\3\64\3\64\3\64\3\64\5\64\u0387\n\64\3\65\7\65\u038a\n\65\f\65\16"+
		"\65\u038d\13\65\3\65\7\65\u0390\n\65\f\65\16\65\u0393\13\65\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u03a1\n\66\3\67"+
		"\3\67\3\67\7\67\u03a6\n\67\f\67\16\67\u03a9\13\67\38\38\38\58\u03ae\n"+
		"8\39\39\59\u03b2\n9\3:\3:\5:\u03b6\n:\3;\3;\5;\u03ba\n;\3<\3<\5<\u03be"+
		"\n<\3=\3=\3=\5=\u03c3\n=\3>\3>\5>\u03c7\n>\3>\3>\7>\u03cb\n>\f>\16>\u03ce"+
		"\13>\3?\3?\5?\u03d2\n?\3?\3?\3?\7?\u03d7\n?\f?\16?\u03da\13?\3?\3?\5?"+
		"\u03de\n?\5?\u03e0\n?\3@\3@\7@\u03e4\n@\f@\16@\u03e7\13@\3@\3@\5@\u03eb"+
		"\n@\3A\3A\5A\u03ef\nA\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F"+
		"\3F\5F\u0402\nF\3G\7G\u0405\nG\fG\16G\u0408\13G\3G\7G\u040b\nG\fG\16G"+
		"\u040e\13G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H\u041d\nH\3I\3I\3"+
		"I\5I\u0422\nI\3I\3I\7I\u0426\nI\fI\16I\u0429\13I\3I\3I\3I\5I\u042e\nI"+
		"\5I\u0430\nI\3J\3J\5J\u0434\nJ\3K\3K\3K\5K\u0439\nK\3K\3K\5K\u043d\nK"+
		"\3L\3L\3L\3L\3L\3L\5L\u0445\nL\3M\3M\3M\7M\u044a\nM\fM\16M\u044d\13M\3"+
		"M\3M\3M\7M\u0452\nM\fM\16M\u0455\13M\5M\u0457\nM\3N\7N\u045a\nN\fN\16"+
		"N\u045d\13N\3N\3N\3N\3O\3O\5O\u0464\nO\3P\7P\u0467\nP\fP\16P\u046a\13"+
		"P\3P\3P\7P\u046e\nP\fP\16P\u0471\13P\3P\3P\3P\3P\5P\u0477\nP\3Q\7Q\u047a"+
		"\nQ\fQ\16Q\u047d\13Q\3Q\3Q\3Q\5Q\u0482\nQ\3Q\3Q\3R\3R\3R\3S\3S\3S\7S\u048c"+
		"\nS\fS\16S\u048f\13S\3T\3T\5T\u0493\nT\3U\3U\5U\u0497\nU\3V\3V\3W\3W\3"+
		"W\3X\7X\u049f\nX\fX\16X\u04a2\13X\3X\3X\5X\u04a6\nX\3X\3X\3Y\3Y\3Y\3Y"+
		"\5Y\u04ae\nY\3Z\5Z\u04b1\nZ\3Z\3Z\3Z\5Z\u04b6\nZ\3Z\3Z\3[\3[\3\\\3\\\5"+
		"\\\u04be\n\\\3\\\5\\\u04c1\n\\\3\\\3\\\3]\5]\u04c6\n]\3]\3]\3]\5]\u04cb"+
		"\n]\3]\3]\3]\5]\u04d0\n]\3]\3]\3]\5]\u04d5\n]\3]\3]\3]\3]\3]\5]\u04dc"+
		"\n]\3]\3]\3]\5]\u04e1\n]\3]\3]\3]\3]\3]\3]\5]\u04e9\n]\3]\3]\3]\5]\u04ee"+
		"\n]\3]\3]\3]\5]\u04f3\n]\3^\7^\u04f6\n^\f^\16^\u04f9\13^\3^\3^\3^\5^\u04fe"+
		"\n^\3^\3^\3_\3_\5_\u0504\n_\3_\5_\u0507\n_\3_\5_\u050a\n_\3_\3_\3`\3`"+
		"\3`\7`\u0511\n`\f`\16`\u0514\13`\3a\7a\u0517\na\fa\16a\u051a\13a\3a\3"+
		"a\3a\5a\u051f\na\3a\5a\u0522\na\3a\5a\u0525\na\3b\3b\3c\3c\7c\u052b\n"+
		"c\fc\16c\u052e\13c\3d\3d\5d\u0532\nd\3e\7e\u0535\ne\fe\16e\u0538\13e\3"+
		"e\3e\3e\5e\u053d\ne\3e\5e\u0540\ne\3e\3e\3f\3f\3f\3f\3f\3f\3f\5f\u054b"+
		"\nf\3g\3g\3g\3h\3h\7h\u0552\nh\fh\16h\u0555\13h\3h\3h\3i\3i\3i\3i\3i\5"+
		"i\u055e\ni\3j\7j\u0561\nj\fj\16j\u0564\13j\3j\3j\3j\3j\3k\3k\3k\3k\5k"+
		"\u056e\nk\3l\7l\u0571\nl\fl\16l\u0574\13l\3l\7l\u0577\nl\fl\16l\u057a"+
		"\13l\3l\3l\3l\3m\3m\3m\3m\3m\3m\5m\u0585\nm\3n\7n\u0588\nn\fn\16n\u058b"+
		"\13n\3n\3n\3n\3n\3n\3o\3o\7o\u0594\no\fo\16o\u0597\13o\3o\3o\3p\3p\3p"+
		"\3p\3p\5p\u05a0\np\3q\7q\u05a3\nq\fq\16q\u05a6\13q\3q\3q\3q\3q\3q\5q\u05ad"+
		"\nq\3q\5q\u05b0\nq\3q\3q\3r\3r\3r\5r\u05b7\nr\3s\3s\3s\3t\3t\3t\5t\u05bf"+
		"\nt\3u\3u\3u\3u\5u\u05c5\nu\3u\3u\3v\3v\3v\7v\u05cc\nv\fv\16v\u05cf\13"+
		"v\3w\3w\3w\3w\3x\3x\3x\5x\u05d8\nx\3y\3y\5y\u05dc\ny\3y\5y\u05df\ny\3"+
		"y\3y\3z\3z\3z\7z\u05e6\nz\fz\16z\u05e9\13z\3{\3{\3{\3|\3|\3|\3|\3|\3|"+
		"\3}\3}\5}\u05f6\n}\3}\5}\u05f9\n}\3}\3}\3~\3~\3~\7~\u0600\n~\f~\16~\u0603"+
		"\13~\3\177\3\177\5\177\u0607\n\177\3\177\3\177\3\u0080\6\u0080\u060c\n"+
		"\u0080\r\u0080\16\u0080\u060d\3\u0081\3\u0081\3\u0081\5\u0081\u0613\n"+
		"\u0081\3\u0082\3\u0082\3\u0082\3\u0083\7\u0083\u0619\n\u0083\f\u0083\16"+
		"\u0083\u061c\13\u0083\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084\3\u0084"+
		"\3\u0084\3\u0084\3\u0084\5\u0084\u0627\n\u0084\3\u0085\3\u0085\3\u0085"+
		"\3\u0085\3\u0085\5\u0085\u062e\n\u0085\3\u0086\3\u0086\3\u0086\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\5\u0086"+
		"\u063c\n\u0086\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\3\u008b\3\u008b\3\u008b\5\u008b\u0652\n\u008b\3\u008c\3\u008c"+
		"\3\u008c\3\u008c\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d"+
		"\3\u008d\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e"+
		"\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\5\u008f\u0674\n\u008f\3\u0090\3\u0090\3\u0090"+
		"\3\u0090\3\u0090\3\u0090\3\u0091\3\u0091\7\u0091\u067e\n\u0091\f\u0091"+
		"\16\u0091\u0681\13\u0091\3\u0091\7\u0091\u0684\n\u0091\f\u0091\16\u0091"+
		"\u0687\13\u0091\3\u0091\3\u0091\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093"+
		"\7\u0093\u0690\n\u0093\f\u0093\16\u0093\u0693\13\u0093\3\u0094\3\u0094"+
		"\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\5\u0094"+
		"\u069f\n\u0094\3\u0095\3\u0095\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096"+
		"\3\u0096\3\u0097\3\u0097\3\u0097\3\u0097\3\u0097\3\u0097\3\u0098\3\u0098"+
		"\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098\3\u0099\3\u0099\5\u0099"+
		"\u06b9\n\u0099\3\u009a\3\u009a\5\u009a\u06bd\n\u009a\3\u009b\3\u009b\3"+
		"\u009b\5\u009b\u06c2\n\u009b\3\u009b\3\u009b\5\u009b\u06c6\n\u009b\3\u009b"+
		"\3\u009b\5\u009b\u06ca\n\u009b\3\u009b\3\u009b\3\u009b\3\u009c\3\u009c"+
		"\3\u009c\5\u009c\u06d2\n\u009c\3\u009c\3\u009c\5\u009c\u06d6\n\u009c\3"+
		"\u009c\3\u009c\5\u009c\u06da\n\u009c\3\u009c\3\u009c\3\u009c\3\u009d\3"+
		"\u009d\5\u009d\u06e1\n\u009d\3\u009e\3\u009e\3\u009f\3\u009f\3\u009f\7"+
		"\u009f\u06e8\n\u009f\f\u009f\16\u009f\u06eb\13\u009f\3\u00a0\3\u00a0\3"+
		"\u00a0\7\u00a0\u06f0\n\u00a0\f\u00a0\16\u00a0\u06f3\13\u00a0\3\u00a0\3"+
		"\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1"+
		"\7\u00a1\u06ff\n\u00a1\f\u00a1\16\u00a1\u0702\13\u00a1\3\u00a1\3\u00a1"+
		"\3\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a2\3\u00a2\5\u00a2\u070d"+
		"\n\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3\5\u00a3\u0713\n\u00a3\3\u00a3"+
		"\3\u00a3\3\u00a4\3\u00a4\5\u00a4\u0719\n\u00a4\3\u00a4\3\u00a4\3\u00a5"+
		"\3\u00a5\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6"+
		"\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\5\u00a7\u072e"+
		"\n\u00a7\3\u00a7\3\u00a7\3\u00a7\5\u00a7\u0733\n\u00a7\3\u00a8\3\u00a8"+
		"\7\u00a8\u0737\n\u00a8\f\u00a8\16\u00a8\u073a\13\u00a8\3\u00a9\3\u00a9"+
		"\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00aa\7\u00aa\u0743\n\u00aa\f\u00aa"+
		"\16\u00aa\u0746\13\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab"+
		"\7\u00ab\u074e\n\u00ab\f\u00ab\16\u00ab\u0751\13\u00ab\3\u00ac\3\u00ac"+
		"\3\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ad\5\u00ad\u075a\n\u00ad\3\u00ad"+
		"\5\u00ad\u075d\n\u00ad\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0762\n\u00ae\3"+
		"\u00ae\3\u00ae\3\u00af\3\u00af\3\u00af\7\u00af\u0769\n\u00af\f\u00af\16"+
		"\u00af\u076c\13\u00af\3\u00b0\7\u00b0\u076f\n\u00b0\f\u00b0\16\u00b0\u0772"+
		"\13\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b1\3\u00b1\5\u00b1"+
		"\u077b\n\u00b1\3\u00b1\7\u00b1\u077e\n\u00b1\f\u00b1\16\u00b1\u0781\13"+
		"\u00b1\3\u00b2\3\u00b2\3\u00b2\3\u00b2\7\u00b2\u0787\n\u00b2\f\u00b2\16"+
		"\u00b2\u078a\13\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2"+
		"\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2"+
		"\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\5\u00b2\u07a0\n\u00b2\3\u00b3"+
		"\3\u00b3\3\u00b4\3\u00b4\3\u00b4\3\u00b4\7\u00b4\u07a8\n\u00b4\f\u00b4"+
		"\16\u00b4\u07ab\13\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b4\3\u00b4\5\u00b4\u07c0\n\u00b4\3\u00b5\3\u00b5"+
		"\3\u00b5\3\u00b5\3\u00b5\5\u00b5\u07c7\n\u00b5\3\u00b6\3\u00b6\3\u00b7"+
		"\3\u00b7\3\u00b7\3\u00b7\5\u00b7\u07cf\n\u00b7\3\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b8\7\u00b8\u07d5\n\u00b8\f\u00b8\16\u00b8\u07d8\13\u00b8\3\u00b8"+
		"\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\7\u00b8\u07e0\n\u00b8\f\u00b8"+
		"\16\u00b8\u07e3\13\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\5\u00b8\u07f9\n\u00b8\3\u00b9"+
		"\3\u00b9\3\u00ba\3\u00ba\3\u00ba\3\u00ba\7\u00ba\u0801\n\u00ba\f\u00ba"+
		"\16\u00ba\u0804\13\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba"+
		"\7\u00ba\u080c\n\u00ba\f\u00ba\16\u00ba\u080f\13\u00ba\3\u00ba\3\u00ba"+
		"\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba"+
		"\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\5\u00ba"+
		"\u0824\n\u00ba\3\u00bb\3\u00bb\5\u00bb\u0828\n\u00bb\3\u00bb\7\u00bb\u082b"+
		"\n\u00bb\f\u00bb\16\u00bb\u082e\13\u00bb\3\u00bb\3\u00bb\3\u00bb\7\u00bb"+
		"\u0833\n\u00bb\f\u00bb\16\u00bb\u0836\13\u00bb\3\u00bb\7\u00bb\u0839\n"+
		"\u00bb\f\u00bb\16\u00bb\u083c\13\u00bb\3\u00bb\5\u00bb\u083f\n\u00bb\3"+
		"\u00bb\3\u00bb\5\u00bb\u0843\n\u00bb\3\u00bb\3\u00bb\5\u00bb\u0847\n\u00bb"+
		"\3\u00bb\3\u00bb\3\u00bb\3\u00bb\5\u00bb\u084d\n\u00bb\3\u00bb\7\u00bb"+
		"\u0850\n\u00bb\f\u00bb\16\u00bb\u0853\13\u00bb\3\u00bb\3\u00bb\5\u00bb"+
		"\u0857\n\u00bb\3\u00bb\3\u00bb\5\u00bb\u085b\n\u00bb\3\u00bb\3\u00bb\5"+
		"\u00bb\u085f\n\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\5\u00bb\u0865\n\u00bb"+
		"\3\u00bb\7\u00bb\u0868\n\u00bb\f\u00bb\16\u00bb\u086b\13\u00bb\3\u00bb"+
		"\3\u00bb\5\u00bb\u086f\n\u00bb\3\u00bb\3\u00bb\5\u00bb\u0873\n\u00bb\3"+
		"\u00bb\3\u00bb\5\u00bb\u0877\n\u00bb\5\u00bb\u0879\n\u00bb\3\u00bc\3\u00bc"+
		"\3\u00bc\5\u00bc\u087e\n\u00bc\3\u00bc\7\u00bc\u0881\n\u00bc\f\u00bc\16"+
		"\u00bc\u0884\13\u00bc\3\u00bc\3\u00bc\5\u00bc\u0888\n\u00bc\3\u00bc\3"+
		"\u00bc\5\u00bc\u088c\n\u00bc\3\u00bc\3\u00bc\5\u00bc\u0890\n\u00bc\3\u00bd"+
		"\3\u00bd\5\u00bd\u0894\n\u00bd\3\u00bd\7\u00bd\u0897\n\u00bd\f\u00bd\16"+
		"\u00bd\u089a\13\u00bd\3\u00bd\3\u00bd\3\u00bd\7\u00bd\u089f\n\u00bd\f"+
		"\u00bd\16\u00bd\u08a2\13\u00bd\3\u00bd\7\u00bd\u08a5\n\u00bd\f\u00bd\16"+
		"\u00bd\u08a8\13\u00bd\3\u00bd\5\u00bd\u08ab\n\u00bd\3\u00bd\3\u00bd\5"+
		"\u00bd\u08af\n\u00bd\3\u00bd\3\u00bd\5\u00bd\u08b3\n\u00bd\3\u00bd\3\u00bd"+
		"\3\u00bd\3\u00bd\5\u00bd\u08b9\n\u00bd\3\u00bd\7\u00bd\u08bc\n\u00bd\f"+
		"\u00bd\16\u00bd\u08bf\13\u00bd\3\u00bd\3\u00bd\5\u00bd\u08c3\n\u00bd\3"+
		"\u00bd\3\u00bd\5\u00bd\u08c7\n\u00bd\3\u00bd\3\u00bd\5\u00bd\u08cb\n\u00bd"+
		"\5\u00bd\u08cd\n\u00bd\3\u00be\3\u00be\3\u00be\5\u00be\u08d2\n\u00be\3"+
		"\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf"+
		"\3\u00bf\3\u00bf\3\u00bf\3\u00bf\5\u00bf\u08e1\n\u00bf\3\u00c0\3\u00c0"+
		"\3\u00c0\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\5\u00c1\u08ef\n\u00c1\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c2"+
		"\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c2\5\u00c2\u08fb\n\u00c2\3\u00c2"+
		"\3\u00c2\3\u00c2\3\u00c2\3\u00c2\7\u00c2\u0902\n\u00c2\f\u00c2\16\u00c2"+
		"\u0905\13\u00c2\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\3\u00c3\3\u00c3\7\u00c3\u0911\n\u00c3\f\u00c3\16\u00c3\u0914"+
		"\13\u00c3\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4"+
		"\3\u00c4\3\u00c4\5\u00c4\u0920\n\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4"+
		"\3\u00c4\7\u00c4\u0927\n\u00c4\f\u00c4\16\u00c4\u092a\13\u00c4\3\u00c5"+
		"\3\u00c5\3\u00c5\5\u00c5\u092f\n\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5"+
		"\3\u00c5\5\u00c5\u0936\n\u00c5\3\u00c5\3\u00c5\3\u00c5\5\u00c5\u093b\n"+
		"\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\5\u00c5\u0942\n\u00c5\3"+
		"\u00c5\3\u00c5\3\u00c5\5\u00c5\u0947\n\u00c5\3\u00c5\3\u00c5\3\u00c5\3"+
		"\u00c5\3\u00c5\5\u00c5\u094e\n\u00c5\3\u00c5\3\u00c5\3\u00c5\5\u00c5\u0953"+
		"\n\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\5\u00c5\u095a\n\u00c5"+
		"\3\u00c5\3\u00c5\3\u00c5\5\u00c5\u095f\n\u00c5\3\u00c5\3\u00c5\3\u00c5"+
		"\3\u00c5\3\u00c5\3\u00c5\5\u00c5\u0967\n\u00c5\3\u00c5\3\u00c5\3\u00c5"+
		"\5\u00c5\u096c\n\u00c5\3\u00c5\3\u00c5\5\u00c5\u0970\n\u00c5\3\u00c6\3"+
		"\u00c6\5\u00c6\u0974\n\u00c6\3\u00c6\3\u00c6\3\u00c6\5\u00c6\u0979\n\u00c6"+
		"\3\u00c6\3\u00c6\3\u00c7\3\u00c7\3\u00c7\5\u00c7\u0980\n\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c7\5\u00c7\u0987\n\u00c7\3\u00c7\3\u00c7"+
		"\3\u00c7\5\u00c7\u098c\n\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7"+
		"\5\u00c7\u0993\n\u00c7\3\u00c7\3\u00c7\3\u00c7\5\u00c7\u0998\n\u00c7\3"+
		"\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\5\u00c7\u099f\n\u00c7\3\u00c7\3"+
		"\u00c7\3\u00c7\5\u00c7\u09a4\n\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3"+
		"\u00c7\3\u00c7\5\u00c7\u09ac\n\u00c7\3\u00c7\3\u00c7\3\u00c7\5\u00c7\u09b1"+
		"\n\u00c7\3\u00c7\3\u00c7\5\u00c7\u09b5\n\u00c7\3\u00c8\3\u00c8\3\u00c8"+
		"\7\u00c8\u09ba\n\u00c8\f\u00c8\16\u00c8\u09bd\13\u00c8\3\u00c9\3\u00c9"+
		"\3\u00c9\5\u00c9\u09c2\n\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9"+
		"\5\u00c9\u09c9\n\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9"+
		"\u09d0\n\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9\u09d7\n"+
		"\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9\u09df\n"+
		"\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9\u09e6\n\u00c9\3"+
		"\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9\u09ee\n\u00c9\3"+
		"\u00ca\3\u00ca\5\u00ca\u09f2\n\u00ca\3\u00ca\3\u00ca\3\u00cb\3\u00cb\3"+
		"\u00cb\5\u00cb\u09f9\n\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5"+
		"\u00cb\u0a00\n\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u0a07"+
		"\n\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u0a0f"+
		"\n\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u0a16\n\u00cb"+
		"\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u0a1e\n\u00cb"+
		"\3\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0a24\n\u00cc\3\u00cc\3\u00cc"+
		"\3\u00cc\3\u00cc\5\u00cc\u0a2a\n\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc"+
		"\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0a36\n\u00cc"+
		"\3\u00cd\3\u00cd\7\u00cd\u0a3a\n\u00cd\f\u00cd\16\u00cd\u0a3d\13\u00cd"+
		"\3\u00ce\7\u00ce\u0a40\n\u00ce\f\u00ce\16\u00ce\u0a43\13\u00ce\3\u00ce"+
		"\3\u00ce\3\u00ce\3\u00ce\3\u00cf\3\u00cf\3\u00d0\3\u00d0\5\u00d0\u0a4d"+
		"\n\u00d0\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d2\3\u00d2\3\u00d2\5\u00d2"+
		"\u0a56\n\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\5\u00d2\u0a5d\n"+
		"\u00d2\3\u00d3\3\u00d3\3\u00d3\7\u00d3\u0a62\n\u00d3\f\u00d3\16\u00d3"+
		"\u0a65\13\u00d3\3\u00d4\3\u00d4\5\u00d4\u0a69\n\u00d4\3\u00d5\3\u00d5"+
		"\5\u00d5\u0a6d\n\u00d5\3\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d7\3\u00d7"+
		"\3\u00d7\5\u00d7\u0a76\n\u00d7\3\u00d8\3\u00d8\3\u00d9\3\u00d9\3\u00d9"+
		"\3\u00d9\3\u00d9\3\u00d9\3\u00d9\5\u00d9\u0a81\n\u00d9\3\u00da\3\u00da"+
		"\3\u00da\3\u00da\3\u00da\3\u00da\7\u00da\u0a89\n\u00da\f\u00da\16\u00da"+
		"\u0a8c\13\u00da\3\u00db\3\u00db\3\u00db\3\u00db\3\u00db\3\u00db\7\u00db"+
		"\u0a94\n\u00db\f\u00db\16\u00db\u0a97\13\u00db\3\u00dc\3\u00dc\3\u00dc"+
		"\3\u00dc\3\u00dc\3\u00dc\7\u00dc\u0a9f\n\u00dc\f\u00dc\16\u00dc\u0aa2"+
		"\13\u00dc\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd\7\u00dd\u0aaa"+
		"\n\u00dd\f\u00dd\16\u00dd\u0aad\13\u00dd\3\u00de\3\u00de\3\u00de\3\u00de"+
		"\3\u00de\3\u00de\7\u00de\u0ab5\n\u00de\f\u00de\16\u00de\u0ab8\13\u00de"+
		"\3\u00df\3\u00df\3\u00df\3\u00df\3\u00df\3\u00df\3\u00df\3\u00df\3\u00df"+
		"\7\u00df\u0ac3\n\u00df\f\u00df\16\u00df\u0ac6\13\u00df\3\u00e0\3\u00e0"+
		"\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0"+
		"\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\7\u00e0\u0ada"+
		"\n\u00e0\f\u00e0\16\u00e0\u0add\13\u00e0\3\u00e1\3\u00e1\3\u00e1\3\u00e1"+
		"\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1"+
		"\3\u00e1\3\u00e1\3\u00e1\7\u00e1\u0aef\n\u00e1\f\u00e1\16\u00e1\u0af2"+
		"\13\u00e1\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2"+
		"\3\u00e2\7\u00e2\u0afd\n\u00e2\f\u00e2\16\u00e2\u0b00\13\u00e2\3\u00e3"+
		"\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3"+
		"\3\u00e3\3\u00e3\7\u00e3\u0b0e\n\u00e3\f\u00e3\16\u00e3\u0b11\13\u00e3"+
		"\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\5\u00e4\u0b1a"+
		"\n\u00e4\3\u00e5\3\u00e5\3\u00e5\3\u00e6\3\u00e6\3\u00e6\3\u00e7\3\u00e7"+
		"\3\u00e7\3\u00e7\3\u00e7\3\u00e7\5\u00e7\u0b28\n\u00e7\3\u00e8\3\u00e8"+
		"\5\u00e8\u0b2c\n\u00e8\3\u00e8\3\u00e8\7\u00e8\u0b30\n\u00e8\f\u00e8\16"+
		"\u00e8\u0b33\13\u00e8\3\u00e9\3\u00e9\3\u00e9\3\u00ea\3\u00ea\3\u00eb"+
		"\3\u00eb\3\u00eb\3\u00ec\3\u00ec\3\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ed"+
		"\3\u00ed\3\u00ed\3\u00ed\7\u00ed\u0b47\n\u00ed\f\u00ed\16\u00ed\u0b4a"+
		"\13\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ed\7\u00ed\u0b52"+
		"\n\u00ed\f\u00ed\16\u00ed\u0b55\13\u00ed\3\u00ed\3\u00ed\3\u00ed\5\u00ed"+
		"\u0b5a\n\u00ed\3\u00ee\3\u00ee\3\u00ee\7\u00ee\u0b5f\n\u00ee\f\u00ee\16"+
		"\u00ee\u0b62\13\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\7\u00ee"+
		"\u0b69\n\u00ee\f\u00ee\16\u00ee\u0b6c\13\u00ee\3\u00ee\3\u00ee\3\u00ee"+
		"\5\u00ee\u0b71\n\u00ee\3\u00ef\3\u00ef\7\u00ef\u0b75\n\u00ef\f\u00ef\16"+
		"\u00ef\u0b78\13\u00ef\3\u00ef\7\u00ef\u0b7b\n\u00ef\f\u00ef\16\u00ef\u0b7e"+
		"\13\u00ef\3\u00ef\3\u00ef\3\u00ef\6\u00ef\u0b83\n\u00ef\r\u00ef\16\u00ef"+
		"\u0b84\3\u00ef\7\u00ef\u0b88\n\u00ef\f\u00ef\16\u00ef\u0b8b\13\u00ef\3"+
		"\u00ef\3\u00ef\5\u00ef\u0b8f\n\u00ef\3\u00f0\3\u00f0\3\u00f1\3\u00f1\6"+
		"\u00f1\u0b95\n\u00f1\r\u00f1\16\u00f1\u0b96\3\u00f1\3\u00f1\7\u00f1\u0b9b"+
		"\n\u00f1\f\u00f1\16\u00f1\u0b9e\13\u00f1\3\u00f2\3\u00f2\7\u00f2\u0ba2"+
		"\n\u00f2\f\u00f2\16\u00f2\u0ba5\13\u00f2\3\u00f2\3\u00f2\7\u00f2\u0ba9"+
		"\n\u00f2\f\u00f2\16\u00f2\u0bac\13\u00f2\5\u00f2\u0bae\n\u00f2\3\u00f3"+
		"\5\u00f3\u0bb1\n\u00f3\3\u00f3\6\u00f3\u0bb4\n\u00f3\r\u00f3\16\u00f3"+
		"\u0bb5\3\u00f3\3\u00f3\3\u00f3\7\u00f3\u0bbb\n\u00f3\f\u00f3\16\u00f3"+
		"\u0bbe\13\u00f3\3\u00f4\3\u00f4\3\u00f5\3\u00f5\5\u00f5\u0bc4\n\u00f5"+
		"\3\u00f6\3\u00f6\3\u00f6\6\u00f6\u0bc9\n\u00f6\r\u00f6\16\u00f6\u0bca"+
		"\3\u00f7\3\u00f7\3\u00f8\6\u00f8\u0bd0\n\u00f8\r\u00f8\16\u00f8\u0bd1"+
		"\3\u00f9\5\u00f9\u0bd5\n\u00f9\3\u00f9\3\u00f9\3\u00f9\5\u00f9\u0bda\n"+
		"\u00f9\3\u00f9\7\u00f9\u0bdd\n\u00f9\f\u00f9\16\u00f9\u0be0\13\u00f9\3"+
		"\u00fa\3\u00fa\3\u00fb\3\u00fb\3\u00fb\5\u00fb\u0be7\n\u00fb\3\u00fc\6"+
		"\u00fc\u0bea\n\u00fc\r\u00fc\16\u00fc\u0beb\3\u00fd\3\u00fd\3\u00fe\3"+
		"\u00fe\3\u00fe\7\u00fe\u0bf3\n\u00fe\f\u00fe\16\u00fe\u0bf6\13\u00fe\3"+
		"\u00fe\5\u00fe\u0bf9\n\u00fe\3\u00fe\3\u00fe\3\u00ff\3\u00ff\3\u0100\6"+
		"\u0100\u0c00\n\u0100\r\u0100\16\u0100\u0c01\3\u0101\3\u0101\7\u0101\u0c06"+
		"\n\u0101\f\u0101\16\u0101\u0c09\13\u0101\3\u0101\3\u0101\3\u0102\3\u0102"+
		"\3\u0102\7\u0102\u0c10\n\u0102\f\u0102\16\u0102\u0c13\13\u0102\3\u0102"+
		"\7\u0102\u0c16\n\u0102\f\u0102\16\u0102\u0c19\13\u0102\5\u0102\u0c1b\n"+
		"\u0102\3\u0103\3\u0103\3\u0103\2\17\648>\u01b2\u01b4\u01b6\u01b8\u01ba"+
		"\u01bc\u01be\u01c0\u01c2\u01c4\u0104\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"+
		"\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8"+
		"\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110"+
		"\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128"+
		"\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140"+
		"\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158"+
		"\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170"+
		"\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188"+
		"\u018a\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0"+
		"\u01a2\u01a4\u01a6\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2\u01b4\u01b6\u01b8"+
		"\u01ba\u01bc\u01be\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca\u01cc\u01ce\u01d0"+
		"\u01d2\u01d4\u01d6\u01d8\u01da\u01dc\u01de\u01e0\u01e2\u01e4\u01e6\u01e8"+
		"\u01ea\u01ec\u01ee\u01f0\u01f2\u01f4\u01f6\u01f8\u01fa\u01fc\u01fe\u0200"+
		"\u0202\u0204\2\n\3\2\65:\7\2\7\7\n\n\35\35\37\37\'\'\4\2\20\20\26\26\4"+
		"\2DD]g\3\2op\6\2=>UVnnqq\6\2=>UVnnpq\4\2UVnq\2\u0d23\2\u0206\3\2\2\2\4"+
		"\u0216\3\2\2\2\6\u021a\3\2\2\2\b\u021c\3\2\2\2\n\u021e\3\2\2\2\f\u0223"+
		"\3\2\2\2\16\u0227\3\2\2\2\20\u0246\3\2\2\2\22\u0248\3\2\2\2\24\u0256\3"+
		"\2\2\2\26\u025d\3\2\2\2\30\u025f\3\2\2\2\32\u0261\3\2\2\2\34\u0266\3\2"+
		"\2\2\36\u0274\3\2\2\2 \u0279\3\2\2\2\"\u028e\3\2\2\2$\u0295\3\2\2\2&\u02a1"+
		"\3\2\2\2(\u02a3\3\2\2\2*\u02a6\3\2\2\2,\u02aa\3\2\2\2.\u02b4\3\2\2\2\60"+
		"\u02b9\3\2\2\2\62\u02c4\3\2\2\2\64\u02c6\3\2\2\2\66\u02d6\3\2\2\28\u02d8"+
		"\3\2\2\2:\u02e8\3\2\2\2<\u02ea\3\2\2\2>\u02ec\3\2\2\2@\u02f8\3\2\2\2B"+
		"\u030b\3\2\2\2D\u0312\3\2\2\2F\u0318\3\2\2\2H\u031a\3\2\2\2J\u031e\3\2"+
		"\2\2L\u0324\3\2\2\2N\u032b\3\2\2\2P\u0335\3\2\2\2R\u0339\3\2\2\2T\u033e"+
		"\3\2\2\2V\u0356\3\2\2\2X\u0358\3\2\2\2Z\u035c\3\2\2\2\\\u0364\3\2\2\2"+
		"^\u0367\3\2\2\2`\u036a\3\2\2\2b\u0372\3\2\2\2d\u037f\3\2\2\2f\u0386\3"+
		"\2\2\2h\u038b\3\2\2\2j\u03a0\3\2\2\2l\u03a2\3\2\2\2n\u03aa\3\2\2\2p\u03af"+
		"\3\2\2\2r\u03b5\3\2\2\2t\u03b9\3\2\2\2v\u03bd\3\2\2\2x\u03c2\3\2\2\2z"+
		"\u03c6\3\2\2\2|\u03df\3\2\2\2~\u03e1\3\2\2\2\u0080\u03ec\3\2\2\2\u0082"+
		"\u03f0\3\2\2\2\u0084\u03f2\3\2\2\2\u0086\u03f4\3\2\2\2\u0088\u03f6\3\2"+
		"\2\2\u008a\u0401\3\2\2\2\u008c\u0406\3\2\2\2\u008e\u041c\3\2\2\2\u0090"+
		"\u042f\3\2\2\2\u0092\u0433\3\2\2\2\u0094\u0435\3\2\2\2\u0096\u0444\3\2"+
		"\2\2\u0098\u0456\3\2\2\2\u009a\u045b\3\2\2\2\u009c\u0463\3\2\2\2\u009e"+
		"\u0476\3\2\2\2\u00a0\u047b\3\2\2\2\u00a2\u0485\3\2\2\2\u00a4\u0488\3\2"+
		"\2\2\u00a6\u0492\3\2\2\2\u00a8\u0496\3\2\2\2\u00aa\u0498\3\2\2\2\u00ac"+
		"\u049a\3\2\2\2\u00ae\u04a0\3\2\2\2\u00b0\u04ad\3\2\2\2\u00b2\u04b0\3\2"+
		"\2\2\u00b4\u04b9\3\2\2\2\u00b6\u04bb\3\2\2\2\u00b8\u04f2\3\2\2\2\u00ba"+
		"\u04f7\3\2\2\2\u00bc\u0501\3\2\2\2\u00be\u050d\3\2\2\2\u00c0\u0518\3\2"+
		"\2\2\u00c2\u0526\3\2\2\2\u00c4\u0528\3\2\2\2\u00c6\u0531\3\2\2\2\u00c8"+
		"\u0536\3\2\2\2\u00ca\u054a\3\2\2\2\u00cc\u054c\3\2\2\2\u00ce\u054f\3\2"+
		"\2\2\u00d0\u055d\3\2\2\2\u00d2\u0562\3\2\2\2\u00d4\u056d\3\2\2\2\u00d6"+
		"\u0572\3\2\2\2\u00d8\u0584\3\2\2\2\u00da\u0589\3\2\2\2\u00dc\u0591\3\2"+
		"\2\2\u00de\u059f\3\2\2\2\u00e0\u05a4\3\2\2\2\u00e2\u05b6\3\2\2\2\u00e4"+
		"\u05b8\3\2\2\2\u00e6\u05be\3\2\2\2\u00e8\u05c0\3\2\2\2\u00ea\u05c8\3\2"+
		"\2\2\u00ec\u05d0\3\2\2\2\u00ee\u05d7\3\2\2\2\u00f0\u05d9\3\2\2\2\u00f2"+
		"\u05e2\3\2\2\2\u00f4\u05ea\3\2\2\2\u00f6\u05ed\3\2\2\2\u00f8\u05f3\3\2"+
		"\2\2\u00fa\u05fc\3\2\2\2\u00fc\u0604\3\2\2\2\u00fe\u060b\3\2\2\2\u0100"+
		"\u0612\3\2\2\2\u0102\u0614\3\2\2\2\u0104\u061a\3\2\2\2\u0106\u0626\3\2"+
		"\2\2\u0108\u062d\3\2\2\2\u010a\u063b\3\2\2\2\u010c\u063d\3\2\2\2\u010e"+
		"\u063f\3\2\2\2\u0110\u0643\3\2\2\2\u0112\u0647\3\2\2\2\u0114\u0651\3\2"+
		"\2\2\u0116\u0653\3\2\2\2\u0118\u0659\3\2\2\2\u011a\u0661\3\2\2\2\u011c"+
		"\u0673\3\2\2\2\u011e\u0675\3\2\2\2\u0120\u067b\3\2\2\2\u0122\u068a\3\2"+
		"\2\2\u0124\u068d\3\2\2\2\u0126\u069e\3\2\2\2\u0128\u06a0\3\2\2\2\u012a"+
		"\u06a2\3\2\2\2\u012c\u06a8\3\2\2\2\u012e\u06ae\3\2\2\2\u0130\u06b8\3\2"+
		"\2\2\u0132\u06bc\3\2\2\2\u0134\u06be\3\2\2\2\u0136\u06ce\3\2\2\2\u0138"+
		"\u06e0\3\2\2\2\u013a\u06e2\3\2\2\2\u013c\u06e4\3\2\2\2\u013e\u06ec\3\2"+
		"\2\2\u0140\u06fb\3\2\2\2\u0142\u070a\3\2\2\2\u0144\u0710\3\2\2\2\u0146"+
		"\u0716\3\2\2\2\u0148\u071c\3\2\2\2\u014a\u0720\3\2\2\2\u014c\u0732\3\2"+
		"\2\2\u014e\u0734\3\2\2\2\u0150\u073b\3\2\2\2\u0152\u0744\3\2\2\2\u0154"+
		"\u074a\3\2\2\2\u0156\u0752\3\2\2\2\u0158\u0755\3\2\2\2\u015a\u075e\3\2"+
		"\2\2\u015c\u0765\3\2\2\2\u015e\u0770\3\2\2\2\u0160\u077a\3\2\2\2\u0162"+
		"\u079f\3\2\2\2\u0164\u07a1\3\2\2\2\u0166\u07bf\3\2\2\2\u0168\u07c6\3\2"+
		"\2\2\u016a\u07c8\3\2\2\2\u016c\u07ce\3\2\2\2\u016e\u07f8\3\2\2\2\u0170"+
		"\u07fa\3\2\2\2\u0172\u0823\3\2\2\2\u0174\u0878\3\2\2\2\u0176\u087a\3\2"+
		"\2\2\u0178\u08cc\3\2\2\2\u017a\u08d1\3\2\2\2\u017c\u08e0\3\2\2\2\u017e"+
		"\u08e2\3\2\2\2\u0180\u08ee\3\2\2\2\u0182\u08fa\3\2\2\2\u0184\u0906\3\2"+
		"\2\2\u0186\u091f\3\2\2\2\u0188\u096f\3\2\2\2\u018a\u0971\3\2\2\2\u018c"+
		"\u09b4\3\2\2\2\u018e\u09b6\3\2\2\2\u0190\u09ed\3\2\2\2\u0192\u09ef\3\2"+
		"\2\2\u0194\u0a1d\3\2\2\2\u0196\u0a35\3\2\2\2\u0198\u0a37\3\2\2\2\u019a"+
		"\u0a41\3\2\2\2\u019c\u0a48\3\2\2\2\u019e\u0a4c\3\2\2\2\u01a0\u0a4e\3\2"+
		"\2\2\u01a2\u0a5c\3\2\2\2\u01a4\u0a5e\3\2\2\2\u01a6\u0a68\3\2\2\2\u01a8"+
		"\u0a6c\3\2\2\2\u01aa\u0a6e\3\2\2\2\u01ac\u0a75\3\2\2\2\u01ae\u0a77\3\2"+
		"\2\2\u01b0\u0a80\3\2\2\2\u01b2\u0a82\3\2\2\2\u01b4\u0a8d\3\2\2\2\u01b6"+
		"\u0a98\3\2\2\2\u01b8\u0aa3\3\2\2\2\u01ba\u0aae\3\2\2\2\u01bc\u0ab9\3\2"+
		"\2\2\u01be\u0ac7\3\2\2\2\u01c0\u0ade\3\2\2\2\u01c2\u0af3\3\2\2\2\u01c4"+
		"\u0b01\3\2\2\2\u01c6\u0b19\3\2\2\2\u01c8\u0b1b\3\2\2\2\u01ca\u0b1e\3\2"+
		"\2\2\u01cc\u0b27\3\2\2\2\u01ce\u0b2b\3\2\2\2\u01d0\u0b34\3\2\2\2\u01d2"+
		"\u0b37\3\2\2\2\u01d4\u0b39\3\2\2\2\u01d6\u0b3c\3\2\2\2\u01d8\u0b59\3\2"+
		"\2\2\u01da\u0b70\3\2\2\2\u01dc\u0b8e\3\2\2\2\u01de\u0b90\3\2\2\2\u01e0"+
		"\u0b92\3\2\2\2\u01e2\u0bad\3\2\2\2\u01e4\u0bb0\3\2\2\2\u01e6\u0bbf\3\2"+
		"\2\2\u01e8\u0bc3\3\2\2\2\u01ea\u0bc8\3\2\2\2\u01ec\u0bcc\3\2\2\2\u01ee"+
		"\u0bcf\3\2\2\2\u01f0\u0bd4\3\2\2\2\u01f2\u0be1\3\2\2\2\u01f4\u0be6\3\2"+
		"\2\2\u01f6\u0be9\3\2\2\2\u01f8\u0bed\3\2\2\2\u01fa\u0bef\3\2\2\2\u01fc"+
		"\u0bfc\3\2\2\2\u01fe\u0bff\3\2\2\2\u0200\u0c03\3\2\2\2\u0202\u0c1a\3\2"+
		"\2\2\u0204\u0c1c\3\2\2\2\u0206\u0207\t\2\2\2\u0207\3\3\2\2\2\u0208\u020a"+
		"\5\u00e6t\2\u0209\u0208\3\2\2\2\u020a\u020d\3\2\2\2\u020b\u0209\3\2\2"+
		"\2\u020b\u020c\3\2\2\2\u020c\u020e\3\2\2\2\u020d\u020b\3\2\2\2\u020e\u0217"+
		"\5\6\4\2\u020f\u0211\5\u00e6t\2\u0210\u020f\3\2\2\2\u0211\u0214\3\2\2"+
		"\2\u0212\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0215\3\2\2\2\u0214\u0212"+
		"\3\2\2\2\u0215\u0217\7\5\2\2\u0216\u020b\3\2\2\2\u0216\u0212\3\2\2\2\u0217"+
		"\5\3\2\2\2\u0218\u021b\5\b\5\2\u0219\u021b\5\n\6\2\u021a\u0218\3\2\2\2"+
		"\u021a\u0219\3\2\2\2\u021b\7\3\2\2\2\u021c\u021d\t\3\2\2\u021d\t\3\2\2"+
		"\2\u021e\u021f\t\4\2\2\u021f\13\3\2\2\2\u0220\u0224\5\16\b\2\u0221\u0224"+
		"\5\34\17\2\u0222\u0224\5\36\20\2\u0223\u0220\3\2\2\2\u0223\u0221\3\2\2"+
		"\2\u0223\u0222\3\2\2\2\u0224\r\3\2\2\2\u0225\u0228\5\24\13\2\u0226\u0228"+
		"\5\32\16\2\u0227\u0225\3\2\2\2\u0227\u0226\3\2\2\2\u0228\u022d\3\2\2\2"+
		"\u0229\u022c\5\22\n\2\u022a\u022c\5\30\r\2\u022b\u0229\3\2\2\2\u022b\u022a"+
		"\3\2\2\2\u022c\u022f\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e"+
		"\17\3\2\2\2\u022f\u022d\3\2\2\2\u0230\u0232\5\u00e6t\2\u0231\u0230\3\2"+
		"\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234"+
		"\u0236\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u0238\7h\2\2\u0237\u0239\5*\26"+
		"\2\u0238\u0237\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u0247\3\2\2\2\u023a\u023b"+
		"\5\16\b\2\u023b\u023f\7C\2\2\u023c\u023e\5\u00e6t\2\u023d\u023c\3\2\2"+
		"\2\u023e\u0241\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0242"+
		"\3\2\2\2\u0241\u023f\3\2\2\2\u0242\u0244\7h\2\2\u0243\u0245\5*\26\2\u0244"+
		"\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247\3\2\2\2\u0246\u0233\3\2"+
		"\2\2\u0246\u023a\3\2\2\2\u0247\21\3\2\2\2\u0248\u024c\7C\2\2\u0249\u024b"+
		"\5\u00e6t\2\u024a\u0249\3\2\2\2\u024b\u024e\3\2\2\2\u024c\u024a\3\2\2"+
		"\2\u024c\u024d\3\2\2\2\u024d\u024f\3\2\2\2\u024e\u024c\3\2\2\2\u024f\u0251"+
		"\7h\2\2\u0250\u0252\5*\26\2\u0251\u0250\3\2\2\2\u0251\u0252\3\2\2\2\u0252"+
		"\23\3\2\2\2\u0253\u0255\5\u00e6t\2\u0254\u0253\3\2\2\2\u0255\u0258\3\2"+
		"\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0259\3\2\2\2\u0258"+
		"\u0256\3\2\2\2\u0259\u025b\7h\2\2\u025a\u025c\5*\26\2\u025b\u025a\3\2"+
		"\2\2\u025b\u025c\3\2\2\2\u025c\25\3\2\2\2\u025d\u025e\5\20\t\2\u025e\27"+
		"\3\2\2\2\u025f\u0260\5\22\n\2\u0260\31\3\2\2\2\u0261\u0262\5\24\13\2\u0262"+
		"\33\3\2\2\2\u0263\u0265\5\u00e6t\2\u0264\u0263\3\2\2\2\u0265\u0268\3\2"+
		"\2\2\u0266\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2\2\2\u0268"+
		"\u0266\3\2\2\2\u0269\u026a\7h\2\2\u026a\35\3\2\2\2\u026b\u026c\5\4\3\2"+
		"\u026c\u026d\5 \21\2\u026d\u0275\3\2\2\2\u026e\u026f\5\16\b\2\u026f\u0270"+
		"\5 \21\2\u0270\u0275\3\2\2\2\u0271\u0272\5\34\17\2\u0272\u0273\5 \21\2"+
		"\u0273\u0275\3\2\2\2\u0274\u026b\3\2\2\2\u0274\u026e\3\2\2\2\u0274\u0271"+
		"\3\2\2\2\u0275\37\3\2\2\2\u0276\u0278\5\u00e6t\2\u0277\u0276\3\2\2\2\u0278"+
		"\u027b\3\2\2\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027c\3\2"+
		"\2\2\u027b\u0279\3\2\2\2\u027c\u027d\7?\2\2\u027d\u0288\7@\2\2\u027e\u0280"+
		"\5\u00e6t\2\u027f\u027e\3\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2"+
		"\2\u0281\u0282\3\2\2\2\u0282\u0284\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u0285"+
		"\7?\2\2\u0285\u0287\7@\2\2\u0286\u0281\3\2\2\2\u0287\u028a\3\2\2\2\u0288"+
		"\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289!\3\2\2\2\u028a\u0288\3\2\2\2"+
		"\u028b\u028d\5$\23\2\u028c\u028b\3\2\2\2\u028d\u0290\3\2\2\2\u028e\u028c"+
		"\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0291\3\2\2\2\u0290\u028e\3\2\2\2\u0291"+
		"\u0293\7h\2\2\u0292\u0294\5&\24\2\u0293\u0292\3\2\2\2\u0293\u0294\3\2"+
		"\2\2\u0294#\3\2\2\2\u0295\u0296\5\u00e6t\2\u0296%\3\2\2\2\u0297\u0298"+
		"\7\23\2\2\u0298\u02a2\5\34\17\2\u0299\u029a\7\23\2\2\u029a\u029e\5\16"+
		"\b\2\u029b\u029d\5(\25\2\u029c\u029b\3\2\2\2\u029d\u02a0\3\2\2\2\u029e"+
		"\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0\u029e\3\2"+
		"\2\2\u02a1\u0297\3\2\2\2\u02a1\u0299\3\2\2\2\u02a2\'\3\2\2\2\u02a3\u02a4"+
		"\7W\2\2\u02a4\u02a5\5\26\f\2\u02a5)\3\2\2\2\u02a6\u02a7\7F\2\2\u02a7\u02a8"+
		"\5,\27\2\u02a8\u02a9\7E\2\2\u02a9+\3\2\2\2\u02aa\u02af\5.\30\2\u02ab\u02ac"+
		"\7B\2\2\u02ac\u02ae\5.\30\2\u02ad\u02ab\3\2\2\2\u02ae\u02b1\3\2\2\2\u02af"+
		"\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0-\3\2\2\2\u02b1\u02af\3\2\2\2"+
		"\u02b2\u02b5\5\f\7\2\u02b3\u02b5\5\60\31\2\u02b4\u02b2\3\2\2\2\u02b4\u02b3"+
		"\3\2\2\2\u02b5/\3\2\2\2\u02b6\u02b8\5\u00e6t\2\u02b7\u02b6\3\2\2\2\u02b8"+
		"\u02bb\3\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bc\3\2"+
		"\2\2\u02bb\u02b9\3\2\2\2\u02bc\u02be\7I\2\2\u02bd\u02bf\5\62\32\2\u02be"+
		"\u02bd\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\61\3\2\2\2\u02c0\u02c1\7\23\2"+
		"\2\u02c1\u02c5\5\f\7\2\u02c2\u02c3\7*\2\2\u02c3\u02c5\5\f\7\2\u02c4\u02c0"+
		"\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c5\63\3\2\2\2\u02c6\u02c7\b\33\1\2\u02c7"+
		"\u02c8\7h\2\2\u02c8\u02ce\3\2\2\2\u02c9\u02ca\f\3\2\2\u02ca\u02cb\7C\2"+
		"\2\u02cb\u02cd\7h\2\2\u02cc\u02c9\3\2\2\2\u02cd\u02d0\3\2\2\2\u02ce\u02cc"+
		"\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\65\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d1"+
		"\u02d7\7h\2\2\u02d2\u02d3\58\35\2\u02d3\u02d4\7C\2\2\u02d4\u02d5\7h\2"+
		"\2\u02d5\u02d7\3\2\2\2\u02d6\u02d1\3\2\2\2\u02d6\u02d2\3\2\2\2\u02d7\67"+
		"\3\2\2\2\u02d8\u02d9\b\35\1\2\u02d9\u02da\7h\2\2\u02da\u02e0\3\2\2\2\u02db"+
		"\u02dc\f\3\2\2\u02dc\u02dd\7C\2\2\u02dd\u02df\7h\2\2\u02de\u02db\3\2\2"+
		"\2\u02df\u02e2\3\2\2\2\u02e0\u02de\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e19"+
		"\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e3\u02e9\7h\2\2\u02e4\u02e5\5> \2\u02e5"+
		"\u02e6\7C\2\2\u02e6\u02e7\7h\2\2\u02e7\u02e9\3\2\2\2\u02e8\u02e3\3\2\2"+
		"\2\u02e8\u02e4\3\2\2\2\u02e9;\3\2\2\2\u02ea\u02eb\7h\2\2\u02eb=\3\2\2"+
		"\2\u02ec\u02ed\b \1\2\u02ed\u02ee\7h\2\2\u02ee\u02f4\3\2\2\2\u02ef\u02f0"+
		"\f\3\2\2\u02f0\u02f1\7C\2\2\u02f1\u02f3\7h\2\2\u02f2\u02ef\3\2\2\2\u02f3"+
		"\u02f6\3\2\2\2\u02f4\u02f2\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5?\3\2\2\2"+
		"\u02f6\u02f4\3\2\2\2\u02f7\u02f9\5B\"\2\u02f8\u02f7\3\2\2\2\u02f8\u02f9"+
		"\3\2\2\2\u02f9\u02fd\3\2\2\2\u02fa\u02fc\5F$\2\u02fb\u02fa\3\2\2\2\u02fc"+
		"\u02ff\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0303\3\2"+
		"\2\2\u02ff\u02fd\3\2\2\2\u0300\u0302\5P)\2\u0301\u0300\3\2\2\2\u0302\u0305"+
		"\3\2\2\2\u0303\u0301\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0306\3\2\2\2\u0305"+
		"\u0303\3\2\2\2\u0306\u0307\7\2\2\3\u0307A\3\2\2\2\u0308\u030a\5D#\2\u0309"+
		"\u0308\3\2\2\2\u030a\u030d\3\2\2\2\u030b\u0309\3\2\2\2\u030b\u030c\3\2"+
		"\2\2\u030c\u030e\3\2\2\2\u030d\u030b\3\2\2\2\u030e\u030f\7\"\2\2\u030f"+
		"\u0310\5\64\33\2\u0310\u0311\7A\2\2\u0311C\3\2\2\2\u0312\u0313\5\u00e6"+
		"t\2\u0313E\3\2\2\2\u0314\u0319\5H%\2\u0315\u0319\5J&\2\u0316\u0319\5L"+
		"\'\2\u0317\u0319\5N(\2\u0318\u0314\3\2\2\2\u0318\u0315\3\2\2\2\u0318\u0316"+
		"\3\2\2\2\u0318\u0317\3\2\2\2\u0319G\3\2\2\2\u031a\u031b\7\33\2\2\u031b"+
		"\u031c\5\66\34\2\u031c\u031d\7A\2\2\u031dI\3\2\2\2\u031e\u031f\7\33\2"+
		"\2\u031f\u0320\58\35\2\u0320\u0321\7C\2\2\u0321\u0322\7U\2\2\u0322\u0323"+
		"\7A\2\2\u0323K\3\2\2\2\u0324\u0325\7\33\2\2\u0325\u0326\7(\2\2\u0326\u0327"+
		"\5\66\34\2\u0327\u0328\7C\2\2\u0328\u0329\7h\2\2\u0329\u032a\7A\2\2\u032a"+
		"M\3\2\2\2\u032b\u032c\7\33\2\2\u032c\u032d\7(\2\2\u032d\u032e\5\66\34"+
		"\2\u032e\u032f\7C\2\2\u032f\u0330\7U\2\2\u0330\u0331\7A\2\2\u0331O\3\2"+
		"\2\2\u0332\u0336\5R*\2\u0333\u0336\5\u00c6d\2\u0334\u0336\7A\2\2\u0335"+
		"\u0332\3\2\2\2\u0335\u0333\3\2\2\2\u0335\u0334\3\2\2\2\u0336Q\3\2\2\2"+
		"\u0337\u033a\5T+\2\u0338\u033a\5\u00ba^\2\u0339\u0337\3\2\2\2\u0339\u0338"+
		"\3\2\2\2\u033aS\3\2\2\2\u033b\u033d\5V,\2\u033c\u033b\3\2\2\2\u033d\u0340"+
		"\3\2\2\2\u033e\u033c\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0341\3\2\2\2\u0340"+
		"\u033e\3\2\2\2\u0341\u0342\7\13\2\2\u0342\u0344\7h\2\2\u0343\u0345\5X"+
		"-\2\u0344\u0343\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0347\3\2\2\2\u0346"+
		"\u0348\5\\/\2\u0347\u0346\3\2\2\2\u0347\u0348\3\2\2\2\u0348\u034a\3\2"+
		"\2\2\u0349\u034b\5^\60\2\u034a\u0349\3\2\2\2\u034a\u034b\3\2\2\2\u034b"+
		"\u034c\3\2\2\2\u034c\u034d\5b\62\2\u034dU\3\2\2\2\u034e\u0357\5\u00e6"+
		"t\2\u034f\u0357\7%\2\2\u0350\u0357\7$\2\2\u0351\u0357\7#\2\2\u0352\u0357"+
		"\7\3\2\2\u0353\u0357\7(\2\2\u0354\u0357\7\24\2\2\u0355\u0357\7)\2\2\u0356"+
		"\u034e\3\2\2\2\u0356\u034f\3\2\2\2\u0356\u0350\3\2\2\2\u0356\u0351\3\2"+
		"\2\2\u0356\u0352\3\2\2\2\u0356\u0353\3\2\2\2\u0356\u0354\3\2\2\2\u0356"+
		"\u0355\3\2\2\2\u0357W\3\2\2\2\u0358\u0359\7F\2\2\u0359\u035a\5Z.\2\u035a"+
		"\u035b\7E\2\2\u035bY\3\2\2\2\u035c\u0361\5\"\22\2\u035d\u035e\7B\2\2\u035e"+
		"\u0360\5\"\22\2\u035f\u035d\3\2\2\2\u0360\u0363\3\2\2\2\u0361\u035f\3"+
		"\2\2\2\u0361\u0362\3\2\2\2\u0362[\3\2\2\2\u0363\u0361\3\2\2\2\u0364\u0365"+
		"\7\23\2\2\u0365\u0366\5\20\t\2\u0366]\3\2\2\2\u0367\u0368\7\32\2\2\u0368"+
		"\u0369\5`\61\2\u0369_\3\2\2\2\u036a\u036f\5\26\f\2\u036b\u036c\7B\2\2"+
		"\u036c\u036e\5\26\f\2\u036d\u036b\3\2\2\2\u036e\u0371\3\2\2\2\u036f\u036d"+
		"\3\2\2\2\u036f\u0370\3\2\2\2\u0370a\3\2\2\2\u0371\u036f\3\2\2\2\u0372"+
		"\u0376\7=\2\2\u0373\u0375\5d\63\2\u0374\u0373\3\2\2\2\u0375\u0378\3\2"+
		"\2\2\u0376\u0374\3\2\2\2\u0376\u0377\3\2\2\2\u0377\u0379\3\2\2\2\u0378"+
		"\u0376\3\2\2\2\u0379\u037a\7>\2\2\u037ac\3\2\2\2\u037b\u0380\5f\64\2\u037c"+
		"\u0380\5\u00aaV\2\u037d\u0380\5\u00acW\2\u037e\u0380\5\u00aeX\2\u037f"+
		"\u037b\3\2\2\2\u037f\u037c\3\2\2\2\u037f\u037d\3\2\2\2\u037f\u037e\3\2"+
		"\2\2\u0380e\3\2\2\2\u0381\u0387\5h\65\2\u0382\u0387\5\u008cG\2\u0383\u0387"+
		"\5R*\2\u0384\u0387\5\u00c6d\2\u0385\u0387\7A\2\2\u0386\u0381\3\2\2\2\u0386"+
		"\u0382\3\2\2\2\u0386\u0383\3\2\2\2\u0386\u0384\3\2\2\2\u0386\u0385\3\2"+
		"\2\2\u0387g\3\2\2\2\u0388\u038a\5\u01da\u00ee\2\u0389\u0388\3\2\2\2\u038a"+
		"\u038d\3\2\2\2\u038b\u0389\3\2\2\2\u038b\u038c\3\2\2\2\u038c\u0391\3\2"+
		"\2\2\u038d\u038b\3\2\2\2\u038e\u0390\5j\66\2\u038f\u038e\3\2\2\2\u0390"+
		"\u0393\3\2\2\2\u0391\u038f\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0394\3\2"+
		"\2\2\u0393\u0391\3\2\2\2\u0394\u0395\5t;\2\u0395\u0396\5l\67\2\u0396\u0397"+
		"\7A\2\2\u0397i\3\2\2\2\u0398\u03a1\5\u00e6t\2\u0399\u03a1\7%\2\2\u039a"+
		"\u03a1\7$\2\2\u039b\u03a1\7#\2\2\u039c\u03a1\7(\2\2\u039d\u03a1\7\24\2"+
		"\2\u039e\u03a1\7\60\2\2\u039f\u03a1\7\63\2\2\u03a0\u0398\3\2\2\2\u03a0"+
		"\u0399\3\2\2\2\u03a0\u039a\3\2\2\2\u03a0\u039b\3\2\2\2\u03a0\u039c\3\2"+
		"\2\2\u03a0\u039d\3\2\2\2\u03a0\u039e\3\2\2\2\u03a0\u039f\3\2\2\2\u03a1"+
		"k\3\2\2\2\u03a2\u03a7\5n8\2\u03a3\u03a4\7B\2\2\u03a4\u03a6\5n8\2\u03a5"+
		"\u03a3\3\2\2\2\u03a6\u03a9\3\2\2\2\u03a7\u03a5\3\2\2\2\u03a7\u03a8\3\2"+
		"\2\2\u03a8m\3\2\2\2\u03a9\u03a7\3\2\2\2\u03aa\u03ad\5p9\2\u03ab\u03ac"+
		"\7D\2\2\u03ac\u03ae\5r:\2\u03ad\u03ab\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae"+
		"o\3\2\2\2\u03af\u03b1\7h\2\2\u03b0\u03b2\5 \21\2\u03b1\u03b0\3\2\2\2\u03b1"+
		"\u03b2\3\2\2\2\u03b2q\3\2\2\2\u03b3\u03b6\5\u019e\u00d0\2\u03b4\u03b6"+
		"\5\u00f8}\2\u03b5\u03b3\3\2\2\2\u03b5\u03b4\3\2\2\2\u03b6s\3\2\2\2\u03b7"+
		"\u03ba\5v<\2\u03b8\u03ba\5x=\2\u03b9\u03b7\3\2\2\2\u03b9\u03b8\3\2\2\2"+
		"\u03bau\3\2\2\2\u03bb\u03be\5\6\4\2\u03bc\u03be\7\5\2\2\u03bd\u03bb\3"+
		"\2\2\2\u03bd\u03bc\3\2\2\2\u03bew\3\2\2\2\u03bf\u03c3\5z>\2\u03c0\u03c3"+
		"\5\u0088E\2\u03c1\u03c3\5\u008aF\2\u03c2\u03bf\3\2\2\2\u03c2\u03c0\3\2"+
		"\2\2\u03c2\u03c1\3\2\2\2\u03c3y\3\2\2\2\u03c4\u03c7\5\u0080A\2\u03c5\u03c7"+
		"\5\u0086D\2\u03c6\u03c4\3\2\2\2\u03c6\u03c5\3\2\2\2\u03c7\u03cc\3\2\2"+
		"\2\u03c8\u03cb\5~@\2\u03c9\u03cb\5\u0084C\2\u03ca\u03c8\3\2\2\2\u03ca"+
		"\u03c9\3\2\2\2\u03cb\u03ce\3\2\2\2\u03cc\u03ca\3\2\2\2\u03cc\u03cd\3\2"+
		"\2\2\u03cd{\3\2\2\2\u03ce\u03cc\3\2\2\2\u03cf\u03d1\7h\2\2\u03d0\u03d2"+
		"\5*\26\2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03e0\3\2\2\2\u03d3"+
		"\u03d4\5z>\2\u03d4\u03d8\7C\2\2\u03d5\u03d7\5\u00e6t\2\u03d6\u03d5\3\2"+
		"\2\2\u03d7\u03da\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9"+
		"\u03db\3\2\2\2\u03da\u03d8\3\2\2\2\u03db\u03dd\7h\2\2\u03dc\u03de\5*\26"+
		"\2\u03dd\u03dc\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03e0\3\2\2\2\u03df\u03cf"+
		"\3\2\2\2\u03df\u03d3\3\2\2\2\u03e0}\3\2\2\2\u03e1\u03e5\7C\2\2\u03e2\u03e4"+
		"\5\u00e6t\2\u03e3\u03e2\3\2\2\2\u03e4\u03e7\3\2\2\2\u03e5\u03e3\3\2\2"+
		"\2\u03e5\u03e6\3\2\2\2\u03e6\u03e8\3\2\2\2\u03e7\u03e5\3\2\2\2\u03e8\u03ea"+
		"\7h\2\2\u03e9\u03eb\5*\26\2\u03ea\u03e9\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb"+
		"\177\3\2\2\2\u03ec\u03ee\7h\2\2\u03ed\u03ef\5*\26\2\u03ee\u03ed\3\2\2"+
		"\2\u03ee\u03ef\3\2\2\2\u03ef\u0081\3\2\2\2\u03f0\u03f1\5|?\2\u03f1\u0083"+
		"\3\2\2\2\u03f2\u03f3\5~@\2\u03f3\u0085\3\2\2\2\u03f4\u03f5\5\u0080A\2"+
		"\u03f5\u0087\3\2\2\2\u03f6\u03f7\7h\2\2\u03f7\u0089\3\2\2\2\u03f8\u03f9"+
		"\5v<\2\u03f9\u03fa\5 \21\2\u03fa\u0402\3\2\2\2\u03fb\u03fc\5z>\2\u03fc"+
		"\u03fd\5 \21\2\u03fd\u0402\3\2\2\2\u03fe\u03ff\5\u0088E\2\u03ff\u0400"+
		"\5 \21\2\u0400\u0402\3\2\2\2\u0401\u03f8\3\2\2\2\u0401\u03fb\3\2\2\2\u0401"+
		"\u03fe\3\2\2\2\u0402\u008b\3\2\2\2\u0403\u0405\5\u01da\u00ee\2\u0404\u0403"+
		"\3\2\2\2\u0405\u0408\3\2\2\2\u0406\u0404\3\2\2\2\u0406\u0407\3\2\2\2\u0407"+
		"\u040c\3\2\2\2\u0408\u0406\3\2\2\2\u0409\u040b\5\u008eH\2\u040a\u0409"+
		"\3\2\2\2\u040b\u040e\3\2\2\2\u040c\u040a\3\2\2\2\u040c\u040d\3\2\2\2\u040d"+
		"\u040f\3\2\2\2\u040e\u040c\3\2\2\2\u040f\u0410\5\u0090I\2\u0410\u0411"+
		"\5\u00a8U\2\u0411\u008d\3\2\2\2\u0412\u041d\5\u00e6t\2\u0413\u041d\7%"+
		"\2\2\u0414\u041d\7$\2\2\u0415\u041d\7#\2\2\u0416\u041d\7\3\2\2\u0417\u041d"+
		"\7(\2\2\u0418\u041d\7\24\2\2\u0419\u041d\7,\2\2\u041a\u041d\7 \2\2\u041b"+
		"\u041d\7)\2\2\u041c\u0412\3\2\2\2\u041c\u0413\3\2\2\2\u041c\u0414\3\2"+
		"\2\2\u041c\u0415\3\2\2\2\u041c\u0416\3\2\2\2\u041c\u0417\3\2\2\2\u041c"+
		"\u0418\3\2\2\2\u041c\u0419\3\2\2\2\u041c\u041a\3\2\2\2\u041c\u041b\3\2"+
		"\2\2\u041d\u008f\3\2\2\2\u041e\u041f\5\u0092J\2\u041f\u0421\5\u0094K\2"+
		"\u0420\u0422\5\u00a2R\2\u0421\u0420\3\2\2\2\u0421\u0422\3\2\2\2\u0422"+
		"\u0430\3\2\2\2\u0423\u0427\5X-\2\u0424\u0426\5\u00e6t\2\u0425\u0424\3"+
		"\2\2\2\u0426\u0429\3\2\2\2\u0427\u0425\3\2\2\2\u0427\u0428\3\2\2\2\u0428"+
		"\u042a\3\2\2\2\u0429\u0427\3\2\2\2\u042a\u042b\5\u0092J\2\u042b\u042d"+
		"\5\u0094K\2\u042c\u042e\5\u00a2R\2\u042d\u042c\3\2\2\2\u042d\u042e\3\2"+
		"\2\2\u042e\u0430\3\2\2\2\u042f\u041e\3\2\2\2\u042f\u0423\3\2\2\2\u0430"+
		"\u0091\3\2\2\2\u0431\u0434\5t;\2\u0432\u0434\7\62\2\2\u0433\u0431\3\2"+
		"\2\2\u0433\u0432\3\2\2\2\u0434\u0093\3\2\2\2\u0435\u0436\7h\2\2\u0436"+
		"\u0438\7;\2\2\u0437\u0439\5\u0096L\2\u0438\u0437\3\2\2\2\u0438\u0439\3"+
		"\2\2\2\u0439\u043a\3\2\2\2\u043a\u043c\7<\2\2\u043b\u043d\5 \21\2\u043c"+
		"\u043b\3\2\2\2\u043c\u043d\3\2\2\2\u043d\u0095\3\2\2\2\u043e\u0445\5\u00a0"+
		"Q\2\u043f\u0440\5\u0098M\2\u0440\u0441\7B\2\2\u0441\u0442\5\u009eP\2\u0442"+
		"\u0445\3\2\2\2\u0443\u0445\5\u009eP\2\u0444\u043e\3\2\2\2\u0444\u043f"+
		"\3\2\2\2\u0444\u0443\3\2\2\2\u0445\u0097\3\2\2\2\u0446\u044b\5\u009aN"+
		"\2\u0447\u0448\7B\2\2\u0448\u044a\5\u009aN\2\u0449\u0447\3\2\2\2\u044a"+
		"\u044d\3\2\2\2\u044b\u0449\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u0457\3\2"+
		"\2\2\u044d\u044b\3\2\2\2\u044e\u0453\5\u00a0Q\2\u044f\u0450\7B\2\2\u0450"+
		"\u0452\5\u009aN\2\u0451\u044f\3\2\2\2\u0452\u0455\3\2\2\2\u0453\u0451"+
		"\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0457\3\2\2\2\u0455\u0453\3\2\2\2\u0456"+
		"\u0446\3\2\2\2\u0456\u044e\3\2\2\2\u0457\u0099\3\2\2\2\u0458\u045a\5\u009c"+
		"O\2\u0459\u0458\3\2\2\2\u045a\u045d\3\2\2\2\u045b\u0459\3\2\2\2\u045b"+
		"\u045c\3\2\2\2\u045c\u045e\3\2\2\2\u045d\u045b\3\2\2\2\u045e\u045f\5t"+
		";\2\u045f\u0460\5p9\2\u0460\u009b\3\2\2\2\u0461\u0464\5\u00e6t\2\u0462"+
		"\u0464\7\24\2\2\u0463\u0461\3\2\2\2\u0463\u0462\3\2\2\2\u0464\u009d\3"+
		"\2\2\2\u0465\u0467\5\u009cO\2\u0466\u0465\3\2\2\2\u0467\u046a\3\2\2\2"+
		"\u0468\u0466\3\2\2\2\u0468\u0469\3\2\2\2\u0469\u046b\3\2\2\2\u046a\u0468"+
		"\3\2\2\2\u046b\u046f\5t;\2\u046c\u046e\5\u00e6t\2\u046d\u046c\3\2\2\2"+
		"\u046e\u0471\3\2\2\2\u046f\u046d\3\2\2\2\u046f\u0470\3\2\2\2\u0470\u0472"+
		"\3\2\2\2\u0471\u046f\3\2\2\2\u0472\u0473\7j\2\2\u0473\u0474\5p9\2\u0474"+
		"\u0477\3\2\2\2\u0475\u0477\5\u009aN\2\u0476\u0468\3\2\2\2\u0476\u0475"+
		"\3\2\2\2\u0477\u009f\3\2\2\2\u0478\u047a\5\u00e6t\2\u0479\u0478\3\2\2"+
		"\2\u047a\u047d\3\2\2\2\u047b\u0479\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u047e"+
		"\3\2\2\2\u047d\u047b\3\2\2\2\u047e\u0481\5t;\2\u047f\u0480\7h\2\2\u0480"+
		"\u0482\7C\2\2\u0481\u047f\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u0483\3\2"+
		"\2\2\u0483\u0484\7-\2\2\u0484\u00a1\3\2\2\2\u0485\u0486\7/\2\2\u0486\u0487"+
		"\5\u00a4S\2\u0487\u00a3\3\2\2\2\u0488\u048d\5\u00a6T\2\u0489\u048a\7B"+
		"\2\2\u048a\u048c\5\u00a6T\2\u048b\u0489\3\2\2\2\u048c\u048f\3\2\2\2\u048d"+
		"\u048b\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u00a5\3\2\2\2\u048f\u048d\3\2"+
		"\2\2\u0490\u0493\5\20\t\2\u0491\u0493\5\34\17\2\u0492\u0490\3\2\2\2\u0492"+
		"\u0491\3\2\2\2\u0493\u00a7\3\2\2\2\u0494\u0497\5\u00fc\177\2\u0495\u0497"+
		"\7A\2\2\u0496\u0494\3\2\2\2\u0496\u0495\3\2\2\2\u0497\u00a9\3\2\2\2\u0498"+
		"\u0499\5\u00fc\177\2\u0499\u00ab\3\2\2\2\u049a\u049b\7(\2\2\u049b\u049c"+
		"\5\u00fc\177\2\u049c\u00ad\3\2\2\2\u049d\u049f\5\u00b0Y\2\u049e\u049d"+
		"\3\2\2\2\u049f\u04a2\3\2\2\2\u04a0\u049e\3\2\2\2\u04a0\u04a1\3\2\2\2\u04a1"+
		"\u04a3\3\2\2\2\u04a2\u04a0\3\2\2\2\u04a3\u04a5\5\u00b2Z\2\u04a4\u04a6"+
		"\5\u00a2R\2\u04a5\u04a4\3\2\2\2\u04a5\u04a6\3\2\2\2\u04a6\u04a7\3\2\2"+
		"\2\u04a7\u04a8\5\u00b6\\\2\u04a8\u00af\3\2\2\2\u04a9\u04ae\5\u00e6t\2"+
		"\u04aa\u04ae\7%\2\2\u04ab\u04ae\7$\2\2\u04ac\u04ae\7#\2\2\u04ad\u04a9"+
		"\3\2\2\2\u04ad\u04aa\3\2\2\2\u04ad\u04ab\3\2\2\2\u04ad\u04ac\3\2\2\2\u04ae"+
		"\u00b1\3\2\2\2\u04af\u04b1\5X-\2\u04b0\u04af\3\2\2\2\u04b0\u04b1\3\2\2"+
		"\2\u04b1\u04b2\3\2\2\2\u04b2\u04b3\5\u00b4[\2\u04b3\u04b5\7;\2\2\u04b4"+
		"\u04b6\5\u0096L\2\u04b5\u04b4\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b7"+
		"\3\2\2\2\u04b7\u04b8\7<\2\2\u04b8\u00b3\3\2\2\2\u04b9\u04ba\7h\2\2\u04ba"+
		"\u00b5\3\2\2\2\u04bb\u04bd\7=\2\2\u04bc\u04be\5\u00b8]\2\u04bd\u04bc\3"+
		"\2\2\2\u04bd\u04be\3\2\2\2\u04be\u04c0\3\2\2\2\u04bf\u04c1\5\u00fe\u0080"+
		"\2\u04c0\u04bf\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c3"+
		"\7>\2\2\u04c3\u00b7\3\2\2\2\u04c4\u04c6\5*\26\2\u04c5\u04c4\3\2\2\2\u04c5"+
		"\u04c6\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7\u04c8\7-\2\2\u04c8\u04ca\7;\2"+
		"\2\u04c9\u04cb\5\u018e\u00c8\2\u04ca\u04c9\3\2\2\2\u04ca\u04cb\3\2\2\2"+
		"\u04cb\u04cc\3\2\2\2\u04cc\u04cd\7<\2\2\u04cd\u04f3\7A\2\2\u04ce\u04d0"+
		"\5*\26\2\u04cf\u04ce\3\2\2\2\u04cf\u04d0\3\2\2\2\u04d0\u04d1\3\2\2\2\u04d1"+
		"\u04d2\7*\2\2\u04d2\u04d4\7;\2\2\u04d3\u04d5\5\u018e\u00c8\2\u04d4\u04d3"+
		"\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5\u04d6\3\2\2\2\u04d6\u04d7\7<\2\2\u04d7"+
		"\u04f3\7A\2\2\u04d8\u04d9\5:\36\2\u04d9\u04db\7C\2\2\u04da\u04dc\5*\26"+
		"\2\u04db\u04da\3\2\2\2\u04db\u04dc\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd\u04de"+
		"\7*\2\2\u04de\u04e0\7;\2\2\u04df\u04e1\5\u018e\u00c8\2\u04e0\u04df\3\2"+
		"\2\2\u04e0\u04e1\3\2\2\2\u04e1\u04e2\3\2\2\2\u04e2\u04e3\7<\2\2\u04e3"+
		"\u04e4\7A\2\2\u04e4\u04f3\3\2\2\2\u04e5\u04e6\5\u0160\u00b1\2\u04e6\u04e8"+
		"\7C\2\2\u04e7\u04e9\5*\26\2\u04e8\u04e7\3\2\2\2\u04e8\u04e9\3\2\2\2\u04e9"+
		"\u04ea\3\2\2\2\u04ea\u04eb\7*\2\2\u04eb\u04ed\7;\2\2\u04ec\u04ee\5\u018e"+
		"\u00c8\2\u04ed\u04ec\3\2\2\2\u04ed\u04ee\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef"+
		"\u04f0\7<\2\2\u04f0\u04f1\7A\2\2\u04f1\u04f3\3\2\2\2\u04f2\u04c5\3\2\2"+
		"\2\u04f2\u04cf\3\2\2\2\u04f2\u04d8\3\2\2\2\u04f2\u04e5\3\2\2\2\u04f3\u00b9"+
		"\3\2\2\2\u04f4\u04f6\5V,\2\u04f5\u04f4\3\2\2\2\u04f6\u04f9\3\2\2\2\u04f7"+
		"\u04f5\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04fa\3\2\2\2\u04f9\u04f7\3\2"+
		"\2\2\u04fa\u04fb\7\22\2\2\u04fb\u04fd\7h\2\2\u04fc\u04fe\5^\60\2\u04fd"+
		"\u04fc\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff\u0500\5\u00bc"+
		"_\2\u0500\u00bb\3\2\2\2\u0501\u0503\7=\2\2\u0502\u0504\5\u00be`\2\u0503"+
		"\u0502\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0506\3\2\2\2\u0505\u0507\7B"+
		"\2\2\u0506\u0505\3\2\2\2\u0506\u0507\3\2\2\2\u0507\u0509\3\2\2\2\u0508"+
		"\u050a\5\u00c4c\2\u0509\u0508\3\2\2\2\u0509\u050a\3\2\2\2\u050a\u050b"+
		"\3\2\2\2\u050b\u050c\7>\2\2\u050c\u00bd\3\2\2\2\u050d\u0512\5\u00c0a\2"+
		"\u050e\u050f\7B\2\2\u050f\u0511\5\u00c0a\2\u0510\u050e\3\2\2\2\u0511\u0514"+
		"\3\2\2\2\u0512\u0510\3\2\2\2\u0512\u0513\3\2\2\2\u0513\u00bf\3\2\2\2\u0514"+
		"\u0512\3\2\2\2\u0515\u0517\5\u00c2b\2\u0516\u0515\3\2\2\2\u0517\u051a"+
		"\3\2\2\2\u0518\u0516\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u051b\3\2\2\2\u051a"+
		"\u0518\3\2\2\2\u051b\u0521\7h\2\2\u051c\u051e\7;\2\2\u051d\u051f\5\u018e"+
		"\u00c8\2\u051e\u051d\3\2\2\2\u051e\u051f\3\2\2\2\u051f\u0520\3\2\2\2\u0520"+
		"\u0522\7<\2\2\u0521\u051c\3\2\2\2\u0521\u0522\3\2\2\2\u0522\u0524\3\2"+
		"\2\2\u0523\u0525\5b\62\2\u0524\u0523\3\2\2\2\u0524\u0525\3\2\2\2\u0525"+
		"\u00c1\3\2\2\2\u0526\u0527\5\u00e6t\2\u0527\u00c3\3\2\2\2\u0528\u052c"+
		"\7A\2\2\u0529\u052b\5d\63\2\u052a\u0529\3\2\2\2\u052b\u052e\3\2\2\2\u052c"+
		"\u052a\3\2\2\2\u052c\u052d\3\2\2\2\u052d\u00c5\3\2\2\2\u052e\u052c\3\2"+
		"\2\2\u052f\u0532\5\u00c8e\2\u0530\u0532\5\u00dan\2\u0531\u052f\3\2\2\2"+
		"\u0531\u0530\3\2\2\2\u0532\u00c7\3\2\2\2\u0533\u0535\5\u00caf\2\u0534"+
		"\u0533\3\2\2\2\u0535\u0538\3\2\2\2\u0536\u0534\3\2\2\2\u0536\u0537\3\2"+
		"\2\2\u0537\u0539\3\2\2\2\u0538\u0536\3\2\2\2\u0539\u053a\7\36\2\2\u053a"+
		"\u053c\7h\2\2\u053b\u053d\5X-\2\u053c\u053b\3\2\2\2\u053c\u053d\3\2\2"+
		"\2\u053d\u053f\3\2\2\2\u053e\u0540\5\u00ccg\2\u053f\u053e\3\2\2\2\u053f"+
		"\u0540\3\2\2\2\u0540\u0541\3\2\2\2\u0541\u0542\5\u00ceh\2\u0542\u00c9"+
		"\3\2\2\2\u0543\u054b\5\u00e6t\2\u0544\u054b\7%\2\2\u0545\u054b\7$\2\2"+
		"\u0546\u054b\7#\2\2\u0547\u054b\7\3\2\2\u0548\u054b\7(\2\2\u0549\u054b"+
		"\7)\2\2\u054a\u0543\3\2\2\2\u054a\u0544\3\2\2\2\u054a\u0545\3\2\2\2\u054a"+
		"\u0546\3\2\2\2\u054a\u0547\3\2\2\2\u054a\u0548\3\2\2\2\u054a\u0549\3\2"+
		"\2\2\u054b\u00cb\3\2\2\2\u054c\u054d\7\23\2\2\u054d\u054e\5`\61\2\u054e"+
		"\u00cd\3\2\2\2\u054f\u0553\7=\2\2\u0550\u0552\5\u00d0i\2\u0551\u0550\3"+
		"\2\2\2\u0552\u0555\3\2\2\2\u0553\u0551\3\2\2\2\u0553\u0554\3\2\2\2\u0554"+
		"\u0556\3\2\2\2\u0555\u0553\3\2\2\2\u0556\u0557\7>\2\2\u0557\u00cf\3\2"+
		"\2\2\u0558\u055e\5\u00d2j\2\u0559\u055e\5\u00d6l\2\u055a\u055e\5R*\2\u055b"+
		"\u055e\5\u00c6d\2\u055c\u055e\7A\2\2\u055d\u0558\3\2\2\2\u055d\u0559\3"+
		"\2\2\2\u055d\u055a\3\2\2\2\u055d\u055b\3\2\2\2\u055d\u055c\3\2\2\2\u055e"+
		"\u00d1\3\2\2\2\u055f\u0561\5\u00d4k\2\u0560\u055f\3\2\2\2\u0561\u0564"+
		"\3\2\2\2\u0562\u0560\3\2\2\2\u0562\u0563\3\2\2\2\u0563\u0565\3\2\2\2\u0564"+
		"\u0562\3\2\2\2\u0565\u0566\5t;\2\u0566\u0567\5l\67\2\u0567\u0568\7A\2"+
		"\2\u0568\u00d3\3\2\2\2\u0569\u056e\5\u00e6t\2\u056a\u056e\7%\2\2\u056b"+
		"\u056e\7(\2\2\u056c\u056e\7\24\2\2\u056d\u0569\3\2\2\2\u056d\u056a\3\2"+
		"\2\2\u056d\u056b\3\2\2\2\u056d\u056c\3\2\2\2\u056e\u00d5\3\2\2\2\u056f"+
		"\u0571\5\u01da\u00ee\2\u0570\u056f\3\2\2\2\u0571\u0574\3\2\2\2\u0572\u0570"+
		"\3\2\2\2\u0572\u0573\3\2\2\2\u0573\u0578\3\2\2\2\u0574\u0572\3\2\2\2\u0575"+
		"\u0577\5\u00d8m\2\u0576\u0575\3\2\2\2\u0577\u057a\3\2\2\2\u0578\u0576"+
		"\3\2\2\2\u0578\u0579\3\2\2\2\u0579\u057b\3\2\2\2\u057a\u0578\3\2\2\2\u057b"+
		"\u057c\5\u0090I\2\u057c\u057d\5\u00a8U\2\u057d\u00d7\3\2\2\2\u057e\u0585"+
		"\5\u00e6t\2\u057f\u0585\7%\2\2\u0580\u0585\7\3\2\2\u0581\u0585\7\16\2"+
		"\2\u0582\u0585\7(\2\2\u0583\u0585\7)\2\2\u0584\u057e\3\2\2\2\u0584\u057f"+
		"\3\2\2\2\u0584\u0580\3\2\2\2\u0584\u0581\3\2\2\2\u0584\u0582\3\2\2\2\u0584"+
		"\u0583\3\2\2\2\u0585\u00d9\3\2\2\2\u0586\u0588\5\u00caf\2\u0587\u0586"+
		"\3\2\2\2\u0588\u058b\3\2\2\2\u0589\u0587\3\2\2\2\u0589\u058a\3\2\2\2\u058a"+
		"\u058c\3\2\2\2\u058b\u0589\3\2\2\2\u058c\u058d\7i\2\2\u058d\u058e\7\36"+
		"\2\2\u058e\u058f\7h\2\2\u058f\u0590\5\u00dco\2\u0590\u00db\3\2\2\2\u0591"+
		"\u0595\7=\2\2\u0592\u0594\5\u00dep\2\u0593\u0592\3\2\2\2\u0594\u0597\3"+
		"\2\2\2\u0595\u0593\3\2\2\2\u0595\u0596\3\2\2\2\u0596\u0598\3\2\2\2\u0597"+
		"\u0595\3\2\2\2\u0598\u0599\7>\2\2\u0599\u00dd\3\2\2\2\u059a\u05a0\5\u00e0"+
		"q\2\u059b\u05a0\5\u00d2j\2\u059c\u05a0\5R*\2\u059d\u05a0\5\u00c6d\2\u059e"+
		"\u05a0\7A\2\2\u059f\u059a\3\2\2\2\u059f\u059b\3\2\2\2\u059f\u059c\3\2"+
		"\2\2\u059f\u059d\3\2\2\2\u059f\u059e\3\2\2\2\u05a0\u00df\3\2\2\2\u05a1"+
		"\u05a3\5\u00e2r\2\u05a2\u05a1\3\2\2\2\u05a3\u05a6\3\2\2\2\u05a4\u05a2"+
		"\3\2\2\2\u05a4\u05a5\3\2\2\2\u05a5\u05a7\3\2\2\2\u05a6\u05a4\3\2\2\2\u05a7"+
		"\u05a8\5t;\2\u05a8\u05a9\7h\2\2\u05a9\u05aa\7;\2\2\u05aa\u05ac\7<\2\2"+
		"\u05ab\u05ad\5 \21\2\u05ac\u05ab\3\2\2\2\u05ac\u05ad\3\2\2\2\u05ad\u05af"+
		"\3\2\2\2\u05ae\u05b0\5\u00e4s\2\u05af\u05ae\3\2\2\2\u05af\u05b0\3\2\2"+
		"\2\u05b0\u05b1\3\2\2\2\u05b1\u05b2\7A\2\2\u05b2\u00e1\3\2\2\2\u05b3\u05b7"+
		"\5\u00e6t\2\u05b4\u05b7\7%\2\2\u05b5\u05b7\7\3\2\2\u05b6\u05b3\3\2\2\2"+
		"\u05b6\u05b4\3\2\2\2\u05b6\u05b5\3\2\2\2\u05b7\u00e3\3\2\2\2\u05b8\u05b9"+
		"\7\16\2\2\u05b9\u05ba\5\u00eex\2\u05ba\u00e5\3\2\2\2\u05bb\u05bf\5\u00e8"+
		"u\2\u05bc\u05bf\5\u00f4{\2\u05bd\u05bf\5\u00f6|\2\u05be\u05bb\3\2\2\2"+
		"\u05be\u05bc\3\2\2\2\u05be\u05bd\3\2\2\2\u05bf\u00e7\3\2\2\2\u05c0\u05c1"+
		"\7i\2\2\u05c1\u05c2\5\66\34\2\u05c2\u05c4\7;\2\2\u05c3\u05c5\5\u00eav"+
		"\2\u05c4\u05c3\3\2\2\2\u05c4\u05c5\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6\u05c7"+
		"\7<\2\2\u05c7\u00e9\3\2\2\2\u05c8\u05cd\5\u00ecw\2\u05c9\u05ca\7B\2\2"+
		"\u05ca\u05cc\5\u00ecw\2\u05cb\u05c9\3\2\2\2\u05cc\u05cf\3\2\2\2\u05cd"+
		"\u05cb\3\2\2\2\u05cd\u05ce\3\2\2\2\u05ce\u00eb\3\2\2\2\u05cf\u05cd\3\2"+
		"\2\2\u05d0\u05d1\7h\2\2\u05d1\u05d2\7D\2\2\u05d2\u05d3\5\u00eex\2\u05d3"+
		"\u00ed\3\2\2\2\u05d4\u05d8\5\u01b0\u00d9\2\u05d5\u05d8\5\u00f0y\2\u05d6"+
		"\u05d8\5\u00e6t\2\u05d7\u05d4\3\2\2\2\u05d7\u05d5\3\2\2\2\u05d7\u05d6"+
		"\3\2\2\2\u05d8\u00ef\3\2\2\2\u05d9\u05db\7=\2\2\u05da\u05dc\5\u00f2z\2"+
		"\u05db\u05da\3\2\2\2\u05db\u05dc\3\2\2\2\u05dc\u05de\3\2\2\2\u05dd\u05df"+
		"\7B\2\2\u05de\u05dd\3\2\2\2\u05de\u05df\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0"+
		"\u05e1\7>\2\2\u05e1\u00f1\3\2\2\2\u05e2\u05e7\5\u00eex\2\u05e3\u05e4\7"+
		"B\2\2\u05e4\u05e6\5\u00eex\2\u05e5\u05e3\3\2\2\2\u05e6\u05e9\3\2\2\2\u05e7"+
		"\u05e5\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u00f3\3\2\2\2\u05e9\u05e7\3\2"+
		"\2\2\u05ea\u05eb\7i\2\2\u05eb\u05ec\5\66\34\2\u05ec\u00f5\3\2\2\2\u05ed"+
		"\u05ee\7i\2\2\u05ee\u05ef\5\66\34\2\u05ef\u05f0\7;\2\2\u05f0\u05f1\5\u00ee"+
		"x\2\u05f1\u05f2\7<\2\2\u05f2\u00f7\3\2\2\2\u05f3\u05f5\7=\2\2\u05f4\u05f6"+
		"\5\u00fa~\2\u05f5\u05f4\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f8\3\2\2"+
		"\2\u05f7\u05f9\7B\2\2\u05f8\u05f7\3\2\2\2\u05f8\u05f9\3\2\2\2\u05f9\u05fa"+
		"\3\2\2\2\u05fa\u05fb\7>\2\2\u05fb\u00f9\3\2\2\2\u05fc\u0601\5r:\2\u05fd"+
		"\u05fe\7B\2\2\u05fe\u0600\5r:\2\u05ff\u05fd\3\2\2\2\u0600\u0603\3\2\2"+
		"\2\u0601\u05ff\3\2\2\2\u0601\u0602\3\2\2\2\u0602\u00fb\3\2\2\2\u0603\u0601"+
		"\3\2\2\2\u0604\u0606\7=\2\2\u0605\u0607\5\u00fe\u0080\2\u0606\u0605\3"+
		"\2\2\2\u0606\u0607\3\2\2\2\u0607\u0608\3\2\2\2\u0608\u0609\7>\2\2\u0609"+
		"\u00fd\3\2\2\2\u060a\u060c\5\u0100\u0081\2\u060b\u060a\3\2\2\2\u060c\u060d"+
		"\3\2\2\2\u060d\u060b\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u00ff\3\2\2\2\u060f"+
		"\u0613\5\u0102\u0082\2\u0610\u0613\5R*\2\u0611\u0613\5\u0106\u0084\2\u0612"+
		"\u060f\3\2\2\2\u0612\u0610\3\2\2\2\u0612\u0611\3\2\2\2\u0613\u0101\3\2"+
		"\2\2\u0614\u0615\5\u0104\u0083\2\u0615\u0616\7A\2\2\u0616\u0103\3\2\2"+
		"\2\u0617\u0619\5\u009cO\2\u0618\u0617\3\2\2\2\u0619\u061c\3\2\2\2\u061a"+
		"\u0618\3\2\2\2\u061a\u061b\3\2\2\2\u061b\u061d\3\2\2\2\u061c\u061a\3\2"+
		"\2\2\u061d\u061e\5t;\2\u061e\u061f\5l\67\2\u061f\u0105\3\2\2\2\u0620\u0627"+
		"\5\u010a\u0086\2\u0621\u0627\5\u010e\u0088\2\u0622\u0627\5\u0116\u008c"+
		"\2\u0623\u0627\5\u0118\u008d\2\u0624\u0627\5\u012a\u0096\2\u0625\u0627"+
		"\5\u0130\u0099\2\u0626\u0620\3\2\2\2\u0626\u0621\3\2\2\2\u0626\u0622\3"+
		"\2\2\2\u0626\u0623\3\2\2\2\u0626\u0624\3\2\2\2\u0626\u0625\3\2\2\2\u0627"+
		"\u0107\3\2\2\2\u0628\u062e\5\u010a\u0086\2\u0629\u062e\5\u0110\u0089\2"+
		"\u062a\u062e\5\u011a\u008e\2\u062b\u062e\5\u012c\u0097\2\u062c\u062e\5"+
		"\u0132\u009a\2\u062d\u0628\3\2\2\2\u062d\u0629\3\2\2\2\u062d\u062a\3\2"+
		"\2\2\u062d\u062b\3\2\2\2\u062d\u062c\3\2\2\2\u062e\u0109\3\2\2\2\u062f"+
		"\u063c\5\u00fc\177\2\u0630\u063c\5\u010c\u0087\2\u0631\u063c\5\u0112\u008a"+
		"\2\u0632\u063c\5\u011c\u008f\2\u0633\u063c\5\u011e\u0090\2\u0634\u063c"+
		"\5\u012e\u0098\2\u0635\u063c\5\u0142\u00a2\2\u0636\u063c\5\u0144\u00a3"+
		"\2\u0637\u063c\5\u0146\u00a4\2\u0638\u063c\5\u014a\u00a6\2\u0639\u063c"+
		"\5\u0148\u00a5\2\u063a\u063c\5\u014c\u00a7\2\u063b\u062f\3\2\2\2\u063b"+
		"\u0630\3\2\2\2\u063b\u0631\3\2\2\2\u063b\u0632\3\2\2\2\u063b\u0633\3\2"+
		"\2\2\u063b\u0634\3\2\2\2\u063b\u0635\3\2\2\2\u063b\u0636\3\2\2\2\u063b"+
		"\u0637\3\2\2\2\u063b\u0638\3\2\2\2\u063b\u0639\3\2\2\2\u063b\u063a\3\2"+
		"\2\2\u063c\u010b\3\2\2\2\u063d\u063e\7A\2\2\u063e\u010d\3\2\2\2\u063f"+
		"\u0640\7h\2\2\u0640\u0641\7J\2\2\u0641\u0642\5\u0106\u0084\2\u0642\u010f"+
		"\3\2\2\2\u0643\u0644\7h\2\2\u0644\u0645\7J\2\2\u0645\u0646\5\u0108\u0085"+
		"\2\u0646\u0111\3\2\2\2\u0647\u0648\5\u0114\u008b\2\u0648\u0649\7A\2\2"+
		"\u0649\u0113\3\2\2\2\u064a\u0652\5\u01aa\u00d6\2\u064b\u0652\5\u01c8\u00e5"+
		"\2\u064c\u0652\5\u01ca\u00e6\2\u064d\u0652\5\u01d0\u00e9\2\u064e\u0652"+
		"\5\u01d4\u00eb\2\u064f\u0652\5\u0188\u00c5\2\u0650\u0652\5\u0174\u00bb"+
		"\2\u0651\u064a\3\2\2\2\u0651\u064b\3\2\2\2\u0651\u064c\3\2\2\2\u0651\u064d"+
		"\3\2\2\2\u0651\u064e\3\2\2\2\u0651\u064f\3\2\2\2\u0651\u0650\3\2\2\2\u0652"+
		"\u0115\3\2\2\2\u0653\u0654\7\30\2\2\u0654\u0655\7;\2\2\u0655\u0656\5\u019e"+
		"\u00d0\2\u0656\u0657\7<\2\2\u0657\u0658\5\u0106\u0084\2\u0658\u0117\3"+
		"\2\2\2\u0659\u065a\7\30\2\2\u065a\u065b\7;\2\2\u065b\u065c\5\u019e\u00d0"+
		"\2\u065c\u065d\7<\2\2\u065d\u065e\5\u0108\u0085\2\u065e\u065f\7\21\2\2"+
		"\u065f\u0660\5\u0106\u0084\2\u0660\u0119\3\2\2\2\u0661\u0662\7\30\2\2"+
		"\u0662\u0663\7;\2\2\u0663\u0664\5\u019e\u00d0\2\u0664\u0665\7<\2\2\u0665"+
		"\u0666\5\u0108\u0085\2\u0666\u0667\7\21\2\2\u0667\u0668\5\u0108\u0085"+
		"\2\u0668\u011b\3\2\2\2\u0669\u066a\7\4\2\2\u066a\u066b\5\u019e\u00d0\2"+
		"\u066b\u066c\7A\2\2\u066c\u0674\3\2\2\2\u066d\u066e\7\4\2\2\u066e\u066f"+
		"\5\u019e\u00d0\2\u066f\u0670\7J\2\2\u0670\u0671\5\u019e\u00d0\2\u0671"+
		"\u0672\7A\2\2\u0672\u0674\3\2\2\2\u0673\u0669\3\2\2\2\u0673\u066d\3\2"+
		"\2\2\u0674\u011d\3\2\2\2\u0675\u0676\7+\2\2\u0676\u0677\7;\2\2\u0677\u0678"+
		"\5\u019e\u00d0\2\u0678\u0679\7<\2\2\u0679\u067a\5\u0120\u0091\2\u067a"+
		"\u011f\3\2\2\2\u067b\u067f\7=\2\2\u067c\u067e\5\u0122\u0092\2\u067d\u067c"+
		"\3\2\2\2\u067e\u0681\3\2\2\2\u067f\u067d\3\2\2\2\u067f\u0680\3\2\2\2\u0680"+
		"\u0685\3\2\2\2\u0681\u067f\3\2\2\2\u0682\u0684\5\u0126\u0094\2\u0683\u0682"+
		"\3\2\2\2\u0684\u0687\3\2\2\2\u0685\u0683\3\2\2\2\u0685\u0686\3\2\2\2\u0686"+
		"\u0688\3\2\2\2\u0687\u0685\3\2\2\2\u0688\u0689\7>\2\2\u0689\u0121\3\2"+
		"\2\2\u068a\u068b\5\u0124\u0093\2\u068b\u068c\5\u00fe\u0080\2\u068c\u0123"+
		"\3\2\2\2\u068d\u0691\5\u0126\u0094\2\u068e\u0690\5\u0126\u0094\2\u068f"+
		"\u068e\3\2\2\2\u0690\u0693\3\2\2\2\u0691\u068f\3\2\2\2\u0691\u0692\3\2"+
		"\2\2\u0692\u0125\3\2\2\2\u0693\u0691\3\2\2\2\u0694\u0695\7\b\2\2\u0695"+
		"\u0696\5\u019c\u00cf\2\u0696\u0697\7J\2\2\u0697\u069f\3\2\2\2\u0698\u0699"+
		"\7\b\2\2\u0699\u069a\5\u0128\u0095\2\u069a\u069b\7J\2\2\u069b\u069f\3"+
		"\2\2\2\u069c\u069d\7\16\2\2\u069d\u069f\7J\2\2\u069e\u0694\3\2\2\2\u069e"+
		"\u0698\3\2\2\2\u069e\u069c\3\2\2\2\u069f\u0127\3\2\2\2\u06a0\u06a1\7h"+
		"\2\2\u06a1\u0129\3\2\2\2\u06a2\u06a3\7\64\2\2\u06a3\u06a4\7;\2\2\u06a4"+
		"\u06a5\5\u019e\u00d0\2\u06a5\u06a6\7<\2\2\u06a6\u06a7\5\u0106\u0084\2"+
		"\u06a7\u012b\3\2\2\2\u06a8\u06a9\7\64\2\2\u06a9\u06aa\7;\2\2\u06aa\u06ab"+
		"\5\u019e\u00d0\2\u06ab\u06ac\7<\2\2\u06ac\u06ad\5\u0108\u0085\2\u06ad"+
		"\u012d\3\2\2\2\u06ae\u06af\7\17\2\2\u06af\u06b0\5\u0106\u0084\2\u06b0"+
		"\u06b1\7\64\2\2\u06b1\u06b2\7;\2\2\u06b2\u06b3\5\u019e\u00d0\2\u06b3\u06b4"+
		"\7<\2\2\u06b4\u06b5\7A\2\2\u06b5\u012f\3\2\2\2\u06b6\u06b9\5\u0134\u009b"+
		"\2\u06b7\u06b9\5\u013e\u00a0\2\u06b8\u06b6\3\2\2\2\u06b8\u06b7\3\2\2\2"+
		"\u06b9\u0131\3\2\2\2\u06ba\u06bd\5\u0136\u009c\2\u06bb\u06bd\5\u0140\u00a1"+
		"\2\u06bc\u06ba\3\2\2\2\u06bc\u06bb\3\2\2\2\u06bd\u0133\3\2\2\2\u06be\u06bf"+
		"\7\27\2\2\u06bf\u06c1\7;\2\2\u06c0\u06c2\5\u0138\u009d\2\u06c1\u06c0\3"+
		"\2\2\2\u06c1\u06c2\3\2\2\2\u06c2\u06c3\3\2\2\2\u06c3\u06c5\7A\2\2\u06c4"+
		"\u06c6\5\u019e\u00d0\2\u06c5\u06c4\3\2\2\2\u06c5\u06c6\3\2\2\2\u06c6\u06c7"+
		"\3\2\2\2\u06c7\u06c9\7A\2\2\u06c8\u06ca\5\u013a\u009e\2\u06c9\u06c8\3"+
		"\2\2\2\u06c9\u06ca\3\2\2\2\u06ca\u06cb\3\2\2\2\u06cb\u06cc\7<\2\2\u06cc"+
		"\u06cd\5\u0106\u0084\2\u06cd\u0135\3\2\2\2\u06ce\u06cf\7\27\2\2\u06cf"+
		"\u06d1\7;\2\2\u06d0\u06d2\5\u0138\u009d\2\u06d1\u06d0\3\2\2\2\u06d1\u06d2"+
		"\3\2\2\2\u06d2\u06d3\3\2\2\2\u06d3\u06d5\7A\2\2\u06d4\u06d6\5\u019e\u00d0"+
		"\2\u06d5\u06d4\3\2\2\2\u06d5\u06d6\3\2\2\2\u06d6\u06d7\3\2\2\2\u06d7\u06d9"+
		"\7A\2\2\u06d8\u06da\5\u013a\u009e\2\u06d9\u06d8\3\2\2\2\u06d9\u06da\3"+
		"\2\2\2\u06da\u06db\3\2\2\2\u06db\u06dc\7<\2\2\u06dc\u06dd\5\u0108\u0085"+
		"\2\u06dd\u0137\3\2\2\2\u06de\u06e1\5\u013c\u009f\2\u06df\u06e1\5\u0104"+
		"\u0083\2\u06e0\u06de\3\2\2\2\u06e0\u06df\3\2\2\2\u06e1\u0139\3\2\2\2\u06e2"+
		"\u06e3\5\u013c\u009f\2\u06e3\u013b\3\2\2\2\u06e4\u06e9\5\u0114\u008b\2"+
		"\u06e5\u06e6\7B\2\2\u06e6\u06e8\5\u0114\u008b\2\u06e7\u06e5\3\2\2\2\u06e8"+
		"\u06eb\3\2\2\2\u06e9\u06e7\3\2\2\2\u06e9\u06ea\3\2\2\2\u06ea\u013d\3\2"+
		"\2\2\u06eb\u06e9\3\2\2\2\u06ec\u06ed\7\27\2\2\u06ed\u06f1\7;\2\2\u06ee"+
		"\u06f0\5\u009cO\2\u06ef\u06ee\3\2\2\2\u06f0\u06f3\3\2\2\2\u06f1\u06ef"+
		"\3\2\2\2\u06f1\u06f2\3\2\2\2\u06f2\u06f4\3\2\2\2\u06f3\u06f1\3\2\2\2\u06f4"+
		"\u06f5\5t;\2\u06f5\u06f6\5p9\2\u06f6\u06f7\7J\2\2\u06f7\u06f8\5\u019e"+
		"\u00d0\2\u06f8\u06f9\7<\2\2\u06f9\u06fa\5\u0106\u0084\2\u06fa\u013f\3"+
		"\2\2\2\u06fb\u06fc\7\27\2\2\u06fc\u0700\7;\2\2\u06fd\u06ff\5\u009cO\2"+
		"\u06fe\u06fd\3\2\2\2\u06ff\u0702\3\2\2\2\u0700\u06fe\3\2\2\2\u0700\u0701"+
		"\3\2\2\2\u0701\u0703\3\2\2\2\u0702\u0700\3\2\2\2\u0703\u0704\5t;\2\u0704"+
		"\u0705\5p9\2\u0705\u0706\7J\2\2\u0706\u0707\5\u019e\u00d0\2\u0707\u0708"+
		"\7<\2\2\u0708\u0709\5\u0108\u0085\2\u0709\u0141\3\2\2\2\u070a\u070c\7"+
		"\6\2\2\u070b\u070d\7h\2\2\u070c\u070b\3\2\2\2\u070c\u070d\3\2\2\2\u070d"+
		"\u070e\3\2\2\2\u070e\u070f\7A\2\2\u070f\u0143\3\2\2\2\u0710\u0712\7\r"+
		"\2\2\u0711\u0713\7h\2\2\u0712\u0711\3\2\2\2\u0712\u0713\3\2\2\2\u0713"+
		"\u0714\3\2\2\2\u0714\u0715\7A\2\2\u0715\u0145\3\2\2\2\u0716\u0718\7&\2"+
		"\2\u0717\u0719\5\u019e\u00d0\2\u0718\u0717\3\2\2\2\u0718\u0719\3\2\2\2"+
		"\u0719\u071a\3\2\2\2\u071a\u071b\7A\2\2\u071b\u0147\3\2\2\2\u071c\u071d"+
		"\7.\2\2\u071d\u071e\5\u019e\u00d0\2\u071e\u071f\7A\2\2\u071f\u0149\3\2"+
		"\2\2\u0720\u0721\7,\2\2\u0721\u0722\7;\2\2\u0722\u0723\5\u019e\u00d0\2"+
		"\u0723\u0724\7<\2\2\u0724\u0725\5\u00fc\177\2\u0725\u014b\3\2\2\2\u0726"+
		"\u0727\7\61\2\2\u0727\u0728\5\u00fc\177\2\u0728\u0729\5\u014e\u00a8\2"+
		"\u0729\u0733\3\2\2\2\u072a\u072b\7\61\2\2\u072b\u072d\5\u00fc\177\2\u072c"+
		"\u072e\5\u014e\u00a8\2\u072d\u072c\3\2\2\2\u072d\u072e\3\2\2\2\u072e\u072f"+
		"\3\2\2\2\u072f\u0730\5\u0156\u00ac\2\u0730\u0733\3\2\2\2\u0731\u0733\5"+
		"\u0158\u00ad\2\u0732\u0726\3\2\2\2\u0732\u072a\3\2\2\2\u0732\u0731\3\2"+
		"\2\2\u0733\u014d\3\2\2\2\u0734\u0738\5\u0150\u00a9\2\u0735\u0737\5\u0150"+
		"\u00a9\2\u0736\u0735\3\2\2\2\u0737\u073a\3\2\2\2\u0738\u0736\3\2\2\2\u0738"+
		"\u0739\3\2\2\2\u0739\u014f\3\2\2\2\u073a\u0738\3\2\2\2\u073b\u073c\7\t"+
		"\2\2\u073c\u073d\7;\2\2\u073d\u073e\5\u0152\u00aa\2\u073e\u073f\7<\2\2"+
		"\u073f\u0740\5\u00fc\177\2\u0740\u0151\3\2\2\2\u0741\u0743\5\u009cO\2"+
		"\u0742\u0741\3\2\2\2\u0743\u0746\3\2\2\2\u0744\u0742\3\2\2\2\u0744\u0745"+
		"\3\2\2\2\u0745\u0747\3\2\2\2\u0746\u0744\3\2\2\2\u0747\u0748\5\u0154\u00ab"+
		"\2\u0748\u0749\5p9\2\u0749\u0153\3\2\2\2\u074a\u074f\5|?\2\u074b\u074c"+
		"\7X\2\2\u074c\u074e\5\20\t\2\u074d\u074b\3\2\2\2\u074e\u0751\3\2\2\2\u074f"+
		"\u074d\3\2\2\2\u074f\u0750\3\2\2\2\u0750\u0155\3\2\2\2\u0751\u074f\3\2"+
		"\2\2\u0752\u0753\7\25\2\2\u0753\u0754\5\u00fc\177\2\u0754\u0157\3\2\2"+
		"\2\u0755\u0756\7\61\2\2\u0756\u0757\5\u015a\u00ae\2\u0757\u0759\5\u00fc"+
		"\177\2\u0758\u075a\5\u014e\u00a8\2\u0759\u0758\3\2\2\2\u0759\u075a\3\2"+
		"\2\2\u075a\u075c\3\2\2\2\u075b\u075d\5\u0156\u00ac\2\u075c\u075b\3\2\2"+
		"\2\u075c\u075d\3\2\2\2\u075d\u0159\3\2\2\2\u075e\u075f\7;\2\2\u075f\u0761"+
		"\5\u015c\u00af\2\u0760\u0762\7A\2\2\u0761\u0760\3\2\2\2\u0761\u0762\3"+
		"\2\2\2\u0762\u0763\3\2\2\2\u0763\u0764\7<\2\2\u0764\u015b\3\2\2\2\u0765"+
		"\u076a\5\u015e\u00b0\2\u0766\u0767\7A\2\2\u0767\u0769\5\u015e\u00b0\2"+
		"\u0768\u0766\3\2\2\2\u0769\u076c\3\2\2\2\u076a\u0768\3\2\2\2\u076a\u076b"+
		"\3\2\2\2\u076b\u015d\3\2\2\2\u076c\u076a\3\2\2\2\u076d\u076f\5\u009cO"+
		"\2\u076e\u076d\3\2\2\2\u076f\u0772\3\2\2\2\u0770\u076e\3\2\2\2\u0770\u0771"+
		"\3\2\2\2\u0771\u0773\3\2\2\2\u0772\u0770\3\2\2\2\u0773\u0774\5t;\2\u0774"+
		"\u0775\5p9\2\u0775\u0776\7D\2\2\u0776\u0777\5\u019e\u00d0\2\u0777\u015f"+
		"\3\2\2\2\u0778\u077b\5\u016e\u00b8\2\u0779\u077b\5\u0196\u00cc\2\u077a"+
		"\u0778\3\2\2\2\u077a\u0779\3\2\2\2\u077b\u077f\3\2\2\2\u077c\u077e\5\u0168"+
		"\u00b5\2\u077d\u077c\3\2\2\2\u077e\u0781\3\2\2\2\u077f\u077d\3\2\2\2\u077f"+
		"\u0780\3\2\2\2\u0780\u0161\3\2\2\2\u0781\u077f\3\2\2\2\u0782\u07a0\5\2"+
		"\2\2\u0783\u0788\5\66\34\2\u0784\u0785\7?\2\2\u0785\u0787\7@\2\2\u0786"+
		"\u0784\3\2\2\2\u0787\u078a\3\2\2\2\u0788\u0786\3\2\2\2\u0788\u0789\3\2"+
		"\2\2\u0789\u078b\3\2\2\2\u078a\u0788\3\2\2\2\u078b\u078c\7C\2\2\u078c"+
		"\u078d\7\13\2\2\u078d\u07a0\3\2\2\2\u078e\u078f\7\62\2\2\u078f\u0790\7"+
		"C\2\2\u0790\u07a0\7\13\2\2\u0791\u07a0\7-\2\2\u0792\u0793\5\66\34\2\u0793"+
		"\u0794\7C\2\2\u0794\u0795\7-\2\2\u0795\u07a0\3\2\2\2\u0796\u0797\7;\2"+
		"\2\u0797\u0798\5\u019e\u00d0\2\u0798\u0799\7<\2\2\u0799\u07a0\3\2\2\2"+
		"\u079a\u07a0\5\u0174\u00bb\2\u079b\u07a0\5\u017c\u00bf\2\u079c\u07a0\5"+
		"\u0182\u00c2\2\u079d\u07a0\5\u0188\u00c5\2\u079e\u07a0\5\u0190\u00c9\2"+
		"\u079f\u0782\3\2\2\2\u079f\u0783\3\2\2\2\u079f\u078e\3\2\2\2\u079f\u0791"+
		"\3\2\2\2\u079f\u0792\3\2\2\2\u079f\u0796\3\2\2\2\u079f\u079a\3\2\2\2\u079f"+
		"\u079b\3\2\2\2\u079f\u079c\3\2\2\2\u079f\u079d\3\2\2\2\u079f\u079e\3\2"+
		"\2\2\u07a0\u0163\3\2\2\2\u07a1\u07a2\3\2\2\2\u07a2\u0165\3\2\2\2\u07a3"+
		"\u07c0\5\2\2\2\u07a4\u07a9\5\66\34\2\u07a5\u07a6\7?\2\2\u07a6\u07a8\7"+
		"@\2\2\u07a7\u07a5\3\2\2\2\u07a8\u07ab\3\2\2\2\u07a9\u07a7\3\2\2\2\u07a9"+
		"\u07aa\3\2\2\2\u07aa\u07ac\3\2\2\2\u07ab\u07a9\3\2\2\2\u07ac\u07ad\7C"+
		"\2\2\u07ad\u07ae\7\13\2\2\u07ae\u07c0\3\2\2\2\u07af\u07b0\7\62\2\2\u07b0"+
		"\u07b1\7C\2\2\u07b1\u07c0\7\13\2\2\u07b2\u07c0\7-\2\2\u07b3\u07b4\5\66"+
		"\34\2\u07b4\u07b5\7C\2\2\u07b5\u07b6\7-\2\2\u07b6\u07c0\3\2\2\2\u07b7"+
		"\u07b8\7;\2\2\u07b8\u07b9\5\u019e\u00d0\2\u07b9\u07ba\7<\2\2\u07ba\u07c0"+
		"\3\2\2\2\u07bb\u07c0\5\u0174\u00bb\2\u07bc\u07c0\5\u017c\u00bf\2\u07bd"+
		"\u07c0\5\u0188\u00c5\2\u07be\u07c0\5\u0190\u00c9\2\u07bf\u07a3\3\2\2\2"+
		"\u07bf\u07a4\3\2\2\2\u07bf\u07af\3\2\2\2\u07bf\u07b2\3\2\2\2\u07bf\u07b3"+
		"\3\2\2\2\u07bf\u07b7\3\2\2\2\u07bf\u07bb\3\2\2\2\u07bf\u07bc\3\2\2\2\u07bf"+
		"\u07bd\3\2\2\2\u07bf\u07be\3\2\2\2\u07c0\u0167\3\2\2\2\u07c1\u07c7\5\u0176"+
		"\u00bc\2\u07c2\u07c7\5\u017e\u00c0\2\u07c3\u07c7\5\u0184\u00c3\2\u07c4"+
		"\u07c7\5\u018a\u00c6\2\u07c5\u07c7\5\u0192\u00ca\2\u07c6\u07c1\3\2\2\2"+
		"\u07c6\u07c2\3\2\2\2\u07c6\u07c3\3\2\2\2\u07c6\u07c4\3\2\2\2\u07c6\u07c5"+
		"\3\2\2\2\u07c7\u0169\3\2\2\2\u07c8\u07c9\3\2\2\2\u07c9\u016b\3\2\2\2\u07ca"+
		"\u07cf\5\u0176\u00bc\2\u07cb\u07cf\5\u017e\u00c0\2\u07cc\u07cf\5\u018a"+
		"\u00c6\2\u07cd\u07cf\5\u0192\u00ca\2\u07ce\u07ca\3\2\2\2\u07ce\u07cb\3"+
		"\2\2\2\u07ce\u07cc\3\2\2\2\u07ce\u07cd\3\2\2\2\u07cf\u016d\3\2\2\2\u07d0"+
		"\u07f9\5\2\2\2\u07d1\u07d6\5\66\34\2\u07d2\u07d3\7?\2\2\u07d3\u07d5\7"+
		"@\2\2\u07d4\u07d2\3\2\2\2\u07d5\u07d8\3\2\2\2\u07d6\u07d4\3\2\2\2\u07d6"+
		"\u07d7\3\2\2\2\u07d7\u07d9\3\2\2\2\u07d8\u07d6\3\2\2\2\u07d9\u07da\7C"+
		"\2\2\u07da\u07db\7\13\2\2\u07db\u07f9\3\2\2\2\u07dc\u07e1\5v<\2\u07dd"+
		"\u07de\7?\2\2\u07de\u07e0\7@\2\2\u07df\u07dd\3\2\2\2\u07e0\u07e3\3\2\2"+
		"\2\u07e1\u07df\3\2\2\2\u07e1\u07e2\3\2\2\2\u07e2\u07e4\3\2\2\2\u07e3\u07e1"+
		"\3\2\2\2\u07e4\u07e5\7C\2\2\u07e5\u07e6\7\13\2\2\u07e6\u07f9\3\2\2\2\u07e7"+
		"\u07e8\7\62\2\2\u07e8\u07e9\7C\2\2\u07e9\u07f9\7\13\2\2\u07ea\u07f9\7"+
		"-\2\2\u07eb\u07ec\5\66\34\2\u07ec\u07ed\7C\2\2\u07ed\u07ee\7-\2\2\u07ee"+
		"\u07f9\3\2\2\2\u07ef\u07f0\7;\2\2\u07f0\u07f1\5\u019e\u00d0\2\u07f1\u07f2"+
		"\7<\2\2\u07f2\u07f9\3\2\2\2\u07f3\u07f9\5\u0178\u00bd\2\u07f4\u07f9\5"+
		"\u0180\u00c1\2\u07f5\u07f9\5\u0186\u00c4\2\u07f6\u07f9\5\u018c\u00c7\2"+
		"\u07f7\u07f9\5\u0194\u00cb\2\u07f8\u07d0\3\2\2\2\u07f8\u07d1\3\2\2\2\u07f8"+
		"\u07dc\3\2\2\2\u07f8\u07e7\3\2\2\2\u07f8\u07ea\3\2\2\2\u07f8\u07eb\3\2"+
		"\2\2\u07f8\u07ef\3\2\2\2\u07f8\u07f3\3\2\2\2\u07f8\u07f4\3\2\2\2\u07f8"+
		"\u07f5\3\2\2\2\u07f8\u07f6\3\2\2\2\u07f8\u07f7\3\2\2\2\u07f9\u016f\3\2"+
		"\2\2\u07fa\u07fb\3\2\2\2\u07fb\u0171\3\2\2\2\u07fc\u0824\5\2\2\2\u07fd"+
		"\u0802\5\66\34\2\u07fe\u07ff\7?\2\2\u07ff\u0801\7@\2\2\u0800\u07fe\3\2"+
		"\2\2\u0801\u0804\3\2\2\2\u0802\u0800\3\2\2\2\u0802\u0803\3\2\2\2\u0803"+
		"\u0805\3\2\2\2\u0804\u0802\3\2\2\2\u0805\u0806\7C\2\2\u0806\u0807\7\13"+
		"\2\2\u0807\u0824\3\2\2\2\u0808\u080d\5v<\2\u0809\u080a\7?\2\2\u080a\u080c"+
		"\7@\2\2\u080b\u0809\3\2\2\2\u080c\u080f\3\2\2\2\u080d\u080b\3\2\2\2\u080d"+
		"\u080e\3\2\2\2\u080e\u0810\3\2\2\2\u080f\u080d\3\2\2\2\u0810\u0811\7C"+
		"\2\2\u0811\u0812\7\13\2\2\u0812\u0824\3\2\2\2\u0813\u0814\7\62\2\2\u0814"+
		"\u0815\7C\2\2\u0815\u0824\7\13\2\2\u0816\u0824\7-\2\2\u0817\u0818\5\66"+
		"\34\2\u0818\u0819\7C\2\2\u0819\u081a\7-\2\2\u081a\u0824\3\2\2\2\u081b"+
		"\u081c\7;\2\2\u081c\u081d\5\u019e\u00d0\2\u081d\u081e\7<\2\2\u081e\u0824"+
		"\3\2\2\2\u081f\u0824\5\u0178\u00bd\2\u0820\u0824\5\u0180\u00c1\2\u0821"+
		"\u0824\5\u018c\u00c7\2\u0822\u0824\5\u0194\u00cb\2\u0823\u07fc\3\2\2\2"+
		"\u0823\u07fd\3\2\2\2\u0823\u0808\3\2\2\2\u0823\u0813\3\2\2\2\u0823\u0816"+
		"\3\2\2\2\u0823\u0817\3\2\2\2\u0823\u081b\3\2\2\2\u0823\u081f\3\2\2\2\u0823"+
		"\u0820\3\2\2\2\u0823\u0821\3\2\2\2\u0823\u0822\3\2\2\2\u0824\u0173\3\2"+
		"\2\2\u0825\u0827\7!\2\2\u0826\u0828\5*\26\2\u0827\u0826\3\2\2\2\u0827"+
		"\u0828\3\2\2\2\u0828\u082c\3\2\2\2\u0829\u082b\5\u00e6t\2\u082a\u0829"+
		"\3\2\2\2\u082b\u082e\3\2\2\2\u082c\u082a\3\2\2\2\u082c\u082d\3\2\2\2\u082d"+
		"\u082f\3\2\2\2\u082e\u082c\3\2\2\2\u082f\u083a\7h\2\2\u0830\u0834\7C\2"+
		"\2\u0831\u0833\5\u00e6t\2\u0832\u0831\3\2\2\2\u0833\u0836\3\2\2\2\u0834"+
		"\u0832\3\2\2\2\u0834\u0835\3\2\2\2\u0835\u0837\3\2\2\2\u0836\u0834\3\2"+
		"\2\2\u0837\u0839\7h\2\2\u0838\u0830\3\2\2\2\u0839\u083c\3\2\2\2\u083a"+
		"\u0838\3\2\2\2\u083a\u083b\3\2\2\2\u083b\u083e\3\2\2\2\u083c\u083a\3\2"+
		"\2\2\u083d\u083f\5\u017a\u00be\2\u083e\u083d\3\2\2\2\u083e\u083f\3\2\2"+
		"\2\u083f\u0840\3\2\2\2\u0840\u0842\7;\2\2\u0841\u0843\5\u018e\u00c8\2"+
		"\u0842\u0841\3\2\2\2\u0842\u0843\3\2\2\2\u0843\u0844\3\2\2\2\u0844\u0846"+
		"\7<\2\2\u0845\u0847\5b\62\2\u0846\u0845\3\2\2\2\u0846\u0847\3\2\2\2\u0847"+
		"\u0879\3\2\2\2\u0848\u0849\5:\36\2\u0849\u084a\7C\2\2\u084a\u084c\7!\2"+
		"\2\u084b\u084d\5*\26\2\u084c\u084b\3\2\2\2\u084c\u084d\3\2\2\2\u084d\u0851"+
		"\3\2\2\2\u084e\u0850\5\u00e6t\2\u084f\u084e\3\2\2\2\u0850\u0853\3\2\2"+
		"\2\u0851\u084f\3\2\2\2\u0851\u0852\3\2\2\2\u0852\u0854\3\2\2\2\u0853\u0851"+
		"\3\2\2\2\u0854\u0856\7h\2\2\u0855\u0857\5\u017a\u00be\2\u0856\u0855\3"+
		"\2\2\2\u0856\u0857\3\2\2\2\u0857\u0858\3\2\2\2\u0858\u085a\7;\2\2\u0859"+
		"\u085b\5\u018e\u00c8\2\u085a\u0859\3\2\2\2\u085a\u085b\3\2\2\2\u085b\u085c"+
		"\3\2\2\2\u085c\u085e\7<\2\2\u085d\u085f\5b\62\2\u085e\u085d\3\2\2\2\u085e"+
		"\u085f\3\2\2\2\u085f\u0879\3\2\2\2\u0860\u0861\5\u0160\u00b1\2\u0861\u0862"+
		"\7C\2\2\u0862\u0864\7!\2\2\u0863\u0865\5*\26\2\u0864\u0863\3\2\2\2\u0864"+
		"\u0865\3\2\2\2\u0865\u0869\3\2\2\2\u0866\u0868\5\u00e6t\2\u0867\u0866"+
		"\3\2\2\2\u0868\u086b\3\2\2\2\u0869\u0867\3\2\2\2\u0869\u086a\3\2\2\2\u086a"+
		"\u086c\3\2\2\2\u086b\u0869\3\2\2\2\u086c\u086e\7h\2\2\u086d\u086f\5\u017a"+
		"\u00be\2\u086e\u086d\3\2\2\2\u086e\u086f\3\2\2\2\u086f\u0870\3\2\2\2\u0870"+
		"\u0872\7;\2\2\u0871\u0873\5\u018e\u00c8\2\u0872\u0871\3\2\2\2\u0872\u0873"+
		"\3\2\2\2\u0873\u0874\3\2\2\2\u0874\u0876\7<\2\2\u0875\u0877\5b\62\2\u0876"+
		"\u0875\3\2\2\2\u0876\u0877\3\2\2\2\u0877\u0879\3\2\2\2\u0878\u0825\3\2"+
		"\2\2\u0878\u0848\3\2\2\2\u0878\u0860\3\2\2\2\u0879\u0175\3\2\2\2\u087a"+
		"\u087b\7C\2\2\u087b\u087d\7!\2\2\u087c\u087e\5*\26\2\u087d\u087c\3\2\2"+
		"\2\u087d\u087e\3\2\2\2\u087e\u0882\3\2\2\2\u087f\u0881\5\u00e6t\2\u0880"+
		"\u087f\3\2\2\2\u0881\u0884\3\2\2\2\u0882\u0880\3\2\2\2\u0882\u0883\3\2"+
		"\2\2\u0883\u0885\3\2\2\2\u0884\u0882\3\2\2\2\u0885\u0887\7h\2\2\u0886"+
		"\u0888\5\u017a\u00be\2\u0887\u0886\3\2\2\2\u0887\u0888\3\2\2\2\u0888\u0889"+
		"\3\2\2\2\u0889\u088b\7;\2\2\u088a\u088c\5\u018e\u00c8\2\u088b\u088a\3"+
		"\2\2\2\u088b\u088c\3\2\2\2\u088c\u088d\3\2\2\2\u088d\u088f\7<\2\2\u088e"+
		"\u0890\5b\62\2\u088f\u088e\3\2\2\2\u088f\u0890\3\2\2\2\u0890\u0177\3\2"+
		"\2\2\u0891\u0893\7!\2\2\u0892\u0894\5*\26\2\u0893\u0892\3\2\2\2\u0893"+
		"\u0894\3\2\2\2\u0894\u0898\3\2\2\2\u0895\u0897\5\u00e6t\2\u0896\u0895"+
		"\3\2\2\2\u0897\u089a\3\2\2\2\u0898\u0896\3\2\2\2\u0898\u0899\3\2\2\2\u0899"+
		"\u089b\3\2\2\2\u089a\u0898\3\2\2\2\u089b\u08a6\7h\2\2\u089c\u08a0\7C\2"+
		"\2\u089d\u089f\5\u00e6t\2\u089e\u089d\3\2\2\2\u089f\u08a2\3\2\2\2\u08a0"+
		"\u089e\3\2\2\2\u08a0\u08a1\3\2\2\2\u08a1\u08a3\3\2\2\2\u08a2\u08a0\3\2"+
		"\2\2\u08a3\u08a5\7h\2\2\u08a4\u089c\3\2\2\2\u08a5\u08a8\3\2\2\2\u08a6"+
		"\u08a4\3\2\2\2\u08a6\u08a7\3\2\2\2\u08a7\u08aa\3\2\2\2\u08a8\u08a6\3\2"+
		"\2\2\u08a9\u08ab\5\u017a\u00be\2\u08aa\u08a9\3\2\2\2\u08aa\u08ab\3\2\2"+
		"\2\u08ab\u08ac\3\2\2\2\u08ac\u08ae\7;\2\2\u08ad\u08af\5\u018e\u00c8\2"+
		"\u08ae\u08ad\3\2\2\2\u08ae\u08af\3\2\2\2\u08af\u08b0\3\2\2\2\u08b0\u08b2"+
		"\7<\2\2\u08b1\u08b3\5b\62\2\u08b2\u08b1\3\2\2\2\u08b2\u08b3\3\2\2\2\u08b3"+
		"\u08cd\3\2\2\2\u08b4\u08b5\5:\36\2\u08b5\u08b6\7C\2\2\u08b6\u08b8\7!\2"+
		"\2\u08b7\u08b9\5*\26\2\u08b8\u08b7\3\2\2\2\u08b8\u08b9\3\2\2\2\u08b9\u08bd"+
		"\3\2\2\2\u08ba\u08bc\5\u00e6t\2\u08bb\u08ba\3\2\2\2\u08bc\u08bf\3\2\2"+
		"\2\u08bd\u08bb\3\2\2\2\u08bd\u08be\3\2\2\2\u08be\u08c0\3\2\2\2\u08bf\u08bd"+
		"\3\2\2\2\u08c0\u08c2\7h\2\2\u08c1\u08c3\5\u017a\u00be\2\u08c2\u08c1\3"+
		"\2\2\2\u08c2\u08c3\3\2\2\2\u08c3\u08c4\3\2\2\2\u08c4\u08c6\7;\2\2\u08c5"+
		"\u08c7\5\u018e\u00c8\2\u08c6\u08c5\3\2\2\2\u08c6\u08c7\3\2\2\2\u08c7\u08c8"+
		"\3\2\2\2\u08c8\u08ca\7<\2\2\u08c9\u08cb\5b\62\2\u08ca\u08c9\3\2\2\2\u08ca"+
		"\u08cb\3\2\2\2\u08cb\u08cd\3\2\2\2\u08cc\u0891\3\2\2\2\u08cc\u08b4\3\2"+
		"\2\2\u08cd\u0179\3\2\2\2\u08ce\u08d2\5*\26\2\u08cf\u08d0\7F\2\2\u08d0"+
		"\u08d2\7E\2\2\u08d1\u08ce\3\2\2\2\u08d1\u08cf\3\2\2\2\u08d2\u017b\3\2"+
		"\2\2\u08d3\u08d4\5\u0160\u00b1\2\u08d4\u08d5\7C\2\2\u08d5\u08d6\7h\2\2"+
		"\u08d6\u08e1\3\2\2\2\u08d7\u08d8\7*\2\2\u08d8\u08d9\7C\2\2\u08d9\u08e1"+
		"\7h\2\2\u08da\u08db\5\66\34\2\u08db\u08dc\7C\2\2\u08dc\u08dd\7*\2\2\u08dd"+
		"\u08de\7C\2\2\u08de\u08df\7h\2\2\u08df\u08e1\3\2\2\2\u08e0\u08d3\3\2\2"+
		"\2\u08e0\u08d7\3\2\2\2\u08e0\u08da\3\2\2\2\u08e1\u017d\3\2\2\2\u08e2\u08e3"+
		"\7C\2\2\u08e3\u08e4\7h\2\2\u08e4\u017f\3\2\2\2\u08e5\u08e6\7*\2\2\u08e6"+
		"\u08e7\7C\2\2\u08e7\u08ef\7h\2\2\u08e8\u08e9\5\66\34\2\u08e9\u08ea\7C"+
		"\2\2\u08ea\u08eb\7*\2\2\u08eb\u08ec\7C\2\2\u08ec\u08ed\7h\2\2\u08ed\u08ef"+
		"\3\2\2\2\u08ee\u08e5\3\2\2\2\u08ee\u08e8\3\2\2\2\u08ef\u0181\3\2\2\2\u08f0"+
		"\u08f1\5:\36\2\u08f1\u08f2\7?\2\2\u08f2\u08f3\5\u019e\u00d0\2\u08f3\u08f4"+
		"\7@\2\2\u08f4\u08fb\3\2\2\2\u08f5\u08f6\5\u0166\u00b4\2\u08f6\u08f7\7"+
		"?\2\2\u08f7\u08f8\5\u019e\u00d0\2\u08f8\u08f9\7@\2\2\u08f9\u08fb\3\2\2"+
		"\2\u08fa\u08f0\3\2\2\2\u08fa\u08f5\3\2\2\2\u08fb\u0903\3\2\2\2\u08fc\u08fd"+
		"\5\u0164\u00b3\2\u08fd\u08fe\7?\2\2\u08fe\u08ff\5\u019e\u00d0\2\u08ff"+
		"\u0900\7@\2\2\u0900\u0902\3\2\2\2\u0901\u08fc\3\2\2\2\u0902\u0905\3\2"+
		"\2\2\u0903\u0901\3\2\2\2\u0903\u0904\3\2\2\2\u0904\u0183\3\2\2\2\u0905"+
		"\u0903\3\2\2\2\u0906\u0907\5\u016c\u00b7\2\u0907\u0908\7?\2\2\u0908\u0909"+
		"\5\u019e\u00d0\2\u0909\u090a\7@\2\2\u090a\u0912\3\2\2\2\u090b\u090c\5"+
		"\u016a\u00b6\2\u090c\u090d\7?\2\2\u090d\u090e\5\u019e\u00d0\2\u090e\u090f"+
		"\7@\2\2\u090f\u0911\3\2\2\2\u0910\u090b\3\2\2\2\u0911\u0914\3\2\2\2\u0912"+
		"\u0910\3\2\2\2\u0912\u0913\3\2\2\2\u0913\u0185\3\2\2\2\u0914\u0912\3\2"+
		"\2\2\u0915\u0916\5:\36\2\u0916\u0917\7?\2\2\u0917\u0918\5\u019e\u00d0"+
		"\2\u0918\u0919\7@\2\2\u0919\u0920\3\2\2\2\u091a\u091b\5\u0172\u00ba\2"+
		"\u091b\u091c\7?\2\2\u091c\u091d\5\u019e\u00d0\2\u091d\u091e\7@\2\2\u091e"+
		"\u0920\3\2\2\2\u091f\u0915\3\2\2\2\u091f\u091a\3\2\2\2\u0920\u0928\3\2"+
		"\2\2\u0921\u0922\5\u0170\u00b9\2\u0922\u0923\7?\2\2\u0923\u0924\5\u019e"+
		"\u00d0\2\u0924\u0925\7@\2\2\u0925\u0927\3\2\2\2\u0926\u0921\3\2\2\2\u0927"+
		"\u092a\3\2\2\2\u0928\u0926\3\2\2\2\u0928\u0929\3\2\2\2\u0929\u0187\3\2"+
		"\2\2\u092a\u0928\3\2\2\2\u092b\u092c\5<\37\2\u092c\u092e\7;\2\2\u092d"+
		"\u092f\5\u018e\u00c8\2\u092e\u092d\3\2\2\2\u092e\u092f\3\2\2\2\u092f\u0930"+
		"\3\2\2\2\u0930\u0931\7<\2\2\u0931\u0970\3\2\2";
	private static final String _serializedATNSegment1 =
		"\2\u0932\u0933\5\66\34\2\u0933\u0935\7C\2\2\u0934\u0936\5*\26\2\u0935"+
		"\u0934\3\2\2\2\u0935\u0936\3\2\2\2\u0936\u0937\3\2\2\2\u0937\u0938\7h"+
		"\2\2\u0938\u093a\7;\2\2\u0939\u093b\5\u018e\u00c8\2\u093a\u0939\3\2\2"+
		"\2\u093a\u093b\3\2\2\2\u093b\u093c\3\2\2\2\u093c\u093d\7<\2\2\u093d\u0970"+
		"\3\2\2\2\u093e\u093f\5:\36\2\u093f\u0941\7C\2\2\u0940\u0942\5*\26\2\u0941"+
		"\u0940\3\2\2\2\u0941\u0942\3\2\2\2\u0942\u0943\3\2\2\2\u0943\u0944\7h"+
		"\2\2\u0944\u0946\7;\2\2\u0945\u0947\5\u018e\u00c8\2\u0946\u0945\3\2\2"+
		"\2\u0946\u0947\3\2\2\2\u0947\u0948\3\2\2\2\u0948\u0949\7<\2\2\u0949\u0970"+
		"\3\2\2\2\u094a\u094b\5\u0160\u00b1\2\u094b\u094d\7C\2\2\u094c\u094e\5"+
		"*\26\2\u094d\u094c\3\2\2\2\u094d\u094e\3\2\2\2\u094e\u094f\3\2\2\2\u094f"+
		"\u0950\7h\2\2\u0950\u0952\7;\2\2\u0951\u0953\5\u018e\u00c8\2\u0952\u0951"+
		"\3\2\2\2\u0952\u0953\3\2\2\2\u0953\u0954\3\2\2\2\u0954\u0955\7<\2\2\u0955"+
		"\u0970\3\2\2\2\u0956\u0957\7*\2\2\u0957\u0959\7C\2\2\u0958\u095a\5*\26"+
		"\2\u0959\u0958\3\2\2\2\u0959\u095a\3\2\2\2\u095a\u095b\3\2\2\2\u095b\u095c"+
		"\7h\2\2\u095c\u095e\7;\2\2\u095d\u095f\5\u018e\u00c8\2\u095e\u095d\3\2"+
		"\2\2\u095e\u095f\3\2\2\2\u095f\u0960\3\2\2\2\u0960\u0970\7<\2\2\u0961"+
		"\u0962\5\66\34\2\u0962\u0963\7C\2\2\u0963\u0964\7*\2\2\u0964\u0966\7C"+
		"\2\2\u0965\u0967\5*\26\2\u0966\u0965\3\2\2\2\u0966\u0967\3\2\2\2\u0967"+
		"\u0968\3\2\2\2\u0968\u0969\7h\2\2\u0969\u096b\7;\2\2\u096a\u096c\5\u018e"+
		"\u00c8\2\u096b\u096a\3\2\2\2\u096b\u096c\3\2\2\2\u096c\u096d\3\2\2\2\u096d"+
		"\u096e\7<\2\2\u096e\u0970\3\2\2\2\u096f\u092b\3\2\2\2\u096f\u0932\3\2"+
		"\2\2\u096f\u093e\3\2\2\2\u096f\u094a\3\2\2\2\u096f\u0956\3\2\2\2\u096f"+
		"\u0961\3\2\2\2\u0970\u0189\3\2\2\2\u0971\u0973\7C\2\2\u0972\u0974\5*\26"+
		"\2\u0973\u0972\3\2\2\2\u0973\u0974\3\2\2\2\u0974\u0975\3\2\2\2\u0975\u0976"+
		"\7h\2\2\u0976\u0978\7;\2\2\u0977\u0979\5\u018e\u00c8\2\u0978\u0977\3\2"+
		"\2\2\u0978\u0979\3\2\2\2\u0979\u097a\3\2\2\2\u097a\u097b\7<\2\2\u097b"+
		"\u018b\3\2\2\2\u097c\u097d\5<\37\2\u097d\u097f\7;\2\2\u097e\u0980\5\u018e"+
		"\u00c8\2\u097f\u097e\3\2\2\2\u097f\u0980\3\2\2\2\u0980\u0981\3\2\2\2\u0981"+
		"\u0982\7<\2\2\u0982\u09b5\3\2\2\2\u0983\u0984\5\66\34\2\u0984\u0986\7"+
		"C\2\2\u0985\u0987\5*\26\2\u0986\u0985\3\2\2\2\u0986\u0987\3\2\2\2\u0987"+
		"\u0988\3\2\2\2\u0988\u0989\7h\2\2\u0989\u098b\7;\2\2\u098a\u098c\5\u018e"+
		"\u00c8\2\u098b\u098a\3\2\2\2\u098b\u098c\3\2\2\2\u098c\u098d\3\2\2\2\u098d"+
		"\u098e\7<\2\2\u098e\u09b5\3\2\2\2\u098f\u0990\5:\36\2\u0990\u0992\7C\2"+
		"\2\u0991\u0993\5*\26\2\u0992\u0991\3\2\2\2\u0992\u0993\3\2\2\2\u0993\u0994"+
		"\3\2\2\2\u0994\u0995\7h\2\2\u0995\u0997\7;\2\2\u0996\u0998\5\u018e\u00c8"+
		"\2\u0997\u0996\3\2\2\2\u0997\u0998\3\2\2\2\u0998\u0999\3\2\2\2\u0999\u099a"+
		"\7<\2\2\u099a\u09b5\3\2\2\2\u099b\u099c\7*\2\2\u099c\u099e\7C\2\2\u099d"+
		"\u099f\5*\26\2\u099e\u099d\3\2\2\2\u099e\u099f\3\2\2\2\u099f\u09a0\3\2"+
		"\2\2\u09a0\u09a1\7h\2\2\u09a1\u09a3\7;\2\2\u09a2\u09a4\5\u018e\u00c8\2"+
		"\u09a3\u09a2\3\2\2\2\u09a3\u09a4\3\2\2\2\u09a4\u09a5\3\2\2\2\u09a5\u09b5"+
		"\7<\2\2\u09a6\u09a7\5\66\34\2\u09a7\u09a8\7C\2\2\u09a8\u09a9\7*\2\2\u09a9"+
		"\u09ab\7C\2\2\u09aa\u09ac\5*\26\2\u09ab\u09aa\3\2\2\2\u09ab\u09ac\3\2"+
		"\2\2\u09ac\u09ad\3\2\2\2\u09ad\u09ae\7h\2\2\u09ae\u09b0\7;\2\2\u09af\u09b1"+
		"\5\u018e\u00c8\2\u09b0\u09af\3\2\2\2\u09b0\u09b1\3\2\2\2\u09b1\u09b2\3"+
		"\2\2\2\u09b2\u09b3\7<\2\2\u09b3\u09b5\3\2\2\2\u09b4\u097c\3\2\2\2\u09b4"+
		"\u0983\3\2\2\2\u09b4\u098f\3\2\2\2\u09b4\u099b\3\2\2\2\u09b4\u09a6\3\2"+
		"\2\2\u09b5\u018d\3\2\2\2\u09b6\u09bb\5\u019e\u00d0\2\u09b7\u09b8\7B\2"+
		"\2\u09b8\u09ba\5\u019e\u00d0\2\u09b9\u09b7\3\2\2\2\u09ba\u09bd\3\2\2\2"+
		"\u09bb\u09b9\3\2\2\2\u09bb\u09bc\3\2\2\2\u09bc\u018f\3\2\2\2\u09bd\u09bb"+
		"\3\2\2\2\u09be\u09bf\5:\36\2\u09bf\u09c1\7\\\2\2\u09c0\u09c2\5*\26\2\u09c1"+
		"\u09c0\3\2\2\2\u09c1\u09c2\3\2\2\2\u09c2\u09c3\3\2\2\2\u09c3\u09c4\7h"+
		"\2\2\u09c4\u09ee\3\2\2\2\u09c5\u09c6\5\f\7\2\u09c6\u09c8\7\\\2\2\u09c7"+
		"\u09c9\5*\26\2\u09c8\u09c7\3\2\2\2\u09c8\u09c9\3\2\2\2\u09c9\u09ca\3\2"+
		"\2\2\u09ca\u09cb\7h\2\2\u09cb\u09ee\3\2\2\2\u09cc\u09cd\5\u0160\u00b1"+
		"\2\u09cd\u09cf\7\\\2\2\u09ce\u09d0\5*\26\2\u09cf\u09ce\3\2\2\2\u09cf\u09d0"+
		"\3\2\2\2\u09d0\u09d1\3\2\2\2\u09d1\u09d2\7h\2\2\u09d2\u09ee\3\2\2\2\u09d3"+
		"\u09d4\7*\2\2\u09d4\u09d6\7\\\2\2\u09d5\u09d7\5*\26\2\u09d6\u09d5\3\2"+
		"\2\2\u09d6\u09d7\3\2\2\2\u09d7\u09d8\3\2\2\2\u09d8\u09ee\7h\2\2\u09d9"+
		"\u09da\5\66\34\2\u09da\u09db\7C\2\2\u09db\u09dc\7*\2\2\u09dc\u09de\7\\"+
		"\2\2\u09dd\u09df\5*\26\2\u09de\u09dd\3\2\2\2\u09de\u09df\3\2\2\2\u09df"+
		"\u09e0\3\2\2\2\u09e0\u09e1\7h\2\2\u09e1\u09ee\3\2\2\2\u09e2\u09e3\5\20"+
		"\t\2\u09e3\u09e5\7\\\2\2\u09e4\u09e6\5*\26\2\u09e5\u09e4\3\2\2\2\u09e5"+
		"\u09e6\3\2\2\2\u09e6\u09e7\3\2\2\2\u09e7\u09e8\7!\2\2\u09e8\u09ee\3\2"+
		"\2\2\u09e9\u09ea\5\36\20\2\u09ea\u09eb\7\\\2\2\u09eb\u09ec\7!\2\2\u09ec"+
		"\u09ee\3\2\2\2\u09ed\u09be\3\2\2\2\u09ed\u09c5\3\2\2\2\u09ed\u09cc\3\2"+
		"\2\2\u09ed\u09d3\3\2\2\2\u09ed\u09d9\3\2\2\2\u09ed\u09e2\3\2\2\2\u09ed"+
		"\u09e9\3\2\2\2\u09ee\u0191\3\2\2\2\u09ef\u09f1\7\\\2\2\u09f0\u09f2\5*"+
		"\26\2\u09f1\u09f0\3\2\2\2\u09f1\u09f2\3\2\2\2\u09f2\u09f3\3\2\2\2\u09f3"+
		"\u09f4\7h\2\2\u09f4\u0193\3\2\2\2\u09f5\u09f6\5:\36\2\u09f6\u09f8\7\\"+
		"\2\2\u09f7\u09f9\5*\26\2\u09f8\u09f7\3\2\2\2\u09f8\u09f9\3\2\2\2\u09f9"+
		"\u09fa\3\2\2\2\u09fa\u09fb\7h\2\2\u09fb\u0a1e\3\2\2\2\u09fc\u09fd\5\f"+
		"\7\2\u09fd\u09ff\7\\\2\2\u09fe\u0a00\5*\26\2\u09ff\u09fe\3\2\2\2\u09ff"+
		"\u0a00\3\2\2\2\u0a00\u0a01\3\2\2\2\u0a01\u0a02\7h\2\2\u0a02\u0a1e\3\2"+
		"\2\2\u0a03\u0a04\7*\2\2\u0a04\u0a06\7\\\2\2\u0a05\u0a07\5*\26\2\u0a06"+
		"\u0a05\3\2\2\2\u0a06\u0a07\3\2\2\2\u0a07\u0a08\3\2\2\2\u0a08\u0a1e\7h"+
		"\2\2\u0a09\u0a0a\5\66\34\2\u0a0a\u0a0b\7C\2\2\u0a0b\u0a0c\7*\2\2\u0a0c"+
		"\u0a0e\7\\\2\2\u0a0d\u0a0f\5*\26\2\u0a0e\u0a0d\3\2\2\2\u0a0e\u0a0f\3\2"+
		"\2\2\u0a0f\u0a10\3\2\2\2\u0a10\u0a11\7h\2\2\u0a11\u0a1e\3\2\2\2\u0a12"+
		"\u0a13\5\20\t\2\u0a13\u0a15\7\\\2\2\u0a14\u0a16\5*\26\2\u0a15\u0a14\3"+
		"\2\2\2\u0a15\u0a16\3\2\2\2\u0a16\u0a17\3\2\2\2\u0a17\u0a18\7!\2\2\u0a18"+
		"\u0a1e\3\2\2\2\u0a19\u0a1a\5\36\20\2\u0a1a\u0a1b\7\\\2\2\u0a1b\u0a1c\7"+
		"!\2\2\u0a1c\u0a1e\3\2\2\2\u0a1d\u09f5\3\2\2\2\u0a1d\u09fc\3\2\2\2\u0a1d"+
		"\u0a03\3\2\2\2\u0a1d\u0a09\3\2\2\2\u0a1d\u0a12\3\2\2\2\u0a1d\u0a19\3\2"+
		"\2\2\u0a1e\u0195\3\2\2\2\u0a1f\u0a20\7!\2\2\u0a20\u0a21\5\4\3\2\u0a21"+
		"\u0a23\5\u0198\u00cd\2\u0a22\u0a24\5 \21\2\u0a23\u0a22\3\2\2\2\u0a23\u0a24"+
		"\3\2\2\2\u0a24\u0a36\3\2\2\2\u0a25\u0a26\7!\2\2\u0a26\u0a27\5\16\b\2\u0a27"+
		"\u0a29\5\u0198\u00cd\2\u0a28\u0a2a\5 \21\2\u0a29\u0a28\3\2\2\2\u0a29\u0a2a"+
		"\3\2\2\2\u0a2a\u0a36\3\2\2\2\u0a2b\u0a2c\7!\2\2\u0a2c\u0a2d\5\4\3\2\u0a2d"+
		"\u0a2e\5 \21\2\u0a2e\u0a2f\5\u00f8}\2\u0a2f\u0a36\3\2\2\2\u0a30\u0a31"+
		"\7!\2\2\u0a31\u0a32\5\16\b\2\u0a32\u0a33\5 \21\2\u0a33\u0a34\5\u00f8}"+
		"\2\u0a34\u0a36\3\2\2\2\u0a35\u0a1f\3\2\2\2\u0a35\u0a25\3\2\2\2\u0a35\u0a2b"+
		"\3\2\2\2\u0a35\u0a30\3\2\2\2\u0a36\u0197\3\2\2\2\u0a37\u0a3b\5\u019a\u00ce"+
		"\2\u0a38\u0a3a\5\u019a\u00ce\2\u0a39\u0a38\3\2\2\2\u0a3a\u0a3d\3\2\2\2"+
		"\u0a3b\u0a39\3\2\2\2\u0a3b\u0a3c\3\2\2\2\u0a3c\u0199\3\2\2\2\u0a3d\u0a3b"+
		"\3\2\2\2\u0a3e\u0a40\5\u00e6t\2\u0a3f\u0a3e\3\2\2\2\u0a40\u0a43\3\2\2"+
		"\2\u0a41\u0a3f\3\2\2\2\u0a41\u0a42\3\2\2\2\u0a42\u0a44\3\2\2\2\u0a43\u0a41"+
		"\3\2\2\2\u0a44\u0a45\7?\2\2\u0a45\u0a46\5\u019e\u00d0\2\u0a46\u0a47\7"+
		"@\2\2\u0a47\u019b\3\2\2\2\u0a48\u0a49\5\u019e\u00d0\2\u0a49\u019d\3\2"+
		"\2\2\u0a4a\u0a4d\5\u01a0\u00d1\2\u0a4b\u0a4d\5\u01a8\u00d5\2\u0a4c\u0a4a"+
		"\3\2\2\2\u0a4c\u0a4b\3\2\2\2\u0a4d\u019f\3\2\2\2\u0a4e\u0a4f\5\u01a2\u00d2"+
		"\2\u0a4f\u0a50\7[\2\2\u0a50\u0a51\5\u01a6\u00d4\2\u0a51\u01a1\3\2\2\2"+
		"\u0a52\u0a5d\7h\2\2\u0a53\u0a55\7;\2\2\u0a54\u0a56\5\u0096L\2\u0a55\u0a54"+
		"\3\2\2\2\u0a55\u0a56\3\2\2\2\u0a56\u0a57\3\2\2\2\u0a57\u0a5d\7<\2\2\u0a58"+
		"\u0a59\7;\2\2\u0a59\u0a5a\5\u01a4\u00d3\2\u0a5a\u0a5b\7<\2\2\u0a5b\u0a5d"+
		"\3\2\2\2\u0a5c\u0a52\3\2\2\2\u0a5c\u0a53\3\2\2\2\u0a5c\u0a58\3\2\2\2\u0a5d"+
		"\u01a3\3\2\2\2\u0a5e\u0a63\7h\2\2\u0a5f\u0a60\7B\2\2\u0a60\u0a62\7h\2"+
		"\2\u0a61\u0a5f\3\2\2\2\u0a62\u0a65\3\2\2\2\u0a63\u0a61\3\2\2\2\u0a63\u0a64"+
		"\3\2\2\2\u0a64\u01a5\3\2\2\2\u0a65\u0a63\3\2\2\2\u0a66\u0a69\5\u019e\u00d0"+
		"\2\u0a67\u0a69\5\u00fc\177\2\u0a68\u0a66\3\2\2\2\u0a68\u0a67\3\2\2\2\u0a69"+
		"\u01a7\3\2\2\2\u0a6a\u0a6d\5\u01b0\u00d9\2\u0a6b\u0a6d\5\u01aa\u00d6\2"+
		"\u0a6c\u0a6a\3\2\2\2\u0a6c\u0a6b\3\2\2\2\u0a6d\u01a9\3\2\2\2\u0a6e\u0a6f"+
		"\5\u01ac\u00d7\2\u0a6f\u0a70\5\u01ae\u00d8\2\u0a70\u0a71\5\u019e\u00d0"+
		"\2\u0a71\u01ab\3\2\2\2\u0a72\u0a76\5:\36\2\u0a73\u0a76\5\u017c\u00bf\2"+
		"\u0a74\u0a76\5\u0182\u00c2\2\u0a75\u0a72\3\2\2\2\u0a75\u0a73\3\2\2\2\u0a75"+
		"\u0a74\3\2\2\2\u0a76\u01ad\3\2\2\2\u0a77\u0a78\t\5\2\2\u0a78\u01af\3\2"+
		"\2\2\u0a79\u0a81\5\u01b2\u00da\2\u0a7a\u0a7b\5\u01b2\u00da\2\u0a7b\u0a7c"+
		"\7I\2\2\u0a7c\u0a7d\5\u019e\u00d0\2\u0a7d\u0a7e\7J\2\2\u0a7e\u0a7f\5\u01b0"+
		"\u00d9\2\u0a7f\u0a81\3\2\2\2\u0a80\u0a79\3\2\2\2\u0a80\u0a7a\3\2\2\2\u0a81"+
		"\u01b1\3\2\2\2\u0a82\u0a83\b\u00da\1\2\u0a83\u0a84\5\u01b4\u00db\2\u0a84"+
		"\u0a8a\3\2\2\2\u0a85\u0a86\f\3\2\2\u0a86\u0a87\7P\2\2\u0a87\u0a89\5\u01b4"+
		"\u00db\2\u0a88\u0a85\3\2\2\2\u0a89\u0a8c\3\2\2\2\u0a8a\u0a88\3\2\2\2\u0a8a"+
		"\u0a8b\3\2\2\2\u0a8b\u01b3\3\2\2\2\u0a8c\u0a8a\3\2\2\2\u0a8d\u0a8e\b\u00db"+
		"\1\2\u0a8e\u0a8f\5\u01b6\u00dc\2\u0a8f\u0a95\3\2\2\2\u0a90\u0a91\f\3\2"+
		"\2\u0a91\u0a92\7O\2\2\u0a92\u0a94\5\u01b6\u00dc\2\u0a93\u0a90\3\2\2\2"+
		"\u0a94\u0a97\3\2\2\2\u0a95\u0a93\3\2\2\2\u0a95\u0a96\3\2\2\2\u0a96\u01b5"+
		"\3\2\2\2\u0a97\u0a95\3\2\2\2\u0a98\u0a99\b\u00dc\1\2\u0a99\u0a9a\5\u01b8"+
		"\u00dd\2\u0a9a\u0aa0\3\2\2\2\u0a9b\u0a9c\f\3\2\2\u0a9c\u0a9d\7X\2\2\u0a9d"+
		"\u0a9f\5\u01b8\u00dd\2\u0a9e\u0a9b\3\2\2\2\u0a9f\u0aa2\3\2\2\2\u0aa0\u0a9e"+
		"\3\2\2\2\u0aa0\u0aa1\3\2\2\2\u0aa1\u01b7\3\2\2\2\u0aa2\u0aa0\3\2\2\2\u0aa3"+
		"\u0aa4\b\u00dd\1\2\u0aa4\u0aa5\5\u01ba\u00de\2\u0aa5\u0aab\3\2\2\2\u0aa6"+
		"\u0aa7\f\3\2\2\u0aa7\u0aa8\7Y\2\2\u0aa8\u0aaa\5\u01ba\u00de\2\u0aa9\u0aa6"+
		"\3\2\2\2\u0aaa\u0aad\3\2\2\2\u0aab\u0aa9\3\2\2\2\u0aab\u0aac\3\2\2\2\u0aac"+
		"\u01b9\3\2\2\2\u0aad\u0aab\3\2\2\2\u0aae\u0aaf\b\u00de\1\2\u0aaf\u0ab0"+
		"\5\u01bc\u00df\2\u0ab0\u0ab6\3\2\2\2\u0ab1\u0ab2\f\3\2\2\u0ab2\u0ab3\7"+
		"W\2\2\u0ab3\u0ab5\5\u01bc\u00df\2\u0ab4\u0ab1\3\2\2\2\u0ab5\u0ab8\3\2"+
		"\2\2\u0ab6\u0ab4\3\2\2\2\u0ab6\u0ab7\3\2\2\2\u0ab7\u01bb\3\2\2\2\u0ab8"+
		"\u0ab6\3\2\2\2\u0ab9\u0aba\b\u00df\1\2\u0aba\u0abb\5\u01be\u00e0\2\u0abb"+
		"\u0ac4\3\2\2\2\u0abc\u0abd\f\4\2\2\u0abd\u0abe\7K\2\2\u0abe\u0ac3\5\u01be"+
		"\u00e0\2\u0abf\u0ac0\f\3\2\2\u0ac0\u0ac1\7N\2\2\u0ac1\u0ac3\5\u01be\u00e0"+
		"\2\u0ac2\u0abc\3\2\2\2\u0ac2\u0abf\3\2\2\2\u0ac3\u0ac6\3\2\2\2\u0ac4\u0ac2"+
		"\3\2\2\2\u0ac4\u0ac5\3\2\2\2\u0ac5\u01bd\3\2\2\2\u0ac6\u0ac4\3\2\2\2\u0ac7"+
		"\u0ac8\b\u00e0\1\2\u0ac8\u0ac9\5\u01c0\u00e1\2\u0ac9\u0adb\3\2\2\2\u0aca"+
		"\u0acb\f\7\2\2\u0acb\u0acc\7F\2\2\u0acc\u0ada\5\u01c0\u00e1\2\u0acd\u0ace"+
		"\f\6\2\2\u0ace\u0acf\7E\2\2\u0acf\u0ada\5\u01c0\u00e1\2\u0ad0\u0ad1\f"+
		"\5\2\2\u0ad1\u0ad2\7L\2\2\u0ad2\u0ada\5\u01c0\u00e1\2\u0ad3\u0ad4\f\4"+
		"\2\2\u0ad4\u0ad5\7M\2\2\u0ad5\u0ada\5\u01c0\u00e1\2\u0ad6\u0ad7\f\3\2"+
		"\2\u0ad7\u0ad8\7\34\2\2\u0ad8\u0ada\5\f\7\2\u0ad9\u0aca\3\2\2\2\u0ad9"+
		"\u0acd\3\2\2\2\u0ad9\u0ad0\3\2\2\2\u0ad9\u0ad3\3\2\2\2\u0ad9\u0ad6\3\2"+
		"\2\2\u0ada\u0add\3\2\2\2\u0adb\u0ad9\3\2\2\2\u0adb\u0adc\3\2\2\2\u0adc"+
		"\u01bf\3\2\2\2\u0add\u0adb\3\2\2\2\u0ade\u0adf\b\u00e1\1\2\u0adf\u0ae0"+
		"\5\u01c2\u00e2\2\u0ae0\u0af0\3\2\2\2\u0ae1\u0ae2\f\5\2\2\u0ae2\u0ae3\7"+
		"F\2\2\u0ae3\u0ae4\7F\2\2\u0ae4\u0aef\5\u01c2\u00e2\2\u0ae5\u0ae6\f\4\2"+
		"\2\u0ae6\u0ae7\7E\2\2\u0ae7\u0ae8\7E\2\2\u0ae8\u0aef\5\u01c2\u00e2\2\u0ae9"+
		"\u0aea\f\3\2\2\u0aea\u0aeb\7E\2\2\u0aeb\u0aec\7E\2\2\u0aec\u0aed\7E\2"+
		"\2\u0aed\u0aef\5\u01c2\u00e2\2\u0aee\u0ae1\3\2\2\2\u0aee\u0ae5\3\2\2\2"+
		"\u0aee\u0ae9\3\2\2\2\u0aef\u0af2\3\2\2\2\u0af0\u0aee\3\2\2\2\u0af0\u0af1"+
		"\3\2\2\2\u0af1\u01c1\3\2\2\2\u0af2\u0af0\3\2\2\2\u0af3\u0af4\b\u00e2\1"+
		"\2\u0af4\u0af5\5\u01c4\u00e3\2\u0af5\u0afe\3\2\2\2\u0af6\u0af7\f\4\2\2"+
		"\u0af7\u0af8\7S\2\2\u0af8\u0afd\5\u01c4\u00e3\2\u0af9\u0afa\f\3\2\2\u0afa"+
		"\u0afb\7T\2\2\u0afb\u0afd\5\u01c4\u00e3\2\u0afc\u0af6\3\2\2\2\u0afc\u0af9"+
		"\3\2\2\2\u0afd\u0b00\3\2\2\2\u0afe\u0afc\3\2\2\2\u0afe\u0aff\3\2\2\2\u0aff"+
		"\u01c3\3\2\2\2\u0b00\u0afe\3\2\2\2\u0b01\u0b02\b\u00e3\1\2\u0b02\u0b03"+
		"\5\u01c6\u00e4\2\u0b03\u0b0f\3\2\2\2\u0b04\u0b05\f\5\2\2\u0b05\u0b06\7"+
		"U\2\2\u0b06\u0b0e\5\u01c6\u00e4\2\u0b07\u0b08\f\4\2\2\u0b08\u0b09\7V\2"+
		"\2\u0b09\u0b0e\5\u01c6\u00e4\2\u0b0a\u0b0b\f\3\2\2\u0b0b\u0b0c\7Z\2\2"+
		"\u0b0c\u0b0e\5\u01c6\u00e4\2\u0b0d\u0b04\3\2\2\2\u0b0d\u0b07\3\2\2\2\u0b0d"+
		"\u0b0a\3\2\2\2\u0b0e\u0b11\3\2\2\2\u0b0f\u0b0d\3\2\2\2\u0b0f\u0b10\3\2"+
		"\2\2\u0b10\u01c5\3\2\2\2\u0b11\u0b0f\3\2\2\2\u0b12\u0b1a\5\u01c8\u00e5"+
		"\2\u0b13\u0b1a\5\u01ca\u00e6\2\u0b14\u0b15\7S\2\2\u0b15\u0b1a\5\u01c6"+
		"\u00e4\2\u0b16\u0b17\7T\2\2\u0b17\u0b1a\5\u01c6\u00e4\2\u0b18\u0b1a\5"+
		"\u01cc\u00e7\2\u0b19\u0b12\3\2\2\2\u0b19\u0b13\3\2\2\2\u0b19\u0b14\3\2"+
		"\2\2\u0b19\u0b16\3\2\2\2\u0b19\u0b18\3\2\2\2\u0b1a\u01c7\3\2\2\2\u0b1b"+
		"\u0b1c\7Q\2\2\u0b1c\u0b1d\5\u01c6\u00e4\2\u0b1d\u01c9\3\2\2\2\u0b1e\u0b1f"+
		"\7R\2\2\u0b1f\u0b20\5\u01c6\u00e4\2\u0b20\u01cb\3\2\2\2\u0b21\u0b28\5"+
		"\u01ce\u00e8\2\u0b22\u0b23\7H\2\2\u0b23\u0b28\5\u01c6\u00e4\2\u0b24\u0b25"+
		"\7G\2\2\u0b25\u0b28\5\u01c6\u00e4\2\u0b26\u0b28\5\u01d8\u00ed\2\u0b27"+
		"\u0b21\3\2\2\2\u0b27\u0b22\3\2\2\2\u0b27\u0b24\3\2\2\2\u0b27\u0b26\3\2"+
		"\2\2\u0b28\u01cd\3\2\2\2\u0b29\u0b2c\5\u0160\u00b1\2\u0b2a\u0b2c\5:\36"+
		"\2\u0b2b\u0b29\3\2\2\2\u0b2b\u0b2a\3\2\2\2\u0b2c\u0b31\3\2\2\2\u0b2d\u0b30"+
		"\5\u01d2\u00ea\2\u0b2e\u0b30\5\u01d6\u00ec\2\u0b2f\u0b2d\3\2\2\2\u0b2f"+
		"\u0b2e\3\2\2\2\u0b30\u0b33\3\2\2\2\u0b31\u0b2f\3\2\2\2\u0b31\u0b32\3\2"+
		"\2\2\u0b32\u01cf\3\2\2\2\u0b33\u0b31\3\2\2\2\u0b34\u0b35\5\u01ce\u00e8"+
		"\2\u0b35\u0b36\7Q\2\2\u0b36\u01d1\3\2\2\2\u0b37\u0b38\7Q\2\2\u0b38\u01d3"+
		"\3\2\2\2\u0b39\u0b3a\5\u01ce\u00e8\2\u0b3a\u0b3b\7R\2\2\u0b3b\u01d5\3"+
		"\2\2\2\u0b3c\u0b3d\7R\2\2\u0b3d\u01d7\3\2\2\2\u0b3e\u0b3f\7;\2\2\u0b3f"+
		"\u0b40\5\4\3\2\u0b40\u0b41\7<\2\2\u0b41\u0b42\5\u01c6\u00e4\2\u0b42\u0b5a"+
		"\3\2\2\2\u0b43\u0b44\7;\2\2\u0b44\u0b48\5\f\7\2\u0b45\u0b47\5(\25\2\u0b46"+
		"\u0b45\3\2\2\2\u0b47\u0b4a\3\2\2\2\u0b48\u0b46\3\2\2\2\u0b48\u0b49\3\2"+
		"\2\2\u0b49\u0b4b\3\2\2\2\u0b4a\u0b48\3\2\2\2\u0b4b\u0b4c\7<\2\2\u0b4c"+
		"\u0b4d\5\u01cc\u00e7\2\u0b4d\u0b5a\3\2\2\2\u0b4e\u0b4f\7;\2\2\u0b4f\u0b53"+
		"\5\f\7\2\u0b50\u0b52\5(\25\2\u0b51\u0b50\3\2\2\2\u0b52\u0b55\3\2\2\2\u0b53"+
		"\u0b51\3\2\2\2\u0b53\u0b54\3\2\2\2\u0b54\u0b56\3\2\2\2\u0b55\u0b53\3\2"+
		"\2\2\u0b56\u0b57\7<\2\2\u0b57\u0b58\5\u01a0\u00d1\2\u0b58\u0b5a\3\2\2"+
		"\2\u0b59\u0b3e\3\2\2\2\u0b59\u0b43\3\2\2\2\u0b59\u0b4e\3\2\2\2\u0b5a\u01d9"+
		"\3\2\2\2\u0b5b\u0b71\7\2\2\3\u0b5c\u0b60\7r\2\2\u0b5d\u0b5f\5\u01de\u00f0"+
		"\2\u0b5e\u0b5d\3\2\2\2\u0b5f\u0b62\3\2\2\2\u0b60\u0b5e\3\2\2\2\u0b60\u0b61"+
		"\3\2\2\2\u0b61\u0b63\3\2\2\2\u0b62\u0b60\3\2\2\2\u0b63\u0b64\5\u01dc\u00ef"+
		"\2\u0b64\u0b65\7s\2\2\u0b65\u0b66\7\2\2\3\u0b66\u0b71\3\2\2\2\u0b67\u0b69"+
		"\5\u01de\u00f0\2\u0b68\u0b67\3\2\2\2\u0b69\u0b6c\3\2\2\2\u0b6a\u0b68\3"+
		"\2\2\2\u0b6a\u0b6b\3\2\2\2\u0b6b\u0b6d\3\2\2\2\u0b6c\u0b6a\3\2\2\2\u0b6d"+
		"\u0b6e\5\u01dc\u00ef\2\u0b6e\u0b6f\7\2\2\3\u0b6f\u0b71\3\2\2\2\u0b70\u0b5b"+
		"\3\2\2\2\u0b70\u0b5c\3\2\2\2\u0b70\u0b6a\3\2\2\2\u0b71\u01db\3\2\2\2\u0b72"+
		"\u0b76\5\u01e0\u00f1\2\u0b73\u0b75\5\u01de\u00f0\2\u0b74\u0b73\3\2\2\2"+
		"\u0b75\u0b78\3\2\2\2\u0b76\u0b74\3\2\2\2\u0b76\u0b77\3\2\2\2\u0b77\u0b8f"+
		"\3\2\2\2\u0b78\u0b76\3\2\2\2\u0b79\u0b7b\5\u01de\u00f0\2\u0b7a\u0b79\3"+
		"\2\2\2\u0b7b\u0b7e\3\2\2\2\u0b7c\u0b7a\3\2\2\2\u0b7c\u0b7d\3\2\2\2\u0b7d"+
		"\u0b7f\3\2\2\2\u0b7e\u0b7c\3\2\2\2\u0b7f\u0b8f\5\u01ee\u00f8\2\u0b80\u0b82"+
		"\5\u01e0\u00f1\2\u0b81\u0b83\7o\2\2\u0b82\u0b81\3\2\2\2\u0b83\u0b84\3"+
		"\2\2\2\u0b84\u0b82\3\2\2\2\u0b84\u0b85\3\2\2\2\u0b85\u0b89\3\2\2\2\u0b86"+
		"\u0b88\5\u01de\u00f0\2\u0b87\u0b86\3\2\2\2\u0b88\u0b8b\3\2\2\2\u0b89\u0b87"+
		"\3\2\2\2\u0b89\u0b8a\3\2\2\2\u0b8a\u0b8c\3\2\2\2\u0b8b\u0b89\3\2\2\2\u0b8c"+
		"\u0b8d\5\u01ee\u00f8\2\u0b8d\u0b8f\3\2\2\2\u0b8e\u0b72\3\2\2\2\u0b8e\u0b7c"+
		"\3\2\2\2\u0b8e\u0b80\3\2\2\2\u0b8f\u01dd\3\2\2\2\u0b90\u0b91\t\6\2\2\u0b91"+
		"\u01df\3\2\2\2\u0b92\u0b9c\5\u01e2\u00f2\2\u0b93\u0b95\5\u01ec\u00f7\2"+
		"\u0b94\u0b93\3\2\2\2\u0b95\u0b96\3\2\2\2\u0b96\u0b94\3\2\2\2\u0b96\u0b97"+
		"\3\2\2\2\u0b97\u0b98\3\2\2\2\u0b98\u0b99\5\u01e2\u00f2\2\u0b99\u0b9b\3"+
		"\2\2\2\u0b9a\u0b94\3\2\2\2\u0b9b\u0b9e\3\2\2\2\u0b9c\u0b9a\3\2\2\2\u0b9c"+
		"\u0b9d\3\2\2\2\u0b9d\u01e1\3\2\2\2\u0b9e\u0b9c\3\2\2\2\u0b9f\u0ba3\5\u01e4"+
		"\u00f3\2\u0ba0\u0ba2\5\u01e8\u00f5\2\u0ba1\u0ba0\3\2\2\2\u0ba2\u0ba5\3"+
		"\2\2\2\u0ba3\u0ba1\3\2\2\2\u0ba3\u0ba4\3\2\2\2\u0ba4\u0bae\3\2\2\2\u0ba5"+
		"\u0ba3\3\2\2\2\u0ba6\u0baa\5\u01fa\u00fe\2\u0ba7\u0ba9\5\u01e8\u00f5\2"+
		"\u0ba8\u0ba7\3\2\2\2\u0ba9\u0bac\3\2\2\2\u0baa\u0ba8\3\2\2\2\u0baa\u0bab"+
		"\3\2\2\2\u0bab\u0bae\3\2\2\2\u0bac\u0baa\3\2\2\2\u0bad\u0b9f\3\2\2\2\u0bad"+
		"\u0ba6\3\2\2\2\u0bae\u01e3\3\2\2\2\u0baf\u0bb1\7p\2\2\u0bb0\u0baf\3\2"+
		"\2\2\u0bb0\u0bb1\3\2\2\2\u0bb1\u0bb3\3\2\2\2\u0bb2\u0bb4\5\u01e6\u00f4"+
		"\2\u0bb3\u0bb2\3\2\2\2\u0bb4\u0bb5\3\2\2\2\u0bb5\u0bb3\3\2\2\2\u0bb5\u0bb6"+
		"\3\2\2\2\u0bb6\u0bbc\3\2\2\2\u0bb7\u0bbb\5\u01e6\u00f4\2\u0bb8\u0bbb\7"+
		"p\2\2\u0bb9\u0bbb\7i\2\2\u0bba\u0bb7\3\2\2\2\u0bba\u0bb8\3\2\2\2\u0bba"+
		"\u0bb9\3\2\2\2\u0bbb\u0bbe\3\2\2\2\u0bbc\u0bba\3\2\2\2\u0bbc\u0bbd\3\2"+
		"\2\2\u0bbd\u01e5\3\2\2\2\u0bbe\u0bbc\3\2\2\2\u0bbf\u0bc0\t\7\2\2\u0bc0"+
		"\u01e7\3\2\2\2\u0bc1\u0bc4\5\u01fa\u00fe\2\u0bc2\u0bc4\5\u01ea\u00f6\2"+
		"\u0bc3\u0bc1\3\2\2\2\u0bc3\u0bc2\3\2\2\2\u0bc4\u01e9\3\2\2\2\u0bc5\u0bc9"+
		"\5\u01e6\u00f4\2\u0bc6\u0bc9\7p\2\2\u0bc7\u0bc9\7i\2\2\u0bc8\u0bc5\3\2"+
		"\2\2\u0bc8\u0bc6\3\2\2\2\u0bc8\u0bc7\3\2\2\2\u0bc9\u0bca\3\2\2\2\u0bca"+
		"\u0bc8\3\2\2\2\u0bca\u0bcb\3\2\2\2\u0bcb\u01eb\3\2\2\2\u0bcc\u0bcd\7o"+
		"\2\2\u0bcd\u01ed\3\2\2\2\u0bce\u0bd0\5\u01f0\u00f9\2\u0bcf\u0bce\3\2\2"+
		"\2\u0bd0\u0bd1\3\2\2\2\u0bd1\u0bcf\3\2\2\2\u0bd1\u0bd2\3\2\2\2\u0bd2\u01ef"+
		"\3\2\2\2\u0bd3\u0bd5\7p\2\2\u0bd4\u0bd3\3\2\2\2\u0bd4\u0bd5\3\2\2\2\u0bd5"+
		"\u0bd6\3\2\2\2\u0bd6\u0bd7\7i\2\2\u0bd7\u0bd9\5\u01f2\u00fa\2\u0bd8\u0bda"+
		"\7p\2\2\u0bd9\u0bd8\3\2\2\2\u0bd9\u0bda\3\2\2\2\u0bda\u0bde\3\2\2\2\u0bdb"+
		"\u0bdd\5\u01f4\u00fb\2\u0bdc\u0bdb\3\2\2\2\u0bdd\u0be0\3\2\2\2\u0bde\u0bdc"+
		"\3\2\2\2\u0bde\u0bdf\3\2\2\2\u0bdf\u01f1\3\2\2\2\u0be0\u0bde\3\2\2\2\u0be1"+
		"\u0be2\7n\2\2\u0be2\u01f3\3\2\2\2\u0be3\u0be7\5\u01f6\u00fc\2\u0be4\u0be7"+
		"\5\u01fa\u00fe\2\u0be5\u0be7\7o\2\2\u0be6\u0be3\3\2\2\2\u0be6\u0be4\3"+
		"\2\2\2\u0be6\u0be5\3\2\2\2\u0be7\u01f5\3\2\2\2\u0be8\u0bea\5\u01f8\u00fd"+
		"\2\u0be9\u0be8\3\2\2\2\u0bea\u0beb\3\2\2\2\u0beb\u0be9\3\2\2\2\u0beb\u0bec"+
		"\3\2\2\2\u0bec\u01f7\3\2\2\2\u0bed\u0bee\t\b\2\2\u0bee\u01f9\3\2\2\2\u0bef"+
		"\u0bf0\7t\2\2\u0bf0\u0bf4\5\u01fc\u00ff\2\u0bf1\u0bf3\7p\2\2\u0bf2\u0bf1"+
		"\3\2\2\2\u0bf3\u0bf6\3\2\2\2\u0bf4\u0bf2\3\2\2\2\u0bf4\u0bf5\3\2\2\2\u0bf5"+
		"\u0bf8\3\2\2\2\u0bf6\u0bf4\3\2\2\2\u0bf7\u0bf9\5\u01fe\u0100\2\u0bf8\u0bf7"+
		"\3\2\2\2\u0bf8\u0bf9\3\2\2\2\u0bf9\u0bfa\3\2\2\2\u0bfa\u0bfb\7>\2\2\u0bfb"+
		"\u01fb\3\2\2\2\u0bfc\u0bfd\7n\2\2\u0bfd\u01fd\3\2\2\2\u0bfe\u0c00\5\u0202"+
		"\u0102\2\u0bff\u0bfe\3\2\2\2\u0c00\u0c01\3\2\2\2\u0c01\u0bff\3\2\2\2\u0c01"+
		"\u0c02\3\2\2\2\u0c02\u01ff\3\2\2\2\u0c03\u0c07\7=\2\2\u0c04\u0c06\5\u0202"+
		"\u0102\2\u0c05\u0c04\3\2\2\2\u0c06\u0c09\3\2\2\2\u0c07\u0c05\3\2\2\2\u0c07"+
		"\u0c08\3\2\2\2\u0c08\u0c0a\3\2\2\2\u0c09\u0c07\3\2\2\2\u0c0a\u0c0b\7>"+
		"\2\2\u0c0b\u0201\3\2\2\2\u0c0c\u0c1b\5\u0200\u0101\2\u0c0d\u0c17\5\u0204"+
		"\u0103\2\u0c0e\u0c10\7o\2\2\u0c0f\u0c0e\3\2\2\2\u0c10\u0c13\3\2\2\2\u0c11"+
		"\u0c0f\3\2\2\2\u0c11\u0c12\3\2\2\2\u0c12\u0c14\3\2\2\2\u0c13\u0c11\3\2"+
		"\2\2\u0c14\u0c16\5\u0204\u0103\2\u0c15\u0c11\3\2\2\2\u0c16\u0c19\3\2\2"+
		"\2\u0c17\u0c15\3\2\2\2\u0c17\u0c18\3\2\2\2\u0c18\u0c1b\3\2\2\2\u0c19\u0c17"+
		"\3\2\2\2\u0c1a\u0c0c\3\2\2\2\u0c1a\u0c0d\3\2\2\2\u0c1b\u0203\3\2\2\2\u0c1c"+
		"\u0c1d\t\t\2\2\u0c1d\u0205\3\2\2\2\u0168\u020b\u0212\u0216\u021a\u0223"+
		"\u0227\u022b\u022d\u0233\u0238\u023f\u0244\u0246\u024c\u0251\u0256\u025b"+
		"\u0266\u0274\u0279\u0281\u0288\u028e\u0293\u029e\u02a1\u02af\u02b4\u02b9"+
		"\u02be\u02c4\u02ce\u02d6\u02e0\u02e8\u02f4\u02f8\u02fd\u0303\u030b\u0318"+
		"\u0335\u0339\u033e\u0344\u0347\u034a\u0356\u0361\u036f\u0376\u037f\u0386"+
		"\u038b\u0391\u03a0\u03a7\u03ad\u03b1\u03b5\u03b9\u03bd\u03c2\u03c6\u03ca"+
		"\u03cc\u03d1\u03d8\u03dd\u03df\u03e5\u03ea\u03ee\u0401\u0406\u040c\u041c"+
		"\u0421\u0427\u042d\u042f\u0433\u0438\u043c\u0444\u044b\u0453\u0456\u045b"+
		"\u0463\u0468\u046f\u0476\u047b\u0481\u048d\u0492\u0496\u04a0\u04a5\u04ad"+
		"\u04b0\u04b5\u04bd\u04c0\u04c5\u04ca\u04cf\u04d4\u04db\u04e0\u04e8\u04ed"+
		"\u04f2\u04f7\u04fd\u0503\u0506\u0509\u0512\u0518\u051e\u0521\u0524\u052c"+
		"\u0531\u0536\u053c\u053f\u054a\u0553\u055d\u0562\u056d\u0572\u0578\u0584"+
		"\u0589\u0595\u059f\u05a4\u05ac\u05af\u05b6\u05be\u05c4\u05cd\u05d7\u05db"+
		"\u05de\u05e7\u05f5\u05f8\u0601\u0606\u060d\u0612\u061a\u0626\u062d\u063b"+
		"\u0651\u0673\u067f\u0685\u0691\u069e\u06b8\u06bc\u06c1\u06c5\u06c9\u06d1"+
		"\u06d5\u06d9\u06e0\u06e9\u06f1\u0700\u070c\u0712\u0718\u072d\u0732\u0738"+
		"\u0744\u074f\u0759\u075c\u0761\u076a\u0770\u077a\u077f\u0788\u079f\u07a9"+
		"\u07bf\u07c6\u07ce\u07d6\u07e1\u07f8\u0802\u080d\u0823\u0827\u082c\u0834"+
		"\u083a\u083e\u0842\u0846\u084c\u0851\u0856\u085a\u085e\u0864\u0869\u086e"+
		"\u0872\u0876\u0878\u087d\u0882\u0887\u088b\u088f\u0893\u0898\u08a0\u08a6"+
		"\u08aa\u08ae\u08b2\u08b8\u08bd\u08c2\u08c6\u08ca\u08cc\u08d1\u08e0\u08ee"+
		"\u08fa\u0903\u0912\u091f\u0928\u092e\u0935\u093a\u0941\u0946\u094d\u0952"+
		"\u0959\u095e\u0966\u096b\u096f\u0973\u0978\u097f\u0986\u098b\u0992\u0997"+
		"\u099e\u09a3\u09ab\u09b0\u09b4\u09bb\u09c1\u09c8\u09cf\u09d6\u09de\u09e5"+
		"\u09ed\u09f1\u09f8\u09ff\u0a06\u0a0e\u0a15\u0a1d\u0a23\u0a29\u0a35\u0a3b"+
		"\u0a41\u0a4c\u0a55\u0a5c\u0a63\u0a68\u0a6c\u0a75\u0a80\u0a8a\u0a95\u0aa0"+
		"\u0aab\u0ab6\u0ac2\u0ac4\u0ad9\u0adb\u0aee\u0af0\u0afc\u0afe\u0b0d\u0b0f"+
		"\u0b19\u0b27\u0b2b\u0b2f\u0b31\u0b48\u0b53\u0b59\u0b60\u0b6a\u0b70\u0b76"+
		"\u0b7c\u0b84\u0b89\u0b8e\u0b96\u0b9c\u0ba3\u0baa\u0bad\u0bb0\u0bb5\u0bba"+
		"\u0bbc\u0bc3\u0bc8\u0bca\u0bd1\u0bd4\u0bd9\u0bde\u0be6\u0beb\u0bf4\u0bf8"+
		"\u0c01\u0c07\u0c11\u0c17\u0c1a";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}