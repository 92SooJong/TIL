[원문](https://docs.gradle.org/current/userguide/java_library_plugin.html)

# The Java Library Plugin

Java Plugin은 JVM 기반의 프로젝트에서 필요한 기본적인 Task들을 미리 작성해서 제공함.

Java Library Plugin은 Java Plugin의 기능을 좀더 확장한 용도임.

Library는 하나의 자바 컴포넌트가 다른 컴포넌트에 의해 사용되는것을 의미한다. (Java Plugin과 Java Library Plugin의 가장큰 차이점이다.)

Plugin은 2개의 configuration을 제공하는데 api와 implementation이 그것이다.

api에 정의된 의존성은 라이브러리를 사용하는 측에게 노출되어 있다
- A라는 모듈에서 a라는 의존성을 사용했다고 치자. B라는 모듈이 A를 사용할때 a도 함께 의존성을 내려받는것을 의미한다.

implementation에 정의된 의존성은 라이브러리를 사용하는 측에게 노출되어 있지 않는다.
- A라는 모듈에서 a라는 의존성을 사용했다고 치자. B라는 모듈이 A를 사용할때 a의 의존성을 내려받지 않는다.

implementation을 사용하면 사용자 측의 compile path에 나의 의존성 정보가 노출되지 않는다.

implementation 장점
- 컴파일 속도 빠름(classpath 사이즈가 줄었기 떄문) 결국은 경량화되고 깔끔해졌다.