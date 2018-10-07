package debugging.excercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excercise1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
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
