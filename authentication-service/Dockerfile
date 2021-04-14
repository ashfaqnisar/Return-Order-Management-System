# Building
FROM maven:3.8.1-openjdk AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Packaging
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/authentication-0.0.1-SNAPSHOT.jar /home/app/authentication-service.jar
WORKDIR /home/app
EXPOSE 2000
ENTRYPOINT java -jar authentication-service.jar
