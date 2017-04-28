package UI.Swing;

import Domain.Management.Administration;
import Domain.Model.Employee;
import Domain.Model.User;

import javax.swing.*;

/**
 * Created by jakob on 24-Apr-17.
 */
public class UserAdminUI {
    private JTabbedPane tpTabs;
    private JPanel pnHolding;
    private JPanel pnCreate;
    private JPanel pnDelete;
    private JPanel pnEdit;
    private JButton btCreateUser;
    private JTextField tfUsernameCreate;
    private JTextField tfPasswordCreate;
    private JTextField tfGroupCreate;
    private JButton btDeleteUser;
    private JTextField tfUsernameDelete;
    private JButton btUpdateUser;
    private JTextField tfUsernameCurrent;
    private JTextField tfUsernameNew;
    private JTextField tfPasswordNew;
    private JTextField tfGroupNew;
    private JLabel lbUsernameCreate;
    private JLabel lbPasswordCreate;
    private JLabel lbGroupCreate;
    private JLabel lbUsernameDelete;
    private JLabel lbUsernameCurrent;
    private JLabel lbUsernameNew;
    private JLabel lbPasswordNew;
    private JLabel lbGroupNew;
    private JLabel lbHelp;
    private JTextField tfPasswordDelete;
    private JLabel lbPasswordDelete;
    private JTextField tfPasswordCurrent;
    private JLabel lbPasswordCurrent;
    private JTextField tfPosition;
    private JTextField tfId;
    private JTextField tfPhone;
    private JTextField tfAddress;
    private JTextField tfEmail;
    private JTextField tfBank;
    private JLabel lbPosition;
    private JLabel lbId;
    private JLabel lbPhone;
    private JLabel lbAddress;
    private JLabel lbEmail;
    private JLabel lbBank;
    private JTextField tfName;
    private JLabel lbName;
    private JPanel pnCreateEmp;
    private JTextField tfCreateUserEmpId;
    private JLabel lbCreateUserEmpId;
    private JButton btCreateEmp;

    public UserAdminUI(Administration adm) {
        btCreateUser.addActionListener(Action -> createUser(adm));
        btDeleteUser.addActionListener(Action -> deleteUser(adm));
        btUpdateUser.addActionListener(Action -> editUser(adm));
        btCreateEmp.addActionListener(Action -> createEmp(adm));
    }

    public static void main(Administration adm) {
        JFrame frame = new JFrame("User Administration");
        frame.setContentPane(new UserAdminUI(adm).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUser(Administration adm) {
        String username = tfUsernameCreate.getText();
        String password = tfPasswordCreate.getText();
        String group = tfGroupCreate.getText();

        Employee employee = adm.getEmployee(Integer.parseInt(tfCreateUserEmpId.getText()));

        if (username != null && password != null && group != null && employee != null) {
            User user = new User(username, password, group, employee);
            adm.createUser(user);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information missing, user not created.");
        }
    }

    private void deleteUser(Administration adm) {
        String username = tfUsernameDelete.getText();
        String password = tfPasswordDelete.getText();

        if (username != null && password != null) {
            adm.deleteUser(adm.getUser(username, password));
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information missing, user not deleted.");
        }
    }

    private void editUser(Administration adm) {
        String username = tfUsernameCurrent.getText();
        String password = tfPasswordCurrent.getText();

        User user = null;

        if (username != null && password != null) {
            user = adm.getUser(username, password);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some current user information missing, user not found.");
        }

        String confirmation = null;
        if (tfUsernameNew.getText() != null) {
            user.setLogin(tfUsernameNew.getText());
            confirmation += "Username edited. ";
        }
        if (tfPasswordNew.getText() != null) {
            user.setPassword(tfPasswordNew.getText());
            confirmation += "Password edited. ";
        }
        if (tfGroupNew.getText() != null) {
            user.setGroup(tfGroupNew.getText());
            confirmation += "Group edited.";
        }

        JOptionPane.showConfirmDialog(pnHolding, confirmation);
    }

    private void createEmp(Administration adm) {

        String empName = tfName.getText();
        String position = tfPosition.getText();
        int id = Integer.parseInt(tfId.getText());
        String phone = tfPhone.getText();
        String address = tfAddress.getText();
        String email = tfEmail.getText();
        String bank = tfBank.getText();

        Employee employee = null;

        if (empName != null && position != null && id != 0 && phone != null && address != null && email != null && bank != null) {
            employee = new Employee(empName, position, id, phone, address, email, bank);
            adm.createEmployee(employee);
        }
    }
}
