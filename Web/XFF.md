---
title: "Web : X-Forwarded-For(XFF)"
date: 2023-01-29T14:17:00+09:00
tags: ["Web","Korean"]
---

# 정리
The "X-Forwarded-For" (XFF) attribute is an HTTP header field that is used to identify the originating IP address of a client connecting to a web server through an HTTP proxy or a load balancer. The XFF header is used to prevent IP spoofing and other types of IP address-based attacks.

When a client connects to an HTTP proxy or load balancer, the proxy or load balancer adds the client's IP address to the XFF header of the incoming request. The value of the XFF header is a comma-separated list of IP addresses, with the most recent IP address (the client's IP address) listed first.

For example, if a client with IP address 1.2.3.4 connects to an HTTP proxy with IP address 5.6.7.8, the XFF header of the incoming request would be:

```
X-Forwarded-For: 1.2.3.4, 5.6.7.8
```

The web server can then use the XFF header to determine the client's IP address, even if the client is connecting to the web server through an HTTP proxy or load balancer.

It's important to note that the XFF header can be easily spoofed. Therefore, it should not be used as a sole means of determining a user's IP address. It should be used in conjunction with other security measures, such as IP address white-listing, to mitigate IP spoofing and other types of IP address-based attacks.

# 요약
- HTTP 프록시나 로드 밸런서를 통해서 들어오는 요청의 오리지널 IP 주소를 찾는데 주로 사용된다.
- XFF 헤더는 IP 스푸핑 또는 그외 IP 기반의 보안 공격을 예방하는데 사용된다.
- 클라이언트가 HTTP Proxy나 로드 밸런서에 연결을 했을때, 프록시 또는 로드 밸런서로 들어오는 request의 요청에 클라이언트의 IP 주소를 XFF 헤드 필드에 세팅한다
- XFF 헤더에 있는 IP 주소 목록은 콤마(,)로 구분한다. 클라이언트의 IP 주소가 리스트의 첫번째에 위치하게 된다.()
- 서버는 XFF 헤더를 확인함으로써 클라이언트의 IP를 알 수 있다.
- XFF는 IP 스푸핑을 당할 수 있기 떄문에 사용자의 IP를 확인하는 유일한 수단으로 사용하진 말자. 가능하면 IP 주소 화이트 리스팅을 통해서 부가적인 보안 장치를 마련하자.