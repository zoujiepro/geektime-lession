package com.viepub.thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-26
 */
public class AutowiringByNameDependencySetterInjectionDemo {

    private static String path = "classpath:/autowiring-dependency-setter-injection.context.xml";

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(path);

        UserHolder bean = factory.getBean(UserHolder.class);
        System.out.println(bean);
    }
}
