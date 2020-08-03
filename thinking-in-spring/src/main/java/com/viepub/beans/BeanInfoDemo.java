package com.viepub.beans;

import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditor;
import java.util.stream.Stream;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-3
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            String name = propertyDescriptor.getName();
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            System.out.println("name = " + name + " type = " + propertyType.getSimpleName());
            propertyDescriptor.setPropertyEditorClass(PropertyEditor.class);
        });
    }
}
