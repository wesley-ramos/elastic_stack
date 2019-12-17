FROM docker.elastic.co/logstash/logstash:7.5.0

COPY pipeline /usr/share/logstash/pipeline
COPY certs /certs

COPY config/logstash.yml /usr/share/logstash/config/logstash.yml
COPY config/pipelines.yml /usr/share/logstash/config/pipelines.yml

EXPOSE 8080 12201 8090/udp 8070/udp