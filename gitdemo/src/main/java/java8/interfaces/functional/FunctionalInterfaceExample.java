package java8.interfaces.functional;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        //TODO instantiate as an inner class
        Foo fooByIC= new Foo() {
            @Override
            public void method(String string) {
                System.out.println(string);
            }
        };
        Foo fooByIc2=new Foo() {
            @Override
            public void method(String string) {
                System.out.println(string+" "+string);
            }
        };
        fooByIC.method("test");
        fooByIc2.method("test");

        //TODO call testFunctional with fooByIC
        testFunctional("test2",fooByIc2);
        //TODO call testFunctional with a lambda
        testFunctional("test3",s-> System.out.println(s.toUpperCase()+"lambda"));
        //TODO call testFunctional with a different lambda
        testFunctional("4",s-> {
            try {


                Integer number = Integer.parseInt(s);
                System.out.println(number*number);
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Not a number");
            }

        });
        testFunctional(2,3,(a,b)->a+b);


    }

    public static void testFunctional(String s, Foo foo) {
        foo.method(s);
    }
    public static void testFunctional(int a,int b, Multiple foo) {
        System.out.println(foo.ceva(a,b));
    }
}

//Any interface with a Single Abstract Method is a functional interface
@FunctionalInterface
interface Foo {
    //TODO try to comment the next line
    void method(String string);

    //TODO try to create another abstract method
// void method2(String string);
    //TODO try to create a default method
    default void method3(String string)
    {
        System.out.println(string);
    }
    //TODO create another functional interface and try to extend this one

    //TODO create an empty interface and extend this one
}
@FunctionalInterface
interface Bar extends Foo{

    //void method1();
    //void method(String string);

}

@FunctionalInterface
interface Buz extends Foo,Bar//daca extindea 2 interfete functionale cu metode abstracte diferite atunci asta nu mai era functionala
{

}
@FunctionalInterface
interface Multiple
{
    int ceva(int a,int b);
}