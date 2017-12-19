import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import DBConnect.*;

public class StoreDetails extends JFrame{
    private JPanel panel1;
    private JTextField txtUsername;
    private JTextField txtEmail;
    private JPasswordField txtPW;
    private JTextField txtUID;
    private JButton btnExit;
    private JButton btnInsert;

    public StoreDetails() {
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertDB();
            }
        });
    }
    public void insertDB()
    {
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String pw = String.valueOf(txtPW.getPassword());
        String uID = txtUID.getText();
        System.out.println("Values "+username+" "+email+" "+pw+" "+uID);
        String query = "Insert into userdetails values ("+uID+",'"+username+"','"+email+"','"+pw+"',5)";
        System.out.println(query);

        dbConnect DB = new dbConnect();
        Statement stmt = null;
        try{
            stmt = DB.Conn2DB();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Stored Successfully");
        }catch (SQLException se)
        {
            se.printStackTrace();
        }

    }
}
