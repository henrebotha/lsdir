FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/lsdir-0.1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
