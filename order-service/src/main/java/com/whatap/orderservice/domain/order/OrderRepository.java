package com.whatap.orderservice.domain.order;

import com.whatap.orderservice.global.pagination.PageQuery;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(Long id);

    List<Order> findAll();

    List<Order> findAll(PageQuery pageQuery);
}
