package com.Hotel.Room;

import com.Hotel.Hotel;

public class SnowdenSuite extends Room{
    private final double COST_PER_NIGHT = 375.25; //specific to children class
    private final int MAX_PEOPLE = 7;
    private final int FIRST_ROOM_NUMBER = 300;
    private final int LAST_ROOM_NUMBER = 399;
    private final String ROOM_NAME = "Snowden Suite";


    public SnowdenSuite(String guestName,int guestNumber,int daysReserved, String checkInDate) {
        setGuestName(guestName);
        setGuestNumber(guestNumber, MAX_PEOPLE);
        setDaysReserved(daysReserved);
        setCheckInDate(checkInDate);
        setRoomNumber(FIRST_ROOM_NUMBER,LAST_ROOM_NUMBER);
        setReservationNumber();
    }



    public double calculateCost() {
        return COST_PER_NIGHT * getDaysReserved();
    }

    public String getRoomName() {
        return this.ROOM_NAME;
    }
    @Override
    public String toString() {
        return "Booking Guest: " + Hotel.nameFormatter(getGuestName()) +
                ", Reservation Number: "+ getReservationNumber()+
                ", Accompanying Guests: " + getGuestNumber() +
                ", Check In Date: " + getCheckInDate() +
                ", Check Out Date: " + getCheckOutDate() +
                ", Room Class: "+ getRoomName() +
                ", Room Number: " + getRoomNumber() +
                ", Stay Cost: " + calculateCost();
    }
    }

