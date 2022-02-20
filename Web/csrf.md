# 정의
- Cross Site Request Forgery(교차 사이트 요청 위조)
- 사용자가 의도치 않은 요청을 서버로 보내는 것을 말한다.

# 예시
- 은행에 로그인을 했다.
- 로그아웃을 하지 않은 상태로 해커가 만들어준 링크를 클릭한다.
- 링크를 클릭하는 순간 사용자가 의도하지 않은 요청을 보낸다.

# 방지
## 원인
- 문제 발생 원인은 정상적인 사이트의 요청과 evil 사이트의 요청이 똑같은 형태를 가지기 때문이다.
- 서버측에서는 당연히 두 요청에 대해서 구분할 수 있는 방법이 없다.
- 그러므로 정상 사이트와 evil 사이트의 요청을 구분하기 위한 방법이 필요하다.
## Synchronizer Token Pattern
- 사용자에게 세션 쿠키를 부여할때 token을 함께 부여하는것이다.
- 사용자는 요청을 보낼때마다 서버에서 부여해준 token을 함께 보내야한다.
- evil 사이트는 랜덤하게 생성되는 csrf를 알지 못하기 때문에 악의적 요청을 코딩할수 없게된다. 

# 스프링 시큐리티
- 스프링 시큐리티에서는 CSRF 방지를 모든 요청에서 적용하길 추천한다. 
- 만약 browser를 사용하지 않는 서비스를 제공할 경우는 csrf방지를 disable 처리해도 된다 ( 사용자가 악의적 링크를 클릭할 우려가 없으므로 )
- 스프링 시큐리티에선 CSRF 방지 사용이 기본이다.

# 참고 사이트
[https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/csrf.html](https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/csrf.html)
