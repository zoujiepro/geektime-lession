package com.viepub.thinking.in.spring.ioc.overview.dependency.injection;

import com.viepub.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-4
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("dependency-injection.context.xml");

        summary4(applicationContext);
    }

    /**
     *
     * applicationContext内部的beanFactory 与对象依赖注入的beanFactory是同一对象
     * @param context
     */
    private static void summary4(AbstractRefreshableApplicationContext context){
        UserRepository userRepository = context.getBean(UserRepository.class);

        BeanFactory beanFactory = userRepository.getBeanFactory();

        System.out.println(beanFactory == context.getBeanFactory());
    }

    /**
     * BeanFactory 和 ApplicationContext
     *
     * ApplicationContext是BeanFactory子接口
     * beanFactory是一个最基础的IOC容器，ApplicationContext在此基础上
     * 提供了更多的企业级别的功能性，ApplicationContext是beanFactory的超集
     *
     * aop特性
     * 消息资源国际化
     * 事件发布
     * 应用层级别容器，例如WebApplicationContext
     * 环境变量
     *
     * @link "https://docs.spring.io/spring/docs/5.2.8.RELEASE/spring-framework-reference/core.html#beans-introduction"
     * @param beanFactory
     */
    private static void summary3(BeanFactory beanFactory){
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        /**
         * 表达式为什么不成立
         * ApplicationContext 实现了BeanFactory接口，内部定义了 DefaultListableBeanFactory beanFactory，类似于代理
         */
        System.out.println("userRepository.getBeanFactory():" + userRepository.getBeanFactory());
        System.out.println("beanFactory:" + beanFactory);
        System.out.println("userRepository.getBeanFactory() == beanFactory : " + (userRepository.getBeanFactory() == beanFactory));
    }

    /**
     *依赖来源
     * 1 自定义bean
     * 2 容器内建bean对象
     * 3 容器内建依赖
     * @param beanFactory
     */
    private static void summary2(BeanFactory beanFactory){

        //依赖来源一：自定义bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        //依赖来源二：依赖注入（内建依赖）
        System.out.println(userRepository.getBeanFactory());

        //依赖来源三：容器内建（依赖）bean
        Environment bean = beanFactory.getBean(Environment.class);
        System.out.println("获取的Environment类型对象" + bean);


    }

    /**
     *得出结论 依赖查找和依赖注入不是同一来源
     * @param beanFactory
     */
    private static void summary1(BeanFactory beanFactory){
        UserRepository bean = beanFactory.getBean(UserRepository.class);

        System.out.println(bean.getUsers());

        //依赖注入
        System.out.println(bean.getBeanFactory() == beanFactory);

//      依赖查找（错误）
//      System.out.println(beanFactory.getBean(BeanFactory.class));

        System.out.println(bean.getObjectFactory().getObject());
    }
}
