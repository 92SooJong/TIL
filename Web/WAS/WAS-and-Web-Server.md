
![](./Images/WAS-and-Web-Server1.png)

# Web Server

대표적인 Web Server로는 Apache가 있다. 클라이언트의 요청이 왔을때 정적인 웹페이지를 response하는 역할을 한다. 

Web Server는 어떤 하나의 프로그램일 수도, Web Server가 설치된 컴퓨터를 의미할 수도 있다. 

- 웹서버 = HTTP 프로토콜(GET, POST, DELETE)로 요청이 왔을때 응답
- 정적인 데이터만 처리한다.(HTML,CSS,이미지 등)
- port:80
- Apache Server, Nginx, IIS(Windows 전용 Web 서버) 등

# Web Application Server

- WAS는 Web Application Server의 줄임말이다.
- Tomcat, JBoss, Jeus, Web Sphere 등
- 동적인 웹을 만들어 내기 위해 사용되며 웹 컨테이너, 서블릿 컨테이너 등으로 불린다.
- Web Server에서 정적으로 처리하지 못하는 동작을 WAS로 넘긴다. ( JSP, ASP, PHP 등을 넘긴다. )
- Container란 JSP, Servlet을 실행시킬 수 있는 소프트웨어를 말한다.
- WAS는 JSP, Servlet 구동 환경을 제공한다.

![](./Images/WAS-and-Web-Server2.png)

아래와 같은 구조도 가능하다. WAS가 자체적으로 Web Server를 내장하는 경우다. 바로 위 구조와 성능상 차이가 별로 없다고 한다. 

![](./Images/WAS-and-Web-Server3.png)

Web Server가 필요한 이유는?

WAS와 별개로 Web Server를 앞단에 둚으로써 정적인 파일에 대한 요청은 WAS까지 도달할 필요없이 처리가 가능하다. 따라서 WAS의 부담을 줄일 수 있고 사용자 입장에서는 빠른 반응속도를 경험할 수 있다. 

WAS가 필요한 이유는?

WAS는 사용자의 요청에 따라 동적인 웹 페이지를 만들어 내는데 만약 WAS가 없다면 사용자가 발생시킬 수 있는 모든 경우의 수를 Web Server에 구현해둬야 한다. 

Web Server와 WAS를 분리한 이유는?

1. WAS의 부하를 줄일 수 있다. 정적파일에 대한 요청은 Web Server가 수행한다.
2. SSL에 대한 암복호화 처리에 Web Server를 사용하여 물리적으로 분리하여 보안 강화
3. Web Server에 여러대의 WAS 연결이 가능하다. 복제된 WAS를 하나더 연결하는 방식을 통해 기존 WAS가 장애가 발생하더라도 다른 WAS를 기동하면서 무중단 운영이 가능하다.
