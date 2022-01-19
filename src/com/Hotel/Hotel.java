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

    public Hotel(String hotelName, String address) {
        this.hotelName = hotelName;
        this.address = address;
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
        if(room.getRoomName()== "Regular Room"){
            regularRooms.add((RegularRoom) room);
        }
        else if(room.getRoomName()== "Presidential Suite"){
            presidentialSuites.add((PresidentialSuite) room);
        }
        else if(room.getRoomName()== "Snowden Suite"){
            snowdenSuites.add((SnowdenSuite) room);
        }

    }
    public void listGuests(){
        for(RegularRoom room: regularRooms){
            System.out.println(room);
        }
        for(PresidentialSuite room: presidentialSuites){
            System.out.println(room);
        }
        for(SnowdenSuite room: snowdenSuites){
            System.out.println(room);
        }
    }



}
