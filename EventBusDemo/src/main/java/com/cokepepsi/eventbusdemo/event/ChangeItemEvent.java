package com.cokepepsi.eventbusdemo.event;

import com.cokepepsi.eventbusdemo.common.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author CokePepsi
 * @date 2023/9/20 14:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeItemEvent extends BaseEvent {
    //旧值
    private String oldValue;

    //新值
    private String newValue;

    //最大值
    private Integer maxValue;
}
