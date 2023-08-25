# Separate Chaining

Separate Chaining는 충돌 해결을 위한 테크닉이다.

Linked List를 사용하는 방법이다.

이 방법을 사용하면 elements를 같은 slot에 넣을 수 있다. 

각 슬롯은 Linked List이다. 하나의 슬롯에 2개 이상의 elements를 넣어야 하는경우 유용하다.

![Untitled](/images/cs/2022-11/separate-chaining.png)

# **How to Avoid Collision in Separate Chaining Method**

가능하면 충돌을 최소화하는 Hash function을 설계하는게 중요하다. 좋은 hash function은 아래와 같다.

- 충돌 최소화
- 계산하기 쉽고 속도가 빠르다.
- 해쉬 테이블에 균형있게 insert 된다.
- Key에 대해서 high load factor를 가진다.

## **Time Complexity**

검색시 O(1+load factor)의 시간 복잡도를 가진다. 

하나의 슬롯안에 여러 엘리멘츠가 있을 경우 Linked list를 검색하는 작업이 추가로 필요하다. 워스트 케이스는 모든 elements가 하나의 슬롯안에 들어가 있는 경우다. 이 경우 시간 복잡도는 O(n)이 된다. 

검색과 마찬가지로 삭제시에 O(1+load factor)의 시간 복잡도를 가진다. 워스트 케이스의 경우 O(n) 시간 복잡도를 가진다. 

## **Load Factor**

균일하게 Key가 slot에 분배 되어 있는 지 알려주는 지표다.

Load Factor= Total elements in hash table/ Size of hash table

# **Advantages**

Seperate Chaining은 가장 쉬운 방법이다.

chain을 통해서 제한없이 elements를 추가할 수 있다.

elements의 수를 예측할 수 없을때 사용하기 좋다.

# **Disadvantages**

균형있게 분배되지 않을 수 있다.

따라서 공간 낭비가 발생할 수 있음.

체인이 길어질 수록 시간 복잡도가 O(n)이 된다.