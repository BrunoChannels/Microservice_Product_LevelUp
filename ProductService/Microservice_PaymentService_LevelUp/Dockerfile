# ===== STAGE 1: Build =====
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn -q dependency:go-offline

COPY . .

RUN mvn -q clean package -DskipTests


# ===== STAGE 2: Runtime =====
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENV DB_URL=""
ENV DB_USER=""
ENV DB_PASS=""

ENTRYPOINT ["java", "-jar", "app.jar"]
