package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.exception.CartException;
import com.bridgelabz.bookstoreapp.model.Cart;

import java.util.List;

public interface ICartService {

    Cart addBookToCart(CartDto cartDto);

    List<Cart> getListOfBooksInCart();

    Cart updateCart(Long bookId, Long quantity) throws CartException;

    void removeBookFromCart(Long bookId) throws CartException;

    void removeAllBooks();
}
