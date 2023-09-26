# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# EXPOSE 8080
# COPY target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar
EXPOSE 9001
CMD ["java", "-jar", "app.jar"]