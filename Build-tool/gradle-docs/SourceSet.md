# 정의
Java source 파일과 Resource 파일의 논리적 그룹을 의미한다. 아래와 같이 작성하면서 Compile시에 원하지 않는 패키지를 제외할 수 있다.
```
plugins {
    id 'java'
}

sourceSets {
  main {
    java {
      exclude 'some/unwanted/package/**'
    }
  }
}
```
위 예시에 나오는 main은 미리 만들어둔 source set의 이름이다.

main내에 있는 java는 Property라고 부른다. java는 자바 컴파일러에 의해 컴파일될 소스를 정의한다.(컴파일 제외도 가능함)

# 원문 링크
[https://docs.gradle.org/current/dsl/org.gradle.api.tasks.SourceSet.html](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.SourceSet.html)