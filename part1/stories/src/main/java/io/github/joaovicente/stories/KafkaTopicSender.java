package io.github.joaovicente.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class KafkaTopicSender {
    @Autowired
    private KafkaTemplate<String, ?> kafkaTemplate;

    public void send(String topic, Object payload) {
        kafkaTemplate
                .send(MessageBuilder.withPayload(payload).setHeader(KafkaHeaders.TOPIC, topic).build());
    }
}

