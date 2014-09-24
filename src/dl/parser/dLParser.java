/* A Bison parser, made by GNU Bison 3.0.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2013 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

package hephaestos.dl.parser;
/* First part of user declarations.  */
/* "dLParser.y":2  */ /* lalr1.java:91  */

	import java.util.*;
	import hephaestos.dl.syntax.*;
	import hephaestos.dl.semantics.*;

	@SuppressWarnings({"unchecked"})

/* "dLParser.java":44  */ /* lalr1.java:91  */

/* "dLParser.java":46  */ /* lalr1.java:92  */

/**
 * A Bison parser, automatically generated from <tt>dLParser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class dLParser extends AbstractdLParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.0.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>dLParser</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int EXTERNAL = 258;
    /** Token number,to be returned by the scanner.  */
    static final int FUNCTIONS = 259;
    /** Token number,to be returned by the scanner.  */
    static final int RULES = 260;
    /** Token number,to be returned by the scanner.  */
    static final int SCHEMAVARIABLES = 261;
    /** Token number,to be returned by the scanner.  */
    static final int SCHEMATEXT = 262;
    /** Token number,to be returned by the scanner.  */
    static final int PROBLEM = 263;
    /** Token number,to be returned by the scanner.  */
    static final int ANNOTATION = 264;
    /** Token number,to be returned by the scanner.  */
    static final int BOUNDS = 265;
    /** Token number,to be returned by the scanner.  */
    static final int STATEVARIABLES = 266;
    /** Token number,to be returned by the scanner.  */
    static final int EIPARAMETERS = 267;
    /** Token number,to be returned by the scanner.  */
    static final int ENVELOPE = 268;
    /** Token number,to be returned by the scanner.  */
    static final int INVARIANT = 269;
    /** Token number,to be returned by the scanner.  */
    static final int ROBUSTPARAMETERS = 270;
    /** Token number,to be returned by the scanner.  */
    static final int DOMAIN = 271;
    /** Token number,to be returned by the scanner.  */
    static final int CONTROLLAW = 272;
    /** Token number,to be returned by the scanner.  */
    static final int CONTROLTEMPLATE = 273;
    /** Token number,to be returned by the scanner.  */
    static final int SETTINGS = 274;
    /** Token number,to be returned by the scanner.  */
    static final int ASSIGN = 275;
    /** Token number,to be returned by the scanner.  */
    static final int PRIME = 276;
    /** Token number,to be returned by the scanner.  */
    static final int OPENBRACE = 277;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEBRACE = 278;
    /** Token number,to be returned by the scanner.  */
    static final int EQUALS = 279;
    /** Token number,to be returned by the scanner.  */
    static final int TEST = 280;
    /** Token number,to be returned by the scanner.  */
    static final int KLEENESTAR = 281;
    /** Token number,to be returned by the scanner.  */
    static final int CUP = 282;
    /** Token number,to be returned by the scanner.  */
    static final int RANDOM = 283;
    /** Token number,to be returned by the scanner.  */
    static final int REALDECLARATION = 284;
    /** Token number,to be returned by the scanner.  */
    static final int SEMICOLON = 285;
    /** Token number,to be returned by the scanner.  */
    static final int OPENBOX = 286;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEBOX = 287;
    /** Token number,to be returned by the scanner.  */
    static final int OPENDIAMOND = 288;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEDIAMOND = 289;
    /** Token number,to be returned by the scanner.  */
    static final int NUMBER = 290;
    /** Token number,to be returned by the scanner.  */
    static final int IDENTIFIER = 291;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS = 292;
    /** Token number,to be returned by the scanner.  */
    static final int MINUS = 293;
    /** Token number,to be returned by the scanner.  */
    static final int MULTIPLY = 294;
    /** Token number,to be returned by the scanner.  */
    static final int DIVIDE = 295;
    /** Token number,to be returned by the scanner.  */
    static final int POWER = 296;
    /** Token number,to be returned by the scanner.  */
    static final int NEWLINE = 297;
    /** Token number,to be returned by the scanner.  */
    static final int INEQUALITY = 298;
    /** Token number,to be returned by the scanner.  */
    static final int LPAREN = 299;
    /** Token number,to be returned by the scanner.  */
    static final int RPAREN = 300;
    /** Token number,to be returned by the scanner.  */
    static final int COMMA = 301;
    /** Token number,to be returned by the scanner.  */
    static final int AND = 302;
    /** Token number,to be returned by the scanner.  */
    static final int OR = 303;
    /** Token number,to be returned by the scanner.  */
    static final int NOT = 304;
    /** Token number,to be returned by the scanner.  */
    static final int IMPLIES = 305;
    /** Token number,to be returned by the scanner.  */
    static final int IFF = 306;
    /** Token number,to be returned by the scanner.  */
    static final int FORALL = 307;
    /** Token number,to be returned by the scanner.  */
    static final int EXISTS = 308;
    /** Token number,to be returned by the scanner.  */
    static final int TRUE = 309;
    /** Token number,to be returned by the scanner.  */
    static final int FALSE = 310;
    /** Token number,to be returned by the scanner.  */
    static final int QUANTIFIER = 311;
    /** Token number,to be returned by the scanner.  */
    static final int NEGATIVE = 312;


    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param msg The string for the error message.
     */
     void yyerror (String msg);
  }

  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public dLParser (Lexer yylexer) 
  {
    
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror (String msg)
  {
    yylexer.yyerror (msg);
  }


  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value                            ) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out)
    {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yy_lr_goto_state_ (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - yyntokens_] + yystate;
    if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - yyntokens_];
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    

    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);

    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
          case 2:
  if (yyn == 2)
    /* "dLParser.y":120  */ /* lalr1.java:489  */
    {
		try {
			yyval = (String)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location input:valuation");
			System.err.println( e );
		}
	};
  break;
    

  case 3:
  if (yyn == 3)
    /* "dLParser.y":128  */ /* lalr1.java:489  */
    {
		try {
			parsedStructure = (dLFormula)((yystack.valueAt (4-(1)))); // valuation has already been handled
			yyval = (String)((yystack.valueAt (4-(3)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula OPENBRACE valuation CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 4:
  if (yyn == 4)
    /* "dLParser.y":137  */ /* lalr1.java:489  */
    {
		try {
			parsedStructure = (HybridProgram)((yystack.valueAt (4-(1)))); // valuation has already been handled
			yyval = (String)((yystack.valueAt (4-(3)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula OPENBRACE valuation CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 5:
  if (yyn == 5)
    /* "dLParser.y":146  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("full block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:keymaerablock");
			System.err.println( e );
		}
	};
  break;
    

  case 6:
  if (yyn == 6)
    /* "dLParser.y":154  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("function block");
		} catch ( Exception e ) {
			System.err.println("Exception at location input:funblock");
			System.err.println( e );
		}
	};
  break;
    

  case 7:
  if (yyn == 7)
    /* "dLParser.y":162  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("variable declaration block");
		} catch ( Exception e ) {
			System.err.println("Exception at location input:varblock");
			System.err.println( e );
		}
	};
  break;
    

  case 8:
  if (yyn == 8)
    /* "dLParser.y":170  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("schema variables block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:schemavarsblock");
			System.err.println( e );
		}
			
	};
  break;
    

  case 9:
  if (yyn == 9)
    /* "dLParser.y":179  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("rules block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:rulesblock");
			System.err.println( e );
		}
	};
  break;
    

  case 10:
  if (yyn == 10)
    /* "dLParser.y":187  */ /* lalr1.java:489  */
    { 
		try {
			//System.out.println("Found: dLformula"); 
			parsedStructure = (dLFormula)((yystack.valueAt (1-(1))));	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 11:
  if (yyn == 11)
    /* "dLParser.y":196  */ /* lalr1.java:489  */
    {
		try {
			yyval = "hybrid program"; 
			parsedStructure = (HybridProgram)((yystack.valueAt (1-(1))));	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:hybridprogram");
			System.err.println( e );
		}
	};
  break;
    

  case 12:
  if (yyn == 12)
    /* "dLParser.y":205  */ /* lalr1.java:489  */
    {
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("annotation block"); //System.out.println($$); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:annotationblock");
			System.err.println( e );
		}
	};
  break;
    

  case 13:
  if (yyn == 13)
    /* "dLParser.y":213  */ /* lalr1.java:489  */
    {
		try {
			yyval = ((Term)((yystack.valueAt (1-(1))))).toKeYmaeraString();
			parsedStructure = (Term)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location input:term");
			System.err.println( e );
		}
	};
  break;
    

  case 14:
  if (yyn == 14)
    /* "dLParser.y":222  */ /* lalr1.java:489  */
    {
		try {
			yyval = "Sucessfully parsed EITool input file";	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:eitoolblock");
			System.err.println( e );
		}
	};
  break;
    

  case 15:
  if (yyn == 15)
    /* "dLParser.y":230  */ /* lalr1.java:489  */
    {
		System.err.println("Parser: I'm confused, throwing error");
		System.out.println( (String)((yystack.valueAt (1-(1)))) );
		//System.exit(1);
	};
  break;
    

  case 16:
  if (yyn == 16)
    /* "dLParser.y":240  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 17:
  if (yyn == 17)
    /* "dLParser.y":248  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (2-(1)))) + (String)((yystack.valueAt (2-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:funblock problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 18:
  if (yyn == 18)
    /* "dLParser.y":256  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (4-(1)))) + (String)((yystack.valueAt (4-(2)))) + (String)((yystack.valueAt (4-(3)))) + (String)((yystack.valueAt (4-(4))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:funblock schemavarsblock rulesblock problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 19:
  if (yyn == 19)
    /* "dLParser.y":264  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (4-(1)))) + (String)((yystack.valueAt (4-(2)))) + (String)((yystack.valueAt (4-(3)))) + (String)((yystack.valueAt (4-(4))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:schemavarsblock rulesblock funblock problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 20:
  if (yyn == 20)
    /* "dLParser.y":272  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (3-(1)))) + (String)((yystack.valueAt (3-(2)))) + (String)((yystack.valueAt (3-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:schemavarsblock rulesblock problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 21:
  if (yyn == 21)
    /* "dLParser.y":280  */ /* lalr1.java:489  */
    {
		try{
			yyval = (String)((yystack.valueAt (2-(1)))) + (String)((yystack.valueAt (2-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:keymaerablock");
			System.err.println( e );
		}
	};
  break;
    

  case 22:
  if (yyn == 22)
    /* "dLParser.y":291  */ /* lalr1.java:489  */
    { 
		try {
			parsedStructure = (dLFormula)((yystack.valueAt (4-(3))));
			yyval = "{\n" + ((dLStructure)((yystack.valueAt (4-(3))))).toString() + "\n}"; System.out.println( yyval );
		} catch ( Exception e ) {
			System.err.println("Exception at location problemblock:PROBLEM OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 23:
  if (yyn == 23)
    /* "dLParser.y":300  */ /* lalr1.java:489  */
    { 
		try {
			parsedStructure = (dLFormula)((yystack.valueAt (5-(4))));
			yyval = "{\n" + (String)((yystack.valueAt (5-(3)))) + "\n" + ((dLStructure)((yystack.valueAt (5-(4))))).toString() + "\n}"; System.out.println(yyval);
		} catch ( Exception e ) {
			System.err.println("Exception at location problemblock:PROBLEM OPENBRACE varblock dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 24:
  if (yyn == 24)
    /* "dLParser.y":313  */ /* lalr1.java:489  */
    {
		try {
			synthesis = false;
		} catch ( Exception e ) {
			System.err.println("Exception at location eitoolblock: statevarblock eiparameterblock envelopeblock invariantblock robustparameterblock controllawblock");
			System.err.println( e );
		}
	};
  break;
    

  case 25:
  if (yyn == 25)
    /* "dLParser.y":321  */ /* lalr1.java:489  */
    {
		try {
			synthesis = true;
		} catch ( Exception e ) {
			System.err.println("Exception at location eitoolblock: statevarblock eiparameterblock envelopeblock invariantblock robustparameterblock controltemplateblock");
			System.err.println( e );
		}
	};
  break;
    

  case 26:
  if (yyn == 26)
    /* "dLParser.y":330  */ /* lalr1.java:489  */
    {
		try {
			statevariables = (ArrayList<RealVariable>)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location statevarblock: STATEVARIABLES OPENBRACE varlist CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 27:
  if (yyn == 27)
    /* "dLParser.y":340  */ /* lalr1.java:489  */
    {
		try {
			eiparameters = (ArrayList<RealVariable>)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location eiparameterblock: EIPARAMETERS OPENBRACE varlist CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 28:
  if (yyn == 28)
    /* "dLParser.y":351  */ /* lalr1.java:489  */
    {
		try {
			envelope = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location envelopeblock: ENVELOPE OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 29:
  if (yyn == 29)
    /* "dLParser.y":361  */ /* lalr1.java:489  */
    {
		try {
			invariant = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location invariantblock: INVARIANT OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 30:
  if (yyn == 30)
    /* "dLParser.y":371  */ /* lalr1.java:489  */
    {
		try {
			robustparameters = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location robustparametersblock: ROBUSTPARAMETERS OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 31:
  if (yyn == 31)
    /* "dLParser.y":389  */ /* lalr1.java:489  */
    {
		try {
			domain = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location invariantblock: INVARIANT OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 32:
  if (yyn == 32)
    /* "dLParser.y":400  */ /* lalr1.java:489  */
    {
		try {
			control = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location controllawblock: CONTROLLAW OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 33:
  if (yyn == 33)
    /* "dLParser.y":409  */ /* lalr1.java:489  */
    {
		try {
			control = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location controltemplateblock: CONTROLTEMPLATE OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 35:
  if (yyn == 35)
    /* "dLParser.y":426  */ /* lalr1.java:489  */
    {
		try {
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}

			this.valuation.put( new RealVariable( (String)((yystack.valueAt (3-(1)))) ), new Real( (String)((yystack.valueAt (3-(3)))) ) );
			yyval = "(valuation " +  (String)((yystack.valueAt (3-(1)))) + "->" + (String)((yystack.valueAt (3-(3)))) + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:IDENTIFIER IMPLIES NUMBER");
			System.err.println( e );
		}
		
	};
  break;
    

  case 36:
  if (yyn == 36)
    /* "dLParser.y":441  */ /* lalr1.java:489  */
    {
		try {
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}

			this.valuation.put( new RealVariable( (String)((yystack.valueAt (4-(1)))) ), new Real( "-" + (String)((yystack.valueAt (4-(4)))) ) );
			yyval = "(valuation " +  (String)((yystack.valueAt (4-(1)))) + "->" + "-" + (String)((yystack.valueAt (4-(3)))) + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:IDENTIFIER IMPLIES MINUS NUMBER");
			System.err.println( e );
		}
		
	};
  break;
    

  case 37:
  if (yyn == 37)
    /* "dLParser.y":456  */ /* lalr1.java:489  */
    {
		try{
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}
			this.valuation.put( new RealVariable( (String)((yystack.valueAt (5-(3)))) ), new Real( (String)((yystack.valueAt (5-(5)))) ) );
			yyval = (String)((yystack.valueAt (5-(1)))) + "\n" + "(valuation " +  (String)((yystack.valueAt (5-(3)))) + "->" + (String)((yystack.valueAt (5-(5)))) + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:valuation COMMA IDENTIFIER IMPLIES NUMBER");
			System.err.println( e );
		}
	};
  break;
    

  case 38:
  if (yyn == 38)
    /* "dLParser.y":468  */ /* lalr1.java:489  */
    {
		try{
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}
			this.valuation.put( new RealVariable( (String)((yystack.valueAt (6-(3)))) ), new Real( "-" + (String)((yystack.valueAt (6-(6)))) ) );
			yyval = (String)((yystack.valueAt (6-(1)))) + "\n" + "(valuation " +  (String)((yystack.valueAt (6-(3)))) + "->" + "-" + (String)((yystack.valueAt (6-(5)))) + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:valuation COMMA IDENTIFIER IMPLIES MINUS NUMBER");
			System.err.println( e );
		}
	};
  break;
    

  case 39:
  if (yyn == 39)
    /* "dLParser.y":486  */ /* lalr1.java:489  */
    {
		try {
			this.annotations = (ArrayList<dLFormula>)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:ANNOTATION OPENBRACE annotationlist CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 40:
  if (yyn == 40)
    /* "dLParser.y":494  */ /* lalr1.java:489  */
    {
		try {
			this.bounds = (dLFormula)((yystack.valueAt (5-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:BOUNDS OPENBRACE dLformula CLOSEBRACE annotationblock");
			System.err.println( e );
		}
	};
  break;
    

  case 41:
  if (yyn == 41)
    /* "dLParser.y":505  */ /* lalr1.java:489  */
    {
		try {
			ArrayList<dLFormula> annot = new ArrayList<dLFormula>();
			annot.add( (dLFormula)((yystack.valueAt (2-(1)))) );
			yyval = annot;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationlist:dLformula SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 42:
  if (yyn == 42)
    /* "dLParser.y":515  */ /* lalr1.java:489  */
    {
		try {
			ArrayList<dLFormula> annot = new ArrayList<dLFormula>();
			annot.addAll( (ArrayList<dLFormula>)((yystack.valueAt (3-(1)))) );
			annot.add( (dLFormula)((yystack.valueAt (3-(2)))) );
			yyval = annot;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationlist:annotationlist dLformula SEMICOLON");
			System.err.println( e );
		}

	};
  break;
    

  case 43:
  if (yyn == 43)
    /* "dLParser.y":534  */ /* lalr1.java:489  */
    { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			yyval = "(declare-schema-vars: \n" + (String)((yystack.valueAt (4-(3)))) + "\n)"; System.out.println( yyval );
			this.declaredSchemaVariables = (String)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location schemavarsblock:SCHEMAVARIABLES OPENBRACE schematext CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 44:
  if (yyn == 44)
    /* "dLParser.y":549  */ /* lalr1.java:489  */
    { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			yyval = "(declare-rules: \n" + (String)((yystack.valueAt (4-(3)))) + "\n)"; System.out.println( yyval );
			this.declaredRules = (String)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location rulesblock:RULES OPENBRACE schematext CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 45:
  if (yyn == 45)
    /* "dLParser.y":564  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location schematext:SCHEMATEXT");
			System.err.println( e );
		}
	};
  break;
    

  case 46:
  if (yyn == 46)
    /* "dLParser.y":572  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (2-(1)))) + (String)((yystack.valueAt (2-(2)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location schematext:SCHEMATEXT schematext");
			System.err.println( e );
		}
	};
  break;
    

  case 47:
  if (yyn == 47)
    /* "dLParser.y":586  */ /* lalr1.java:489  */
    { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			this.declaredProgramVariables = new ArrayList<RealVariable>();
			this.declaredProgramVariables.addAll( (ArrayList<RealVariable>)((yystack.valueAt (3-(2)))) );
			yyval = this.declaredProgramVariables.toString();
		} catch ( Exception e ) {
			System.err.println("Exception at location varblock:OPENBOX vardeclaration CLOSEBOX");
			System.err.println( e );
		}
		
	};
  break;
    

  case 48:
  if (yyn == 48)
    /* "dLParser.y":600  */ /* lalr1.java:489  */
    { 
		//$$ = "(declare-vars: \n" + (String)$2 + ")" + (String)$3; System.out.println( $$ );
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			this.declaredProgramVariables = (ArrayList<RealVariable>)((yystack.valueAt (4-(2))));
			this.variableInitializations = (ArrayList<String>)((yystack.valueAt (4-(3))));

			ArrayList<String> result = new ArrayList<String>();
			//result.addAll( this.declaredProgramVariables );
			result.addAll( this.variableInitializations );
			yyval = result.toString();
		} catch ( Exception e ) {
			System.err.println("Exception at location varblock:OPENBOX vardeclaration varinitlist CLOSEBOX");
			System.err.println( e );
		}

	};
  break;
    

  case 49:
  if (yyn == 49)
    /* "dLParser.y":622  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ArrayList<RealVariable>)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location vardeclaration:REALDECLARATION varlist SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 50:
  if (yyn == 50)
    /* "dLParser.y":630  */ /* lalr1.java:489  */
    { 
		//$$ = "\t(declare-real " + (String)$2 + " )\n"  + (String)$4;
		try {
			ArrayList<RealVariable> vars = (ArrayList<RealVariable>)((yystack.valueAt (4-(1))));
			vars.addAll( (ArrayList<RealVariable>)((yystack.valueAt (4-(3)))) );
			yyval = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location vardeclaration:vardeclaration REALDECLARATION varlist SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 51:
  if (yyn == 51)
    /* "dLParser.y":644  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<RealVariable> vars = new ArrayList<RealVariable>();
			vars.add( new RealVariable( (String)((yystack.valueAt (1-(1)))) ) );
			yyval = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location varlist:IDENTIFIER");
			System.err.println( e );
		}
	};
  break;
    

  case 52:
  if (yyn == 52)
    /* "dLParser.y":654  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<RealVariable> vars  = (ArrayList<RealVariable>)((yystack.valueAt (3-(1)))) ;
			vars.add( new RealVariable( (String)((yystack.valueAt (3-(3)))) ) );
			yyval = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location varlist:varlist COMMA IDENTIFIER");
			System.err.println( e );
		}
	};
  break;
    

  case 53:
  if (yyn == 53)
    /* "dLParser.y":667  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<String> init = new ArrayList<String>();
			dLStructure myTerm = (dLStructure)((yystack.valueAt (4-(3))));
			init.add( (String)((yystack.valueAt (4-(1)))) + " := " + myTerm.toString() );
			yyval = init;
		} catch ( Exception e ) {
			System.err.println("Exception at location varinitlist:IDENTIFIER ASSIGN term SEMICOLON");
			System.err.println( e );
		}

	};
  break;
    

  case 54:
  if (yyn == 54)
    /* "dLParser.y":679  */ /* lalr1.java:489  */
    { 
		//$$ = "\t(init: " + (String)$1 + ", " + (String)$3 + " )\n" + (String)$5;
		try {
			ArrayList<String> init = (ArrayList<String>)((yystack.valueAt (5-(1))));
			dLStructure myTerm = (dLStructure)((yystack.valueAt (5-(4))));
			init.add( (String)((yystack.valueAt (5-(2)))) + " := " + myTerm.toString() );
			yyval = init;
		} catch ( Exception e ) {
			System.err.println("Exception at location varinitlist:varinitlist IDENTIFIER ASSIGN term SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 55:
  if (yyn == 55)
    /* "dLParser.y":696  */ /* lalr1.java:489  */
    { 
		try {
			//$$ = "(declare-funs: \n" + (String)$3 + ")"; System.out.println( $$ ); 
			yyval = (String)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location funblock:FUNCTIONS OPENBRACE functiondeclaration CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 56:
  if (yyn == 56)
    /* "dLParser.y":708  */ /* lalr1.java:489  */
    {
		try {
			//$$ = "(R fun " + (String)$2 + " " + (String)$4 + " )\n";
			yyval = (String)((yystack.valueAt (6-(1)))) + (String)((yystack.valueAt (6-(2)))) + (String)((yystack.valueAt (6-(3)))) + (String)((yystack.valueAt (6-(4)))) + (String)((yystack.valueAt (6-(5)))) + (String)((yystack.valueAt (6-(6)))) + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 57:
  if (yyn == 57)
    /* "dLParser.y":717  */ /* lalr1.java:489  */
    {
		try {
			//$$ = "(R fun " + (String)$3 + " " + (String)$5 + " )\n"; 
			yyval = (String)((yystack.valueAt (7-(1)))) + (String)((yystack.valueAt (7-(2)))) + (String)((yystack.valueAt (7-(3)))) + (String)((yystack.valueAt (7-(4)))) + (String)((yystack.valueAt (7-(5)))) + (String)((yystack.valueAt (7-(6)))) + (String)((yystack.valueAt (7-(7)))) + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 58:
  if (yyn == 58)
    /* "dLParser.y":726  */ /* lalr1.java:489  */
    {
		try {
			//$$ = "(R fun " + (String)$2 + " " + (String)$4 + " )\n" + (String)$7; 
			yyval = (String)((yystack.valueAt (7-(1)))) + (String)((yystack.valueAt (7-(2)))) + (String)((yystack.valueAt (7-(3)))) + (String)((yystack.valueAt (7-(4)))) + (String)((yystack.valueAt (7-(5)))) + (String)((yystack.valueAt (7-(6)))) + (String)((yystack.valueAt (7-(7)))) + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 59:
  if (yyn == 59)
    /* "dLParser.y":735  */ /* lalr1.java:489  */
    {
		try {
			//$$ = "(R fun " + (String)$3 + " " + (String)$5 + " )\n" + (String)$8; 
			yyval = (String)((yystack.valueAt (8-(1)))) + (String)((yystack.valueAt (8-(2)))) + (String)((yystack.valueAt (8-(3)))) + (String)((yystack.valueAt (8-(4)))) + (String)((yystack.valueAt (8-(5)))) + (String)((yystack.valueAt (8-(6)))) + (String)((yystack.valueAt (8-(7)))) + (String)((yystack.valueAt (8-(8)))) + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:functiondeclaration EXTERNAL REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 60:
  if (yyn == 60)
    /* "dLParser.y":747  */ /* lalr1.java:489  */
    {
		yyval = "";
	};
  break;
    

  case 61:
  if (yyn == 61)
    /* "dLParser.y":750  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentdeclaration:REALDECLARATION");
			System.err.println( e );
		}
	};
  break;
    

  case 62:
  if (yyn == 62)
    /* "dLParser.y":758  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (3-(1)))) + (String)((yystack.valueAt (3-(2)))) + (String)((yystack.valueAt (3-(3)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentdeclaration:argumentdeclaration COMMA REALDECLARATION");
			System.err.println( e );
		}
	};
  break;
    

  case 63:
  if (yyn == 63)
    /* "dLParser.y":771  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new TrueFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:TRUE");
			System.err.println( e );
		}
	};
  break;
    

  case 64:
  if (yyn == 64)
    /* "dLParser.y":779  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new FalseFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:FALSE");
			System.err.println( e );
		}
	};
  break;
    

  case 65:
  if (yyn == 65)
    /* "dLParser.y":787  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ComparisonFormula)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:comparison");
			System.err.println( e );
		}
	};
  break;
    

  case 66:
  if (yyn == 66)
    /* "dLParser.y":795  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new AndFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula AND dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 67:
  if (yyn == 67)
    /* "dLParser.y":803  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new OrFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula OR dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 68:
  if (yyn == 68)
    /* "dLParser.y":811  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new NotFormula( (dLFormula)((yystack.valueAt (2-(2)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:NOT dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 69:
  if (yyn == 69)
    /* "dLParser.y":819  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (dLFormula)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:LPAREN dLformula RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 70:
  if (yyn == 70)
    /* "dLParser.y":827  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ImpliesFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula IMPLIES dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 71:
  if (yyn == 71)
    /* "dLParser.y":835  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new IffFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula IFF dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 72:
  if (yyn == 72)
    /* "dLParser.y":843  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ForAllFormula( new RealVariable( (String)((yystack.valueAt (4-(2))))), (dLFormula)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:FORALL IDENTIFIER SEMICOLON dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 73:
  if (yyn == 73)
    /* "dLParser.y":851  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ExistsFormula( new RealVariable( (String)((yystack.valueAt (4-(2)))) ), (dLFormula)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:EXISTS IDENTIFIER SEMICOLON dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 74:
  if (yyn == 74)
    /* "dLParser.y":859  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new BoxModalityFormula( (HybridProgram)((yystack.valueAt (4-(2)))), (dLFormula)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location OPENBOX:hybridprogram CLOSEBOX dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 75:
  if (yyn == 75)
    /* "dLParser.y":867  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new BoxModalityFormula( (HybridProgram)((yystack.valueAt (4-(2)))), (dLFormula)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location OPENDIAMOND hybridprogram CLOSEDIAMOND dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 76:
  if (yyn == 76)
    /* "dLParser.y":878  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ContinuousProgram)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:odesystem");
			System.err.println( e );
		}
	};
  break;
    

  case 77:
  if (yyn == 77)
    /* "dLParser.y":886  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (TestProgram)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:test");
			System.err.println( e );
		}
	};
  break;
    

  case 78:
  if (yyn == 78)
    /* "dLParser.y":894  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ConcreteAssignmentProgram)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:concreteassignment");
			System.err.println( e );
		}
	};
  break;
    

  case 79:
  if (yyn == 79)
    /* "dLParser.y":902  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ArbitraryAssignmentProgram)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:arbitraryassignment");
			System.err.println( e );
		}
	};
  break;
    

  case 80:
  if (yyn == 80)
    /* "dLParser.y":910  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new SequenceProgram( (HybridProgram)((yystack.valueAt (3-(1)))), (HybridProgram)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram SEMICOLON hybridprogram");
			System.err.println( e );
		}
	};
  break;
    

  case 81:
  if (yyn == 81)
    /* "dLParser.y":918  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ChoiceProgram( (HybridProgram)((yystack.valueAt (3-(1)))), (HybridProgram)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram CUP hybridprogram");
			System.err.println( e );
		}
	};
  break;
    

  case 82:
  if (yyn == 82)
    /* "dLParser.y":926  */ /* lalr1.java:489  */
    {
		try {
			yyval = new RepetitionProgram( (HybridProgram)((yystack.valueAt (2-(1)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram ASTERISK");
			System.err.println( e );
		}
	};
  break;
    

  case 83:
  if (yyn == 83)
    /* "dLParser.y":934  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (HybridProgram)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:LPAREN hybridprogram RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 84:
  if (yyn == 84)
    /* "dLParser.y":945  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ConcreteAssignmentProgram( new RealVariable( (String)((yystack.valueAt (3-(1)))) ), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location concreteassignment:IDENTIFIER ASSIGN term");
			System.err.println( e );
		}
	};
  break;
    

  case 85:
  if (yyn == 85)
    /* "dLParser.y":956  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ArbitraryAssignmentProgram( new RealVariable( (String)((yystack.valueAt (3-(1)))) ) );
		} catch ( Exception e ) {
			System.err.println("Exception at location arbitraryassignment:IDENTIFIER ASSIGN ASTERISK");
			System.err.println( e );
		}
	};
  break;
    

  case 86:
  if (yyn == 86)
    /* "dLParser.y":967  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new TestProgram( (dLStructure)((yystack.valueAt (2-(2)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location test:TEST dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 87:
  if (yyn == 87)
    /* "dLParser.y":978  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ContinuousProgram( (ArrayList<ExplicitODE>)((yystack.valueAt (3-(2)))) ); // Constructor appends "true" doe automaticaly
		} catch ( Exception e ) {
			System.err.println("Exception at location odesystem:OPENBRACE odelist CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 88:
  if (yyn == 88)
    /* "dLParser.y":986  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ContinuousProgram( (ArrayList<ExplicitODE>)((yystack.valueAt (5-(2)))), (dLFormula)((yystack.valueAt (5-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location odesystem:OPENBRACE odelist AND dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 89:
  if (yyn == 89)
    /* "dLParser.y":997  */ /* lalr1.java:489  */
    { 
		//$$ = (String)$1;
		try {
			ArrayList<ExplicitODE> args = new ArrayList<ExplicitODE>();
			args.add( (ExplicitODE)((yystack.valueAt (1-(1)))) );

			yyval = args;

		} catch ( Exception e ) {
			System.err.println("Exception at location odelist:ode");
			System.err.println( e );
		}

	};
  break;
    

  case 90:
  if (yyn == 90)
    /* "dLParser.y":1011  */ /* lalr1.java:489  */
    { 
		//$$ = (String)$1 + ", " + (String)$3;
		try {
			ArrayList<ExplicitODE> args = new ArrayList<ExplicitODE>();
			args.addAll( (ArrayList<ExplicitODE>)((yystack.valueAt (3-(1)))) );
			args.add( (ExplicitODE)((yystack.valueAt (3-(3)))) );
			yyval = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location odelist:odelist COMMA ode");
			System.err.println( e );
		}

	};
  break;
    

  case 91:
  if (yyn == 91)
    /* "dLParser.y":1026  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ExplicitODE( new RealVariable( (String)((yystack.valueAt (4-(1)))) ), (Term)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location ode:IDENTIFIER PRIME EQUALS term");
			System.err.println( e );
		}

	};
  break;
    

  case 92:
  if (yyn == 92)
    /* "dLParser.y":1040  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ComparisonFormula( new Operator( (String)((yystack.valueAt (3-(2)))), 2, true ), (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) ) ;
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term INEQUALITY term");
			System.err.println( e );
		}
	};
  break;
    

  case 93:
  if (yyn == 93)
    /* "dLParser.y":1048  */ /* lalr1.java:489  */
    {
		try {
			yyval = new ComparisonFormula( new Operator( (String)((yystack.valueAt (3-(2)))), 2, true ), (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) ) ;
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term EQUALS term");
			System.err.println( e );
		}
	};
  break;
    

  case 94:
  if (yyn == 94)
    /* "dLParser.y":1060  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new Real( (String)((yystack.valueAt (1-(1)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:NUMBER");
			System.err.println( e );
		}
	};
  break;
    

  case 95:
  if (yyn == 95)
    /* "dLParser.y":1068  */ /* lalr1.java:489  */
    {
		try {
			yyval = new Term( new Operator( (String)((yystack.valueAt (4-(1)))), ((ArrayList<Term>)((yystack.valueAt (4-(3))))).size(), false ), (ArrayList<Term>)((yystack.valueAt (4-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER LPAREN argumentlist RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 96:
  if (yyn == 96)
    /* "dLParser.y":1076  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new RealVariable( (String)((yystack.valueAt (1-(1)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER");
			System.err.println( e );
		}
	};
  break;
    

  case 97:
  if (yyn == 97)
    /* "dLParser.y":1084  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (Term)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location term:LPAREN term RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 98:
  if (yyn == 98)
    /* "dLParser.y":1092  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("+", 2, true), args );
			yyval = new AdditionTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term PLUS term");
			System.err.println( e );
		}
	};
  break;
    

  case 99:
  if (yyn == 99)
    /* "dLParser.y":1104  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("-", 2, true), args );
			yyval = new SubtractionTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term MINUS term");
			System.err.println( e );
		}
	};
  break;
    

  case 100:
  if (yyn == 100)
    /* "dLParser.y":1116  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("*", 2, true), args );
			yyval = new MultiplicationTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term ASTERISK term");
			System.err.println( e );
		}
	};
  break;
    

  case 101:
  if (yyn == 101)
    /* "dLParser.y":1128  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("/", 2, true), args );
			yyval = new DivisionTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term DIVIDE term");
			System.err.println( e );
		}
	};
  break;
    

  case 102:
  if (yyn == 102)
    /* "dLParser.y":1140  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("^", 2, true), args );
			yyval = new PowerTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term POWER tterm:term POWER term");
			System.err.println( e );
		}
	};
  break;
    

  case 103:
  if (yyn == 103)
    /* "dLParser.y":1152  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( new Real( "0" ) );
			//args.add( (Term)$2 );
			//$$ = new Term( new Operator("-", 2, true), args );
			yyval = new SubtractionTerm( new Real("0"), (Term)((yystack.valueAt (2-(2)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:MINUS term");
			System.err.println( e );
		}
	};
  break;
    

  case 104:
  if (yyn == 104)
    /* "dLParser.y":1167  */ /* lalr1.java:489  */
    {
		yyval = null;
	};
  break;
    

  case 105:
  if (yyn == 105)
    /* "dLParser.y":1170  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<Term> args = new ArrayList<Term>();
			args.add( (Term)((yystack.valueAt (1-(1)))) );
			yyval = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:term");
			System.err.println( e );
		}
	};
  break;
    

  case 106:
  if (yyn == 106)
    /* "dLParser.y":1180  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<Term> args = new ArrayList<Term>();
			args.addAll( (ArrayList<Term>)((yystack.valueAt (3-(1)))) );
			args.add( (Term)((yystack.valueAt (3-(3)))) );
			yyval = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:argumentlist COMMA term");
			System.err.println( e );
		}
	};
  break;
    


/* "dLParser.java":1987  */ /* lalr1.java:489  */
        default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yy_lr_goto_state_ (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }



  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
                                 Object yyvaluep                                 )
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
              + yytname_[yytype] + " ("
              + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }


  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
   public boolean parse () throws java.io.IOException

  {
    


    /* Lookahead and lookahead in internal form.  */
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval );



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yy_pact_value_is_default_ (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {


            yycdebug ("Reading a token: ");
            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal ();

          }

        /* Convert token to internal form.  */
        if (yychar <= Lexer.EOF)
          {
            yychar = yytoken = Lexer.EOF;
            yycdebug ("Now at end of input.\n");
          }
        else
          {
            yytoken = yytranslate_ (yychar);
            yy_symbol_print ("Next token is", yytoken,
                             yylval);
          }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
            if (yy_table_value_is_error_ (yyn))
              label = YYERRLAB;
            else
              {
                yyn = -yyn;
                label = YYREDUCE;
              }
          }

        else
          {
            /* Shift the lookahead token.  */
            yy_symbol_print ("Shifting", yytoken,
                             yylval);

            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
        /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

        if (yychar <= Lexer.EOF)
          {
          /* Return failure if at end of input.  */
          if (yychar == Lexer.EOF)
            return false;
          }
        else
            yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:

        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yy_pact_value_is_default_ (yyn))
              {
                yyn += yyterror_;
                if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;

            
            yystack.pop ();
            yystate = yystack.stateAt (0);
            if (yydebug > 0)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
            /* Leave the switch.  */
            break;



        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
                         yylval);

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yy_pact_value_is_default_ (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yy_table_value_is_error_ (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -116;
  private static final short yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short yypact_[] = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     136,  -116,    36,    92,    99,   148,   155,   162,   178,   -21,
     240,    86,    38,  -116,    -6,   308,   172,   240,    16,   146,
    -116,  -116,   204,  -116,  -116,  -116,   197,   356,   214,  -116,
    -116,    21,   -14,   331,  -116,  -116,  -116,  -116,  -116,   284,
      18,   247,   247,   252,   240,   240,   222,    -8,    -7,   -16,
    -116,    38,   220,   240,   339,   284,   229,   222,   248,    38,
     207,   348,   149,   217,   308,   308,  -116,   322,    -4,   273,
    -116,   242,   244,  -116,   255,   266,  -116,   356,   214,    21,
     160,  -116,   214,   250,   240,   240,   240,   240,   250,  -116,
      38,    38,   308,   308,   308,   308,   308,   308,   308,   262,
     264,    17,   247,   286,   292,   240,    69,    26,   109,    81,
    -116,     2,   293,    34,  -116,   294,  -116,   229,   240,   311,
      63,   222,  -116,   325,    58,   240,   240,  -116,   344,   344,
      88,   310,  -116,  -116,  -116,   240,   240,   222,   332,   342,
    -116,   351,   351,   313,     9,   106,   106,   339,   339,    30,
     193,   193,   344,   241,   241,   327,   327,   327,   344,   335,
     333,   347,  -116,   343,  -116,  -116,  -116,   101,  -116,  -116,
     151,  -116,   186,  -116,   352,   308,  -116,   357,   341,  -116,
     115,  -116,    97,   308,  -116,   373,  -116,  -116,  -116,   308,
    -116,  -116,    31,   240,   372,   380,  -116,  -116,  -116,  -116,
     353,   367,   362,   355,  -116,  -116,  -116,  -116,   344,  -116,
     213,  -116,  -116,   296,   308,   344,  -116,   164,   240,   378,
     385,   367,  -116,   253,   358,   367,  -116,   368,  -116,   301,
    -116,   183,   240,   382,   211,   257,   375,   377,   367,   274,
    -116,  -116,  -116,   190,   240,   386,   387,  -116,  -116,   381,
    -116,  -116,   283,   383,  -116,   199,   240,   240,  -116,   384,
    -116,  -116,   212,   219,  -116,  -116,  -116
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte yydefact_[] = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,    15,     0,     0,     0,     0,     0,     0,     0,    34,
       0,     0,     0,    94,    96,     0,     0,     0,     0,     0,
      63,    64,     0,     5,    16,    14,     0,    12,     8,     9,
       7,     6,    10,    11,    78,    79,    77,    76,    65,    13,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
      89,     0,    96,     0,    86,     0,     0,     0,     0,     0,
       0,     0,     0,     0,   104,     0,   103,     0,     0,     0,
      68,     0,     0,     1,     0,     0,    21,     0,     0,     0,
       0,    17,     0,    34,     0,     0,     0,     0,    34,    82,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,    45,     0,     0,     0,     0,     0,     0,     0,
      51,     0,     0,     0,     2,     0,    87,     0,     0,     0,
       0,     0,    47,     0,     0,     0,     0,    85,    84,   105,
       0,     0,    69,    83,    97,     0,     0,     0,     0,     0,
      20,     0,     0,     0,     0,    66,    67,    70,    71,     0,
      81,    80,    93,    98,    99,   100,   101,   102,    92,     0,
       0,     0,    55,     0,    46,    44,    43,     0,    22,    39,
       0,    41,     0,    26,     0,     0,    35,     0,     0,    90,
       0,    49,     0,     0,    48,     0,    74,    75,    95,     0,
      72,    73,     0,     0,     0,     0,    19,    18,     3,     4,
       0,    60,     0,     0,    23,    42,    40,    52,    91,    36,
       0,    88,    50,     0,     0,   106,    27,     0,     0,     0,
       0,    60,    61,     0,     0,    60,    37,     0,    53,     0,
      28,     0,     0,     0,     0,     0,     0,     0,    60,     0,
      38,    54,    29,     0,     0,     0,     0,    24,    25,     0,
      56,    62,     0,     0,    30,     0,     0,     0,    57,     0,
      58,    31,     0,     0,    59,    32,    33
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short yypgoto_[] = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
    -116,  -116,   407,   -29,  -116,  -116,  -116,  -116,  -116,  -116,
    -116,  -116,  -116,    67,     1,  -116,     4,     6,   -37,   369,
    -116,   -48,  -116,    11,  -116,  -115,     0,    12,  -116,  -116,
    -116,  -116,  -116,   298,  -116,     3,  -116
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short yydefgoto_[] = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
      -1,    22,    76,    24,    25,    26,    75,   139,   195,   220,
     234,   247,   248,    48,    77,   107,    78,    80,   103,    30,
      60,   111,   124,    79,   101,   223,    67,    61,    34,    35,
      36,    37,    49,    50,    38,    55,   130
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short yytable_[] = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      32,    27,    81,    39,    28,   104,    29,   116,    83,   120,
      54,    31,    33,   112,    63,    47,   114,    70,    66,    69,
     161,    99,    89,    90,    62,   173,    91,     4,    68,     5,
     117,   118,   198,    84,    85,    82,    86,    87,    64,   115,
     162,   133,   113,   106,   108,   109,   163,   100,   174,   169,
      81,   140,    71,   199,   216,   115,    69,    51,    40,    12,
      56,    13,    52,    10,    15,   164,   128,   129,   131,   176,
      53,    68,   177,   182,    58,    17,   115,   174,    18,    19,
      20,    21,    59,    82,   145,   146,   147,   148,   142,   192,
     184,   141,   168,   181,   185,   152,   153,   154,   155,   156,
     157,   158,   150,   151,   172,   167,   235,   170,    56,   174,
     239,    10,   196,   197,    41,    57,    84,    85,   180,    86,
      87,    42,    58,   252,   204,   186,   187,   212,    84,    85,
      59,    86,    87,   188,   189,   190,   191,     1,   211,   171,
       2,     3,     4,   174,     5,     6,     7,     8,    84,    85,
     144,    86,    87,    84,    85,   149,    84,    85,     9,    86,
      87,    10,    84,    85,     2,    86,    87,    11,     5,    12,
      43,    13,    14,   206,    15,    89,    90,    44,   208,    91,
      16,   205,    72,   126,    45,    17,   213,   230,    18,    19,
      20,    21,   215,   217,    56,     6,     7,    10,    84,    85,
      46,    86,    87,    51,    73,    12,   242,    13,    14,    74,
      15,    84,    85,   254,    86,    87,    16,   229,   231,     3,
      90,    17,   261,    91,    18,    19,    20,    21,   245,   246,
      84,    85,   243,    86,    87,   265,   121,    84,    85,   122,
      86,    87,   266,   123,   255,   127,    84,    85,   226,    86,
      87,   227,    13,    52,   102,    15,   262,   263,   110,    84,
      85,    65,    86,    87,    64,   119,    84,    85,    63,    86,
      87,    51,   135,    12,   136,    13,    52,   137,    15,   138,
      95,    96,    97,    11,    53,    12,   143,    13,    52,    17,
      15,   159,    18,    19,    20,    21,    53,    92,   236,   237,
     160,    17,   249,   237,    18,    19,    20,    21,    92,   165,
      93,    94,    95,    96,    97,   166,    98,   175,   134,   253,
     237,    93,    94,    95,    96,    97,   228,    98,   259,   237,
     178,   241,   112,    93,    94,    95,    96,    97,    93,    94,
      95,    96,    97,    13,    52,   183,    15,    93,    94,    95,
      96,    97,    65,    88,   193,   134,   194,    89,    90,     5,
       2,    91,     4,   113,     5,     6,     7,   132,    97,    84,
      85,   200,    86,    87,    89,    90,   202,   201,    91,   203,
     125,    93,    94,    95,    96,    97,    84,    85,   207,    86,
      87,   210,   209,   214,   218,   219,   222,   221,   224,   225,
     232,   233,   238,   240,   244,   250,   251,    23,   256,   257,
       0,   258,   105,   260,   264,   179
    };
  }

private static final short yycheck_[] = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
       0,     0,    31,     0,     0,    42,     0,    23,    22,    57,
      10,     0,     0,    21,    20,    36,    23,    17,    15,    16,
       3,     3,    26,    27,    12,    23,    30,     6,    16,     8,
      46,    47,    23,    47,    48,    31,    50,    51,    44,    46,
      23,    45,    50,    43,    44,    45,    29,    29,    46,    23,
      79,    80,    36,    23,    23,    46,    53,    31,    22,    33,
      22,    35,    36,    25,    38,   102,    63,    64,    65,    35,
      44,    59,    38,   121,    36,    49,    46,    46,    52,    53,
      54,    55,    44,    79,    84,    85,    86,    87,    82,   137,
      32,    80,    23,    30,    36,    92,    93,    94,    95,    96,
      97,    98,    90,    91,    23,   105,   221,   107,    22,    46,
     225,    25,   141,   142,    22,    29,    47,    48,   118,    50,
      51,    22,    36,   238,    23,   125,   126,    30,    47,    48,
      44,    50,    51,    45,    46,   135,   136,     1,    23,    30,
       4,     5,     6,    46,     8,     9,    10,    11,    47,    48,
      83,    50,    51,    47,    48,    88,    47,    48,    22,    50,
      51,    25,    47,    48,     4,    50,    51,    31,     8,    33,
      22,    35,    36,   172,    38,    26,    27,    22,   175,    30,
      44,    30,    36,    34,    22,    49,   183,    23,    52,    53,
      54,    55,   189,   193,    22,     9,    10,    25,    47,    48,
      22,    50,    51,    31,     0,    33,    23,    35,    36,    12,
      38,    47,    48,    23,    50,    51,    44,   214,   218,     5,
      27,    49,    23,    30,    52,    53,    54,    55,    17,    18,
      47,    48,   232,    50,    51,    23,    29,    47,    48,    32,
      50,    51,    23,    36,   244,    28,    47,    48,    35,    50,
      51,    38,    35,    36,     7,    38,   256,   257,    36,    47,
      48,    44,    50,    51,    44,    36,    47,    48,    20,    50,
      51,    31,    30,    33,    30,    35,    36,    22,    38,    13,
      39,    40,    41,    31,    44,    33,    36,    35,    36,    49,
      38,    29,    52,    53,    54,    55,    44,    24,    45,    46,
      36,    49,    45,    46,    52,    53,    54,    55,    24,    23,
      37,    38,    39,    40,    41,    23,    43,    24,    45,    45,
      46,    37,    38,    39,    40,    41,    30,    43,    45,    46,
      36,    30,    21,    37,    38,    39,    40,    41,    37,    38,
      39,    40,    41,    35,    36,    20,    38,    37,    38,    39,
      40,    41,    44,    22,    22,    45,    14,    26,    27,     8,
       4,    30,     6,    50,     8,     9,    10,    45,    41,    47,
      48,    36,    50,    51,    26,    27,    29,    44,    30,    36,
      32,    37,    38,    39,    40,    41,    47,    48,    36,    50,
      51,    50,    35,    20,    22,    15,    29,    44,    36,    44,
      22,    16,    44,    35,    22,    30,    29,     0,    22,    22,
      -1,    30,    43,    30,    30,   117
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     1,     4,     5,     6,     8,     9,    10,    11,    22,
      25,    31,    33,    35,    36,    38,    44,    49,    52,    53,
      54,    55,    59,    60,    61,    62,    63,    72,    74,    75,
      77,    81,    84,    85,    86,    87,    88,    89,    92,    93,
      22,    22,    22,    22,    22,    22,    22,    36,    71,    90,
      91,    31,    36,    44,    84,    93,    22,    29,    36,    44,
      78,    85,    85,    20,    44,    44,    93,    84,    85,    93,
      84,    36,    36,     0,    12,    64,    60,    72,    74,    81,
      75,    61,    74,    22,    47,    48,    50,    51,    22,    26,
      27,    30,    24,    37,    38,    39,    40,    41,    43,     3,
      29,    82,     7,    76,    76,    77,    84,    73,    84,    84,
      36,    79,    21,    50,    23,    46,    23,    46,    47,    36,
      79,    29,    32,    36,    80,    32,    34,    28,    93,    93,
      94,    93,    45,    45,    45,    30,    30,    22,    13,    65,
      61,    81,    75,    36,    71,    84,    84,    84,    84,    71,
      85,    85,    93,    93,    93,    93,    93,    93,    93,    29,
      36,     3,    23,    29,    76,    23,    23,    84,    23,    23,
      84,    30,    23,    23,    46,    24,    35,    38,    36,    91,
      84,    30,    79,    20,    32,    36,    84,    84,    45,    46,
      84,    84,    79,    22,    14,    66,    61,    61,    23,    23,
      36,    44,    29,    36,    23,    30,    72,    36,    93,    35,
      50,    23,    30,    93,    20,    93,    23,    84,    22,    15,
      67,    44,    29,    83,    36,    44,    35,    38,    30,    93,
      23,    84,    22,    16,    68,    83,    45,    46,    44,    83,
      35,    30,    23,    84,    22,    17,    18,    69,    70,    45,
      30,    29,    83,    45,    23,    84,    22,    22,    30,    45,
      30,    23,    84,    84,    30,    23,    23
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    58,    59,    59,    59,    59,    59,    59,    59,    59,
      59,    59,    59,    59,    59,    59,    60,    60,    60,    60,
      60,    60,    61,    61,    62,    62,    63,    64,    65,    66,
      67,    68,    69,    70,    71,    71,    71,    71,    71,    72,
      72,    73,    73,    74,    75,    76,    76,    77,    77,    78,
      78,    79,    79,    80,    80,    81,    82,    82,    82,    82,
      83,    83,    83,    84,    84,    84,    84,    84,    84,    84,
      84,    84,    84,    84,    84,    84,    85,    85,    85,    85,
      85,    85,    85,    85,    86,    87,    88,    89,    89,    90,
      90,    91,    92,    92,    93,    93,    93,    93,    93,    93,
      93,    93,    93,    93,    94,    94,    94
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     3,     4,     4,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     2,     4,     4,
       3,     2,     4,     5,     7,     7,     4,     4,     4,     4,
       4,     4,     4,     4,     0,     3,     4,     5,     6,     4,
       5,     2,     3,     4,     4,     1,     2,     3,     4,     3,
       4,     1,     3,     4,     5,     4,     6,     7,     7,     8,
       0,     1,     3,     1,     1,     1,     3,     3,     2,     3,
       3,     3,     4,     4,     4,     4,     1,     1,     1,     1,
       3,     3,     2,     3,     3,     3,     2,     3,     5,     1,
       3,     4,     3,     3,     1,     4,     1,     3,     3,     3,
       3,     3,     3,     2,     0,     1,     3
    };
  }

  /* YYTOKEN_NUMBER[YYLEX-NUM] -- Internal symbol number corresponding
      to YYLEX-NUM.  */
  private static final short yytoken_number_[] = yytoken_number_init();
  private static final short[] yytoken_number_init()
  {
    return new short[]
    {
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298,   299,   300,   301,   302,   303,   304,
     305,   306,   307,   308,   309,   310,   311,   312
    };
  }

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "EXTERNAL", "FUNCTIONS", "RULES",
  "SCHEMAVARIABLES", "SCHEMATEXT", "PROBLEM", "ANNOTATION", "BOUNDS",
  "STATEVARIABLES", "EIPARAMETERS", "ENVELOPE", "INVARIANT",
  "ROBUSTPARAMETERS", "DOMAIN", "CONTROLLAW", "CONTROLTEMPLATE",
  "SETTINGS", "ASSIGN", "PRIME", "OPENBRACE", "CLOSEBRACE", "EQUALS",
  "TEST", "KLEENESTAR", "CUP", "RANDOM", "REALDECLARATION", "SEMICOLON",
  "OPENBOX", "CLOSEBOX", "OPENDIAMOND", "CLOSEDIAMOND", "NUMBER",
  "IDENTIFIER", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "POWER", "NEWLINE",
  "INEQUALITY", "LPAREN", "RPAREN", "COMMA", "AND", "OR", "NOT", "IMPLIES",
  "IFF", "FORALL", "EXISTS", "TRUE", "FALSE", "QUANTIFIER", "NEGATIVE",
  "$accept", "input", "keymaerablock", "problemblock", "eitoolblock",
  "statevarblock", "eiparameterblock", "envelopeblock", "invariantblock",
  "robustparameterblock", "domainblock", "controllawblock",
  "controltemplateblock", "valuation", "annotationblock", "annotationlist",
  "schemavarsblock", "rulesblock", "schematext", "varblock",
  "vardeclaration", "varlist", "varinitlist", "funblock",
  "functiondeclaration", "argumentdeclaration", "dLformula",
  "hybridprogram", "concreteassignment", "arbitraryassignment", "test",
  "odesystem", "odelist", "ode", "comparison", "term", "argumentlist", null
    };
  }

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,   120,   120,   128,   137,   146,   154,   162,   170,   179,
     187,   196,   205,   213,   222,   230,   240,   248,   256,   264,
     272,   280,   291,   300,   313,   321,   330,   340,   351,   361,
     371,   389,   400,   409,   425,   426,   441,   456,   468,   486,
     494,   505,   515,   534,   549,   564,   572,   586,   600,   622,
     630,   644,   654,   667,   679,   696,   708,   717,   726,   735,
     747,   750,   758,   771,   779,   787,   795,   803,   811,   819,
     827,   835,   843,   851,   859,   867,   878,   886,   894,   902,
     910,   918,   926,   934,   945,   956,   967,   978,   986,   997,
    1011,  1026,  1040,  1048,  1060,  1068,  1076,  1084,  1092,  1104,
    1116,  1128,  1140,  1152,  1167,  1170,  1180
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
                       yystos_[yystack.stateAt(yynrhs - (yyi + 1))],
                       ((yystack.valueAt (yynrhs-(yyi + 1)))));
  }

  /* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
  private static final byte yytranslate_table_[] = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57
    };
  }

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 415;
  private static final int yynnts_ = 37;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 73;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 58;

  private static final int yyuser_token_number_max_ = 312;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */

}

/* "dLParser.y":1194  */ /* lalr1.java:1070  */





