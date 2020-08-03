package com.viepub.thinking.in.spring.ioc.overview.dependency.lookup;

import com.viepub.thinking.in.spring.ioc.overview.annotation.Super;
import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-3
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("dependency-lookup.context.xml");

        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);

        lookupByType(beanFactory);

        lookupCollectionByType(beanFactory);

        lookupCollectionWithAnnotation(beanFactory);
    }

    private static void lookupCollectionWithAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof  ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);

            System.out.println(beansWithAnnotation);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory =  (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beansOfType);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User bean = beanFactory.getBean(User.class);
        System.out.println(bean);
    }

    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = beanFactory.getBean("user", User.class);
        System.out.println("实时查找" +
                ""+user);
    }

    private static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User>  objectFactory = ( ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User object = objectFactory.getObject();

        System.out.println("延时查找" + object);
    }
}
