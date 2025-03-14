package com.kensmith.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter


public class InitializePaymentRequest {
    private BigDecimal amount;
    private String email;
    private String reference;

}
