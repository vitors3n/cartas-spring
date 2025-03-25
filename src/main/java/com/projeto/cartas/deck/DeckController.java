package com.projeto.cartas.deck;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "api/v1/decks")
public class DeckController {
    private final DeckService deckService;

    @Autowired
    public DeckController(DeckService deckService){
        this.deckService = deckService;
    }

    @GetMapping("/{deckId}")
    public Optional<Deck> getDeck(@PathVariable Long deckId) {
        return deckService.getDeckbyId(deckId);
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
