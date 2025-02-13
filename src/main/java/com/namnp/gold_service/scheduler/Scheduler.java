package com.namnp.gold_service.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(cron = "0 */10 * * * *")
    public void reportCurrentTime() {
        log.info("job run");
    }
}
