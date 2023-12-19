package com.cokepepsi.designpattern;

import com.cokepepsi.designpattern.bean.Image;
import com.cokepepsi.designpattern.context.FilterContext;
import com.cokepepsi.designpattern.context.FilterEnumContext;
import com.cokepepsi.designpattern.strategy.FilterStrategy;
import com.cokepepsi.designpattern.strategy.impl.BlackAndWhiteFilterStrategy;
import com.cokepepsi.designpattern.strategy.impl.VintageFilterStrategy;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author CokePepsi
 * @date 2023/12/19 10:11
 */

class StrategyTest {
    Logger logger = LoggerFactory.getLogger(StrategyTest.class);

    @Test
    void testStrategy() {
        //创建图片
        Image image = new Image();
        //创建上下文对象, 承接上下, 屏蔽策略细节
        FilterContext filterContext = new FilterContext();
        //使用黑白滤镜
        filterContext.setFilterStrategy(new BlackAndWhiteFilterStrategy());

        //使用怀旧滤镜
        filterContext.setFilterStrategy(new VintageFilterStrategy());
        filterContext.applyFilter(image);
    }

    @Test
    void testStaticStrategy() throws Exception {
        //创建图片
        Image image = new Image();
        //创建上下文对象, 承接上下, 屏蔽策略细节
        FilterContext filterContext = new FilterContext();
        //使用黑白滤镜
        Field strategyFiled = FilterContext.class.getDeclaredField("FILTER_STRATEGY_HASH_MAP");
        logger.info(String.valueOf(strategyFiled));
        strategyFiled.setAccessible(true);
        Object filterMapObject = strategyFiled.get(null);
        HashMap<String, FilterStrategy> strategyHashMap = null;
        if (filterMapObject instanceof HashMap) {
            strategyHashMap = (HashMap<String, FilterStrategy>) filterMapObject;
            filterContext.setFilterStrategy(strategyHashMap.get("blackAndWhite"));
        } else {
            throw new IllegalStateException("The field is not of type HashMap<String, FilterStrategy>");
        }
        filterContext.setFilterStrategy(strategyHashMap.get("blackAndWhite"));
        filterContext.applyFilter(image);
    }


    @Test
    void tesEnumStrategy() {
        Image image = new Image();
        logger.info("对照片使用黑白滤镜");
        FilterEnumContext.BLACK_AND_WHITE.applyFilter(image);

        logger.info("对照片使用复古滤镜");
        FilterEnumContext.VINTAGE.applyFilter(image);
    }
}
