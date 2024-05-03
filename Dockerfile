FROM radut/openjdk-21-maven AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /app/target/*.jar /event-management-system.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/event-management-system.jar"]
