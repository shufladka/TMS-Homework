package org.tms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tms.domain.ContentType;
import org.tms.domain.Order;
import org.tms.service.DataService;
import org.tms.service.OrderService;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final DataService service;

    @Override
    public Order save(ContentType contentType, Integer amount) {

        Order order = Order.builder()
                .id (1)
                .contentType(contentType)
                .amount(amount)
                .price(2024.0)
                .build();

        return service.save(order);
    }
}