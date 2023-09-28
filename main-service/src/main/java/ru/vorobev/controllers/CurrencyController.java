package ru.vorobev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vorobev.entities.Currency;
import ru.vorobev.services.CurrencyService;

import java.util.List;

/**
 * Контроллер для работы с валютами
 */
@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Currency> getAllCurrency() {
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Currency getCurrencyById(@PathVariable String id) {
        return currencyService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCurrency(@RequestBody Currency currency) {
        currencyService.saveAndRefreshCache(currency);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCurrency(@RequestBody Currency currency) {
        currencyService.updateAndRefreshCache(currency);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCurrencyById(@PathVariable String id) {
        currencyService.deleteAndEvict(id);
    }

}
