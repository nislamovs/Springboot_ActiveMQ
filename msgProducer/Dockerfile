FROM openjdk:8
ARG JAR_FILE=target/msgProducer-1.0.0.jar

WORKDIR application
COPY ${JAR_FILE} app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/application/app.jar"]