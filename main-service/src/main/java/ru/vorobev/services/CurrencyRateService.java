package ru.vorobev.services;

import ru.vorobev.dto.CbrDailyDto;
import ru.vorobev.entities.CurrencyRate;

/**
 * Сервис для работы с курсами валют
 */
public interface CurrencyRateService {

    /**
     * Конвертация {@link CbrDailyDto} и сохранение в виде списка {@link CurrencyRate} в базу
     *
     * @param cbrDailyDto - информация о валютах, пришедшая из вне
     */
    void saveCbrDailyDto(CbrDailyDto cbrDailyDto);
}
