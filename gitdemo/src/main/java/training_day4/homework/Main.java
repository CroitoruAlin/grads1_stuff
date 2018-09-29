package training_day4.homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int sumOfNumbers(int numberOfRetries)
    {
        Scanner scanner=new Scanner(System.in);
        String toRead;
        Integer sum=0;
        Integer number;
        while(!(toRead=scanner.next()).equals("$"))
        {
            try {
                number = Integer.parseInt(toRead);
                sum+=number;
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Please enter an Integer");
                numberOfRetries--;
                System.out.println("Number of tries remaining"+ numberOfRetries);
            }
            finally {
                if(Integer.valueOf(numberOfRetries).equals(0))
                    return sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        Calculator calculator=new Calculator();
//        List<Integer> listNumbers=new ArrayList<Integer>();
//        listNumbers.add(2);
//        listNumbers.add(Integer.MAX_VALUE);
//        try {
//            System.out.println(calculator.add(Integer.MIN_VALUE,-22));
//
//        } catch (OverFlowException e) {
//            System.out.println(e.toString());;
//        } catch (UnderflowException e) {
//            System.out.println(e.toString());
//        }
//        try {
//            System.out.println(calculator.divide(2, 0));
//        }
//        catch(ArithmeticException ex)
//        {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            System.out.println(calculator.mean(listNumbers));
//        } catch (OverFlowException e) {
//            System.out.println(e.toString());
//        } catch (UnderflowException e) {
//            System.out.println(e.toString());
//        }
        System.out.println(sumOfNumbers(3));

        }
}
