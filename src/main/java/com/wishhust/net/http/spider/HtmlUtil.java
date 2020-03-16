package com.wishhust.net.http.spider;

/**
 * Created by liuke on 2019/12/26 18:11
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @use 获取指定HTML标签的相关内容
 */
public class HtmlUtil {

  /**
   * 获取指定HTML标签的代码及指定属性的值
   *
   * @param source  要匹配的源文本
   * @param element 标签名称
   * @param byAttr  标签的属性名称
   * @return 属性值列表
   */
  public static List<String> match(String source, String element, String byAttr) {
    List<String> result = new ArrayList<String>();
    String reg = String.format("<%s[^<>]*?\\s?%s=['\"](.*?)['\"]\\s?.*?>(.*?)</%s>", element, byAttr, element);
    Matcher m = Pattern.compile(reg).matcher(source);
    while (m.find()) {
      String elementResult = m.group(0);
      String attrResult = m.group(1);
      result.add(elementResult + VS
          + attrResult);
    }
    return result;
  }

  /**
   * 通过属性名称获取属性值
   *
   * @param source  要匹配的源文本
   * @param element 标签名称
   * @param byAttr  标签的属性名称
   * @return 属性值
   */
  public static String getAttrValueByAttr(String source, String element, String byAttr) {
    String result = "";
    String reg = String.format("<%s[^<>]*?\\s?%s=['\"](.*?)['\"]\\s?.*?>(.*?)</%s>", element, byAttr, element);
    Matcher m = Pattern.compile(reg).matcher(source);
    while (m.find()) {
      result = m.group(1);
    }
    return result;
  }

  /**
   * 根据指定的属性值获取指定的其他属性值
   *
   * @param htmlCode  网页源代码
   * @param element   标签名称
   * @param byAttr1   指定的属性名称
   * @param attrValue 指定的属性值
   * @param byAttr2   指定的其他属性名称
   * @return 指定的其他属性值
   */
  public static String getAttrValue(String htmlCode, String element, String byAttr1, String attrValue, String byAttr2) {
    List<String> list = match(htmlCode, element, byAttr1);
    String tempr = "";
    for (int i = 0; i < list.size(); i++) {
      String tempResult = list.get(i);
      String[] temp = tempResult
          .split(VS);
      if (temp[1].equals(attrValue)) {
        tempr = getAttrValueByAttr(htmlCode, element, byAttr2);
      }
    }
    return tempr;
  }

  /**
   * 根据指定属性获取指定html标签的代码
   *
   * @param htmlCode  网页源代码
   * @param element   标签名称
   * @param byAttr    属性名称
   * @param attrValue 属性值
   * @return 指定html标签的代码
   */
  public static String getElementById(String htmlCode, String element, String byAttr, String attrValue) {
    List<String> list = match(htmlCode, element, byAttr);
    String tempr = "";
    for (int i = 0; i < list.size(); i++) {
      String tempResult = list.get(i);
      String[] temp = tempResult
          .split(VS);
//            System.out.println("--------> " + (i + 1) + ". " + list.get(i));
      if (temp[1].equals(attrValue)) {
//                System.out.println("内部打印    " + temp[0]);
        tempr = temp[0];
      }
    }
    return tempr;
  }

  /**
   * 获取指定标签包含的内容
   *
   * @param htmlCode  网页源代码
   * @param element   标签名称
   * @param byAttr    属性
   * @param attrValue 属性值
   * @return 指定标签包含的内容
   */
  public static String getElementValueByAttr(String htmlCode, String element, String byAttr, String attrValue) {
    String elementCode = getElementById(htmlCode, element, byAttr, attrValue);
    String regTagStart = String.format("<%s[^<>]*?\\s?%s=['\"](.*?)['\"]\\s?.*?>", element,byAttr);
    String tagStart="";
    Matcher m = Pattern.compile(regTagStart).matcher(elementCode);
    while (m.find()) {
      tagStart = m.group(0);
    }
    String regTagEnd = String.format("</%s>", element);
    String result = elementCode.replace(tagStart, "").replace(regTagEnd, "");
    return result;
  }

  /**
   * 根据已有标签代码获取标签包含的内容
   *
   * @param elementCode 标签代码
   * @param element     标签名称
   * @return 标签包含的内容
   */
  public static String getElementValueByElementCode(String elementCode, String element,String byAttr) {
    String regTagStart = String.format("<%s[^<>]*?\\s?%s=['\"](.*?)['\"]\\s?.*?>", element,byAttr);
    String tagStart="";
    Matcher m = Pattern.compile(regTagStart).matcher(elementCode);
    while (m.find()) {
      tagStart = m.group(0);
    }
    String regTagEnd = String.format("</%s>", element);
    String result = elementCode.replace(tagStart, "").replace(regTagEnd, "");
    return result;
  }

  private static String VS = "--------";//split标记自定义
}
