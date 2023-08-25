
# Spring Web MVC
- Spring Web MVC는 Servlet API 상에서 작동하는 웹 프레임워크로서 하며, 초창기 Spring 프레임워크 시절부터 제공되어왔다. 
- 공식적인 이름은 Spring Web MVC이나 일반적으로 줄여서 Spring MVC라고 칭한다.
- Tomcat 같은 서블릿 컨테이너를 손쉽게 다룰수 있게 해준다. 
- 따라서 개발자가 직접 HTTP 데이터를 해석하지 않고 Spring MVC에서 제공하는 어노테이션 또는 함수를 통해서 손쉽게 사용자와 데이터 송수신이 가능하다.

# DispatcherServlet
- Spring MVC에서는 모든 요청은 하나의 서블릿을 통과한다. 이 서블렛이 DispatcherServlet이다.( 소위 Front Controller라고 불리기도 한다. )
- Spring MVC는 다른 웹 프레임워크와 마찬가지로 프론트 단에서 url 패턴을 중앙 Servlet이 분석하도록 설계되었다.  (이 중앙 Servlet을 Spring MVC에선 DispatcherServlet이라고 부른다.)
- Front Controller는 웹 개발에 있어서 전형적인 디자인 패턴중 하나다. 
- DispatcherServlet의 기능은 request를 특정 Spring MVC의 Controller에 보내는 것이다. (클라이언트의 요청을 모두 받아서 적절한 컨트롤러를 할당해주는 역할을 한다.)
- DispatcherServlet을 사용하기 위해선 Java Configuration이나 web.xml을 통해서 정의 및 매핑이 되어야 한다.
- DispatcherServlet은 Spring Configuration을 통해서 request 매핑이나 view 찾기, 예외 처리같은 작업들을 처리할 컴포넌트를 찾아준다.

## 부가 설명
- DispatcherServlet은 아래의 몇가지 mapper에 따라 Controller를 찾는방식이 다르다.
  - BeanNameUrlHandlerMapping;
  - ControllerBeanNameHandlerMapping;
  - ControllerClassNameHandlerMapping;
  - DefaultAnnotationHandlerMapping;
  - SimpleUrlHandlerMapping.
- 별다른 설정을 하지 않았다면 기본적은 BeanNameUrlHandlerMapping과 DefaultAnnotationHandlerMapping을 통해 Controller를 찾게된다. 
- 대상 Controller가 발견되었다면 DispatcherServlet은 request를 보낸다. 그후 Controller는 request에 따른 몇가지 작업들을 처리할것이다. 
- 그리고 DispatcherServlet에 Model과 View의 이름을 넘겨준다. 
- View의 이름은 유일한 논리명이어야 한다. 
- View의 논리명을 이용해 실제 뷰를 찾는데 사용한다. 
- DispatcherServlet은 실제 뷰를 찾기위해 ViewReslover를 사용한다. 
- ViewReslover 구현체는 아래와 같다. 
  - BeanNameViewResolver
  - ContentNegotiatingViewResolver
  - FreeMarkerViewResolver
  - InternalResourceViewResolver
  - JasperReportsViewResolver
  - ResourceBundleViewResolver
  - TilesViewResolver
  - UrlBasedViewResolver
  - VelocityLayoutViewResolver
  - VelocityViewResolver
  - XmlViewResolver
  - XsltViewResolver


----
# 참고
[https://docs.spring.io/spring-framework/docs/current/reference/html/web.html](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)
