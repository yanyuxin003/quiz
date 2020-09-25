package com.twuc.shopping.api;

import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodController {

    @Autowired
    GoodsRepository goodsRepository;

    OrderController orderController;

    public GoodController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @GetMapping("/goodList")
    public ResponseEntity<List<GoodsPO>> getGoodList(){
        return ResponseEntity.ok(goodsRepository.findAll());
    }

    @PostMapping("/good/{id}")
    public ResponseEntity findGoodByIdAddAddToOrder(@PathVariable int id){
        return ResponseEntity.ok(orderController.addToOrder(id));
    }

    @PostMapping("/goods")
    public ResponseEntity addGood(@RequestBody Goods good){
        if(goodsRepository.findByName(good.getName()).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        goodsRepository.save(GoodsPO.builder()
                .name(good.getName())
                .price(good.getPrice())
                .goodunit(good.getGoodunit())
                .imgUrl(good.getImgUrl()).build());
        return ResponseEntity.ok().build();
    }
}
