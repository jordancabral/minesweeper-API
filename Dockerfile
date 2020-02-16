FROM gradle:jdk8-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/minesweeper*.jar ./app.jar
CMD ["java", "-jar", "app.jar"]