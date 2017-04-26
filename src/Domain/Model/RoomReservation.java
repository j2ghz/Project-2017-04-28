package Domain.Model;

import java.util.Collection;
import java.util.Date;

public class RoomReservation {
    private Date checkIn;
    private Date chekcOut;
    private Customer customer;
    private Collection<Menu> menus;
    private Collection<RoomService> roomServices;
    private Room room;

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public Collection<RoomService> getRoomServices() {
        return roomServices;
    }

    public RoomReservation(Date checkIn, Date chekcOut, Customer customer, Room room) {
        this.checkIn = checkIn;
        this.chekcOut = chekcOut;
        this.customer = customer;
        this.room = room;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void addRoomService(RoomService rs) {
        roomServices.add(rs);
    }

    public void setRoomServices(Collection<RoomService> roomServices) {
        this.roomServices = roomServices;
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

    public Date getChekcOut() {
        return chekcOut;
    }

    public void setChekcOut(Date chekcOut) {
        this.chekcOut = chekcOut;
    }
}
