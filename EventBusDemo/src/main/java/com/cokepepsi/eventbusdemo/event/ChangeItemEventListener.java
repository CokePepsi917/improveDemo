package com.cokepepsi.eventbusdemo.event;


import com.cokepepsi.eventbusdemo.common.BaseEvent;
import com.cokepepsi.eventbusdemo.common.ConCurrentEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author CokePepsi
 * @date 2023/9/20 14:10
 */
@Component
@Slf4j
public class ChangeItemEventListener implements ConCurrentEventListener {

    @Override
    public void onEvent(BaseEvent event) {
        ChangeItemEvent changeItemEvent = (ChangeItemEvent) event;
        //获取最大值
        Integer maxValue = changeItemEvent.getMaxValue();
        //获取旧值
        String oldValue = changeItemEvent.getOldValue();
        //获取新值
        String newValue = changeItemEvent.getNewValue();

        log.info("ChangeItemEvent发生以后....最大值是: {}", maxValue);

        log.info("ChangeItemEvent发生以前的值是:{}", oldValue);

        log.info("ChangeItemEvent发生以后的值是:{}", newValue);
    }
}
