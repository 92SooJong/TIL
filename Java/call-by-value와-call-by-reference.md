java의 call by value와 call by reference(처럼보이는)를 예제코드를 통해 살펴본다.

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
