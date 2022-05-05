# Build docker image from local code

# FROM maven:3.8-jdk-11-slim as build
# ENV HOME=/usr/app
# RUN mkdir -p $HOME
# WORKDIR $HOME
# ADD . $HOME
# RUN mvn package

# FROM tomcat:9.0.62-jre11-temurin
# EXPOSE 8080
# RUN rm -rf /usr/local/tomcat/webapps/*
# #COPY ./src/main/resources/tomcat/conf/* /usr/local/tomcat/conf/
# COPY --from=build /usr/app/target/dockerfile-maven-api-1.0.war /usr/local/tomcat/webapps/smarti.war
# CMD ["catalina.sh","run"]


# FROM openjdk:11-jre-slim
# ENV HOME=/usr/app
# ENV JAR_FILE=demo-0.0.1.jar
# RUN mkdir -p $HOME
# WORKDIR $HOME
# COPY target/$JAR_FILE $JAR_FILE
# ENTRYPOINT java -jar $JAR_FILE

FROM maven:3.8-jdk-11-slim
ENV HOME=/usr/app
#ENV JAR_FILE=demo-0.0.1.jar
ENV JAR_FILE=$("ls target/*.jar |head -1") 
RUN mkdir -p $HOME
WORKDIR $HOME

RUN apt update \
    && apt install -y git \
    && git clone https://github.com/usouza1/DockerComposeJavaPersistence.git \
    && mvn package

#COPY target/$JAR_FILE $JAR_FILE
ENTRYPOINT java -jar target/$JAR_FILE
