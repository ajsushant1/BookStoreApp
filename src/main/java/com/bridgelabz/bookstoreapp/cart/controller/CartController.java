package com.bridgelabz.bookstoreapp.cart.controller;

import com.bridgelabz.bookstoreapp.cart.dto.CartDTO;
import com.bridgelabz.bookstoreapp.cart.exception.CartException;
import com.bridgelabz.bookstoreapp.cart.model.Cart;
import com.bridgelabz.bookstoreapp.cart.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    final
    CartServiceImpl cartService;

    @Autowired
    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add-book")
    public Cart addBooksToCart(@RequestBody CartDTO cartDTO) {
        return cartService.addBooksToCart(cartDTO);
    }

    @GetMapping("/get-books")
    public List<Cart> getBooksInCart() {
        return cartService.getBooksInCart();
    }

    @PutMapping("/update-book-quantity/{quantity}")
    public Cart updateCart(@PathVariable long quantity, @RequestParam(value = "book_id") long bookId) throws CartException {
        return cartService.updateCart(bookId, quantity);
    }

    @DeleteMapping("/delete-book/{bookId}")
    public void deleteMapping(@PathVariable long bookId) {
        cartService.deleteBook(bookId);
    }
}
