package com.whatap.orderservice.presentation;

import com.whatap.orderservice.application.OrderCreateAplService;
import com.whatap.orderservice.application.OrderDeleteAplService;
import com.whatap.orderservice.application.OrderReadAplService;
import com.whatap.orderservice.application.OrderUpdateAplService;
import com.whatap.orderservice.application.command.OrderCreateCommand;
import com.whatap.orderservice.application.command.OrderDeleteCommand;
import com.whatap.orderservice.application.command.OrderUpdateCommand;
import com.whatap.orderservice.application.query.OrderDetailQuery;
import com.whatap.orderservice.application.query.OrderListQuery;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.model.OrderDetail;
import com.whatap.orderservice.domain.order.model.OrderSummary;
import com.whatap.orderservice.global.pagination.PageQuery;
import com.whatap.orderservice.global.pagination.PageQueryDto;
import com.whatap.orderservice.presentation.request.OrderCreateRequest;
import com.whatap.orderservice.presentation.request.OrderUpdateRequest;
import com.whatap.orderservice.presentation.response.OrderCreateResponse;
import com.whatap.orderservice.presentation.response.OrderDetailResponse;
import com.whatap.orderservice.presentation.response.OrderResponse;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderCreateAplService orderCreateAplService;
    private final OrderReadAplService orderReadAplService;
    private final OrderUpdateAplService orderUpdateAplService;
    private final OrderDeleteAplService orderDeleteAplService;

    @PostMapping("")
    public OrderCreateResponse createOrder(@RequestBody @Valid OrderCreateRequest request) {
        Order order = orderCreateAplService.createOrder(new OrderCreateCommand(request.getProductId()));
        return new OrderCreateResponse(order);
    }

    @GetMapping("/{id}")
    public OrderDetailResponse getOrderDetail(@PathVariable Long id) {
        OrderDetail orderDetail = orderReadAplService.getOrderDetail(new OrderDetailQuery(id));
        return new OrderDetailResponse(orderDetail);
    }

    @GetMapping("/all")
    public List<OrderResponse> getAllOrders() {
        return orderReadAplService.getAllOrders().stream()
            .map(OrderResponse::new)
            .collect(Collectors.toList());
    }

    @GetMapping("")
    public List<OrderResponse> getOrders(@ModelAttribute @Valid PageQueryDto pageQueryDto) {
        PageQuery pageQuery = new PageQuery(pageQueryDto.getPage(), pageQueryDto.getLimit());
        return orderReadAplService.getOrders(new OrderListQuery(pageQuery)).stream()
            .map(OrderResponse::new)
            .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public OrderResponse updateOrder(
        @PathVariable Long id,
        @RequestBody @Valid OrderUpdateRequest request) {

        OrderSummary orderSummary = orderUpdateAplService.updateOrder(
            new OrderUpdateCommand(id, request.getProductId()));
        return new OrderResponse(orderSummary);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderDeleteAplService.deleteOrder(new OrderDeleteCommand(id));
    }
}
