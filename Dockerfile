#
# Package stage
#
FROM openjdk:1.8-jre-slim
COPY target/payment-service-1.0.jar app.jar
EXPOSE 8043
ENTRYPOINT ["java", "-jar", "/app.jar"]