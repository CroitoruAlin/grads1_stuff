package training_day2.ex1;


public class MultipleContainer<T,U> {

    private T obiect;
    private U quantity;

    public U getQuantity() {
        return quantity;
    }

    public void setQuantity(U quantity) {
        this.quantity = quantity;
    }

    public MultipleContainer(T obiect) {
        this.obiect = obiect;
    }
    public MultipleContainer()
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
