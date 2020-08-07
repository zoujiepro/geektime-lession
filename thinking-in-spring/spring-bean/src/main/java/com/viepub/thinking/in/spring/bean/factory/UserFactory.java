package com.viepub.thinking.in.spring.bean.factory;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-6
 */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}
