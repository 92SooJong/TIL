# Peering Connection
## What is the peering connection in AWS's VPC?
A VPC peering connection in Amazon Web Services (AWS) is a networking connection between two Amazon Virtual Private Clouds (VPCs) that enables communication between instances in the VPCs as if they were within the same network.

> 2개의 VPC를 연결하기 위한 서비스이다.

With VPC peering, you can route traffic between VPCs using private IP addresses. The VPCs can be in the same region or in different regions. You can also set up VPC peering between your own VPCs, or between a VPC in your account and a VPC in another AWS account.

> private IP 주소를 통해서 VPC간 통신을 가능하게 해준다. VPC는 같은 리전에 있어도 되고 그렇지 않아도 된다. 다른 사람의 계정에서 생성되어 있는 VPC 연결도 가능하다.

VPC peering provides several benefits, including:

Improved network performance, as the traffic between instances in peered VPCs does not traverse the public internet.

Increased security, as the traffic between instances in peered VPCs is kept within the Amazon network.

Enhanced scalability, as you can build multi-tier applications across multiple VPCs that can grow and evolve independently.

> VPC 피어링을 사용하면 네트워크 성능을 향상 시킬 수 있는데, 이유는 internet을 통하지 않고 바로 VPC간 통신을 하기 때문이다.
>  
> 마찬가지로 인터넷을 통하지 않고 AWS 서비스 내에서 통신하기 때문에 보안상 안전하다.
>
> 피어링을 통해 확장이 편리해진다.

VPC peering is a one-to-one relationship, meaning that each VPC can be peered with a maximum of one VPC in another AWS account, and each VPC in another AWS account can be peered with a maximum of one VPC in your account. However, you can create multiple VPC peering connections within a region or across multiple regions.

> VPC 피어링은 1대1 관계이다. 즉, 하나의 VPC는 다른 1개의 VPC에만 연결될 수 있다.
