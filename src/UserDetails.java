import DBConnect.dbConnect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserDetails extends JFrame {
    private JPanel panel1;
    private JTextField txtUsername;
    private JTextField textField1;
    private JTextField txtEmail;
    private JTextField txtNumber;
    private JTextField txtGPA;
    private JTextField txtAcdYr;
    private JButton exitButton;
    private JButton insertDataButton;
    private Statement stml=null;

    public UserDetails(String userName) {
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        fillDetails(userName);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        insertDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreDetails().setVisible(true);
                setVisible(false);

            }
        });
    }
    private void fillDetails(String userName)
    {
        DBConnect.dbConnect DB = new dbConnect();//Object from DB connect
        stml = DB.Conn2DB();//Connect to DB
        String query = "Select * from userDetails where UserName='"+userName+"'";
        try{
            ResultSet rs= stml.executeQuery(query);
            rs.first();
            txtUsername.setText(rs.getString("UserName"));
            txtEmail.setText(rs.getString("Email"));
        }catch (SQLException se)
        {
            se.printStackTrace();
        }
    }
}
