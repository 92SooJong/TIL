# Interpreting and Classloading

JVM은 stack-based interpreted machine이다. 이 뜻은 CPU같은 물리적 하드웨어를 뜻하는게 아니라 execution stack을 의미한다. 그리고 이 스택에 존재하는 값들을 통해서 계산을 수행한다.

예를들어  `java HelloWorld` 커맨드를 실행하면, 운영체제는 virtual machine process(the java binary)를 실행한다. 이 과정에서 자바 가상 환경 세팅과 초기화를 수행한다. 이 결과로 HelloWorld.class 파일을 생성한다.

생성된 클래스 파일의 진입점은 main() 메소드가 될것이다. 클래스 파일을 제어하기 위해선 가상 머신을 실행하기 전에 클래스 파일이 로딩되어야한다.

이 작업을 위해 Java Class Loading 메커니즘이 사용된다. 새로운 Java process가 실행될때 클래스로더 체인이 사용되며 가장 먼저 실행되는 initial loader는 Bootstrap 클래스로더이다. 

Bootstrap 클래스로더는 core Java runtime에 있는 클래스들을 포함하고 있다. 자바 8버전 까지는 이것들이 rt.jar 파일로부터 로딩된다. (런타임의 약자인듯?) 자바 9버전 이후론 모듈화 되었고, 클래스로더 컨셉 자체가 바껴버렸다.

Bootstrap 클래스 로더의 핵심은 최소한의 class만 로딩한다는 것이다. ( java.lang.Object, Class, Classloader같은 애들을 말함.) 이 클래스들은 시스템의 다른 부분을 불러올 수 있도록 도와주는 역할을 주로 한다. (클래스 로더도 하나의 오브젝트이기 때문에 최소한의 클래스 세트가 필요함.)

그다음으로 Extension 클래스 로더가 생성된다. 확장 클래스로더는 부모를 부트스트랩 클래스로더로 정의하고, 부모에게 자신을 위임합니다. ( 즉, 부모 클래스 로더를 확장하는 역할을 함 )

그렇게 흔히 사용되는 클래스로더는 아니다. 하지만 오버라이드 기능을 제공할 수 있고, 특정 운영체제에 필요한 네이티브 코드를 작성해야할 때 사용할 수 있다.

마지막으로 Application 클래스로더가 생성된다. 클래스 Path에 정의되어 있는 유저 클래스를 로딩하는 책임을 가진다. 어쩔땐 System 클래스로더로 불리기도하는데 이 용어는 적절하지 않으므로 피하도록 하자. (시스템 클래스를 호출한다고 오해할 여지가 생긴다. 시스템 클래스를 호출하는 역할은 Bootstrap 클래스로더가 수행한다.)

자바는 의존성을 통해 새로운 클래스들을 로드한다. 프로그램을 실행하다가 처음으로 마주치는 그순간에…

클래스로더가 적절한 클래스를 찾는걸 실패하면 행위는 부모 클래스로더로 위임된다. 

만약 이러한 체인이 Bootstrap 클래스로더까지 도달하고 적절한 클래스를 찾지못한다면 ClassNotFoundException이 발생할 것이다. 

자바는 클래스를 단 한번만 로드하며, Class 오브젝트가 생성된다. 대표한다 클래스를 런타임 환경에서.

하지만, 서로 다른 클래스 로더라면 잠재적으로 같은 클래스가 각각 호출된다. ( 즉 두번 이상 호출되는 일이 있음)

그결과 시스템에 있는 클래스는 클래스 로더와 패키지명을 통해서 유일성이 식별된다. 

# Executing Bytecode

자바 소스코드가 실행 전까지 많은 변환작업이 있다는걸 아는게 중요하다. 

첫번째는 compilation step이다. 이 과정을 위해 Java compiler인 `javac` 가 사용된다. 

javac의 역할은 Java code를 바이트 코드를 포함한 .class 파일로 변환하는것이다. 

아주 최소한의 최적화 작업이 이 과정에서 이뤄진다. 결과로 나온 바이트 코드는 꽤 읽을 수 있는 수준이다. disassembly 툴을 사용해서 표준인 javap 같은걸 사용하면 말이다. 

바이트 코드는 중간단계를 나타낸다. 즉 특정 하드웨어와 엮여 있는 상태가 아니다. 

하드웨어와 디커플링을 통해서 포터블한 능력을 제공하게 된다. JVM 상에서 돌아가기 때문에 하드웨어에 의존적이지 않다. JVM을 사용했을때 중요한 포인트중 하나다.

컴파일된 클래스파일은 잘 정의된 구조를 가지고 있다. 클래스 파일은 VM 명세에 지정된 컴포넌트로 구성된다. 

![Untitled](./images/Untitled.png)

![Untitled](./images/Untitled%201.png)

모든 클래스들은  매직넘버 0xCAFEBABE로 시작한다. 첫 4바이트는 클래스 파일 형식에 대한 적합성을 나타낸다. 그뒤에 오는 4 바이트는 클래스 파일을 컴파일하는데 사용되는 minor , major 버전을 나타낸다. 이를 이용해서 클래스로더는 JVM과 버전이 매칭이 되는지 확인할 수 있다. 

만약 버전이 매칭되지 않는다면, UnsupportedClassVersionError가 발생한다. (JVM이 컴파일된 클래스파일을 사용하기엔 낮은 버전이라는 걸 뜻한다.)

Constant pool은 상수 정보를 가지고 있다. 예를들면 클래스, 인터페이스, 필드 이름과 같은 것들이다. JVM이 코드를 실행할때 값을 얻기 위해 상수 테이블이 사용된다. ( 어떤 메모리에 의존하지 않음 )

Access flag들은 modifier가 클래스에 접근할 수 있는지를 검사한다. 예를 들면 final 클래스면 서브 클래스를 가질수 없도록 하는 역할들을 수행한다. 

인터페이스인지 추상클래스인지 검사함. 또한, enum인지 어노테이션 타입인지 검사한다.

This class, Superclass, Interface는 constant pool의 인덱스로 존재한다. 인지하기 위해 타입의 계층구조를…

아래 그림을 통해서 좀더 바이트 구조를 쉽게 암기할 수 있다.

![Untitled](./images/Untitled%202.png)

아래 간단한 코드를 컴파일 해보자.

```java
public class HelloWorld {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello World");
		} 
}
```

생성된 클래스 파일을 javap를 통해서 확인해보자. 

클래스 파일에 대한 바이트 코드를 확인할 수 있다. 메소드가 두개로 보이는데 컴파일 과정에서 자동으로 생성자 메소드가 생성되었기 때문이다. 

![Untitled](./images/Untitled%203.png)

생성자에 있는 aload_0는 `this` 에 대한 레퍼런스를 뜻하며 스택의 첫번째에 위치하게 됩니다.

invokespecial 명령어는 슈퍼 생성자를 호출해서 오브젝트를 생성하는 역할을 합니다. 위 예시에서는 default가 실행되는데 이때는 Object 클래스의 생성자가 호출됩니다. 

main 메소드에 있는 iconst_0는 상수인 0을 evaluation 스택에 넣는다.

istore_1은 스택에 있던 상수 값을 지역 변수 오프셋 1번에 저장한다. (for 문에 있던 i 변수를 의미한다.)

사실 지역변수의 오프셋은 0부터 시작한다. 하지만 인스턴스 메소드에선 0번째 오프셋은 항상 this가 된다.

오프셋 1에 있는 변수는 스택으로 로딩된다. 그리고 bipush 10을 통해서 변수 10이 비교를 위해 스택으로 로딩된다. 비교는 if_icmpage( if integer compare greater or equal ) 명령어를 통해 수행하게된다. 22의 의미는 테스트 성공시 22로 이동하라는 뜻이다. ( 현재 코드에선 22는 return이다. )테스트는 현재 정수가 10보다 크거나 같을때만 성공하게 된다. 

몇번의 루프동안 조건 검사는 계속 실패하게 되므로 8번 작업을 수행하면된다. getstatic #2는 System.out 을 의미하며 이후에 있는 ldc #3(상수 pool #3) 에 존재하던 “Hello World” 문자를 가져와 출력한다. 

invokevirtual은  인스턴스 메소드를 실행시킨다. 

iinc는 정수의 증가(integer increment)를 의미하며, 1씩 증가하며 1번에 있는 istore_1을 업데이트한다. 

goto는 2번째 명령어로 포인터를 옮기는 역할을 한다. 

이 작업은 if_icmpge가 성공할때까지 계속해서 수행된다. 

# Introducing HotSpot

1999년 4월 Sun은 성능과 관련된 용어에 대해서 변경사항을 발표했다.

HotSpot 가상 머신은 자바의 핵심기능이며, C와 C++과 비견될만한 성능 변화를 가져왔다. 

런타임시에 발생하는 동작을 실시간으로 분석하고 이를 성능 최적화에 활용한다.

![Untitled](./images/Untitled%204.png)

# Introducing Just-In-Time Compilation

자바 프로그램은 바이트 코드 인터프리터 위에서 실행된다. 바이트코드 인터프리터는 가상화된 스택 머신위에서 명령어를 실행한다.

이렇게 하드웨어(CPU, 레지스터 등)에 직접 접근하지 않고 추상화 하는 방식은 클래스 파일이 포터블할 수 있도록 해준다.(따라서 코드가 하드웨어에 의존적이지 않아도된다.) 하지만 최대의 성능을 내기 위해선 CPU가 직접 코드를 실행하도록 해야한다.

이런 문제를 HotSpot은 바이트 코드를 네이티브 코드로 변환하는 방식을 몇 가지 unit을 통해서 해결했다. HotSpot VM 내부에 있는 컴파일 unit들은 메소드와 루프이다. 이것은 Just-In-Time(JIT)으로 많이 알려져 있다. 

JIT 컴파일은 구동중인 application을 모니터링하면서 진행되는데, 여기서 가장 자주 실행되는 코드의 부분을 찾는다. 특정 메소드의 실행이 threshold를 넘어가게 되면, profiler가 코드의 특정 영역을 컴파일하고 최적화 작업을 수행한다. 

JIT는 최적화를 인터프리터 단계에서 수집된 정보를 기반으로 최적화를 수행하기 때문에 좀 더 객관적인 정보를 통한 최적화가 가능하다는 장점을 가진다. 또한 수많은 엔지니어링 기간을 보냈기때문에 매 버전마다 개선된 JIT을 사용할 수 있다. 

C++ 같은 언어는 성능이 예상가능하다. 하지만 사용자는 상당한 복잡성을 가진 low-level을 다뤄야하는 단점이 있다. 또한 “예상 가능한”이 더 좋다는 것을 의미하지도 않는다. (AOT vs PGO에 대해서 살펴보기)

HotSpot 컴파일은 VM에 제공하는 두개의 핵심 기능중 하나이다. 또다른 하나는 메모리 관리이다.