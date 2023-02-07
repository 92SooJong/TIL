# What is the must know terminology for learning Kubernetes?
Here is a list of some key terminology to be familiar with when learning Kubernetes:

Cluster: A set of physical or virtual machines that run Kubernetes and host containers.

Node: A worker machine in a cluster that runs containers.

Pod: The smallest and simplest unit in the Kubernetes object model, representing a single instance of a running process.

Deployment: A declarative resource used to manage a set of replicas of a pod.

Service: An abstraction layer that defines a logical set of pods and a policy by which to access them.

Volume: A mechanism for storing data that can persist even after a pod is deleted.

ConfigMap: A resource used to store configuration data that can be used by pods.

Secret: A resource used to store sensitive information, such as passwords and certificates, that can be used by pods.

Namespace: A logical boundary for resources in a cluster.

Label: A key-value pair attached to resources in Kubernetes, used for organization and management.

# 정리하자면
Cluster는 쿠버네티스, 컨테이너가 구동중인 가상 또는 물리 서버의 집합을 의미한다.

Node는 클러스터 내에서 컨테이너를 실행하는 worker 서버를 의미한다.

Pod은 쿠버네티스 오브젝트의 최소 단위를 의미하며, 하나의 실행중인 프로세스를 의미한다

Deployment는 Pod으로 이뤄진 레플리카의 묶음을 관리하는 명시적 리소스를 의미한다

Service는 pods의 논리적인 그룹이며, 그룹에 대한 접근 정책을 관리하는 추상화된 레이어이다.

Volume은 pods의 영속 데이터를 저장하기 위한 메카니즘을 의미한다.

ConfigMap은 pods에 의해 사용되는 configuration 데이터 리소스를 의미한다.

Secret은 pods가 사용하는 민감 정보 리소스를 의미한다. 예를들면, 패스워드, 인증정보이다.

Namespace는 클러스터 내에서 사용되는 리소스간 논리적인 경계를 의미한다.

Label은 리소스에 붙어있는 Key-Value이다. 주로 그룹화나 매니징을 위해 사용된다.