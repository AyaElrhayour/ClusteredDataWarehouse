FROM maven:3.9-amazoncorretto-17 AS build
WORKDIR  /app
COPY . .
RUN mvn clean install

FROM eclipse-temurin:17-jdk-focal
WORKDIR /app
COPY --from=build /app/target/clusteredDataWarehouse-0.0.1-SNAPSHOT.jar clusteredDataWarehouse.jar
EXPOSE 8082
ENTRYPOINT [ "java", "-jar",  "/app/clusteredDataWarehouse.jar" ]