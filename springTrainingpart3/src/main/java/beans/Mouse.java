package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Mouse {


    private Baterie baterie;
    private String culoare;
    //@Autowired //injectarea se face pe param constructorului
                //Autowired nu merge pe o proprietate final, putem face injectarea punand autowired peste constructor
    public Mouse(Baterie baterie) {
        this.baterie = baterie;
    }

    public Mouse() {
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public Baterie getBaterie() {
        return baterie;
    }
    @Autowired//spring va injecta valoarea in param si va si apela constructorul
    public void setBaterie(Baterie baterie) {
        this.baterie = baterie;
    }
}
