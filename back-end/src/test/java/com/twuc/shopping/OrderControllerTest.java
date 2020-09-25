package com.twuc.shopping;

import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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
    void setup(){

    }
}
