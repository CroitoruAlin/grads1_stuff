package training_day4.homework;

import java.util.Collection;

public class Calculator implements IntegerOperations{


    public Integer add(Integer a, Integer b) throws OverFlowException,UnderflowException {

        Integer sum=a+b;
        if((sum^a)<0 && (sum^b)<0)
            if(a<0)
                throw new UnderflowException();
            else
                if(a>0)
                    throw new OverFlowException();
        return sum;


    }

    public Double divide(Integer a, Integer b) throws ArithmeticException{
        if(b.equals(0))
            throw new ArithmeticException("Can not divide by 0");
        return Double.valueOf(a/b);
    }

    public Double mean(Collection<? extends Integer> listOfNumbers) throws OverFlowException, UnderflowException {
        Integer sum=0;
        for(Integer number:listOfNumbers)
            sum=add(number,sum);
        return Double.valueOf(sum)/Double.valueOf(listOfNumbers.size());


    }
}
