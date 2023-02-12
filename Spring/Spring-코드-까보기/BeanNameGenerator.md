# What is "BeanNameGenerator" interface in Spring?
The BeanNameGenerator is an interface in the Spring framework that is used to generate names for beans that are managed by the Spring container. The BeanNameGenerator interface provides a simple and flexible way to generate unique names for beans, which is useful when you have multiple beans of the same type in your application.

> Spring Container에 의해 관리되는 bean의 이름을 만들어내는 역할을 하는 인터페이스이다. 

The BeanNameGenerator interface has a single method, generateBeanName, which takes a BeanDefinition object as an argument and returns a string that represents the name of the bean. The BeanDefinition object contains information about the bean, such as its class, its properties, and its constructor arguments. The generateBeanName method uses this information to generate a unique name for the bean.

> BeanNameGenerator 인터페이스는 1개의 메소드만 가지고 있다. BeanDefinition 객체를 받아서 bean 이름을 String 타입으로 반환한다. BeanDefinition은 bean에 대한 클래스명, properties, 생성자 아규먼트 정보를 가지고 있다. 이런 정보를 사용해서 bean을 위한 unique한 이름을 만들어서 반환한다.

In Spring, the default implementation of the BeanNameGenerator interface is the AnnotationBeanNameGenerator, which generates bean names based on the annotations present on the bean class. For example, if a bean is annotated with @Service, the AnnotationBeanNameGenerator will generate a name that is based on the class name, such as myService.

> Spring에서 사용하는 default 구현체는 AnnotationBeanNameGenerator 이다. bean class에 존재하는 어노테이션을 기반으로 bean 이름을 생성한다. 예를들어 myService라는 클래스에 "@Service" 어노테이션이 있다고 가정해보자, 이떄 AnnotationBeanNameGenerator를 사용하면, 클래스 이름인 myService를 bean의 이름으로 사용한다.


You can also create your own implementation of the BeanNameGenerator interface to generate custom bean names. To use a custom BeanNameGenerator, you can specify it using the nameGenerator attribute of the @ComponentScan annotation in your configuration. For example:

> 아래와 같이하면 특정 패키지 하위에 있는 빈에대해서만 bean이름 생성에 대한 rule을 지정할 수 있다.


```java
@Configuration
@ComponentScan(basePackages = "com.example", nameGenerator = MyBeanNameGenerator.class)
public class AppConfig {
  // ...
}
```

In this example, the @ComponentScan annotation is used to scan the com.example package for components. The nameGenerator attribute is set to MyBeanNameGenerator.class, which is a custom implementation of the BeanNameGenerator interface. When the Spring container scans the com.example package for components, it will use the MyBeanNameGenerator class to generate names for the beans that it finds.