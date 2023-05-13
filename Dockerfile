FROM openjdk:17-jdk-alpine
ENTRYPOINT ["java", "-jar", "/usr/technicaltest.jar"]
EXPOSE 8080
ADD target/*.jar /usr/technicaltest.jar