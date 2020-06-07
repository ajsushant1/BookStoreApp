package com.bridgelabz.bookstoreapp.cart.service;

import com.bridgelabz.bookstoreapp.cart.dto.CartDTO;
import com.bridgelabz.bookstoreapp.cart.exception.CartException;
import com.bridgelabz.bookstoreapp.cart.model.Cart;

import java.util.List;

public interface ICartService {
    Cart addBooksToCart(CartDTO cartDTO);

    List<Cart> getBooksInCart();

    Cart updateCart(long bookId, long quantity) throws CartException;

    void deleteBook(long book_id);

    void deleteAllBooks();
}
