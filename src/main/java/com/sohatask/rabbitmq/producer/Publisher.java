package com.sohatask.rabbitmq.producer;

import com.rabbitmq.client.*;

public class Publisher {

    private final static String QUEUE_NAME = "My_Queue";

    public static void publish() {
        try {

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String message = "add to Queue";
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}