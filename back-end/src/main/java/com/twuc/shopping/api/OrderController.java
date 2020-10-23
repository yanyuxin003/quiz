package com.twuc.shopping.api;

import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orderList")
    @CrossOrigin
    public ResponseEntity<List<OrderPO>> getOrders(){
        return orderService.getOrderList();
    }

    @DeleteMapping("/order/{id}")
    @CrossOrigin
    public ResponseEntity<List<OrderPO>> deleteOrder(@PathVariable int id){
        return orderService.deleteOrder(id);
    }
}


