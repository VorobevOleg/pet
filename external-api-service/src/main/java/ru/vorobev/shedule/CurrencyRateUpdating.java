package ru.vorobev.shedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.vorobev.entities.dto.CbrDailyDto;
import ru.vorobev.service.ExternalApiGetService;
import ru.vorobev.service.ExternalApiPostService;

/**
 * Класс с методами, которые работают по расписанию
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyRateUpdating {

    private final ExternalApiGetService externalApiGetService;
    private final ExternalApiPostService externalApiPostService;

    @Scheduled(fixedDelay = 10000)
    public void updateRestInMainService() {

        CbrDailyDto cbrDailyDto =  (CbrDailyDto) externalApiGetService.getApiDto();

        externalApiPostService.postApiDto(cbrDailyDto);

    }

}
