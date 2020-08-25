package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.viepub.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-13
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //外部单例对象
        UserFactory userFactory = new DefaultUserFactory();

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("userFactory",userFactory);

        applicationContext.refresh();

        UserFactory bean = beanFactory.getBean(UserFactory.class);
        System.out.println(bean == userFactory);

        applicationContext.close();



    }
}
