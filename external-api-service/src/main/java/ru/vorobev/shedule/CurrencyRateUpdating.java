package ru.vorobev.shedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.vorobev.entities.dto.CbrDailyDto;
import ru.vorobev.rabbitmq.RabbitSender;
import ru.vorobev.service.ExternalApiGetService;
import ru.vorobev.service.ExternalApiPostService;

/**
 * Класс для обновления информации о курсах валют с методами, которые работают по расписанию
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyRateUpdating {

    private final ExternalApiGetService externalApiGetService;
    private final ExternalApiPostService externalApiPostService;
    private final RabbitSender rabbitSender;

    @Scheduled(fixedDelay = 10000, initialDelay = 1000)    // REST
    public void updateFromRestInMainService() {

        CbrDailyDto cbrDailyDto =  (CbrDailyDto) externalApiGetService.getApiDto();

        externalApiPostService.postApiDto(cbrDailyDto);

    }

    @Scheduled(fixedDelay = 5000, initialDelay = 1000)  // REST + Broker
    public void updateFromBrokerInMainService() {

        CbrDailyDto cbrDailyDto =  (CbrDailyDto) externalApiGetService.getApiDto();

        rabbitSender.send(cbrDailyDto);
    }

}
