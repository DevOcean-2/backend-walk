FROM openjdk:17-slim AS builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM openjdk:17

COPY dd-java-agent.jar /usr/agent/dd-java-agent.jar

COPY --from=builder build/libs/*.jar app.jar

VOLUME /tmp

ENTRYPOINT ["java", "-javaagent:/usr/agent/dd-java-agent.jar", "-Ddd.agent.host=localhost", "-Ddd.profiling.enabled=true", "-XX:FlightRecorderOptions=stackdepth=256", "-Ddd.logs.injection=true", "-Ddd.service=discovery-api", "-Ddd.env=prod", "-Dspring.profiles.active=production", "-jar", "/app.jar"]
