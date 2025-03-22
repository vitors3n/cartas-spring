package com.projeto.cartas.carta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    public void addNewCard(Card card) {
        Optional<Card> cardOptional = cardRepository.findCardByFront(card.getFront());
        if (cardOptional.isPresent()){
            throw new IllegalStateException("Card já existe");
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
