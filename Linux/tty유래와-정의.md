Linux나 UNIX를 사용하다 보면 "TTY"라는 용어를 많이 듣게 되는데 "TTY"는 무엇일까?

Do note that there’s no definitive answer to this, but it relates to how input/output devices interacted in the past.
So, you will have to know a bit of history to get a clear picture.


# 역사속의 TTY
tty는 1830년대의 Teleprinter로부터 시작한다.
Teleprinter는 wire로 연결된 기기로 메세지를 보내고, 결과를 받을수 있도록 해줬다.
Teleprinter의 입력장치는 지금의 키보드 모습을 하고 있었기때문에 당시 사용하던 모스코드를 대체하기에 충분했다. ( 1901년 도널드 머레이에 의해 현대적인 모습의 키보드로 다시 탈바꿈한다.)
Teleprinter는 한명의 오퍼레이터가 필요했다.

Murray 코드는 오퍼레이터가 메세지를 손쉽게 보낼수 있도록 해줬다. 덕분에 Teleprinter가 1908년 상업화된 Teletypewriter로 전화하게 된다.
TTY는 이 Teletypewriter의 약자이다.

Teletypewriter와 일반적인 typewriter(타자기)의 차이는 Teletypewriter가 통신 장치에 부착되어 메세지를 전송한다는 점이다.
Teletypewriter는 사람이 유선으로 연결된 다른 장치와 소통이 가능하도록 해줬다. 바로 여기서 TTY가 나타난것이다.


# (상대적으로)근대의 TTY
여기서 드는 궁금증이 지금까지 봤던 TTY가 어떻게 현대의 컴퓨터로 들어왔냐는것이다. 
Teletypewriter이 시장을 강타하고 몇년뒤 반도체 트랜지스터가 개발되었다. 이후 반도체 트랜지스터는 컴퓨터의 마이크로프로세서를 개발되기에 이르렀다.
초기의 컴퓨터에는 키보드 개념이 없었으며, 입력으로는 Punch 카드를 사용했다. 컴퓨터가 점점 진화하면서 punch카드는 점점 입출력이 편리한 Teletypewriters로 대체 되었다.

기술이 점점 발전하면서 Teletypewriter는 가상화(Virtualized)되기에 이른다. 따라서 물리적이고 기계적인 TTY는 필요가 없어졌다.
이전 처럼 종이에 결과를 찍어내는게 아닌 모니터를 통해서 확인하고, 타이핑을 하긴 하지만 타이핑의 내용을 종이가 아닌 모니터를 통해 확인할수 있게 되었다. 즉 물리적인 방법이 전기적인 방법으로 변경되었다.

초창기의 컴퓨터는 스크린이 존재하지 않았기 때문에 모든 행위는 종이에 프린트 되었다. ( 여기서 왜 모든 출력문이 `display`가 아닌 `print` 라는 용어를 사용하는지 알게된다. )
기술이 발전하면서 이 physical한 terminal은 terminal emulator가 되었다. linux의 GNOME Terminal, or Konsol이 그 대표적인 예다. (여기서 말한 terminal이 tty다.)

# What is TTY in Linux?
Linux에서 TTY는 추상적인 장비이다. 직렬 포트와 같은 물리적 입력 장치를 가리키는 경우도 있고, 사용자가 시스템과 상호 작용할 수 있는 가상 TTY를 가리키는 경우도 있다. 
한마디로 지금까지 설명했던 Teletypewriter를 그대로 Linux에 집어 넣은것이라고 보면된다.
키보드를 통해 명령어를 입력하면 가상의 TTY에 타이핑을 하는것과 같다. linux os에 가상의 tty가 여러대 있다고 생각하면 쉽다. `who`를 검색하면 현재 user별로 현재 사용중인 tty를 조회할 수 있다.

