package entities;

import java.util.List;

public class Card {
    private String pan;
    private List<Transaction> transactionList;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
