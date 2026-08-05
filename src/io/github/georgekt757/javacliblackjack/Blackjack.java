package io.github.georgekt757.javacliblackjack;

import io.github.georgekt757.javacliblackjack.cardusers.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Blackjack {

    public Player initialisePlayer(Scanner kbd) {
        // This method creates the player through use of the Scanner object, with validation
        // via try-catch blocks for the numerical values to ensure the program does not crash
        String name;
        int bet = 0, pot = 0;
        final int MINIMUM = 10; // Change this value if you wish to alter the minimum starting value
        boolean waiter = true;
        
        System.out.print("What is your name?: ");
        name = kbd.nextLine();
        
        System.out.println("Next comes inputting how much money you have and are willing to gamble, and how much of it you are betting each round.\nBoth must be a multiple of five.");
        while (waiter) {
            try {
                // Player inputs their pot here, and it is validated to ensure it is always an integer
                // and is valid to the constraints given
                System.out.print("How much money are you willing to gamble?: ");
                pot = kbd.nextInt();

                if (pot < MINIMUM) {
                    System.out.println("You're have too little money!");
                } else if (pot % 5 != 0) {
                    System.out.println("The pot must be a multiple of five!");
                } else {
                    waiter = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("You need to input a valid whole number!");
            }
        }

        waiter = true;
        while (waiter) {
            try {
                // Player inputs their bet here, and it is validated to ensure it is always an integer
                // and valid to the constraints given
                System.out.print("How much are you betting? (You can change your bet at any time.): ");
                bet = kbd.nextInt();

                if (bet > pot) {
                    System.out.println("You're betting more money than you have!");
                } else if (bet < 5) {
                    System.out.println("Your bet is too low! It must be at least five!");
                } else if (bet % 5 != 0) {
                    System.out.println("Your bet must be a multiple of five!");
                } else {
                    waiter = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("You need to input a valid whole number!");
            }
        }

        return new Player(name, bet, pot);
    }

    public static void printHelpMsg() {
        System.out.println("This game is currently in development. More details on how to play will come as");
        System.out.println("they are implemented, but keep in mind it'll asume you already know how to play\nBlackjack.");
    }

    public static String mainMenu(Scanner kbd) {
        String choice;
        
        System.out.println(" << Blackjack CLI PRE-ALPHA >>");
        System.out.println("Don't ask what happened to the first one!");
        System.out.println("\nWelcome to Blackjack CLI, a blackjack game played on the command-line interface! If you didn't figure that out, God save you!");
        
        while(true) {
            System.out.print("What do you wish to do?:\n1. Start\n2. How to play\n3. Quit\n>");
            choice = kbd.nextLine();

            switch (choice) {
                case "1":
                    return "start";
                case "2":
                    printHelpMsg();
                    break;
                case "3":
                    return "quit";
                default:
                    System.out.println("Please enter a valid option!\n");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String choice;

        choice = mainMenu(kbd);
    }
}
