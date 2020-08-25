package com.viepub.thinking.in.spring.dependency.lookup;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Descrption :
 * 类型安全的依赖查找
 *
 * @Author: zoujie
 * @Date: 2020-8-17
 */
public class TypeSaftyDependencyLookupDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.refresh();

        //getBean安全性
//        displayGetBean(applicationContext);

        //ObjectFactory
//        displayObjectFactory(applicationContext);

//        displayListableBeanFactory(applicationContext);

        displayObjectProviderStream(applicationContext);

        applicationContext.close();
    }

    private static void displayObjectProviderStream(AnnotationConfigApplicationContext applicationContext) {
        printException("displayObjectFactoryStream",()->applicationContext.getBeanProvider(User.class).stream());
    }

    private static void displayListableBeanFactory(ListableBeanFactory applicationContext) {
        printException("listableFactory",()->applicationContext.getBeansOfType(User.class));
    }

    private static void displayObjectFactory(ApplicationContext applicationContext) {
        printException("displayObjectFactory",()->{
            ObjectFactory<User> objectFactory = applicationContext.getBeanProvider(User.class);
            User object = objectFactory.getObject();
        });
    }

    public static void displayGetBean(ApplicationContext applicationContext){
        printException("displayGetBean",()->applicationContext.getBean(User.class));
    }

    public static void  printException(String source,Runnable runnable){
        System.out.println("source from " + source);
        try {
            runnable.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
