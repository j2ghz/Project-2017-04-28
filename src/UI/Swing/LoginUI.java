package UI.Swing;


import Domain.Management.UserManager;
import Services.Database.DB;

import javax.swing.*;

public class LoginUI extends JFrame {
    private DB db;

    public LoginUI(UserManager userManager, DB db) {
        this.db = db;
        this.setSize(100, 80);
        JButton b = new JButton();
        this.add(b);
        b.addActionListener(e -> next());
    }

    private void next() {
        this.setVisible(false);
        MainFrame f = new MainFrame(db);
    }

}
