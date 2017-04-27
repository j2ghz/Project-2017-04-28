package UI.Swing;

import Domain.Model.Arrangement;
import Domain.Model.Customer;
import Domain.Reservation.ReservationManager;
import Services.Database.DB;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jakob on 24-Apr-17.
 */
public class ArrangementReservationUI {
    private JPanel pnHolding;
    private JTextField tfEventName;
    private JTextField tfDescription;
    private JTextField tfDate;
    private JTextField tfEventSize;
    private JTextField tfCustomer;
    private JTextField tfPrice;
    private JLabel lbEventName;
    private JLabel lbDescription;
    private JLabel lbDate;
    private JLabel lbEventSize;
    private JLabel lbCustomer;
    private JLabel lbPrice;
    private JButton btCreateReservation;
    private JTextField tfEventID;
    private JLabel lbEventID;

    public static void main(DB db) {
        JFrame frame = new JFrame("Arrangement Reservation");
        frame.setContentPane(new ArrangementReservationUI(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ArrangementReservationUI(DB db) {
        btCreateReservation.addActionListener(Action -> createReservation(db));
    }

    private void createReservation(DB db) {
        ReservationManager rm = new ReservationManager(db);
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.setVisible(false);

        try {
            rm.createArrangementReservation(new SimpleDateFormat().parse(tfDate.getText()), Integer.parseInt(tfEventID.getText()), Double.parseDouble(tfPrice.getText()), Integer.parseInt(tfCustomer.getText()), tfEventName.getText(), tfDescription.getText(), db.getCustomer(Integer.parseInt(tfCustomer.getText())), Integer.parseInt(tfEventSize.getText()), jOptionPane);
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered date was invalid, reservation was not created.");
        }
    }
}
