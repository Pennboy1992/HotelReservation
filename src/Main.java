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


        boolean capacity = guestNumber <= 7;
        if(capacity)
        {
            System.out.println("You are eligible for:  " + options);
            System.out.println("Which room would you like?(Enter the corresponding number to the room you would like)");
            System.out.println("1.Regular Room");
            System.out.println("2.Presidential Suite");
            System.out.println("3.Snowden Suite");
            Scanner in3 = new Scanner(System.in);
            int roomOption = in3.nextInt();
        }
        else{
            System.out.println("We apologize but we have no rooms that can fit this capacity.");
        }


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

}