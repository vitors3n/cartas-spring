package com.projeto.cartas.deck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addNewDeck(Deck deck) {
        Optional<Deck> deckOptional = deckRepository.findDeckByName(deck.getName());
        if (deckOptional.isPresent()){
            throw new IllegalStateException("Deck já existe");
        }
        deckRepository.save(deck);
    }

    public void deleteDeck(Long deckId){
        boolean deckExists = deckRepository.existsById(deckId);

        if(!deckExists){
            throw new IllegalStateException("Deck com id " + deckId + " não existe");
        }
        deckRepository.deleteById(deckId);
    }
}
