package com.cokepepsi.easyexceldemo.domain;


import lombok.Data;

import java.util.Date;

/**
 * @author CokePepsi
 * @date 2023/10/16 17:00
 */
@Data
public class DemoData {
    private Long id;
    private String string;
    private Date date;
    private Double doubleData;
}
