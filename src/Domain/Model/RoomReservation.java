package Domain.Model;

import java.util.Collection;
import java.util.Date;

public class RoomReservation {
    private Date checkIn;
    private Date checkOut;
    private Customer customer;
    private Collection<Menu> menus;
    private Collection<RoomService> roomServices;
    private Room room;
    private int id;


    public RoomReservation(Date checkIn, Date checkOut, Customer customer, Room room, int id) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.customer = customer;
        this.room = room;
        this.id = id;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public Collection<RoomService> getRoomServices() {
        return roomServices;
    }

    public void setRoomServices(Collection<RoomService> roomServices) {
        this.roomServices = roomServices;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void addRoomService(RoomService rs) {
        roomServices.add(rs);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
