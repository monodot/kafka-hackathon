package com.cleverbuilder.kafkademos.camelproducer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.component.kafka.KafkaConstants;

@Component
public class KafkaCamelProducer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        getContext().getShutdownStrategy().setTimeout(30L);

        from("timer:mytimer?period=5000")
                .setBody(simple("Customer number ${random(1000,2000)} just bought a burger"))
                .setHeader(KafkaConstants.KEY, constant("Camel")) // Key of the message
                .log("Sending a message to Kafka...")
                .to("kafka:{{kafka.topic}}?brokers={{kafka.host}}:{{kafka.port}}");

    }
}
