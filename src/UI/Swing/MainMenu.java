package UI.Swing;

import Services.Database.DB;

import javax.swing.*;

/**
 * Created by jakob on 24-Apr-17.
 */
public class MainMenu {
    private JPanel pnHolding;
    private JButton btRoomReservation;
    private JButton btUserAdmin;
    private JButton btCateringReservation;
    private JButton btArrangementReservation;
    private JButton btCreateToDo;
    private JButton btDeletRoomRes;
    private JButton btUpdRoomRes;

    public static void main(DB db) {
        JFrame frame = new JFrame("Main Menu");
        frame.setContentPane(new MainMenu(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainMenu(DB db){
        btRoomReservation.addActionListener(Action -> new StandardReservationUI(db));
        btArrangementReservation.addActionListener(Action -> new ArrangementReservationUI(db));
        btCateringReservation.addActionListener(Action -> new CateringReservationUI(db));
        btCreateToDo.addActionListener(Action -> new ToDoUI(db));
        btUserAdmin.addActionListener(Action -> new UserAdminUI(db));
    }
}
