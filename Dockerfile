FROM maven:3.5.2-jdk-8-alpine

EXPOSE 3000

WORKDIR /Backend

COPY . /Backend

RUN mvn install

CMD java -jar target/gs-rest-service-0.1.0.jar
