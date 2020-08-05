# 依赖来源： 
    @see com.viepub.thinking.in.spring.ioc.overview.dependency.injection.DependencyInjectionDemo#summary2
1. 自定义bean
2. 容器内建bean对象
3. 容器内建依赖

# BeanFactory和ApplicationContext
1. 


    @see com.viepub.thinking.in.spring.ioc.overview.dependency.injection.DependencyInjectionDemo#summary3
2. 

     
     @see com.viepub.thinking.in.spring.ioc.overview.dependency.injection.DependencyInjectionDemo#summary3
3.   

     
     * ApplicationContext是BeanFactory子接口
     * beanFactory是一个最基础的IOC容器，ApplicationContext在此基础上
     * 提供了更多的企业级别的功能性，ApplicationContext是beanFactory的超集
     *
     * aop特性
     * 消息资源国际化
     * 事件发布
     * 应用层级别容器，例如WebApplicationContext
     * 环境变量
     *
     * @link "https://docs.spring.io/spring/docs/5.2.8.RELEASE/spring-framework-reference/core.html#beans-introduction"
        applicationContext内部的beanFactory 与对象依赖注入的beanFactory是同一对象

# 依赖查找：

1. 实时查找：通过BeanFactory的方法进行查找，通过字接口ListableBeanFactory进行集合查找
2. 延迟查找：ObjectFactory

# 依赖注入：
1. xml中bean标签属性autowire="byType"
2. xmlns:util="http://www.springframework.org/schema/util"
3. 
   
   
        <bean id="userRepository" class="com.viepub.thinking.in.spring.ioc.overview.repository.UserRepository"
           autowire="byType">
           <!--<property name="users">-->
               <!--<util:list>-->
                   <!--<ref bean="user"></ref>-->
                   <!--<ref bean="superUser"></ref>-->
               <!--</util:list>-->
           <!--</property>-->
       </bean>
       
#Spring应用上下文
ApplicationContext除了IoC容器角色，还有提供：
1. 面向切面(aop)
2. 配置元信息(Configuration Metadata)
3. 资源管理(Resources)
4. 事件(Events)
5. 国际化(i18n)
6. 注解(Annotations)
7. Environment抽象(Environment Abstraction)
:配置(profile)和外部化配置，外部化配置主要解决占位符问题和一些相关配置以及实时读取一些阈值开关。

#