package model;

import org.springframework.stereotype.Component;

@Component//face exact acelasi lucru ca si bean din clasa de configurare
public class Baterie {
    private double voltaj;

    public double getVoltaj() {
        return voltaj;
    }

    public void setVoltaj(double voltaj) {
        this.voltaj = voltaj;
    }
}
