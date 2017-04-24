package UI.Swing;

import Domain.Management.UserManager;
import Services.Database.DB;

import javax.swing.*;

/**
 * Created by jakob on 24-Apr-17.
 */
public class LoginUI extends JFrame{
    private JPanel pnHolding;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JButton btLogin;
    private JLabel lbUsername;
    private JLabel lbPassword;

    public LoginUI(UserManager um, DB db){

        btLogin.addActionListener(Action -> um.login(tfUsername.getText(),tfPassword.getText()));

        
    }
}
