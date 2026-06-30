package org.petstore.demo.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.petstore.demo.api.model.Order;
import org.petstore.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StoreApiController implements StoreApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<Void> deleteOrder(Long orderId) {
        log.info("deleteOrder {}", orderId);
        orderService.delete(orderId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Map<String, Integer>> getInventory() {
        return null;
    }

    @Override
    public ResponseEntity<Order> getOrderById(Long orderId) {
        return null;
    }

    @Override
    public ResponseEntity<Order> placeOrder(Order order) {
        return null;
    }
}
