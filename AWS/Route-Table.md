# Route Table

## What is the difference between Destination and Target in AWS routing table?

In Amazon Web Services (AWS), a routing table is used to determine where network traffic is directed within a Virtual Private Cloud (VPC). The terms "destination" and "target" are used in the context of a routing table to refer to specific aspects of a route:

Destination: The destination is the address or subnet to which traffic is being directed. In a routing table, the destination is specified as a CIDR block.

Target: The target is the AWS resource to which traffic is being directed. In a routing table, the target is specified as the network interface or virtual private gateway that handles the traffic.

When you create a route in a routing table, you specify both the destination and the target. The destination is used to determine which traffic the route applies to, and the target is used to determine where that traffic should be directed.

For example, you might create a route that directs all traffic destined for a specific subnet to a virtual private gateway, and another route that directs all other traffic to a network interface. The destination in both cases would be specified as a CIDR block, and the target would be specified as either a virtual private gateway or a network interface, depending on the desired routing behavior.

## 정리하면...
Destination은 Key, Target은 Value라고 생각하면된다.
다만 Destination은 Specific한 주소이기 보단 CIDR 형태의 범위를 나타내는 경우가 많다.