package com.kensmith.service;


import com.kensmith.dto.request.InitializePaymentRequest;
import com.kensmith.dto.response.InitializePaymentResponse;
import com.kensmith.dto.response.TransactionResponse;
import com.kensmith.dto.response.VerifyPaymentResponse;
import org.springframework.stereotype.Service;



@Service

public interface TransactionService {


    InitializePaymentResponse initializePayment(InitializePaymentRequest request);

    VerifyPaymentResponse verifyPayment(String reference);

    TransactionResponse getAllTransactions();

    TransactionResponse getTransactionById(String id);
}
