FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} chapter6.jar
ENTRYPOINT ["java","-jar","/chapter6.jar"]
