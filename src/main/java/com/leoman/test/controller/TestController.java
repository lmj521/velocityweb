package com.leoman.test.controller;

import com.leoman.test.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/1.
 */
@RequestMapping("/admin/test")
@Controller
public class TestController {

    @RequestMapping(value = "/aes")
    public void aes(TestEntity testEntity) {
        System.out.println(testEntity.toString());
    }
}
