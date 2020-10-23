package com.twuc.shopping.api;

import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.service.GoodsService;
import com.twuc.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    ShoppingCartService shoppingCartService;

    public GoodsController(GoodsService goodsService,  ShoppingCartService shoppingCartService) {
        this.goodsService = goodsService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/goods")
    public ResponseEntity<List<GoodsPO>> getGoods(){
        return goodsService.getGoods();
    }

    @PostMapping("/goods/{id}")
    @CrossOrigin
    public ResponseEntity findGoodByIdAddAddToOrder(@PathVariable int id){
        return shoppingCartService.addToCart(id);
    }

    @PostMapping("/goods")
    @CrossOrigin
    public ResponseEntity addGood(@RequestBody Goods good){
        return goodsService.addGood(good);
    }
}
