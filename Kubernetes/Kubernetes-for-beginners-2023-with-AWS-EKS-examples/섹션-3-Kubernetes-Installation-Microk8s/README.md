이미지와 마찬가지로 컨테이너도 변경이 불가능하다. 즉, Kubernetes의 자원들은 모두 immutable하다.

# Kubectl


kubectl에서 ctl은 controller의 약자이다.

원격에 구동중인 Kube 클러스터에 접근하고 명령어를 수행하기 위한 클라이언트 툴이다. Kube 클러스터와 HTTPS를 통한 REST API 통신을 수행한다.

설치를 해보자.

```other
#!/bin/bash
sudo snap install kubectl --classic

# check the version of kubectl
kubectl version

# You can find all the other OSses and distros here https://pwittrock.github.io/docs/tasks/tools/install-kubectl/

### WIDOWS 
# If you decided to go with Windows download the binary 
# Place it to dedicated folder e.g.C:\Program Files\kubectl
# Place the folder to the environment variables so you can use it in cmd
# Create the .kube folder in your home directory. Most likely in C:\Users\<User-name>\.kube
# Config is expected to be presented there 

# In order to work with kubectl we need cluster and cluster config
# Everytime we run kubectl command the CLI will search for config by default at
cat ~/.kube/config

# Or if speciffied at KUBECONFIG
export KUBECONFIG=/path/to/config   # to set variable
printenv | grep KUBECONFIG          # to view variable 
# there is also option to always provide path to the config with every cli call whihch we discuss later

# You can combine kubeconfigs we discuss later
```


# Microek8s


로컬 테스트용으로 간단히 Kube 환경을 구축할때 사용한다.

Mac OS를 사용하고 있다면 아래 링크를 통해서 설치하자.

[https://microk8s.io/docs/install-macos](https://microk8s.io/docs/install-macos)

아래 명령어는 Ubuntu 사용자 기준의 설치법이다.

```java
#!/bin/bash

# First update the registires
sudo apt update
sudo apt upgrade

# Install microk8s with single command. This will install latest snap you can check versions here (top right dropdown with versions) https://snapcraft.io/microk8s
sudo snap install microk8s --classic

# If you want to install version which I am using not latest you can run 
sudo snap install microk8s --channel=1.25/stable --classic 

# (Optional just to know) To uninstall run 
sudo snap remove microk8s --purge

# To check the status of microk8s
microk8s status

# You can start and stop anytime 
microk8s stop
microk8s start

# You can install microk8s addons as follows 
# List of all addons is here https://microk8s.io/docs/addons
# We will need just following ones (you can add addon anytime you want)
microk8s enable rbac dns storage metallb:10.64.140.43-10.64.140.49 ingress

# Microk8s kubeconfig can be obtained with microk8s config
mkdir ~/.kube                       # create .kube directory 
microk8s config > ~/.kube/config    # create config. Now we no longer need to prefix with microk8s.
kubectl version                     # now if you run the command you should see version for client and version for server
```


`microk8s kubectl get nodes` 명령어를 통해서 microk8s내 노드를 확인할 수 있다.
