package com.leoman.test.controller;

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
    public void aes(@RequestParam Map<String,Object> map) {
        for (Map.Entry<String,Object> params : map.entrySet()) {
            System.out.println("key:" + params.getKey() + "==value" + params.getValue());
        }
    }
}
