package com.example.lightframeworkexample.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author limbo
 * @since 2022/12/1 21:41
 */
@Slf4j
@Component
public class UserSchedule {

    @Scheduled(cron = "0/30 * * * * ?")
    public void task() {
        log.info("开启定时任务 ...");
    }
}
