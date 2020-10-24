package com.twuc.shopping.api;

import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.ShoppingCartPO;
import com.twuc.shopping.service.GoodsService;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;


    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/shoppingcart")
    public ResponseEntity<List<ShoppingCartPO>> getShoppingCart(){
        return shoppingCartService.getCarts();
    }

    @DeleteMapping("/shoppingcart/{id}")
    public ResponseEntity<List<ShoppingCartPO>> deleteShoppingCart(@PathVariable int id){
        return shoppingCartService.deleteCarts(id);
    }

    @DeleteMapping("/shoppingcart/all")
    public ResponseEntity<List<ShoppingCartPO>> deleteAllcart(){
        return shoppingCartService.deleteAll();
    }

    @PostMapping("/shoppingcart/add")
    public ResponseEntity<List<OrderPO>> addAllCartToOrder(){
        return shoppingCartService.addCartToOrder();
    }
}


