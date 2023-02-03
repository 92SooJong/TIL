---
title: "OAuth 2.0"
date: 2023-01-04T20:00:00+09:00
tags: ["OAuth","Korean"]
---

# 사전지식
## Authentication vs Authorization
- OAuth 2.0은 Authorization(인가)를 위해 만들어졌다.(Authentication을 위해 만들어 진게 아님!)
## Delegated authorization
- Delegated authorization은 누군가에 의해 관리되고 있는 시스템의 데이터로 접근가능하도록 application에 permission을 주는것이다.
- 사용자의 Credential을 얻지 않은채 Delegated authorization를 하는건 불가능하다.

# What is OAuth
- Open Authorization의 약자이다.
- 토큰 기반의 인증,인가 방식이다.
- 엔드 user의 계정을 써드파티 서비스가 사용할 수 있도록 해준다. facebook의 아이디와 비밀번호를 모르더라도 facebook에 접근이 가능하다!
- OAuth 1.0은 Deprecated이며 현재는 OAuth 2.0이 사용된다
# OAuth 2.0 Terminology
## Resource Owner
- application이 얻으려고 하는 `데이터의 소유자`를 의미한다
## Client
- application을 의미한다
## Authorization server
- permission을 부여하거나 조회할때 사용되는 서버를 의미한다
## Resource server
- 물리 데이터를 저장하고 있는 서버를 의미한다
## Authorization grant
- `Authorization grant를 가졌다`는 데이터에 접근할 권한을 가졌다와 같은 뜻이다.
## Redirect Uri
- permission을 부여받았을때 사용자가 redirect될 경로를 의미한다
## Access token
- Resource server의 데이터에 접근하기 위한 key를 의미한다
## Scope
- Scope에 따라 application이 얻을 수 있는 사용자 데이터의 수준을 달리 할수 있다.
- Permission의 level을 설정한다고 생각하면 됨!

# Flow
- Resource Owner 위치가 잘못됐다?!
![](/images/etc/2023-01/2023-01-04-19-53-54.png)

# More OAuth 2.0 Terminology
- 위 그림에서 access token을 바로 얻는게 아니라 code를 통해서 access token을 얻는걸 볼 수 있다. (인가서버에 code를 보내서 access token을 얻는다)
- 이 이유를 이해하기 위해선 아래 2개 용어를 알고 있어야한다.
## Back channel
- 서버간 통신을 위해 강력한 보안이 적용되어 있는 채널이다
## Front channel
- browser/mobile app이 서버로 접속하기 위해 느슨한 보안이 적용되어 있는 채널이다.

인가 서버로 code를 보내서 access token을 얻고, Resource server에서 resource를 얻을땐 access token을 사용한다
![](/images/etc/2023-01/2023-01-04-20-10-03.png)

# 링크
[What the hell is OAuth?
](https://medium.com/@wdevon99/what-the-hell-is-oauth-6ba19f236612)