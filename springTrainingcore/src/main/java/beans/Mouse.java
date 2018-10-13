package beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Mouse {

    @Autowired
    private Baterie baterie;
    private String culoare;

    public Baterie getBaterie() {
        return baterie;
    }

    public void setBaterie(Baterie baterie) {
        this.baterie = baterie;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
}
