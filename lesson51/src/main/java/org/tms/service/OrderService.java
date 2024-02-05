package org.tms.service;

import org.tms.domain.ContentType;
import org.tms.domain.Order;

public interface OrderService {
    Order save(ContentType contentType, Integer amount);
}