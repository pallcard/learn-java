package com.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuke on 2019/12/27 10:41
 *
 *
 单词拆分
 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

 说明：

 拆分时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词。
 示例 1：

 输入: s = "leetcode", wordDict = ["leet", "code"]
 输出: true
 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 示例 2：

 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 输出: true
 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 注意你可以重复使用字典中的单词。
 示例 3：

 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 输出: false
 */
public class WordBreak {

  public static boolean isExist = false;

  public boolean wordBreak(String s, List<String> wordDict) {
    dfsSearch(s,wordDict,0);
    return isExist;
  }

  public void dfsSearch(String s, List<String> wordDic, int start) {
    if (start == s.length()) {
      isExist = true;
    }

    for (int i = 0; i < wordDic.size(); i++) {
      if (isMatchStart(s,start,wordDic.get(i))) {
        dfsSearch(s,wordDic,start+wordDic.get(i).length());
      }
    }
  }

  public boolean isMatchStart(String s, int start, String dic) {
    if (start+dic.length() <= s.length() && s.substring(start, start + dic.length()).equals(dic)) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    //
    String s = "catsanddog";
    List<String> wordDic = new ArrayList<>();
    wordDic.add("cats");
    wordDic.add("dog");
    wordDic.add("cats");
    wordDic.add("and");
    wordDic.add("sand");
    System.out.println(new WordBreak().wordBreak(s,wordDic));
  }
}
