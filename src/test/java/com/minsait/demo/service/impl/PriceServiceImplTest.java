package com.minsait.demo.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test1() throws Exception {
        this.mockMvc.perform(
                    get("/prices")
                        .queryParam("date", "2020-06-14T10:00:00")
                        .queryParam("productId", "35455")
                        .queryParam("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':35455,'brandId':1,'startDate':'2020-06-14T00:00:00'," +
                        "'endDate':'2020-12-31T23:59:59','priority':0,'price':35.5}"));
    }

    @Test
    @DisplayName("petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test2() throws Exception {
        this.mockMvc.perform(
                        get("/prices")
                                .queryParam("date", "2020-06-14T16:00:00")
                                .queryParam("productId", "35455")
                                .queryParam("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':35455,'brandId':1,'startDate':'2020-06-14T15:00:00'," +
                        "'endDate':'2020-06-14T18:30:00','priority':1,'price':25.45}"));
    }

    @Test
    @DisplayName("petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test3() throws Exception {
        this.mockMvc.perform(
                        get("/prices")
                                .queryParam("date", "2020-06-14T21:00:00")
                                .queryParam("productId", "35455")
                                .queryParam("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':35455,'brandId':1,'startDate':'2020-06-14T00:00:00'," +
                        "'endDate':'2020-12-31T23:59:59','priority':0,'price':35.5}"));
    }

    @Test
    @DisplayName("petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void test4() throws Exception {
        this.mockMvc.perform(
                        get("/prices")
                                .queryParam("date", "2020-06-15T10:00:00")
                                .queryParam("productId", "35455")
                                .queryParam("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':35455,'brandId':1,'startDate':'2020-06-15T00:00:00'," +
                        "'endDate':'2020-06-15T11:00:00','priority':1,'price':30.5}"));
    }

    @Test
    @DisplayName("petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void test5() throws Exception {
        this.mockMvc.perform(
                        get("/prices")
                                .queryParam("date", "2020-06-16T21:00:00")
                                .queryParam("productId", "35455")
                                .queryParam("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':35455,'brandId':1,'startDate':'2020-06-15T16:00:00'," +
                        "'endDate':'2020-12-31T23:59:59','priority':1,'price':38.95}"));
    }
}