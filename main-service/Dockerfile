FROM openjdk:19-oracle
ADD target/main-service-1.0.jar docker-main-service-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-main-service-1.0.jar"]