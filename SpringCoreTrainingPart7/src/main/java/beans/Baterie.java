package beans;

public class Baterie {
    private double voltaj;

    public Baterie() {
    }

    public Baterie(double voltaj) {
        this.voltaj = voltaj;
    }

    public double getVoltaj() {
        return voltaj;
    }

    public void setVoltaj(double voltaj) {
        this.voltaj = voltaj;
    }


    public void init()
    {
        System.out.println("S-a initializat beanul");

    }
    public void destroy()
    {
        System.out.println("S-a distrus beanul");
    }
}
