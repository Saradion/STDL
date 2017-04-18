import egg.*;
import mg.egg.eggc.runtime.libjava.ISourceUnit;
import mg.egg.eggc.runtime.libjava.SourceUnit;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.ProblemRequestor;

public class Main {
    public static void main(String[] args) {
        try {
            ISourceUnit su = new SourceUnit(args[0]);
            System.out.println("Analyzing file : " + args[0]);
            ProblemReporter problemReporter = new ProblemReporter(su);
            ProblemRequestor problemRequestor = new ProblemRequestor();
            Block block = new Block(problemReporter);
            block.set_eval(false);
            block.compile(su);
            problemRequestor.beginReporting();
            for (IProblem problem : problemReporter.getAllProblems()) {
                problemRequestor.acceptProblem(problem);
            }
            problemRequestor.endReporting();
            System.out.println("Done");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
