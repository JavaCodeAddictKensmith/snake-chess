package com.kensmith.dto.response;


import com.kensmith.dto.request.CartItemDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartResponseDto {
    private double subTotal;
    private int totalQuantity;
    private List<CartItemDto> cartItem;



}
