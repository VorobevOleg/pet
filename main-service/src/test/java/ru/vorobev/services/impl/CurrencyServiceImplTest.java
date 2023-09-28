package ru.vorobev.services.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vorobev.converters.DtoConverter;
import ru.vorobev.entities.Currency;
import ru.vorobev.repositories.CurrencyRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyServiceImplTest {

    @Autowired
    private CurrencyServiceImpl service;
    @Autowired
    private CurrencyRepository repository;
    @Autowired
    private DtoConverter dtoConverter;

    private static Currency testCurrency;
    private static Currency testCurrencyToUpdate;

    @BeforeAll
    private static void init() {
        testCurrency = Currency.builder()
                .id("Test")
                .numCode(999)
                .charCode("TES")
                .nominal(1)
                .name("Test currency")
                .build();
        testCurrencyToUpdate = Currency.builder()
                .id("Test")
                .numCode(998)
                .charCode("TET")
                .nominal(2)
                .name("Test currency updated")
                .build();
    }

    @Test
    void getAllCurrencyFromDb_findAll_notEmptyResponse() {
        List<Currency> currencyList = service.getAll();
        assertNotNull(currencyList);
        assertFalse(currencyList.isEmpty());
    }

    @Test
    void saveCurrencyToDb_saveCurrency_allFieldsCorrectSaved() {
        Currency currency = service.saveAndRefreshCache(testCurrency);
        assertNotNull(currency);
        assertEquals(currency.getId(), testCurrency.getId());
        assertEquals(currency.getNumCode(), testCurrency.getNumCode());
        assertEquals(currency.getCharCode(), testCurrency.getCharCode());
        assertEquals(currency.getNominal(), testCurrency.getNominal());
        assertEquals(currency.getName(), testCurrency.getName());
    }

    @Test
    void updateCurrencyInDb_updateCurrency_allFieldsCorrectSaved() {

    }

    @Test
    void deleteAndEvictCurrency() {
    }


}