package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Mouse {

    @Autowired //atributul required spune ca din context daca nu exista nici un bean sa nu instantieze campul resp
    @Qualifier("baterie1")//ii spunem ce bean sa ia dupa nume
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
