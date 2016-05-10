FROM java
MAINTAINER tanmay ambre
COPY ./target/kafkaproducerapi-beta.jar /usr/local/kafkaproducerapi/
RUN ls -al /usr/local/kafkaproducerapi
RUN java -version
EXPOSE 8080
VOLUME /logs
WORKDIR /usr/local/kafkaproducerapi
ENTRYPOINT java -jar kafkaproducerapi-beta.jar
