package com.endava.springbootday3part5.proxy;

import com.endava.springbootday3part5.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CardServiceProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${grads.url.client.service}")
    private String cardServiceUrl;
    @Value("${grads.url.post.card.user}")
    private String urlCardPost;

    public Card getRemoteCard(String pan)
    {
        return restTemplate.getForObject("http://localhost:8090/card/get/",Card.class,pan);
    }


    public List<Card> getCardsOfUser(int id) {
       ResponseEntity<List<Card>> responseEntity=restTemplate.exchange(cardServiceUrl+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Card>>() {
        });
       return responseEntity.getBody();
    }

    public void saveCard(Card card) {
        restTemplate.postForObject(urlCardPost,card,Card.class);
    }
}
