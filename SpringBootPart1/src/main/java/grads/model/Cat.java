package grads.model;

public class Cat {
    private String nume;
    private String color;

    public Cat() {
    }

    public Cat(String nume, String color) {
        this.nume = nume;
        this.color = color;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
