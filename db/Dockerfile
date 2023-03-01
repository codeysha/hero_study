FROM mysql:5.6

MAINTAINER wellingt <wellingt@student.21-school.ru>

RUN chown -R mysql:root /var/lib/mysql/

ENV TZ=Europe/Moscow

ARG MYSQL_DATABASE

ENV MYSQL_DATABASE=$MYSQL_DATABASE

COPY hero_db.sql /docker-entrypoint-initdb.d
RUN sed -i 's/MYSQL_DATABASE/'$MYSQL_DATABASE'/g' /docker-entrypoint-initdb.d/hero_db.sql
