

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
- 클래스의 역할은 인스턴스를 만드는 '설계도'의 역할을 할 뿐이고, static 클래스라고해서 인스턴스가 만들어져 있는게 아니다.
- 단지 아래처럼 인스턴스를 만드는 방식에 약간의 차이가 있을뿐이다. ( static class는 자신을 감싸고 있는 클래스의 인스턴스가 필요없음!)
```java
OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
```
## inner class
- inner class는 반드시 외부 클래스의 인스턴스를 통해서만 인스턴스 생성이 가능하다.
- 이런 경우 inner class의 인스턴스는 외부 인스턴스에 대해 참조를 가지고 있다. ( 인스턴스간의 연결이 발생함 )
- 이를 `외부참조` 또는 `숨은 외부참조`라고 부른다.
- 외부참조 덕분에 innser class 인스턴스에서 외부 클래스의 인스턴스 필드에 접근이 가능하다.
```java
OuterClass outerObject = new OuterClass()
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```
### 단점
- 참조값을 담아야 하기 때문에, 인스턴스 생성시 시간적, 공간적으로 성능이 낮아진다.
- 외부 인스턴스에 대한 참조가 존재하기 때문에, 가비지 컬렉션이 인스턴스 수거를 하지 못하여 메모리 누수가 생길 수 있다.

