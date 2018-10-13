package main.model;

public class Card {
    private String pan;

    public Card(String pan) {
        this.pan = pan;
    }

    public Card() {
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
