package com.wishhust.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataListener<T> extends AnalysisEventListener<T> {
  private List<T> data = new ArrayList<>();

  public List<T> getData() {
    return data;
  }

  /**
   * 这个每一条数据解析都会来调用
   *
   * @param object  one row value.
   * @param context
   */
  @Override
  public void invoke(T object, AnalysisContext context) {
    data.add(object);
  }

  /**
   * 所有数据解析完成了 都会来调用
   *
   * @param context
   */
  @Override
  public void doAfterAllAnalysed(AnalysisContext context) {
//    log.info("数据解析完成");
  }
}

