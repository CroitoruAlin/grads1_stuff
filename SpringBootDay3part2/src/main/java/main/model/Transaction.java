package main.model;

public class Transaction {
    private String transactionNo;
    private Double amount;

    public Transaction(String transactionNo, Double amount) {
        this.transactionNo = transactionNo;
        this.amount = amount;
    }

    public Transaction() {
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
