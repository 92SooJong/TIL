# 정의
트랜잭션들 끼리 일관된 데이터를 얼마나 허용할 것인지를 정하는 수준이다.

# 종류
총 4가지의 단계가 존재한다. 고립 수준(레벨)이 높아질수록 동시성은 낮아지며, 일관성은 높아진다.
즉, 고립이 심해질수록 동시 접근성은 떨어지지만, 데이터가 일관되게 관리됨을 의미한다.
- Level 0 Read Uncommitted
  - Transaction A가 수행되는 와중에 Transaction B가 데이터를 변경할 수 있다. 이럴때 A는 변경되기 전의 데이터를 읽을 가능성이 있다. 이를 Dirty Read라고 한다.
  - 동시성은 높으나 일관성이 떨어짐, 가능하면 사용하지 말것
  - 발생가능한 이상현상 : Dirty Read, Non Repeatable Read, Phantom Read
- Level 1 Read Committed
  - 트랜잭션이 작업하는 시점에 Lock을 건다.
  - Lock 을 거는 주체는 INSERT 나 UPDATE 와 같은 처리 세션이며, SELECT는 INSERT,UPDATE가 끝날때까지 대기함.
  - 대부분의 DB의 고립레벨이다. (MySQL 제외)
  - 발생가능한 이상현상 : Non Repeatable Read, Phantom Read
- Level 2 Repeatable Read
  - SELECT를 할때 Lock을 걸며, INSERT나 UPDATE가 대기한다.
  - MySQL의 고립레벨이다.
  - 발생가능한 이상현상 : Phantom Read
- Level 3 Serializable
  - 데이터의 안정성이 매우 중요한 특수한 상황이 아닌 이상 거의 사용하지 않음
  - 발생가능한 이상현상은 없다.



