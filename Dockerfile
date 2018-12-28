FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 4040

ARG JAR_FILE=build/libs/playerbattle-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Dserver.port=4040","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]