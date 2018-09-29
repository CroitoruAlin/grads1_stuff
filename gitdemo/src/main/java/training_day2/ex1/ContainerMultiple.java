package training_day2.ex1;


public class ContainerMultiple<T extends Animal> {//extends este folosit si pentru interfete si pentru clase
                                                  //extends se foloseste pentru tipurile care sunt sub animal

    private T obiect;

    public ContainerMultiple(T obiect) {
        this.obiect = obiect;
    }
    public ContainerMultiple()
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
