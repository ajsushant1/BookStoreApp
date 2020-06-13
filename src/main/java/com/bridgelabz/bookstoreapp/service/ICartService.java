package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartDTO;
import com.bridgelabz.bookstoreapp.exception.CartException;
import com.bridgelabz.bookstoreapp.model.Cart;

import java.util.List;

public interface ICartService {
    Cart addBooksToCart(CartDTO cartDTO);

    List<Cart> getBooksInCart();

    Cart updateCart(long bookId, long quantity) throws CartException;

    void deleteBook(long book_id);

    void deleteAllBooks();
}
