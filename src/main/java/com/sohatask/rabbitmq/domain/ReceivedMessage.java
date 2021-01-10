package com.sohatask.rabbitmq.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "received_messages")
@Getter
@Setter
public class ReceivedMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "message_text")
    private String message;
}
