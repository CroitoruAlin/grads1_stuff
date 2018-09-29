package training_day2.ex1;

public class Elefant implements Animal{

    private String name;

    public Elefant(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Elefant{" +
                "name='" + name + '\'' +
                '}';
    }
}
