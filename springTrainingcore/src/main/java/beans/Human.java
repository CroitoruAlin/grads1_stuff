package beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {


    @Autowired
    private Baterie baterie;
    @Autowired
    private Mouse mouse;

    public Baterie getBaterie() {

        return baterie;
    }

    public void setBaterie(Baterie baterie) {
        this.baterie = baterie;
    }


    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
