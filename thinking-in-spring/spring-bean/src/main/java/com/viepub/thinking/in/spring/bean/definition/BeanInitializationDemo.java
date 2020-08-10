package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.viepub.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Descrption :
 * 初始化的三种方式
 * @Author: zoujie
 * @Date: 2020-8-10
 */
public class BeanInitializationDemo {

    private static String path = "bean-special-instantiation-context.xml";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();

//        UserFactory userFactory = applicationContext.getBean("userFactory", UserFactory.class);
//        System.out.println(userFactory);

        applicationContext.close();
    }


    @Bean(initMethod = "initUserFactory")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
