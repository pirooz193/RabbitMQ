package com.sohatask.rabbitmq.consumer;

import com.sohatask.rabbitmq.domain.Person;
import com.sohatask.rabbitmq.service.ReceivedMessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private final ReceivedMessageService receivedMessage;

    public RabbitMQConsumer(ReceivedMessageService receivedMessage) {
        this.receivedMessage = receivedMessage;
    }


    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void receiveMessage(Person person) {

        receivedMessage.saveMessage(person.toString());
        System.out.println("Receive Message from  RabbitMQ : " + person);

    }
}
