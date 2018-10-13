package com.endava.springbootday3part5.model;

public class Card {
    private int id;
    private String pan;
    private int userId;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", pan='" + pan + '\'' +
                ", userId=" + userId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
