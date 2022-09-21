package com.whatap.orderservice.infra.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntitySpringDataRepository extends JpaRepository<OrderEntity, Long> {

}
