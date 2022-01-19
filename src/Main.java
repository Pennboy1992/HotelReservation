import com.Hotel.Room.RegularRoom;
import com.Hotel.Room.Room;
import com.Hotel.Room.SnowdenSuite;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        StringBuilder options = new StringBuilder();

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Hacker's Suite Hotel!");
        System.out.println("May we have your name for this reservation today:  ");
        String guestName = in.nextLine();
        System.out.println("Thank you, " + guestName + "!");
        Scanner in2 = new Scanner(System.in);
        System.out.println("How many guests can we expect for this reservation?:  ");
        int guestNumber = in2.nextInt() + 1;
        if(guestNumber > 7){
            System.out.println("We apologize but we have no rooms that can fit this capacity.");
        }
        else if(guestNumber > 5 && guestNumber <= 7){
            System.out.println("We recommend going with the Snowden Suite.");
            options.append("Snowden Suite");
        }
        else if(guestNumber > 3 && guestNumber <= 5){
            System.out.println("We recommend going with the Presidential Suite");
            options.append("Presidential Suite, ");
            options.append("Snowden Suite");
        }
        else if(guestNumber >= 1 && guestNumber <= 3){
            System.out.println("We recommend you use the Regular Rooms.");
            options.append("Regular Room, ");
            options.append("Presidential Suite, ");
            options.append("Snowden Suite");
        }
        System.out.println("You are eligible for:  " + options);
//


//        boolean capacity = guestNumber <= 7;
//        if(capacity)
//        {
//            System.out.println("You are eligible for:  " + options);
//            System.out.println("Which room would you like?(Enter the corresponding number to the room you would like)");
//            System.out.println("1.Regular Room");
//            System.out.println("2.Presidential Suite");
//            System.out.println("3.Snowden Suite");
//            Scanner in3 = new Scanner(System.in);
//            int roomOption = in3.nextInt();
//        }
//        else{
//            System.out.println("We apologize but we have no rooms that can fit this capacity.");
//        }

         Scanner in4 = new Scanner(System.in);
        System.out.println("What day will you be joining us?(Please enter date in yyyy-mm-dd format");
        String checkInDate = in4.nextLine();
        Scanner in5 = new Scanner(System.in);
        System.out.println("Now how many days will you be staying with us?");
        int numOfDays = in5.nextInt();

        Room edward = new SnowdenSuite(guestName,guestNumber,numOfDays,checkInDate);
        printReceipt(edward);
        in.close();
        in2.close();
        in4.close();
        in5.close();





 /*
        int num = -1;
        while (num > 0 || num < 0) {
            num = in.nextInt();
            System.out.println("***************************************************************************************");
            System.out.println("Welcome to the Hacker's Hotel Application");
            System.out.println("***************************************************************************************");
            System.out.println("Please type in the number corresponding to the option you'd like.");
            System.out.println("***************************************************************************************");

            System.out.println("Please type in 1 and press ENTER to) Reserve a spot in the Hacker's Hotel");

            System.out.println("Please type in 2 and press ENTER to) To update your reservation if needed");

            System.out.println("Please type in 3 and press ENTER to) To show all current residents or reservations");

            System.out.println("Please type in 0 and press ENTER to) exit the application");

            System.out.println("***************************************************************************************");


            if (num == 0) {

                System.out.println("Thank you for using the the Hacker's Hotel application, we hope you have a good day!");

                break;
            }

            if(num == 1){

            }

            if(num == 2){

            }

            if(num == 3){

            }


        }

        */
    }

    public static void printReceipt(Room rom) {
        System.out.println("Thank you for making your reservation with us at the Hacker Suite Hotel "+ rom.getGuestName() + ".");
        System.out.println("You will be staying in one of our " + rom.getRoomName() + "s accompanied by " + (rom.getGuestNumber() - 1) + " guest(s)");
        System.out.println("Your check in date will be " + rom.getCheckInDate() + " and your checkout date will be " + rom.getCheckOutDate() + ".");
        String total = String.format("%,.2f",rom.calculateCost());
        System.out.println("Your total for this reservation will be " + total + " and will be due on: " + rom.getCheckInDate() + ".");
    }

}