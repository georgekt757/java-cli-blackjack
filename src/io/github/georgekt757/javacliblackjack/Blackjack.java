package io.github.georgekt757.javacliblackjack;

import io.github.georgekt757.javacliblackjack.cardusers.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Blackjack {

    public Player initialisePlayer(Scanner kbd) {
        String name;
        int bet = 0, pot = 0;
        boolean waiter = true;
        
        System.out.print("What is your name?: ");
        name = kbd.nextLine();

        System.out.println("Next comes inputting how much money you have and are willing to gamble, and how much of it you are betting.\nBoth must be a multiple of five.");
        while (waiter) {
            try {
                System.out.print("How much money are you willing to gamble?: ");
                pot = kbd.nextInt();

                if (pot < 10) {
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
                System.out.print("How much are you betting? (You can change your bet at any time.): ");
                bet = kbd.nextInt();

                if (bet > pot) {
                    System.out.println("You're betting more money than you have!");
                } else if (bet < 5) {
                    System.out.println("Your bet is too low! It must be at least five!");
                } else if (bet % 5 != 0) {
                    System.out.println("The pot must be a multiple of five!");
                } else {
                    waiter = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("You need to input a valid whole number!");
            }
        }

        return new Player(name, bet, pot);
    }

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
    }
}
