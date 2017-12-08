package com.cleverbuilder.kafkademos.camelkafkaclient;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.component.kafka.KafkaConstants;

@Component
public class KafkaClientRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        getContext().getShutdownStrategy().setTimeout(30L);

        from("timer:mytimer?period=5000")
                .setBody(constant("Message from Camel"))          // Message to send
                .setHeader(KafkaConstants.KEY, constant("Camel")) // Key of the message
                .to("kafka:{{kafka.topic}}?brokers={{kafka.host}}:{{kafka.port}}");

    }
}