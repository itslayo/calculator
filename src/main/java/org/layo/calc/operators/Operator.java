package org.layo.calc.operators;

/**
 * Created by Layo on 12.03.2015.
 */
public interface Operator {
    public char getSymbol();
    public double evaluate(double leftOperand, double rightOperand);
}
