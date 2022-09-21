package com.whatap.orderservice.infra.order;

import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.OrderRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderEntitySpringDataRepository orderEntitySpringDataRepository;

    @Override
    public Order save(Order order) {
        return orderEntitySpringDataRepository.save(order.toEntity()).toDomain();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderEntitySpringDataRepository.findById(id).map(OrderEntity::toDomain);
    }
}
