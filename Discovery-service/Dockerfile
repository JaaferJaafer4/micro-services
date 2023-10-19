FROM openjdk:8
EXPOSE 8761
ADD target/discoveryService.jar discoveryS.jar
ENTRYPOINT ["java", "-jar", "discoveryS.jar"]