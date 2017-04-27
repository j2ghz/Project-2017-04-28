package Services.Database;
import Domain.Model.*;
import sun.reflect.FieldAccessor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DB {
    private static PreparedStatement ps = null;
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

    public Arrangement getArrangement() {
        throw new NotImplementedException();
    }

    public void addArrangement(int fld_ArrID, String fld_ArrName, String fld_ArrDescription, String fld_ArrDate, int fld_ArrPrice, int fld_ArrPartNo, int fld_CustID) throws SQLException{

        ps = con.prepareStatement("insert into tbl_Arrangement values (?, ?, ?, ?, ?, ?, ?)");

        ps.setInt(1,fld_ArrID);
        ps.setString(2,fld_ArrName);
        ps.setString(3,fld_ArrDescription);
        ps.setString(4,fld_ArrDate);
        ps.setInt(5,fld_ArrPrice);
        ps.setInt(6,fld_ArrPartNo);
        ps.setInt(7,fld_CustID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteArrangement(int fld_ArrID) throws SQLException{

        ps = con.prepareStatement("DELETE FROM tbl_Arrangement WHERE fld_ArrID = ?");
        ps.setInt(1,fld_ArrID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateArrangement(int fld_ArrID, String fld_ArrName, String fld_ArrDescription, String fld_ArrDate, int fld_ArrPrice, int fld_ArrPartNo, int fld_CustID) throws SQLException{

        ps = con.prepareStatement("UPDATE tbl_Arrangement SET fld_ArrName = ? ,SET fld_ArrDescription = ?,SET fld_ArrDate = ?,SET fld_ArrPrice = ?,SET fld_ArrPartNo = ?,SET fld_CustID = ? WHERE fld_ArrID = ?");
        ps.setString(1,fld_ArrName);
        ps.setString(2,fld_ArrDescription);
        ps.setString(3,fld_ArrDate);
        ps.setInt(4,fld_ArrPrice);
        ps.setInt(5,fld_ArrPartNo);
        ps.setInt(6, fld_CustID);
        ps.setInt(7,fld_ArrID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public ArrayList<Catering> getCaterings() {
        throw new NotImplementedException();
    }

    public Catering getCatering() {
        throw new NotImplementedException();
    }

    public void addCatering(int fld_CatOrderID, int fld_CatNoOfMeals, String fld_CatTypeOfFood, String fld_CatLocation, String fld_CatDate, int fld_CatPrice, int fld_CustID) throws SQLException{

        ps = con.prepareStatement("INSERT INTO tbl_Catering VALUES (?,?,?,?,?,?,?)");

        ps.setInt(1,fld_CatOrderID);
        ps.setInt(2,fld_CatNoOfMeals);
        ps.setString(3,fld_CatTypeOfFood);
        ps.setString(4,fld_CatLocation);
        ps.setString(5,fld_CatDate);
        ps.setInt(6,fld_CatPrice);
        ps.setInt(7,fld_CustID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteCatering(int fld_CatOrderID) throws SQLException {

        ps = con.prepareStatement("DELETE FROM tbl_Catering WHERE fld_CatOrderID = ?");
        ps.setInt(1,fld_CatOrderID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateCatering(int fld_CatOrderID, int fld_CatNoOfMeals, String fld_CatTypeOfFood, String fld_CatLocation, String fld_CatDate, int fld_CatPrice, int fld_CustID) throws SQLException{

        ps = con.prepareStatement("UPDATE tbl_Catering SET fld_CatNoOfMeals = ? ,SET CatTypeOfFood = ?,SET fld_CatLocation = ?,SET fld_CatDate = ?,SET fld_CatPrice = ?,SET fld_CustID = ? WHERE fld_CatOrderID = ?");

        ps.setInt(1,fld_CatNoOfMeals);
        ps.setString(2,fld_CatTypeOfFood);
        ps.setString(3,fld_CatLocation);
        ps.setString(4,fld_CatDate);
        ps.setInt(5,fld_CatPrice);
        ps.setInt(6, fld_CustID);
        ps.setInt(7,fld_CatOrderID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public ArrayList<Customer> getCustomers() {
        throw new NotImplementedException();
    }

    public Customer getCustomer(int id) {
        throw new NotImplementedException();
    }

    public void addCustomer(int fld_CustID, String fld_CustName, String fld_CustPhone, String fld_CustAddress, String fld_CustDateOfBirth, String fld_CustEmail) throws SQLException {

        ps = con.prepareStatement("INSERT INTO tbl_Customer VALUES (?,?,?,?,?,?)");

        ps.setInt(1,fld_CustID);
        ps.setString(2,fld_CustName);
        ps.setString(3,fld_CustPhone);
        ps.setString(4,fld_CustAddress);
        ps.setString(5,fld_CustDateOfBirth);
        ps.setString(6,fld_CustEmail);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteCustomer(int fld_CustID) throws SQLException {

        ps = con.prepareStatement("DELETE FROM tbl_Customer WHERE fld_CustID = ?");
        ps.setInt(1,fld_CustID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateCustomer(int fld_CustID, String fld_CustName, String fld_CustPhone, String fld_CustAddress, String fld_CustDateOfBirth, String fld_CustEmail) throws SQLException{

        ps = con.prepareStatement("UPDATE tbl_Customer SET fld_CustName = ?, SET fld_CustPhone = ?, SET fld_CustAddress = ?, SET fld_CustDateOfBirth = ?, SET fld_CustEmail = ?, WHERE fld_CustID =?)");

        ps.setString(1,fld_CustName);
        ps.setString(2,fld_CustPhone);
        ps.setString(3,fld_CustAddress);
        ps.setString(4,fld_CustDateOfBirth);
        ps.setString(5,fld_CustEmail);
        ps.setInt(6,fld_CustID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public ArrayList<Employee> getEmployees() {
        throw new NotImplementedException();
    }

    public Employee getEmployee(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addEmployee(int fld_EmpID, String fld_EmpName, String fld_EmpPhone, String fld_Position, String fld_EmpAddress, String fld_EmpEmail, String fld_EmpBankAccount) throws SQLException{

        ps = con.prepareStatement("INSERT INTO tbl_Employee VALUES (?,?,?,?,?,?,?)");

        ps.setInt(1,fld_EmpID);
        ps.setString(2,fld_EmpName);
        ps.setString(3,fld_EmpPhone);
        ps.setString(4,fld_Position);
        ps.setString(5,fld_EmpAddress);
        ps.setString(6,fld_EmpEmail);
        ps.setString(7,fld_EmpBankAccount);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteEmployee(int fld_EmpID) throws SQLException{

        ps = con.prepareStatement("DELETE FROM tbl_Employee WHERE fld_EmpID = ?");
        ps.setInt(1,fld_EmpID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateEmployee(int fld_EmpID, String fld_EmpName, String fld_EmpPhone, String fld_Position, String fld_EmpAddress, String fld_EmpEmail, String fld_EmpBankAccount) throws SQLException{

        ps = con.prepareStatement("UPDATE tbl_Employee SET fld_EmpName = ?, SET fld_EmpPhone = ?, SET fldPosition = ?, SET fld_EmpAddress = ?, Set fld_EmpEmail = ?, SET fld_EmpBankAccount = ? WHERE fld_EmpID = ? ");
        ps.setString(1,fld_EmpName);
        ps.setString(2,fld_EmpPhone);
        ps.setString(3,fld_Position);
        ps.setString(4,fld_EmpAddress);
        ps.setString(5,fld_EmpEmail);
        ps.setString(6,fld_EmpBankAccount);
        ps.setInt(7,fld_EmpID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public ArrayList<Menu> getMenus() {
        throw new NotImplementedException();
    }

    public Menu getMenu() {
        throw new NotImplementedException();
    }

    public void addMenu(String fld_MenuName, int fld_MenuPrice)throws SQLException {

        ps = con.prepareStatement("INSERT INTO tbl_Menu VALUES (?,?)");
        ps.setString(1,fld_MenuName);
        ps.setInt(2,fld_MenuPrice);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteMenu(String fld_MenuName) throws SQLException {

        ps = con.prepareStatement("DELETE FROM tbl_Menu WHERE fld_MenuName = ?");
        ps.setString(1,fld_MenuName);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateMenu(String fld_MenuName, int fld_MenuPrice) throws SQLException {

        ps = con.prepareStatement("UPDATE tbl_Menu SET fld_MenuPrice = ? WHERE fld_MenuName = ?");
        ps.setInt(1,fld_MenuPrice);
        ps.setString(2,fld_MenuName);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public ArrayList<Room> getRooms() {
        throw new NotImplementedException();
    }

    public Room getRoom() {
        throw new NotImplementedException();
    }

    public void addRoom(int fld_RoomNo, String fld_RoomDescription, int fld_RoomBedNo, int fld_RoomPrice) throws SQLException{

        ps = con.prepareStatement("INSERT INTO tbl_Room VALUES (?,?,?,?)");
        ps.setInt(1,fld_RoomNo);
        ps.setString(2,fld_RoomDescription);
        ps.setInt(3,fld_RoomBedNo);
        ps.setInt(4,fld_RoomPrice);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteRoom(int fld_RoomNo) throws SQLException {

        ps = con.prepareStatement("DELETE FROM tbl_Room WHERE fld_RoomNo = ?");
        ps.setInt(1,fld_RoomNo);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateRoom(int fld_RoomNo, String fld_RoomDescription, int fld_RoomBedNo, int fld_RoomPrice) throws SQLException{

        ps = con.prepareStatement("UPDATE tbl_Room SET fld_RoomDescription = ?, SET fld_RommBedNo = ?, SET fld_RoomPrice = ? WHERE fld_RoomNo = ?");
        ps.setString(1,fld_RoomDescription);
        ps.setInt(2,fld_RoomBedNo);
        ps.setInt(3,fld_RoomPrice);
        ps.setInt(4,fld_RoomNo);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public ArrayList<RoomReservation> getRoomReservations() {
        throw new NotImplementedException();
    }

    public RoomReservation getRoomReservation() {
        throw new NotImplementedException();
    }

    public void addRoomReservation(int fld_RRID, String fld_RRCHeckIn, String fld_RRCheckOut, int fld_RoomNo, int fld_CustID) throws SQLException {

        ps = con.prepareStatement("INSERT INTO tbl_RoomReservation VALUES (?,?,?,?,?)");
        ps.setInt(1,fld_RRID);
        ps.setString(2,fld_RRCHeckIn);
        ps.setString(3,fld_RRCheckOut);
        ps.setInt(4,fld_RoomNo);
        ps.setInt(5,fld_CustID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteRoomReservation(int fld_RRIDI) throws SQLException {

        ps = con.prepareStatement("DELETE FROM tbl_RoomRervation WHERE fld_RRID = ?");
        ps.setInt(1,fld_RRIDI);
        ps.executeUpdate();
        ps.close();

        throw new NotImplementedException();
    }

    public void updateRoomReservation(int fld_RRID, String fld_RRCheckIn, String fld_RRCheckOut, int fld_RoomNo, int fld_CustID) throws SQLException {

        ps = con.prepareStatement("UPDATE tbl_RoomReservation SET fld_RRCheckIn = ?, set fld_RRCheckOut = ?, set fld_RoomNo = ?, set fld_CustID = ? WHERE fld_RRID = ?");
        ps.setString(1,fld_RRCheckIn);
        ps.setString(2,fld_RRCheckOut);
        ps.setInt(3,fld_RoomNo);
        ps.setInt(4,fld_CustID);
        ps.setInt(5,fld_RRID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public ArrayList<RoomService> getRoomServices() {
        throw new NotImplementedException();
    }

    public RoomService getRoomService() {
        throw new NotImplementedException();
    }

    public void addRoomService(String fld_RSName, int fld_RSPrice) throws SQLException {

        ps = con.prepareStatement("INSERT INTO tbl_RoomService VALUES (?,?)");
        ps.setString(1,fld_RSName);
        ps.setInt(2,fld_RSPrice);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteRoomService(String fld_RSName) throws SQLException {

        ps = con.prepareStatement("DELETE FROM tbl_RoomService WHERE fld_RSName = ?");
        ps.setString(1,fld_RSName);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateRoomService(String fld_RSName, int fld_RSPrice) throws SQLException {

        ps = con.prepareStatement("UPDATE tbl_RoomService SET fld_RSPrice = ? WHERE fld_RSName = ?");
        ps.setInt(1,fld_RSPrice);
        ps.setString(2,fld_RSName);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }


    public ArrayList<ToDo> getToDos(int id) {
        throw new NotImplementedException();
    }

    public ToDo getToDo() {
        throw new NotImplementedException();
    }

    public void addToDo(String fld_TDDescription, String fld_TDDate, int fld_EmpID) throws SQLException {

        ps = con.prepareStatement("INSERT INTO tbl_ToDO VALUES (?,?,?)");
        ps.setString(1,fld_TDDescription);
        ps.setString(2,fld_TDDate);
        ps.setInt(3,fld_EmpID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteToDo(String fld_TDDescription) throws SQLException{

        ps = con.prepareStatement("DELETE FROM tbl_ToDO WHERE fld_TDDescription = ?");
        ps.setString(1,fld_TDDescription);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateToDo(String fld_TDDescription, String fld_TDDate, int fld_EmpID) throws SQLException{

        ps = con.prepareStatement("INSERT INTO tbl_ToDO SET fld_TDDate = ?, SET fld_EmpID = ? WHERE fld_TDDescription = ?");
        ps.setString(1,fld_TDDate);
        ps.setInt(2,fld_EmpID);
        ps.setString(3,fld_TDDescription);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public ArrayList<User> getUsers() {
        throw new NotImplementedException();
    }

    public User getUser(String user, String pass) {
        throw new NotImplementedException();
    }

    public void addUser(String fld_UserGroup, String fld_UserPassword, String fld_UserLogin, int fld_EmpID) throws SQLException{

        ps = con.prepareStatement("INSERT INTO tbl_User VALUES (?,?,?,?)");
        ps.setString(1,fld_UserGroup);
        ps.setString(2,fld_UserPassword);
        ps.setString(3,fld_UserLogin);
        ps.setInt(4,fld_EmpID);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void deleteUser(String fld_UserLogin) throws SQLException {

        ps = con.prepareStatement("DELETE FROM tbl_User WHERE fld_UserLogin = ?");
        ps.setString(1,fld_UserLogin);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }

    public void updateUser(String fld_UserGroup, String fld_UserPassword, String fld_UserLogin, int fld_EmpID) throws SQLException {

        ps = con.prepareStatement("INSERT INTO tbl_User SET fld_UserPassword = ?, SET fld_UserGroup, SET fld_EmpID = ? WHERE fld_UserLogin = ?");
        ps.setString(1,fld_UserGroup);
        ps.setString(2,fld_UserPassword);
        ps.setInt(3,fld_EmpID);
        ps.setString(4,fld_UserLogin);

        ps.executeUpdate();
        ps.close();
        throw new NotImplementedException();
    }


}

