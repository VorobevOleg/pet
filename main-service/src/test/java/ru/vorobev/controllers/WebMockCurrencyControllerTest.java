package ru.vorobev.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.vorobev.services.CurrencyService;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CurrencyController.class)
class WebMockCurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService service;

    @Test
    void getAllCurrencyMock() {

    }
}