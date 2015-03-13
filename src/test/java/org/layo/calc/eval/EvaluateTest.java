package org.layo.calc.eval;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Layo on 12.03.2015.
 */
public class EvaluateTest {

    @Test
    public void testEvaluate(){
        assertEquals(4.0, Evaluate.evalExpression("4"));
        assertEquals(-4.0, Evaluate.evalExpression("-4"));
        assertEquals(2.0, Evaluate.evalExpression("4/2"));
        assertEquals(-2.0, Evaluate.evalExpression("4/-2"));
        assertEquals(14.0, Evaluate.evalExpression("4*3+2"));
        assertEquals(10.0, Evaluate.evalExpression("4+3*2"));
        assertEquals(16.0, Evaluate.evalExpression("4/2*8"));
        assertEquals(7.0, Evaluate.evalExpression("4+3"));
        assertEquals(-3.0, Evaluate.evalExpression("-3"));
        assertEquals(13.0, Evaluate.evalExpression("4+3+1+3+1+1"));
        assertEquals(10.0, Evaluate.evalExpression("4+3*2"));
        assertEquals(22.0, Evaluate.evalExpression("4+3*2*3"));
        assertEquals(-14.0, Evaluate.evalExpression("4+3*-2*3"));
        assertEquals(16.0, Evaluate.evalExpression("4/2*8"));
        assertEquals(16.0, Evaluate.evalExpression("4/2*8"));
        assertEquals(1.0, Evaluate.evalExpression("4*2/8"));
        assertEquals(1.0, Evaluate.evalExpression("4*2/8"));
        assertEquals(16.0, Evaluate.evalExpression("4/2*8"));
        assertEquals(-10.0, Evaluate.evalExpression("-3+-3-4"));
    }
}
