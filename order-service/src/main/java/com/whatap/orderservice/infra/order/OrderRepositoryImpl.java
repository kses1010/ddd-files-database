package com.whatap.orderservice.infra.order;

import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.OrderRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

    @Override
    public List<Order> findAll() {
        return orderEntitySpringDataRepository.findAll().stream()
            .map(OrderEntity::toDomain)
            .collect(Collectors.toList());
    }
}
