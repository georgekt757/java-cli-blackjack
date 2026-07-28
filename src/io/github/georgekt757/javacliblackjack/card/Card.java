package io.github.georgekt757.javacliblackjack.card;

public class Card {
    private String face;
    private String suit;
    private int value;

    public Card(String face, String suit, int value) {
        this.face = face;
        this.suit = suit;
        this.value = value;
    }

    public String getFace() {
        return this.face;
    }
    public void setFace(String face) {
        this.face = face;
    }

    public String getSuit() {
        return this.suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
