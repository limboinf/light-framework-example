package com.example.lightframeworkexample.kafka.consumer;

import com.example.lightframeworkexample.domain.dto.UserDto;
import com.example.lightframeworkexample.kafka.handler.UserConsumerHandler;
import com.limbo.light.lightkafkaspringbootstarter.kafka.AbstractMessageConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class UserEventConsumer extends AbstractMessageConsumer<UserDto, UserConsumerHandler> {

    @KafkaListener(
            id = "UserEventConsumer",
            topics = "tmp_user",
            groupId = "lightGroupId",
            containerFactory = "singleKafkaContainer")
    public void onMessage(ConsumerRecord<String, String> msg, Acknowledgment ack) {
        Optional.ofNullable(msg.value()).ifPresent(v -> super.onReceive(msg.value()));
        ack.acknowledge();
    }

}
