package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Type_Block {
LEX_Block scanner;
  S_Type_Block() {
	}
  S_Type_Block(LEX_Block scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_Block att_scanner;
  private void regle3() throws Exception {

	//declaration
	T_Block x_2 = new T_Block(scanner ) ;
	T_Block x_3 = new T_Block(scanner ) ;
	T_Block x_4 = new T_Block(scanner ) ;
	S_Fields_Block x_5 = new S_Fields_Block(scanner,att_eval) ;
	T_Block x_6 = new T_Block(scanner ) ;
	//appel
	x_2.analyser(LEX_Block.token_struct);
	x_3.analyser(LEX_Block.token_identifier_type);
	x_4.analyser(LEX_Block.token_left_brace);
	x_5.analyser() ;
	x_6.analyser(LEX_Block.token_right_brace);
  }
  private void regle6() throws Exception {

	//declaration
	T_Block x_2 = new T_Block(scanner ) ;
	S_Type_Block x_3 = new S_Type_Block(scanner,att_eval) ;
	T_Block x_4 = new T_Block(scanner ) ;
	S_Type_Block x_5 = new S_Type_Block(scanner,att_eval) ;
	T_Block x_6 = new T_Block(scanner ) ;
	//appel
	x_2.analyser(LEX_Block.token_inf);
	x_3.analyser() ;
	x_4.analyser(LEX_Block.token_comma);
	x_5.analyser() ;
	x_6.analyser(LEX_Block.token_sup);
  }
  private void regle7() throws Exception {

	//declaration
	T_Block x_2 = new T_Block(scanner ) ;
	//appel
	x_2.analyser(LEX_Block.token_identifier);
  }
  private void regle8() throws Exception {

	//declaration
	T_Block x_2 = new T_Block(scanner ) ;
	//appel
	x_2.analyser(LEX_Block.token_type_bool);
  }
  private void regle9() throws Exception {

	//declaration
	T_Block x_2 = new T_Block(scanner ) ;
	//appel
	x_2.analyser(LEX_Block.token_type_int);
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Block.token_struct : // 38
        regle3 () ;
      break ;
      case LEX_Block.token_inf : // 9
        regle6 () ;
      break ;
      case LEX_Block.token_identifier : // 41
        regle7 () ;
      break ;
      case LEX_Block.token_type_bool : // 37
        regle8 () ;
      break ;
      case LEX_Block.token_type_int : // 36
        regle9 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlockMessages.id_Block_unexpected_token,BlockMessages.Block_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
