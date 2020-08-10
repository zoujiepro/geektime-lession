package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.viepub.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
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

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();


//        serviceLoaderFactoryBeanDemo(applicationContext);

//        serviceLoaderDemo();

        DefaultUserFactory bean = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(bean);
    }

    /**
     * spring 适配 jdk serviceLoader
     * @see ServiceLoaderFactoryBean
     * @param beanFactory
     */
    private static void serviceLoaderFactoryBeanDemo(BeanFactory beanFactory) {
        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader",ServiceLoader.class);

        displayServiceLoader(serviceLoader);
    }


    /**
     * jdk 实现IOC方式
     * @see ServiceLoader
     */
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
