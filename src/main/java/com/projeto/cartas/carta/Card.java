package com.projeto.cartas.carta;

public class Card {
    private Long id;
    private String front;
    private String back;
    private Integer reviews;




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
