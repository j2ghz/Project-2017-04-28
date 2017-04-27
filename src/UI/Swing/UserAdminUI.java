package UI.Swing;

import Domain.Model.Employee;
import Domain.Model.User;
import Services.Database.DB;
import com.sun.xml.internal.bind.v2.TODO;

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

    public static void main(DB db) {
        JFrame frame = new JFrame("User Administration");
        frame.setContentPane(new UserAdminUI(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public UserAdminUI(DB db) {
        btCreateUser.addActionListener(Action -> createUser(db));
        btDeleteUser.addActionListener(Action -> deleteUser(db));
        btUpdateUser.addActionListener(Action -> editUser(db));
        btCreateEmp.addActionListener(Action -> createEmp(db));
    }

    private void createUser(DB db) {
        String username = tfUsernameCreate.getText();
        String password = tfPasswordCreate.getText();
        String group = tfGroupCreate.getText();

        Employee employee = db.getEmployee(Integer.parseInt(tfCreateUserEmpId.getText()));

        if (username != null && password != null && group != null && employee != null) {
            User user = new User(username, password, group, employee);
            db.addUser(user);
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information missing, user not created.");
        }
    }

    private void deleteUser(DB db) {
        String username = tfUsernameDelete.getText();
        String password = tfPasswordDelete.getText();

        if (username != null && password != null) {
            db.deleteUser(db.getUser(username, password));
        } else {
            JOptionPane.showConfirmDialog(pnHolding, "There was some information missing, user not deleted.");
        }
    }

    private void editUser(DB db) {
        String username = tfUsernameCurrent.getText();
        String password = tfPasswordCurrent.getText();

        User user = null;

        if (username != null && password != null) {
            user = db.getUser(username, password);
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

    private void createEmp(DB db){

        String empName = tfName.getText();
        String position = tfPosition.getText();
        int id = Integer.parseInt(tfId.getText());
        String phone = tfPhone.getText();
        String address = tfAddress.getText();
        String email = tfEmail.getText();
        String bank = tfBank.getText();

        Employee employee = null;

        if(empName != null && position != null && id != 0 && phone != null && address != null && email != null && bank != null){
            employee = new Employee(empName,position,id,phone,address,email,bank);
            db.addEmployee(employee);
        }
    }
}
