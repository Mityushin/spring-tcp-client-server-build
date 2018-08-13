package ru.protei.tcpserver.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class WebServiceLogger {

    @Autowired
    private Logger log;

    public WebServiceLogger() {
    }

    @Pointcut(value = "execution(public * *(..))")
    public void webServicePublicMethod() {}

    @Pointcut(value = "@annotation(ru.protei.tcpserver.annotation.Loggable)")
    public void loggableMethod() {}

    @Around(value = "webServicePublicMethod() && loggableMethod()")
    public Object logWebServiceCall(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        log.debug("CALL METHOD " + methodName + " with args " + Arrays.toString(methodArgs));

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("FAIL CALL METHOD " + methodName, throwable);
        }

        log.debug("METHOD " + methodName + " returns " + result);

        return result;
    }
}
