package com.viepub.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-17
 */
public class HierarchicalDependencyLookupDemo {

    private static String path = "parent-bean-factory.xml";

    @Bean
    String helloWord(){
        return "helloWord";
    }


    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(path);


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDependencyLookupDemo.class);
        applicationContext.refresh();

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.setParentBeanFactory(factory);


        ObjectProvider<String> beanProvider = beanFactory.getBeanProvider(String.class);

        System.out.println(beanProvider);

        System.out.println(beanProvider.getIfAvailable(()->"LLL"));
    }
}
