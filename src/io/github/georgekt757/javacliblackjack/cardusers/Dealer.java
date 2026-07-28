package io.github.georgekt757.javacliblackjack.cardusers;

public class Dealer extends CardUser {
    private int bank;

    public Dealer() {
        super();
        this.bank = 10000;
    }

    public int getBank() {
        return this.bank;
    }
    public void setBank(int bank) {
        this.bank = bank;
    }
}
