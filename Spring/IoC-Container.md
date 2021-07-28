[https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html#beans-introduction](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html#beans-introduction)

The org.springframework.beans와 org.springframework.context는 IoC 컨테이너의 기본이 되는 패키지다.

BeanFactory 인터페이스는 어떤 형태의 오브젝트(클래스)를 관리하는 진보된 설정 메커니즘을 제공한다. 

ApplicationContext는 BeanFactory의 서브 인터페이스이다. 

ApplicationConext는 AOP의 특성을 이용해 더 쉽게 통합가능하도록 해준다.

message resource handling (for use in internationalization), event publication; and application-layer specific contexts such as the WebApplicationContext for use in web applications

WebApplicationContext같은 것들을 통해 국제화, 이벤트 발행, 응용 프로그램 레이어의 로직등을 사용할 수 있다.

요약하면, BeanFactory은 프레임워크의 설정 및 기본 기능을 제공해준다. 그리고, ApplicationContext는 전사수준의 기능을 추가한 것이다. 
ApplicationContext는 BeanFactory의 완성된 superset이다.

스프링에서 여러분이 Application backbone에서 만든 오브젝트는 Spring IoC 컨터이너에서 관리되고 있으며, 해당 오브젝트를 beans라고 부른다.

A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.
bean은 Spring IoC container에 의해 관리되는 인스턴스화 되고, 조립된다. 
