package model;

public class Transaction {
    private int id;
    private double amount;
    private int card_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int user_id) {
        this.card_id = user_id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", card_id=" + card_id +
                '}';
    }
}
