package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextUtil {
    private volatile static ContextUtil instance;
    private ApplicationContext context;

    public static ContextUtil getInstance() {

        if (instance == null) {
            synchronized (ContextUtil.class) {
                if (instance == null)
                    instance = new ContextUtil();

            }
        }
        return instance;
    }

    public ApplicationContext getContext() {
        if (context != null) {
            return this.context;
        } else {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            return this.context;
        }

    }
    public Object getBean(String beanId){
      return   getContext().getBean(beanId);

    }


}
