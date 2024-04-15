FROM openjdk:17
WORKDIR /app
COPY ./target/newsletter-0.0.1-SNAPSHOT.jar.jar ./application.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "./application.jar"]