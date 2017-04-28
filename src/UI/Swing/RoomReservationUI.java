package UI.Swing;

import Domain.Management.Administration;
import Domain.Model.Customer;
import Domain.Model.Room;
import Domain.Reservation.ReservationManager;

import javax.swing.*;
import java.text.SimpleDateFormat;

/**
 * Created by j200g on 28.04.2017.
 */
public class RoomReservationUI {
    private JPanel pnHolding;
    private JButton btCreateRes;
    private JTextField tfCustId;
    private JTextField tfRoomNo;
    private JTextField tfCheckIn;
    private JTextField tfCheckOut;
    private JLabel lbCustId;
    private JLabel lbRoomNo;
    private JLabel lbCheckIn;
    private JLabel lbCheckOut;
    private JTextField tfResId;
    private JLabel lbResId;

    private RoomReservationUI(ReservationManager rm, Administration adm) {
        btCreateRes.addActionListener(Action -> reserveRoom(rm, adm));
    }

    public static void main(ReservationManager rm, Administration adm) {

        JFrame frame = new JFrame("RoomReservationUI");
        frame.setContentPane(new RoomReservationUI(rm, adm).pnHolding);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void reserveRoom(ReservationManager rm, Administration adm) {
        Customer customer = adm.getCustomer(Integer.parseInt(tfCustId.getText()));

        Room room = adm.getRoom(Integer.parseInt(tfRoomNo.getText()));
        try {
            rm.reserveRoom(Integer.parseInt(tfResId.getText()), new SimpleDateFormat("yyyy-MM-dd").parse(tfCheckIn.getText()), new SimpleDateFormat("yyyy-MM-dd").parse(tfCheckOut.getText()), customer, room);
            JOptionPane.showConfirmDialog(pnHolding, "Success!");
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "One or both of the entered dates was invalid, customer was not created.");
        }
    }
}
