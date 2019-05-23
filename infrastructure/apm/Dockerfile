FROM docker.elastic.co/apm/apm-server-oss:6.6.2

COPY apm-server.yml /usr/share/apm-server/apm-server.yml
USER root
RUN chmod go-w /usr/share/apm-server/apm-server.yml
USER apm-server