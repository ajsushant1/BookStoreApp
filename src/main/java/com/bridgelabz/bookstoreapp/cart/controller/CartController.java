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

    @PostMapping("/addbook")
    public Cart addBooksToCart(@RequestBody CartDTO cartDTO) {
        return cartService.addBooksToCart(cartDTO);
    }

    @GetMapping("/getbooks")
    public List<Cart> getBooksInCart() {
        return cartService.getBooksInCart();
    }

    @PutMapping("/updatebookquantity/{quantity}")
    public Cart updateCart(@PathVariable long quantity, @RequestParam(value = "item_id") long itemId) throws CartException {
        return cartService.updateCart(itemId, quantity);
    }

    @DeleteMapping("/deletebook/{bookId}")
    public void deleteMapping(@PathVariable long bookId) {
        cartService.deleteBook(bookId);
    }
}
