package ru.vorobev.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vorobev.dto.CbrDailyDto;

@Slf4j
@Component
public class RabbitSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send(CbrDailyDto cbrDailyDto) {
        try {
            template.convertAndSend(queue.getName(), cbrDailyDto);
        } catch (Exception e) {
            System.out.println("Error send() RabbitMQ");
            log.error("Pu-pu-pu : ", e);
            return;
        }

        System.out.println(" [x] Sent '" + cbrDailyDto + "'");
    }
}
