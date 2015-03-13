package org.layo.calc.operators;

/**
 * Created by Layo on 12.03.2015.
 */
public abstract class AbstractOperator implements Operator {

    private char symb;

    public AbstractOperator(char symb) {
        this.symb = symb;
    }

    /**
     * Get char symbol of an operator
     * @return char symbol
     */
    public char getSymbol() {
        return symb;
    }

    /**
     * Calculate 2 double operands
     * @param leftOperand
     * @param rightOperand
     * @return double result
     */
    public double evaluate(double leftOperand, double rightOperand) {
        return 0;
    }

}
