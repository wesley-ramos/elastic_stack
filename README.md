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

The communication with the mobile is performed through the entrypoint "localhost: 8090", it receives a lot of logs with the following structure

```json
{	
 "application":"ios",
 "tenant":"client",
 "release":"0.0.1",
 "level":"tracing",
 "batch":[{"message":"my message"},
          {"message":"my message"}]
}
```

### Web APP integration (UDP)

The communication with the web application is performed through the entrypoint "localhost: 8091" that receives the messages through the UDP protocol.

For this to work it is necessary to configure log4j
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN" shutdownHook="disable">
    <Appenders>
    	<Console name="stdout" target="SYSTEM_OUT">
    		<PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} %5p ${PID:- } [%t] --- %-40.40logger{39} : %m%n"/>
    	</Console>
    	<Socket name="logstash" protocol="udp" host="localhost" port="8091" immediateFlush="true">
        	 <PatternLayout pattern="application=webapp level=tracing %m%n"/>
    	</Socket>
    </Appenders>  
	<Loggers>
	 	<Root level="INFO">
            <AppenderRef ref="logstash" />
        </Root>
	</Loggers>
</Configuration>
```

