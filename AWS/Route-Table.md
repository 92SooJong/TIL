# Route Table
## What is the purpose of Route Table in AWS's VPC?
The Route Table in Amazon Web Services (AWS) Virtual Private Cloud (VPC) serves as a mapping between the IP subnetworks in your VPC and the Internet. The Route Table contains a set of rules, called routes, that are used to determine where network traffic is directed.

> Route Table은 VPC내에 있는 서브넷과 인터넷을 매핑기능을 제공한다. Route Table은 routes 라고 불리는 rule을 가진다. routes를 통해서 네트워크 트래픽이 어디로 갈지 결정할 수 있다.

Each subnet in a VPC must be associated with a Route Table, which controls the traffic routing for the subnet. The Route Table specifies the traffic that is forwarded to the Internet through the Internet Gateway, and traffic that is forwarded to other subnets within the VPC, through a Virtual Private Gateway, VPN Connections, or VPC Peering Connections.

> 서브넷은 반드시 하나의 Route Table에는 할당되어야 한다. Route Table은 트래픽을 포워딩하는데 대상은 (인터넷 게이트웨이를 통한)인터넷 일수도 있고, 또 다른 서브넷일 수도 있다.

By using the Route Table, you can control the flow of traffic within your VPC and between your VPC and the Internet, allowing you to implement security and access controls for your resources. This helps you to design and enforce network security policies and to increase the security and reliability of your network.

> Route Table을 사용함으로써 VPC내의 트래픽을 제어할 수 있을뿐만 아니라 VPC와 인터넷 사이의 트래픽도 제어가 가능하다. 또한 Route Table에 적절한 룰을 적용함으로서 보안성을 높일 수 있다.

## What is the difference between Destination and Target in AWS routing table?
In Amazon Web Services (AWS), a routing table is used to determine where network traffic is directed within a Virtual Private Cloud (VPC). The terms "destination" and "target" are used in the context of a routing table to refer to specific aspects of a route:

Destination: The destination is the address or subnet to which traffic is being directed. In a routing table, the destination is specified as a CIDR block.

> Destination은 주소 또는 서브넷(범위)로 표기하며, 어떤 트래픽을 이동시킬지 나타낸다. routing table에서 destination은 CIDR 블럭으로 표기된다.

Target: The target is the AWS resource to which traffic is being directed. In a routing table, the target is specified as the network interface or virtual private gateway that handles the traffic.

> Target은 트래픽이 도착할 AWS의 리소스를 의미한다. routing table에서 target은 network interface or virtual private gateway 등이 정의 될 수 있다.

When you create a route in a routing table, you specify both the destination and the target. The destination is used to determine which traffic the route applies to, and the target is used to determine where that traffic should be directed.

For example, you might create a route that directs all traffic destined for a specific subnet to a virtual private gateway, and another route that directs all other traffic to a network interface. The destination in both cases would be specified as a CIDR block, and the target would be specified as either a virtual private gateway or a network interface, depending on the desired routing behavior.

> 특정 서브넷으로 향하는 모든 트래픽은 virtual private gateway로 가도록하고 그외 트래픽을 network interface로 보내는 route를 만들 수 있다. 이 경우 destination은 CIDR 블럭으로 정의될 것이다. routing behavior에 따라 다르겠지만 target은 virtual private gateway 이거나 network interface일 수 있다.

# Main Route Table
VPC를 보면 Main Route 테이블이 있는데, 이는 VPC생성시 부여되는 default route table을 의미한다. main route table은 삭제할 수 없다.
별다른 설정을 하지 않았다면 subnet들은 main route table에 할당된다.
