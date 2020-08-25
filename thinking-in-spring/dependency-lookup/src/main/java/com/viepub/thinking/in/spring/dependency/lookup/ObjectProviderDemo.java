package com.viepub.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-14
 */
public class ObjectProviderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

//        泛型
//        applicationContext.getBeanProvider(ResolvableType.NONE)

        lookupObjectProvider(applicationContext);

        applicationContext.close();

    }

    @Bean String helloWord(){
        return "helloWord";
    }


    public static void lookupObjectProvider(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
    }

}
