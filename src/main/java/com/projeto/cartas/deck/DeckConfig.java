package com.projeto.cartas.deck;

import com.projeto.cartas.carta.Card;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DeckConfig {

    @Bean
    CommandLineRunner deckContentsRunner(DeckRepository repository) {
        return args -> {

            Deck SCRUM = new Deck("SCRUM");
            Deck TDD = new Deck("TDD");

            Card card1 = new Card("Qual a função do Scrum Master?","Resposta", 0, SCRUM);
            Card card2 = new Card("O que é um Product Backlog?","Resposta", 0, SCRUM);

            List<Card> cardsSCRUM = List.of(card1,card2);

            Card cardTDD1 = new Card("Test-first","Resposta", 0, TDD);
            Card cardTDD2 = new Card("TDD Red Geen Refactor","Resposta", 0, TDD);

            List<Card> cardsTDD = List.of(cardTDD1,cardTDD2);

            SCRUM.setCards(cardsSCRUM);
            TDD.setCards(cardsTDD);

            repository.saveAll(
                    List.of(SCRUM, TDD)
            );
        };
    }
}
