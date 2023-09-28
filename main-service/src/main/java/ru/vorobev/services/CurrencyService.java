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
     * @return  список {@link Currency}
     */
    List<Currency> getAll();

    /**
     * Получение валюты {@link Currency} по id
     *
     * @param id id валюты
     * @return {@link Currency}, найденная по id
     */
    Currency getById(String id);

    /**
     * Сохранение новой валюты в базу
     *
     * @param currency пришедший с контроллера объект с инфой для создания новой валюты
     * @return {@link Currency} - успешно сохранненная в БД валюта
     */
    Currency saveAndRefreshCache(Currency currency);

    /**
     * Удаление валюты из базы по id
     *
     * @param id id валюты
     */
    void deleteAndEvict(String id);

    /**
     * Обновление валюты в базе
     *
     * @param currency пришедший с контроллера объект с инфой для обновления валюты
     * @return {@link Currency} - успешно обновленная в БД валюта
     */
    Currency updateAndRefreshCache(Currency currency);
}
