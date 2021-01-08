package com.sohatask.rabbitmq.consumer;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Receiver {

    private static final String QUEUE_NAME = "My_Queue";

    public static <T> void receive(Class<T> clazz) {

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            Logger logger = LoggerFactory.getLogger(clazz);


            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    logger.info(" [x] Received '" + message + "'");

                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR!!!");
        }

    }
}