package training_day2.Main;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import training_day2.ex1.GenericContainerMultipleBounds;
import training_day2.ex1.Leu;


import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        GenericContainerMultipleBounds<Leu> multipleBounds=new GenericContainerMultipleBounds<Leu>();


        List<? super Number> list=new ArrayList<Object>();
        list.add(new Integer(2));
        //list.add(new Object());
    }
}
