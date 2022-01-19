package com.Hotel.Room;

import java.time.LocalDate;

public class RegularRoom extends Room{
    private final double COST_PER_NIGHT = 195.67;
    private final int MAX_PEOPLE = 3;
    private final int FIRST_ROOM_NUMBER = 100;
    private final int LAST_ROOM_NUMBER = 115;
    private String guestName;
    private int guestNumber;
    private int daysReserved;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int roomNumber;


    public RegularRoom(String guestName,int guestNumber,int daysReserved, String checkInDate) {
        setGuestName(guestName);
        setGuestNumber(guestNumber, MAX_PEOPLE);
        setDaysReserved(daysReserved);
        setCheckInDate(checkInDate);
        setRoomNumber(FIRST_ROOM_NUMBER,LAST_ROOM_NUMBER);
    }

    public double calculateCost() {
        return COST_PER_NIGHT * getDaysReserved();
    }




}
