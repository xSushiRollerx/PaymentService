#
# Package stage
#
FROM openjdk:8
COPY target/paymentservice-0.0.1-SNAPSHOT.jar .
EXPOSE 8043
ENTRYPOINT ["java", "-jar", "/app.jar"]