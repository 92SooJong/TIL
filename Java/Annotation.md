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





Suppose, you want to set some application-wide constants/parameters. In this scenario, XML would be a better choice because this is not related to any specific piece of code. If you want to expose some method as a service, an annotation would be a better choice as it needs to be tightly coupled with that method and developer of the method must be aware of this.

Another important factor is that an annotation defines a standard way of defining metadata in code. Prior to annotations, people also used their own ways to define metadata. Some examples are using marker interfaces, comments, transient keywords, etc. Each developer needs his own way to decide metadata, but annotation standardized things.

These days most frameworks use a combination of both XML and Annotations to leverage positive aspects of both.



