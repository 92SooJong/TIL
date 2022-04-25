# Javascript 개요
## 역사
- Brendan Eich에 의해 1995년에 만들어졌으며 1997년에 ECMA 표준이되었다.
- 모카 -> 라이브스크립트 -> 자바스크립트 -> ECMA스크립트
- 현재는 ECMAScript6가 작업중
## script 태그
- script 태그를 만나면 브라우저는 이를 스크립트 코드로 인식함.
- HTML5부터 태그에 type이나 language 속성을 지정할 필요가 없음
## 언어적 특징
- 컴파일이 아닌 인터프리터 방식
- 프로그램 작성 측면에서 보다 쉽고 빠르나, 컴파일 언어보다 제한된 능력과 실행 속도를 가짐
- 타입 체크가 느슨함.
- 너무 유연하기 때문에 예상치 못한 부작용 발생 가능성 높음
- 객체 지향보다는 객체 기반
- node.js처럼 점차 서버쪽으로 영역이 커지고 있음
## 스크립트의 위치
- 스크립트를 별도 파일로 분리하고 참조하는 방식이 일반적
- head태그에 작성된 코드가 먼저 실행되고 body 태그에 작성된 코드가 실행된다.
## 에러처리
- 인터프리터 방식이기 때문에 브라우저는 잘못된 스크립트 코드를 만나면 그냥 무시하고 리턴한다.
## 어휘 구조
- 문장 내의 공백과 탭은 무시한다.
- HTML과 달리 대소문자를 구분한다.
- 문장과 문장은 세미콜론으로 구분
- 스크립트 코드 내에서 HTML 주석은 사용하면 안된다.
## 출력
- 자바스크립트는 자체 출력 함수를 가지고 있지 않음
- 대신 내장 객체를 사용하여 출력을 할 수 있으며, 주로 `console.log()`를 많이 사용한다.
## 대화상자
- 실행을 블록 시키기 때문에 사용을 지양해야함. 
- `window.alert(message)`,`window.prompt(message)`,`window.confirm(message)`
## 엄격모드
- 자바스크립트의 유연한 문법 이면의 애매함에 의한 부작용을 막기 위해 도입(ES5)
- 스크립트 선두나 함수 선두에 `use strict`구문을 작성해서 사용
- 변수를 선언하지 않고 사용할 수 없음
- 일반 함수에서 this는 전역 객체가 아닌 undefined가 됨
# 변수
## 원시형
- `Numbers` 한 종류의 숫자 타입만 가짐
- `Strings` 연속된 문자들
- `Booleans` true or false
## 객체형
- `object` {}(curly brace)로 표현
- `function` 함수 자체도 데이터 타입
- `undefined` 값이 없는 변수
## 숫자
- 자바스크립트에서 숫자 타입은 항상 64비트 부동 소수점
- 52 비트의 상수, 11비트의 소수점, 1bit의 부호로 구성된다.
- 정수는 15자리까지 표현이 가능하다.
- 소수는 17자리까지 표현이 가능하나 항상 정확한건 아님
- `0x`로 시작하여 16진수 값을 표현 가능
## 문자열
- 연속된 문자들을 " 또는 '로 둘러싸서 표현 가능
## 논리형 
- true 혹은 false값을 표현함
- 자바스크림트에서 값이 없는 모든것은 false
    - 0(zero), -0(minus zero), ""(empty value),undefined,null,NaN
## 변수의 선언
- 자바스크립트에서는 변수 선언 시 타입을 지정하지 않음
- 필요한 변수들을 모두 스크립트 시작 부분에 선언하는 것이 올바른 습관임.
## 선업 없이 사용하기
- 인터프리터 방식이라는 특징 때문에 변수를 선언하지 않고 사용할 수 있음.
- 변수의 타입 또한 언제든지 바꿀수 있음.
## 변수의 범위
- scope는 접근할 수 있는 변수, 객체, 함수의 집합으로 자바스크립트는 function scope이다.
- 로컬 변수는 함수가 종료되면 소멸되며, 글로벌 변수는 페이지가 종료되면 소멸됨.
- global에 var 키워드를 사용하지 않으면 자동으로 전역 변수가 됨.(???)
## 상수
- const 키워드를 사용한다.
- 관습적으로 대문자 + underscore로 명명한다
## 특수한 값
- 자바스크립트는 특수한 상태를 표현하는 리터럴을 제공한다.
- `null` 변수가 선언되지 않은 상태
- `undefined` 변수가 선언되었지만 값이 초기화 되지 않은 상태 (예: `var x;`) 
- `Empty Values` 변수가 선언되었고 빈 값으로 초기화된 상태 (예:`var x ="";`)
- `Infinity(or -Infinity)` 무한대를 나타내는 상수로 숫자 타입임(예:`var x=2/0; var y=-2/0;`)
- `NaN(Not a Number)` 숫자로 표현할 수 없는 상수로 숫자 타입임(예:`var x=0/0; var y=0/"A";`)
## 암시적 변환
- 자바스크립트에서 서로 다른 데이터 타입의 값을 연산하면 실행 중에 자동으로 타입을 바꿔 적용함
- `"8" + "6" ==> "86"` , `"8" - "6" ==> 2`
## 명시적 변환
- 명시적으로 형 변환을 해야 하는 경우에는 타입 별로 정의된 내장 함수를 사용한다.
- `Number("82") + Number("75") ==> 157`
## 숫자를 문자열로 변환
- `String(320 + 160) ==> "480"`
## 논리형의 변환
- `Boolean("false") ==> false`
# 연산자
- 기본적으로 자바와 유사함. 특별한 연산자를 살펴본다.
## 대입 연산자
- `36 = 9 << 2;` 왼쪽으로 시프트, 오른쪽으로 0을 추가함
- `2 = 9 >> 2;` 오른쪽으로 시프트, 왼쪽의 비트가 사라짐
- `4 = 19 >>>2` 오른쪽으로 시프트, 왼쪽의 비트를 0으로 채움
## 증감 연산자
- 전위형은 값을 먼저 증가시키고 반환하며, 후휘형은 값을 먼저 반환하고 증가시킴.
## 비교 연산자
- 일반적으로 자바와 같으면 아래 동등 비교 연산자가 드라다.
- `==` 좌변과 우변의 값이 같다.
- `===` 좌변과 우변의 값과 타입이 같다.
## 논리 연산
- Short Circuit 기능을 제공함.
- 앞의 조건이 참인 경우에만 뒤의 조건을 평가.
## typeof
- 자바스크립트의 동적인 타입을 typeof 연산자를 통해 실쟁 중에 어떤 타입인지 검사할 수 있음.
# 제어문
- 일반적으로 자바와 같음
## 점프문
- break 문은 label과 함께 쓰면 다중 루프도 빠져나올 수 있음.
- `break endloop;   endloop:`
## 무한루프
- `for(;;)`처럼 for문의 조건을 생략하거나, `while(true)`를 통해 무한루프를 작성할 수 있다.
## 예외구문
- 자바처럼 `try ~ catch ~ finally` 구문을 사용함.
- 예외 발생시 catch 블록으로 exception 객체가 전달 됨.
# 함수
## 함수의 정의
- 함수는 특정 일을 수행하는 코드 블록에 이름을 붙여 정의한 객체
```javascript
// 선언 - 리턴 타입을 명시하지 않으나 필요하다면 본체에서 리턴 가능
function functioName(param1, param2,...){
    code to be excuted
}

// 호출,만약 함수 선언이 호출보다 뒤에 있더라도 hoisting에 의해 실행에 문제가 없다.
functionname(p1,p2);
```
- `hoisting`은 인터프리터가 자바스크립트 코드를 해석함에 있어서 Global 영역에 선언된 코드 블록을 최상위 Scope로 끌어올리는것을 말한다.
## 인수
- 함수의 인수는 자바와 달리 타입이 없다.
- 인수의 개수가 호출 구문과 일치하지 않아도 실행됨.
- 명시적인 인수 외에 묵시적인 arguments라는 인수의 배열이 자동으로 전달됨
## 인수 전달 방식
- 원시형 타입(Numbers,Strings,Booleans)는 값으로 전달(call by value)
- 객체는 참조로 전달 (call by reference)
## 리턴값
- 별도의 return문을 사용하지 않으면 undeifned가 반환 됨
## 내부함수
- 함수 안에 정의한 함수를 말하며, 중첩함수라고도 한다.
## 익명함수
- 함수를 선언한 후 사용하지 않고 표현식처럼 사용할 수 있다.(이름이 없는 함수)
```javascript
var add = function(a,b){
    return a + b;
};
add(2,3);
```
- 익명함수는 hoisting 되지 않는다. 명시적으로 선언을 가장 위에 써둬야함.
## 클로저
- 클로저는 지역 변수의 범위를 확장하는 자바스크립트의 기법
- 전역 변수가 필요하지만 이름 충돌 등의 이유로 지역 변수로 내려 사용하면서도 변수가 유지되게 하고 싶을 때 사용
```javascript
function outer(){
    var value = 1234;
    function inner(){
        document.write(value);
    }
    return inner;
}

var outin = outer();
outin(); // 1234
```
## 동적함수
- 동적함수는 실행 중에 본체가 정의된다.
```javascript
var body;
if(confirm("더할래,곱할래") == true){
    body = "return a +b;";
}else {
    body = "return a * b";
}

var add = new Function("a","b",body);
document.write("result = " + add(2,3) + "<br>");

```
## 내장 함수
- `parseInt(value),Number("0x1a")`와 같은 타입 변환 내장함수를 제공함.
- `isNan(value)`와 같은 상태점검 내장함수를 제공함
- `encodeURI(uri)`와 같은 인코딩 내장함수를 제공함
# 객체
## 객체의 선언
- 객체는 변수들을 담고 있는 변수이다.
- 원시 타입(strings,numbers 등)의 값을 제외하면 모든 값은 객체다.
```javascript
// 리터럴 방식 (권장)
var person = {
    firstName:"John",
    lastName:"Doe"
};
// new 연산자 방식
var person = new Object();
person.firstName ="John";
person.lastName = "Doe";
```
## 멤버의 참조
- .이나 [] 연산자로 참조 가능하다.
```javascript
//objectName.property;
person.age;
//objectName["property"];
person["age"];
```
## with
- 임시로 변수의 유효범위 체인을 변경하는데 사용되며 객체의 멤버를 참조하는 코드를 간결하게 할 수 있다.
- 다만 with는 코드가 모호해지고 성능이 떨어지기 때문에 엄격모드에서는 에러로 처리된다. (가능하면 사용을 자제하자)
```javascript
var person = {age:50};
var age = 30;
with(person){
    document.write(age); // age 판단하기 어려워짐
}
```
## 값과 참조
- 자바스크립트 원시 타입의 변수는 값으로 참조되는 반면 객체의 변수는 레퍼런스로 참조됨
- 자바스크립트 원시 타입은 immutable하고 객체는 mutable함
```javascript
var y = 1;
var x = y; // 값 참조

var person = {firstName:"John" , lastName:"Doe"};
var x = person // 레퍼런스
x.age = 10; // person도 함께 변경됨
```
## 메소드
- 자바스크립트 메소드는 객체에서 수행할 수 있는 동작을 지정하며 함수의 정의를 담고 있는 속성임
- 메소드는 함수가 객체 타입의 속성으로 담겨 있는 것임
```javascript
var person = {
    firstName:"John" , 
    lastName:"Doe",
    fullName:function() { return this.firstName +" " + this.lastName;}
};
person.fullName(); // 괄호를 생략하면 단순 메소드의 정보를 보여줌
```
## 동적 속성 편집
- 객체의 멤버는 실행 중에 마음대로 추가,삭제할 수 있다.
```javascript
var person = {
    firstName:"John" , 
    lastName:"Doe"
};
delete person.lastName;
```
## 클래스
- 생성자 방식은 다른 언어들의 클래스와 기능적으로 유사
- 생성되는 객체별로 복사본을 갇도록 하기위해 this를 사용
```javascript
function person(first, last,age,eyecolr){
    this.first = first;
    this.last = last;
    this.age = age;
    this.eyecolor = eyecolor;
}
var myFather = new person("John","Doe",50,"blue");
var myMother = new person("Sally","Rally",48,"green");
```
## 프로토타입
- 프로토타입은 생성자를 통해 생성된 객체들 사이에 공유되는 영역
```javascript
function person(first, last,age,eyecolr){
    this.first = first;
    this.last = last;
    this.age = age;
    this.eyecolor = eyecolor;
}
// person의 모든 인스턴스가 name이라는 function을 가지게된다
person.prototype.name = function(){
    return this.first + " " + this.last;
}
```
## instanceof 연산자
- instanceof 연산자는 객체가 특정 생성자로 만들어진건지 체크
- 상위 클래스도 체크하기 때문에 최상위 객체인 Object로 체크하면 항상 참이 나옴
```javascript
function Person(name){
    this.name = name;
}
function Car(model){
    this.model = model;
}
var p = new Person("John Doe");
var c = new Car("50");

if(c instanceof Person) document.write(c); // 거짓
```
## this
- java와 유사함. 실행 문맥에 따라 의미가 달라짐
- 메소드 내부의 this는 해당 메소드를 호출한 부모 객체를 참조
- 생성자 함수 코드 내부의 this는 새로 생성된 객체를 참조
## call(),apply()
- 문맥에 따라 변하는 this를 내가 원하는 객체로 바꾸기 위해 사용한다.
- call()은 각각 하나의 인자로 넘기고, apply()는 배열 형태로 인자를 넘김
# 원시객체
## Object
- 자바스크립트 최상위 객체로 모든 객체는 Object의 속성을 사용 가능
- `var x = {};`와 같이 리터럴 방식 사용 권장
- `constructor,toString(),valueOf()`등이 있음
## Number
- Number 객체는 원시 타입의 숫자 형을 표현하는 자바스크립트 내장 객체
- `var x = new Number()` 보단 `var x = 0;`을 권장
- `MAX_VALUE,toFixed(x)`등이 있음
## String 
- String 객체는 원시 타입의 문자형을 표현하는 자바스크립트 내장 객체
- `var x = new String()`대신 `var x =""`을 권장
- `"koread".length` 등이 있음
## Boolean
- Boolean 객체는 원시 타입의 논리형을 표현하는 자바스크립트 내장 객체
- `var x = new Boolean();`대신 `var x = false;`를 권장
- Object로 상속 받은 속성 외에 별도의 멤버가 없음
## 래퍼 객체
- 자바스크립트는 원시 데이터 타입에 대응되는 내장 객체들을 제공하지만 가급적 객체 형태 보다는 원시 데이터 타입을 권장한다.
```javascript
var a = new String("korea");
var b = "korea";
// a == b => true
// a === b => false
// typeof(a) == typeof(b) => false
// a.constructor == b.constructor => true
```
## 속성 설명자
- Object.defineProperty() 내장 함수는 객체에 속성을 다양한 옵션으로 정의할 수 있는 방법을 제공한다.
```javascript
var person = {
    name : "John Doe",
    eyeColor : "blue"
};
// 속성 설명자
Object.defineProperty(person,"age",{
    value :50,
    enumerable :false, // for in 문으로 열거 가능 여부
    writable :false // 값 변경가능 여부
})
```
## 액세서
- java의 getter와 setter의 역할을 한다고 보면된다.
```javascript
var person = {
    name : "John Doe",
    age : 50
};

Object.defineProperty(person,"age",{
    enumerable :true, // for in 문으로 열거 가능 여부
    get : function{return age;} // 액세서
    set : function(value){ // 액세서
        if(value > -1) { age = value;} 
    }
})
```
## 객체 생성
- 객체를 리터럴로 생성하는 경우에는 속성의 이름과 값만 지정 가능하기 떄문에 속성의 옵션까지 적용하려면 Object.create() 내장 함수를 사용해야 함
- Object.create()를 통해 상속을 구현할 수도 있음
```javascript
// 문법 Object.create(원본객체, 설명자 집합)
var person = Object.create({},{
    name :{
        value : "John Doe"
    }
});

var staff = Object.create(person,{
    salary:{
        value : 680
    }
});
```
## 캡슐화
- 속성의 추가나 삭제를 금지 또는 허용
- `preventExtensions()`를 통해 필드 추가를 방지
- `freeze()`를 통해 필드 삭제나 추가를 하지 못하도록 함
# 배열
- 배열도 자바스크립트의 내장 객체 중 하나
## 배열의 선언
- 생성자 방식
```javascript
Array(n);
```
- 리터럴 방식
```javascript
var ar = [1,2,3,4,5];
```
## 배열의 특성
- 다른 언어의 배열에 비해 독특한 특징들이 있음
- 배열의 크기는 가변적이며 실행 중에 필요한 만큼 늘어남
- 배열의 인덱스가 꼭 연속적일 필요는 없음
- 문자열의 length와 달리 배열의 length 속성은 직접 변경 가능
- 배열의 인덱스가 반드시 정수를 사용하지 않아도 됨
## 배열의 순회
- 배열의 동적 특성 때문에 `for(var 변수 in 배열){}` 순회가 더 안전하다
## 배열의 배열
- 다른 언어처럼 다차원 배열이 가능함
## 유사배열
- 배열은 객체인데 역으로 객체를 배열과 유사하게 사용하는 경우도 있음
- 이 경우 length 속성을 추가한다 하더라도 배열처럼 자동으로 관리되지 않음
## Array 메소드
- `indexOf(item,start)`나 `push(a)`같은 내장 메소드 사용이 가능함
## 추가 및 삭제
- `push`와 `pop` (stack처럼 동작)
- `unshift`와 `shift` (queue처럼 동작)
- `splice(index,cnt,item1,...)`는 특정 위치에서 원하는 개수만큼 요소를 추가 및 제거
## 분리 및 합침
- `slice(start,end)`는 배열의 일부를 복사해 새 배열을 만듦
- `concat(arr)`은 배열을 합쳐 하나로 만듦
## 정렬
- `sort(comparefn)`는 배열의 요소를 크기 순으로 정렬하며 comparefn을 지정하지 않으면 사전순으로 비교하여 요소의 길이가 고려되지 않음
- `reverse()`는 배열의 순서를 반대로 바꿈
## 순회 메소드
- `forEach(callbackfn)` 메소드는 배열을 순회하면서 요소의 값을 반환
- `map(callbackfn)` 메소드는 배열을 순회하면서 원본 배열의 요소를 받아 새로운 배열을 만들어 반환
# 내장객체
## String 내장객체
- 문자열 조작과 관련된 각종 기능들을 제공한다.
- `charAt(index), replace(searchValue,newValue)`등이 있다.
### 변경
- `toUpperCase(), toLowerCase(),trim()`이 있다.
### 추출
- `substring(start,end) , substr(start,length),slice(start,end)`등이 있다
## 코어객체
- `Math`,`Date`,`RegExp`,`JSON`,`Audio` 등이있다.
# BOM
- Browser Object Model의 약자
- 언어 자체적으로 제공하는 내장 객체와 달리 브라우저 별로 약간씩 상이하기 떄문에 고수준 라이브러리를 많이 사용한다
## Window
- BOM의 최상위 객체는 `Window`이다.
- 브라우저 실행과 동시에 생성된다.
- 주요 속성으로 `name`,`status`등이 있다.
- 주요 메소드로 `closed()`,`focus()`등이 있다.
- Window를 포함하는 몇가지 객체가 있다.
    - `history` 객체는 방문한 URL 목록을 저장하고 관리함
    - `location` 객체는 현재 방문중인 페이지의 URL의 속성들을 가지고 있음
    - `screen` 객체는 사용자의 화면에 대한 정보를 제공함
    - `navigator` 객체는 브라우저와 운영체제에 대한 정보를 제공함
# DOM
- Document Object Model의 약자
- DOM은 HTML 문서를 읽고 조작하는 객체의 집합
- BOM과 마찬가지로 자바스크립트 관점에서 Built-in Object가 아닌 Host Object
## 찾기
- `document.getElementById(id);`와 같은 문법 사용
## 읽기, 쓰기
- `innerHTML,innerText`와 같은 문법 사용
## 노드 추가
- `appendChild(node)`와 같은 문법 사용
## 속성 추가
- `setAttribute(name,value)`와 같은 문법 사용
## 삭제
- `removeChild(node)`와 같은 문법 사용
# 이벤트 모델
- `load`,`unload` 페이지 시작 및 종료
- `click`,`mousedown`등과 같은 다양한 이벤트 핸들러가 있다.
## 기본 모델과 인라인 모델
- 기본모델의 경우 `getElementById()`를 통해 노드를 가져와서 노드의 `onclick`에 이벤트 처리 function을 부여하는 방식
- 인라인 모델은 노드의 속성인 onclick에 바로 function 명을 작성하는 방식
## 리스너 등록
- DOM 레벨 2에서 도입된 방식으로 가장 널리 쓰임.
- `addEventListener(type,listener,useCapture)` 문법을 사용
- 예) `header.addEventListener('click',headerClick2);`
## 이벤트 인수
- 이벤트 발생 시 핸들러의 첫 번째 인수로 event 객체가 전달되고, 객체 안에는 추가 정보가 담겨있음(this도 함께 전달됨)
## 이벤트 호출
- 이벤트도 함수이므로 이벤트가 사용자에 의해 발생되지 않아도 직접 호출이 가능함
## 이벤트 무시
- 핸들러에서 false를 반환하면 이벤트가 무시됨 
## 이벤트 버블링
- 여러 객체에 동시에 발생한 이벤트 처리를 위해 버블링과 캡처링을 사용함
- `버블링` 자식이 이벤트를 먼저 받고 이어서 부모가 이벤트를 받음(말단에서 body로)
- `캡쳐링` 부모가 이벤트를 먼저 받고 아래쪽 자식으로 전파됨(body에서 말단으로)
- addEventListener(type,listener,useCapture)의 세번째 인자로 제어하거나, stopPropagation()으로 이벤트 전파 차단 가능
## load
- HTML 문서가 로드를 완료 했을때 발생
## resize
- 브라우저의 크기가 변할 때 마다 발생
## 마우스 이벤트
- 마우스 이벤트는 엘리먼트 위에서 마우스를 조작할 때 발생
# AJAX
- AJAX(Asynchronous JavaScript and XML)은 화면 전환 없이 서버와 통신할 수 있도록 하기 위해 기존 기술을 조합한 새로운 웹 개발 접근 방식
