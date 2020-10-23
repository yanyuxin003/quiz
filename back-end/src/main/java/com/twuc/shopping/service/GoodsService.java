package com.twuc.shopping.service;

import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.repository.GoodsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    GoodsRepository goodsRepository;

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public ResponseEntity addGood(Goods good) {
        if (goodsRepository.findByName(good.getName()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        goodsRepository.save(GoodsPO.builder()
                .name(good.getName())
                .price(good.getPrice())
                .goodunit(good.getGoodunit())
                .imgUrl(good.getImgUrl()).build());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<GoodsPO>> getGoods() {
        return ResponseEntity.ok(goodsRepository.findAll());
    }
}