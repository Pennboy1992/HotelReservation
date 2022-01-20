package com.Hotel;

import com.Hotel.Room.PresidentialSuite;
import com.Hotel.Room.RegularRoom;
import com.Hotel.Room.Room;
import com.Hotel.Room.SnowdenSuite;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Hotel {
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
        System.out.println("May we have your name for this reservation today:  ");
        String guestName = in.nextLine();

        System.out.println("Thank you, " + nameFormatter(guestName) + "!");

        System.out.println("How many guests can we expect for this reservation?:  ");
        int guestNumber = in2.nextInt() + 1;
        in2.nextLine();
        if (guestNumber > 7) {
            System.out.println("We apologize but we have no rooms that can fit this capacity.");
            System.out.println("Please come back when you need less guests accommodated");
            adminPortal();

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
        System.out.println("What day will you be joining us?(Please enter date in yyyy-mm-dd format)");
        String checkInDate = in4.nextLine();
        if(checkInDate.length()<10){
            Scanner in6 = new Scanner(System.in);
            System.out.println("Please enter a proper date: yyyy-mm-dd ");
            checkInDate= in6.nextLine();
        }

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

    public Room findReservation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the reservation number for the reservation you would like to find : ");
        int reservationNumber = in.nextInt();
        List<Room> rooms = hotelRooms.stream()
                .filter(room -> room.getReservationNumber() == reservationNumber)
                .collect(Collectors.toList());
        System.out.println(rooms.get(0) + "\n");
        return rooms.get(0);
    }
    public void cancelReservation(){
//        int numToCancel = findReservation().getReservationNumber();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the reservation number for the reservation you'd like to cancel: ");
        int numToCancel = in.nextInt();

        List<Room> rooms = hotelRooms.stream()
                .filter(room -> room.getReservationNumber() == numToCancel)
                .collect(Collectors.toList());
        if(rooms.size() > 0){
            Room room = rooms.get(0);
            System.out.println("We're sorry to see you go, "+nameFormatter(room.getGuestName()));
            System.out.println("We've refunded your payment of $"+String.format("%,.2f",room.calculateCost())+"\n");
        }
        else{
            System.out.println("We didn't find a reservation for the number provided.");
        }
        hotelRooms.removeIf(room -> room.getReservationNumber() == numToCancel);
    }
    public String nameFormatter(String str){
        String[] names = str.split("\\s");
        String capitalizeName = "";
        for(String w: names){
            String first = w.substring(0, 1);
            String last = w.substring(1);
            capitalizeName+= first.toUpperCase() + last + " ";
        }
        return capitalizeName.trim();
    }
    public void adminPortal(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Hacker Suite Admin Portal!");
            System.out.println("1. Make a reservation\n2. Find a Reservation\n3. Cancel Reservation\n4.List Reservations\n5.Exit portal");
            System.out.println("Please enter the corresponding number for the following options: ");
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
               makeReservation();
            }
            else if (choice == 2) {
                findReservation();
            }
            else if (choice == 3){
                cancelReservation();
            }
            else if (choice == 4) {
               listGuests();
            }
            else if (choice == 5) {
                System.out.println("Thanks for choosing Hacker Suite! Have a great day!!");
                break;
            }

    }

}}
