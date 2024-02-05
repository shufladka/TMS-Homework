package org.tms.service.impl;

import org.springframework.stereotype.Service;
import org.tms.domain.Order;
import org.tms.service.DataService;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public Order save(Order order) {
        throw new RuntimeException();
    }
}