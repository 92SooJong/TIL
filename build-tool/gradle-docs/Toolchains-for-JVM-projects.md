---
title: "Gradle : Toolchains for JVM projects"
date: 2023-01-21T16:00:00+09:00
tags: ["Gradle","Korean"]
---

default 설정에 따라 gradle은 프로젝트의 빌드, gradle 자체를 실행하는데 있어서 똑같은 자바 버전을 사용한다. (참고. gradle은 Java로 구현되어 있음.)
By default, Gradle uses the same Java version for running Gradle itself and building JVM projects.

이것이 항상 좋은것만은 아니다. 개발자 별로 또는 CI 서버가 서로 다른 자바 버전을 사용해서 프로젝트를 빌드한다면 예상치 못한 문제가 발생할 수 있다. (사용자 마다 running gradle 버전이 다르면 프로젝트 빌드시 사용하는 JDK의 버전도 달라질것이다.) 거기다 running gradle이 지원하지 않는 버전의 자바를 사용해서 프로젝트를 빌드하고 싶은 경우도 있을것이다.

Java Toolchain(일반적으로 toolchain이라 부름)은 tool의 묶음이다. 일반적으론 build의 다른 부분들을 설정하기 위해 사용되는 local JRE/JDK 설치를 통해서 가져온다.
Compile task는 자신들의 Compiler로 `javac`를 사용할것이고, test와 exec task를 위해서 `java` 명령어를 사용할 것이다. 또한, 문서 생성을 위해서 `javac`명령어를 사용할 것이다.
# Consuming Toolchains
build는 Java 버전(벤더는 Optional)을 설정함으로써 전역으로 적용할 toolchain 정의가 가능하다.
```
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
```
build 실행을 하면 toolchain에 연관된 몇가지 동작을 수행한다.
1. Compile, test, javadoc task가 정의된 toolchain을 사용할 수 있도록 세팅한다.
2. gradle은 로컬에 있는 JVM을 찾는다.
3. gradle은 toolchain에 정의된 버전의 JRE/JDK를 찾는다.
4. 만약에 매칭되는게 없다면 자동으로 AdopOpenJDK에서 버전에 맞는 JDK를 다운로드 받는다.
# Using toolchains by specific vendors
버전뿐만 아니라 원하는 vendor의 JDK를 설정할 수 있다.
```
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
        vendor = JvmVendorSpec.ADOPTIUM
    }
}
```

# 원문 링크
[https://docs.gradle.org/current/userguide/toolchains.html#toolchains](https://docs.gradle.org/current/userguide/toolchains.html#toolchains)