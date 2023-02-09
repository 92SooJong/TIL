# 원문 링크
[Kubernetes 101: Pods, Nodes, Containers, and Clusters](https://medium.com/google-cloud/kubernetes-101-pods-nodes-containers-and-clusters-c1509e409e16)


# 정리
## Node
쿠버네티스내에 존재하는 가장 작은 단위의 하드웨어를 뜻한다.(당연히 가상 하드웨어도 포함 함)

## Pod
Pod는 복수개의 컨테이너를 가질수 있으나 가능하면 pod에 있는 컨테이너 수는 작게 유지할 수있도록 하는게 좋다. pod가 스케일 업/다운을 할때 pod내에 있는 모든 컨테이너에 적용되기 떄문이다.

## Deployment
Pod는 deployment라는 추상화된 레이어에 의해서 관리된다. deployment는 pod가 한번에 몇개까지 실행되어야 하는지를 지정하기 위해 사용된다. Deployment가 클러스터에 추가되면 설정된 Replicas 개수에 따라 Pod를 생성한다. Deployment를 사용함으로써 pod를 수동으로 관리할 필요가 없다.

## Ingress
서비스중인 Pod과 통신하기 위해서 채널을 열어야하는데 이를 Ingress라고 한다. 가장 손쉬운 방법은 Ingress controller 또는 LoadBalancer를 추가하는 것이다.(2개의 차이를 이해해야함!)


