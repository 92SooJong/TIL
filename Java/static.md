

# 클래스
클래스내부에 있는 클래스에는 두가지 유형이 있는데 하나는 Static 키워드가 붙어있는 클래스이고, 다른 하나는 Static 키워드가 없는 클래스이다.
- 두가지 유형을 아래처럼 명명하기도 한다.
  - None Static Class는 inner class라고 불린다.
  - Static Class는 static nested class라고 불린다.
- static nested class는 자신을 감싸고 있는 클래스를 통해서 접근이 가능하다.
  - Top-Class의 인스턴스를 사용하지 않고도 nested class를 사용할 수 있다.
  - static nested class는 마치 Top-Class인것처럼 동작한다.
  - 외부의 필드에 접근이 불가능하다. static 필드는 접근이 가능하다.
  - 아니면 외부 클래스의 인스턴스를 통해서 접근해야한다. 
  - 정적 내부 클래스는 외부 클래스의 비 정적 멤버에 액세스 할 수 없습니다.
  - 정적 내부 클래스는 멤버 변수에 액세스하기 위해 외부 클래스 참조가 필요하지 않습니다.
  - 정적 클래스는 인스턴스화 될 수 없습니다. 따라서 메서드는 클래스 이름으로 직접 액세스 할 수 있습니다.
```java
OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
```
- inner class는 아래와 같은 방식으로 사용이 가능하다.
```java
OuterClass outerObject = new OuterClass()
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```
