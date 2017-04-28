package Domain.Management;


import Domain.Model.*;
import Services.Database.DB;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Administration {
    private final DB db;

    public Administration(DB db) {
        this.db = db;
    }

    public ArrayList<Employee> getEmployees() {
        return db.getEmployees();
    }

    public Employee getEmployee(/*identifier*/int i) {
        throw new NotImplementedException();
    }

    public void createEmployee(Employee employee) {
        db.addEmployee(employee);
    }

    public void deleteEmployee(Employee emoloyee) {
        throw new NotImplementedException();
    }

    public void updateEmployee() {
        throw new NotImplementedException();
    }

    public ArrayList<Customer> getCustomers() {
        throw new NotImplementedException();
    }

    public Customer getCustomer(int id) {
        throw new NotImplementedException();
    }

    public void createCustomer(int id, String phoneNumber, String address, String email, Date dateOfBirth, String name, JOptionPane jOptionPane) {
        if (id != 0 && address != null && name != null && email != null && phoneNumber != null && dateOfBirth != null) {
            Customer customer = new Customer(id, phoneNumber, address, email, dateOfBirth, name);
            db.addCustomer(customer);
        } else {
            jOptionPane.setMessage("There was some information about the customer missing, reservation was not created.");
            jOptionPane.setVisible(true);
        }
    }

    public void deleteCustomer(Customer customer) {
        throw new NotImplementedException();
    }

    public void updateCustomer(Customer customer) {
        throw new NotImplementedException();
    }

    public ArrayList<Menu> getMenus() {
        throw new NotImplementedException();
    }

    public Menu getMenu(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void createMenu(Menu menu) {
        db.addMenu(menu);
    }

    public void deleteMenu(Menu menu) {
        throw new NotImplementedException();
    }

    public void updateMenu() {
        throw new NotImplementedException();
    }

    public ArrayList<Room> getRooms() {
        throw new NotImplementedException();
    }

    public Room getRoom(int number) {
        throw new NotImplementedException();
    }

    public void createRoom(double price, String name, int number, int bedCount, String description, JOptionPane jOptionPane) {
        if (price != 0 && name != null && number != 0 && bedCount != 0) {
            Room room = new Room(price, name, number, bedCount,description);
            db.addRoom(room);
        } else {
            jOptionPane.setMessage("There was some information about the room missing, reservation was not created.");
        }
    }

    public void deleteRoom(Room room) {
        throw new NotImplementedException();
    }

    public void updateRoom() {
        throw new NotImplementedException();
    }

    public ArrayList<RoomService> getRoomServices() {
        throw new NotImplementedException();
    }

    public RoomService getRoomService(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void createRoomService(RoomService rs) {
        db.addRoomService(rs);
    }

    public void deleteRoomService(RoomService roomService) {
        throw new NotImplementedException();
    }

    public void updateRoomService() {
        throw new NotImplementedException();
    }

    public ArrayList<ToDo> getToDos(Date date) {
        throw new NotImplementedException();
    }

    public void createUser(User user) {
        throw new NotImplementedException();
    }

    public User getUser(String username, String password) {throw new NotImplementedException();
    }

    public void deleteUser(User user) {throw new NotImplementedException();
    }
}
