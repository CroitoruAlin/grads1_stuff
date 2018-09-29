package exceptions;

public class ExceptionHandlerExample {

    public static void method1() throws Exception {
        System.out.println("Method 1");
        throw new Exception("exception 1");
    }

    public static void method2() throws ArrayIndexOutOfBoundsException {
        System.out.println("Method 2");
        throw new ArrayIndexOutOfBoundsException("exception 2");
    }

    public static int getInt() {
        try {
            String[] students = {"Stan", "Bran"};
            System.out.println(students[4]);
        } catch (Exception e) {
            return 1;
        } finally {
            System.out.println("In finally");
        }

        System.out.println("After the try block");
        return 0;
    }

    public static int getInt2() {
        try {
            String[] students = {"Stan", "Bran"};
            System.out.println(students[4]);
        } catch (Exception e) {
            System.out.println("catchy!!!");
            return 10;
        } finally {
            System.out.println("In finally");
            return 20;
        }

    }

    public static int getInt3() {
        int value = 1;
        try {
            String[] students = {"Stan", "Bran"};
            System.out.println(students[4]);
        } catch (Exception e) {
            value = 10;
            System.out.println("catch value is  " + value);
            return value;
        } finally {
            value = 20;
            System.out.println("In finally " + value);
        }

        return value;
    }


    public static void main(String[] args)  {
        System.out.println(getInt());
        System.out.println(getInt2());
        System.out.println(getInt3());
        try {
            System.out.println("try me please!!!please!!!!");
        } catch (Exception e) {
            method2();
        } finally {
            System.out.println("finally 1");
            System.out.println("finally 2");
            System.out.println("finally 3");
        }
    }
}
