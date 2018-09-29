package java8.interfaces.staticAndDefaultMethods;

public class ClassImplementsDefaultInterface implements InterfaceWithDefaultMethodExample {
    @Override
    public String getInfo() {
        return "Other message";
    }
}
