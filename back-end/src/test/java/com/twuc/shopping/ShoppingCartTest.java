package com.twuc.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.po.GoodsPO;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.ShoppingCartPO;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ShoppingCartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingCartTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    MockMvc mockMvc;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @BeforeEach
    void setup(){
        goodsRepository.deleteAll();
        orderRepository.deleteAll();
        shoppingCartRepository.deleteAll();
        GoodsPO goodsPO = GoodsPO.builder().name("iPhone11").price(5999).goodunit("ge").imgUrl("../images/iPhone11.jpg").build();
        goodsRepository.save(goodsPO);
        GoodsPO goodsPO_2 = GoodsPO.builder().name("apple").price(3.00).goodunit("kg").imgUrl("../images/apple.jpg").build();
        goodsRepository.save(goodsPO_2);
        OrderPO orderPO= OrderPO.builder().name("apple").count(2).price(3.00).goodunit("kg").build();
        orderRepository.save(orderPO);
        ShoppingCartPO shoppingCartPO = ShoppingCartPO.builder().name("apple").price(3.00).goodunit("kg").imgUrl("../images/apple.jpg").build();
        orderRepository.save(orderPO);
    }

    @Test
    @Order(1)
    void should_get_good_list() throws Exception {
        mockMvc.perform(get("/goods"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("iPhone11")))
                .andExpect(jsonPath("$[0].price", is(5999.0)))
                .andExpect(jsonPath("$[1].name", is("apple")))
                .andExpect(jsonPath("$[1].price", is(3.00)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void should_add_good_to_cart() throws Exception {
        int Id = goodsRepository.findAll().get(0).getId();
        mockMvc.perform(post("/goods/"+Id))
                .andExpect(status().isOk());
        List<OrderPO> orders = orderRepository.findAll();
        assertEquals(2, orders.size());
    }

}