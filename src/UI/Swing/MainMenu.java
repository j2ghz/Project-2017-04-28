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

    private MainMenu(ReservationManager rm, Administration adm) {
        btRoomReservation.addActionListener(Action -> StandardReservationUI.main(rm, adm));
        btUpdRoomRes.addActionListener(Action -> UpdateRoomRes.main(rm,adm));
        btDeletRoomRes.addActionListener(Action -> DeleteRoomRes.main(rm));
        btArrangementReservation.addActionListener(Action ->  ArrangementReservationUI.main(rm, adm));
        btCateringReservation.addActionListener(Action ->  CateringReservationUI.main(rm, adm));
        btCreateToDo.addActionListener(Action ->  ToDoUI.main(adm));
        btUserAdmin.addActionListener(Action ->  UserAdminUI.main(adm));
    }

    public static void main(ReservationManager rm, Administration adm) {
        JFrame frame = new JFrame("Main Menu");
        frame.setContentPane(new MainMenu(rm, adm).pnHolding);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
