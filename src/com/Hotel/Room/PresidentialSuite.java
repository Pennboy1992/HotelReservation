package com.Hotel.Room;

import com.Hotel.Hotel;

public class PresidentialSuite extends Room{
    private final double COST_PER_NIGHT = 235.89;
    private final int MAX_PEOPLE = 5;
    private final int FIRST_ROOM_NUMBER = 200;
    private final int LAST_ROOM_NUMBER = 299;
    private final String ROOM_NAME = "Presidential Suite";

    public PresidentialSuite(String guestName,int guestNumber,int daysReserved, String checkInDate) {
        setGuestName(guestName);
        setGuestNumber(guestNumber, MAX_PEOPLE);
        setDaysReserved(daysReserved);
        setCheckInDate(checkInDate);
        setRoomNumber(FIRST_ROOM_NUMBER,LAST_ROOM_NUMBER);
        setReservationNumber();
        setTotalCost(COST_PER_NIGHT);
    }

    public String getRoomName() {
        return this.ROOM_NAME;
    }

    @Override
    public String toString() {
        return "Booking Guest: " + Hotel.nameFormatter(getGuestName()) +
                ", Reservation Number: "+ getReservationNumber()+
                ", Accompanying Guests: " + (getGuestNumber() -1)  +
                ", Check In Date: " + getCheckInDate() +
                ", Check Out Date: " + getCheckOutDate() +
                ", Room Class: "+ getRoomName() +
                ", Room Number: " + getRoomNumber() +
                ", Stay Cost: " + getTotalCost();
    }
}
