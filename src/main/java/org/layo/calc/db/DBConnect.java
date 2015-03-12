package org.layo.calc.db;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Layo on 11.03.2015.
 */
public class DBConnect {

    private static Connection conn;
    private static Statement st;

    static {
        try {
            Class.forName("org.h2.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            st = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDB(String expr) {
        try {
            st.execute("CREATE TABLE IF NOT EXISTS expressions (expression VARCHAR(255))");
            String q = "INSERT INTO expressions(expression) VALUES(?)";
            PreparedStatement st1;
            st1 = conn.prepareStatement(q);
            st1.setString(1, expr);
            st1.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DefaultListModel retrieveFromDB(){
        List<String> resultList = new ArrayList<String>();
        ResultSet result;
        DefaultListModel listModel = new DefaultListModel();
        try {
            result = st.executeQuery("SELECT * FROM expressions");
            while (result.next()) {
                String exprFromDB = result.getString("expression");
                resultList.add(exprFromDB);
                System.out.println(exprFromDB);
                listModel.addElement(exprFromDB);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listModel;
    }
}
