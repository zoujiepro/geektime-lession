package com.viepub.thinking.in.spring.ioc.overview.domain;

import com.viepub.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-3
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return super.toString() + "address : " + this.address;
    }
}
