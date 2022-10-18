# CIDR(Classless Inter-Domain Routing) 정의

CIDR은 IP 주소를 할당하고, IP 라우팅을 위한 방법론이다. IETF에 의해 1993년에 처음 소개 되었다.

주 목적은 라우팅 테이블의 증가와 IPv4 주소 고갈 속도를 줄이는 것이다.

IP주소는 2개의 bit 그룹으로 구성된다. 

Most Significant Bits(MSB)는 prefix로 사용되며 전체 네트워크을 의미한다.(subnet) MSB는 동적으로 변할 수 있으며 이러한 특성을 variable-length subnet masking(VLSM)으로 말하기도 한다.

Least Significant Bits(LSB)는 특정 host를 구분하기 위한 용도로 사용된다.

# 작성 방법과 예시

CIDR은 `198.51.100.14/24`  과 같이 작성할 수 있다. 

뒤에서 나오는 `24는 prefix bit(MSB)의 개수`를 의미한다. 즉, 24는 총 24개 prefix bit를 subnet으로 사용하겠다는 뜻이다. 198.51.100은 네트워크 전체를 의미하며, IPv4의 마지막 10진수인 14는 네트워크에 속한 특정 호스트 1개를 의미한다.

정리하면 `198.51.100` 네트워크의 내부에 할당 할 수 있는 host의 개수는 2의 9승인 256개가 된다.

그중 첫번째는 네트워크 주소가 되며, 마지막은 브로드캐스트를 의미하도록 설정된다. 따라서 254개가 실제 사용할 수 있는 host의 개수가 된다.
