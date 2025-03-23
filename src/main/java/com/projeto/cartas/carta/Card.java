package com.projeto.cartas.carta;

import com.projeto.cartas.deck.Deck;
import jakarta.persistence.*;


@Entity
@Table
public class Card {

    @Id
    @SequenceGenerator(
            name = "card_sequence",
            sequenceName = "card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "card_sequence"
    )
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String front;

    @Column(columnDefinition = "TEXT")
    private String back;

    private Integer reviews;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

    public Card() {
    }

    public Card(String front, String back, Integer reviews, Deck deck) {
        this.front = front;
        this.back = back;
        this.reviews = reviews;
        this.deck = deck;
    }

    public Card(Long id, String front, String back, Integer reviews) {
        this.id = id;
        this.front = front;
        this.back = back;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Long getDeck() {
        return deck.getId();
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
