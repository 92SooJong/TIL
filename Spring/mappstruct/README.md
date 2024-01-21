# Spring에서 Mapstruct 의존성 추가시 주의사항

Lombok mapstuct를 사용한 매핑시에 lombok 어노테이션을 적용하고 싶다면, `org.projectlombok:lombok-mapstruct-binding` 의존성을 추가로 지정해줘야 한다.

![Alt text](image.png)

# Mapping을 위한 최소한 세팅

Source 객체에는 Getter 메소드만 있으면 된다. 

Target 객체에는 전체 필드 생성자 또는 Builder, Setter와 같이 값 세팅을 위한 메소드가 있어야한다.