템플릿 엔진 의존성(예. `org.springframework.boot:spring-boot-starter-thymeleaf`)을 등록하지 않고 View를 호출하면 404에러가 return된다.


## `Unsupported class file major version 65`에러가 발생한 경우

Gradle과 현재 JVM 버전이 맞지 않아서 발생한 에러이다. 65인 경우 Java 17버전을 사용하면 정상적으로 실행된다.