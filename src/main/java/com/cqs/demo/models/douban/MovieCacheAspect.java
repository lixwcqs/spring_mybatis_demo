package com.cqs.demo.models.douban;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 会忽略从父类继承而来的方法
 * <p>
 * Created by cqs on 17-1-4.
 */
@Aspect
@Component
public class MovieCacheAspect {


    //    @Pointcut("execution(* com.cqs.demo.models.douban.service.impl.MovieServiceImpl.*(..))")
    @Pointcut("execution(* com.cqs.demo.models.douban.AopClient.*(..))")
    private void aopClient() {
    }

    @Pointcut("execution(* com.cqs.demo.commons.base.service.BaseServiceImpl+.*(..))")
    private void movieService() {
    }


    @Around("movieService() || aopClient()")
    public Object stopWatch(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object obj = pjp.proceed();
        Object target = pjp.getTarget();
        Object[] args = pjp.getArgs();
        Object aThis = pjp.getThis();
        pjp.getSignature();
        stopWatch.stop();
        System.out.println("运行时间: " + stopWatch.getTotalTimeMillis() + " 毫秒");
        return obj;
    }
}