package com.example.demo.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class TidiAspect {
    @Pointcut("@annotation(com.example.demo.Aspect.Tidi)")
    public void testPointCut(){

    }

    @Before("testPointCut()")
    public void test(JoinPoint joinPoint){
        log.info("test");
        System.out.println("test");
    }
}
