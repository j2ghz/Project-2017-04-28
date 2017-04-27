package UI.Swing;

import Services.Database.DB;

import javax.swing.*;

/**
 * Created by jakob on 27-Apr-17.
 */
public class DeleteRoomRes {
    private JButton btDeleteRoomRes;
    private JPanel pnHolding;
    private JTextField tfResId;
    private JLabel lbResId;

    public DeleteRoomRes(DB db) {
        btDeleteRoomRes.addActionListener(Action -> deleteRoomRes(db));
    }

    public static void main(DB db) {

        JFrame frame = new JFrame("Delete Room Reservation");
        frame.setContentPane(new DeleteRoomRes(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void deleteRoomRes(DB db){
        int resId = Integer.parseInt(tfResId.getText());

        if(resId != 0){
            db.deleteRoomReservation(db.getRoomReservation(resId));
        }
    }
}
