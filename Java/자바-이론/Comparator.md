---
title: "Comparable vs Comparator in Java"
date: 2022-12-30T19:23:00+09:00
tags: ["Java", "Korean"]
---

# Comparable
- single element의 정렬을 제공한다. 예를 들면 ID, 이름, 가격 등
- 원본 클래스가 변경된다.
- element 정렬을 위해서 compareTo() 메소드를 제공한다
- Comparable은 java.lang 패키지에 존재한다
- Comparable을 상속하는 list형태의 Collection은 `Collections.sort(List)` 메소드를 사용할 수 있다.
- Comparable은 상속을 받아야 하기 때문에 OOP 관점에서 보면 인터페이스와 커플링이 발생하게 된다. 커플링 문제를 해결하기 위해 Comparator를 사용한다

# Comparator
- multiple element의 정렬을 지원한다. 예를들면 (ID,이름)을 묶어서 정렬할 수 있다.
- element 정렬을 위해서 compare() 메소드를 제공한다
- Comparator는 java.util 패키지에 존재한다
- list형태의 Collection을 `Collection.sort(List,Comparator)` 메소드를 사용해서 정렬할 수 있다.


# 공식문서에서 발췌한 글
## Comparator
- [공식문서 링크](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html)
- Comparasion function은 collection 오브젝트에 전체 정렬을 위한 함수이다. 
- Comparator는 정렬 메소드(Collections.sort, Arrays.sort)에 주입됨으로써 정렬에 대한 방법을 개발자가 정의할 수 있다.
- Comparator는 sorted sets나 sorted maps와 같은 특정 자료구조에서도 사용될 수 있다.
- `c.compare(e1, e2)==0`라는 뜻은 `e1.equals(e2)`와 똑같은 연산을 하고 있다는 뜻이다.
- equals를 사용하지 않는 순서매기기 방법을 사용할때는 주의해야한다.
- 비어 있는 TreeSet에 2개의 elements(a,b)를 넣는다고 가정하자. `a.equals(b) && c.compare(a, b) != 0` 연산을 했을때 결과는 어떻게 될까? 


# 참고한 링크
- [Comparable vs Comparator in Java
](https://medium.com/@kasunprageethdissanayake/comparable-vs-comparator-in-java-623b7435e06)

