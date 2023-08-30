package ru.vorobev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vorobev.entities.Currency;
import ru.vorobev.services.CurrencyService;

import java.util.List;

/**
 * Контроллер для работы с валютами
 */
@RestController
@RequestMapping("/currensy")
@RequiredArgsConstructor
public class CurrensyController {

    private final CurrencyService currencyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Currency> getAllCurrency() {
        return currencyService.getAllCurrency();
    }

}
