package com.twuc.shopping.service;

import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.ShoppingCartPO;
import com.twuc.shopping.repository.ShoppingCartRepository;
import com.twuc.shopping.repository.GoodsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    GoodsRepository goodsRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, GoodsRepository goodsRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.goodsRepository = goodsRepository;
    }

    public ResponseEntity<List<ShoppingCartPO>> getCarts() {
        return ResponseEntity.ok(shoppingCartRepository.findAll());
    }

    public ResponseEntity deleteCarts(int id) {
        if (shoppingCartRepository.findById(id).isPresent()) {
            shoppingCartRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.badRequest().build();
    }

    public ResponseEntity deleteAll() {
        shoppingCartRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<OrderPO>> addToCart(@PathVariable int id) {
        Optional<GoodsPO> goodsPO = goodsRepository.findById(id);
        if (goodsPO.isPresent()) {
            Optional<ShoppingCartPO> findCart = shoppingCartRepository.findByName(goodsPO.get().getName());
            if (findCart.isPresent()) {
                findCart.get().setId(findCart.get().getId() + 1);
                shoppingCartRepository.save(findCart.get());
            } else {
                shoppingCartRepository.save(ShoppingCartPO.builder()
                        .id(id).name(goodsPO.get().getName())
                        .price(goodsPO.get().getPrice())
                        .goodunit(goodsPO.get().getGoodunit())
                        .imgUrl(goodsPO.get().getImgUrl())
                        .count(1).build());
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}