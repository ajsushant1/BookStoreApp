package com.bridgelabz.bookstoreapp.cart.dto;

public class CartDTO {
    long book_id;
    long quantity;

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
