package com.yumumu.front.service.Impl;

import com.yumumu.front.annotation.CommandInfo;
import com.yumumu.front.model.ChangeWidget;
import com.yumumu.front.service.BaseService;
import org.springframework.stereotype.Service;

@Service
@CommandInfo(commandName = "change_widget", commandPojoClass = com.yumumu.front.model.ChangeWidget.class)
public class ChangeWidgetService implements BaseService<ChangeWidget> {
    @Override
    public Boolean processCommand(ChangeWidget changeWidget) {
        System.out.println("ChangeWidgetService==>False");
        return false;
    }
}
