package main.service;

import main.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardRestService {

    @Autowired
    private RestTemplate restTemplate;
    public Card getCard()
    {
        return restTemplate.getForObject("http://localhost:8080/card", Card.class, "");//null in loc de requestParam
    }

}
