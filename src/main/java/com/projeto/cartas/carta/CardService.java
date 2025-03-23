package com.projeto.cartas.carta;

import com.projeto.cartas.deck.Deck;
import com.projeto.cartas.deck.DeckRepository;
import com.projeto.cartas.deck.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final DeckRepository deckRepository;

    @Autowired
    public CardService(CardRepository cardRepository, DeckRepository deckRepository) {
        this.cardRepository = cardRepository;
        this.deckRepository = deckRepository;
    }

    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    public void addNewCard(Card card) {
        Optional<Card> cardOptional = cardRepository.findCardByFront(card.getFront());
        if (cardOptional.isPresent()){
            throw new IllegalStateException("Card já existe");
        }

        Optional<Deck> deckOptional = deckRepository.findById(card.getDeck());

        if (deckOptional.isEmpty()){
            throw new IllegalStateException("Deck não encontrado");
        }

        cardRepository.save(card);
    }

    public void deleteCard(Long cardId) {
        boolean exists = cardRepository.existsById(cardId);
        if (!exists) {
            throw new IllegalStateException("Carta com id " + cardId + " não existe.");
        }
        cardRepository.deleteById(cardId);
    }
}
