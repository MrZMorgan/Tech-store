
FROM adoptopenjdk/openjdk11:alpine-jre
MAINTAINER tech.store
COPY build/libs/tech_store-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]