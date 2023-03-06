# Constant Pool
클래스 파일 포멧으로 기록되어 있던 상수들을 모아둔 공간을 의미한다. 리터럴, 심볼릭 참조, 메소드, 필드 등 자바 프로그램을 실행하는데 있어서 필요한 정보들이 모두 기록되어 있다.

Constant Pool은 컴파일러 시점에 Java Compiler에 의해 작성된다. `.class` 파일에 대해서 `javap -v 파일명` 명령어를 수행하면 constant pool을 확인할 수 있다. (정리하면 Constant Pool은 `.class` 파일에 바이트코드와 함께 기록되어 있다!!)

JVM은 프로그램을 실행하면서 Constant Pool에 있는 상수들을 사용하면서 작업을 하게된다.


`HelloWorld.java` 파일
```java
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }
}
```

`HelloWorld.class`의 바이트 코드 영역
```java
public class HelloWorld {
  public HelloWorld();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello, world!
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
```

`HelloWorld.class`의 Constant Pool 영역
```less
Constant pool:
   #1 = Methodref          #7.#22         // java/lang/Object."<init>":()V
   #2 = Fieldref           #23.#24        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #25            // Hello, world!
   #4 = Methodref          #26.#27        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = Class              #28            // HelloWorld
   #6 = Methodref          #5.#22         // HelloWorld."<init>":()V
   #7 = Class              #29            // java/lang/Object
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               main
  #13 = Utf8               ([Ljava/lang/String;)V
  #14 = Utf8               SourceFile
  #15 = Utf8               HelloWorld.java
  #16 = Utf8               Hello, world!
  #17 = Utf8               java/lang/System
  #18 = Utf8               out
  #19 = Utf8               Ljava/io/PrintStream;
  #20 = Utf8               println
  #21 = Utf8               (Ljava/lang/String;)V
  #22 = NameAndType        #8:#9          // "<init>":()V
  #23 = Class              #17            // java/lang/System
  #24 = NameAndType        #18:#19        // out:Ljava/io/PrintStream;
  #25 = Utf8               Hello, world!
  #26 = Class              #30            // java/io/PrintStream
  #27 = NameAndType        #20:#21        // println:(Ljava/lang/String;)V
  #28 = Utf8               HelloWorld
  #29 = Utf8               java/lang/Object
  #30 = Utf8               java/io/PrintStream
```

# 참고 링크
https://qr.ae/prcqjy
