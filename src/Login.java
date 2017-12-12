import javax.swing.*;

public class Login {
    private JPanel panel1;
    private JTextField txtUsername;
    private JPasswordField txtPW;
    private JButton exitButton;
    private JButton loginButton;
    public static JFrame logFR = new JFrame("Login for FIS");

    public static void main(String[] args) {
        logFR.setContentPane(new Login().panel1);
        logFR.pack();
        logFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logFR.setVisible(true);
    }
}
