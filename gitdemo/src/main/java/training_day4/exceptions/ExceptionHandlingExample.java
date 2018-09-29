package training_day4.exceptions;

public class ExceptionHandlingExample {
    public static void method1() throws Exception {
        System.out.println("Method1");
        throw new Exception("Exception1");

    }
    public static void method2() throws ArrayIndexOutOfBoundsException {
        System.out.println("Method2");
        throw new ArrayIndexOutOfBoundsException("exception2");

    }


    public static void main(String[] args) throws Exception {

        try {
            method1();
        } catch (Exception e) {
            method2();
        }
        /*catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }unreachable code*/
        finally {
            System.out.println("sout1");
            System.out.println("sout2");
            System.out.println("sout3");



        }
    }
}
