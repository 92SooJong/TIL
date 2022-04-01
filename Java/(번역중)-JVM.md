# 개요
Java 메모리 관리는 application을 튜닝하기 위해서 필수적으로 알아야하는 지식이다. 메모리 관리의 핵심은 새로운 오브젝트를 생성을 처리하고, 사용하지 않는 오브젝트를 지우는 일이 핵심이다.

# Java Virtual Machine (JVM)
- JVM은 Java 프로그램을 구동하기 위한 컴퓨터 추상화 기술이다. 따라서 O/S에 의존하지 않고 어디서든 구동이 가능하다.
- JVM은 3가지 개념으로 나눠볼수 있다.
- Specification(명세) : JVM이 구동되는 명세를 뜻하며, 구현체는 SUN이나 그외 회사들에 의해 제공된다.
- Implementation(구현) : 흔히 Java Runtime Environment
- Instance : 자바 명령어를 작성한후 Java Class를 실행하기 위한 JVM 인스턴스가 생성된다.

# Java (JVM) Memory Structure
JVM memory is divided into multiple parts: Heap Memory, Non-Heap Memory, and Other.
- JVM 메모리는 몇가지 부분으로 나눠질 수 있다. : 힙, Non-힙, 그외

## Heap Memory
Heap memory is the run time data area from which the memory for all java class instances and arrays is allocated. 
- heap 메모리는 모든 클래스와 배열의 인스턴스가 할당되는 런타임 데이터 영역이다.
- heap은 JVM이 시작될때 생성된다. 
The heap is created when the Java Virtual Machine starts up and may increase or decrease in size while the application runs. 

The size of the heap can be specified using –Xms VM option. The heap can be of fixed size or variable size depending on the garbage collection strategy. Maximum heap size can be set using –Xmx option. By default, the maximum heap size is set to 64 MB.


# 참고자료
[https://www.betsol.com/blog/java-memory-management-for-java-virtual-machine-jvm/](https://www.betsol.com/blog/java-memory-management-for-java-virtual-machine-jvm/)
