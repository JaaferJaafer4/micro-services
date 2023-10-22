FROM openjdk:8
EXPOSE 8095
ADD target/evaluationService.jar evaluationS.jar
ENTRYPOINT ["java", "-jar", "evaluationS.jar"]