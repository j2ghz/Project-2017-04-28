package Domain.Reservation;


import Domain.Model.Room;
import Domain.Model.RoomReservation;
import Services.Database.DB;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Date;

public class ReservationManager {
    private final DB db;

    public ReservationManager(DB db) {
        this.db = db;
    }

    public ArrayList<Room> freeRooms(Date date) {
        throw new NotImplementedException();
    }

    public void reserveRoom(Date checkIn, Date checkOut, Room room) {
        RoomReservation reservation = new RoomReservation();
        reservation.setCheckIn(checkIn);
        reservation.setChekcOut(checkOut);
        reservation.setRoom(room);
        reservation.setMenus(new ArrayList<>());
        reservation.setRoomServices(new ArrayList<>());

        db.addRoomReservation(reservation);
    }

}
