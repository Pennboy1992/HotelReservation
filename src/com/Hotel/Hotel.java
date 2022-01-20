package com.Hotel;

import com.Hotel.Room.PresidentialSuite;
import com.Hotel.Room.RegularRoom;
import com.Hotel.Room.Room;
import com.Hotel.Room.SnowdenSuite;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Hotel {
//    private Collection<RegularRoom> regularRooms = new ArrayList<>();
//    private Collection<PresidentialSuite> presidentialSuites = new ArrayList<>();
//    private Collection<SnowdenSuite> snowdenSuites = new ArrayList<>();
    private Collection<Room> hotelRooms = new ArrayList<>();
    private String hotelName;
    private String address;
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
    public void makeReservation(){

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        Scanner in4 = new Scanner(System.in);
        Scanner in5 = new Scanner(System.in);

        StringBuilder options = new StringBuilder();
        System.out.println("Welcome to the Hacker's Suite Hotel!");
        System.out.println("May we have your name for this reservation today:  ");
        String guestName = in.nextLine();

        System.out.println("Thank you, " + guestName + "!");

        System.out.println("How many guests can we expect for this reservation?:  ");
        int guestNumber = in2.nextInt() + 1;
        in2.nextLine();
        if (guestNumber > 7) {
            System.out.println("We apologize but we have no rooms that can fit this capacity.");

        } else if (guestNumber > 5) {
            System.out.println("We recommend going with the Snowden Suite.");
            options.append("Snowden Suite");

        } else if (guestNumber > 3) {
            System.out.println("We recommend going with the Presidential Suite");
            options.append("Presidential Suite, ");
            options.append("Snowden Suite");

        } else if (guestNumber >= 1) {
            System.out.println("We recommend you use the Regular Rooms.");
            options.append("Regular Room, ");
            options.append("Presidential Suite, ");
            options.append("Snowden Suite");
        }
        System.out.println("What day will you be joining us?(Please enter date in yyyy-mm-dd format");
        String checkInDate = in4.nextLine();

        System.out.println("Now how many days will you be staying with us?");
        int numOfDays = in5.nextInt();
        boolean capacity = guestNumber <= 7;
        if(capacity)
        {
            System.out.println("You are eligible for:  " + options);
            System.out.println("Which room would you like?(Enter the corresponding number to the room you would like)");
            System.out.println("1.Regular Room");
            System.out.println("2.Presidential Suite");
            System.out.println("3.Snowden Suite");
            System.out.println("Enter room option number: ");

            int roomOption = in3.nextInt();
            in3.nextLine();
            if (roomOption == 1 && guestNumber <= 3) {
                RegularRoom room = new RegularRoom(guestName,guestNumber,numOfDays,checkInDate);
                hotelRooms.add(room);
                room.printReceipt();
            }
            else if (roomOption == 2 && guestNumber <= 5) {
                PresidentialSuite room = new PresidentialSuite(guestName,guestNumber,numOfDays,checkInDate);
                hotelRooms.add(room);
                room.printReceipt();
            }
            else if (roomOption == 3) {
                SnowdenSuite room = new SnowdenSuite(guestName,guestNumber,numOfDays,checkInDate);
                hotelRooms.add(room);
                room.printReceipt();

            }

        }
        else{
            System.out.println("We apologize but we have no rooms that can fit this capacity.");
        }

    }
    public void listGuests(){
        System.out.println("Current Reservations: \n");
        for (Room room: hotelRooms) {
            System.out.println(room + "\n");
        }
    }

    public void findReservation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the reservation number for the reservation you would like to find : ");
        int reservationNumber = in.nextInt();
        List<Room> rooms = hotelRooms.stream()
                .filter(room -> room.getReservationNumber() == reservationNumber)
                .collect(Collectors.toList());
        System.out.println(rooms.get(0) + "\n");
    }



}
