package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-5
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)  //方式3
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();
        registryUserBeanDefinition(beanFactory,"user");

        beanFactory.refresh();

        Object user = beanFactory.getBean("user");
        System.out.println(user);
    }

    public static void registryUserBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry){
        registryUserBeanDefinition(beanDefinitionRegistry,null);
    }

    public static void registryUserBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry, String beanName){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        builder.addPropertyValue("id",11L);
        builder.addPropertyValue("name","viepub");

        registryBeanDefinition(beanDefinitionRegistry,beanName,builder.getBeanDefinition());
    }

    public static void registryBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry, String beanName, BeanDefinition beanDefinition){

        if(StringUtils.hasText(beanName)){
            //带有beanName的注册
            beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinition);
        }else {
            //不带beanName的注册
            BeanDefinitionReaderUtils.registerWithGeneratedName((AbstractBeanDefinition) beanDefinition,beanDefinitionRegistry);
        }

    }

    @Component //方式2
    public static class Config {

        @Bean //方式1
        public User user() {
            User user = new User();
            user.setId(11L);
            return user;
        }
    }
}
