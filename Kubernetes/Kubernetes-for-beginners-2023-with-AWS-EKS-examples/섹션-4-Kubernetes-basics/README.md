# 섹션 4: Kubernetes basics

# Node

Kubernetes의 노드는 클러스터를 구성하는 (Logical or Physical) Machine이다.

클러스터 내에는 최대 5000개의 Node가 존재할 수 있으나 현실적으로 이만큼 생성할 일은 없다. 그냥 참고차 알아두자.

# Type of Node

- control plane 노드 - 쿠버네티스의 기능들이 있는 노드. Worker 노드를 관리하는 노드. AWS는 control plane을 래핑한 서비스를 제공하기도 함. 이런 서비스들을 사용하면 control plane 노드의 가용성을 어느정도 보장받을 수 있음.
- Worker 노드 - application이 실행되는 노드

# Kube api server

Kube api는 REST api이며, 클러스터를 관리하는 기능들을 제공한다. 클러스터를 제어하기 위한 End Point라고 생각하면 된다. kubectl은 로컬에 있는 클라이언트이며 Kube api server로 클러스터 제어를 위한 요청들을 보낸다.

일반적으로 Kube api server는 control plane 노드에서 Pod 형태로 동작한다.

![Image.png](Image.png)

# EKS

AWS에서 제공하는 kubernetes 관리 service이다. control plane자체는 AWS에서 관리하며 우리는 worker node에만 집중하면 된다. AWS에서 control plane의 가용성을 보장해줌!!!

# Etcd(distributed key value storage)

쿠버네티스 클러스터를 백업하는 데이터베이스임. Key-value 형태로 데이터를 저장한다. distributed라는 이름에서 알 수 있듯이 multi node에서 동시에 실행되고 있다. kube api server가 직접 통신하고 있기 떄문에 client쪽에서 직접 통신할 필요는 없다. 1초에 10,000회 쓰기가 가능한 빠른 저장소임.

control plane 노드가 1개 있다면 Etcd도 1개 있다고 생각하면 됨.

Raft protocol을 사용한다.(이 부분은 다시 학습을 해보자)

# Kublet

Kublet은 Node의 심장같은 존재다. 모든 노드가 Kublet을 가지고 있다. kube api가 다른 노드와 통신할때 각 노드에 있는 kublet과 통신을 수행한다.

![Image.png](Image%20(2).png)

