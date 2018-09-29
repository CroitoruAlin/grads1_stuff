package training_day4.homework;


import java.util.Collection;

public interface IntegerOperations {

    Integer add(Integer a,Integer b) throws OverFlowException, UnderflowException;
    Double divide(Integer a, Integer b);
    Double mean(Collection<? extends Integer> listOfNumbers) throws OverFlowException, UnderflowException;
}
