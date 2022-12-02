package com.example.lightframeworkexample.service.impl;

import com.example.lightframeworkexample.eventhub.PointEventDto;
import com.example.lightframeworkexample.service.UserService;
import com.google.common.base.Stopwatch;
import com.limbo.light.lighteventhubspringbootstarter.eventhub.EventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author limbo
 * @since 2022/12/2 21:06
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EventProducer eventProducer;

    @Override
    public String getUserName(Long userId) {

        log.info("getUserName - userId: [{}]", userId);

        // eventhub
        final PointEventDto event = new PointEventDto("10010", "发消息事件");
        List<PointEventDto> eventDtoList = new ArrayList<>();
        eventProducer.post("不存在的identifier", new PointEventDto("10012", "其他事件"));

        final Stopwatch start = Stopwatch.createStarted();
        for (int i = 0; i < 10; i++) {
            eventDtoList.add(event);
        }

        // 批量发送
        eventProducer.post("point", eventDtoList);
        final long elapsed = start.elapsed(TimeUnit.MILLISECONDS);
        log.info("执行耗时: {}ms", elapsed);

        return "Limbo";
    }
}
