
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

%token INEQUALITY

/* Punctuation */
%token LPAREN
%token RPAREN

/* First Order Logic */
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

%right INEQUALITY /* <, >, <=, >=, =, != */
%left MINUS PLUS
%left DIVIDE MULTIPLY
%right POWER
%left NEGATIVE

/*%type <String> input keymaerablock problemblock schemavarsblock rulesblock schematext varblock funblock functiondeclaration argumentdeclaration annotationblock valuation
%type <ArrayList<String>> varinitlist
%type <ArrayList<RealVariable>> varlist vardeclaration
%type <ExplicitODE> ode
%type <dLFormula> dLformula 
%type <ConcreteAssignmentProgram> concreteassignment 
%type <ArbitraryAssignmentProgram> arbitraryassignment 
%type <TestProgram> test
%type <ComparisonFormula> comparison
%type <Term> term
%type <HybridProgram> hybridprogram
%type <ContinuousProgram> odesystem
%type <ArrayList<dLStructure>> odelist 
%type <ArrayList<dLFormula>> annotationlist
%type <ArrayList<Term>> argumentlist

%type <String> EXTERNAL FUNCTIONS RULES SCHEMAVARIABLES SCHEMATEXT PROBLEM ASSIGN PRIME OPENBRACE CLOSEBRACE EQUALS TEST CUP ASTERISK REALDECLARATION OPENBOX CLOSEBOX OPENDIAMOND CLOSEDIAMOND NUMBER IDENTIFIER PLUS MINUS ASTERISK DIVIDE POWER NEWLINE INEQUALITY LPAREN RPAREN SEMICOLON COMMA AND OR NOT IMPLIES IFF FORALL EXISTS TRUE FALSE 
*/

%%
input: 
	OPENBRACE valuation CLOSEBRACE {
		try {
			$$ = (String)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location input:valuation");
			System.err.println( e );
		}
	}
	| dLformula OPENBRACE valuation CLOSEBRACE {
		try {
			parsedStructure = (dLFormula)$1; // valuation has already been handled
			$$ = (String)$3; 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula OPENBRACE valuation CLOSEBRACE");
			System.err.println( e );
		}
	}
	| hybridprogram OPENBRACE valuation CLOSEBRACE {
		try {
			parsedStructure = (HybridProgram)$1; // valuation has already been handled
			$$ = (String)$3; 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula OPENBRACE valuation CLOSEBRACE");
			System.err.println( e );
		}
	}
	| keymaerablock { 
		try {
			$$ = (String)$1; System.out.println("full block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:keymaerablock");
			System.err.println( e );
		}
	}
	| funblock { 
		try {
			$$ = (String)$1; System.out.println("function block");
		} catch ( Exception e ) {
			System.err.println("Exception at location input:funblock");
			System.err.println( e );
		}
	}
	| varblock { 
		try {
			$$ = (String)$1; System.out.println("variable declaration block");
		} catch ( Exception e ) {
			System.err.println("Exception at location input:varblock");
			System.err.println( e );
		}
	}
	| schemavarsblock { 
		try {
			$$ = (String)$1; System.out.println("schema variables block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:schemavarsblock");
			System.err.println( e );
		}
			
	}
	| rulesblock { 
		try {
			$$ = (String)$1; System.out.println("rules block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:rulesblock");
			System.err.println( e );
		}
	}
	| dLformula { 
		try {
			//System.out.println("Found: dLformula"); 
			parsedStructure = (dLFormula)$1;	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula");
			System.err.println( e );
		}
	}
	| hybridprogram {
		try {
			$$ = "hybrid program"; 
			parsedStructure = (HybridProgram)$1;	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:hybridprogram");
			System.err.println( e );
		}
	}
	| annotationblock {
		try {
			$$ = (String)$1; System.out.println("annotation block"); //System.out.println($$); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:annotationblock");
			System.err.println( e );
		}
	} 
	| term {
		try {
			$$ = ((Term)$1).toKeYmaeraString();
			parsedStructure = (Term)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location input:term");
			System.err.println( e );
		}
	}
	| eitoolblock {
		try {
			$$ = "Sucessfully parsed EITool input file";	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:eitoolblock");
			System.err.println( e );
		}
	}
	| error {
		System.err.println("Parser: I'm confused, throwing error");
		System.out.println( (String)$1 );
		//System.exit(1);
	}
;


/*==================== Block as it would occur in a KeYmaera input file ====================*/
keymaerablock:
	problemblock { 
		try{
			$$ = (String)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:problemblock");
			System.err.println( e );
		}
	}
	| funblock problemblock { 
		try{
			$$ = (String)$1 + (String)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:funblock problemblock");
			System.err.println( e );
		}
	}
	| funblock schemavarsblock rulesblock problemblock { 
		try{
			$$ = (String)$1 + (String)$2 + (String)$3 + (String)$4;
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:funblock schemavarsblock rulesblock problemblock");
			System.err.println( e );
		}
	}
	| schemavarsblock rulesblock funblock problemblock { 
		try{
			$$ = (String)$1 + (String)$2 + (String)$3 + (String)$4;
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:schemavarsblock rulesblock funblock problemblock");
			System.err.println( e );
		}
	}
	| schemavarsblock rulesblock problemblock { 
		try{
			$$ = (String)$1 + (String)$2 + (String)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:schemavarsblock rulesblock problemblock");
			System.err.println( e );
		}
	}
	| annotationblock keymaerablock {
		try{
			$$ = (String)$1 + (String)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:keymaerablock");
			System.err.println( e );
		}
	}
;

problemblock:
	PROBLEM OPENBRACE dLformula CLOSEBRACE { 
		try {
			parsedStructure = (dLFormula)$3;
			$$ = "{\n" + ((dLStructure)$3).toString() + "\n}"; System.out.println( $$ );
		} catch ( Exception e ) {
			System.err.println("Exception at location problemblock:PROBLEM OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	}
	| PROBLEM OPENBRACE varblock dLformula CLOSEBRACE { 
		try {
			parsedStructure = (dLFormula)$4;
			$$ = "{\n" + (String)$3 + "\n" + ((dLStructure)$4).toString() + "\n}"; System.out.println($$);
		} catch ( Exception e ) {
			System.err.println("Exception at location problemblock:PROBLEM OPENBRACE varblock dLformula CLOSEBRACE");
			System.err.println( e );
		}
	}
;

/*============================================================*/
/*==================== Input file for EITool ====================*/
eitoolblock: statevarblock eiparameterblock envelopeblock invariantblock robustparameterblock domainblock controllawblock {
		try {
			synthesis = false;
		} catch ( Exception e ) {
			System.err.println("Exception at location eitoolblock: statevarblock eiparameterblock envelopeblock invariantblock robustparameterblock controllawblock");
			System.err.println( e );
		}
	}
	| statevarblock eiparameterblock envelopeblock invariantblock robustparameterblock domainblock controltemplateblock {
		try {
			synthesis = true;
		} catch ( Exception e ) {
			System.err.println("Exception at location eitoolblock: statevarblock eiparameterblock envelopeblock invariantblock robustparameterblock controltemplateblock");
			System.err.println( e );
		}
	}
;
statevarblock: STATEVARIABLES OPENBRACE varlist CLOSEBRACE {
		try {
			statevariables = (ArrayList<RealVariable>)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location statevarblock: STATEVARIABLES OPENBRACE varlist CLOSEBRACE");
			System.err.println( e );
		}
	}
;

eiparameterblock: EIPARAMETERS OPENBRACE varlist CLOSEBRACE {
		try {
			eiparameters = (ArrayList<RealVariable>)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location eiparameterblock: EIPARAMETERS OPENBRACE varlist CLOSEBRACE");
			System.err.println( e );
		}
	}
;


envelopeblock: ENVELOPE OPENBRACE dLformula CLOSEBRACE {
		try {
			envelope = (dLFormula)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location envelopeblock: ENVELOPE OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	}
;

invariantblock: INVARIANT OPENBRACE dLformula CLOSEBRACE {
		try {
			invariant = (dLFormula)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location invariantblock: INVARIANT OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	}
;

robustparameterblock: ROBUSTPARAMETERS OPENBRACE dLformula CLOSEBRACE {
		try {
			robustparameters = (dLFormula)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location robustparametersblock: ROBUSTPARAMETERS OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	} /*| ROBUSTPARAMETERS OPENBRACE valuation CLOSEBRACE {
		try {
			$$ = "single valuation parameters: (String)$3";
		} catch ( Exception e ) {
			System.err.println("Exception at location robustparametersblock: ROBUSTPARAMETERS OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}

	}*/
;

domainblock: DOMAIN OPENBRACE dLformula CLOSEBRACE {
		try {
			domain = (dLFormula)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location invariantblock: INVARIANT OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	}
;


controllawblock: CONTROLLAW OPENBRACE dLformula CLOSEBRACE {
		try {
			control = (dLFormula)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location controllawblock: CONTROLLAW OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	}
;
controltemplateblock: CONTROLTEMPLATE OPENBRACE dLformula CLOSEBRACE {
		try {
			control = (dLFormula)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location controltemplateblock: CONTROLTEMPLATE OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	}
;



/*============================================================*/

/*==================== Valuations, for command-line interface ====================*/
valuation:
	%empty
	| IDENTIFIER IMPLIES NUMBER {
		try {
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}

			this.valuation.put( new RealVariable( (String)$1 ), new Real( (String)$3 ) );
			$$ = "(valuation " +  (String)$1 + "->" + (String)$3 + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:IDENTIFIER IMPLIES NUMBER");
			System.err.println( e );
		}
		
	}
	| IDENTIFIER IMPLIES MINUS NUMBER {
		try {
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}

			this.valuation.put( new RealVariable( (String)$1 ), new Real( "-" + (String)$4 ) );
			$$ = "(valuation " +  (String)$1 + "->" + "-" + (String)$3 + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:IDENTIFIER IMPLIES MINUS NUMBER");
			System.err.println( e );
		}
		
	}
	| valuation COMMA IDENTIFIER IMPLIES NUMBER {
		try{
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}
			this.valuation.put( new RealVariable( (String)$3 ), new Real( (String)$5 ) );
			$$ = (String)$1 + "\n" + "(valuation " +  (String)$3 + "->" + (String)$5 + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:valuation COMMA IDENTIFIER IMPLIES NUMBER");
			System.err.println( e );
		}
	}
	| valuation COMMA IDENTIFIER IMPLIES MINUS NUMBER {
		try{
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}
			this.valuation.put( new RealVariable( (String)$3 ), new Real( "-" + (String)$6 ) );
			$$ = (String)$1 + "\n" + "(valuation " +  (String)$3 + "->" + "-" + (String)$5 + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:valuation COMMA IDENTIFIER IMPLIES MINUS NUMBER");
			System.err.println( e );
		}
	}
;
/*============================================================*/
	

/*==================== Annotations ====================*/
annotationblock:
	ANNOTATION OPENBRACE annotationlist CLOSEBRACE {
		try {
			this.annotations = (ArrayList<dLFormula>)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:ANNOTATION OPENBRACE annotationlist CLOSEBRACE");
			System.err.println( e );
		}
	}
	| BOUNDS OPENBRACE dLformula CLOSEBRACE annotationblock {
		try {
			this.bounds = (dLFormula)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:BOUNDS OPENBRACE dLformula CLOSEBRACE annotationblock");
			System.err.println( e );
		}
	}
;

annotationlist:
	dLformula SEMICOLON {
		try {
			ArrayList<dLFormula> annot = new ArrayList<dLFormula>();
			annot.add( (dLFormula)$1 );
			$$ = annot;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationlist:dLformula SEMICOLON");
			System.err.println( e );
		}
	}
	| annotationlist dLformula SEMICOLON {
		try {
			ArrayList<dLFormula> annot = new ArrayList<dLFormula>();
			annot.addAll( (ArrayList<dLFormula>)$1 );
			annot.add( (dLFormula)$2 );
			$$ = annot;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationlist:annotationlist dLformula SEMICOLON");
			System.err.println( e );
		}

	}
;


/*============================================================*/

/*==================== Schema rules and variables ====================*/
schemavarsblock:
	SCHEMAVARIABLES OPENBRACE schematext CLOSEBRACE { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			$$ = "(declare-schema-vars: \n" + (String)$3 + "\n)"; System.out.println( $$ );
			this.declaredSchemaVariables = (String)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location schemavarsblock:SCHEMAVARIABLES OPENBRACE schematext CLOSEBRACE");
			System.err.println( e );
		}
	}
;

rulesblock:
	RULES OPENBRACE schematext CLOSEBRACE { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			$$ = "(declare-rules: \n" + (String)$3 + "\n)"; System.out.println( $$ );
			this.declaredRules = (String)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location rulesblock:RULES OPENBRACE schematext CLOSEBRACE");
			System.err.println( e );
		}
	}
;

schematext:
	SCHEMATEXT { 
		try {
			$$ = (String)$1; 
		} catch ( Exception e ) {
			System.err.println("Exception at location schematext:SCHEMATEXT");
			System.err.println( e );
		}
	}
	| SCHEMATEXT schematext { 
		try {
			$$ = (String)$1 + (String)$2; 
		} catch ( Exception e ) {
			System.err.println("Exception at location schematext:SCHEMATEXT schematext");
			System.err.println( e );
		}
	}
;

/*============================================================*/

/*==================== Variable declarations ====================*/
varblock:
	OPENBOX vardeclaration CLOSEBOX { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			this.declaredProgramVariables = new ArrayList<RealVariable>();
			this.declaredProgramVariables.addAll( (ArrayList<RealVariable>)$2 );
			$$ = this.declaredProgramVariables.toString();
		} catch ( Exception e ) {
			System.err.println("Exception at location varblock:OPENBOX vardeclaration CLOSEBOX");
			System.err.println( e );
		}
		
	}
	| OPENBOX vardeclaration varinitlist CLOSEBOX { 
		//$$ = "(declare-vars: \n" + (String)$2 + ")" + (String)$3; System.out.println( $$ );
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			this.declaredProgramVariables = (ArrayList<RealVariable>)$2;
			this.variableInitializations = (ArrayList<String>)$3;

			ArrayList<String> result = new ArrayList<String>();
			//result.addAll( this.declaredProgramVariables );
			result.addAll( this.variableInitializations );
			$$ = result.toString();
		} catch ( Exception e ) {
			System.err.println("Exception at location varblock:OPENBOX vardeclaration varinitlist CLOSEBOX");
			System.err.println( e );
		}

	}
;

vardeclaration:
	REALDECLARATION varlist SEMICOLON { 
		try {
			$$ = (ArrayList<RealVariable>)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location vardeclaration:REALDECLARATION varlist SEMICOLON");
			System.err.println( e );
		}
	}
	| vardeclaration REALDECLARATION varlist SEMICOLON { 
		//$$ = "\t(declare-real " + (String)$2 + " )\n"  + (String)$4;
		try {
			ArrayList<RealVariable> vars = (ArrayList<RealVariable>)$1;
			vars.addAll( (ArrayList<RealVariable>)$3 );
			$$ = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location vardeclaration:vardeclaration REALDECLARATION varlist SEMICOLON");
			System.err.println( e );
		}
	}
;

varlist:
	IDENTIFIER { 
		try {
			ArrayList<RealVariable> vars = new ArrayList<RealVariable>();
			vars.add( new RealVariable( (String)$1 ) );
			$$ = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location varlist:IDENTIFIER");
			System.err.println( e );
		}
	}
	| varlist COMMA IDENTIFIER { 
		try {
			ArrayList<RealVariable> vars  = (ArrayList<RealVariable>)$1 ;
			vars.add( new RealVariable( (String)$3 ) );
			$$ = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location varlist:varlist COMMA IDENTIFIER");
			System.err.println( e );
		}
	}
;
	
varinitlist:
	IDENTIFIER ASSIGN term SEMICOLON { 
		try {
			ArrayList<String> init = new ArrayList<String>();
			dLStructure myTerm = (dLStructure)$3;
			init.add( (String)$1 + " := " + myTerm.toString() );
			$$ = init;
		} catch ( Exception e ) {
			System.err.println("Exception at location varinitlist:IDENTIFIER ASSIGN term SEMICOLON");
			System.err.println( e );
		}

	}
	| varinitlist IDENTIFIER ASSIGN term SEMICOLON { 
		//$$ = "\t(init: " + (String)$1 + ", " + (String)$3 + " )\n" + (String)$5;
		try {
			ArrayList<String> init = (ArrayList<String>)$1;
			dLStructure myTerm = (dLStructure)$4;
			init.add( (String)$2 + " := " + myTerm.toString() );
			$$ = init;
		} catch ( Exception e ) {
			System.err.println("Exception at location varinitlist:varinitlist IDENTIFIER ASSIGN term SEMICOLON");
			System.err.println( e );
		}
	}
;
/*============================================================*/

/*==================== Function declarations ====================*/
funblock:
	FUNCTIONS OPENBRACE functiondeclaration CLOSEBRACE { 
		try {
			//$$ = "(declare-funs: \n" + (String)$3 + ")"; System.out.println( $$ ); 
			$$ = (String)$3;
		} catch ( Exception e ) {
			System.err.println("Exception at location funblock:FUNCTIONS OPENBRACE functiondeclaration CLOSEBRACE");
			System.err.println( e );
		}
	}
;

functiondeclaration:
	REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON {
		try {
			//$$ = "(R fun " + (String)$2 + " " + (String)$4 + " )\n";
			$$ = (String)$1 + (String)$2 + (String)$3 + (String)$4 + (String)$5 + (String)$6 + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	}
	| EXTERNAL REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON {
		try {
			//$$ = "(R fun " + (String)$3 + " " + (String)$5 + " )\n"; 
			$$ = (String)$1 + (String)$2 + (String)$3 + (String)$4 + (String)$5 + (String)$6 + (String)$7 + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	}
	| functiondeclaration REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON {
		try {
			//$$ = "(R fun " + (String)$2 + " " + (String)$4 + " )\n" + (String)$7; 
			$$ = (String)$1 + (String)$2 + (String)$3 + (String)$4 + (String)$5 + (String)$6 + (String)$7 + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	}
	| functiondeclaration EXTERNAL REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON {
		try {
			//$$ = "(R fun " + (String)$3 + " " + (String)$5 + " )\n" + (String)$8; 
			$$ = (String)$1 + (String)$2 + (String)$3 + (String)$4 + (String)$5 + (String)$6 + (String)$7 + (String)$8 + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:functiondeclaration EXTERNAL REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	}
;

argumentdeclaration:
	%empty {
		$$ = "";
	}
	| REALDECLARATION { 
		try {
			$$ = (String)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentdeclaration:REALDECLARATION");
			System.err.println( e );
		}
	}
	| argumentdeclaration COMMA REALDECLARATION { 
		try {
			$$ = (String)$1 + (String)$2 + (String)$3; 
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentdeclaration:argumentdeclaration COMMA REALDECLARATION");
			System.err.println( e );
		}
	}
;
/*============================================================*/

/*==================== Differential dynamic logic ====================*/
dLformula:
	TRUE { 
		try {
			$$ = new TrueFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:TRUE");
			System.err.println( e );
		}
	}
	| FALSE	{ 
		try {
			$$ = new FalseFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:FALSE");
			System.err.println( e );
		}
	}
	| comparison { 
		try {
			$$ = (ComparisonFormula)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:comparison");
			System.err.println( e );
		}
	}
	| dLformula AND dLformula { 
		try {
			$$ = new AndFormula( (dLFormula)$1, (dLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula AND dLformula");
			System.err.println( e );
		}
	}
	| dLformula OR dLformula { 
		try {
			$$ = new OrFormula( (dLFormula)$1, (dLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula OR dLformula");
			System.err.println( e );
		}
	}
	| NOT dLformula	{ 
		try {
			$$ = new NotFormula( (dLFormula)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:NOT dLformula");
			System.err.println( e );
		}
	}
	| LPAREN dLformula RPAREN { 
		try {
			$$ = (dLFormula)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:LPAREN dLformula RPAREN");
			System.err.println( e );
		}
	}
	| dLformula IMPLIES dLformula { 
		try {
			$$ = new ImpliesFormula( (dLFormula)$1, (dLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula IMPLIES dLformula");
			System.err.println( e );
		}
	}
	| dLformula IFF dLformula { 
		try {
			$$ = new IffFormula( (dLFormula)$1, (dLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula IFF dLformula");
			System.err.println( e );
		}
	}
	| FORALL IDENTIFIER SEMICOLON dLformula %prec QUANTIFIER { 
		try {
			$$ = new ForAllFormula( new RealVariable( (String)$2), (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:FORALL IDENTIFIER SEMICOLON dLformula");
			System.err.println( e );
		}
	}
	| EXISTS IDENTIFIER SEMICOLON dLformula %prec QUANTIFIER { 
		try {
			$$ = new ExistsFormula( new RealVariable( (String)$2 ), (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:EXISTS IDENTIFIER SEMICOLON dLformula");
			System.err.println( e );
		}
	}
	| OPENBOX hybridprogram CLOSEBOX dLformula { 
		try {
			$$ = new BoxModalityFormula( (HybridProgram)$2, (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location OPENBOX:hybridprogram CLOSEBOX dLformula");
			System.err.println( e );
		}
	}
	| OPENDIAMOND hybridprogram CLOSEDIAMOND dLformula { 
		try {
			$$ = new BoxModalityFormula( (HybridProgram)$2, (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location OPENDIAMOND hybridprogram CLOSEDIAMOND dLformula");
			System.err.println( e );
		}
	}
;

hybridprogram:
	odesystem { 
		try {
			$$ = (ContinuousProgram)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:odesystem");
			System.err.println( e );
		}
	}
	| test { 
		try {
			$$ = (TestProgram)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:test");
			System.err.println( e );
		}
	}
	| concreteassignment { 
		try {
			$$ = (ConcreteAssignmentProgram)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:concreteassignment");
			System.err.println( e );
		}
	}
	| arbitraryassignment { 
		try {
			$$ = (ArbitraryAssignmentProgram)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:arbitraryassignment");
			System.err.println( e );
		}
	}
	| hybridprogram SEMICOLON hybridprogram { 
		try {
			$$ = new SequenceProgram( (HybridProgram)$1, (HybridProgram)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram SEMICOLON hybridprogram");
			System.err.println( e );
		}
	}
	| hybridprogram CUP hybridprogram { 
		try {
			$$ = new ChoiceProgram( (HybridProgram)$1, (HybridProgram)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram CUP hybridprogram");
			System.err.println( e );
		}
	}
	| hybridprogram KLEENESTAR {
		try {
			$$ = new RepetitionProgram( (HybridProgram)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram ASTERISK");
			System.err.println( e );
		}
	}
	| LPAREN hybridprogram RPAREN { 
		try {
			$$ = (HybridProgram)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:LPAREN hybridprogram RPAREN");
			System.err.println( e );
		}
	}
;

concreteassignment:
	IDENTIFIER ASSIGN term { 
		try {
			$$ = new ConcreteAssignmentProgram( new RealVariable( (String)$1 ), (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location concreteassignment:IDENTIFIER ASSIGN term");
			System.err.println( e );
		}
	}
;

arbitraryassignment:
	IDENTIFIER ASSIGN RANDOM { 
		try {
			$$ = new ArbitraryAssignmentProgram( new RealVariable( (String)$1 ) );
		} catch ( Exception e ) {
			System.err.println("Exception at location arbitraryassignment:IDENTIFIER ASSIGN ASTERISK");
			System.err.println( e );
		}
	}


test:
	TEST dLformula { 
		try {
			$$ = new TestProgram( (dLStructure)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location test:TEST dLformula");
			System.err.println( e );
		}
	}
;

odesystem:
	OPENBRACE odelist CLOSEBRACE { 
		try {
			$$ = new ContinuousProgram( (ArrayList<ExplicitODE>)$2 ); // Constructor appends "true" doe automaticaly
		} catch ( Exception e ) {
			System.err.println("Exception at location odesystem:OPENBRACE odelist CLOSEBRACE");
			System.err.println( e );
		}
	}
	| OPENBRACE odelist AND dLformula CLOSEBRACE { 
		try {
			$$ = new ContinuousProgram( (ArrayList<ExplicitODE>)$2, (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location odesystem:OPENBRACE odelist AND dLformula CLOSEBRACE");
			System.err.println( e );
		}
	}
;

odelist:
	ode { 
		//$$ = (String)$1;
		try {
			ArrayList<ExplicitODE> args = new ArrayList<ExplicitODE>();
			args.add( (ExplicitODE)$1 );

			$$ = args;

		} catch ( Exception e ) {
			System.err.println("Exception at location odelist:ode");
			System.err.println( e );
		}

	}
	| odelist COMMA ode { 
		//$$ = (String)$1 + ", " + (String)$3;
		try {
			ArrayList<ExplicitODE> args = new ArrayList<ExplicitODE>();
			args.addAll( (ArrayList<ExplicitODE>)$1 );
			args.add( (ExplicitODE)$3 );
			$$ = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location odelist:odelist COMMA ode");
			System.err.println( e );
		}

	}
;
ode:
	IDENTIFIER PRIME EQUALS term { 
		try {
			$$ = new ExplicitODE( new RealVariable( (String)$1 ), (Term)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location ode:IDENTIFIER PRIME EQUALS term");
			System.err.println( e );
		}

	}
;



comparison:
	term INEQUALITY term { 
		try {
			$$ = new ComparisonFormula( new Operator( (String)$2, 2, true ), (Term)$1, (Term)$3 ) ;
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term INEQUALITY term");
			System.err.println( e );
		}
	}
	| term EQUALS term {
		try {
			$$ = new ComparisonFormula( new Operator( (String)$2, 2, true ), (Term)$1, (Term)$3 ) ;
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term EQUALS term");
			System.err.println( e );
		}
	}
;


term:
	NUMBER { 
		try {
			$$ = new Real( (String)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:NUMBER");
			System.err.println( e );
		}
	}
	| IDENTIFIER LPAREN argumentlist RPAREN {
		try {
			$$ = new Term( new Operator( (String)$1, ((ArrayList<Term>)$3).size(), false ), (ArrayList<Term>)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER LPAREN argumentlist RPAREN");
			System.err.println( e );
		}
	}
	| IDENTIFIER { 
		try {
			$$ = new RealVariable( (String)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER");
			System.err.println( e );
		}
	}
	| LPAREN term RPAREN { 
		try {
			$$ = (Term)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location term:LPAREN term RPAREN");
			System.err.println( e );
		}
	}
	| term PLUS term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("+", 2, true), args );
			$$ = new AdditionTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term PLUS term");
			System.err.println( e );
		}
	}
	| term MINUS term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("-", 2, true), args );
			$$ = new SubtractionTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term MINUS term");
			System.err.println( e );
		}
	}
	| term MULTIPLY term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("*", 2, true), args );
			$$ = new MultiplicationTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term ASTERISK term");
			System.err.println( e );
		}
	}
	| term DIVIDE term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("/", 2, true), args );
			$$ = new DivisionTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term DIVIDE term");
			System.err.println( e );
		}
	}
	| term POWER term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("^", 2, true), args );
			$$ = new PowerTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term POWER tterm:term POWER term");
			System.err.println( e );
		}
	}
	| MINUS term %prec NEGATIVE { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( new Real( "0" ) );
			//args.add( (Term)$2 );
			//$$ = new Term( new Operator("-", 2, true), args );
			$$ = new SubtractionTerm( new Real("0"), (Term)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:MINUS term");
			System.err.println( e );
		}
	}
;

argumentlist:
	%empty {
		$$ = null;
	}
	| term	{ 
		try {
			ArrayList<Term> args = new ArrayList<Term>();
			args.add( (Term)$1 );
			$$ = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:term");
			System.err.println( e );
		}
	}
	| argumentlist COMMA term { 
		try {
			ArrayList<Term> args = new ArrayList<Term>();
			args.addAll( (ArrayList<Term>)$1 );
			args.add( (Term)$3 );
			$$ = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:argumentlist COMMA term");
			System.err.println( e );
		}
	}
;

/*============================================================*/
%%




