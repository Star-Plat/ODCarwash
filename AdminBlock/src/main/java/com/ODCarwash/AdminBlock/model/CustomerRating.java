package com.ODCarwash.AdminBlock.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratingdb")
public class CustomerRating {

    private String washerName;
    private int rating;
    private String review;
    public CustomerRating() {
        super();
    }
    public CustomerRating(String washerName, int rating, String review) {
        super();
        this.washerName = washerName;
        this.rating = rating;
        this.review = review;
    }
    public String getWasherName() {
        return washerName;
    }
    public void setWasherName(String washerName) {
        this.washerName = washerName;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    @Override
    public String toString() {
        return "CustomerRating [washer name=" + washerName + ", rating=" + rating + ", review=" + review + "]";
    }


}
