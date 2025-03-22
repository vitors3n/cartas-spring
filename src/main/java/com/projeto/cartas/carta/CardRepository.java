package com.projeto.cartas.carta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository
        extends JpaRepository<Card, Long> {

    //@Query("SELECT c FROM card c WHERE c.front = ?1")
    Optional<Card> findCardByFront(String front);
}
