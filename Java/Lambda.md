# 정의
- lambda는 Java 8에서 처음으로 등장했다.
- lambda는 이름이 없는 함수, 익명함수 정도로 이해하면 되겠다. 
- lambda는 변수형태로 저장이 가능하며 따라서 메서드의 인수로 전달이 가능하다.

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(9);
    numbers.add(8);
    numbers.add(1);
    // (parameter) -> {code block} 형태로 작성한 예제이다.
    numbers.forEach( (n) -> { System.out.println(n); } ); 
    
  }
}
```


Java의 Consumer 인터페이스를 통해서 lambda를 변수에 할당할 수 있다.
```java
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(9);
    numbers.add(8);
    numbers.add(1);
    // lambda식을 변수에 할당.
    Consumer<Integer> method = (n) -> { System.out.println(n); };
    numbers.forEach( method );
  }
}
```
