# 등장
- Representational State Transfer의 약자이며 HTTP 설계의 우수성을 극대화 하고자 2000년도에 등장. (로이필딩의 논문)

# 구성
- HTTP Mehtod를 통해 수행할 동작을 정의한다. ( 대표적으로 POST가 생성, PUT이 수정, GET이 조회 )
- URI를 통해 필요한 자원을 표현한다.

# 특징
## Stateless
- 상태를 별도로 저장하지 않도록한다. REST API는 단순히 요청만 처리하고 끝이다.

## Cacheable
- HTTP를 그대로 따르기 때문에 당연히 HTTP의 캐싱 기능도 그대로 사용이 가능하다.

## Self-descriptiveness 
- REST API의 메시지만 보고도 충분히 이해가 가능하다.

## Client-Server 구조
- REST 서버는 API만을 제공하고, Client에서 세션이나 로그인정보를 관리하면서 서로간의 의존성을 줄인다. 

## 계층구조
REST 서버는 Client서버와 구분되어 있기 때문에 요청에 대해 PROXY, 게이트웨이 같은 네트워크 기반의 중간매체 또는 로드 밸런싱, 암호화 계층을 추가할 수도 있다.


# 참고
[https://meetup.toast.com/posts/92](https://meetup.toast.com/posts/92)
