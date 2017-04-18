package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Program_Block {
LEX_Block scanner;
  S_Program_Block() {
	}
  S_Program_Block(LEX_Block scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_Block att_scanner;
  private void regle0() throws Exception {

	//declaration
	T_Block x_2 = new T_Block(scanner ) ;
	S_Block_Block x_3 = new S_Block_Block(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_Block.token_identifier);
	x_3.analyser() ;
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Block.token_identifier : // 41
        regle0 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlockMessages.id_Block_unexpected_token,BlockMessages.Block_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
