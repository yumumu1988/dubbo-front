package com.yumumu.front.utils;

import com.yumumu.front.annotation.CommandInfo;
import com.yumumu.front.model.ChangeSlide;
import com.yumumu.front.model.ChangeWidget;
import com.yumumu.front.service.BaseService;
import com.yumumu.front.service.Impl.ChangeSlideService;
import com.yumumu.front.service.Impl.ChangeWidgetService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommandServiceUtils2 implements BeanPostProcessor {

    private Map<Class, BaseService> innerServiceMap  = new HashMap<>();

    public <T> Boolean executeCommand(T t){
        return innerServiceMap.get(t.getClass()).processCommand(t);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean != null) {
            CommandInfo commandInfo = AnnotationUtils.findAnnotation(bean.getClass(), CommandInfo.class);
            if (null != commandInfo) {
                //插入到数据中
                System.out.println(commandInfo.commandName());
                System.out.println(commandInfo.commandPojoClass());

                innerServiceMap.put(commandInfo.commandPojoClass(), (BaseService)bean);
            }
        }
        return bean;
    }
}
