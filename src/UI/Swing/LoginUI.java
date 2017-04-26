package UI.Swing;

import Domain.Management.UserManager;
import Services.Database.DB;

import javax.swing.*;

/**
 * Created by jakob on 24-Apr-17.
 */
public class LoginUI extends JFrame {
    private JPanel pnHolding;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JButton btLogin;
    private JLabel lbUsername;
    private JLabel lbPassword;

    public static void main(UserManager um, DB db) {
        JFrame frame = new JFrame("LoginUI");
        frame.setContentPane(new LoginUI(um, db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public LoginUI(UserManager um, DB db) {
        btLogin.addActionListener(Action -> authenticate(um, db));
    }

    public void authenticate(UserManager um, DB db) {
        if (um.login(tfUsername.getText(), tfPassword.getText())) {
            MainMenu menu = new MainMenu(db);
        }else{
            JOptionPane.showConfirmDialog(pnHolding,"Login failed, wrong username or password.");
        }
    }
}
