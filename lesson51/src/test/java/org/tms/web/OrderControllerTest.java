package org.tms.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.tms.domain.ContentType;
import org.tms.domain.Order;
import org.tms.service.OrderService;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void saveOrder() throws Exception {

        Order order = Order.builder()
                .id(1)
                .contentType(ContentType.SOAP)
                .amount(2)
                .build();

        Mockito.when(orderService.save(eq(ContentType.SOAP), eq(2))).thenReturn(order);
        var json = mapper.writeValueAsString(order);

        mockMvc.perform(post("/orders")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(order.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.contentType", CoreMatchers.is(order.getContentType().name())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount", CoreMatchers.is(order.getAmount())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", CoreMatchers.is(order.getPrice())));
    }
}