package org.tms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tms.domain.ContentType;
import org.tms.domain.Order;
import org.tms.service.OrderService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @PostMapping
    public Order save(ContentType contentType, Integer amount) {
        return service.save(contentType, amount);
    }
}