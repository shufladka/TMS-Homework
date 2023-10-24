package org.tms.utilities;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("@annotation(org.tms.utilities.MyAnnotation)")
    public void myPointCut() {
    }

    @Around("myPointCut()")
    public void doAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.nanoTime();
        proceedingJoinPoint.proceed();

        long end = System.nanoTime();
        System.out.println("Время гонки: " + (end - start));
    }
}