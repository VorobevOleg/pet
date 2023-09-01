package ru.vorobev.converters;

import org.springframework.stereotype.Component;
import ru.vorobev.dto.CurrensyDto;
import ru.vorobev.entities.Currency;

/**
 * Конвертер дто в сущности и обратно
 */
@Component
public class DtoConverter {
    public Currency to(CurrensyDto currensyDto) {

        Currency currency = new Currency();

        currency.setId(currensyDto.getId());
        currency.setNumCode(currensyDto.getNumCode());
        currency.setCharCode(currensyDto.getCharCode());
        currency.setNominal(currency.getNominal());
        currency.setName(currensyDto.getName());

        return currency;
    }
}
