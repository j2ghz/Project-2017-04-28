package UI.Swing;

import Domain.Model.Catering;
import Domain.Model.Customer;
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
        JFrame frame = new JFrame("CateringReservationUI");
        frame.setContentPane(new CateringReservationUI(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createReservation(DB db) {
        int noMeals = Integer.parseInt(tfNoMeals.getText());
        String typeOfFood = tfTypeOfFood.getText();
        String location = tfLocation.getText();
        Date date = null;
        try {
            date = new SimpleDateFormat().parse(tfDate.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered date was invalid, reservation was not created.");
        }
        int customerID = Integer.parseInt(tfCustomer.getText());
        Double price = Double.parseDouble(tfPrice.getText());
        int cateringID = Integer.parseInt(tfCateringID.getText());

        Customer customer = db.getCustomer(customerID);

        if (date != null && noMeals != 0 && typeOfFood != null && location != null && customerID != 0 && price != 0 && cateringID != 0) {
            Catering catering = new Catering(noMeals, typeOfFood, location, date, cateringID, price, customer);
            db.addCatering(catering);
        }else{
            JOptionPane.showConfirmDialog(pnHolding, "There was some information missing, reservation was not created");
        }
    }
}
