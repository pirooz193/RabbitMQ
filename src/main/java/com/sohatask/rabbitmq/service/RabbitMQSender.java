package com.sohatask.rabbitmq.service;

import com.sohatask.rabbitmq.domain.Person;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    private final AmqpTemplate rabbitTemplate ;
    public RabbitMQSender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingKey;



    public void send(Person person){
        rabbitTemplate.convertAndSend("javainuse.exchange","javainuse.routingkey",  person);
        System.out.println("sent : "+ person);
    }
}
