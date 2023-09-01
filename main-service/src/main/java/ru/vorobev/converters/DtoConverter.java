package ru.vorobev.converters;

import org.springframework.stereotype.Component;
import ru.vorobev.dto.CurrencyDto;
import ru.vorobev.entities.Currency;

/**
 * Конвертер дто в сущности и обратно
 */
@Component
public class DtoConverter {
    public Currency to(CurrencyDto currencyDto) {

        Currency currency = new Currency();

        currency.setId(currencyDto.getId());
        currency.setNumCode(currencyDto.getNumCode());
        currency.setCharCode(currencyDto.getCharCode());
        currency.setNominal(currency.getNominal());
        currency.setName(currencyDto.getName());

        return currency;
    }
}
