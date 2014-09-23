package manticore.dl;


%%

%public
%class ScalarTermLexer
%implements ScalarTermParser.Lexer
%int
%unicode
%line
%column

%{
	boolean debug = false;
	public Object getLVal() {
		return yytext();
	}

	public void yyerror ( String S ) {
		System.err.println( S );
	}
%}


IdentifierName = [a-zA-Z_]+[a-z0-9A-Z_]*
Number = [0-9]+ \.?[0-9]* | [0-9]+ \.?[0-9]* e [-]?[0-9]+ | [0-9]+ \.?[0-9]* E [-]?[0-9]+

InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n|\n;
WhiteSpace     = {LineTerminator} | [ \t\f]

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
/**/
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}


%%
<YYINITIAL> {
	{WhiteSpace} { 
		if ( debug ) {
			System.out.println("Lexer: space");
			System.out.println("Lexer @ " + yytext() );
		}
	}
	{Comment} {
		if ( debug ) {
			System.out.println("Lexer: comment");	
			System.out.println("Lexer @ " + yytext() );
		}
	}

	// Punctuation
	"(" { 
		if ( debug ) {
			System.out.println("Lexer: LPAREN");
			System.out.println("Lexer @ " + yytext() );
		}
		return LPAREN;
	}
	"," { 
		if ( debug ) {
			System.out.println("Lexer: COMMA");
			System.out.println("Lexer @ " + yytext() );
		}
		return COMMA;
	}
	")" { 
		if ( debug ) {
			System.out.println("Lexer: RPAREN");
			System.out.println("Lexer @ " + yytext() );
		}
		return RPAREN;
	}
	
	// Basic arithmetic
	"+" { 
		if ( debug ) {
			System.out.println("Lexer: PLUS");
			System.out.println("Lexer @ " + yytext() );
		}
		return PLUS;
	}
	"*" { 
		if ( debug ) {
			System.out.println("Lexer: MULTIPLY");
			System.out.println("Lexer @ " + yytext() );
		}
		return MULTIPLY;
	}
	"-" { 
		if ( debug ) {
			System.out.println("Lexer: MINUS");
			System.out.println("Lexer @ " + yytext() );
		}
		return MINUS;
	}
	"/" { 
		if ( debug ) {
			System.out.println("Lexer: DIVIDE");
			System.out.println("Lexer @ " + yytext() );
		}
		return DIVIDE;
	}
	"^" { 		
		if ( debug ) {
			System.out.println("Lexer: POWER");
			System.out.println("Lexer @ " + yytext() );
		}
		return POWER;		
	}
	{Number} { 
		if ( debug ) {
			System.out.println("Lexer: NUMBER");
			System.out.println("Lexer @ " + yytext() );
		}
		return NUMBER;
	}
	
	{IdentifierName} { 
		if ( debug ) {
			System.out.println("Lexer: IDENTIFIER");
			System.out.println("Lexer @ " + yytext() );
		}
		return IDENTIFIER;
	}
	
	[^] { 
		System.out.println("Lexer: I'm confused, throwing error");
		System.out.println("Lexer @ " + yytext() );
		return YYParser.YYERROR;
	}
}


