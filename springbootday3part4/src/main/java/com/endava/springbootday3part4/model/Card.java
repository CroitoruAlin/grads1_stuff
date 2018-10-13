package com.endava.springbootday3part4.model;

public class Card {
    private int id;
    private String pan;
    private Integer userId;

    public Card() {
    }

    public Card(int id, String pan, Integer userId) {
        this.id = id;
        this.pan = pan;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
