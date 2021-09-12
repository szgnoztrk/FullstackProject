FROM openjdk:8
EXPOSE 4540
ADD target/*.jar patika.jar
ENTRYPOINT ["java", "-jar", "patika.jar"]