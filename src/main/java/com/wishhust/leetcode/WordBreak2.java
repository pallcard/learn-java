package com.wishhust.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 单词拆分 II 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子， 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。 示例 1：
 * <p>
 * 输入: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"] 输出: [ "cats and dog", "cat
 * sand dog" ] 示例 2：
 * <p>
 * 输入: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen", "pine", "pineapple"] 输出: [
 * "pine apple pen apple", "pineapple pen apple", "pine applepen apple" ] 解释: 注意你可以重复使用字典中的单词。 示例
 * 3：
 * <p>
 * 输入: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: []
 */
public class WordBreak2 {

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> ret = new ArrayList<>();
    dfs(s, wordDict, 0, ret, new StringBuilder());
    return ret;
  }

  public void dfs(String s, List<String> wordDict, int start, List<String> list, StringBuilder sb) {
    if (s.length() == start) {
      list.add(sb.substring(0, sb.length() - 1));
      return;
    }

    for (int i = 0; i < wordDict.size(); i++) {
      if (isMatchStart(s, start, wordDict.get(i))) {
        sb.append(wordDict.get(i) + " ");
        dfs(s, wordDict, start + wordDict.get(i).length(), list, sb);
        sb = sb.delete(sb.length()-wordDict.get(i).length()-1, sb.length());
      }
    }
  }

  public boolean isMatchStart(String s, int start, String dic) {
    if (start + dic.length() <= s.length() && s.substring(start, start + dic.length())
        .equals(dic)) {
      return true;
    } else {
      return false;
    }
  }

  public List<String> wordBreak2(String s, List<String> wordDict) {
    List<String> ret = new ArrayList<>();
    Set<String> wordDictSet = new HashSet<>(wordDict);
    Queue<StringBuilder> startQueue = new LinkedList<>();
    startQueue.add(new StringBuilder());

    boolean [] visited = new boolean[s.length()+1];

    while (!startQueue.isEmpty()) {
      StringBuilder head = startQueue.peek();
      Integer start = head.toString().replaceAll(" ","").length();
      if (start == s.replaceAll(" ","").length()) {
        ret.add(startQueue.poll().toString().trim());
      } else {
        startQueue.poll();
      }
      if (!visited[start]) {
        for (int end = start+1; end <= s.length(); end++) {
          if (wordDictSet.contains(s.substring(start, end))) {
            head.append(" ");
            head.append(s, start, end);
            startQueue.add(new StringBuilder(head));
            head.delete(head.lastIndexOf(" "), head.length());
          }
        }
      }
    }
    return ret;
  }

  public List<String> wordBreak3(String s, List<String> wordDict) {
    LinkedList<String> [] dp = new LinkedList[s.length()+1];
    LinkedList<String> initial = new LinkedList<>();
    initial.add("");
    for (int end = 1; end <= s.length(); end++) {
      LinkedList<String> temp = new LinkedList<>();
      for (int start = 0; start < end; start++) {
        if (dp[start].size()>0 && wordDict.contains(s.substring(start, end))) {
          for (String l : dp[start]) {
            dp[start].add( l + (l.equals("")? "" : " ") )
          }
        }
      }
    }
  }



  public static void main(String[] args) {
    String s = "catsanddog";
    List<String> wordDic = new ArrayList<>();
    wordDic.add("cat");
    wordDic.add("sand");
    wordDic.add("cats");
    wordDic.add("and");
    wordDic.add("dog");
    System.out.println(new WordBreak2().wordBreak(s, wordDic));
    System.out.println(new WordBreak2().wordBreak(s, wordDic).size());
    System.out.println(new WordBreak2().wordBreak2(s, wordDic));
    System.out.println(new WordBreak2().wordBreak2(s, wordDic).size());
    System.out.println(new WordBreak2().wordBreak3(s, wordDic));
    System.out.println(new WordBreak2().wordBreak3(s, wordDic).size());
  }

}
