package com.viepub.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-6
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {

    @PostConstruct
    public void init(){
        System.out.println("@postConstruct");
    }

    public void initUserFactory(){
        System.out.println("initUserFactory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
