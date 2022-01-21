package com.Hotel.Room;

import java.time.LocalDate;
import com.Hotel.Hotel;

public abstract class Room {
    private String guestName;
    private int guestNumber;
    private int daysReserved;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int roomNumber;
    private int reservationNumber;
    private double totalCost;

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double costPerNight) {
        this.totalCost = costPerNight * getDaysReserved();
    }

    public int getReservationNumber() {
        return reservationNumber;
    }
    //importing the random class, get a number b/w 1-1000, not starting at zero
    public void setReservationNumber() {
        int random_int = (int) Math.floor(Math.random() * (9999 - 1 + 1) + 1);
        this.reservationNumber = random_int;
    }

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
    //checkout date = checkin date + days staying
    public LocalDate getCheckOutDate() {
        LocalDate inDate = getCheckInDate();
        LocalDate outDate = inDate.plusDays(daysReserved);
        checkOutDate = outDate;
        return checkOutDate;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }
    //random room number b/w min and max which is defined in child class
    public void setRoomNumber(int min, int max) {
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        this.roomNumber = random_int;
    }

    public abstract String getRoomName();

    @Override
    public String toString() {
        return "Room{" +
                "guestName='" + guestName + '\'' +
                ", guestNumber=" + guestNumber +
                ", daysReserved=" + daysReserved +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + getCheckOutDate() +
                ", roomNumber=" + roomNumber +
                '}';
    }
}


