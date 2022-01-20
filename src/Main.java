import com.Hotel.Room.PresidentialSuite;
import com.Hotel.Room.RegularRoom;
import com.Hotel.Room.Room;
import com.Hotel.Room.SnowdenSuite;
import com.Hotel.Hotel;
import com.Hotel.HackerSuite;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        HackerSuite hacker = new HackerSuite();
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        Scanner in4 = new Scanner(System.in);
        Scanner in5 = new Scanner(System.in);



        while(true) {
            StringBuilder options = new StringBuilder();
            System.out.println("Welcome to the Hacker's Suite Hotel!");
            System.out.println("May we have your name for this reservation today:  ");
            String guestName = in.nextLine();
            in.nextLine();

            System.out.println("Thank you, " + guestName + "!");


            System.out.println("How many guests can we expect for this reservation?:  ");
            int guestNumber = in2.nextInt() + 1;
            in2.nextLine();
            if (guestNumber > 7) {
                System.out.println("We apologize but we have no rooms that can fit this capacity.");

            } else if (guestNumber > 5 && guestNumber <= 7) {
                System.out.println("We recommend going with the Snowden Suite.");
                options.append("Snowden Suite");

            } else if (guestNumber > 3 && guestNumber <= 5) {
                System.out.println("We recommend going with the Presidential Suite");
                options.append("Presidential Suite, ");
                options.append("Snowden Suite");

            } else if (guestNumber >= 1 && guestNumber <= 3) {
                System.out.println("We recommend you use the Regular Rooms.");
                options.append("Regular Room, ");
                options.append("Presidential Suite, ");
                options.append("Snowden Suite");

            }
            System.out.println("What day will you be joining us?(Please enter date in yyyy-mm-dd format");
            String checkInDate = in4.nextLine();
            in4.nextLine();

            System.out.println("Now how many days will you be staying with us?");
            int numOfDays = in5.nextInt();
            in5.nextLine();


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
                    hacker.makeReservation(new RegularRoom(guestName,guestNumber,numOfDays,checkInDate));
                }
                else if (roomOption == 2 && guestNumber <= 5) {
                    hacker.makeReservation(new PresidentialSuite(guestName,guestNumber,numOfDays,checkInDate));
                }
                else if (roomOption == 3 && guestNumber <= 7) {
                    hacker.makeReservation(new SnowdenSuite(guestName,guestNumber,numOfDays,checkInDate));
                }

            }
            else{
                System.out.println("We apologize but we have no rooms that can fit this capacity.");
            }


        }



    }

}