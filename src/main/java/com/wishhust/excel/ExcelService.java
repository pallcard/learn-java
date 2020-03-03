package com.wishhust.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.wishhust.excel.model.StudentModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {

  public static void main(String[] args) throws IOException {

    File file = new File("C:\\Users\\Administrator\\Desktop\\excel.xlsx");

    // 获取excel表格
    List<StudentModel> stuExcelList = new ExcelService().readExcel(file, new ExcelDataListener<>(), StudentModel.class);

    List<StudentModel> list = new ArrayList<>();
    new ExcelService().downExcel(null, "",  list, StudentModel.class);
  }

  /**
   * 通用读excel表格
   *
   * @param file  excel原文件
   * @param listener  excel处理监听器
   * @param cls 每一行模型的类
   * @param <T>
   * @return
   * @throws IOException
   */
  public <T> List<T> readExcel(File file, ExcelDataListener<T> listener,
      Class<? extends BaseRowModel > cls) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(file);
    ExcelReader reader = EasyExcelFactory.getReader(fileInputStream, listener);
    List<Sheet> sheets = reader.getSheets();
    for (Sheet sheet : sheets) {
      sheet.setHeadLineMun(1);
      sheet.setClazz(cls);
      reader.read(sheet);
    }
    //关闭资源
    fileInputStream.close();
    return listener.getData();
  }

  public void downExcel(HttpServletResponse response, String fileName,
      List<? extends BaseRowModel> listObject,
      Class<? extends BaseRowModel> cls) throws IOException {
    ServletOutputStream out = response.getOutputStream();
    response.setContentType("multipart/form-data");
    response.setCharacterEncoding("utf-8");
    response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
    ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
    Sheet sheet1 = new Sheet(1, 0, cls);
    sheet1.setSheetName("sheet1");
    writer.write(listObject, sheet1);
    writer.finish();
    out.flush();
  }
}
