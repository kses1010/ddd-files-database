package com.whatap.orderservice.presentation;

import com.whatap.orderservice.application.OrderCreateAplService;
import com.whatap.orderservice.application.OrderReadAplService;
import com.whatap.orderservice.application.command.OrderCreateCommand;
import com.whatap.orderservice.application.query.OrderDetailQuery;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.presentation.request.OrderCreateRequest;
import com.whatap.orderservice.presentation.response.OrderCreateResponse;
import com.whatap.orderservice.presentation.response.OrderDetailResponse;
import com.whatap.orderservice.presentation.response.OrderResponse;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderCreateAplService orderCreateAplService;
    private final OrderReadAplService orderReadAplService;

    @PostMapping("")
    public OrderCreateResponse createOrder(@RequestBody @Valid OrderCreateRequest request) {
        Order order = orderCreateAplService.createOrder(new OrderCreateCommand(request.getProductId()));
        return new OrderCreateResponse(order);
    }

    @GetMapping("/{id}")
    public OrderDetailResponse getOrderDetail(@PathVariable Long id) {
        Order order = orderReadAplService.getOrderDetail(new OrderDetailQuery(id));
        return new OrderDetailResponse(order);
    }

    @GetMapping("/all")
    public List<OrderResponse> getAllOrders() {
        return orderReadAplService.getAllOrders().stream()
            .map(OrderResponse::new)
            .collect(Collectors.toList());
    }
}
