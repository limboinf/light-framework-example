package com.example.lightframeworkexample.kafka.handler;

import com.example.lightframeworkexample.domain.dto.UserDto;
import com.limbo.light.lightkafkaspringbootstarter.kafka.ConsumeMessageHandler;
import com.limbo.light.log.aop.TraceId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description
 *
 * @author limbo
 * @since 2022/12/6 14:40
 */
@Slf4j
@Service
public class UserConsumerHandler implements ConsumeMessageHandler<UserDto> {

    @Resource(name = "lightKafkaTemplate")
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    @TraceId
    public void process(UserDto message) {
        log.info("接受kafka消息: [{}]", message);
        // 验证消息
        checkValidate(message);
        // 发送到另外kafka
        kafkaTemplate.send("tmp_user_back", message);
    }
}
