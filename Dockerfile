# syntax=docker/dockerfile:1

FROM openjdk:11 as base

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

RUN ./mvnw clean package

FROM base as development

COPY --from=base /app/target/screenshotter-user-*.jar /screenshotter-user.jar

EXPOSE 8081

ENTRYPOINT ["java","-Dspring.profiles.active=local", "-jar", "/screenshotter-user.jar"]
