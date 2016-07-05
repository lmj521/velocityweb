package com.leoman.test.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/5.
 */
@Component
@Aspect
public class AspectTest {

    @Before(value="execution(* com.leoman.index.service.impl.LoginServiceImpl.login(..))")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("=============doBefore()==============");
    }
}
