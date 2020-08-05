package com.viepub.thinking.in.spring.ioc.overview.container;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-4
 */
public class AnnotationApplicationContextAsIoCContainer {

    private static String beanDefinitionPath = "classpath:dependency-injection.context.xml";

    @Bean
    public User user1() {
        User user = new User();
        user.setId(1l);
        user.setName("viepub");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIoCContainer.class);
        applicationContext.refresh();

        getBeansOfType(applicationContext);

    }

    private static void getBeansOfType(BeanFactory beanFactory) {
        Map<String, User> beansOfType = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
        System.out.println(beansOfType);
    }
}
