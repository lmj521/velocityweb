package com.leoman.test.controller;

import com.leoman.common.annotion.RequestLimit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/4.
 */
@Aspect
@Component
public class RequestLimtContract implements ThrowsAdvice{

//    @Autowired
//    private RedisTemplate<String,String> redisTemplate;

    @Before(value = "within(@org.springframework.stereotype.Controller *) && @annotation(limit)")
    public void requestLimit(JoinPoint joinPoint,RequestLimit limit) throws Exception {

        System.out.println("================requestLimit()===============");
//        Object[] args = joinPoint.getArgs();
//        HttpServletRequest request = null;
//        for (int i = 0;i < args.length; i++) {
//            request = (HttpServletRequest) args[i];
//            break;
//        }
//        if(request == null) {
//            throw new Exception("request is null");
//        }
//        String ip = request.getRemoteAddr();
//        String url = request.getRequestURL().toString();
//        String key = "req_limit".concat(url).concat(ip);
//        long count = redisTemplate.opsForValue().increment(key,1);
//        if(count  == 1) {
//            redisTemplate.expire(key,requestLimit.time(), TimeUnit.MILLISECONDS);
//        }
//        if(count > requestLimit.count()) {
//            System.out.println("用户IP:[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + requestLimit.count() + "]");
//        }
    }
}
