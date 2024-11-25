package com.kensmith.service.serviceImpl;

import com.kensmith.repository.OrderRepository;
import com.kensmith.repository.ProductRepository;
import com.kensmith.repository.UserRepository;
import com.kensmith.service.OrderService;
import com.kensmith.utils.LoggedInUserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl  implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final LoggedInUserUtils utils;












}
