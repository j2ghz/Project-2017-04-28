package UI.Swing;


import Domain.Management.UserManager;

import javax.swing.*;

public class LoginUI extends JFrame {
    public LoginUI(UserManager userManager) {
        this.setSize(100, 80);
        JButton b = new JButton();
        this.add(b);
        b.addActionListener(e -> next());
    }

    private void next() {
        this.setVisible(false);
        MainFrame f = new MainFrame();
    }

}
