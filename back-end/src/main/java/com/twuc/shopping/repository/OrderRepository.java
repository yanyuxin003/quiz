package com.twuc.shopping.repository;

import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.po.OrderPO;

import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderPO,Integer> {
//    @Override
    List<OrderPO> findAll();

    Optional<OrderPO> findByName(String name);

    Optional<OrderPO> findById(Integer id);
}