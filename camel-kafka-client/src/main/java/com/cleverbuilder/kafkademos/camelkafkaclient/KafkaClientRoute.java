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
        from("timer:mytimer").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setBody("Test Message from Camel Kafka Component Final", String.class);
                exchange.getIn().setHeader(KafkaConstants.PARTITION_KEY, 0);
                exchange.getIn().setHeader(KafkaConstants.KEY, "1");
            }
        }).to("kafka:kafka:9092?topic=test");
    }
}