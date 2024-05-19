package com.example.petshopproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopPets {
    @Before("execution(* com.example.petshopproject.services.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        log.info("The "+joinPoint.getSignature().getName()+" is running");
    }
}
