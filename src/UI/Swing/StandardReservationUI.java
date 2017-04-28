package UI.Swing;

import Domain.Management.Administration;
import Domain.Model.Customer;
import Domain.Model.Menu;
import Domain.Model.Room;
import Domain.Model.RoomService;
import Domain.Reservation.ReservationManager;

import javax.swing.*;
import java.text.SimpleDateFormat;

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
    private JTextField tfRoomDesc;
    private JLabel lbRoomDesc;
    private JLabel lbResId;
    private JTextField tfResId;

    public StandardReservationUI(ReservationManager rm, Administration adm) {
        btCreateReservation.addActionListener(Action -> createReservation(rm, adm));
    }

    public static void main(ReservationManager rm, Administration adm) {
        JFrame frame = new JFrame("Room Reservation");
        frame.setContentPane(new StandardReservationUI(rm, adm).pnHolding);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createReservation(ReservationManager rm, Administration adm) {
        JOptionPane jOptionPane = new JOptionPane(pnHolding);
        jOptionPane.setVisible(false);

        try {
            adm.createCustomer(Integer.parseInt(tfCustID.getText()), tfCustPhone.getText(), tfCustAddress.getText(), tfCustEmail.getText(), new SimpleDateFormat().parse(tfCustBirth.getText()), tfCustName.getText(), jOptionPane);
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered birthdate was invalid, customer was not created.");
        }

        adm.createRoom(Double.parseDouble(tfRoomPrice.getText()), tfRoomName.getText(), Integer.parseInt(tfRoomNumber.getText()), Integer.parseInt(tfSize.getText()), tfRoomDesc.getText(), jOptionPane);

        Customer customer = adm.getCustomer(Integer.parseInt(tfCustID.getText()));

        Room room = adm.getRoom(Integer.parseInt(tfRoomNumber.getText()));


        try {
            if (rbNoMenu.isSelected() && rbNoService.isSelected()) {
                rm.reserveRoom(Integer.parseInt(tfResId.getText()), new SimpleDateFormat().parse(tfCheckin.getText()), new SimpleDateFormat().parse(tfCheckout.getText()), customer, room);
            } else if (rbNoService.isSelected() && rbYesMenu.isSelected()) {
                Menu menu = new Menu(Double.parseDouble(tfMenuPrice.getText()), tfMenuName.getText());
                adm.createMenu(menu);
                rm.reserveRoom(Integer.parseInt(tfResId.getText()), new SimpleDateFormat().parse(tfCheckin.getText()), new SimpleDateFormat().parse(tfCheckout.getText()), customer, room, menu);
            } else if (rbYesService.isSelected() && rbNoMenu.isSelected()) {
                RoomService rs = new RoomService(Double.parseDouble(tfServicePrice.getText()), tfServiceName.getText());
                adm.createRoomService(rs);
                rm.reserveRoom(Integer.parseInt(tfResId.getText()), new SimpleDateFormat().parse(tfCheckin.getText()), new SimpleDateFormat().parse(tfCheckout.getText()), customer, room, rs);
            } else if (rbYesService.isSelected() && rbYesMenu.isSelected()) {
                Menu menu = new Menu(Double.parseDouble(tfMenuPrice.getText()), tfMenuName.getText());
                adm.createMenu(menu);
                RoomService rs = new RoomService(Double.parseDouble(tfServicePrice.getText()), tfServiceName.getText());
                adm.createRoomService(rs);
                rm.reserveRoom(Integer.parseInt(tfResId.getText()), new SimpleDateFormat().parse(tfCheckin.getText()), new SimpleDateFormat().parse(tfCheckout.getText()), customer, room, menu, rs);

            }
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "One of the entered dates was invalid, reservation was not created.");
        }

    }
}
