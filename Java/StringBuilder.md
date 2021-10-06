
## StringBuilder
- String 간의 Concat연산을 메모리를 최대한 효율적으로 활용해서 수행하기 위한 객체다.
- "aaa" + "bbb"를 수행하면 Java는 내부적으로 "aaabbbb"를 담기 위해 새로운 메모리공간을 사용한다.
- StringBuilder는 "aaa","bbb"연산을 하면 새로운 메모리 공간을 사용하지 않고 "aaa"와 "bbb"를 합치게 해준다.

```java

StringBuilder sb = new StringBuilder();

sb.append("aaa");
sb.append("bbb");

System.out.println(sb.toString());

```

- 동기화를 보장하진 않는다. 
- StringBuilder는 MultiThread 환경에서는 사용하지 않는게 좋다. ( Thread가 String Buffer에 동시접근이 가능하다. )
- 동기화가 요구된다면 StringBuffer를 사용할 것을 권장한다.


## StringBuffer

- StringBuffer는 Multi Thread로부터 안전하다. 
- 쓰레드가 한번에 하나씩만 String Buffer에 접근이 가능하다.
- StringBuilder와 마찬가지로 append와 insert가 주요 메서드이다.
