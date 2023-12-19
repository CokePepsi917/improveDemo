package com.cokepepsi.streamsource.producer.impl;

import com.cokepepsi.streamsource.messaging.StreamSource;
import com.cokepepsi.streamsource.producer.IMessageProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author CokePepsi
 * @date 2023/10/30 19:23
 */
//@EnableBinding(Source.class) //定义消息的推送管道====>类似于思维图的三个管道柱子
@EnableBinding(StreamSource.class)
public class MessageProducer implements IMessageProducer {

    @Resource
    private MessageChannel streamOutput; //消息发送管道


    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        String serialFinal = serial + "最终的消息";
        streamOutput.send(MessageBuilder.withPayload(serialFinal).build());
        System.out.println("发送的消息是 ***** serial : " + serialFinal);
        return null;
    }
}
