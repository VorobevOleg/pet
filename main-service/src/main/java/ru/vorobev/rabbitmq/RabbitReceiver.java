package ru.vorobev.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.vorobev.dto.CbrDailyDto;
import ru.vorobev.services.CurrencyRateService;

@Slf4j
@Component
@RabbitListener(queues = "cbrDailyQueue")
@RequiredArgsConstructor
public class RabbitReceiver {

    private final CurrencyRateService currencyRateService;

    @RabbitHandler
    public void receive(CbrDailyDto cbrDailyDto) {
        log.info(" [x] Received {}", cbrDailyDto);
        log.debug("BROKER: Saving in DB CbrDailyDto timestamp: '{}'", cbrDailyDto.getTimestamp());
        currencyRateService.saveCbrDailyDto(cbrDailyDto);
        log.debug("BROKER: Saved in DB CbrDailyDto timestamp: '{}'", cbrDailyDto.getTimestamp());
    }
}
