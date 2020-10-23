package com.twuc.shopping.repository;


import com.twuc.shopping.po.ShoppingCartPO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCartPO,Integer> {
    List<ShoppingCartPO> findAll();
    Optional<ShoppingCartPO> findByName(String name);
    void deleteAll();
}