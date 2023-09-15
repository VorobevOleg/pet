package ru.vorobev.converters;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vorobev.dto.CurrencyDto;
import ru.vorobev.entities.Currency;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DtoConverter.class)
class DtoConverterTest {

    @Autowired
    private DtoConverter dtoConverter;

    private static CurrencyDto currencyDto;

    @BeforeAll
    public static void init() {
        currencyDto = CurrencyDto.builder()
                .id("R01010")
                .numCode(36)
                .charCode("AUD")
                .nominal(1)
                .name("Австралийский доллар")
                .build();
    }

    @Test
    void convertCurrencyDtoToCurrency_convert_allFieldsConvertedCorrect() {
        Currency currency = dtoConverter.to(currencyDto);
        assertNotNull(currency);
        assertEquals("R01010", currency.getId());
        assertEquals(36, currency.getNumCode());
        assertEquals("AUD", currency.getCharCode());
        assertEquals(1, currency.getNominal());
        assertEquals("Австралийский доллар", currency.getName());
    }
}