package com.cleverbuilder.kafkademos.camelconsumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaCamelConsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        getContext().getShutdownStrategy().setTimeout(30L);

        from("kafka:{{kafka.topic}}?brokers={{kafka.host}}:{{kafka.port}}")
                .log("Message received from Kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}");

    }
}
