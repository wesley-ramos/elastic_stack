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
docker-compose up -d
```

### Body

```json
{	
 "type":"log",
 "release":"0.0.1",
 "batch":[{"message":"file=wesley.txt"},
          {"message":"file=leo.txt"}]
}
```

```json
{"type":"tracing",  "release":"0.0.1", "message":"file=tracing.txt"}
```
