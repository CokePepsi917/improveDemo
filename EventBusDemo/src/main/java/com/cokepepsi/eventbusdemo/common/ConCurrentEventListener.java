package com.cokepepsi.eventbusdemo.common;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * @author CokePepsi
 * @date 2023/9/20 16:38
 */
public interface ConCurrentEventListener {
    @Subscribe
    @AllowConcurrentEvents
    void onEvent(BaseEvent event);
}
