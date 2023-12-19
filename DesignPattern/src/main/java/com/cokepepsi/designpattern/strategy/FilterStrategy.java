package com.cokepepsi.designpattern.strategy;

import com.cokepepsi.designpattern.bean.Image;

/**
 * @author CokePepsi
 * @date 2023/12/19 9:47
 */
public interface FilterStrategy {

    /**
     * 应用滤镜
     * @param image 图片
     */
    void applyFilter(Image image);
}
