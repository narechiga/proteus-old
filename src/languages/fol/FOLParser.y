
%{
	import hephaestos.languages.scalararithmetic.*;
	import java.util.*;

	@SuppressWarnings({"unchecked"})
%}

%language "Java"
%define package hephaestos.languages.fol
%define extends {FOLParser}
%define extends {AbstractFOLParser}
%define public

/* Arithmetic */
%token SCALARTERM
%token MATRIXTERM /* not yet implemented :P */

/* Comparisons */
%token GT
%token GEQ
%token LT
%token LEQ
%token EQUAL

/* Punctuation */
%token LPAREN
%token RPAREN

/* logic stuff */
%token AND
%token OR
%token NOT
%token IMPLIES
%token IFF
%token FORALL
%token EXISTS
%token TRUE
%token FALSE

%right IMPLIES IFF
%right OR AND
%left NOT

%%
input: 
;

/*==================== First-order logic ====================*/
folformula:
	TRUE { 
		try {
			$$ = new TrueFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:TRUE");
			System.err.println( e );
		}
	}
	| FALSE	{ 
		try {
			$$ = new FalseFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:FALSE");
			System.err.println( e );
		}
	}
	| comparison { 
		try {
			$$ = (ComparisonFormula)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:comparison");
			System.err.println( e );
		}
	}
	| folformula AND folformula { 
		try {
			$$ = new AndFormula( (FOLFormula)$1, (FOLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:folformula AND folformula");
			System.err.println( e );
		}
	}
	| folformula OR folformula { 
		try {
			$$ = new OrFormula( (FOLFormula)$1, (FOLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:folformula OR folformula");
			System.err.println( e );
		}
	}
	| NOT folformula	{ 
		try {
			$$ = new NotFormula( (FOLFormula)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:NOT folformula");
			System.err.println( e );
		}
	}
	| LPAREN folformula RPAREN { 
		try {
			$$ = (FOLFormula)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:LPAREN folformula RPAREN");
			System.err.println( e );
		}
	}
	| folformula IMPLIES folformula { 
		try {
			$$ = new ImpliesFormula( (FOLFormula)$1, (FOLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:folformula IMPLIES folformula");
			System.err.println( e );
		}
	}
	| folformula IFF folformula { 
		try {
			$$ = new IffFormula( (FOLFormula)$1, (FOLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:folformula IFF folformula");
			System.err.println( e );
		}
	}
	| FORALL IDENTIFIER SEMICOLON folformula %prec QUANTIFIER { 
		try {
			$$ = new ForAllFormula( new RealVariable( (String)$2), (FOLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:FORALL IDENTIFIER SEMICOLON folformula");
			System.err.println( e );
		}
	}
	| EXISTS IDENTIFIER SEMICOLON folformula %prec QUANTIFIER { 
		try {
			$$ = new ExistsFormula( new RealVariable( (String)$2 ), (FOLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location folformula:EXISTS IDENTIFIER SEMICOLON folformula");
			System.err.println( e );
		}
	}
;

term:
	SCALARTERM {
	}
	| MATRIXTERM {
	}
;

comparison:
	SCALARTERM LEQ SCALARTERM {
	} 
	| SCALARTERM LT SCALARTERM {
	}
	| SCALARTERM EQUAL SCALARTERM {
	}
	| SCALARTERM GT SCALARTERM {
	}
	| SCALARTERM GEQ SCALARTERM {
	}
;


/*============================================================*/
%%




