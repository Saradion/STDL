package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Fields_Block {
LEX_Block scanner;
  S_Fields_Block() {
	}
  S_Fields_Block(LEX_Block scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_Block att_scanner;
  private void regle4() throws Exception {

	//declaration
	S_Field_Block x_2 = new S_Field_Block(scanner,att_eval) ;
	S_Fields_Block x_3 = new S_Fields_Block(scanner,att_eval) ;
	//appel
	x_2.analyser() ;
	x_3.analyser() ;
  }
  public void analyser () throws Exception {
    regle4 () ;
  }
  }
