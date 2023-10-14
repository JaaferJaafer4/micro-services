FROM openjdk:8
EXPOSE 9022
ADD target/userService.jar userS.jar
ENTRYPOINT ["java", "-jar", "userS.jar"]