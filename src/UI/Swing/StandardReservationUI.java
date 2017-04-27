package UI.Swing;

import Domain.Model.*;
import Services.Database.DB;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jakob on 24-Apr-17.
 */
public class StandardReservationUI {
    private JTabbedPane tabbedPane;
    private JPanel pnHolding;
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
    private JPanel pnReservationInfo;
    private JPanel pnRoom;
    private JPanel pnMenu;
    private JPanel pnRoomService;
    private JTextField tfCheckin;
    private JTextField tfCheckout;
    private JRadioButton rbYesMenu;
    private JRadioButton rbNoMenu;
    private JRadioButton rbYesService;
    private JRadioButton rbNoService;
    private JTextField tfSize;
    private JLabel lbCheckin;
    private JLabel lbCheckout;
    private JLabel lbSize;
    private JButton btCreateReservation;
    private JTextField tfMenuName;
    private JTextField tfMenuPrice;
    private JLabel lbMenuName;
    private JLabel lbMenuPrice;
    private JTextField tfRoomPrice;
    private JLabel lbRoomPrice;
    private JTextField tfServiceName;
    private JTextField tfServicePrice;
    private JTextField tfCustID;
    private JLabel lbCustID;
    private JTextField tfRoomName;
    private JLabel lbRoomName;
    private JTextField tfRoomNumber;
    private JLabel lbRoomNumber;
    private JLabel lbServiceName;
    private JLabel lbServicePrice;

    public static void main(DB db) {
        JFrame frame = new JFrame("Room Reservation");
        frame.setContentPane(new StandardReservationUI(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public StandardReservationUI(DB db) {
        btCreateReservation.addActionListener(Action -> createReservation(db));
    }

    private void createReservation(DB db) {
        String custAddress = tfCustAddress.getText();
        String custName = lbCustName.getText();
        String custEmail = tfCustEmail.getText();
        String custPhone = tfCustPhone.getText();
        Date custBirth = null;
        try {
            custBirth = new SimpleDateFormat().parse(tfCustBirth.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered birthdate was invalid, customer was not created.");
        }
        int custID = Integer.parseInt(tfCustID.getText());


        if (custAddress != null && custName != null && custEmail != null && custPhone != null && custBirth != null) {
            Customer customer = new Customer(custID, custPhone, custAddress, custEmail, custBirth, custName);
            db.addCustomer(customer);
            createRoom(db, customer);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information about the customer missing, reservation was not created.");
        }

    }

    private void createRoom(DB db, Customer customer) {
        double price = Double.parseDouble(tfRoomPrice.getText());
        String name = tfRoomName.getText();
        int roomNumber = Integer.parseInt(tfRoomNumber.getText());
        int roomSize = Integer.parseInt(tfSize.getText());

        if (price != 0 && name != null && roomNumber != 0 && roomSize != 0) {
            Room room = new Room(price, name, roomNumber, roomSize);
            createRoomReservation(db, room, customer);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information about the room missing, reservation was not created.");
        }

    }

    private void createRoomReservation(DB db, Room room, Customer customer) {
        Date checkIn = null;
        try {
            checkIn = new SimpleDateFormat().parse(tfCheckin.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered check in was invalid, reservation was not created.");
        }
        Date checkOut = null;
        try {
            checkOut = new SimpleDateFormat().parse(tfCheckout.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered check out was invalid, reservation was not created.");
        }


        if (checkIn != null && checkOut != null && customer != null && room != null) {
            RoomReservation roomRes = new RoomReservation(checkIn, checkOut, customer, room);

            if (rbYesMenu.isSelected()) {
                double menuPrice = Double.parseDouble(tfMenuPrice.getText());
                String menuName = tfMenuName.getText();

                if (menuPrice != 0 && menuName != null) {
                    Menu menu = new Menu(menuPrice, menuName);
                    roomRes.addMenu(menu);
                } else {
                    JOptionPane.showConfirmDialog(pnHolding, "The entered menu options were not valid, menu not added to reservation.");
                }

            }

            if (rbYesService.isSelected()) {
                double servicePrice = Double.parseDouble(tfServicePrice.getText());
                String serviceName = tfServiceName.getText();

                if (servicePrice != 0 && serviceName != null) {
                    RoomService rs = new RoomService(servicePrice, serviceName);
                    roomRes.addRoomService(rs);
                } else {
                    JOptionPane.showConfirmDialog(pnHolding, "The entered room service options were not valid, room service not added to reservation.");
                }
            }

            db.addRoomReservation(roomRes);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "The entered information was not valid, reservation not created.");
        }

    }
}
