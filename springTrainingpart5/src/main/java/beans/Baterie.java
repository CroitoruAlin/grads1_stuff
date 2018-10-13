package beans;

public class Baterie {
    private double voltaj;

    public double getVoltaj() {
        return voltaj;
    }

    public void setVoltaj(double voltaj) {
        this.voltaj = voltaj;
    }

    @Override
    public String toString() {
        return "Baterie{" +
                "voltaj=" + voltaj +
                '}';
    }
}
