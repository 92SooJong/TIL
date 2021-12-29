# Current offsets 

- 토픽 내 파티션에 100개의 records가 있다고 가정하자. 최초의 current offsets은 0이다.
- topic에서 index 20까지 데이터를 Sub했다면 current offset은 20이 된다.
- 만약 이후에 추가로 topic에서 데이터를 Sub했다면 current offset은 20에서 sub한 데이터의 갯수만큼 이동할 것이다.
- current offsets은 Positive Integer이며, Topic입장에서 Consumer에게 보낸 데이터의 가장 마지막 위치를 가르키고 있는것이다.
- current offset 덕분에 Consumer는 같은 데이터를 2번이상 받지 않는다.

# Committed offsets

- Consumer가 모든 작업을 처리하고 Commit 명령을 하면 Committed offset이 이동한다.

만약 Current offsets 데이터를 읽다가 커밋을 미처하지 못하고 장애가 발생한다면 다음번 재실행시 Committed offsets부터 읽으면 된다. 

Committed offsets은 Consumer가 확실히 해당 데이터를 수신하고 원하는 작업을 수행했다는 것을 의미한다.
