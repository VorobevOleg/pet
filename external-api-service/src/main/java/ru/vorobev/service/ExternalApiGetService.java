package ru.vorobev.service;

import ru.vorobev.dto.ApiDto;

/**
 * Сервис для получения информации с внешних API
 */
public interface ExternalApiGetService {

    /**
     * Получение объекта с инфой с внешнего API
     *
     * @return  - {@link ApiDto} - объект с инфой
     */
    ApiDto getApiDto();

}
