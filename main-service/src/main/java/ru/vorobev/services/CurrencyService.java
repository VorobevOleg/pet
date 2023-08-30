package ru.vorobev.services;

import ru.vorobev.entities.Currency;

import java.util.List;

/**
 * Сервис для работы с валютами
 */
public interface CurrencyService {

    /**
     * Получение списка всех валют из базы
     *
     * @return  - список {@link Currency}
     */
    List<Currency> getAllCurrency();
}
