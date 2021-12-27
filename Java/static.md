

# 클래스
클래스내부에 있는 클래스에는 두가지 유형이 있는데 하나는 Static 키워드가 붙어있는 클래스이고, 다른 하나는 Static 키워드가 없는 클래스이다.
- 두가지 유형을 일반적으로 아래처럼 명명해서 사용중이다.
  - None Static Class는 **inner class**
  - Static Class는 **static nested class**

## static nested class
- static nested class는 자신을 감싸고 있는 클래스를 통해서 접근이 가능하다.
- Top-Class의 인스턴스를 사용하지 않고도 nested class를 사용할 수 있다.
- 외부의 필드에 static 키워드가 없다면 접근이 불가능하다.
- 외부 클래스의 인스턴스를 통해서 접근해야한다.
```java
OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
```
## inner class
```java
OuterClass outerObject = new OuterClass()
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```
