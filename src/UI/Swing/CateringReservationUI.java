package UI.Swing;

import Domain.Model.Catering;
import Domain.Model.Customer;
import Domain.Reservation.ReservationManager;
import Services.Database.DB;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jakob on 24-Apr-17.
 */
public class CateringReservationUI {
    private JPanel pnHolding;
    private JTextField tfNoMeals;
    private JTextField tfTypeOfFood;
    private JTextField tfLocation;
    private JTextField tfDate;
    private JTextField tfCustomer;
    private JTextField tfPrice;
    private JLabel lbNoMeals;
    private JLabel lbTypeOfFood;
    private JLabel lbLocation;
    private JLabel lbDate;
    private JLabel lbCustomer;
    private JButton btCreateReservation;
    private JLabel lbPrice;
    private JTextField tfCateringID;
    private JLabel lbCateringID;

    public CateringReservationUI(DB db) {
        btCreateReservation.addActionListener(Action -> createReservation(db));
    }

    public static void main(DB db) {
        JFrame frame = new JFrame("Catering Reservation");
        frame.setContentPane(new CateringReservationUI(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createReservation(DB db) {
        ReservationManager rm = new ReservationManager(db);
        JOptionPane jOptionPane = new JOptionPane(pnHolding);
        jOptionPane.setVisible(false);

        try {
            rm.createCateringReservation(Integer.parseInt(tfNoMeals.getText()), tfTypeOfFood.getText(), tfLocation.getText(), new SimpleDateFormat().parse(tfDate.getText()), Integer.parseInt(tfCateringID.getText()), Double.parseDouble(tfPrice.getText()), db.getCustomer(Integer.parseInt(tfCustomer.getText())), jOptionPane);

        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered date was invalid, reservation was not created.");
        }
    }
}
