package org.layo.calc.ui;

import org.layo.calc.command.Command;
import org.layo.calc.command.EvaluateCommand;
import org.layo.calc.db.DBConnect;
import org.layo.calc.eval.Evaluate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Layo on 11.03.2015.
 */
public class Calc extends JFrame implements ActionListener {

    private static Calc instance = null;

    private Command command;

    private JPanel[] row = new JPanel[5];
    private JButton[] button = new JButton[19];
    private JTextField display = new JTextField(25);
    private String[] buttonString = {"7", "8", "9", "+",
            	                     "4", "5", "6", "-",
            	                     "1", "2", "3", "*",
                                     ".", "/", "Clear", "History",
                                     "Exit", "=", "0"};
    private int[] dimW = {300,45,100,90};
    private int[] dimH = {35, 40};
    private Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    private Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    private Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    private Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
    private boolean[] function = new boolean[4];

    public Calc() throws HeadlessException {
        super("Calculator");
        setSize(380, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        GridLayout grid = new GridLayout(5,5);
        setLayout(grid);
        for(int i = 0; i < 4; i++)
             function[i] = false;
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        for(int i = 0; i < 5; i++)
             row[i] = new JPanel();
        	 row[0].setLayout(f1);
        	 for(int i = 1; i < 5; i++)
            	  row[i].setLayout(f2);

        for(int i = 0; i < 19; i++) {
             button[i] = new JButton();
             button[i].setText(buttonString[i]);
             button[i].addActionListener(this);
        }
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);
        for(int i = 0; i < 14; i++)
            button[i].setPreferredSize(regularDimension);
        	for(int i = 14; i < 18; i++)
                button[i].setPreferredSize(rColumnDimension);
        	    button[18].setPreferredSize(zeroButDimension);
        row[0].add(display);
        add(row[0]);
        for(int i = 0; i < 4; i++)
            row[1].add(button[i]);
            row[1].add(button[14]);
            add(row[1]);

        for(int i = 4; i < 8; i++)
            row[2].add(button[i]);
            row[2].add(button[15]);
            add(row[2]);

        for(int i = 8; i < 12; i++)
            row[3].add(button[i]);
            row[3].add(button[16]);
            add(row[3]);

        row[4].add(button[18]);
        for(int i = 12; i < 14; i++)
            row[4].add(button[i]);
            row[4].add(button[17]);
            add(row[4]);

        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[0]){
            display.setText(display.getText().concat("7"));
        }
        if (e.getSource() == button[1]){
            display.setText(display.getText().concat("8"));
        }
        if (e.getSource() == button[2]){
            display.setText(display.getText().concat("9"));
        }
        if (e.getSource() == button[3]){
            display.setText(display.getText().concat("+"));
        }
        if (e.getSource() == button[4]){
            display.setText(display.getText().concat("4"));
        }
        if (e.getSource() == button[5]){
            display.setText(display.getText().concat("5"));
        }
        if (e.getSource() == button[6]){
            display.setText(display.getText().concat("6"));
        }
        if (e.getSource() == button[7]){
            display.setText(display.getText().concat("-"));
        }
        if (e.getSource() == button[8]){
            display.setText(display.getText().concat("1"));
        }
        if (e.getSource() == button[9]){
            display.setText(display.getText().concat("2"));
        }
        if (e.getSource() == button[10]){
            display.setText(display.getText().concat("3"));
        }
        if (e.getSource() == button[11]){
            display.setText(display.getText().concat("*"));
        }
        if (e.getSource() == button[12]){
            display.setText(display.getText().concat("."));
        }
        if (e.getSource() == button[13]){
            display.setText(display.getText().concat("/"));
        }
        if (e.getSource() == button[14]){
            display.setText("");
        }
        if (e.getSource() == button[15]){
            new DataRetrieve(DBConnect.retrieveFromDB());
        }
        if (e.getSource() == button[16]){
            dispose();
        }
        if (e.getSource() == button[17]){
            String exprTextValue = display.getText();
            Evaluate evaluate = new Evaluate();
            EvaluateCommand evCommand = new EvaluateCommand(evaluate, exprTextValue);
            setCommand(evCommand);
            double result = command.execute();
            display.setText(String.valueOf(result));
            DBConnect.updateDB(exprTextValue);
        }
        if (e.getSource() == button[18]){
            display.setText(display.getText().concat("0"));
        }
    }

    /**
     * Set value for input field
     * @param exprTextField
     */
    public void setExprTextField(String exprTextField) {
        this.display.setText(exprTextField);
    }

    /**
     * Set command
     * Building pattern Command
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Making class Calc as Singleton
     * @return instance of class Calc
     */
    public static Calc getInstance(){
        if(instance == null)
            instance =  new Calc();
        return instance;
    }
}
