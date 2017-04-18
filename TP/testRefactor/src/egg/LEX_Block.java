package egg;
import java.util.Arrays;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.messages.NLS;
import mg.egg.eggc.runtime.libjava.lex.LEXICAL4;
import mg.egg.eggc.runtime.libjava.lex.LEX_CONTEXTE;
import mg.egg.eggc.runtime.libjava.problem.IProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemSeverities;
import java.util.*;
public class LEX_Block extends LEXICAL4  {
 public static final int EOF = 0 ;
 public static final int token_right_parenthesis = 1 ;
 public static final int token_different = 2 ;
 public static final int token_add = 3 ;
 public static final int token_equality = 4 ;
 public static final int token_comments = 5 ;
 public static final int token_left_brace = 6 ;
 public static final int token_subtract = 7 ;
 public static final int token_true = 8 ;
 public static final int token_sup_or_equal = 9 ;
 public static final int token_first = 10 ;
 public static final int token_type_int = 11 ;
 public static final int token_comma = 12 ;
 public static final int token_identifier = 13 ;
 public static final int token_right_brace = 14 ;
 public static final int token_struct = 15 ;
 public static final int token_type_bool = 16 ;
 public static final int token_left_parenthesis = 17 ;
 public static final int token_sup = 18 ;
 public static final int token_else = 19 ;
 public static final int token_identifier_type = 20 ;
 public static final int token_multiply = 21 ;
 public static final int token_divide = 22 ;
 public static final int token_right_bracket = 23 ;
 public static final int token_period = 24 ;
 public static final int token_second = 25 ;
 public static final int token_whitespace = 26 ;
 public static final int token_or = 27 ;
 public static final int token_constant = 28 ;
 public static final int token_integer = 29 ;
 public static final int token_while = 30 ;
 public static final int token_if = 31 ;
 public static final int token_inf_or_equal = 32 ;
 public static final int token_false = 33 ;
 public static final int token_and = 34 ;
 public static final int token_not = 35 ;
 public static final int token_assign = 36 ;
 public static final int token_inf = 37 ;
 public static final int token_print = 38 ;
 public static final int token_typedef = 39 ;
 public static final int token_semicolon = 40 ;
 public static final int token_left_bracket = 41 ;
 public static final int token_modulo = 42 ;
  static final int token_autre = 43 ;
  public static final String[][] tokenImages = {
	{"<EOF>"} ,{"right_parenthesis"},
{"different"},
{"add"},
{"equality"},
    {"comments"} ,
{"left_brace"},
{"subtract"},
{"true"},
{"sup_or_equal"},
{"first"},
{"type_int"},
{"comma"},
    {"identifier"} ,
{"right_brace"},
{"struct"},
{"type_bool"},
{"left_parenthesis"},
{"sup"},
{"else"},
    {"identifier_type"} ,
{"multiply"},
{"divide"},
{"right_bracket"},
{"period"},
{"second"},
    {"whitespace"} ,
{"or"},
{"constant"},
    {"integer"} ,
{"while"},
{"if"},
{"inf_or_equal"},
{"false"},
{"and"},
{"not"},
{"assign"},
{"inf"},
{"print"},
{"typedef"},
{"semicolon"},
{"left_bracket"},
{"modulo"},
  } ;
  private int [] separateurs = { 
token_comments
, token_whitespace
	} ;
  public int[] getSeparateurs(){
	return separateurs;
    }
  private int [] comments = { 
	} ;
  public int[] getComments(){
	return comments;
    }
  private int le_comment = -1;
  public int getComment(){
	return le_comment;
    }
  public LEX_Block(IProblemReporter pr, LEX_CONTEXTE lc, int k) {
	super(pr, lc,k);
	dernier_accepte = 0 ;
	analyseur = new JLEX_Block();
  }
  public void setSource ( LEXICAL4 scanner) throws EGGException{
	scanner.analyseur.toContext(scanner.contexte);
	analyseur.fromContext(scanner.contexte);
  }
  public void setReader ( LEXICAL4 scanner) {
	scanner.analyseur.setReader(scanner.contexte.source);
  }
  public void accepter_sucre ( int t ) throws EGGException {
	if ( fenetre[0].code == t ) {
	  dernier_accepte = fenetre[0].ligne ;
	  recovery = false;
	  decaler () ;
	}else {
	  _interrompre(IProblem.Syntax,getBeginLine(), IBlockMessages.id_Block_expected_token, BlockMessages.Block_expected_token,new Object[]{fenetre[0].getNom(), Arrays.asList(tokenImages[t])});
	}
  }
  public void accepter_fds() throws EGGException {
	lit ( 1 ) ;
	if ( fenetre[0].code != EOF ) {
	  _interrompre(IProblem.Syntax,getBeginLine(), IBlockMessages.id_Block_expected_token, BlockMessages.Block_expected_eof, new Object[]{fenetre[0].getNom()});
	  }
     else {
	  dernier_accepte = fenetre[0].ligne ;
	  }
	}
  public int ligneDepart () {
	return getBeginLine() + getEndLine() ;
	}
  public void _interrompre (int cat,  int line, int id,  String c , Object [] m )  {
	  //recovery = true;
	  recovery = false;
	  contexte.errors++;
	    problemReporter.handle(cat, id,line  , NLS.bind(c,m), getOffset(), getOffset() + getLength() - 1,ProblemSeverities.Error,m);
	}
	public void _signaler ( int cat, int line, int id, String c , Object [] m )  {
	    problemReporter.handle(cat , id, line  , NLS.bind(c,m),getOffset(), getOffset() + getLength() - 1,ProblemSeverities.Warning,m);
	}
  }
