package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Block_Block {
LEX_Block scanner;
  S_Block_Block() {
	}
  S_Block_Block(LEX_Block scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_Block att_scanner;
  private void regle1() throws Exception {

	//declaration
	T_Block x_2 = new T_Block(scanner ) ;
	S_Instructions_Block x_3 = new S_Instructions_Block(scanner,att_eval) ;
	T_Block x_4 = new T_Block(scanner ) ;
	//appel
	x_2.analyser(LEX_Block.token_left_brace);
	x_3.analyser() ;
	x_4.analyser(LEX_Block.token_right_brace);
  }
  public void analyser () throws Exception {
    regle1 () ;
  }
  }
