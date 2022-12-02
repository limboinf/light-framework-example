package com.example.lightframeworkexample.eventhub;

import com.limbo.light.lighteventhubspringbootstarter.eventhub.EventConsume;
import com.limbo.light.lighteventhubspringbootstarter.eventhub.EventHubDto;
import com.limbo.light.lighteventhubspringbootstarter.eventhub.EventProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@EventConsume(identifier = "point")
@Component
public class PointLogConsume implements EventProcess<PointEventDto> {

    @Override
    public void process(EventHubDto<PointEventDto> eventHubDto) {
        log.info("point接收事件: {}", eventHubDto);
    }
}
