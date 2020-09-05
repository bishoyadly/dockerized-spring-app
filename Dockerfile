FROM adoptopenjdk/openjdk11

WORKDIR spring-app

COPY target/*.jar app.jar

CMD ["java","-jar","app.jar"]