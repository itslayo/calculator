package org.layo.calc.command;

import org.layo.calc.eval.Evaluate;

/**
 * Created by Layo on 12.03.2015.
 */
public class EvaluateCommand implements Command {
    Evaluate evaluate;
    String expr;

    public EvaluateCommand(Evaluate evaluate, String expr) {
        this.evaluate = evaluate;
        this.expr = expr;
    }

    @Override
    public String execute() {
        return evaluate.evalExpression(expr);
    }
}
