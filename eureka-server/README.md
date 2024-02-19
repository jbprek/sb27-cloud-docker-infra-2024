mcsvc-infra-eureka-service
==============================

Spring Boot cloud Netflix Eureka Implementation



Reference documentation
-----------------------
[Spring Cloud NetFlix](https://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html)

[Service Discovery Eureka Server](https://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html#spring-cloud-eureka-server)


Build & Run
-----------

### Standalone

```
mvn spring-boot:run
```

#### Web Console access

http://localhost:8761

### Docker Image Build 
```
mvn compile jib:dockerBuild
```