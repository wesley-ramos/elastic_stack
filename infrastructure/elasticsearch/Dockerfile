FROM  docker.elastic.co/elasticsearch/elasticsearch:7.5.0

COPY --chown=elasticsearch:elasticsearch elasticsearch.yml /usr/share/elasticsearch/config/

RUN echo 'involves' | bin/elasticsearch-keystore add  -xf bootstrap.password

EXPOSE 9200 9300
