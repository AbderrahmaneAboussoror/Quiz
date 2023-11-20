FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY ./target/*.jar quizz.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/quizz.jar"]