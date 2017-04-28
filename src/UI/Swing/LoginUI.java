package UI.Swing;

import Domain.Management.Administration;
import Domain.Management.UserManager;
import Domain.Reservation.ReservationManager;

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

    public LoginUI(ReservationManager rm, UserManager um, Administration adm) {
        btLogin.addActionListener(Action -> authenticate(rm, um, adm));
    }

    public static void main(ReservationManager rm, UserManager um, Administration adm) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new LoginUI(rm, um, adm).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void authenticate(ReservationManager rm, UserManager um, Administration adm) {
        if (um.login(tfUsername.getText(), tfPassword.getText())) {
            MainMenu menu = new MainMenu(rm, um, adm);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "Login failed, wrong username or password.");
        }
    }
}
