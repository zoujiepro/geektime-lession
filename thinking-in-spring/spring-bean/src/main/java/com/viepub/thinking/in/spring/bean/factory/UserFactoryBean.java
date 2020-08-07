package com.viepub.thinking.in.spring.bean.factory;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Descrption : {@link com.viepub.thinking.in.spring.ioc.overview.domain.User} 的 {@see }
 * @Author: zoujie
 * @Date: 2020-8-6
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
