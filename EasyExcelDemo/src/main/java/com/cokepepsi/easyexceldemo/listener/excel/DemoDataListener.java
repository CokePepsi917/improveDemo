package com.cokepepsi.easyexceldemo.listener.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cokepepsi.easyexceldemo.domain.DemoData;
import com.cokepepsi.easyexceldemo.repository.DemoDataRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CokePepsi
 * @date 2023/10/16 17:03
 */
@Component
public class DemoDataListener extends AnalysisEventListener<DemoData> {

    @Resource
    DemoDataRepository demoDataRepository;

    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        List<DemoData> all = demoDataRepository.findAll();
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
