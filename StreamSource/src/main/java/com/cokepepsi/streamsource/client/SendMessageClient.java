package com.cokepepsi.streamsource.client;

import com.cokepepsi.streamsource.producer.IMessageProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CokePepsi
 * @date 2023/10/30 19:34
 */

@RestController
public class SendMessageClient {
    @Resource
    private IMessageProducer messageProducer;

    @GetMapping(value = "/send-message")
    public String sendMessage() {
        return messageProducer.send();
    }
}
