package ru.vorobev.services.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vorobev.converters.DtoConverter;
import ru.vorobev.dto.CurrencyDto;
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

    private static CurrencyDto testCurrencyDto;
    private static CurrencyDto testCurrencyDtoToUpdate;

    @BeforeAll
    private static void init() {
        testCurrencyDto = CurrencyDto.builder()
                .id("Test")
                .numCode(999)
                .charCode("TES")
                .nominal(1)
                .name("Test currency")
                .build();
        testCurrencyDtoToUpdate = CurrencyDto.builder()
                .id("Test")
                .numCode(998)
                .charCode("TET")
                .nominal(2)
                .name("Test currency updated")
                .build();
    }

    @Test
    void getAllCurrencyFromDb_findAll_notEmptyResponse() {
        List<Currency> currencyList = service.getAllCurrency();
        assertNotNull(currencyList);
        assertFalse(currencyList.isEmpty());
    }

    @Test
    void saveCurrencyToDb_saveCurrency_allFieldsCorrectSaved() {
        Currency currency = service.saveCurrency(testCurrencyDto);
        assertNotNull(currency);
        assertEquals(currency.getId(), testCurrencyDto.getId());
        assertEquals(currency.getNumCode(), testCurrencyDto.getNumCode());
        assertEquals(currency.getCharCode(), testCurrencyDto.getCharCode());
        assertEquals(currency.getNominal(), testCurrencyDto.getNominal());
        assertEquals(currency.getName(), testCurrencyDto.getName());
    }

    @Test
    void updateCurrencyInDb_updateCurrency_allFieldsCorrectSaved() {

    }

    @Test
    void deleteAndEvictCurrency() {
    }


}