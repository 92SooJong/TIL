_자바 어노테이션에대해 설명한 내용을 번역합니다. 출처 : [https://dzone.com/articles/how-annotations-work-java](https://dzone.com/articles/how-annotations-work-java)_

어노테이션은 자바에서 중요한 부분입니다. 자바 어노테이션은 J2SE 5.0에서 처음 등장했습니다. 우리가 흔히 마주하는 어노테이션으론 @Override나 @Deprecated같은 것들이 있습니다.

# 어노테이션이란 무엇인가?
어노테이션은 메타데이터다. 메타데이터는 데이터에 대한 데이터다.( 특정 데이터 집합을 설명하는 데이터라고 이해하면 쉽다. ) 자바의 어노테이션은 코드를 위한 메타데이터다. 아래의 코드를 보자.  
    @Override
public String toString() {
return "This is String Representation of current object.";
}

