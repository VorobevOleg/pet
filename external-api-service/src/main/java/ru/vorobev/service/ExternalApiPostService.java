package ru.vorobev.service;

import ru.vorobev.entities.dto.ApiDto;

/**
 * Сервис для отправки DTO во внешние системы
 */
public interface ExternalApiPostService {

    /**
     * Отправка DTO во внешние системы
     *
     * @param apiDto - объект с инфой {@link ApiDto}
     */
    void postApiDto(ApiDto apiDto);
}
