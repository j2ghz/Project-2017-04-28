package UI.Swing;

import Domain.Model.Arrangement;
import Domain.Model.Customer;
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
        btCreateReservation.addActionListener(Action -> createReservation());
    }

    private void createReservation(DB db) {
        Date date = null;
        try {
            date = new SimpleDateFormat().parse(tfDate.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered date was invalid, reservation was not created.");
        }
        int arrangementID = Integer.parseInt(tfEventID.getText());
        int customerID = Integer.parseInt(tfCustomer.getText());
        Double price = Double.parseDouble(tfPrice.getText());
        String arrangementName = tfEventName.getText();
        String description = tfDescription.getText();
        int eventSize = Integer.parseInt(tfEventSize.getText());

        Customer customer = db.getCustomer(customerID);

        if (date != null && arrangementID != 0 && price != 0 && customerID != 0 && arrangementName != null && description != null && customer != null && eventSize != 0) {
            Arrangement arrangement = new Arrangement(date, arrangementID, price, customerID, arrangementName, description, customer, eventSize);
            db.addArrangement(arrangement);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information missing, reservation was not created");
        }
    }
}
