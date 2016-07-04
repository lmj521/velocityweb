package com.leoman.test.controller;

import com.leoman.common.annotion.RequestLimit;
import com.leoman.test.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/7/1.
 */

@RequestMapping("/admin/test")
@Controller
public class TestController {

    @RequestLimit(count = 5)
    @RequestMapping(value = "/aes")
    public void aes(TestEntity testEntity) {
        System.out.println(testEntity.toString());
    }
}
