---
title: "Gradle : Building Java Applications Sample"
date: 2023-01-20T22:55:00+09:00
tags: ["Gradle","Korean"]
---

# 원문 링크
[https://docs.gradle.org/current/samples/sample_building_java_applications.html](https://docs.gradle.org/current/samples/sample_building_java_applications.html)

# 프로젝트 구조
![](/images/build/2023/01/2023-01-20-23-52-42.png)
1. wrapper 파일을 포함한 폴더
2. wrapper를 실행하기 위한 스크립트들
3. build 이름과 서브모듈을 정의하기 위한 세팅파일
4. `app` 프로젝트(예시)를 빌드하기 위한 스크립트
5. 자바 서비스 코드 폴더
6. 자바 테스트 코드 폴더

# Review the project files
최초의 `settings.gradle` 파일엔 2줄이 있다.
![](/images/build/2023/01/2023-01-20-23-58-29.png)
`rootProject.name` build에 이름을 부여한다. 이 정보가 없으면 기본적으로 폴더이름을 따라가게 된다. (가능하면 위 처럼 fix된 이름으로 하자)

`include("app")` 프로젝트가 포함하고 있는 서브프로젝트를 정의한다. 서브프로젝트를 추가하고 싶다면 `include(..)`를 사용하면된다.

우리는 app이라 불리는 1개의 서브 프로젝트를 가지고 있으며, app의 빌드 설정은 `app/build.gradle`을 통해서 할 수 있다.
![](/images/build/2023/01/2023-01-21-00-03-09.png)
1. 자바에서 CLI application을 빌드할 수 있는 application plugin을 적용한다. 
2. 의존성 관리를 mavenCentral이 하도록 한다.
3. 테스트를 위해 junit jupiter를 사용하도록 한다.
4. application에서 사용할 의존성을 추가한다
5. application의 main 클래스를 지정한다

# Run the application
`application` plugin 덕분에 Command line으로 application을 바로 run 할수 있다.

run 명령어를 통해서 `build.gradle`에서 작성한 `mainClass`를 실행한다

```
$ ./gradlew run

> Task :app:run
Hello world!

BUILD SUCCESSFUL
2 actionable tasks: 2 executed
```

# Bundle the application
`application` plugin은 application을 모든 의존성과 함꼐 묶을 수 있다. 이 작업은 `build` 명령어를 통해 간단히 수행할 수 있다.
```
$ ./gradlew build

BUILD SUCCESSFUL in 0s
7 actionable tasks: 7 executed
```

# Publish a Build Scan
build 과정에서 실제로 어떤 동작이 수행되고 있는지 확인하고 싶다면 build scan을 발행 하면된다. build scan은 build 명령어에 `--scan` 옵션을 추가해주면 된다.
```
$ ./gradlew build --scan

BUILD SUCCESSFUL in 0s
7 actionable tasks: 7 executed

Publishing a build scan to scans.gradle.com requires accepting the Gradle Terms of Service defined at https://gradle.com/terms-of-service.
Do you accept these terms? [yes, no] yes

Gradle Terms of Service accepted.

Publishing build scan...
https://gradle.com/s/5u4w3gxeurtd2
```

terminal에 출력된 사이트를 들어가면 아래와 같이 build에 대한 정보를 확인할 수 있다.
![](/images/build/2023/01/2023-01-21-00-42-02.png)