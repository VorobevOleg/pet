package ru.vorobev.services;

import ru.vorobev.dto.CurrencyDto;
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

    /**
     * Сохранение новой валюты в базу
     *
     * @param currencyDto - пришедший с контроллера объект с инфой для создания новой валюты
     * @return {@link Currency} - успешно сохранненная в БД валюта
     */
    Currency saveCurrency(CurrencyDto currencyDto);

    /**
     * Удаление валюты из базы по id
     *
     * @param id - id валюты
     */
    void deleteAndEvictCurrency(String id);

    /**
     * Получение списка всех валют из базы
     *
     * @param currencyDto - пришедший с контроллера объект с инфой для обновления существующей валюты
     */
    void updateCurrency(CurrencyDto currencyDto);
}
