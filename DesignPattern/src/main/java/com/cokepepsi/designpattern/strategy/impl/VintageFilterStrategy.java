package com.cokepepsi.designpattern.strategy.impl;

import com.cokepepsi.designpattern.bean.Image;
import com.cokepepsi.designpattern.strategy.FilterStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CokePepsi
 * @date 2023/12/19 9:53
 */
public class VintageFilterStrategy implements FilterStrategy {
    Logger logger = LoggerFactory.getLogger(VintageFilterStrategy.class);
    @Override
    public void applyFilter(Image image) {
        logger.info("传入的图片是:{}", image);
        logger.info("使用怀旧滤镜进行调色");
    }
}
