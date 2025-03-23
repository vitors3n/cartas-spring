package com.projeto.cartas.deck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeckRepository
        extends JpaRepository<Deck, Long> {

    // QUERY
    Optional<Deck> findDeckByName(String name);
}
