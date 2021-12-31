# Consumer Group
- Consumer group은 토픽에 있는 데이터를 처리하는 Consumer의 묶음이다.
- 토픽에 존재하는 파티션들은 Consumer group에 있는 Consumer에 할당이된다.
- Consumer group에 새로운 Consumer가 들어오고 기존에 존재하던 Consumer가 사라진다면, 파티션은 Consumer group내의 Consumer와의 관계를 새롭게 정의한다. 새롭게 관계를 정의할때 가능하면 Consumer들이 동일한 개수의 파티션을 배정받을수 있도록 한다. 이를 "그룹을 리밸런싱 한다(rebalancing the group)" 라고 한다.

The main difference between the older “high-level” consumer and the new consumer is that the former depended on ZooKeeper for group management, while the latter uses a group protocol built into Kafka itself. 
In this protocol, one of the brokers is designated as the group’s coordinator and is responsible for managing the members of the group as well as their partition assignments.

The coordinator of each group is chosen from the leaders of the internal offsets topic __consumer_offsets, which is used to store committed offsets. 
Basically the group’s ID is hashed to one of the partitions for this topic and the leader of that partition is selected as the coordinator. 
In this way, management of consumer groups is divided roughly equally across all the brokers in the cluster, which allows the number of groups to scale by increasing the number of brokers.

When the consumer starts up, it finds the coordinator for its group and sends a request to join the group. 
The coordinator then begins a group rebalance so that the new member is assigned its fair share of the group’s partitions. 
Every rebalance results in a new generation of the group.

Each member in the group must send heartbeats to the coordinator in order to remain a member of the group. 
If no hearbeat is received before expiration of the configured session timeout, then the coordinator will kick the member out of the group and reassign its partitions to another member.
