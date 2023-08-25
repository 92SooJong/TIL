# Complexity and Load Factor

HashMap의 Insert 작업은 Key-Value가 나눠져서 진행된다. 

먼저, Hash Function을 통해서 Key를 양의 정수 형태로 변환한다. 여기서 시간은 Key의 원본 데이터의 사이즈에 따라 달라지게 되는데 사실상 무시할 수 있는 수준이라 시간 복잡도는 O(1)이 된다.

두번째로, Key를 통해 index를 선정했다면 Linked List에 Value를 붙여야 하는데 최악의 경우 모든 노드가 하나의 인덱스에 들어있다면 n번의 탐색을 해야한다. (Linked List는 인덱스를 가지지 않으므로 마지막 위치를 알기위해선 끝까지 탐색을 해야한다.) 이 경우에 O(n)까지 시간 복잡도가 높아지게 된다. 

하지만 대부분의 Hash Function은 Hash Map에 적절하게 노드가 분배되도록 설계되었기 때문에 O(n)까지 가는 경우는 없고 대부분 O(1)에 수렴한다. 

load factor는 전체 노드의 개수를 Capacity로 나눈 값으로 구할 수 있다.

load factor = 전체 노드 개수/Capacity

전체 노드 개수가 6개이고 Capacity가 3이라면 각 Bucket에는 2개의 노드가 존재하게된다.(load factor가 2)

load factor를 낮게 유지하는게 Hashing 성능의 핵심이다. 

# Rehashing

이름 그대로 Hashing을 다시 하는것이다.

load factor가 설정한 임계치 값 보다 커지게 되었을 때(자바 기준 0.75) Capacity를 2배로 늘리게되는데 이때 기존에 존재하는 Node를 재분배하는 작업을 하게되는데 이를 Rehashing이라 한다.

Rehashing을 하는 이유는? 성능때문이다. 노드를 적절하게 분배함으로써 시간 복잡도를 O(1)이 되도록한다.

# Sample Source Code

```java

import java.util.ArrayList;

public class RehashingSampleMap<K,V> {

    // HashMap에서 사용할 Node의 구조를 정의한다
    class Node<K, V> {

        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    ArrayList<Node<K, V>> buckets;
    int size; // 전체 Node의 개수
    int numBuckets; // 버킷의 개수

    final double DEFAULT_LOAD_FACTOR = 0.75;

    public RehashingSampleMap() {

        numBuckets = 5; //Initial Bucket Number is 5

        buckets = new ArrayList<>(numBuckets);

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
        System.out.println("HashMap created");
        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + numBuckets);
        System.out.println("Default Load Factor : " + DEFAULT_LOAD_FACTOR + "\n");
    }

    private int getBucketIndex(K key) {

        // Using the inbuilt function from the object class
        int hashCode = key.hashCode();

        // array index = hashCode%numBuckets
        return (hashCode % numBuckets);
    }

    public void insert(K key, V value) {
        // key와 매칭된 bucket의 인덱스
        int bucketIndex = getBucketIndex(key);

        // bucket을 가져온다. 이 뜻은 각 버켓의 Head Node를 가져온다는 뜻!!
        Node<K, V> head = buckets.get(bucketIndex);

        // bucket내에 이미 존재하고 있는 key인지 검사하고 존재한다면 value를 덮어쓰기 하고 종료
        while (head != null) {

            // If already present the value is updated
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // 새로운 노드를 만든다
        Node<K, V> newElementNode = new Node<>(key, value);

        // 새로운 노드를 넣을 bucket을 가져온다
        head = buckets.get(bucketIndex);

        // 새로 들어온 Node의 next를 첫번째 Node로 한다
        // 원형 Linked List 구조!
        newElementNode.next = head;
        // 새로 들어온 element가 Head가 될 수 있도록 한다
        buckets.set(bucketIndex, newElementNode);

        System.out.println("Pair(" + key + ", " + value + ") inserted successfully.\n");

        // 전체 Node 개수를 1 증가 시킨다
        size++;

        // load factor를 재계산 한다.
        double loadFactor = (1.0 * size) / numBuckets;

        System.out.println("Current Load factor = " + loadFactor);

        // If the load factor is > 0.75, rehashing is done
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            System.out.println(loadFactor + " is greater than " + DEFAULT_LOAD_FACTOR);
            System.out.println("Therefore Rehashing will be done.\n");

            // Rehash
            rehash();

            System.out.println("New Size of Map: " + numBuckets + "\n");
        }

        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + numBuckets + "\n");
    }

    private void rehash() {

        System.out.println("\n***Rehashing Started***\n");

        // The present bucket list is made temp
        ArrayList<Node<K, V> > temp = buckets;

        // New bucketList of double the old size is created
        buckets = new ArrayList<>(2 * numBuckets);

        for (int i = 0; i < 2 * numBuckets; i++) {
            // Initialised to null
            buckets.add(null);
        }
        // Now size is made zero
        // and we loop through all the nodes in the original bucket list(temp)
        // and insert it into the new list
        size = 0;
        numBuckets *= 2;

        // insert 작업을 다시 수행한다!!!!
        for (int i = 0; i < temp.size(); i++) {

            // head of the chain at that index
            Node<K, V> head = temp.get(i);

            while (head != null) {
                K key = head.key;
                V val = head.value;

                // calling the insert function for each node in temp
                // as the new list is now the bucketArray
                insert(key, val);
                head = head.next;
            }
        }

        System.out.println("\n***Rehashing Ended***\n");
    }

    public void printMap() {

        // The present bucket list is made temp
        ArrayList<Node<K, V> > temp = buckets;

        System.out.println("Current HashMap:");
        // loop through all the nodes and print them
        for (int i = 0; i < temp.size(); i++) {

            // head of the chain at that index
            Node<K, V> head = temp.get(i);

            while (head != null) {
                System.out.println("key = " + head.key + ", val = " + head.value);

                head = head.next;
            }
        }
        System.out.println();
    }

    //Function to get an element from Map
    public V getValue(K key){
        //Get actual index of the key
        int actualIndex = getBucketIndex(key);
        Node<K,V> temp = buckets.get(actualIndex);
        //Search for key in list
        while(temp != null){
            if(temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }




}


```