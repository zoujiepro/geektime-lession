#定义 Spring Bean
BeanDefinition是Spring Framework中定义Bean的配置元信息接口，包含：
1. Bean的类名
2. Bean的行为配置元素，如作用域、自动绑定的模式、生命周期回调等
3. 其他Bean引用，又可称作合作者(Collaborators)或者依赖(Dependencies)
4. 配置设置，比如Bean属性(properties)

#BeanDefinition 元信息
1. **Class**：Bean全类名，必须是具体类，不能用抽象类或接口
2. **Name**：(标识)Bean的名称或者id
3. **Scope**：Bean的作用域(如：singleton、prototype)
4. **Constructor arguments**：Bean的构造参数(用于依赖注入)
5. **Properties**：Bean属性设置(用于依赖注入)
6. **Autowiring mode**：Bean自动绑定模式(如：通过名称ByName)
7. **Lazy initialization mode**：Bean延迟初始化模式(延迟和非延迟)
8. **Initialization method**：Bean初始化回调方法名称
9. **Destruction method**：Bean销毁回调方法名称

#BeanDefinition的构建
1. BeanDefinitionBuilder
2. AbstractBeanDefinition的派生类，如：GenericBeanDefinition

# Alias别名
# 注册Spring Bean
1. BeanDefinition注册

    1.1 xml配置元信息，如：<bean id=""/>
    
    1.2 Java注解配置元信息 如：@Bean  @Component  @Import
    
    1.3 Java API配置元信息
     `@see BeanDefinitionRegistry`
    
     &nbsp;&nbsp;&nbsp;&nbsp;1.3.1 命名方式：BeanDefinitionRegistry#registryBeanDefinition(String,BeanDefinition) 
        
     &nbsp;&nbsp;&nbsp;&nbsp;1.3.2 非命名方式：BeanDefinitionReaderUtils#registryWithGerneratedName(AbstractBeanDefinition,BeanDefinitionRegistry)
        
     &nbsp;&nbsp;&nbsp;&nbsp;1.3.3 配置类方式：AnnotatedBeanDefinitionReader#registry(Class)

2. Bean实例化(instantiation)

   2.1常规方式
   
   &nbsp;&nbsp;&nbsp;&nbsp;2.1.1 通过构造器(配置元信息：xml、java注解和javaAPI)
   
   &nbsp;&nbsp;&nbsp;&nbsp;2.1.2 通过静态工厂方法(配置元信息：xml、和javaAPI)
   
   &nbsp;&nbsp;&nbsp;&nbsp;2.1.3 通过Bean工厂方法(配置元信息：xml、和javaAPI)
   
   &nbsp;&nbsp;&nbsp;&nbsp;2.1.4 通过FactoryBean(配置元信息：xml、java注解和javaAPI)
   
   2.2特殊方式
   
   &nbsp;&nbsp;&nbsp;&nbsp;2.2.1 通过ServiceLoaderFactoryBean(配置元信息：xml、java注解和javaAPI)
   
   &nbsp;&nbsp;&nbsp;&nbsp;2.2.2 通过AutowireCapableBeanFactory#createBean(java.lang.class,int,boolean)
   
   &nbsp;&nbsp;&nbsp;&nbsp;2.2.3 通过BeanDefinitionRegistry#registryBeanDefinition(String,BeanDefinition)
   