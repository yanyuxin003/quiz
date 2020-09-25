package com.twuc.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.hamcrest.Matchers.is;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GoodsControllerTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    MockMvc mockMvc;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setup(){
        GoodsPO goodsPO = GoodsPO.builder().name("iPhone11").price(5999).goodunit("ge").imgUrl("../images/iPhone11.jpg").build();
        goodsRepository.save(goodsPO);
        GoodsPO goodsPO_2 = GoodsPO.builder().name("apple").price(3.00).goodunit("kg").imgUrl("../images/apple.jpg").build();
        goodsRepository.save(goodsPO_2);
        OrderPO orderPO= OrderPO.builder().name("apple").count(2).price(3.00).goodunit("kg").build();
        orderRepository.save(orderPO);
    }

    @AfterEach
    void set_clean(){
        goodsRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    @Order(1)
    void should_get_good_list() throws Exception {
        mockMvc.perform(get("/goodList"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("iPhone11")))
                .andExpect(jsonPath("$[0].price", is(5999)))
                .andExpect(jsonPath("$[1].name", is("apple")))
                .andExpect(jsonPath("$[1].price", is(3.00)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(1)
    void should() throws Exception {

    }

    @Test
    @Order(2)
    void should_add_good_to_order_list() throws Exception {
        int Id = goodsRepository.findAll().get(1).getId();
        mockMvc.perform(post("/goods/"+Id))
                .andExpect(status().isOk());
        List<OrderPO> orders = orderRepository.findAll();
        assertEquals(2, orders.size());
    }

    @Test
    @Order(3)
    void should_add_good() throws Exception {
        Goods goods = Goods.builder().name("paper").price(0.3).goodunit("piece").imgUrl("../images/paper").build();
        String requestJson = objectMapper.writeValueAsString(goods);
        mockMvc.perform(post("/goods/").content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(get("/goods"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("paper")))
                .andExpect(jsonPath("$[2].price", is(0.3)))
                .andExpect(status().isOk());
    }
    
}
