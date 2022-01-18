package com.Hotel.Room;

import java.time.LocalDate;
import java.util.Date;

public class Room {
    private String guestName;
    private int guestNumber;
    private int daysReserved;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int roomNumber;



    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(int guestNumber) {
        this.guestNumber = guestNumber;
    }

    public int getDaysReserved() {
        return daysReserved;
    }

    public void setDaysReserved(int daysReserved) {
        this.daysReserved = daysReserved;
    }

    public LocalDate getCheckInDate() {

        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        LocalDate inDate = LocalDate.parse(checkInDate);
        this.checkInDate = inDate;
    }

    public LocalDate getCheckOutDate() {
        LocalDate inDate = getCheckInDate();
        LocalDate outDate = inDate.plusDays(daysReserved);
        checkOutDate = outDate;
        return checkOutDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
