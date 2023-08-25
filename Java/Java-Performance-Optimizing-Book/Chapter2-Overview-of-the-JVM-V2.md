# Chapter 2. Overview of the JVM

## Interpreting and Classloading
According to the specification that defines the Java Virtual Machine (usually called the VM Spec), the JVM is a stack-based interpreted machine. This means that rather than having registers (like a physical hardware CPU), it uses an execution stack of partial results and performs calculations by operating on the top value (or values) of that stack. 

> JVM의 문서를 보면 JVM은 stack-based 인터프리터 머신이라고 설명하고 있다. 여기서 말하는 stack-based는 어떤 값이 물리적인 register에 저장되는게 아니라 가상의 stack을 만들어서 작업을 처리한다는 뜻이다.
   
The basic behavior of the JVM interpreter can be thought of as essentially “a switch inside a while loop”—processing each opcode of the program independently of the last, using the evaluation stack to hold intermediate values.

> JVM의 기본동작 "a switch inside a while loop"이다. 이뜻은 stack을 통해서 값들을 저장하고 가장 최신 opcode로 연산을 처리함을 의미한다.

When we launch our application using the `java HelloWorld` command, the operating system starts the virtual machine process (the java binary). This sets up the Java virtual environment and initializes the stack machine that will actually execute the user code in the HelloWorld class file.

>  `java HelloWorld` 명령어를 실행하면 운영체제는 java binary를 처리하기 위한 VM을 실행한다. 이 준비 과정에서 HelloWorld class 파일을 실행할 Java virutal 환경과 stack machine을 초기화 한다.

The entry point into the application will be the main() method of HelloWorld.class. In order to hand over control to this class, it must be loaded by the virtual machine before execution can begin.

> 코드의 시작지점은 `main()` 메소드이다. 클래스를 처리하기 위해서 코드를 실행하기전 VM에 의해 로드가 되어야 한다.

To achieve this, the Java classloading mechanism is used. When a new Java process is initializing, a chain of classloaders is used. The initial loader is known as the `Bootstrap classloader` and contains classes in the core Java runtime. In versions of Java up to and including 8, these are loaded from `rt.jar`. In version 9 and later, the runtime has been modularised and the concepts of classloading are somewhat different.

> 로드를 위해서 Java classloading 메커니즘이 사용된다. 새로운 Java 프로세스가 초기화 될때, classloader들의 체인이 사용된다.

The main point of the Bootstrap classloader is to get a minimal set of classes (which includes essentials such as java.lang.Object, Class, and Classloader) loaded to allow other classloaders to bring up the rest of the system.

> Bootstrap classloader는 다른 classloader들이 system의 나머지 부분들을 실행시키기 위해 필요한 최소한의 클래스들을 로딩하는 역할을 한다.

The Extension classloader is created next; it defines its parent to be the Bootstrap classloader and will delegate to its parent if needed. Extensions are not widely used, but can supply overrides and native code for specific operating systems and platforms. Notably, the Nashorn JavaScript runtime introduced in Java 8 is loaded by the Extension loader.

> 그 다음 Extension classloader가 생성된다. overrides와 네이티브 코드를 제공한다.

Finally, the Application classloader is created; it is responsible for loading in user classes from the defined classpath. Some texts unfortunately refer to this as the “System” classloader. This term should be avoided, for the simple reason that it doesn’t load the system classes (the Bootstrap classloader does). The Application classloader is encountered extremely frequently, and it has the Extension loader as its parent.

> 마지막으로 Application classloader가 생성된다. 정의된 classpath 하위에 있는 사용자가 만든 class를 로딩한다. 종종 System classloader라고 부르는 곳이 있는데 가능하면 지양하자. system을 로드하지 않을 뿐더러 혼란만 발생시킬 뿐이다.(system 로드는 Bootstrap classloader가 수행한다.)

Java loads in dependencies on new classes when they are first encountered during the execution of the program. If a classloader fails to find a class, the behavior is usually to delegate the lookup to the parent. If the chain of lookups reaches the Bootstrap classloader and it isn’t found, a ClassNotFoundException will be thrown.

> 프로그램을 실행시키는 동안 가장 처음 만나는 작업이 의존성을 로드하는것이다. 클래스로더가 필요한 클래스를 찾지 못한다면 부모 클래스로더에 역할을 위임한다. 최상위 클래스 로더인 Bootstrap도 클래스를 찾지 못한다면 `ClassNotFoundException` Exception을 띄운다.

Under normal circumstances Java only loads a class once and a Class object is created to represent the class in the runtime environment. However, it is important to realize that the same class can potentially be loaded twice by different classloaders. As a result, a class in the system is identified by the classloader used to load it as well as the fully qualified class name (which includes the package name).