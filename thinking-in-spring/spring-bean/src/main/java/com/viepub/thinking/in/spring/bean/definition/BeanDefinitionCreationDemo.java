package com.viepub.thinking.in.spring.bean.definition;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-5
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {



        //1.通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();

        //通过属性设置
        builder
                .addPropertyValue("age", 22)
                .addPropertyValue("name", "viepub");

        //获取BeanDefinition实例  并非bean最终形态，可以自定义修改
        BeanDefinition beanDefinition = builder.getBeanDefinition();


        //2.通过AbstractBeanDefinition以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

        //设置bean类型
        genericBeanDefinition.setBeanClass(User.class);

        //通过mutablePropertyValues批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id",22);
//        propertyValues.addPropertyValue("name","viepub");
        propertyValues
                .add("id", 22)
                .add("name", "viepub");

        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
