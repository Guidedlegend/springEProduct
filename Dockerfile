# Use Maven to build the app
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a smaller base image to run the app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Expose the port
EXPOSE 8088

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
