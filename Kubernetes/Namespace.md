# Kubernetes Namespace

Namespace는 단일 클러스터 내에서 리소스 그룹을 격리하는 메커니즘이다.

## Namespace를 나눌 때 얻는 Hard한 이점

단순히 관리나 소통 편의성(soft한 이점)이 아닌, **실제로 격리와 제한을 enforce**할 수 있는 기술적 이점들이 있다.

### 1. Resource Quota & Limit Ranges

Namespace별로 리소스 사용량을 강제로 제한할 수 있다.

```yaml
apiVersion: v1
kind: ResourceQuota
metadata:
  name: team-a-quota
  namespace: team-a
spec:
  hard:
    requests.cpu: "10"
    requests.memory: 20Gi
    limits.cpu: "20"
    limits.memory: 40Gi
    pods: "50"
```

- 특정 팀/서비스가 클러스터 리소스를 독점하는 것을 방지
- Namespace 없이는 클러스터 전체에만 적용 가능

### 2. Network Policy 격리

Namespace 단위로 네트워크 트래픽을 격리할 수 있다.

```yaml
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: deny-from-other-namespaces
  namespace: production
spec:
  podSelector: {}
  ingress:
  - from:
    - podSelector: {}  # 같은 namespace 내의 Pod만 허용
```

- Namespace 간 트래픽 차단 가능
- 보안 경계 설정이 간단해짐

### 3. RBAC 권한 분리

Namespace 단위로 접근 권한을 분리할 수 있다.

```yaml
apiVersion: rbac.authorization.k8s.io/v1
kind: RoleBinding
metadata:
  name: dev-team-binding
  namespace: development
subjects:
- kind: User
  name: developer@company.com
roleRef:
  kind: Role
  name: developer-role
```

- Namespace별로 다른 사용자/서비스 계정 권한 설정
- 개발자가 production namespace 접근 차단 가능

### 4. 리소스 이름 충돌 방지

동일한 이름의 리소스가 다른 Namespace에 공존할 수 있다.

```bash
# 같은 이름이 다른 namespace에 공존 가능
kubectl get svc redis -n team-a  # team-a의 redis
kubectl get svc redis -n team-b  # team-b의 redis
```

- 동일한 이름의 ConfigMap, Secret, Service 등 사용 가능
- DNS 자동 분리: `redis.team-a.svc.cluster.local`

### 5. 일괄 삭제 & 관리

Namespace 삭제 시 모든 하위 리소스가 자동으로 정리된다.

```bash
# namespace 삭제 시 모든 리소스 자동 정리
kubectl delete namespace temp-test
```

- Cascade delete: Namespace 삭제 시 모든 하위 리소스 자동 삭제
- 임시 환경 정리가 간단

## Namespace를 나누지 않아도 되는 경우

| 상황 | 이유 |
|------|------|
| 단일 소규모 서비스 | 오버헤드만 증가 |
| 리소스 격리 불필요 | 모든 팀이 전체 접근 필요 |
| 네트워크 정책 미사용 | CNI가 NetworkPolicy 미지원 |

## 요약

| 이점 | 설명 |
|------|------|
| 리소스 할당량 강제 | ResourceQuota로 CPU, 메모리, Pod 수 제한 |
| 네트워크 격리 | NetworkPolicy로 Namespace 간 트래픽 차단 |
| 접근 권한 분리 | RBAC으로 Namespace별 권한 설정 |
| 이름 충돌 해결 | DNS 분리로 동일 이름 리소스 공존 |
| 일괄 리소스 관리 | Cascade delete로 간편한 정리 |
