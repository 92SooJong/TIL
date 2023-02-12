# What is the "SpringBootServletInitializer" abstract class in Spring boot?

SpringBootServletInitializer is an abstract class provided by Spring Boot that makes it easy to configure a Servlet 3.0+ container for a Spring Boot application. This class provides a convenient way to bootstrap a Spring Boot application as a traditional WAR file, which can be deployed in any Servlet 3.0+ container, such as Apache Tomcat, Jetty, and others.

> Spring Boot 어플리케이션을 위해 Servlet 3.0 이상의 컨테이너를 손쉽게 configure하도록 한다. 전통적인 WAR file처럼 Spring Boot application을 부트스탭 할 수 있도록 해준다. 

The SpringBootServletInitializer class extends the WebApplicationInitializer interface, which is a web application bootstrapping interface defined by the Servlet API. By extending this class, you can customize the bootstrapping process of a Spring Boot application in a Servlet container.

> WebApplicationInitializer 인터페이스를 extends한다. WebApplicationInitializer 인터페이스는 Servlet API에 정의 되어 있으며, web application bootstraping하는 역할을 한다. SpringBootServletInitializer를 extneds 함으로써 Spring Boot Application의 bootstrapping 프로세스를 커스터마이징 할 수 있다.

To use SpringBootServletInitializer, you need to create a class that extends this class and overrides the configure method. This method is used to configure the Application class as the root application context and to register any additional Servlet context and Servlet-related components that are needed for the application to run.

> SpringBootServletInitializer를 사용하기 위해선 extends 받고 configure 메소드를 오버라이드 받으면 된다.

# 예제
Spring Config 파일명을 app-config로 변경한다.

profile을 prod로 설정한다

```java
@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(MyApplication.class)
                     .properties("spring.config.name:app-config")
                     .profiles("prod");
  }

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(MyApplication.class);
    application.setDefaultProperties(Collections.singletonMap("spring.config.name", "default-config"));
    application.run(args);
  }
}
```