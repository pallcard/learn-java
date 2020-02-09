package com.wishhust.util;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class MarkdownUtil {

  private static String baseUrl = "https://github.com/pallcard/learn-java/blob/master/";

  /**
   * 根据目录生成链接
   * @param dir
   * @return
   */
  public static String generateLink(String dir) {
    List<String> strings = generateLinkUrl(dir);
    // [1]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/findoffer/FindInArray.java "二维数组中查找"
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strings.size(); i++) {
      int start = strings.get(i).lastIndexOf(File.separator);
      int end = strings.get(i).lastIndexOf(".");
      String className = strings.get(i).substring(start+1,end);
      sb.append("[");
      sb.append(i+1);
      sb.append("]: ");
      sb.append(strings.get(i).replaceAll("\\\\","/"));
      sb.append(" \"");
      sb.append(className);
      sb.append("\"\n");
    }
    return sb.toString();
  }

  private static List<String> generateLinkUrl(String dir) {
    List<String> files = FileUtil.getFiles(dir);
    return files.stream().filter(it->it.endsWith(".java")).map(it->baseUrl+it).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    String findoffer = MarkdownUtil.generateLink("findoffer");
    System.out.println(findoffer);

//    | 14 | [矩形覆盖][nkw14]| [Java][14]
    StringBuilder sb = new StringBuilder();
    for (int i = 10; i < 70; i++) {
      sb.append("| "+i +" | [test][nkw"+i+"] | [Java]["+i+"]\n");
    }
    System.out.println(sb.toString());

    StringBuilder sb2 = new StringBuilder();
    for (int i = 10; i < 70; i++) {
      sb2.append("[nkw"+i+"]: \n");
    }
    System.out.println(sb2.toString());

  }
}
