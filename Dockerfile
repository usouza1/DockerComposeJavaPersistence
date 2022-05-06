# Build docker image from remote git
# Edit only docker-compose.yml

FROM maven:3.8-jdk-11-slim

ARG REPO

ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME

RUN apt update \
    && apt install -y git 
    
ARG CACHEBUST=1

RUN git clone $REPO . \
    && mvn package

# COPY . $HOME
# RUN mvn package

ENTRYPOINT java -jar target/*.jar
