
# SecurityContextHolder
- `SecurityContextHolder`는 Spring Security의 핵심적인 class다. 
- `SecurityContextHolder`는 `SecurityContext`를 가지고 있는데, `SecurityContext`에 어떤 값이 들어있다면 해당 값은 인증된 것으로 간주한다.
- 아래 코드는 `SecurityContext`에 인증된 사용자 정보를 할당하고, `SecurityContextHolder`에 저장하는 모습을 보여준다. 
```java
SecurityContext context = SecurityContextHolder.createEmptyContext();
Authentication authentication =
    new TestingAuthenticationToken("username", "password", "ROLE_USER");
context.setAuthentication(authentication);

SecurityContextHolder.setContext(context);
```
- 인증된 사용자의 정보를 불러오기 위해선 아래와 같은 코드를 작성하면된다. 
- 기본적으로 `SecurityContextHolder`는 ThreadLocal을 사용하기 때문에 사용자를 불러오기 위한 특정한 key값을 사용할 필요가 없다. ( 사용자1:쓰레드1 )
```java
SecurityContext context = SecurityContextHolder.getContext();
Authentication authentication = context.getAuthentication();
String username = authentication.getName();
Object principal = authentication.getPrincipal();
Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
```

# SecurityContext
- `SecurityContext`는 `SecurityContextHolder`를 통해 접근이 가능하며, `SecurityContext`는 `Authentication` 오브젝트를 가진다.

# Authentication
- `Authentication`은 두가지의 목적을 가진 객체다.
1. `AuthenticationManager`에 대한 입력으로 사용된다. 입력을 통해서 사용자의 접근 자격에 대한 검증을 수행할 수 있다.
2. 현재 인증된 사용자를 나타낸다. ( `SecurityContext`를 통해 확인할 수 있음 )

- `Authentication`은 아래 3개에 대한 정보를 가지고 있다.
1. principal - 사용자를 식별한다. username/password 방식을 사용한다면 UserDetails의 인스턴스가 주로 사용될것이다.
2. credentials - 주로 비밀번호를 의미한다. 대부분의 경우 사용자 식별이 완료되면 credentials는 지워진다.
3. authorities - 역할과 스코프처럼 사용자에 대한 좀더 높은 레벨의 권한을 의미한다.

# GrantedAuthority
- TODO 작성중.



# 참고
[https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html#servlet-authentication-authenticationmanager](https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html#servlet-authentication-authenticationmanager)
