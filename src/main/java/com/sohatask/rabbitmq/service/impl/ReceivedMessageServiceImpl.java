package com.sohatask.rabbitmq.service.impl;


import com.sohatask.rabbitmq.domain.ReceivedMessage;
import com.sohatask.rabbitmq.repository.MessageRepository;
import com.sohatask.rabbitmq.service.ReceivedMessageService;
import org.springframework.stereotype.Service;

@Service
public class ReceivedMessageServiceImpl implements ReceivedMessageService {

    private final MessageRepository messageRepository;


    public ReceivedMessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public ReceivedMessage saveMessage(String message) {
        ReceivedMessage receivedMessage = new ReceivedMessage();
        receivedMessage.setMessage(message);
        return messageRepository.save(receivedMessage);
    }
}
