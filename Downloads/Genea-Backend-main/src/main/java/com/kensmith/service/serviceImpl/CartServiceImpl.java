package com.kensmith.service.serviceImpl;

import com.kensmith.dto.request.CartItemDto;
import com.kensmith.dto.response.CartResponseDto;
import com.kensmith.entity.Cart;
import com.kensmith.entity.CartItem;
import com.kensmith.entity.Product;
import com.kensmith.entity.User;
import com.kensmith.exception.CustomException;
import com.kensmith.exception.UserNotFoundException;
import com.kensmith.repository.CartRepository;
import com.kensmith.repository.ProductRepository;
import com.kensmith.repository.UserRepository;
import com.kensmith.service.CartService;
import com.kensmith.utils.LoggedInUserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private  final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final LoggedInUserUtils utils;
    private final CartRepository cartRepository;

    @Override
    @Transactional
    public String addProductToCart(Long productId) {
        User loggedInUser = getUser();
        Cart cart = loggedInUser.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(loggedInUser);
            cart.setCartItems(new ArrayList<>());
        }
        Product productToAdd = productRepository.findById(productId)
                .orElseThrow(() -> new CustomException("Product not found"));
        if (productToAdd.getQuantity() <= 0) {
            throw new CustomException("Product is out of stock");
        }
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().equals(productToAdd)) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartRepository.save(cart);
                return "Product quantity increased in cart";
            }
        }

        CartItem newCartItem = new CartItem();
        newCartItem.setProduct(productToAdd);
        newCartItem.setQuantity(1);
        newCartItem.setPrice(productToAdd.getPrice());
        newCartItem.setCart(cart);
        cartItems.add(newCartItem);
        cart.setCartItems(cartItems);
        cartRepository.save(cart);

        return "Product added to cart";
    }

    private User getUser() {
        String loggedInUsername = utils.getLoggedInUser();
        if (loggedInUsername == null) {
            throw new CustomException("User not logged in");
        }
        return userRepository.findByEmail(loggedInUsername)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public String removeProductFromCart(Long productId){
        User loggedInUser= getUser();
        Cart cart = loggedInUser.getCart();
        if (cart == null) {
            throw new CustomException("Cart not found");
        }
        Product productToRemove = productRepository.findById(productId)
                .orElseThrow(() -> new CustomException("Product not found"));
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().equals(productToRemove)) {
                cartItems.remove(cartItem);
                cartRepository.save(cart);
                return "Product removed from cart";
            }
        }
        throw new CustomException("Product not found in cart");
    }
    @Override
    public CartResponseDto viewCart() {
        User loggedInUser = getUser();
        Cart cart = loggedInUser.getCart();
        if (cart == null) {
            throw new CustomException("Cart not found");
        }

        List<CartItem> cartItems = cart.getCartItems();
        List<CartItemDto> cartItemsDtoList = new ArrayList<>();

        double subTotal = 0.0;
        int totalQuantity=0;

        for (CartItem cartItem : cartItems) {

            Product product = cartItem.getProduct();
            double totalPrice = product.getPrice() * cartItem.getQuantity();

            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setProductName(product.getProductName());
            cartItemDto.setQuantity(cartItem.getQuantity());
            cartItemDto.setPrice(product.getPrice());
            cartItemDto.setSubTotal(totalPrice);

            cartItemsDtoList.add(cartItemDto);

            subTotal += totalPrice;
            totalQuantity  += cartItem.getQuantity();
        }

        CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setCartItem(cartItemsDtoList);
        cartResponseDto.setTotalQuantity(totalQuantity);
        cartResponseDto.setSubTotal(subTotal);

        return cartResponseDto;
    }



}





