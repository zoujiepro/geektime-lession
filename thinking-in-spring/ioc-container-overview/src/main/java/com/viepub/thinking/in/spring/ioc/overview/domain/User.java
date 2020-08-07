package com.viepub.thinking.in.spring.ioc.overview.domain;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-3
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() +
                "{ id : " + this.id +
                ", name : " + this.name + "}";
    }

    public static User createUser(){
        return new User();
    }
}
