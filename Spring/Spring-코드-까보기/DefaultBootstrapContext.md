---
title: "Spring : DefaultBootstrapContext을 까보자"
date: 2023-01-03T23:55:00+09:00
tags: ["Spring","Korean"]
---

# DefaultBootstrapContext
- `ConfigurableBootstrapContext`를 구현한 디폴트 클래스다.
# ConfigurableBootstrapContext
- `BootstrapContext`와 `BootstrapRegistry`를 extends한다
- `BootstrapContext`는 `BootstrapRegistry`를 통해서 configuration 메소드를 제공한다
# BootstrapRegistry
- 단순한 형태의 오브젝트 레지스트리(저장소)이다. 
- startup이 진행되는 동안 사용가능하다.
- ApplicationContext가 준비되기 직전인 Environment 후처리까지 사용할 수 있다.
- 레지스트리는 Class를 Key로 사용한다. 이뜻은 하나의 인스턴스만 저장될 수 있음을 의미한다.
- BootstrapRegistry는 인스턴스를 등록하는데 사용된다.(인스턴스를 생성하는 cost는 비싸다.)
- 또한 BootstrapRegistry는 ApplicationContext가 사용되기 전에 필요에 따라 공유되기도 한다
- addCloseListener(ApplicationListener) 메소드는 listener를 추가하는데 사용된다.
- listener는 BootstrapContext가 종료되거나 ApplicationContext가 완전히 준비된 시점에 실행된다. 예를들면, 인스턴스는 application이 사용할 수 있도록 자신을 Spring bean으로 등록할 수 있다. (application은 ApplicationContext를 통해서 bean을 사용함!)
# BootstrapContext
- 단순한 형태의 bootstrap context 인터페이스다.
- `BootstrapRegistry`와 마찬가지로 ApplicationContext가 준비되기 직전인 Environment 후처리까지 사용이 가능하다
- 싱글톤으로 lazy 접근이 가능하도록 하는 기능을 제공한다.
- 또한 BootstrapContext는 ApplicationContext가 사용되기 전에 필요에 따라 공유되기도 한다
# 결론
- BootstrapRegistry와 BootstrapContext를 분석한 결과 DefaultBootstrapContext는 ApplicationContext가 준비되기 전에 사용되는 Context다.
- Spring에서 Context는 Bean을 관리하는 Pool또는 Container를 의미한다