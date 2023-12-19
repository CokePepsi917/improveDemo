package com.cokepepsi.streamsink.consumer.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author CokePepsi
 * @date 2023/10/31 19:43
 */
@EnableBinding(Sink.class)
public class MessageConsumer {

    @Value("${server.port}")
    private String serverPort;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者接收到的消息是:-------->" + message.getPayload() + "\t port: " + serverPort);
    }
}
