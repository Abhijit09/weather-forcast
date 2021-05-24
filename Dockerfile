FROM openjdk:8-jdk-alpine
EXPOSE 9000
COPY target/weather-forcast-0.0.1-SNAPSHOT.jar weather-forcast.jar
ENTRYPOINT ["java","-jar","/weather-forcast.jar"]