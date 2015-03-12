package org.layo.calc.eval;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Layo on 12.03.2015.
 */
public class EvaluateTest {

    @Test
    public void testEvaluate(){
        Evaluate evaluate = new Evaluate();

            assertEquals("4.0", evaluate.evalExpression("4"));
            assertEquals("-4.0", evaluate.evalExpression("-4"));
            assertEquals("3.0", evaluate.evalExpression("4 + -1"));
            assertEquals("1.6", evaluate.evalExpression("1.2 + .4"));
            assertEquals("-5.0", evaluate.evalExpression("-4 + -1"));
            assertEquals("-12.0", evaluate.evalExpression("4 * -3"));
            assertEquals("2.0", evaluate.evalExpression("4 / 2"));
            assertEquals("-2.0", evaluate.evalExpression("4 / -2"));
            assertEquals("1.0", evaluate.evalExpression("7 % -2"));
            assertEquals("14.0", evaluate.evalExpression("4 * 3 + 2"));
            assertEquals("10.0", evaluate.evalExpression("4 + 3 * 2"));
            assertEquals("16.0", evaluate.evalExpression("4 / 2 * 8"));
            assertEquals("4.0", evaluate.evalExpression("-(-(4))"));
            assertEquals("7.0", evaluate.evalExpression("(4 + 3)"));
            assertEquals("-6.0", evaluate.evalExpression("-(3 + 3)"));
            assertEquals("13.0", evaluate.evalExpression("4 + (3 + 1) + (3 + 1) + 1"));
            assertEquals("14.0", evaluate.evalExpression("((4 + 3) * 2)"));
            assertEquals("42.0", evaluate.evalExpression("((4 + 3) * 2) * 3"));
            assertEquals("-42.0", evaluate.evalExpression("((4 + 3) * -2) * 3"));
            assertEquals("-2.0", evaluate.evalExpression("((4 + 3) * 2) / -7"));
            assertEquals("16.0", evaluate.evalExpression("(4 / 2) * 8"));
            assertEquals("0.25", evaluate.evalExpression("4 / (2 * 8)"));
            assertEquals("1.0", evaluate.evalExpression("(4 * 2) / 8"));
            assertEquals("1.0", evaluate.evalExpression("4 * (2 / 8)"));
            assertEquals("16.0", evaluate.evalExpression("(4 / (2) * 8)"));
            assertEquals("-4.0", evaluate.evalExpression("-(3 + -(3 - 4))"));
    }
}
