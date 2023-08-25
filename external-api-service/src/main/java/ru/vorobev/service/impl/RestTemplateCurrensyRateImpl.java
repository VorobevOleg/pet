package ru.vorobev.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.vorobev.entities.dto.ApiDto;
import ru.vorobev.entities.dto.CbrDailyDto;
import ru.vorobev.service.ExternalApiGetService;
import ru.vorobev.service.ExternalApiPostService;

/**
 * Реализация сервиса, методы которого позволяют взаимодействовать с внешними API через RestTemplate
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RestTemplateCurrensyRateImpl implements ExternalApiGetService, ExternalApiPostService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${external.api.get.currensy-rate.url}")
    private String externalCbrUrl;

    @Value("${inside.api.post.currensy-rate.url}")
    private String mainServicePostCbrUrl;

    /**
     * Получение актуального курса валют с внешнего API
     *
     * @return  - {@link CbrDailyDto} - объект с инфой о курсе валют
     */
    @Override
    public ApiDto getApiDto() {
        log.debug("Getting CbrDailyDto start");
        CbrDailyDto cbrDailyDto;
        try {
            cbrDailyDto = restTemplate.getForObject(externalCbrUrl, CbrDailyDto.class);
        } catch (Exception e) {
            log.error("Error getting cbr daily currency rate", e);
            throw e;
        }
        log.debug("Getting CbrDailyDto complete ok");
        return cbrDailyDto;
    }

    /**
     * Запись в БД main-service через API
     *
     * @param apiDto - объект с инфой о курсе валют
     */
    @Override
    public void postApiDto(ApiDto apiDto) {
        log.debug("Posting CbrDailyDto to main-service start");

        CbrDailyDto cbrDailyDto = (CbrDailyDto) apiDto;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CbrDailyDto> entity = new HttpEntity<>(cbrDailyDto, headers);

        try {
            restTemplate.postForObject(mainServicePostCbrUrl, entity, String.class);
        } catch (Exception e) {
            log.error("Error posting cbr daily to main-service", e);
            throw e;
        }
        log.debug("Posting CbrDailyDto to main-service complete ok");
    }
}
