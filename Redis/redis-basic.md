# Redis Data Types

## Keys

- Redis의 Key는 바이너리 세이프.
- String, JPEG 파일까지 Key가 가능함.
- 공백 String도 유효한 Key
- key가 너무 긴건 추천하지 않는다. (메모리 측면이나 성능 측면에서 다 안좋음.)
- Key가 너무 짧은건 추천하지 않는다. u1000flw말고 `user:1000:followers` 처럼 읽기 좋게 써라.
- 스키마를 표기해주면 좋다. `object-type:id` `user:1000`
- 여러 단어를 붙여쓸땐 점이나 대쉬를 사용한다. `comment:4321:reply-to`
- 최대 Key size는 512MB이다
  
## Strings
- key중에서 제일 단순한 형태.
- 초보자에게 친숙함.
- key 자체를 그냥 value로 쓸수도 있음. String을 또다른 String으로 할당하는 식
- String은 HTML같은걸 캐싱하고 싶을때 유용하다.

```shell
> set mykey somevalue
OK
> get mykey
"somevalue"
```
- set을 쓰면 기존에 존재하던 데이터를 덮어씀.
- set은 몇가지 옵션을 제공한다. 이미 키가 존재하면 실패하도록 하는식.(그 반대도 가능)

```shell
> set mykey newval nx
(nil)
> set mykey newval xx
OK
```

- String에 대해서 몇가지 추가적인 명령어를 제공한다
```shell
> set counter 100
OK
> incr counter
(integer) 101
> incr counter
(integer) 102
> incrby counter 50
(integer) 152
```
- INCR은 String을 Integer로 파싱하고, 1 증가시키는 명령어. (비슷하게 INCRBY, DECR, DECRBY가 있다)
- INCR은 원자성(atomic)을 보장한다. 따라서 race condition 문제가 발생하지 않음.

```shell
> mset a 10 b 20 c 30
OK
> mget a b c
1) "10"
2) "20"
3) "30"
```
- `MSET`과 `MGET`을 통해서 한번에 여러개의 값을 가져오거나 세팅할 수 있음. (low latency 효과 기대)

## Altering and querying the key space
- 특정 타입에 의존하지 않는 명령어도 존재함.(수정, 조회)
- 예를들면 `EXIST`를 통해서 key가 존재하는지 확인할 수 있다.
```shell
> set mykey hello
OK
> exists mykey
(integer) 1
> del mykey
(integer) 1
> exists mykey
(integer) 0
```
- `TYPE` 명령어를 통해서 key의 타입을 확인할 수 있다.
```shell
> set mykey x
OK
> type mykey
string
> del mykey
(integer) 1
> type mykey
none
```

## Key expiration
- key에 대한 타임아웃을 설정할 수 있다.
- time to live 또는 TTL이라고 부른다.
- 초 또는 밀리세컨드로 설정이 가능하다.
- key 만료와 관련된 정보는 디스크에 저장된다.
- Redis 서버가 멈추더라도 시간을 흐른것으로 간주한다(Redis가 key의 만료 시간을 저장하고 있음을 의미한다)
```shell
> set key some-value
OK
> expire key 5
(integer) 1
> get key (immediately)
"some-value"
> get key (after some time)
(nil)
```
- `expire` 명령어를 통해서 key의 만료 시간을 지정할 수 있다.
- 위 예시는 key라는 이름을 가진 key의 만료시간을 5초로 설정하는 예시다.
- `set` 명령어를 사용할때 옵션으로 만료 시간을 줄 수 있다.
```shell
> set key 100 ex 10
OK
> ttl key
(integer) 9
```
- 위 예시는 key-value를 생성함과 동시에 10초의 만료 시간을 지정한다.
- `ttl` 명령어를 통해서 남아있는 만료 시간을 조회할 수 있다.

## Lists
- List라는 용어는 언어별로 의미가 다르게 사용되는 경향이 있다. 파이썬의 list는 Linked Lists가 아닌 Array를 의미함.
- List는 연속적이며 순서가 있는 elements의 목록(List)를 의미한다.
- Redis의 list는 Linked lists를 의미한다. 따라서 새로운 elements를 추가하는데 있어서 속도가 상수 시간으로 보장된다.
- index를 통한 접근은 단점이다.
- 만약 인덱스를 통한 접근이 중요하다면 Sorted sets 타입을 사용해라.

## First steps with Redis Lists
- The `LPUSH` command adds a new element into a list, on the left (at the head)
```shell
> rpush mylist A
(integer) 1
> rpush mylist B
(integer) 2
> lpush mylist first
(integer) 3
> lrange mylist 0 -1
1) "first"
2) "A"
3) "B"
```

- In one time, you can add multiple elements.
```shell
> rpush mylist 1 2 3 4 5 "foo bar"
(integer) 9
> lrange mylist 0 -1
1) "first"
2) "A"
3) "B"
4) "1"
5) "2"
6) "3"
7) "4"
8) "5"
9) "foo bar"
```
- pop is the operation of both retrieving the element from the list, and eliminating it from the list at the same time.
```shell
> rpush mylist a b c
(integer) 3
> rpop mylist
"c"
> rpop mylist
"b"
> rpop mylist
"a"
```



# etc

Redis can persist your data either by periodically dumping the dataset to disk. You can also disable persistence if you just need a feature-rich, networked, in-memory cache.


External programs talk to Redis using a TCP socket and a Redis specific protocol.

you need to download and install a Redis client library for your programming language.