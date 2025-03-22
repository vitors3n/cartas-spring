package com.projeto.cartas.carta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/card")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @PostMapping
    public void registerNewCard(@RequestBody Card card){
        cardService.addNewCard(card);
    }

    @DeleteMapping(path = "{cardId}")
    public void deleteCard(@PathVariable("cardId") Long cardId){
        cardService.deleteCard(cardId);
    }
}
