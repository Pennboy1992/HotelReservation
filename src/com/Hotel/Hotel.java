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


}
