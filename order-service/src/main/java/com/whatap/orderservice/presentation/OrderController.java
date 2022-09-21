package com.whatap.orderservice.presentation;

import com.whatap.orderservice.application.OrderCreateAplService;
import com.whatap.orderservice.application.command.OrderCreateCommand;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.presentation.request.OrderCreateRequest;
import com.whatap.orderservice.presentation.response.OrderCreateResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderCreateAplService orderCreateAplService;

    @PostMapping("")
    public OrderCreateResponse createOrder(@RequestBody @Valid OrderCreateRequest request) {
        Order order = orderCreateAplService.createOrder(new OrderCreateCommand(request.getProductId()));
        return new OrderCreateResponse(order);
    }
}
