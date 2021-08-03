# Springboot_ActiveMQ [Artemis]
#### Springboot + ActiveMQ [Artemis] + Monorepo + Docker example

## Stack:

- Java 8, Springboot 2, Monorepo project structure
- ArtemisMQ [Artemis], Slack, Feign
- Docker, Maven with docker plugin

## Artemis UI

To visit Artemis UI, go to `http://localhost:8161`, login/passwd : `admin/admin`

## Build

- Build all project : `./mvnw clean install`
- Build particular module : `./mvnw clean install -pl msgProducer`
- Build all project with docker images : `./mvnw clean install docker:build`
- Build particular module with docker images : `./mvnw clean install -pl msgProducer docker:build`

To run project, type following commands :

```
./mvnw clean package docker:run
docker compose up
```

or run script : `./totalRebuild.sh`
