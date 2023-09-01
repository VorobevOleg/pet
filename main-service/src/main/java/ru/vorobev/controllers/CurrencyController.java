package ru.vorobev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vorobev.dto.CurrencyDto;
import ru.vorobev.entities.Currency;
import ru.vorobev.services.CurrencyService;

import java.util.List;

/**
 * Контроллер для работы с валютами
 */
@RestController
@RequestMapping("/currensy")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Currency> getAllCurrency() {
        return currencyService.getAllCurrency();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCurrency(@RequestBody CurrencyDto currencyDto) {
        currencyService.saveCurrency(currencyDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCurrency(@RequestBody CurrencyDto currencyDto) {
        currencyService.updateCurrency(currencyDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCurrency(@PathVariable String id) {
        currencyService.deleteCurrency(id);
    }

}
