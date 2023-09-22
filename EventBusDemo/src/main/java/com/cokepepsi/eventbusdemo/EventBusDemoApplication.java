package com.cokepepsi.eventbusdemo;

import com.cokepepsi.eventbusdemo.event.ChangeItemEvent;
import com.cokepepsi.eventbusdemo.event.ChangeItemEventBus;
import com.cokepepsi.eventbusdemo.event.ChangeItemEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class EventBusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventBusDemoApplication.class, args);
    }
}
