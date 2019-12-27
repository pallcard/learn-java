package com.wishhust.http.spider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyze {

  public static void main(String[] args) throws Exception {
    String s = new Analyze().regexMain("ThreadExample.java");
    System.out.println(s);
  }

  public String regexMain(String className)
      throws Exception {
    String url="http://cs.ecs.baylor.edu/~donahoo/practical/JavaSockets2/code/"+className;
    String result = ConnectionUtil.Connect(url);
    String str = ("package com.wishhust.http.chapter4; "+result).replaceAll(" ","\n");
    File file =
        new File(
            "E:\\workspaces\\learn-java\\src\\main\\java\\com\\wishhust\\http\\chapter4\\"
                + className);
    PrintStream ps = new PrintStream(new FileOutputStream(file));
    ps.println(str);// 往文件里写入字符串

    return result;
  }


}
