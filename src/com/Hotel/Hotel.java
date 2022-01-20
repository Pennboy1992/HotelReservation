package com.Hotel;

import com.Hotel.Room.PresidentialSuite;
import com.Hotel.Room.RegularRoom;
import com.Hotel.Room.Room;
import com.Hotel.Room.SnowdenSuite;

import java.util.ArrayList;
import java.util.Collection;

public class Hotel {
    private Collection<RegularRoom> regularRooms = new ArrayList<>();
    private Collection<PresidentialSuite> presidentialSuites = new ArrayList<>();
    private Collection<SnowdenSuite> snowdenSuites = new ArrayList<>();
    private String hotelName;
    private String address;

    public Hotel(String hotelName,String address) {
        setHotelName(hotelName);
        setAddress(address);
    }


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public void makeReservation(Room room){
        if(room.getRoomName()== "Regular Room" && regularRooms.size() <= 15){
            regularRooms.add((RegularRoom) room);
            room.printReceipt();
        }
        else if(room.getRoomName()== "Presidential Suite" && presidentialSuites.size() <= 10){
            presidentialSuites.add((PresidentialSuite) room);
            room.printReceipt();
        }
        else if(room.getRoomName()== "Snowden Suite" && snowdenSuites.size() <= 5){
            snowdenSuites.add((SnowdenSuite) room);
            room.printReceipt();
        }

    }
    public void listGuests(){
        for(RegularRoom room: regularRooms){
            System.out.println("Regular Room guests: ");
            System.out.println(room);
        }
        for(PresidentialSuite room: presidentialSuites){
            System.out.println("Presidential Suite guests: ");
            System.out.println(room);
        }
        for(SnowdenSuite room: snowdenSuites){
            System.out.println("Snowden Suite guests: ");
            System.out.println(room);
        }
    }



}
