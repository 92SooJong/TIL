# Prefix list
## What is the prefix list in AWS?
A prefix list in Amazon Web Services (AWS) is a collection of IP address prefixes (in CIDR notation) that define a set of addresses. Prefix lists are used in AWS to control access to Amazon VPCs (Virtual Private Clouds) and Amazon VPC endpoints, such as Amazon S3 and Amazon DynamoDB.

> CIDR로 작성된 IP 주소 범위의 묶음을 뜻한다.

In Amazon VPC, you can use prefix lists to specify the IP address ranges for AWS services or endpoints in your VPC. For example, you can create a prefix list that includes all the IP address ranges for Amazon S3, and then use that prefix list to allow incoming traffic from Amazon S3 to your VPC. Similarly, you can create a prefix list for Amazon DynamoDB and use it to control access to your DynamoDB tables from your VPC.

Prefix lists are also used in Amazon VPC peering, where you can use prefix lists to define the IP address ranges for the VPCs that you want to allow traffic to and from in a VPC peering connection. This allows you to control the flow of traffic between VPCs in a more fine-grained manner.