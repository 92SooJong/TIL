# WAF
Web Application Firewall의 약자이다. 익히 알던 방화벽과 마찬가지로 리소스에 대한 접근을 제어하는 역할을 한다.

WAF는 AWS의 Cloud Front와 연계해서 많이 사용된다.

WAF는 Cloud Front보다 바깥쪽에 위치한다.

WAF는 방화벽처럼 동작하며 룰을 만족하는 트래픽에 대해서만 Cloud Front로 보낸다.

# Cloud Front
content delivery network (CDN) 역할을 한다. 여기서 말하는 Content는 JPEG, HTML같은 정적 파일일 수도있고 또다른 서버를 의미하기도 한다.(즉 다른 서버로 Forwarding이 가능하다)

## What is "Alternate domain names" In AWS's Cloud Front?
- Alternate Domain Names (CNAMEs) in Amazon Web Services (AWS) CloudFront is a feature that allows you to associate multiple domain names with a single CloudFront distribution. 
- This way, users can access your content using different URLs, all of which resolve to the same content. 
- This is useful in cases where you have multiple domains that you want to serve the same content from or when you want to use a custom domain name for your CloudFront distribution instead of the default CloudFront domain.

## What is "Behaviors" In AWS's Cloud Front?
In AWS CloudFront, a behavior is a set of rules that define how CloudFront handles requests for specific files in your distribution. Each behavior is associated with a specific path pattern, and the behavior determines the origin that CloudFront uses to get the files, the caching behavior, and the authentication or access restrictions for requests.

You can configure multiple behaviors for a single CloudFront distribution, and each behavior can have different settings. For example, you might have one behavior that directs all requests for JPEG files to be served from a specific S3 bucket and another behavior that directs all requests for HTML files to be served from a different S3 bucket.

Behaviors are a key aspect of customizing the behavior of your CloudFront distribution, and they allow you to fine-tune how CloudFront serves your content to meet the needs of your application.

## What AWS service can integrate Cloud Front?
Amazon S3

Amazon Elastic Compute Cloud (EC2)

Amazon Elastic Load Balancer (ELB)

Amazon Route 53
AWS Certificate Manager (ACM)
- CloudFront can use ACM to securely serve content over HTTPS using a custom SSL/TLS certificate.

Amazon Lambda@Edge
- CloudFront can integrate with Lambda@Edge to run custom code in response to specific CloudFront events, such as a request or an error, allowing you to perform custom actions such as modifying the response headers.

Amazon DynamoDB 
- CloudFront can use DynamoDB to store data for use by a Lambda@Edge function.
