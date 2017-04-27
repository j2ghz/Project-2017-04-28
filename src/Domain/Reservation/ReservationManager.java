package Domain.Reservation;


import Domain.Model.*;
import Services.Database.DB;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
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

    public void reserveRoom(Date checkIn, Date checkOut, Customer customer, Room room) {
        RoomReservation reservation = new RoomReservation(checkIn, checkOut, customer, room);

        db.addRoomReservation(reservation);
    }

    public void reserveRoom(Date checkIn, Date checkOut, Customer customer, Room room, Menu menu) {
        RoomReservation reservation = new RoomReservation(checkIn, checkOut, null, room);

        reservation.addMenu(menu);

        db.addRoomReservation(reservation);
    }

    public void reserveRoom(Date checkIn, Date checkOut, Customer customer, Room room, RoomService rs) {
        RoomReservation reservation = new RoomReservation(checkIn, checkOut, null, room);

        reservation.addRoomService(rs);

        db.addRoomReservation(reservation);
    }

    public void reserveRoom(Date checkIn, Date checkOut, Customer customer, Room room, Menu menu, RoomService rs) {
        RoomReservation reservation = new RoomReservation(checkIn, checkOut, null, room);

        reservation.addMenu(menu);

        reservation.addRoomService(rs);

        db.addRoomReservation(reservation);
    }

    public void deleteRoomReservation(int resId) {
        if (resId != 0) {
            db.deleteRoomReservation(db.getRoomReservation(resId));
        }
    }

    public void createCateringReservation(int noMeals, String typeOfFood, String location, Date date, int cateringID, double price, Customer customer, JOptionPane jOptionPane) {
        if (date != null && noMeals != 0 && typeOfFood != null && location != null && customer != null && price != 0 && cateringID != 0) {
            Catering catering = new Catering(noMeals, typeOfFood, location, date, cateringID, price, customer);
            db.addCatering(catering);
        } else {
            jOptionPane.setMessage("There was some information missing, reservation was not created");
            jOptionPane.setVisible(true);
        }
    }

    public void createArrangementReservation(Date date, int arrangementID, double price, int customerID, String arrangementName, String description, Customer customer, int eventSize, JOptionPane jOptionPane) {
        if (date != null && arrangementID != 0 && price != 0 && customerID != 0 && arrangementName != null && description != null && customer != null && eventSize != 0) {
            Arrangement arrangement = new Arrangement(date, arrangementID, price, customerID, arrangementName, description, customer, eventSize);
            db.addArrangement(arrangement);
        } else {
            jOptionPane.setMessage("There was some information missing, reservation was not created");
            jOptionPane.setVisible(true);
        }
    }
}
