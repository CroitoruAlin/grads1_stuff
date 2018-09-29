package training_day4.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SquareRoot {

    public static void displaySquareRoot(String numberString) throws CustomSquareRootException
    {
        Double number= Double.parseDouble(numberString);
        System.out.println(number);
        if(number<0)
            throw new CustomSquareRootException();
        else
            System.out.println(Math.sqrt(number));
    }

    public static Integer readAndDivide() throws InputMismatchException,ArithmeticException
    {
        Scanner sc=new Scanner(System.in);

        try {
            System.out.println("x=");
            Integer x = Integer.parseInt(sc.next());
            System.out.println("y=");
            Integer y = Integer.parseInt(sc.next());
            if(y.equals(0))
                throw new ArithmeticException("Can not divide by 0");
            return x/y;

        }
        catch (NumberFormatException exception)
        {
            throw new InputMismatchException("Please give Integer numbers");
        }
    }

    public static void main(String[] args) {
//        try {
//            displaySquareRoot("0.64");
//        } catch (CustomSquareRootException e) {
//            System.out.println(e.toString());
//        }
        try {
            System.out.println(readAndDivide());
        }
        catch (InputMismatchException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (ArithmeticException aex)
        {
            System.out.println(aex.getMessage());
        }
    }

}
