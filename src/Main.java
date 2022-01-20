import com.Hotel.HackerSuite;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        HackerSuite hacker = new HackerSuite();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Hacker Suite Admin Portal!");
        System.out.println("1. Make a reservation\n2. Find a Reservation\n3. Cancel Reservation\n4.List Reservations\n5.Exit portal");
            System.out.println("Please enter the corresponding number for the following options: ");
        int choice = in.nextInt();
            in.nextLine();
        if (choice == 1) {
            hacker.makeReservation();
        }
        else if (choice == 2) {
            hacker.findReservation();
        }
        else if (choice == 4) {
            hacker.listGuests();
        }
        else if (choice == 5) {
            System.out.println("Thanks for choosing Hacker Suite! Have a great day!!");
            break;
        }
    }
    }
}





