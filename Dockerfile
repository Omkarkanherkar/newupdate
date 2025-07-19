FROM openjdk:17-jdk-slim
WORKDIR /app

# ✅ Corrected COPY command: provide both source and destination
COPY target/chat-app-backened-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
