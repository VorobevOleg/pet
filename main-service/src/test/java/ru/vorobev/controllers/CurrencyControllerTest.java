package ru.vorobev.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.vorobev.entities.Currency;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CurrencyControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllCurrencyFromController_getCurrencies_StatusOkAndBodyNotEmpty() {
        ResponseEntity<List<Currency>> currencyResponseEntity = this.restTemplate.exchange(
                "http://localhost:" + port + "/currency",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        assertNotNull(currencyResponseEntity);
        assertTrue(currencyResponseEntity.getStatusCode().is2xxSuccessful());
        assertTrue(currencyResponseEntity.hasBody());
        assertFalse(Objects.requireNonNull(currencyResponseEntity.getBody()).isEmpty());
    }
}