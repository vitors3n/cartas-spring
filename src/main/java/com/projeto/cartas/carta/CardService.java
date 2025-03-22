package com.projeto.cartas.carta;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    public List<Card> getCards() {
        return List.of(
                new Card(1L,"Artigo 1","Texto",0),
                new Card(2L,"Artigo 2","Texto",0)
        );
    }
}
