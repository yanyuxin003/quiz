package com.twuc.shopping.repository;

import com.twuc.shopping.po.GoodsPO;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository extends CrudRepository<GoodsPO,Integer> {
//    @Override
    List<GoodsPO> findAll();

    Optional<GoodsPO> findById(Integer id);

    Optional<GoodsPO> findByName(String name);
}
