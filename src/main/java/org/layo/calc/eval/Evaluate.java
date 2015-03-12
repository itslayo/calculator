package org.layo.calc.eval;

/**
 * Created by Layo on 11.03.2015.
 */

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class Evaluate {
    public String evalExpression(String expr){
        String result = "";
        Evaluator evaluator = new Evaluator();
        try {
            result = evaluator.evaluate(expr);
        } catch (EvaluationException e) {
            e.printStackTrace();
        }
        return result;
    }
}
