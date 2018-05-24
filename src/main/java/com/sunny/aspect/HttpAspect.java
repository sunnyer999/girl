package com.sunny.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.sunny.controller.GirlController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}", request.getRequestURL());

        logger.info("method={}", request.getMethod());

        logger.info("ip={}", request.getRemoteAddr());

//        logger.info("class_method={}",joinPoint.);
//
//        logger.info("args={}",j);
    }

    @After("log()")
    public void doAfter() {
        logger.info("2222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
