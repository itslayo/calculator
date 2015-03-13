package org.layo.calc.operators.impl;

import org.layo.calc.operators.AbstractOperator;

/**
 * Created by Layo on 12.03.2015.
 */
public class AdditionOperator extends AbstractOperator {

    public AdditionOperator() {
        super('+');
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }

    @Override
    public char getSymbol() {
        return super.getSymbol();
    }
}
