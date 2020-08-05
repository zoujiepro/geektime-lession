package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-5
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-definition-context.xml");

        User user = beanFactory.getBean("user", User.class);
        User viepubUser = beanFactory.getBean("viepub-user", User.class);

        System.out.println(user == viepubUser);
    }
}
