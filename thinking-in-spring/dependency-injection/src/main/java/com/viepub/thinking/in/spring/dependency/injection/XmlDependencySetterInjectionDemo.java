package com.viepub.thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-26
 */
public class XmlDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        String xmlPath = "classpath:/dependency-setter-injection.context.xml";
        reader.loadBeanDefinitions(xmlPath);


        UserHolder bean = factory.getBean(UserHolder.class);
        System.out.println(bean);
    }
}
