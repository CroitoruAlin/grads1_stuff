package debugging.exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

        try(Scanner in = new Scanner(System.in);) {
            System.out.println("Enter a numeric value");
            double a = in.nextDouble();
            if (a > 1234567821)
                throw new Exception();
        }
        catch (InputMismatchException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
