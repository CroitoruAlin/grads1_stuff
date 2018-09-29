package java8.interfaces.staticAndDefaultMethods;

public class Main {
    public static void main(String[] args) {
        InterfaceWithDefaultMethodExample classImplementsDefaultInterface=new ClassImplementsDefaultInterface();
        System.out.println(classImplementsDefaultInterface.getInfo());

        System.out.println(InterfaceWithStaticMethodExample.producer());
    }
}
