package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component//nu mai e nevoie de bean in clasa de configurare dar avem nevoie in clasa de configurare de anotatia @ComponentScan caruia ii specificam
//pachetul in care sa scaneze dupa Component

public class Mouse {

    @Autowired
    private Baterie baterie;
    private String culoare;

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public Baterie getBaterie() {
        return baterie;
    }

    public void setBaterie(Baterie baterie) {
        this.baterie = baterie;
    }
}
