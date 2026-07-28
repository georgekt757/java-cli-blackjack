package io.github.georgekt757.javacliblackjack.cardusers;

public class Player extends CardUser {
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
