import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import DBConnect.*;

public class Login {
    private JPanel panel1;
    private JTextField txtUsername;
    private JPasswordField txtPW;
    private JButton btnExit;
    private JButton btnLogin;
    public static JFrame logFR = new JFrame("Login for FIS");
    private Statement stml=null;

    public Login() {
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validateUserPW())JOptionPane.showMessageDialog(null,"Sorry, "+txtUsername.getText()+" Login Failed");
                else
                {
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    new UserDetails(txtUsername.getText()).setVisible(true);
                    logFR.setVisible(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        logFR.setContentPane(new Login().panel1);
        logFR.pack();
        logFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logFR.setVisible(true);
    }

    private boolean validateUserPW()
    {
        String uName = txtUsername.getText();
        String PW = String.valueOf(txtPW.getPassword());
        DBConnect.dbConnect DB = new dbConnect();//Object from DB connect
        stml = DB.Conn2DB();//Connect to DB
        String sql = "Select * from userdetails where userName='"+uName+"'";
        try{
            ResultSet rs = stml.executeQuery(sql);
            rs.first();
            String dbPW = rs.getString("Password");
            if (PW.equals(dbPW))
                return true;
        }catch (SQLException se)
        {
            se.printStackTrace();
        }
        return false;
    }
}
