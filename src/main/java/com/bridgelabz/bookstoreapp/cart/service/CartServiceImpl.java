package com.bridgelabz.bookstoreapp.cart.service;

import com.bridgelabz.bookstoreapp.cart.dto.CartDTO;
import com.bridgelabz.bookstoreapp.cart.exception.CartException;
import com.bridgelabz.bookstoreapp.cart.model.Cart;
import com.bridgelabz.bookstoreapp.cart.repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    final
    CartRepository cartRepository;

    final
    ModelMapper modelMapper;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Cart addBooksToCart(CartDTO cartDTO) {
        Cart cart = modelMapper.map(cartDTO, Cart.class);
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getBooksInCart() {
        return cartRepository.findAll();
    }

    //Method to update book quantity in cart
    @Override
    public Cart updateCart(long bookId, long quantity) throws CartException {
        Cart cart = cartRepository.findById(bookId).get();
        if (cart == null)
            throw new CartException(CartException.ExceptionType.BOOK_NOT_FOUND, "Book Not Found");
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public void deleteBook(long book_id) {
        cartRepository.deleteById(book_id);
    }

    public void deleteAllBooks() {
        cartRepository.deleteAll();
    }
}
