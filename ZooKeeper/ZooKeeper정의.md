
# 정의
주키퍼는 중앙에서 분산 application을 관리하는 코디네이션 애플리케이션이다. 

# 코디네이션 애플리케이션

데이터 스트리밍을 통해서 나의 target DataBase에 데이터를 저장한다고 해보자. 데이터 스트리밍을 수행하기 위한 컴퓨터를 한대 마련했다. 데이터 스트리밍을 수행하던 도중 유일하게 데이터 스트리밍을 수행하는 컴퓨터가 장애를 일으킨 경우, 데이터 스트리밍 기능 자체가 마비되어버린다. 


이런 장애를 해소하기 위해 데이터 스트리밍을 하기위한 컴퓨터를 몇대 더 추가함으로써 분산 애플리케이션을 구축했다. 여기서 또다른 문제가 발생한다. 안정적으로 데이터 스트리밍을 수행하긴 하지만 서버간의 상태가 일관되게 유지 되지 않았다. ( kafka의 경우 offset 같은 정보들이 있다. )


위 처럼 분산된 애플리케이션의 상태를 동기화하기 위해 코디네이션 애플리케이션이 등장했다. 그 대표적인 프레임워크가 ZooKeeper이다.

# ZooKeeper와 앙상블

ZooKeeper는 코디네이션 서비스다. 코디네이션 서비스는 분산된 서버를 하나로 관리해주는 역할을 한다. ZooKeeper의 앙상블(클러스터)를 구성하기 위해선 항상 홀수개의 ZooKeeper서버가 준비되어야한다.  ZooKeeper의 앙상블에는 Leader와 Follower가 존재한다. 

# zNode

zNode는 ZooKeeper서버의 파일시스템을 구성하는 가장 기본적인 단위이다. zNode는 최대1MB의 데이터를 저장할 수 있다. 

Application(ZooKeeper Client)은 zNode의 상태를 업데이트하는데, 변경사항에 대해선 ZooKeeper서버 전체와 동기화 할수 있도록 한다. ZooKeeper를 사용하기 위해선 자바가 설치되어 있어야한다. 

### 

# 참고

- https://jdm.kr/blog/214
- https://www.slideshare.net/ssuser0ae7a8/zoo-keeper-77685872
- https://www.mynotes.kr/zookeeper-cluster-설치/
- https://www.youtube.com/watch?v=SspgvvQ13DU
