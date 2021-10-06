- String 간의 Concat연산을 메모리를 최대한 효율적으로 활용해서 수행하기 위한 객체다.
- "aaa" + "bbb"를 수행하면 Java는 내부적으로 "aaabbbb"를 담기 위해 새로운 메모리공간을 사용한다.
- StringBuilder는 "aaa","bbb"연산을 하면 새로운 메모리 공간을 사용하지 않고 "aaa"와 "bbb"를 합치게 해준다.

```java

StringBuilder sb = new StringBuilder();

sb.append("aaa");
sb.append("bbb");

System.out.println(sb.toString());

```
