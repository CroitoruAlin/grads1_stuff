package training_day2.ex1;


public class Container<T> {

    private T obiect;

    public Container(T obiect) {
        this.obiect = obiect;
    }
    public Container()
    {
        this.obiect=null;
    }
    public void addObject(T obiect)
    {
        this.obiect=obiect;
    }
    public void empty()
    {
        obiect=null;
    }

    public T getObiect() {
        return obiect;
    }
}
