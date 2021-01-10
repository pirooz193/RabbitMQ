package com.sohatask.rabbitmq.service;

import com.sohatask.rabbitmq.domain.ReceivedMessage;

public interface ReceivedMessageService {


    ReceivedMessage saveMessage(String message);


}
