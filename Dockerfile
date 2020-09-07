#######################
# Phase 1. Build image
FROM gradle:5.4.1-jdk11 AS builder

WORKDIR /build

COPY --chown=gradle:gradle . ./simple-spring-rest
RUN cd simple-spring-rest && gradle -i --stacktrace clean build
#
#######################
### Phase 2. Target image
FROM openjdk:11-jdk AS service

WORKDIR /app
COPY --from=builder /build/simple-spring-rest/build/libs/simple-spring-rest-*.jar /app/simple-spring-rest.jar
COPY --from=builder /build/simple-spring-rest/build/resources/main/application.properties /var/config/api/application.properties

ENTRYPOINT exec java $JAVA_OPTS -jar /app/simple-spring-rest.jar