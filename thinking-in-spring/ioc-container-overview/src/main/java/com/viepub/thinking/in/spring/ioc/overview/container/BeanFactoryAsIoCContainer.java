package com.viepub.thinking.in.spring.ioc.overview.container;

import com.viepub.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-4
 */
public class BeanFactoryAsIoCContainer {

    private static String beanDefinitionPath = "classpath:dependency-injection.context.xml";

    /**
     * new  XmlBeanDefinitionReader(BeanDefinitionRegistry registry)
     * 通过xml获取BeanDefinition
     * DefaultListableBeanFactory实现了接口：BeanDefinitionRegistry
     * @param args
     */
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        int i = beanDefinitionReader.loadBeanDefinitions(beanDefinitionPath);

        UserRepository bean = beanFactory.getBean(UserRepository.class);
        System.out.println(bean);
    }
}
