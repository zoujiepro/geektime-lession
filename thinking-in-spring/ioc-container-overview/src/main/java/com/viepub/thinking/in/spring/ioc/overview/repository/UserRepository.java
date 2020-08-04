package com.viepub.thinking.in.spring.ioc.overview.repository;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-4
 */

public class UserRepository {

    private Collection<User> users;  //自定义bean

    private BeanFactory beanFactory; //内建非bean对象（依赖）

    //private ObjectFactory<ApplicationContext> objectFactory; 根据泛型注入
    private ObjectFactory<User> objectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<User> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
