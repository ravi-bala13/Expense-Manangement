#
# Build stage
#
FROM maven:3.8.2-jdk-8 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:8-jdk-slim
COPY --from=build /target/management-0.0.1-SNAPSHOT.jar management.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","management.jar"]