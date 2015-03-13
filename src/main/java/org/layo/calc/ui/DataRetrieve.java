package org.layo.calc.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Layo on 12.03.2015.
 */
public class DataRetrieve extends JFrame {
    private JButton selectExpr;
    private JList<String> list;
    private JScrollPane scrollPane;
    private JPanel btnPanel;

    public DataRetrieve(DefaultListModel listModel) throws HeadlessException {
        super("List of evaluated expressions");
        initComponents(listModel);
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);
        add(scrollPane);
        add(btnPanel, BorderLayout.SOUTH);
        btnPanel.add(selectExpr);
    }

    /**
     * Init components for JFrame
     * @param listModel
     */
    private void initComponents(DefaultListModel listModel){
        list = new JList(listModel);
        scrollPane = new JScrollPane(list);
        btnPanel = new JPanel();
        selectExpr = new JButton("Choose selected expression");
        selectExpr.addActionListener(new ChooseListItemListener());
    }

    class ChooseListItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedExpr = list.getSelectedValue();
            Calc mainFrame = Calc.getInstance();
            mainFrame.setExprTextField(selectedExpr);
            dispose();
        }
    }
}
