package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Descrption 特殊的实例化bean
 *
 * @see ServiceLoader
 * 1. ServiceLoader
 *
 *
 * @Author: zoujie
 * @Date: 2020-8-6
 */
public class SpecialBeanInstantiationDemo {

    private static String path = "bean-special-instantiation-context.xml";

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);


        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader",ServiceLoader.class);

        displayServiceLoader(serviceLoader);

//        serviceLoaderDemo();
    }


    public static void serviceLoaderDemo(){
        ServiceLoader<UserFactory> load = ServiceLoader.load(UserFactory.class);
        displayServiceLoader(load);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader){
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().createUser());
        }
    }
}
