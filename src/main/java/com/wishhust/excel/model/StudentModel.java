package com.wishhust.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class StudentModel extends BaseRowModel {
  @ExcelProperty(value = "姓名", index = 0)
  private String name;
  @ExcelProperty(value = "年龄", index = 1)
  private String age;
}
