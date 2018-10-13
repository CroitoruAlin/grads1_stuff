package model;

public class UserDetails {
    private String username;
    private String password;
    private String pan;
    private double amount;

    @Override
    public String toString() {
        return "UserDetails{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pan='" + pan + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
