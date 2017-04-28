package UI.Swing;

import Domain.Model.*;
import Services.Database.DB;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jakob on 27-Apr-17.
 */
public class UpdateRoomRes {
    private JPanel pnHolding;
    private JTabbedPane tabbedPane;
    private JPanel pnReservationInfo;
    private JTextField tfCustName;
    private JTextField tfCustAddress;
    private JLabel lbCustName;
    private JLabel lbCustAddress;
    private JLabel lbCustPhone;
    private JLabel lbCustEmail;
    private JLabel lbCustBirth;
    private JTextField tfCustEmail;
    private JTextField tfCustPhone;
    private JTextField tfCustBirth;
    private JLabel lbCustID;
    private JTextField tfCustID;
    private JPanel pnRoom;
    private JLabel lbCheckin;
    private JLabel lbCheckout;
    private JTextField tfCheckin;
    private JTextField tfCheckout;
    private JLabel lbSize;
    private JTextField tfSize;
    private JLabel lbRoomPrice;
    private JTextField tfRoomPrice;
    private JLabel lbRoomName;
    private JTextField tfRoomName;
    private JLabel lbRoomNumber;
    private JTextField tfRoomNumber;
    private JButton btUpdateRes;


    public static void main(DB db) {
        JFrame frame = new JFrame("Update Room Reservation");
        frame.setContentPane(new UpdateRoomRes(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public UpdateRoomRes(DB db) {
        btUpdateRes.addActionListener(Action -> updateReservation(db));
    }

    private void updateReservation(DB db) {
        String custAddress = tfCustAddress.getText();
        String custName = lbCustName.getText();
        String custEmail = tfCustEmail.getText();
        String custPhone = tfCustPhone.getText();
        Date custBirth = null;
        try {
            custBirth = new SimpleDateFormat().parse(tfCustBirth.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered birthdate was invalid, customer was not updated.");
        }
        int custID = Integer.parseInt(tfCustID.getText());


        if (custAddress != null && custName != null && custEmail != null && custPhone != null && custBirth != null) {
            Customer customer = new Customer(custID, custPhone, custAddress, custEmail, custBirth, custName);
            db.updateCustomer(customer);
            updateRoom(db, customer);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information about the customer missing, reservation was not updated.");
        }

    }

    private void updateRoom(DB db, Customer customer) {
        double price = Double.parseDouble(tfRoomPrice.getText());
        String name = tfRoomName.getText();
        int roomNumber = Integer.parseInt(tfRoomNumber.getText());
        int roomSize = Integer.parseInt(tfSize.getText());

        if (price != 0 && name != null && roomNumber != 0 && roomSize != 0) {
            Room room = new Room(price, name, roomNumber, roomSize);
            updateRoomReservation(db, room, customer);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information about the room missing, reservation was not updated.");
        }

    }

    private void updateRoomReservation(DB db, Room room, Customer customer) {
        Date checkIn = null;
        try {
            checkIn = new SimpleDateFormat().parse(tfCheckin.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered check in was invalid, reservation was not updated.");
        }
        Date checkOut = null;
        try {
            checkOut = new SimpleDateFormat().parse(tfCheckout.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered check out was invalid, reservation was not updated.");
        }


        if (checkIn != null && checkOut != null && customer != null && room != null) {
            RoomReservation roomRes = new RoomReservation(checkIn, checkOut, customer, room);

            db.updateRoomReservation(roomRes);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "The entered information was not valid, reservation not updated.");
        }

    }
}