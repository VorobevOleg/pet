package ru.vorobev.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.vorobev.dto.CbrDailyDto;

@Slf4j
@Component
@RabbitListener(queues = "cbrDailyQueue")
public class RabbitReceiver {

    @RabbitHandler
    public void receive(CbrDailyDto cbrDailyDto) {
        System.out.println(" [x] Received '" + cbrDailyDto + "'");
    }
}
