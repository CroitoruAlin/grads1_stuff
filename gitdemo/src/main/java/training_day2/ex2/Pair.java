package training_day2.ex2;

public class Pair<T,U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    public void addFirst(T first)
    {
        this.first=first;
    }
    public void addSecond(U second)
    {
        this.second=second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
