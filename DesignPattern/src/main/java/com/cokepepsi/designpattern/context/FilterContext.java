package com.cokepepsi.designpattern.context;

import com.cokepepsi.designpattern.bean.Image;
import com.cokepepsi.designpattern.strategy.FilterStrategy;
import com.cokepepsi.designpattern.strategy.impl.BlackAndWhiteFilterStrategy;
import com.cokepepsi.designpattern.strategy.impl.VintageFilterStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CokePepsi
 * @date 2023/12/19 9:59
 */
public class FilterContext {
    protected static final Map<String, FilterStrategy> FILTER_STRATEGY_HASH_MAP = new HashMap<>();
    private FilterStrategy filterStrategy;

    static {
        FILTER_STRATEGY_HASH_MAP.put("blackAndWhite", new BlackAndWhiteFilterStrategy());
        FILTER_STRATEGY_HASH_MAP.put("Vintage", new VintageFilterStrategy());
    }
    public void setFilterStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public FilterContext(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public FilterContext() {
    }

    public void applyFilter(Image image) {
        try {
            this.filterStrategy.applyFilter(image);
        } catch (NullPointerException e) {
            throw new NullPointerException("使用滤镜时出现异常, 请确认已经选择了滤镜或者传入了正确的图片!");
        }
    }
}
