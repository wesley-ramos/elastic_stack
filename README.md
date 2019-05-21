# ELK Stack
![Architecture](architecture.png "Architecture")

## Introduction
The purpose of this meetup is to demonstrate how easy it can be to monitor various levels of the application

### Prerequisites
 - Docker

### Directory Organization

```shell
./
├── logstash.conf #Data transformation pipeline
│
└── docker-compose.yml #Infrastructure
```

### How to start the infrastructure ?

```shell
docker-compose -f infrastructure/docker-compose.yml  up -d
```

### Body

```json
{	
 "application":"ios",
 "tenant":"client",
 "release":"0.0.1",
 "level":"tracing",
 "batch":[{"message":"file=wesley.txt"},
          {"message":"file=leo.txt"}]
}
```

```json
{"application":"webapp", "tenant":"client", "release":"0.0.1", "level":"tracing", "message":"file=tracing.txt"}
```
