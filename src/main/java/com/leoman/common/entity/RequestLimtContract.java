package com.leoman.common.entity;

import com.leoman.common.annotion.RequestLimit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/4.
 */
@Aspect
@Component
public class RequestLimtContract {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Before("within(@org.springframework.stereotype.Controller *) && @annotation(requestLimit)")
    public void requestLimit(final JoinPoint joinPoint, RequestLimit requestLimit) throws Exception {

        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;
        for (int i = 0;i < args.length; i++) {
            request = (HttpServletRequest) args[i];
            break;
        }
        if(request == null) {
            throw new Exception("request is null");
        }
        String ip = request.getRemoteAddr();
        String url = request.getRequestURL().toString();
        String key = "req_limit".concat(url).concat(ip);
        long count = redisTemplate.opsForValue().increment(key,1);
        if(count  == 1) {
            redisTemplate.expire(key,requestLimit.time(), TimeUnit.MILLISECONDS);
        }
        if(count > requestLimit.count()) {
            System.out.println("用户IP:[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + requestLimit.count() + "]");
        }
    }
}
