FROM openjdk:19-oracle
ADD target/external-api-service-1.0.jar docker-external-api-service-1.0.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","docker-external-api-service-1.0.jar"]