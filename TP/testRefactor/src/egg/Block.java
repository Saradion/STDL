package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.ISourceUnit;
import mg.egg.eggc.runtime.libjava.lex.LEX_CONTEXTE;
import mg.egg.eggc.runtime.libjava.problem.IProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemSeverities;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class Block {
  LEX_Block scanner;
  protected IProblemReporter problemReporter;
	private S_Program_Block axiome ;
	public  S_Program_Block getAxiom(){return axiome;}
  public Block(IProblemReporter pr){
	   this.problemReporter = pr;
  }
  public void compile(ISourceUnit cu) throws Exception {
	try{
	  System.err.println("Block Version 0.0.1");
	  LEX_CONTEXTE contexte;
	  contexte = new LEX_CONTEXTE(cu);
	  scanner = new LEX_Block(problemReporter, contexte, 1);
	  scanner.analyseur.fromContext(contexte);
	  att_scanner = scanner;
	  axiome = new S_Program_Block(scanner,att_eval);
	  axiome.att_scanner = this.att_scanner ;
	  axiome.att_eval = this.att_eval ;
	  axiome.analyser() ;
	  scanner.accepter_fds() ;
	}catch (EGGException e){
	  problemReporter.handle(e.getCategory(), e.getCode(),0, NLS.bind(e.getId(),e.getArgs()),ProblemSeverities.Error,0,0,e.getArgs());
	}
	}
  boolean att_eval;
  public void set_eval(boolean a_eval){
	att_eval = a_eval;
  }
  public boolean get_eval(){
	return att_eval;
  }
  LEX_Block att_scanner;
  public void set_scanner(LEX_Block a_scanner){
	att_scanner = a_scanner;
  }
  public LEX_Block get_scanner(){
	return att_scanner;
  }
  }
