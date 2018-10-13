package model;

public class CardDetails {
    private String pan;
    private double amount;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double aamount) {
        this.amount = aamount;
    }

    @Override
    public String toString() {
        return "CardDetails{" +
                "pan='" + pan + '\'' +
                ", amount=" + amount +
                '}';
    }
}
