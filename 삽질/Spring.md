
## Error:java: Source option 5 is no longer supported. Use 6 or later. 
```xml
<properties>
     <maven.compiler.source>1.8</maven.compiler.source>
     <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

## Spring JPA로 MySQL에 접근할때 추가로 셋팅해야할 사항.
### mysql Connector가 내장되어 있지 않기때문에 의존성 추가를 해준다. 
### 너무 낮은 버전으로 해도 에러가 발생하니 그나마(?) 최신인 8.0.25버전으로 추가함.
```xml
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.25</version>
</dependency>
```
```
Failed to load driver class com.mysql.cj.jdbc.Driver in either of HikariConfig class loader or Thread context classloader
```
