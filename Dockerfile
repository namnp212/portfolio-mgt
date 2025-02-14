FROM amazoncorretto:17
ADD target/portfolio-service-0.0.1.jar portfolio-service-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/portfolio-service-0.0.1.jar"]