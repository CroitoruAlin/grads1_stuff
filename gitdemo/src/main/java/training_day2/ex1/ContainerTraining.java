package training_day2.ex1;

public class ContainerTraining {
    private Object element;

    public Object loadContainer(Object stuffToLoad)
    {
        element=stuffToLoad;
        return element;
    }
    public void emptyContainer()
    {
        element=null;

    }
}
