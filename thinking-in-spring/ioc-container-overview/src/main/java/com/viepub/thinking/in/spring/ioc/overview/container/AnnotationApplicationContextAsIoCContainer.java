package com.viepub.thinking.in.spring.ioc.overview.container;

import com.viepub.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-4
 */
public class AnnotationApplicationContextAsIoCContainer {

    private static String beanDefinitionPath = "classpath:dependency-injection.context.xml";

    public static void main(String[] args) {
    }
}
