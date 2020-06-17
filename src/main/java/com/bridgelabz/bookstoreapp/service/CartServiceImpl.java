package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.exception.CartException;
import com.bridgelabz.bookstoreapp.model.Cart;
import com.bridgelabz.bookstoreapp.repository.ICartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param cartDto
     * @return Add books into the cart which is to be purchased
     */
    @Override
    public Cart addBookToCart(CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        return cartRepository.save(cart);
    }

    /**
     * @return List of all books present inside the cart
     */
    @Override
    public List<Cart> getListOfBooksInCart() {
        return cartRepository.findAll();
    }

    /**
     * @param bookId
     * @param bookQuantity
     * @return Update book quantity of particular book id
     * @throws CartException
     */
    @Override
    public Cart updateCart(Long bookId, Long bookQuantity) throws CartException {
        Cart cart = cartRepository.findById(bookId).get();
        if (cart == null)
            throw new CartException(CartException.ExceptionType.BOOK_IS_NOT_AVAILABLE, "BOOK_IS_NOT_AVAILABLE");
        cart.setQuantity(bookQuantity);
        return cartRepository.save(cart);
    }

    /**
     * @param bookId
     * @throws CartException
     */
    @Override
    public void removeBookFromCart(Long bookId) throws CartException {
        if (!cartRepository.findById(bookId).isPresent())
            throw new CartException(CartException.ExceptionType.INVALID_BOOK_ID, "INVALID_BOOK_ID");
        cartRepository.deleteById(bookId);
    }

    /**
     * Remove all books inside the cart
     */
    @Override
    public void removeAllBooks() {
        cartRepository.deleteAll();
    }
}
