# Generic

제네릭의 기본인 1.1~1.3은 생략함

# 1.4 제한된 지네릭 클래스

다음과 같이 작성하면 Fruit의 자손타입만 T에 대입할 수 있다. (= Fruit를 implements 또는 extends한 클래스만 T에 대입할 수 있다.) 좀 더 엄격하게 FruitBox에 들어올 수 있는 타입을 관리할 수 있다.

```java
class FruitBox<T extends Fruit>{
	ArrayList<T> list = new ArrayList<T>();
	...
}
```

Fruit의 자손 인스턴스는 얼마든지 담을 수 있다. 다형성을 이용해 여러 과일을 담을 수 있게 되었다.

```java
FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
fruitBox.add(new Apple()); // Apple이 Fruit의 자손
fruitBox.add(new Grape()); // Grape는 Fruit의 자손
```

클래스가 아닌 인터페이스를 구현해야하는 경우 아래와 같이 작성하면 된다. 주의할 점은 implements 키워드 대신에 extends를 사용한다는 점이다.

```java
interface Eatable {}
class FruitBox<T extends Eatable> {...}
```

Fruit의 자손이면서 Eatable 인터페이스도 구현해야 하는 경우 아래와 같이 작성한다. 

```java
class Fruit<T extends Fruit & Eatable> {...}
```

FruitBox에는 Fruit의 자손이면서 Eatable을 구현한 클래스만 타입 매개변수 T에 대입될 수 있다.

```java
import java.util.ArrayList;

interface Eatable { }

class Fruit implements Eatable{
    public String toString(){ return "Fruit";}
}

class Apple extends Fruit { public String toString() { return "Apple";}}
class Grape extends Fruit { public String toString() { return "Grape";}}
class Toy { public String toString() { return "Toy";}}

public class App {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();
        //FruitBox<Grape> grapeBox = new FruitBox<Apple>();//에러. 타입불일치
        //FruitBox<Toy> toyBox = new FruitBox<Toy>(); //에러. 제네릭을 지원하지 않음.

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        //appleBox.add(new Grape()); // 에러. Grape는 Apple의 자손이 아니다.
        grapeBox.add(new Grape());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);

    }

}

class Box<T>{
    ArrayList<T> list = new ArrayList<T>();
    void add(T item){ list.add(item);}
    T get(int i){return list.get(i);}
    int size(){return list.size();}
    public String toString(){return list.toString();}
}

class FruitBox<T extends Fruit & Eatable> extends Box<T>{
}
```

# 1.5 와일드 카드

FruitBox의 내용물을 통해 Juice 인스턴스를 반환하는 Juicer 클래스의 스태틱 메소드.

여기서 makeJuice의 파라미터인 FruitBox의 타입 매개변수가 `Fruit` 임에 주목한다.

```java
class Juicer{
	static Juice makeJuice(FruitBox<Fruit> box){
		String tmp = "";
		for(Fruit f : box.getList()) tmp += f + " ";
		return new Juice(tmp);
	}
}
```

static 메소드는 타입 매개변수를 사용할 수 없으므로 아예 지네릭스를 적용하지 않던지 위처럼 특정 타입 매개변수를 지정해 줘야한다.

```java
FruitBox<Fruit> fruitBox = new FruitBox<>();
FruitBox<Apple> appleBox = new FruitBox<>();
...

System.out.println(Juicer.makeJuice(fruitBox));
System.out.println(Juicer.makeJuice(appleBox)); // 에러.

```

이 문제를 해결하기 위한 가장 단순한 방법은 makeJuice를 매개변수 타입별로 여러개 만드는 것이지만, 자바 컴파일에선 지네릭 타입이 다른 것만으로 오버로딩이 성립하지 않는다고 인식하기 때문에 에러가 발생한다. 즉, 오버로딩이 아닌 메소드 중복이 발생한다. 이 문제를 해결하기 위해 고안된 것이 `와일드 카드`이다.

와일드 카드는 아래의 문법을 따른다.

`<? extends T>` 는 와일드 카드의 상한 제한. T와 그 자손들만 가능하다.

`<? super T>` 는 와일드 카드의 하한 제한. T와 그 조상들만 가능하다.

`<?>`는 제한없음. 모든 타입이 가능. `<? extends Object>`와 동일하게 동작한다.

와일드 카드를 사용해 makeJuice()의 매개변수 타입을 변경해보자.

```java
class Juicer{
	// FruitBox에는 타입 매개변수로 Fruit와 그 자손들만 올 수 있다.
	static Juice makeJuice(FruitBox<? extends Fruit> box){
		String tmp = "";
		for(Fruit f : box.getList()) tmp += f + " ";
		return new Juice(tmp);
	}
}
```