# Build

```
mvn clean compile jib:dockerBuild
```

# RUN

## DB Creation

TODO  - Oracle XE  image with a pre-created schema

### 1. Manually create **subscriptions** schema

Connected as  'sys as sysdba' execute the following commands:

```sql
alter session set container = XEPDB1;
CREATE USER subscriptions IDENTIFIED BY subscriptions;
GRANT CONNECT, RESOURCE, DBA TO subscriptions;
```
###  2. Perform Flyway migation

```
mvn clean flyway:migrate 
```