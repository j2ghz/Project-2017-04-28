package Domain.Management;


import Domain.Model.*;
import Services.Database.DB;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Administration {
    private final DB db;

    public Administration(DB db){
        this.db=db;
    }

    public ArrayList<Employee> getEmployees(){
        return db.getEmployees();
    }
    public Employee getEmployee(/*identifier*/){
        throw new NotImplementedException();
    }
    public void createEmployee(/*props*/String name, String email, String address, String acc, String phone, String pos){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setBankAccount(acc);
        employee.setPhoneNumber(phone);
        employee.setPosition(pos);

        db.addEmployee(employee);
    }
    public void deleteEmployee(Employee emoloyee){
        throw new NotImplementedException();
    }
    public void updateEmployee(){
        throw new NotImplementedException();
    }

    public ArrayList<Customer> getCustomers(){
        throw new NotImplementedException();
    }
    public Customer getCustomer(/*identifier*/){
        throw new NotImplementedException();
    }
    public void createCustomer(/*props*/){
        throw new NotImplementedException();
    }
    public void deleteCustomer(Customer customer){
        throw new NotImplementedException();
    }
    public void updateCustomer(){
        throw new NotImplementedException();
    }

    public ArrayList<Menu> getMenus(){
        throw new NotImplementedException();
    }
    public Menu getMenu(/*identifier*/){
        throw new NotImplementedException();
    }
    public void createMenu(/*props*/){
        throw new NotImplementedException();
    }
    public void deleteMenu(Menu menu){
        throw new NotImplementedException();
    }
    public void updateMenu(){
        throw new NotImplementedException();
    }

    public ArrayList<Room> getRooms(){
        throw new NotImplementedException();
    }
    public Room getRoom(/*identifier*/){
        throw new NotImplementedException();
    }
    public void createRoom(/*props*/){
        throw new NotImplementedException();
    }
    public void deleteRoom(Room room){
        throw new NotImplementedException();
    }
    public void updateRoom(){
        throw new NotImplementedException();
    }

    public ArrayList<RoomService> getRoomServices(){
        throw new NotImplementedException();
    }
    public RoomService getRoomService(/*identifier*/){
        throw new NotImplementedException();
    }
    public void createRoomService(/*props*/){
        throw new NotImplementedException();
    }
    public void deleteRoomService(RoomService roomService){
        throw new NotImplementedException();
    }
    public void updateRoomService(){
        throw new NotImplementedException();
    }
}
