[참고 문서 - JJWT](https://github.com/jwtk/jjwt?tab=readme-ov-file#what-is-a-json-web-token)


# JSON Web Token 이란?
JSON Web Token을 줄여서 JWT라고 부름.

특정 정보를 축약 및 보완된 형태로 전달하기 위한 메시징 포맷
- 즉, 암호화 및 축약된 데이터
- 다양한 목적으로 사용됨 (general-purpose)
- JWT는 텍스트로 이뤄져 있음. (text-based)

흔히들 착각하는게 JWT가 데이터의 식별(identity)을 위해서만 사용한다는 점이다. JWT는 단지 메시지 포맷의 일종이기 때문에 어떤 상황에서든 사용할 수 있다.

# JWT의 구성
가장 간단한 형태의 JWT는 2개의 파트로 나눌수 있다.

JWT에 주요 데이터가 존재하는 파트를 `payload`라고 한다.

`payload`를 설명하는 name/value 기반의 메타데이터 부분이 있는데 이를 `header`라고 한다. (JSON 형태로 작성된다)

`payload`에는 모든 형태의 데이터가 다 들어갈 수 있다. (String, images, documents, etc.)

앞서 말했듯이 `header`는 JSON 타입이다. 그리고 `payload`도 JSON 타입이 될 수 있다. 

`playload`가 어떤 인증을 위해서 JSON 형태로 사용되고 있다면 `payload`를 `Claims`라고 부른다. 그리고 각 name/value를 `Claim`이라고 한다.

# JWT의 장점
JWT는 다양한 방법의 암호화 기법을 적용할 수 있다.

JWT에 암호화를 적용하지 않은 것을 `unprotected JWT`라 부른다.

JWT는 사람이 읽을 수 있는 형태로 작성된다. (실사용시에는 데이터 사이즈를 줄이기 위해서 Base64URL을 통해 인코딩을 한번 한다.)

# JWS (JSON Web Signature)
JWS는 signed JWT를 의미한다.

JWT에 서명을 하는 기법을 의미한다.

JWT 서명을 위한 표준 `Claims`들이 있으니 가능하면 이를 따라서 `Claims`를 구성하도록 하자. 


# JWE (JSON Web Encryption)
JWT, JWS가 적용된 데이터는 암호화가 되어있지 않기 때문에 정보가 노출될 위험이 있다. 

JWT, JWS는 단지 데이터 축소와 서명을 위한 알고리즘만 적용한것임! 어떤 암호를 부여하지 않았음!!
- JWS는 `데이터가 변조되지 않았다`라는 것만 알 수 있음.

이를 위해 등장한 것이 `JSON Web Encryption`이고 줄여서 JWE라고 부른다.
