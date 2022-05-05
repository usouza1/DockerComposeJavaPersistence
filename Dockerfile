# Build docker image from remote git

FROM maven:3.8-jdk-11-slim

ARG REPO

ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME

RUN apt update \
    && apt install -y git \
    && git clone $REPO $HOME

RUN mvn package

ENTRYPOINT java -jar target/*.jar
