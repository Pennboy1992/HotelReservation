package com.Hotel;

import com.Hotel.Room.PresidentialSuite;
import com.Hotel.Room.RegularRoom;
import com.Hotel.Room.Room;
import com.Hotel.Room.SnowdenSuite;
import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    private Collection<Room> hotelRooms = new ArrayList<>();
    private String hotelName;

    //constructor with just hotelName
    public Hotel(String hotelName){
        setHotelName(hotelName);
    }

    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public void makeReservation(){
        //user input for various things like names, guest numbers
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        Scanner in4 = new Scanner(System.in);
        Scanner in5 = new Scanner(System.in);

        //options checks for rooms you are eligible for, takes in desired guest number and tells you rooms eligible for
        StringBuilder options = new StringBuilder();
        System.out.println("May we have your name for this reservation today:  ");
        //induce guest input
        String guestName = in.nextLine();
        //check in case a guest did not input a name
        if(guestName.length() == 0){
            System.out.println("We cannot make a reservation without a name, please come back with a valid one. \n");
            adminPortal();
        }
        //nameFormatter caps the first letter of the name
        System.out.println("Thank you, " + nameFormatter(guestName) + "!");
        //asking guest to input desired guest name + 1 aka him/herself.
        System.out.println("How many guests can we expect for this reservation?:  ");
        int guestNumber = in2.nextInt() + 1;
        //clear the buffer of the scanner so we can do it again.
        in2.nextLine();
        //max guest number can't be more than 7.
        if (guestNumber > 7) {
            System.out.println("We apologize but we have no rooms that can fit this capacity.");
            System.out.println("Please come back when you need less guests accommodated");
            adminPortal();
        } else if (guestNumber > 5) {
            System.out.println("We recommend going with the Snowden Suite.");
            options.append("Snowden Suite");

        } else if (guestNumber > 3) {
            System.out.println("We recommend going with the Presidential Suite.");
            options.append("Presidential Suite, ");
            options.append("Snowden Suite");

        } else if (guestNumber >= 1) {
            System.out.println("We recommend you use the Regular Rooms.");
            options.append("Regular Room, ");
            options.append("Presidential Suite, ");
            options.append("Snowden Suite");
        }
        //ask for check in date, and check for amount of character because we need the proper date format
        System.out.println("What day will you be joining us?(Please enter date in yyyy-mm-dd format)");
        String checkInDate = in4.nextLine();
        if(checkInDate.length()<10){
            Scanner in6 = new Scanner(System.in);
            //if entered incorrectly, ask for date input again
            System.out.println("Please enter a proper date: yyyy-mm-dd ");
            checkInDate= in6.nextLine();
        }
        //ask for days desired input.
        System.out.println("Now how many days will you be staying with us?");
        int numOfDays = in5.nextInt();
        boolean capacity = guestNumber <= 7;
        if(capacity)
        {
            System.out.println("You are eligible for:  " + options);
            System.out.println("Which room would you like?(Enter the corresponding number to the room you would like)");
            if (guestNumber <= 3) {
                System.out.println("1.Regular Room");
                System.out.println("2.Presidential Suite");
                System.out.println("3.Snowden Suite");

            }
            else if (guestNumber > 3 && guestNumber <=5) {
                System.out.println("2.Presidential Suite");
                System.out.println("3.Snowden Suite");
            }
            else if (guestNumber > 5 &&guestNumber <= 7) {
                System.out.println("3.Snowden Suite");
            }


            System.out.println("Enter room option number: ");
            //ask user input for room type
            int roomOption = in3.nextInt();
            in3.nextLine();
            //check for which room type and amount of guest you picked
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
            System.out.println("Thank you for coming to the " + getHotelName());


        }
        else{
            System.out.println("We apologize but we have no rooms that can fit this capacity.");
        }

    }
    //go through all the reservations we created and prints them out
    public void listGuests(){
        System.out.println("Current Reservations: \n");
        for (Room room: hotelRooms) {
            System.out.println(room + "\n");
        }
    }
    //ask for reservation number and either print your reservation or say not found.
    public Room findReservation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the reservation number for the reservation you would like to find : ");
        int reservationNumber = in.nextInt();
        List<Room> rooms = hotelRooms.stream()
                .filter(room -> room.getReservationNumber() == reservationNumber)
                .collect(Collectors.toList());
        if(rooms.size() == 0){
            System.out.println("There are no current reservations for that number. \n" );
            adminPortal();
        }
        System.out.println(rooms.get(0) + "\n");
        return rooms.get(0);
    }
    //ask for reservation number and loop through array, find it and remove it, and tells you we refunded you
    public void cancelReservation(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the reservation number for the reservation you'd like to cancel: ");
        int numToCancel = in.nextInt();

        List<Room> rooms = hotelRooms.stream()
                .filter(room -> room.getReservationNumber() == numToCancel)
                .collect(Collectors.toList());
        if(rooms.size() > 0){
            Room room = rooms.get(0);
            System.out.println("We're sorry to see you go, "+nameFormatter(room.getGuestName()));
            System.out.println("We've refunded your payment of $"+String.format("%,.2f",room.getTotalCost())+"\n");
        }
        else{
            System.out.println("We didn't find a reservation for the number provided. \n");
        }
        hotelRooms.removeIf(room -> room.getReservationNumber() == numToCancel);
    }
    //Upper cases the first letters of your name
    public static String nameFormatter(String str){
        String[] names = str.split("\\s");
        String capitalizeName = "";
        for(String w: names){
            String first = w.substring(0, 1);
            String last = w.substring(1);
            capitalizeName+= first.toUpperCase() + last + " ";
        }
        return capitalizeName.trim();
    }
    // what main calls. greetings, provide a list of things to do,aka a menu
    public void adminPortal(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the " + getHotelName() + " Admin Portal!");
            System.out.println("1. Make a reservation\n2. Find a Reservation\n3. Cancel Reservation\n4. List Reservations\n5. Exit portal");
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
