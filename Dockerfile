FROM openjdk:17-jdk

WORKDIR /app

COPY target/Mealmate-0.0.1.jar  /app/Mealmate.jar

EXPOSE 8765

 CMD ["java","-jar","Mealmate.jar"]