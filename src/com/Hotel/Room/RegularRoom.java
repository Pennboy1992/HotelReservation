package com.Hotel.Room;
import com.Hotel.Hotel;
public class RegularRoom extends Room{
    private final double COST_PER_NIGHT = 195.67;
    private final int MAX_PEOPLE = 3;
    private final int FIRST_ROOM_NUMBER = 100;
    private final int LAST_ROOM_NUMBER = 199;
    private final String ROOM_NAME = "Regular Room";

    public RegularRoom(String guestName,int guestNumber,int daysReserved, String checkInDate) {
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
