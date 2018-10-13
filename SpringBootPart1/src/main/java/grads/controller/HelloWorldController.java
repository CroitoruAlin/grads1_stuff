package grads.controller;


import grads.model.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // nu mai mapeaza fisierul static cu string-ul pe care il returneaza metoda, ca la controller,RestController<=>Controller
// +ResponseBody
//@Controller
//@ResponseBody- mapeaza raspunsul cu un json by default, cu jar jackson din libraries
public class HelloWorldController {

    @RequestMapping(value = "/",method = RequestMethod.GET)//mapeaza o cale cu actiunea, implicit raspunde la request-uri de tip Get
    public Cat helloGrads(){
        return new Cat("Tom","rosie") ;
    }
    @PostMapping(value = "/cat")
    public void postCat(@RequestBody Cat cat)
    {
        System.out.println(cat.getNume());
    }

}
