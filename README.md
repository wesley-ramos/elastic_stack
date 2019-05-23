# ELK Stack
![Architecture](architecture.png "Architecture")

## Introduction

The purpose of this POC is to centralize the logs of a multinentant application and mobile devices.

### Prerequisites
 - Docker

### Directory Organization

```shell
./
├── infrastructure 
│   ├── logstash.conf
│   └── docker-compose.yml
└── webapp 
```

### How to start the infrastructure ?

```shell
docker-compose -f infrastructure/docker-compose.yml  up -d
```

### Mobile device integration (HTTPs)

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

### Web APP integration (UDP)


