
%{
	import java.util.*;

	@SuppressWarnings({"unchecked"})
%}

%language "Java"
%define package hephaestos.languages.scalararithmetic;
%define extends {AbstractScalarTermParser}
%define parser_class_name {ScalarTermParser}
%define public

/* Arithmetic */
%token NUMBER
%token IDENTIFIER
%token PLUS
%token MINUS
%token MULTIPLY
%token DIVIDE
%token POWER

/* Punctuation */
%token LPAREN
%token RPAREN
%token COMMA

%left MINUS PLUS
%left DIVIDE MULTIPLY
%right POWER
%left NEGATIVE

%%
input: scalarterm;

/*==================== Arithmetic  ====================*/
scalarterm:
	NUMBER { 
		try {
			$$ = new Real( (String)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:NUMBER");
			System.err.println( e );
		}
	}
	| IDENTIFIER LPAREN argumentlist RPAREN {
		try {
			$$ = new ScalarGenericFunctionTerm( (String)$1, ((ArrayList<ScalarTerm>)$3) );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:IDENTIFIER LPAREN argumentlist RPAREN");
			System.err.println( e );
		}
	}
	| IDENTIFIER { 
		try {
			$$ = new RealVariable( (String)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:IDENTIFIER");
			System.err.println( e );
		}
	}
	| LPAREN scalarterm RPAREN { 
		try {
			$$ = (ScalarTerm)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:LPAREN scalarterm RPAREN");
			System.err.println( e );
		}
	}
	| scalarterm PLUS scalarterm { 
		try {
			$$ = new ScalarAdditionTerm( (ScalarTerm)$1, (ScalarTerm)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:scalarterm PLUS scalarterm");
			System.err.println( e );
		}
	}
	| scalarterm MINUS scalarterm { 
		try {
			$$ = new ScalarSubtractionTerm( (ScalarTerm)$1, (ScalarTerm)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:scalarterm MINUS scalarterm");
			System.err.println( e );
		}
	}
	| scalarterm MULTIPLY scalarterm { 
		try {
			$$ = new ScalarMultiplicationTerm( (ScalarTerm)$1, (ScalarTerm)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:scalarterm ASTERISK scalarterm");
			System.err.println( e );
		}
	}
	| scalarterm DIVIDE scalarterm { 
		try {
			$$ = new ScalarDivisionTerm( (ScalarTerm)$1, (ScalarTerm)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:scalarterm DIVIDE scalarterm");
			System.err.println( e );
		}
	}
	| scalarterm POWER scalarterm { 
		try {
			$$ = new ScalarPowerTerm( (ScalarTerm)$1, (ScalarTerm)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:scalarterm POWER tscalarterm:scalarterm POWER scalarterm");
			System.err.println( e );
		}
	}
	| MINUS scalarterm %prec NEGATIVE { 
		try {
			$$ = new ScalarSubtractionTerm( new Real("0"), (ScalarTerm)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location scalarterm:MINUS scalarterm");
			System.err.println( e );
		}
	}
;

argumentlist:
	%empty {
		$$ = null;
	}
	| scalarterm	{ 
		try {
			ArrayList<ScalarTerm> args = new ArrayList<ScalarTerm>();
			args.add( (ScalarTerm)$1 );
			$$ = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:scalarterm");
			System.err.println( e );
		}
	}
	| argumentlist COMMA scalarterm { 
		try {
			ArrayList<ScalarTerm> args = new ArrayList<ScalarTerm>();
			args.addAll( (ArrayList<ScalarTerm>)$1 );
			args.add( (ScalarTerm)$3 );
			$$ = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:argumentlist COMMA scalarterm");
			System.err.println( e );
		}
	}
;

/*============================================================*/
%%




