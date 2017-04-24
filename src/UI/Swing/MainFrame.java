package UI.Swing;

import Services.Database.DB;

import javax.swing.*;

public class MainFrame extends JFrame {
    private DB db;

    public MainFrame(DB db) {
        this.db = db;
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
    }
}
