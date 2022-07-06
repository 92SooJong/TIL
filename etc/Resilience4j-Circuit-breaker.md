# **Count-based sliding window**

- Count-based sliding window는 N사이즈의 원형 배열로 구현된다.
- sliding window의 사이즈가 10이라면 원형 배열은 항상 10개의 측정값을 가지고 있다.
- 새로운 요청을 수행할때마다 집합을 수정한다.
- 가장 오래된 측정값이 퇴출된다.

# **Time-based sliding window**

- Time-based sliding window는 N개의 부분 원형 배열로 이뤄진다.
- window size가 10이라면 10개의 부분 원형 배열을 가지게 된다.
- 부분 원형 배열을 bucket이라고 한다.
- 각 bucket은 특정 epoch 초 내에 발생한 모든 요청들을 집계한다.
- 헤드 bucket은 현재 epoch초를 저장하고 있다. (=가장 최신정보를 저장한다. )
- 그외 bucket은 헤드 bucket 이전의 시간에서 발생한 호출 정보를 저장한다.
- 가장 오래된 bucket이 퇴출된다.
- bucket은 `실패 요청 수` , `느린(slow) 요청 수` , `전체 요청 수` 를 기록하고 있다.
- `모든 요청에 대한 전체 시간`을 기록하고 있다.

# **Failure rate and slow call rate thresholds**

- 실패 측정값이 설정한 threshold과 같거나 크면 서킷 브레이커의 상태는 CLOSED에서 OPEN 상태가 된다.
- 모든 Exception은 실패로 간주된다. (디폴트 설정)
- 사용자는 어떤 Exception을 실패로 간주할지 설정할 수 있다.
- 느린 호출의 비율이 설정한 threshold보다 크거나, 같으면 서킷 브레이커의 상태는 CLOSED에서 OPEN으로 변경된다. ( 예. 측정된 요청의 값들 중 50%가 5초를 넘는경우 )
- 응답속도가 늦은 외부 시스템에 대한 로딩을 줄일 수 있다. (자체적인 대기 시간을 설정하기 때문.)
- 최소 측정 숫자를 지정하면 해당 숫자만큼 호출을 받기전까진 실패 측정을 하지 않는다.
- 최소 측정 숫자를 10으로 했다면 9개의 실패 요청이 들어오더라도 그때까지 서킷 브레이커는 아무 작업도 하지 않는다.