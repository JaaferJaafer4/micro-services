FROM openjdk:8
EXPOSE 9020
ADD target/apiGateway.jar apiG.jar
ENTRYPOINT ["java", "-jar", "apiG.jar"]