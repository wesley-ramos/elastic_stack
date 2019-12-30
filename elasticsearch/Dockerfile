FROM  docker.elastic.co/elasticsearch/elasticsearch:7.5.0

COPY --chown=elasticsearch:elasticsearch elasticsearch.yml /usr/share/elasticsearch/config/

RUN echo 'elastic' | bin/elasticsearch-keystore add  -xf bootstrap.password

HEALTHCHECK --interval=5s --timeout=5s --retries=5 CMD curl -H 'Authorization: Basic ZWxhc3RpYzplbGFzdGlj' -f http://localhost:9200/_cat/health

EXPOSE 9200 9300
