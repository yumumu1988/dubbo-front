package com.yumumu.front.utils;

import com.yumumu.front.annotation.CommandInfo;
import com.yumumu.front.model.ChangeSlide;
import com.yumumu.front.model.ChangeWidget;
import com.yumumu.front.service.BaseService;
import com.yumumu.front.service.Impl.ChangeSlideService;
import com.yumumu.front.service.Impl.ChangeWidgetService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommandServiceUtils implements ApplicationListener<ContextRefreshedEvent> {

    private Map<Class, BaseService> innerServiceMap  = new HashMap<>();

    public <T> Boolean executeCommand(T t){
        return innerServiceMap.get(t.getClass()).processCommand(t);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null){
            Map<String, Object> beansWithAnnotation = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(CommandInfo.class);
            for (Object o : beansWithAnnotation.values()){
                CommandInfo commandInfo = AnnotationUtils.findAnnotation(o.getClass(), CommandInfo.class);
                System.out.println(commandInfo.commandName());
                innerServiceMap.put(commandInfo.commandPojoClass(), (BaseService) o);
            }
        }
    }
}
