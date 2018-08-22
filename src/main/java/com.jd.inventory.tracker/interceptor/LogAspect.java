package com.jd.inventory.tracker.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.com.jd.inventory.tracker.controller.rest.*.*(..))")
    public void methodExec() {
    }

    @Around("methodExec()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String method = "";
        try {
            long start = System.currentTimeMillis();
            method = point.getSignature().getName();
            beforeLog(method);
            Object[] args = point.getArgs();
            Object result = point.proceed(args);
            endLog(start, method, result);
            return result;
        } catch (Throwable e) {
            logger.info("error : " + method);
            throw e;
        }
    }

    private void beforeLog(String method) {
        logger.info("enter " + method);
    }

    private void endLog(long start, String method, Object result) {
        long div = System.currentTimeMillis() - start;
        logger.info("end {} spend={}, with result={}", method, div, JSONObject.toJSON(result).toString());
    }
}