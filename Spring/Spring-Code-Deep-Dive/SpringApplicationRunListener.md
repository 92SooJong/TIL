---
title: "Spring : SpringApplicationRunListener를 까보자"
date: 2023-01-04T22:55:00+09:00
tags: ["Spring","Korean"]
---

# SpringApplicationRunListener 인터페이스
- SpringApplication run 메소드의 Listener이다.
- SpringApplicationRunListener는 SpringFactoriesLoader에 의해 로드된다. 
- 그리고 SpringApplication 인스턴스와 아규먼트를 받아내기 위해서 반드시 public 생성자를 선언해야한다.
- 매 run 메소드마다 새로운 SpringApplicationRunListener가 생성될것이다.
# EventPublishingRunListener
- SpringApplicationRunListener 인터페이스를 구현한다
- SpringApplicationEvent를 Publish하는 역할을 함.
- 이벤트는 ApplicationEventMulticaster 필드가 관리된다.
- context가 refresh 되기전에 ApplicationEventMulticaster는 이벤트를 실행한다
# ApplicationEventMulticaster 인터페이스
- Spring framework 영역이다.(boot 아님!)
- 여러개의 ApplicationListener타입 Object를 관리하며 이벤트를 ApplicationListener에 부여하는 역할을 한다
- 이벤트 publish를 위해선 ApplicationEventMulticaster대신 해서 ApplicationEventPublisher 또는 ApplicationContext를 사용할 수도 있음
# ApplicationEvent 추상 클래스
- 모든 Application의 event는 ApplicationEvent를 확장해야한다
# ApplicationContextEvent 추상 클래스
- ApplicationContext가 사용할 이벤트를 의미한다.