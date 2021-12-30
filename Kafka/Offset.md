# Current offsets 

- 토픽 내 파티션에 100개의 records가 있다고 가정하자. 최초의 current offsets은 0이다.
- topic에서 index 20까지 데이터를 Sub했다면 current offset은 20이 된다.
- 만약 이후에 추가로 topic에서 데이터를 Sub했다면 current offset은 20에서 sub한 데이터의 갯수만큼 이동할 것이다.
- current offsets은 Positive Integer이며, Topic입장에서 Consumer에게 보낸 데이터의 가장 마지막 위치를 가르키고 있는것이다.
- current offset 덕분에 Consumer는 같은 데이터를 2번이상 받지 않는다.

# Committed offsets
- Consumer는 데이터를 받고나서 데이터를 가공한 뒤에 DB에 저장하는 작업을 할것이다. 이런 작업을 성공적으로 마무리 했다면 Topic에게 보내준 데이터를 받아서 필요한 작업을 모두 완료했음을 알려줘야한다.
- Committed offsets는 Consumer가 가장 최근 성공적으로 작업을 완료한 데이터의 위치를 가르키고 있다.
- partition rebalance가 발생했을때 Committed offsets를 통해 Consumer가 어느 위치의 데이터까지 처리를 완료했는지 알 수 있게된다.


# 참고사이트
[https://www.learningjournal.guru/courses/kafka/kafka-foundation-training/offset-management/](https://www.learningjournal.guru/courses/kafka/kafka-foundation-training/offset-management/)
