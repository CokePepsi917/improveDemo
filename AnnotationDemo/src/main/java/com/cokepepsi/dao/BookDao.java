package com.cokepepsi.dao;

import org.springframework.stereotype.Repository;

/**
 * @author CokePepsi
 * @date 2023/9/18 21:20
 */
@Repository
public class BookDao {
    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
