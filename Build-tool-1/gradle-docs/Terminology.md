---
title: "Gradle : Terminology"
date: 2023-01-21T16:00:00+09:00
tags: ["Gradle","Korean"]
---

# 원문 링크
[https://docs.gradle.org/current/userguide/what_is_gradle.html#terminology](https://docs.gradle.org/current/userguide/what_is_gradle.html#terminology)

# Terminology
## Projects
Projects는 빌드 대상이다. Projects는 build script를 포함하는데 위치는 root에 `build.gradle`라는 이름으로 있다. Build script는 Projects에 대한 tasks, dependencies, plugins와 그외 설정들을 포함하고 있다. build는 1개 이상의 Project를 포함할 수 있으며, 각 Project는 자신들의 subproject를 가질 수 있다.
## Tasks
Tasks는 소프트웨어 배포, 테스트 실행, 코드 컴파일작업 실행에 대한 로직들을 포함한다. 대부분의 경우는 기존에 존재하는 task를 사용하게 된다. Gradle은 일반적인 build 시스템이 필요로 하는 task를 기본적으로 제공한다.(예를들면, Java Test task같은 경우 기본적으로 Built-in 되어 있어서 사용자가 직접 추가하지 않아도 된다!) Plugins를 통해서 더 다양한 타입의 tasks를 제공한다.
### Task는 아래 동작으로 구성된다.
- Actions: 수행작업을 뜻한다. 예를들면 파일 복사, 소스 컴파일 등
- Inputs : Actions에서 사용하거나 실행시킬때 사용하는 값, 파일, 경로들을 의미한다
- Outputs : Actions이 수정하거나, 생성한 파일이나 디렉토리를 의미한다.
## Plugins
Plugins는 build의 task,file, dependency 설정에 있어 새로운 컨셉을 적용할 수 있게 해준다. 예를 들면, 대부분의 개발 언어 plugins는 빌드를 위한 source sets 개념을 도입했다. (참고 : https://docs.gradle.org/current/userguide/building_java_projects.html#sec:java_source_sets)

Plugins는 로직 재사용, 여러 프로젝트에 적용가능한 설정 등을 제공한다. Plugins를 사용하면 task를 한번만 작성하고도 여러 build에서 재사용할 수 있다. 공통(commone) 설정으로 사용할 수도 있다. (예를 들면 logging, dependencies 또는 버전 매니지먼트 등) plugins를 통해서 중복된 build 스크립트 작성을 예방할 수 있다. 이렇게 plugins를 통해서 좀더 손쉽게 tasks를 적용할 수 있게된다.
## Build Phases
Gradle은 build 스크립트를 검사 및 실행하는데 총 3개의 Phase로 나눠서 진행된다. (Build Lifecycle)
### Initialization
빌드를 위한 환경을 구성하고, 어떤 프로젝트를 빌드할 것인지 판단한다.
### Configuration
빌드를 위한 task graph를 생성한다.
사용자고 실행하고자 하는 작업이 어떤 task를 필요로 하는지 그리고 어떤 실행 순서로 진행되어야 하는지 판단한다.
### Execution
configuration phase에서 선택된 task들을 실행한다.
## Builds
Build는 tasks의 묶음을 실행하는걸 말한다. CLI나 IDE를 통해서 build를 수행할 수 있다. Gradle은 가장 작은 tasks set를 실행하는데, set는 dependencies와 또다른 task에 의해 선택된다.