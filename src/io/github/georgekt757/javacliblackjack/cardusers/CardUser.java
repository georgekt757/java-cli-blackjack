package io.github.georgekt757.javacliblackjack.cardusers;

import io.github.georgekt757.javacliblackjack.card.Card;
import java.util.ArrayList;

abstract class CardUser {
    private int wins;
    private int losses;
    private ArrayList<Card> hand;

    public CardUser() {
        this.wins = 0;
        this.losses = 0;
        this.hand = new ArrayList<>();
    }

    public int getWins() {
        return this.wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return this.losses;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void win() {
        this.wins += 1;
    }
    
    public void lose() {
        this.losses += 1;
    }

    public void resetCards() {
        this.hand.clear();
    }
}

class Player extends CardUser {
    private final String name;
    private int bet;
    private int pot;
    private final int initialPot;

    public Player(String name, int bet, int pot) {
        super();
        this.name = name;
        this.bet = bet;
        this.pot = pot;
        this.initialPot = pot;
    }

    public String getName() {
        return this.name;
    }

    public int getBet() {
        return this.bet;
    }
    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getPot() {
        return this.pot;
    }
    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getInitialPot() {
        return this.initialPot;
    }
}
