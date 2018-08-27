package com.yumumu.front.service.Impl;

import com.yumumu.front.annotation.CommandInfo;
import com.yumumu.front.model.ChangeSlide;
import com.yumumu.front.service.BaseService;
import org.springframework.stereotype.Service;

@Service
@CommandInfo(commandName = "change_slide", commandPojoClass = com.yumumu.front.model.ChangeSlide.class)
public class ChangeSlideService implements BaseService<ChangeSlide> {
    @Override
    public Boolean processCommand(ChangeSlide changeSlide) {
        System.out.println("ChangeSlideService==>True");
        return true;
    }
}
