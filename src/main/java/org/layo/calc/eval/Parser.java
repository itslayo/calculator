package org.layo.calc.eval;

import org.layo.calc.operators.impl.AdditionOperator;
import org.layo.calc.operators.impl.DivisionOperator;
import org.layo.calc.operators.impl.MultiplicationOperator;
import org.layo.calc.operators.impl.SubtractionOperator;

/**
 * Created by Layo on 13.03.2015.
 */
public class Parser {
    private AdditionOperator aoOp = new AdditionOperator();
    private DivisionOperator doOp = new DivisionOperator();
    private MultiplicationOperator moOp = new MultiplicationOperator();
    private SubtractionOperator soOp = new SubtractionOperator();
    private int pos = -1, c;
    private String str;

    public Parser(String str) {
        this.str = str;
    }

    /**
     * Deleting char after reading it
     */
    void eatChar() {
        c = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    /**
     * Main method that starts parsing
     */
    double parse() {
        eatChar();
        double v = parseExpression();
        if (c != -1) throw new RuntimeException("Unexpected: " + (char)c);
        return v;
    }

    /**
     * Reading + and - operators
     * Addition or substraction
     * @return calculated value of 2 double values
     */
    double parseExpression() {
        double v = parseTerm();
        for (;;) {
            if (c == aoOp.getSymbol()) {
                eatChar();
                v = aoOp.evaluate(v, parseTerm());
            } else if (c == soOp.getSymbol()) {
                eatChar();
                v = soOp.evaluate(v, parseTerm());
            } else {
                return v;
            }
        }
    }

    /**
     * Reading * and / operators
     * Multiplication or division
     * @return calculated value of 2 double values
     */
    double parseTerm() {
        double v = parseFactor();
        for (;;) {
            if (c == doOp.getSymbol()) {
                eatChar();
                v = doOp.evaluate(v, parseFactor());
            } else if (c == moOp.getSymbol()) {
                eatChar();
                v = moOp.evaluate(v, parseFactor());
            } else {
                return v;
            }
        }
    }

    /**
     * Method for working with negative numbers
     * Parsing numbers and . symbol
     * @return double value of number
     */
    double parseFactor() {
        double v;
        boolean negate = false;
        if (c == aoOp.getSymbol() || c == soOp.getSymbol()) {
            negate = c == soOp.getSymbol();
            eatChar();
        }
        StringBuilder sb = new StringBuilder();
        while ((c >= '0' && c <= '9') || c == '.') {
            sb.append((char) c);
            eatChar();
        }
        if (sb.length() == 0) throw new RuntimeException("Unexpected: " + (char) c);
        v = Double.parseDouble(sb.toString());
        if (negate) v = -v;
        return v;
    }
}
