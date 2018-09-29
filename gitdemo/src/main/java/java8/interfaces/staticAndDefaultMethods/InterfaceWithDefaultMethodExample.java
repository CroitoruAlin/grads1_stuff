package java8.interfaces.staticAndDefaultMethods;

public interface InterfaceWithDefaultMethodExample {

    //TODO try to call this method
    default String getInfo() {
        return "default info";
    }
}