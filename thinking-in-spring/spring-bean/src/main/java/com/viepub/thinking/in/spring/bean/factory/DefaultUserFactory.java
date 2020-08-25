package com.viepub.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-6
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

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

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy 销毁");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口 销毁");
    }

    public void doDestroy(){
        System.out.println("自定义 doDestroy");
    }
}
