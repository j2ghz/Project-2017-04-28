package UI.Swing;

import Domain.Management.Administration;
import Domain.Management.UserManager;
import Domain.Reservation.ReservationManager;
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

    public static void main(ReservationManager rm, UserManager um, Administration adm) {
        JFrame frame = new JFrame("Main Menu");
        frame.setContentPane(new MainMenu(rm,um,adm).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainMenu(ReservationManager rm, UserManager um, Administration adm){
        btRoomReservation.addActionListener(Action -> new StandardReservationUI());
        btArrangementReservation.addActionListener(Action -> new ArrangementReservationUI());
        btCateringReservation.addActionListener(Action -> new CateringReservationUI());
        btCreateToDo.addActionListener(Action -> new ToDoUI());
        btUserAdmin.addActionListener(Action -> new UserAdminUI());
    }
}
