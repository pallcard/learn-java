package com.wishhust.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

  public static String basePath = "src/main/java/com/wishhust/";

  /***
   * 获取指定目录下的所有的文件（不包括文件夹），采用了递归
   *
   * @param path
   * @return
   */
  public static List<String> getFiles(String path) {
    path = basePath + path;
    List<String> files = new ArrayList<>();
    File file = new File(path);
    File[] tempList = file.listFiles();

    for (int i = 0; i < tempList.length; i++) {
      if (tempList[i].isFile()) {
        files.add(tempList[i].toString());
        //文件名，不包含路径
        //String fileName = tempList[i].getName();
      }
      if (tempList[i].isDirectory()) {
        //这里就不递归了，
      }
    }
    return files;
  }


  public static void main(String[] args) {
    String path = "findoffer";
    List<String> findoffer = getFiles(path);

  }
}
