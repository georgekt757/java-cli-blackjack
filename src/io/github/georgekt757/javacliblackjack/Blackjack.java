package io.github.georgekt757.javacliblackjack;

import io.github.georgekt757.javacliblackjack.game.Game;
import java.util.Scanner;

public class Blackjack {

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

        while(true) {
            choice = mainMenu(kbd);

            switch (choice) {
            case "start":
                Game game = new Game(kbd);
                break;
            case "quit":
                System.exit(0);
            }
        }
    }
}
