package com.Hotel.Room;

import java.time.LocalDate;

public class PresidentialSuite extends Room{
    private final double COST_PER_NIGHT = 235.89;
    private final int MAX_PEOPLE = 5;
    private final int FIRST_ROOM_NUMBER = 200;
    private final int LAST_ROOM_NUMBER = 210;
    private final String ROOM_NAME = "Presidential Suite";
    private String guestName;
    private int guestNumber;
    private int daysReserved;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int roomNumber;


    public PresidentialSuite(String guestName,int guestNumber,int daysReserved, String checkInDate) {
        setGuestName(guestName);
        setGuestNumber(guestNumber, MAX_PEOPLE);
        setDaysReserved(daysReserved);
        setCheckInDate(checkInDate);
        setRoomNumber(FIRST_ROOM_NUMBER,LAST_ROOM_NUMBER);
    }


    public double calculateCost() {
        return COST_PER_NIGHT * getDaysReserved();
    }

    public String getRoomName() {
        return this.ROOM_NAME;
    }

    @Override
    public String toString() {
        return " Booking Guest: " + getGuestName() +
                ", Accompanying Guests: " + getGuestNumber() +
                ", Check In Date: " + getCheckInDate() +
                ", Check Out Date: " + getCheckOutDate() +
                ", Room Number: " + getRoomNumber() +
                ", Stay Cost: " + calculateCost();
    }
}
