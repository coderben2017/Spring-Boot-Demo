package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP统一请求拦截处理
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.UserController.*(..))")
    public void log() {
        logger.info("此处是自定义日志");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("这里是请求接受前处理");
        logger.info("ip = {}", request.getRequestURL());
        logger.info("method = {}", request.getMethod());
        logger.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName()
                + '.' + joinPoint.getSignature().getName());
        logger.info("arguments = {}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("请求完成处理");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response = {}", object.toString());
    }

}
