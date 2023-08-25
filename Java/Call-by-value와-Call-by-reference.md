# 정의
- Call by value(값에 의한 호출)는 인자로 받은 값을 복사하여 처리를 한다. 
    - 안전한 방법이며, 메모리 사용량은 Call by reference보다 많다.
- Call by reference(참조에 의한 호출)는 인자로 받은 값의 주소를 참조하여 직접 값에 영향을 준다. 
    - 직접 참조하기때문에 속도, 메모리면에서 Call by value에 비해 이점이 있으나, 값 변경의 위험이 있다.
- 간단히 말해 값을 복사를 하여 처리를 하느냐, 아니면 직접 참조를 하느냐 차이인 것이다.


# 예제코드

```java
package com.company;

public class Main {

    private static class User{
        String name;
        public User(String name){this.name = name;};

        public void setName(String name) {this.name = name;}
        public String getName() {return name;}
    }

    public static void main(String[] args){

        // call by value
        int n = 10;
        func(n);
        System.out.println("func(n) = " + n);

        // call by reference
        // 자바에서는 주소를 가져올 방법이 없기때문에 call by reference가 불가능하다.

        // 객체 프로퍼티 접근
        User sampleUser = new User("soojong");
        
        // call by reference처럼 동작하나 사실 주소"값"을 복사해서 넘기는것이다.
        // 즉, 주소값 자체를 넘기는 call by reference와는 다르다.
        foo(sampleUser);
        System.out.println("sampleUser = " + sampleUser.getName());

    }

    static void func(int n) {
        n = 20;
    }

    public static void foo(User user){
        user.setName("Joey");
        
    }
    
}
```
