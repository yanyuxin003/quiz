package com.twuc.shopping.api;

import com.twuc.shopping.po.ShoppingCartPO;
import com.twuc.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/shoppingcart")
    public ResponseEntity<List<ShoppingCartPO>> getOrders(){
        return shoppingCartService.getCarts();
    }

    @DeleteMapping("/shoppingcart/{id}")
    public ResponseEntity<List<ShoppingCartPO>> deleteOrder(@PathVariable int id){
        return shoppingCartService.deleteCarts(id);
    }

    @DeleteMapping("/shoppingcart/all")
    public ResponseEntity<List<ShoppingCartPO>> deleteAllcart(){
        return shoppingCartService.deleteAll();
    }
}
