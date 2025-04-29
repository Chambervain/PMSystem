FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/ProductManagement-0.0.1-SNAPSHOT.jar springboot-example.jar
EXPOSE 8080
CMD ["java", "-jar", "springboot-example.jar"]
