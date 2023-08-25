# Map

Simple view of Java’s data strcutrue class hierachy

![Untitled](/images/cs/2022-11/hash2.png)

# Terminology

**Node**: Key-Value 형태의 데이터와 연결되어 있는 다음 노드를 가르키는 데이터 구조를 의미한다

**Bucket**: Linked List로 이뤄진 Node의 집합

**Capacity** : Bucket의 수를 의미한다.

![Untitled](/images/cs/2022-11/hash1.png)

# Initial Capacity

Capacity는 Bucket의 수를 의미한다.

초기 Bucket의 수는 15개이다. (2^4)

좋은 HashMap 알고리즘은 element가 균일하게 HashMap에 분배되어 있도록 한다.

16개의 element가 있을때 각 bucket은 1개의 노드만 가지는 Linked List로 구성된다. 따라서 노드를 검색할때 bucket내에서 1회만에 element를 찾을 수 있다.

32개의 element가 있을때 각 bucket은 2개의 노드를 가지는 Linked List로 구성된다. 따라서 노드를 검색할 때 bucket 내에서 최대 2회의 찾기 작업이 수행된다.

64개의 element가 있는 경우 최대 4회의 찾기 작업이 수행된다. 10,00,000개의 element가 있는 경우 최대 62,500회의 찾기 작업이 수행된다. 

여기서 알 수 있듯이 Capacity가 element의 수에 비해 작다면 찾기 속도가 느려진다. 따라서 적절한 타이밍에 Capacity를 늘려줘야한다. 여기서 적절한 타이밍을  찾을 수 있도록 해주는 값이 Load Factor이다. 

# Load Factor

Load Factor는 Capacity 사이즈에 대한  임계값(Threshold)이다. 초기 Capacity에 있는 element의 비율이 늘어나서 Load Factor를 넘어가면 Capacity의 사이즈를 늘린다.

이 작업을 통해 HashMap은 시간 복잡도를 상수인 O(1)으로 유지할 수 있다. 자바에서 Load factor의 기본값은 0.75f이다.

Capacity가 16일때 element가 13개면 13/16에 의해 0.8125의 비율을 가진다. 이때 Load factor의 기본값인 0.75보다 크므로 Capacity의 사이즈를 기존 사이즈의 2배인 32로 늘린다.

# Link

[Load Factor in HashMap in Java with Examples - GeeksforGeeks](https://www.geeksforgeeks.org/load-factor-in-hashmap-in-java-with-examples/)