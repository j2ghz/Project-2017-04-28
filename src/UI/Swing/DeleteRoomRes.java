package UI.Swing;

import Domain.Reservation.ReservationManager;

import javax.swing.*;

/**
 * Created by jakob on 27-Apr-17.
 */
public class DeleteRoomRes {
    private JButton btDeleteRoomRes;
    private JPanel pnHolding;
    private JTextField tfResId;
    private JLabel lbResId;

    private DeleteRoomRes(ReservationManager rm) {
        btDeleteRoomRes.addActionListener(Action -> deleteRoomRes(rm));
    }

    public static void main(ReservationManager rm) {

        JFrame frame = new JFrame("Delete Room Reservation");
        frame.setContentPane(new DeleteRoomRes(rm).pnHolding);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void deleteRoomRes(ReservationManager rm) {
        rm.deleteRoomReservation(Integer.parseInt(tfResId.getText()));
    }
}
