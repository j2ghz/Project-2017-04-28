package Services.Database;

import Domain.Model.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB {
    private Connection con;

    public DB(String user, String pass, String port, String ip) throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection("jdbc:sqlserver://" + ip + ":" + port + ";databaseName=DB_Project", user, pass);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new Exception("Could not connect to database", e);
        }

    }

    public ArrayList<Arrangement> getArrangements() {
        throw new NotImplementedException();
    }

    public Arrangement getArrangement(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addArrangement(Arrangement arrangement) {
        throw new NotImplementedException();
    }

    public void deleteArrangement(Arrangement arrangement) {
        throw new NotImplementedException();
    }

    public void updateArrangement(Arrangement arrangement) {
        throw new NotImplementedException();
    }

    public ArrayList<Catering> getCaterings() {
        throw new NotImplementedException();
    }

    public Catering getCatering(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addCatering(Catering catering) {
        throw new NotImplementedException();
    }

    public void deleteCatering(Catering catering) {
        throw new NotImplementedException();
    }

    public void updateCatering(Catering catering) {
        throw new NotImplementedException();
    }

    public ArrayList<Customer> getCustomers() {
        throw new NotImplementedException();
    }

    public Customer getCustomer(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addCustomer(Customer customer) {
        throw new NotImplementedException();
    }

    public void deleteCustomer(Customer customer) {
        throw new NotImplementedException();
    }

    public void updateCustomer(Customer customer) {
        throw new NotImplementedException();
    }

    public ArrayList<Employee> getEmployees() {
        throw new NotImplementedException();
    }

    public Employee getEmployee(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addEmployee(Employee employee) {
        throw new NotImplementedException();
    }

    public void deleteEmployee(Employee employee) {
        throw new NotImplementedException();
    }

    public void updateEmployee(Employee employee) {
        throw new NotImplementedException();
    }

    public ArrayList<Menu> getMenus() {
        throw new NotImplementedException();
    }

    public Menu getMenu(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addMenu(Menu menu) {
        throw new NotImplementedException();
    }

    public void deleteMenu(Menu menu) {
        throw new NotImplementedException();
    }

    public void updateMenu(Menu menu) {
        throw new NotImplementedException();
    }

    public ArrayList<Room> getRooms() {
        throw new NotImplementedException();
    }

    public Room getRoom(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addRoom(Room room) {
        throw new NotImplementedException();
    }

    public void deleteRoom(Room room) {
        throw new NotImplementedException();
    }

    public void updateRoom(Room room) {
        throw new NotImplementedException();
    }

    public ArrayList<RoomReservation> getRoomReservations() {
        throw new NotImplementedException();
    }

    public RoomReservation getRoomReservation(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addRoomReservation(RoomReservation roomReservation) {
        throw new NotImplementedException();
    }

    public void deleteRoomReservation(RoomReservation roomReservation) {
        throw new NotImplementedException();
    }

    public void updateRoomReservation(RoomReservation roomReservation) {
        throw new NotImplementedException();
    }

    public ArrayList<RoomService> getRoomServices() {
        throw new NotImplementedException();
    }

    public RoomService getRoomService(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addRoomService(RoomService roomService) {
        throw new NotImplementedException();
    }

    public void deleteRoomService(RoomService roomService) {
        throw new NotImplementedException();
    }

    public void updateRoomService(RoomService roomService) {
        throw new NotImplementedException();
    }

    public ArrayList<ToDo> getToDos() {
        throw new NotImplementedException();
    }

    public ToDo getToDo(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addToDo(ToDo toDo) {
        throw new NotImplementedException();
    }

    public void deleteToDo(ToDo toDo) {
        throw new NotImplementedException();
    }

    public void updateToDo(ToDo toDo) {
        throw new NotImplementedException();
    }

    public ArrayList<User> getUsers() {
        throw new NotImplementedException();
    }

    public User getUser(String user, String pass) {
        throw new NotImplementedException();
    }

    public void addUser(User user) {
        throw new NotImplementedException();
    }

    public void deleteUser(User user) {
        throw new NotImplementedException();
    }

    public void updateUser(User user) {
        throw new NotImplementedException();
    }


}

