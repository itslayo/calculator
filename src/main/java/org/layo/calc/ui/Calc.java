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
public class Calc extends JFrame {

    private JTextField exprTextField;
    private JTextField resultTextField;
    private JPanel mainPanel;
    private JPanel historyPanel;
    private JButton btnEval;
    private JButton btnViewHistory;

    private static Calc instance = null;

    private Command command;

    public Calc() throws HeadlessException {
        super("Calculator");
        initComponents();
        setSize(500, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);
        mainPanel.add(exprTextField);
        btnEval.addActionListener(new EvaluateEventListener());
        mainPanel.add(btnEval);
        mainPanel.add(resultTextField);
        btnViewHistory.addActionListener(new HistoryEventListener());
        historyPanel.add(btnViewHistory);
        container.add(mainPanel);
        container.add(historyPanel);
    }

    private void initComponents(){
        exprTextField = new JTextField(20);
        resultTextField = new JTextField(10);
        resultTextField.setEditable(false);
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEtchedBorder());
        historyPanel = new JPanel();
        historyPanel.setBorder(BorderFactory.createEtchedBorder());
        btnEval = new JButton("Evaluate");
        btnViewHistory = new JButton("View History");
    }

    class EvaluateEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String exprTextValue = exprTextField.getText();
            Evaluate evaluate = new Evaluate();
            EvaluateCommand evCommand = new EvaluateCommand(evaluate, exprTextValue);
            setCommand(evCommand);
            String result = command.execute();
            resultTextField.setText(result);
            DBConnect.updateDB(exprTextValue);
        }
    }

    class HistoryEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new DataRetrieve(DBConnect.retrieveFromDB());
        }
    }

    public void setExprTextField(String exprTextField) {
        this.exprTextField.setText(exprTextField);
    }

    public void setResultTextField(String resultTextField) {
        this.resultTextField.setText(resultTextField);
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public static Calc getInstance(){
        if(instance == null)
            instance =  new Calc();
        return instance;
    }
}
