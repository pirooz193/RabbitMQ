package com.sohatask.rabbitmq.repository;


import com.sohatask.rabbitmq.domain.ReceivedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<ReceivedMessage,Long> {
}
