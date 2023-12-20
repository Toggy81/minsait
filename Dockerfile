FROM maven:3.8.5-openjdk-17

WORKDIR /com/minsait/demo
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run

EXPOSE 80/tcp
EXPOSE 80/udp