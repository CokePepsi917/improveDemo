package com.cokepepsi.designpattern.context;

import com.cokepepsi.designpattern.bean.Image;
import com.cokepepsi.designpattern.strategy.impl.BlackAndWhiteFilterStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CokePepsi
 * @date 2023/12/19 13:52
 */
public enum FilterEnumContext {


    /**
     * 黑白滤镜
     */
    BLACK_AND_WHITE("blackAndWhite") {
        @Override
        public void applyFilter(Image image) {
            System.out.println("传入的图片是:"+ image);
            System.out.println("使用黑白滤镜进行调色");
        }
    },

    /**
     * 复古滤镜
     */
    VINTAGE("vintage") {
        @Override
        public void applyFilter(Image image) {
            System.out.println("传入的图片是:"+ image);
            System.out.println("使用复古滤镜进行调色");
        }
    };

    /**
     *  滤镜
     * @param image 图片
     */
    public abstract void applyFilter(Image image);

    FilterEnumContext(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    String value = "";
}
