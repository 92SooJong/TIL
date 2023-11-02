
# Namespace

Process의 Isolation을 위한 논리적 공간이 Namespace임.

무엇을 분리하는지에 따라 Namespace의 종류가 구분됨.

PID Namespace
- 부모가 자식 PID 조회가능하나, 자식이 부모 PID 조회는 불가능

Network Namespace
- 컨테이너가 독립된 Network 환경을 구성할 수 있도록 해줌.
- Namespace 사이에서는 veth를 통해서 Traffic 전달.

Mount Namespace
- 각 컨테이너가 독립된 Directory를 가질 수 있도록 해준다.
- 호스트의 디렉토리를 컨테이너에 마운트 시킬 수도 있음.

# Linux Cgroup
- 프로세스의 격리를 하고나면 얼마만큼의 자원을 사용할지 설정한다.(+ 모니터링도 포함)

# Container Image
- Container가 이용하는 Root FileSystem.
- meta + Layer로 구성

# 컨테이너 레이어
- RW Layer, Read Only Layer
- Read Only Layer는 변경의 여지가 없기 떄문에 내부적으로 캐싱을 함.
- 이미지가 빨리 받아지는 경우가 있는데 이때 해당 이미지를 구성하는 Layer를 이미 가지고 있는 경우다.

# Union Mount, OverlayFS
- 투영규칙 잘 확인하기

# Dockerfile
- 이미지를 명세한 파일
- 한줄한줄이 하나의 Layer다.
- 내부적으로 Layer 최적화를 위해 하나로 Layer를 단순화 하는 작업을 함.
- Multi Stage Build에 대해서 알아보기(Layer를 줄이기 위해 Build를 별도의 Stage에서 실행하는 방식)
- 좀비 프로세스 방지하기 -> 알아보자...
- 컨테이너 이미지 멀티 아키텍쳐 -> 이미지를 내려 받을 때 x86, ARM에 대응할 수 있도록 해준다. 빌드할떄 플랫폼 태그를 통해서 처리함.

# Container Security
- Process Security in Container
- 어플리케이션에 구동하는데 필요한 Image로만 구성하는게 권고 사항이다. (쓸데없는 Shell같은거 넣지마라.)
- Container 내에서 File Write 동작은 드문일이다. 가능하면 Write는 막고 허용한 볼륨에서만 Write를 수행하도록 해라.

# Kubernetes
- 컨테이너를 하나하나 띄우고 제어하는건 너무 힘들다. 이를 관리하기 위한게 컨테이너 오케스트레이션이다.

etcd
- 키-밸류 스토어

K8s/Cloud Controller Manager 구분하기

# K8s Object
- Controller에 의해서 관리되는 최소 단위
- 네임스페이스 적용 가능, 불가능 두부류로 나눌수 있음.
- Object는 2개의 상태를 가진다. (원하는 값, 현재값)
- Reconcile는 통해서 Spec과 Status를 일치시키는 과정이다.

# CRI(Container Runtime Interface)
- K8s같은 오픈소스는 인터페이스만 제공하고 실행을 위한 구현체는 다른 벤더들이 처리함
- Pod 실행에 관련된 플러그인

# Pod, ReplicaSet
- ReplicSet보다는 Deployment를 많이 사용함.

# StatefulSet
- Replica 개수만큼 전체 Pod의 개수 유지
- 볼륨과 파드의 1대1, 1대N 매칭이 가능함.
- 배포할때 이름을 고정적으로 Pod를 만들 수 있음.

# DaemonSet
- Node에 Pod를 한개씩 배포할때 활용

Pending Pods
- Node 부족으로 인해서 Pending Pod가 발생하는 경우 Cluster AutoScaler, Karpenter(성능 좋음)를 사용.

# CNI (Container Network Interface)
컨테이너 실행과 마찬가지로 Pod 네트워크도 인터페이스화 되어 있음. (Container Network Interface)
Pod간 네트워크와 관련된 플러그인

클러스터 내부간 통신하는 CluseterIP 사용.

클러스터 외부와 통신하는 경우에는 NodePort를 사용.

# CSI (Container Storage Interface)

KMS 서비스를 통해서 별도로 Credential을 적용할 거을 권장함.

Control Plane AWS관리 영역임.
Worker Node 영역이 고객에게 노출된 영역이다.

AWS는 애드온을 서비스로 제공하고 있다.

Metric Server가 Pod의 상태를 모니터링 해준다.

ingress L3(ALB), L4(NLB) 로드 밸런서 차이 알기

EC2 노드를 쓰면 IP를 미리 풀링 해놓기 때문에 어차피 IP 쓰는건 똑같다.