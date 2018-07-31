package com.test.order;

import com.test.producer.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OrderControllerTest {
    @Mock
    OrderRepository orderRepository;

    @Test
    public void shouldGetOrderIfAnOrderExists() {

    }

}