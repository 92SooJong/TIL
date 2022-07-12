# 2.4 Dockerfile

- 새로운 이미지를 생성하기 위해 사용하는 일련의 명령어를 실행할 수 있도록 해주는 파일
- 컨테이너에서 수행해야 할 작업을 명시하고 이미지를 생성한다.

# 2.4.2 Dockerfile 작성

- 샘플 파일을 생성한다.

![Untitled](./images/2-4/Untitled.png)

- Dockerfile을 작성한다.
- `FROM` 은 생성할 이미지의 베이스가 될 이미지를 뜻한다. Dockerfile에 반드시 한 번 이상 입력해야한다.
- `MAINTAINER` 은 이미지를 생성한 개발자의 정보를 나타낸다.
- `LABEL` 은 이미지의 메타데이터를 뜻한다.
- `RUN` 이미지를 만들기 위해 컨테이너 내부에서 명령어를 실행한다.
- `RUN ["실행가능한 파일","명령줄 인자1","명령줄 인자 2, ... ]` 형태로 작성가능하다.
- `ADD` 는 파일을 이미지에 추가한다. Dockerfile이 존재하는 위치에서 test.html을 가져와서 컨테이너에 있는 /var/www/html 경로에 마운트한다.
- `WORKDIR` 는 명령어를 실행할 디렉터리 위치를 나타낸다. Bash Shell에서 `cd` 명령어를 입력하는것과 같은 효과가 있다.
- `EXPOSE` 는 컨테이너에서 사용할 포트를 나타낸다. **호스트의 포트 80번과 바인딩 되는게 아님을 기억하자!!**
- `CMD` 는 컨테이너가 시작될 때마다 실행할 명령어를 설정한다. Dockerfile에서 한번만 사용할 수 있다. 만약 컨테이너를 생성할때 명령어를 입력한다면 Dockerfile에 작성한 CMD 명령어는 무시된다.

```bash
# vi Dockerfile

FROM ubuntu:14.04
MAINTAINER soojong
LABEL "purpose"="practice"
RUN apt-get update
RUN apt-get install apache2 -y
ADD test.html /var/www/html
WORKDIR /var/www/html
RUN ["/bin/bash","-c","echo hello >> test2.html"]
EXPOSE 80
CMD apachectl -DFOREGROUND
```

![Untitled](./images/2-4/Untitled%201.png)

# 2.4.3 Dockerfile 빌드

- `build` 명령어를 사용한다.
- `./` 경로에 있는 Dockerfile을 빌드한다.
- `./` 경로가 빌드 컨텍스트가 된다. ( Dockerfile이 위치한곳이 빌드 컨텍스트 )
- `-t` 옵션을 통해서 이미지의 이름을 지정한다.

```bash
sudo docker build -t mybuild:0.0 ./
```

- 이미지 빌드를 시작할때 가장먼저 빌드 컨텍스트에 있는 파일들을 읽는다.s
- 가능하면 빌드 컨텍스트에는 필요한 파일만 두는게 좋다.
- 아니면 `.dockerignore` 파일을 컨텍스트 빌드에 작성하도록 한다.

![Untitled](./images/2-4/Untitled%202.png)

- 각 Step은 Dockerfile에 작성된 명령어를 의미한다.
- 각 Step이 실행될때 마다 새로운 컨테이너가 하나씩 생성되며 다음 컨테이너 생성시 사용된다.
- 이미지의 빌드가 완료되면 임시로 생성된 컨테이너들은 모두 삭제된다.

![Untitled](./images/2-4/Untitled%203.png)

### 캐시 동작 확인해보기

- Dockerfile2를 생성해서 아래와 같이 명령어를 작성한다.

```bash
FROM ubuntu:14.04
MAINTAINER soojong
LABEL "purpose"="practice"
RUN apt-get update
```

- -f 옵션을 사용해서 강제로 Dockerfile2를 빌드하도록 한다.

```bash
sudo docker build -f Dockerfile2 -t mycache0.0 ./
```

- 로그에서 `Using cache` 를 확인할 수 있다.
- 이전에 빌드했던 Dockerfile에 가튼 내용이 있다면 build 명령어는 이를 새로 빌드하지 않고 같은 명령어 줄까지 이전에 사용한 이미지 레이어를 활용해서 이미지를 생성한다.
- 아래의 예시는 Step1에서 만들어진 임시 컨테이너를 Step4까지 모두 사용한다.

![Untitled](./images/2-4/Untitled%204.png)

### 캐시가 불필요한 경우

- Dockerfile 빌드시 캐시 기능을 제외해야하는 경우가 있다.
- 대표적으로 `RUN git clone` 같은 경우이다. RUN에 대한 이미지 레이어를 계속 캐시로 사용하기 때문에 저장소에 있는 새로운 소스를 불러오지 못하는 경우가 생긴다.
- 따라서 `--no-cache` 옵션을 통해서 빌드시에 캐시기능을 사용하지 않도록 한다.

```bash
sudo docker build --no-cache -y mybuild:0.0 .
```

### 멀티 스테이지를 이용한 Dockerfile 빌드하기

- 샘플용 golang 앱을 만든다.

```go
package main
import "fmt"
func main(){
	fmt.Println("hello World");
}
```

- 위 소스코드를 실행하는 이미지를 빌드하기 위한 Dockerfile을 작성한다.

```bash
FROM golang
ADD main.go /root
WORKDIR /root
RUN go build -o /root/mainApp /root/main.go
CMD ["./mainApp"]
```

- Dockerfile을 빌드한다.

```bash
sudo docker build . -t go_helloworld
```

- golang 이미지의 사이즈가 크기때문에 전체 이미지가 960MB에 달한다.

![Untitled](./images/2-4/Untitled%205.png)

- 멀티 스테이지가 적용된 Dockerfile을 통해서 컴파일된 app만 포함하는 이미지를 만들어본다.
- 첫번째 FROM 이미지에선 golang을 통해 소스코드 빌드까지만 수행한다.
- 두번째 FROM 이미지에선 `COPY --from=0` 을 통해서 첫번째에서 빌드된 App을 2번째 이미지로 가져온다.
- 두번째 FROM에서 내려받은 이미지로 최종 빌드하게 되므로 컴팩트한 이미지 생성이 가능해진다.

```bash
FROM golang
ADD main.go /root
WORKDIR /root
RUN go build -o /root/mainApp /root/main.go

FROM alpine:latest
WORKDIR /root
COPY --from=0 /root/mainApp .
CMD ["./mainApp"]
```

- 용량이 줄어든것을 확인할 수 있다.

![Untitled](./images/2-4/Untitled%206.png)
