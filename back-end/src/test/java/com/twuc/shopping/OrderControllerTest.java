package com.twuc.shopping;

import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setup() {
        goodsRepository.deleteAll();
        orderRepository.deleteAll();
        GoodsPO goodsPO = GoodsPO.builder().name("iPhone11").price(5999).goodunit("ge").imgUrl("../images/iPhone11.jpg").build();
        goodsRepository.save(goodsPO);
        GoodsPO goodsPO_2 = GoodsPO.builder().name("apple").price(3.00).goodunit("kg").imgUrl("../images/apple.jpg").build();
        goodsRepository.save(goodsPO_2);
        OrderPO orderPO = OrderPO.builder().name("apple").count(2).price(3.00).goodunit("kg").build();
        orderRepository.save(orderPO);
        OrderPO orderPO2 = OrderPO.builder().name("pen").count(1).price(3.00).goodunit("zhi").build();
        orderRepository.save(orderPO);
    }

    @Test
    void should_get_order() throws Exception {
        mockMvc.perform(get("/orderList"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("apple")))
                .andExpect(jsonPath("$[0].count", is(2)))
                .andExpect(status().isOk());
    }

    @Test
    void should_delete_order() throws Exception {
        int orderDeleteId = orderRepository.findAll().get(0).getId();
        mockMvc.perform(delete("/order/" + orderDeleteId))
                .andExpect(status().isOk());
        assertEquals(1, orderRepository.findAll().size());
    }
}

