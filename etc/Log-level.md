
불필요한 연산을 최소화하기 위해 문자열 `+`대신 파라미터를 사용한 출력을 할수있도록 코드를 작성하자.
```java
// ( 아래로 갈수록 심각도가 높아짐 )
log.trace("trace log={}" , name);
log.debug("debug log={}" , name);
log.info("info log={}" , name);
log.warn("warn log={}" , name);
log.error("error log={}" , name);
```
