package UI.Swing;

import Domain.Management.Administration;
import Domain.Management.UserManager;
import Domain.Reservation.ReservationManager;

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

    public MainMenu(ReservationManager rm, UserManager um, Administration adm) {
        btRoomReservation.addActionListener(Action -> new StandardReservationUI(rm, adm));
        btArrangementReservation.addActionListener(Action -> new ArrangementReservationUI(rm, adm));
        btCateringReservation.addActionListener(Action -> new CateringReservationUI(rm, adm));
        btCreateToDo.addActionListener(Action -> new ToDoUI(adm));
        btUserAdmin.addActionListener(Action -> new UserAdminUI(adm));
    }

    public static void main(ReservationManager rm, UserManager um, Administration adm) {
        JFrame frame = new JFrame("Main Menu");
        frame.setContentPane(new MainMenu(rm, um, adm).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
