package com.projeto.cartas.carta;

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
    private String front;
    private String back;
    private Integer reviews;

    public Card() {
    }

    public Card(String front, String back, Integer reviews) {
        this.front = front;
        this.back = back;
        this.reviews = reviews;
    }

    public Card(Long id, String front, String back, Integer reviews) {
        this.id = id;
        this.front = front;
        this.back = back;
        this.reviews = reviews;
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
}
