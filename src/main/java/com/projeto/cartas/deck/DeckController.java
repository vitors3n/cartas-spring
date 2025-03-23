package com.projeto.cartas.deck;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "api/v1/deck")
public class DeckController {
    private final DeckService deckService;

    @Autowired
    public DeckController(DeckService deckService){
        this.deckService = deckService;
    }

    @GetMapping
    public List<Deck> getDecks(){
        return deckService.getDecks();
    }

    @PostMapping
    public void registerNewDeck(@RequestBody Deck deck){
        deckService.addNewDeck(deck);
    }
}
