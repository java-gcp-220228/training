package com.revature.HelloSpringBoot.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before(value = "execution(* com.revature.HelloSpringBoot.*.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("testing");
        logger.debug("Before method: " + joinPoint.getSignature());
        logger.info("User is making a request...");
    }

    @After(value = "execution(* com.revature.HelloSpringBoot.*.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("end");
        logger.debug("After method: " + joinPoint.getSignature());
        logger.info("User's request is now complete.");
    }
}
