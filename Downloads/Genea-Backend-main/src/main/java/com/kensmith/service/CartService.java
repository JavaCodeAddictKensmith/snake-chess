package com.kensmith.service;

import com.kensmith.dto.response.CartResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface CartService {
    @Transactional
    String addProductToCart(Long productId);

    String removeProductFromCart(Long productId);

    CartResponseDto viewCart();
}
