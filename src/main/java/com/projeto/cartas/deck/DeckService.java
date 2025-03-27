package com.projeto.cartas.deck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class DeckService {
    private final DeckRepository deckRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository){
        this.deckRepository = deckRepository;
    }

    public List<Deck> getDecks(){
        return deckRepository.findAll();
    }

    public Optional<Deck> getDeckById(Long deckId){
        Optional<Deck> deck = deckRepository.findById(deckId);

        if (deck.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deck com id " + deckId + " não encontrado.");
        }

        return deckRepository.findById(deckId);
    }

    public void addNewDeck(Deck deck) {
        Optional<Deck> deckOptional = deckRepository.findDeckByName(deck.getName());
        if (deckOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Deck já existe.");
        }
        deckRepository.save(deck);

        //throw new ResponseStatusException(HttpStatus.CREATED);
    }

    public void deleteDeck(Long deckId){
        boolean deckExists = deckRepository.existsById(deckId);

        if(!deckExists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deck com id " + deckId + " não encontrado.");
        }

        deckRepository.deleteById(deckId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Deck com id " + deckId + " foi deletado.");
    }
}
