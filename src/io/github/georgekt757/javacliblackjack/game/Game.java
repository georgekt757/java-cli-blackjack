package io.github.georgekt757.javacliblackjack.game;

import io.github.georgekt757.javacliblackjack.cardusers.Dealer;
import io.github.georgekt757.javacliblackjack.cardusers.Player;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {
    private final Player player;
    private final Dealer dealer;
    private Scanner kbd;

    public Game(Scanner kbd) {
        this.player = initialisePlayer(kbd);
        this.dealer = new Dealer();
        this.kbd = kbd;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

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
                    System.out.println("You have too little money!");
                } else if (pot % 5 != 0) {
                    System.out.println("The pot must be a multiple of five!");
                } else {
                    waiter = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("You need to input a valid whole number!");
                kbd.next(); // Consumes invalid input to prevent an infinite loop
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
                kbd.next(); // Consumes invalid input to prevent an infinite loop
            }
        }

        return new Player(name, bet, pot);
    }
}
