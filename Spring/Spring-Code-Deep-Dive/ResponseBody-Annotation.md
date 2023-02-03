---
title: "Spring : ResponseBody Annotation"
date: 2023-01-29T14:04:00+09:00
tags: ["Spring","Korean"]
---

# 설명
The @ResponseBody annotation in Spring is used to indicate that the return value of a method should be bound to the web response body. This annotation tells Spring to use a message converter to convert the return value to a format that can be sent back to the client, typically in the body of the HTTP response.

When a controller method is annotated with @ResponseBody, Spring will automatically convert the returned object to an HTTP response body, by using an instance of HttpMessageConverter. The actual conversion is done by an instance of the HttpMessageConverter interface.

This annotation is often used in RESTful web services, where the client expects a response in a specific format, such as JSON or XML. By annotating a controller method with @ResponseBody, you can ensure that the return value will be automatically converted to the desired format and sent back to the client.

In addition, the @ResponseBody annotation can also be used at the class level to indicate that all methods in the controller should have this behavior, unless overridden by another annotation.

# 요약
- 스프링에게 return Object를 web response(주로 HTTP Response) body로 컨버팅하도록 지시하는 역할이다.
- 컨버팅시에는 HttpMessageConverter 인스턴스를 사용하게 된다.(HttpMessageConverter 인스턴스의 구현체이다)