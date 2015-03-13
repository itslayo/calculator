package org.layo.calc.eval;

/**
 * Created by Layo on 11.03.2015.
 */
public class Evaluate {
    /**
     * Main method for evaluating expression
     * @param str - String value of entered expression
     */
    public static double evalExpression(final String str) {
        return new Parser(str).parse();
        }
}
