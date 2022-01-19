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

    public void setGuestNumber(int guestNumber, int maxGuest) {
        if(guestNumber > maxGuest){
            this.guestNumber = 0;
        }
        else {
            this.guestNumber = guestNumber;
        }
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
        return this.roomNumber;
    }

    public void setRoomNumber(int min, int max) {
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        this.roomNumber = random_int;
        this.roomNumber = roomNumber;
    }
}


