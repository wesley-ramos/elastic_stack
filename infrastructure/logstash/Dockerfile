FROM docker.elastic.co/logstash/logstash:7.5.0

COPY pipeline /usr/share/logstash/pipeline
COPY certs /certs

COPY logstash.yml /usr/share/logstash/config/logstash.yml
COPY pipelines.yml /usr/share/logstash/config/pipelines.yml