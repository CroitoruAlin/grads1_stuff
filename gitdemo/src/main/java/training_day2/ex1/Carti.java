package training_day2.ex1;

public class Carti {

    private String title;

    public Carti(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Carti{" +
                "title='" + title + '\'' +
                '}';
    }
}
