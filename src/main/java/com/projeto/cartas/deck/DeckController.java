package com.projeto.cartas.deck;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/")
    public ResponseEntity<List<Deck>> getDecks(){
        List<Deck> decks = deckService.getDecks();
        return ResponseEntity.ok(decks);
    }

    @GetMapping("/{deckId}")
    public Optional<Deck> getDeck(@PathVariable Long deckId) {
        return deckService.getDeckById(deckId);
    }

    @PostMapping
    public ResponseEntity<Deck> registerNewDeck(@RequestBody Deck deck){
        deckService.addNewDeck(deck);
        URI newDeckUri = URI.create("/decks/" + deck.getId());
        return ResponseEntity.created(newDeckUri).body(deck);
    }
}
