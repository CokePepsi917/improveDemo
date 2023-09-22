package com.cokepepsi.eventbusdemo;

import com.cokepepsi.eventbusdemo.event.ChangeItemEvent;
import com.cokepepsi.eventbusdemo.event.ChangeItemEventBus;
import com.cokepepsi.eventbusdemo.event.ChangeItemEventListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author CokePepsi
 * @date 2023/9/20 16:55
 */
@SpringBootTest(classes = EventBusDemoApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class ChangeItemEventTest {

    @Test
    public void testChangeItemEvent() throws InterruptedException {
        System.out.println("正在处理主线任务-----phonk_music");
        ChangeItemEvent changeItemEvent = ChangeItemEvent.builder()
                .maxValue(Integer.MAX_VALUE)
                .oldValue("Integer的最大值是多少")
                .newValue("两万多!(自信)")
                .build();
        System.out.println("主线任务处理完毕----Jenkins构建出错咯");


        log.info("ChangeItemEvent事件 创建完毕...{}",changeItemEvent);
        log.info("====================还未订阅==========================");

        changeItemEventBus.register(changeItemEventListener);
        log.info("changeItemEventListener 订阅 ChangeItemEventBus");

        log.info("====================changeItemEventBus还未发布事件==========================");

        new Thread(() -> {
            changeItemEventBus.post(changeItemEvent);
            log.info("异步发布");
        },"异步发布事件--changeItemEvent").start();
        Thread.sleep(1000);
        log.info("====================changeItemEventBus已经发布事件==========================");
    }


    @Resource
    ChangeItemEventBus changeItemEventBus;

    @Resource
    ChangeItemEventListener changeItemEventListener;
}
