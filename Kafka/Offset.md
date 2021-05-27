# Current offsets 

- 현재 Consumer가 읽은 위치

# Committed offsets

- Consumer가 모든 작업을 처리하고 Commit 명령을 하면 Committed offset이 이동한다.

만약 Current offsets 데이터를 읽다가 커밋을 미처하지 못하고 장애가 발생한다면 다음번 재실행시 Committed offsets부터 읽으면 된다. 

Committed offsets은 Consumer가 확실히 해당 데이터를 수신하고 원하는 작업을 수행했다는 것을 의미한다.
