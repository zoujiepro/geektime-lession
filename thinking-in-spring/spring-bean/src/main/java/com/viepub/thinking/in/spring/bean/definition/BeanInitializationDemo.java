package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.viepub.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

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
        System.out.println("spring 关闭");
    }


    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
