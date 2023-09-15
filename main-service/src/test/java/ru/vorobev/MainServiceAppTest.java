package ru.vorobev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vorobev.controllers.CurrencyController;
import ru.vorobev.controllers.CurrencyRateController;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainServiceAppTest {

    @Autowired
    private CurrencyController currencyController;
    @Autowired
    private CurrencyRateController currencyRateController;
    @Test
    public void contextLoads() {
        assertNotNull(currencyController, "CurrencyController not load");
        assertNotNull(currencyRateController, "CurrencyRateController not load");
    }
}