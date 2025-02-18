package com.namnp.portfolio_service.aop;

import com.namnp.portfolio_service.model.AssetType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@Aspect
public class LogginAspect {
    private static final Logger log = LoggerFactory.getLogger(LogginAspect.class);

    //return type, full-qualified-class-name.method name(argument)
    @Before("execution(* com.namnp.portfolio_service.scheduler.Scheduler.*(..))")
    public void logFetchStart(JoinPoint jp){
        log.info("=============================== Job start " + jp.getSignature().getName() + " ===============================");
    }

    @After("execution(* com.namnp.portfolio_service.scheduler.Scheduler.*(..))")
    public void logFetchEnd(JoinPoint jp){
        log.info("=============================== Job end " + jp.getSignature().getName() + " ===============================");
    }
}
