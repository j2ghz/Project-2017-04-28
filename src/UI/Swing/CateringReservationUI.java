package UI.Swing;

import Domain.Management.Administration;
import Domain.Reservation.ReservationManager;

import javax.swing.*;
import java.text.SimpleDateFormat;

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

    private CateringReservationUI(ReservationManager rm, Administration adm) {
        btCreateReservation.addActionListener(Action -> createReservation(rm, adm));
    }

    public static void main(ReservationManager rm, Administration adm) {
        JFrame frame = new JFrame("Catering Reservation");
        frame.setContentPane(new CateringReservationUI(rm, adm).pnHolding);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createReservation(ReservationManager rm, Administration adm) {
        JOptionPane jOptionPane = new JOptionPane(pnHolding);
        jOptionPane.setVisible(false);

        try {
            rm.createCateringReservation(Integer.parseInt(tfNoMeals.getText()), tfTypeOfFood.getText(), tfLocation.getText(), new SimpleDateFormat("yyyy-MM-dd").parse(tfDate.getText()), Integer.parseInt(tfCateringID.getText()), Double.parseDouble(tfPrice.getText()), adm.getCustomer(Integer.parseInt(tfCustomer.getText())), jOptionPane);
            JOptionPane.showConfirmDialog(pnHolding, "Reservation was created.");
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered date was invalid, reservation was not created.");
        }
    }
}
