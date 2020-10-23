package com.twuc.shopping.service;

import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    GoodsRepository goodsRepository;
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository, GoodsRepository goodsRepository) {
        this.orderRepository = orderRepository;
        this.goodsRepository = goodsRepository;
    }

    public ResponseEntity<List<OrderPO>> getOrderList(){
        return ResponseEntity.ok(orderRepository.findAll());
    }


    public ResponseEntity<List<OrderPO>> deleteOrder(@PathVariable int id) {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<List<OrderPO>> addToOrder(@PathVariable int id) {
        Optional<GoodsPO> goodsPO= goodsRepository.findById(id);
        if(goodsPO.isPresent()){
            Optional<OrderPO> findOrder=orderRepository.findByName(goodsPO.get().getName());
            if(findOrder.isPresent()){
                findOrder.get().setCount(findOrder.get().getCount()+1);
                orderRepository.save(findOrder.get());
            }else{
                orderRepository.save(OrderPO.builder().id(id)
                        .name(goodsPO.get().getName())
                        .count(1)
                        .price(goodsPO.get().getPrice())
                        .goodunit(goodsPO.get().getGoodunit()).build());
            }
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.badRequest().build();
    }
}
