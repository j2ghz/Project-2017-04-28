package Domain.Management;


import Domain.Model.*;
import Services.Database.DB;
import jdk.nashorn.internal.scripts.JO;
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

    public Employee getEmployee(/*identifier*/) {
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

    public void updateCustomer() {
        throw new NotImplementedException();
    }

    public ArrayList<Menu> getMenus() {
        throw new NotImplementedException();
    }

    public Menu getMenu(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void createMenu(/*props*/) {
        throw new NotImplementedException();
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

    public void createRoom(double price, String name, int number, int bedCount, JOptionPane jOptionPane) {
        if (price != 0 && name != null && number != 0 && bedCount != 0) {
            Room room = new Room(price, name, number, bedCount);
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

    public void createRoomService(/*props*/) {
        throw new NotImplementedException();
    }

    public void deleteRoomService(RoomService roomService) {
        throw new NotImplementedException();
    }

    public void updateRoomService() {
        throw new NotImplementedException();
    }
}
