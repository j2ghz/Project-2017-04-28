package UI.Swing;

import Domain.Management.Administration;
import Domain.Reservation.ReservationManager;

import javax.swing.*;
import java.text.SimpleDateFormat;

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

    public static void main(ReservationManager rm, Administration adm) {
        JFrame frame = new JFrame("Arrangement Reservation");
        frame.setContentPane(new ArrangementReservationUI(rm,adm).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ArrangementReservationUI(ReservationManager rm, Administration adm) {
        btCreateReservation.addActionListener(Action -> createReservation(rm,adm));
    }

    private void createReservation(ReservationManager rm, Administration adm) {
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.setVisible(false);

        try {
            rm.createArrangementReservation(new SimpleDateFormat().parse(tfDate.getText()), Integer.parseInt(tfEventID.getText()), Double.parseDouble(tfPrice.getText()), Integer.parseInt(tfCustomer.getText()), tfEventName.getText(), tfDescription.getText(), adm.getCustomer(Integer.parseInt(tfCustomer.getText())), Integer.parseInt(tfEventSize.getText()), jOptionPane);
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered date was invalid, reservation was not created.");
        }
    }
}
