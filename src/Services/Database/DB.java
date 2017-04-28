package Services.Database;

import Domain.Model.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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

    public static java.sql.Date convertDate(java.util.Date date) {
        return java.sql.Date.valueOf(LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate()));
    }

    public void sqlError(SQLException e) {
        e.printStackTrace();
        System.exit(1);
    }

    public ArrayList<Arrangement> getArrangements() {
        throw new NotImplementedException();
    }

    public Arrangement getArrangement(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addArrangement(Arrangement arrangement) {

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_Arrangement VALUES (?, ?, ?, ?, ?, ?, ?)");

            ps.setInt(1, arrangement.getId());
            ps.setString(2, arrangement.getName());
            ps.setString(3, arrangement.getDescription());
            ps.setDate(4, convertDate(arrangement.getDate()));
            ps.setDouble(5, arrangement.getPrice());
            ps.setInt(6, arrangement.getParticipantNo());
            ps.setInt(7, arrangement.getCustomer().getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteArrangement(Arrangement arrangement) {

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_Arrangement WHERE fld_ArrID = ?");
            ps.setInt(1, arrangement.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateArrangement(Arrangement arrangement) {

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_Arrangement SET fld_ArrName = ? ,SET fld_ArrDescription = ?,SET fld_ArrDate = ?,SET fld_ArrPrice = ?,SET fld_ArrPartNo = ?,SET fld_CustID = ? WHERE fld_ArrID = ?");
            ps.setString(1, arrangement.getName());
            ps.setString(2, arrangement.getDescription());
            ps.setDate(3, convertDate(arrangement.getDate()));
            ps.setDouble(4, arrangement.getPrice());
            ps.setInt(5, arrangement.getParticipantNo());
            ps.setInt(6, arrangement.getCustomer().getId());
            ps.setInt(7, arrangement.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }

    }

    public ArrayList<Catering> getCaterings() {
        throw new NotImplementedException();
    }

    public Catering getCatering(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addCatering(Catering catering) {

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_Catering VALUES (?,?,?,?,?,?,?)");

            ps.setInt(5, catering.getId());
            ps.setInt(1, catering.getNumberOfMeals());
            ps.setString(2, catering.getFoodType());
            ps.setString(3, catering.getLocation());
            ps.setDate(4, convertDate(catering.getDate()));
            ps.setDouble(6, catering.getPrice());
            ps.setInt(7, catering.getCustomer().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteCatering(Catering catering) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_Catering WHERE fld_CatOrderID = ?");
            ps.setInt(1, catering.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateCatering(Catering catering) {

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_Catering SET fld_CatNoOfMeals = ? ,SET CatTypeOfFood = ?,SET fld_CatLocation = ?,SET fld_CatDate = ?,SET fld_CatPrice = ?,SET fld_CustID = ? WHERE fld_CatOrderID = ?");

            ps.setInt(1, catering.getNumberOfMeals());
            ps.setString(2, catering.getFoodType());
            ps.setString(3, catering.getLocation());
            ps.setDate(4, convertDate(catering.getDate()));
            ps.setDouble(5, catering.getPrice());
            ps.setInt(6, catering.getCustomer().getId());
            ps.setInt(7, catering.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public ArrayList<Customer> getCustomers() {
        throw new NotImplementedException();
    }

    public Customer getCustomer(int id) {
        Customer c = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_Customer WHERE fld_CustID=?");

            ps.setString(1, Integer.toString(id));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(6), rs.getDate(5), rs.getString(2));
            }
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }

        return c;
    }

    public void addCustomer(Customer customer) {

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_Customer VALUES (?,?,?,?,?,?)");

            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getPhoneNumber());
            ps.setString(4, customer.getAddress());
            ps.setDate(5, convertDate(customer.getDateOfBirth()));
            ps.setString(6, customer.getEmail());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteCustomer(Customer customer) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_Customer WHERE fld_CustID = ?");
            ps.setInt(1, customer.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateCustomer(Customer customer) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_Customer SET fld_CustName = ?, SET fld_CustPhone = ?, SET fld_CustAddress = ?, SET fld_CustDateOfBirth = ?, SET fld_CustEmail = ?, WHERE fld_CustID =?)");

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhoneNumber());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getDateOfBirth().toString());
            ps.setString(5, customer.getEmail());
            ps.setInt(6, customer.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public ArrayList<Employee> getEmployees() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_Employee");

            ResultSet rs = ps.executeQuery();

            ArrayList<Employee> employeeList = new ArrayList<>();

            while (rs.next()) {
                Employee e = new Employee(rs.getString(2), rs.getString(4), rs.getInt(1), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7));
                employeeList.add(e);
            }

            ps.close();
            return employeeList;
        } catch (SQLException e) {
            sqlError(e);
        }

        return null;
    }

    public Employee getEmployee(int i) {
        Employee em = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_Employee WHERE fld_EmpID=?");

            ps.setString(1, Integer.toString(i));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                em = new Employee(rs.getString(2), rs.getString(4), rs.getInt(1), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7));
            }
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }

        return em;
    }

    public void addEmployee(Employee employee) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_Employee VALUES (?,?,?,?,?,?,?)");

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getPhoneNumber());
            ps.setString(4, employee.getPosition());
            ps.setString(5, employee.getAddress());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getBankAccount());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteEmployee(Employee employee) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_Employee WHERE fld_EmpID = ?");
            ps.setInt(1, employee.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_Employee SET fld_EmpName = ?, SET fld_EmpPhone = ?, SET fldPosition = ?, SET fld_EmpAddress = ?, Set fld_EmpEmail = ?, SET fld_EmpBankAccount = ? WHERE fld_EmpID = ? ");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getPhoneNumber());
            ps.setString(3, employee.getPosition());
            ps.setString(4, employee.getAddress());
            ps.setString(5, employee.getEmail());
            ps.setString(6, employee.getBankAccount());
            ps.setInt(7, employee.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public ArrayList<Menu> getMenus() {
        throw new NotImplementedException();
    }

    public Menu getMenu(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addMenu(Menu menu) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_Menu VALUES (?,?)");
            ps.setString(1, menu.getName());
            ps.setDouble(2, menu.getPrice());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteMenu(Menu menu) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_Menu WHERE fld_MenuName = ?");
            ps.setString(1, menu.getName());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateMenu(Menu menu) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_Menu SET fld_MenuPrice = ? WHERE fld_MenuName = ?");
            ps.setDouble(1, menu.getPrice());
            ps.setString(2, menu.getName());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public ArrayList<Room> getRooms() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_Room");

            ResultSet rs = ps.executeQuery();

            ArrayList<Room> roomList = new ArrayList<>();

            while (rs.next()) {
                Room r = new Room(rs.getDouble(4), rs.getString(5), rs.getInt(1), rs.getInt(3), rs.getString(2));
                roomList.add(r);
            }

            ps.close();
            return roomList;
        } catch (SQLException e) {
            sqlError(e);
        }
        return null;
    }

    public Room getRoom(int i) {
        Room r = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_Room WHERE fld_RoomNo=?");

            ps.setString(1, Integer.toString(i));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r = new Room(rs.getDouble(4), rs.getString(5), rs.getInt(1), rs.getInt(3), rs.getString(2));
            }
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }

        return r;
    }

    public void addRoom(Room room) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_Room VALUES (?,?,?,?,?)");
            ps.setInt(1, room.getNumber());
            ps.setString(2, room.getDescription());
            ps.setInt(3, room.getBedCount());
            ps.setDouble(4, room.getPrice());
            ps.setString(5, room.getName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteRoom(Room room) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_Room WHERE fld_RoomNo = ?");
            ps.setInt(1, room.getNumber());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateRoom(Room room) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_Room SET fld_RoomDescription = ?, SET fld_RoomBedNo = ?, SET fld_RoomPrice = ? WHERE fld_RoomNo = ?");
            ps.setString(1, room.getDescription());
            ps.setInt(2, room.getBedCount());
            ps.setDouble(3, room.getPrice());
            ps.setInt(4, room.getNumber());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public ArrayList<RoomReservation> getRoomReservations() {
        throw new NotImplementedException();
    }

    public RoomReservation getRoomReservation(int id) {
        RoomReservation rr = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_RoomReservation WHERE fld_RRID=?");

            ps.setString(1, Integer.toString(id));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = getCustomer(rs.getInt(5));
                Room r = getRoom(rs.getInt(4));

                rr = new RoomReservation(rs.getDate(2), rs.getDate(3), c, r, rs.getInt(1));
            }
            ps.close();
            return rr;
        } catch (SQLException e) {
            sqlError(e);
        }

        return rr;
    }

    public void addRoomReservation(RoomReservation roomReservation) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_RoomReservation VALUES (?,?,?,?,?)");
            ps.setInt(1, roomReservation.getId());
            ps.setDate(2, convertDate(roomReservation.getCheckIn()));
            ps.setDate(3, convertDate(roomReservation.getCheckOut()));
            ps.setInt(4, roomReservation.getRoom().getNumber());
            ps.setInt(5, roomReservation.getCustomer().getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteRoomReservation(RoomReservation roomReservation) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_RoomReservation WHERE fld_RRID = ?");
            ps.setInt(1, roomReservation.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateRoomReservation(RoomReservation roomReservation) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_RoomReservation SET fld_RRCheckIn = ?, set fld_RRCheckOut = ?, set fld_RoomNo = ?, set fld_CustID = ? WHERE fld_RRID = ?");
            ps.setString(1, roomReservation.getCheckIn().toString());
            ps.setString(2, roomReservation.getCheckOut().toString());
            ps.setInt(3, roomReservation.getRoom().getNumber());
            ps.setInt(4, roomReservation.getCustomer().getId());
            ps.setInt(5, roomReservation.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public ArrayList<RoomService> getRoomServices() {
        throw new NotImplementedException();
    }

    public RoomService getRoomService(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addRoomService(RoomService roomService) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_RoomService VALUES (?,?)");
            ps.setString(1, roomService.getName());
            ps.setDouble(2, roomService.getPrice());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteRoomService(RoomService roomService) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_RoomService WHERE fld_RSName = ?");
            ps.setString(1, roomService.getName());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateRoomService(RoomService roomService) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_RoomService SET fld_RSPrice = ? WHERE fld_RSName = ?");
            ps.setString(1, roomService.getName());
            ps.setDouble(2, roomService.getPrice());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public ArrayList<ToDo> getToDos() {
        throw new NotImplementedException();
    }

    public ArrayList<ToDo> getToDos(Date date) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_ToDo WHERE fld_TDDate=?");

            java.sql.Date sqlDate = convertDate(date);
            ps.setDate(1, sqlDate);

            ResultSet rs = ps.executeQuery();

            ArrayList<ToDo> todoList = new ArrayList<>();

            while (rs.next()) {
                Employee e = getEmployee(rs.getInt(3));
                ToDo t = new ToDo(rs.getString(1), rs.getDate(2), e);
                todoList.add(t);
            }

            ps.close();
            return todoList;
        } catch (SQLException e) {
            sqlError(e);
        }
        return null;
    }

    public ToDo getToDo(/*identifier*/) {
        throw new NotImplementedException();
    }

    public void addToDo(ToDo toDo) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_ToDO VALUES (?,?,?)");
            ps.setString(1, toDo.getDescription());
            ps.setDate(2, convertDate(toDo.getDate()));
            ps.setInt(3, toDo.getEmployee().getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteToDo(ToDo toDo) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_ToDO WHERE fld_TDDescription = ?");
            ps.setString(1, toDo.getDescription());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void updateToDo(ToDo toDo) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_ToDO SET fld_TDDate = ?, SET fld_EmpID = ? WHERE fld_TDDescription = ?");
            ps.setDate(1, convertDate(toDo.getDate()));
            ps.setInt(2, toDo.getEmployee().getId());
            ps.setString(3, toDo.getDescription());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public ArrayList<User> getUsers() {
        throw new NotImplementedException();
    }

    public User getUser(String user) {
        User u = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_User WHERE fld_UserLogin=?");

            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee e = getEmployee(rs.getInt(4));
                u = new User(rs.getString(1), rs.getString(3), rs.getString(2), e);
            }
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
        return u;
    }

    public void addUser(User user) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tbl_User VALUES (?,?,?,?)");
            ps.setString(1, user.getGroup());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getLogin());
            ps.setInt(4, user.getEmployee().getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteUser(User user) {
        deleteUser(user.getLogin());
    }

    public void updateUser(User user) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tbl_User SET fld_UserPassword = ?, SET fld_UserGroup, SET fld_EmpID = ? WHERE fld_UserLogin = ?");
            ps.setString(1, user.getGroup());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getEmployee().getId());
            ps.setString(4, user.getLogin());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }

    public void deleteUser(String username) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tbl_User WHERE fld_UserLogin = ?");
            ps.setString(1, username);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            sqlError(e);
        }
    }
}

