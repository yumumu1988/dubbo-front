package com.yumumu.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import enums.ApiResponseEnum;
import model.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import response.ApiResponse;
import service.SlideService;

@RestController
public class MyController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}", check = false)
    private SlideService slideService;

    @RequestMapping(value = "/slide/{id}", method = RequestMethod.GET)
    public Slide getSlideById(@PathVariable("id") Integer id){
        ApiResponse<Slide> response = slideService.getSlideById(id);
        redisTemplate.opsForValue().set("test", "123");
        String x = redisTemplate.opsForValue().get("test").toString();
        if (ApiResponseEnum.Success == response.getStatus()){
            return response.getBody();
        } else {
            return new Slide();
        }
    }



}
