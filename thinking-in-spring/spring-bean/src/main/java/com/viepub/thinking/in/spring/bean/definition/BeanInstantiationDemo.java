package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-6
 */
public class BeanInstantiationDemo {

    private static String path = "bean-instantiation-context.xml";

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);

//        <!--静态方法实例化-->
        User beanByStatic = beanFactory.getBean("user-by-static", User.class);

//        <!--实例化(bean)方法实例化-->
        User beanByMethod = beanFactory.getBean("user-by-method", User.class);

//        <!--factoryBean方式实例化(包含初始化)-->
        User beanByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);


        System.out.println(beanByStatic);
        System.out.println(beanByMethod);
        System.out.println(beanByFactoryBean);
        System.out.println(beanByMethod == beanByStatic);
        System.out.println(beanByMethod == beanByFactoryBean);

    }
}
