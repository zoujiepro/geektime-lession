#依赖查找
##ListableBeanFactory集合查找

1.getBeanNamesForType(class<?>)
是在BeanDefinition中查找，bean未涉及实例化和初始化阶段。
`@see BeanDefinition#getObjectType()  Class#isAssignableFrom()` 

2. 而getBeansOfType(class<?>)会触发bean的初始化。该方法可能导致
类提前初始化，导致bean初始化并不完全，可能导致一些未知错误。

3. 因此我们需要判断是否有bean时，先通过名称判断，再通过类型判断。
ListableBeanFactory针对某一个类型去查找一个集合列表，集合列表查询bean名称和bean类型，推荐使用查询bean的名称

##单一类型和集合查询合并(层次性查找)
###层次性依赖查找接口-HierarchicalBeanFactory

HierarchicalBeanFactory<--ConfigurableBeanFactory<--ConfigurableListableBeanFactory

1. 双亲BeanFactory：getParentBeanFactory()
2. 层次性查找

    2.1 根据Bean名称查找
    
        2.1.1 基于containsLocalBean
        
    2.2 根据Bean类型查找实例列表
        
        2.2.1 单一类型：BeanFactoryUtils#beanOfType
        
        2.2.2 集合类型：BeanFactoryUtils#beansOfTypeIncludingAncestors
        
    2.3 根据Java注解查找名称列表
    
        2.3.1 BeanFactoryUtils#beanNamesForTypeIncludingAncestors
        
##安全依赖查找
1. 依赖查找安全性对比

    1.1 单一类型查找：BeanFactory#getBean(否)、ObjectFactory#getObjecy(否)、ObjectProvider#getIfAvaliable(是)
    
    1.2 集合类型查找：ListableBeanFactory#getBeansOfType(是)、ObjectProvider#stream(是)
    
#内建可查找的依赖

##AbstractApplicationContext内建可查找的依赖

1. environment   Environment对象  外部化配置以及profiles

2. systemProperties  java.util.Properties对象   java系统属性

3. systemEnvironment    java.util.Map对象  操作系统环境变量

4. messageSource    MessageSource对象   国际化文案

5. lifecycleProcessor   LifecycleProcessor对象    Lifecycle Bean处理器

6. applicationEventMulticaster  ApplicationEventMulticaster对象   Spring事件广播器

##注解驱动Spring应用上下文内建可查找的依赖(部分)

`@see AnnotationConfigUtils`

1. `bean名称：org.springframework.context.annotation.internalConfigurationAnnotationProcessor  实例：ConfigurationClassPostProcessor 使用场景：处理Spring配置类`

2. `bean名称：org.springframework.context.annotation.internalAutowiredAnnotationProcessor 实例：AutowiredAnnotationBeanPostProcessor 使用场景：处理@Autowired 以及 @value注解`

3. `bean名称：org.springframework.context.annotation.internalCommonAnnotationProcessor 实例：CommonAnnotationBeanPostProcessor 使用场景：(条件激活)处理JSR-250注解，如PostConstruct等`

4. `bean名称：org.springframework.context.annotation.internalEventListenerProcessor   实例：EventListenerMethodProcessor  使用场景：处理标注@EventListener的Spring事件监听方法`

5. `bean名称：org.springframework.context.event.internalEventListenerFactory   实例：DefaultEventListenerFactory 使用场景：@EventListener事件监听方法适配为ApplicationListener`

6. `bean名称：org.springframework.context.annotation.internalPersistenceAnnotationProcessor 实例：PersistenceAnnotationBeanPostProcessor  使用场景：(条件激活)处理JPA注解场景`

##依赖查找中的经典异常

1. NoSuchBeanDefinitionException 当查找bean不存在于IOC容器时，场景：BeanFactory#getBean ObjectFactory#getObject

2. NoUniqueBeanDefinitionException  类型依赖查找时，IOC容器存在多个Bean实例  BeanFactory#getBean(Class)

3. BeanInstantiationException   当Bean所对应的类型非具体类时    场景：BeanFactory#getBean

4. BeanCreationException    当Bean初始化过程中    场景： Bean初始化方法执行异常

5. BeanDefinitionStoreException    当BeanDefinition配置元信息非法时  场景：xml配置资源无法打开时



##依赖注入的模式

1. 手动模式-配置或者编程的方式，提前安排注入规则

    1.1 xml资源配置元信息
    
    1.2 java注解配置元信息
    
    1.3 API配置元信息
    
2. 自动模式-实现方提供依赖自动关联的方式，按照内建的注入规则

    2.1 Autowiring(自动绑定)
    
##依赖注入的类型

1. Setter方法   配置元数据举例：<property name="xxx" ref="bean"/>

2. 构造器  <constructor-arg name="user" ref=""bean"/>

3. 字段   @Autowire User user;

4. 方法   @Autowire public void user(User user){...}

5. 接口回调     class MyBean implements BeanFactoryAware{...}