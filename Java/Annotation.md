_자바 어노테이션에대해 설명한 내용을 번역합니다. 출처 : [https://dzone.com/articles/how-annotations-work-java](https://dzone.com/articles/how-annotations-work-java)_

어노테이션은 자바에서 중요한 부분입니다. 자바 어노테이션은 J2SE 5.0에서 처음 등장했습니다. 우리가 흔히 마주하는 어노테이션으론 @Override나 @Deprecated같은 것들이 있습니다.

# 어노테이션이란 무엇인가?
어노테이션은 메타데이터다. 메타데이터는 데이터에 대한 데이터다.( 특정 데이터 집합을 설명하는 데이터라고 이해하면 쉽다. ) 자바의 어노테이션은 코드를 위한 메타데이터다. 아래의 코드를 보자.  
```java
@Override
public String toString() {
    return "This is String Representation of current object.";
}
```
나는 toString() 메소드를 오버라이드 받았다. 그리고 @Override 어노테이션이 해당 코드의 윗부분에 위치하고 있다. 내가 @Override를 작성하지 않더라도 코드는 에러를 발생시키지 않고 잘 실행된다. 
그렇다면 어노테이션을 사용해서 얻는 이점이 무엇일까? @Override는 컴파일러에게 이 메소드가 오버라이드 되었다는걸 알려준다.( 메소드에 대한 메타데이터 역할 ) 이떄 만약 부모 클래스에 toString()이 존재하지 않는다면 컴파일러 에러가 발생하게 된다. ( 오버라이드 되었다고 표시해뒀는데 실제론 오버라이드를 수행하지 않기 떄문에 에러 발생! )

메소드 toString()을 toStrring()으로 잘못 타이핑한 경우를 보자. 만약 @Override를 사용하지 않는다면 오타를 입력했더라도 코드상 문제는 없기때문에 정상적으로 실행된다. 다만 실행결과가 예상한것과 다를것이다. 하지만 @Override를 메소드에 적용했을때는 컴파일러가 부모클래스에서 toStrring()를 찾을것이고 해당 메소드의 이름을 가진 메소드가 없기 때문에 컴파일 에러를 띄운다.
어노테이션은 클래스,메소드,필드,파라미터,변수,생성자 또는 패키지를 꾸밀수 있게 해주는 자바의 특별한 구성요소다.


# 어노테이션의 탄생배경은?
어노테이션이 나타나기 이전에는 XML이 메타데이터를 나타내기 위해 주로 사용되었다. 몇몇 개발자들이 XML의 유지보수에 대한 의문점을 가지게 되었다. 그들은 코드와 너무 느슨하게 결합되어 관리되고 있던 XML보다 코드와 밀접하게 결합되어 관리할수 있는 방법을 원했다. XML 설정(Configuration)은 코드와 설정을 분리해서 관리하기 위해 등장한것이다. 즉, 어노테이션과는 완전히 반대되는 목적을 가지고 태어난 친구다. 그렇다보니 구글에 가면 여전히 XML이냐, annotation이냐를 가지고 많이들 논쟁을 벌이고 있다. 

당신이 어플리케이션 전체에 적용하고 싶은 변수나 파라미터를 선언하고 싶은 경우에는 별도의 소스코드를 작성할 필요가 없는 XML이 어노테이션보단 좋은 선택이 된다.(XML문서에만 작성해두면 애플리케이션 어디서든지 사용이 가능하다.) 그런데 만약 몇몇 메소드만 서비스 로직을 처리하는 메소드로 표시하고 싶은 경우( 예. SpringMVC의 @Service 어노테이션) 어노테이션이 XML보다 더 좋은 선택이 된다. 소스의 메소드에 직접 어노테이션을 표기함으로써 개발자가 해당 메소드의 목적을 파악할 수 있게된다.

어노테이션은 코드상에서 메타데이터를 나타낼수 있다. 어노테이션 등장 이전에는 개발자들이 각자 자신만의 방식으로 메타데이터를 표기했다. ( 마커용 인터페이스를 만든다던지, 주석을 달던지, 팀원간 약속된 키워드를 하는식으로 말이다. ) 하지만 어노테이션은 표준화되어있기 때문에 정형화된 메타데이터 표시가 가능하다.
최근에는 대부분의 프레임워크들이 XML과 어노테이션을 함께 사용하고 있다. ( 프로젝트 전반에 대한 설정은 XML을 사용하고, Bean등록과 같이 선택적인 작업을 할때는 어노테이션을 사용한다. )

# 어노테이션은 어떻게 동작하고, 커스텀 어노테이션은 어떻게 만들까?

어노테이션을 생성하는 방법은 인터페이스와 유사하다. 아래는 자바의 기본 어노테이션인 @Override와 직접 작성한 @Tode 어노테이션이다. 먼저 @Override 어노테이션부터 살펴보자.

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
```

뭔가 수상한듯한 생김새를 하고 있다. @Override는 어떤 동작도 수행하지 않는다. 그냥 단지 @Override를 가진 메소드가 부모클래스에 정의되어 있는지 체크만하는 역할을 한다. ( 어노테이션은 단지 메타데이터를 의미할뿐 어떠한 비즈니스로직도 가지고 있지 않다는걸 기억해야한다. ) 
어노테이션은 단지 어트리뷰트(클래스/메소드/패키지/필드)에 대한 정보를 제공할 뿐이다. 코드들은 이런 정보를 읽어서 적절한 조치를 취한다. 

@Override는 JVM이 사용하며 바이트코드 레벨에서 @Override에 대한 동작을 수행한다. 따라서 @Override는 개발자가 제어할수도 없고, 커스터마이징할 수도 없다. 따라서 필요한 어노테이션이 있다면 우리가 직접 작성해야한다. 

Let’s understand the key terms used for writing annotations one by one. In the above examples, you will see annotations are used on annotations.

J2SE 5.0 provides four annotations in the java.lang.annotation package that are used only when writing annotations:

+ @Documented  – Javadocs에 해당 어노테이션을 추가할지 말지 결정한다. 
+ @Retention  – 언제 어노테이션이 사용되는지를 나타낸다.(=언제까지 어노테이션을 유지할까 = 어노테이션의 라이프사이클 )
+ @Target?  – 어노테이션이 어디에 적용될지를 나타낸다. ( 작성하지 않으면 7개의 모든 곳에 다 위치할 수 있다. )
    + ElementType.TYPE (class, interface, enum)
    + ElementType.FIELD (instance variable)
    + ElementType.METHOD
    + ElementType.PARAMETER
    + ElementType.CONSTRUCTOR
    + ElementType.LOCAL_VARIABLE
    + ElementType.ANNOTATION_TYPE (on another annotation)
    + ElementType.PACKAGE (remember package-info.java)

+ @Inherited  – 현재의 어노테이션을 적용할 서브클래스는 무엇인가?



이제 직접 만든 @Todo 어노테이션을 살펴보자. 내부에 어떤 값들이 정의되어 있다. 
어노테이션은 Primitive 타입과 String 그리고 enum을 지원한다. 모든 어트리뷰트는 메소드 형태로 정의되며 default값이 필요하다. 

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    public enum Priority {LOW, MEDIUM, HIGH}
    public enum Status {STARTED, NOT_STARTED}
    String author() default "Yash";
    Priority priority() default Priority.LOW;
    Status status() default Status.NOT_STARTED;
}

```

@Todo 어노테이션은 아래와 같이 사용하면 된다. 
```java
@Todo(priority = Todo.Priority.MEDIUM, author = "Yashwant", status = Todo.Status.STARTED)
public void incompleteMethod1() {
//Some business logic is written
//But it’s not complete yet
}
```

만약 아래와 같이 어트리뷰트가 하나밖에 없는 @Author 어노테이션을 만들었다면 value="Yashwant"로 작성하지 않고 "Yashwant"라고만 작성하면 된다. 
```java
@interface Author{
    String value();
}
```
```java
@Author("Yashwant")
public void someMethod() {
}
```




So far so good. We have defined our custom annotation and applied it to some business logic methods. Now, it’s time to write a consumer. For that, we will need to use Reflection. If you are familiar with Reflection code, you know reflection provides Class, Method and Field objects. All of these have a getAnnotation()  method, which returns the annotation object. We need to cast this object as our custom annotation (after checking with instanceOf()) and then, we can call methods defined in our custom annotation. Let’s look at the sample code, which uses the above annotation:

```
Class businessLogicClass = BusinessLogic.class;

for(Method method : businessLogicClass.getMethods()) {
    Todo todoAnnotation = (Todo)method.getAnnotation(Todo.class);
    if(todoAnnotation != null) {
        System.out.println(" Method Name : " + method.getName());
        System.out.println(" Author : " + todoAnnotation.author());
        System.out.println(" Priority : " + todoAnnotation.priority());
        System.out.println(" Status : " + todoAnnotation.status());
    }
}

```



