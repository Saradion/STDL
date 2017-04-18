package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Field_Block {
LEX_Block scanner;
  S_Field_Block() {
	}
  S_Field_Block(LEX_Block scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_Block att_scanner;
  private void regle5() throws Exception {

	//declaration
	S_Type_Block x_2 = new S_Type_Block(scanner,att_eval) ;
	T_Block x_3 = new T_Block(scanner ) ;
	//appel
	x_2.analyser() ;
	x_3.analyser(LEX_Block.token_identifier);
  }
  public void analyser () throws Exception {
    regle5 () ;
  }
  }
