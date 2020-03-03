package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by liuke on 2019/12/27 10:41
 *
 *
 *  单词拆分
 *  给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 *  说明：
 *
 *  拆分时可以重复使用字典中的单词。
 *  你可以假设字典中没有重复的单词。
 *  示例 1：
 *
 *  输入: s = "leetcode", wordDict = ["leet", "code"]
 *  输出: true
 *  解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *  示例 2：
 *
 *  输入: s = "applepenapple", wordDict = ["apple", "pen"]
 *  输出: true
 *  解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *  注意你可以重复使用字典中的单词。
 *  示例 3：
 *
 *  输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 *  输出: false
 *
 * 方法一：dfs
 * wordDict为下一步所能走点位置
 *
 * 方法二：带记忆的dfs
 * 用一个数组记录之前能够成功的位置
 *
 * 方法三：
 *
 * */
public class WordBreak {

  public static boolean isExist = false;

  public boolean wordBreak(String s, List<String> wordDict) {
    return dfsSearch(s,wordDict,0, new Boolean [s.length()]);
  }

  public boolean dfsSearch(String s, List<String> wordDic, int start, Boolean [] temp) {
    if (start == s.length()) {
      return true;
    }
    if (temp[start] != null) {
      return temp[start];
    }

    for (int i = 0; i < wordDic.size(); i++) {
      if (isMatchStart(s,start,wordDic.get(i))) {
        return temp[start] = dfsSearch(s,wordDic,start+wordDic.get(i).length(),temp);
      }
    }
    return false;
  }

  public boolean isMatchStart(String s, int start, String dic) {
    if (start+dic.length() <= s.length() && s.substring(start, start + dic.length()).equals(dic)) {
      return true;
    } else {
      return false;
    }
  }

  // catsanddog
  public boolean wordBreak3(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet<>(wordDict);
    Queue<Integer> startQueue = new LinkedList<>();
    boolean [] visited = new boolean[s.length()+1];
    startQueue.add(0);
    while (!startQueue.isEmpty()) {
      Integer start = startQueue.poll();
      if (!visited[start]) {
        for (int end = start+1; end <= s.length(); end++) {
          if (wordDictSet.contains(s.substring(start,end))) {
            startQueue.add(end);
            if (end == s.length()) {
              return true;
            }
          }
        }
        visited[start] = true;
      }
    }
    return false;
  }

  public boolean wordBreak4(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet<>(wordDict);
    boolean [] dp = new boolean[s.length()+1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    //
    String s = "catsandog";
    List<String> wordDic = new ArrayList<>();
    wordDic.add("cats");
    wordDic.add("dog");
    wordDic.add("cats");
    wordDic.add("and");
    wordDic.add("sand");
    System.out.println(new WordBreak().wordBreak4(s,wordDic));
  }
}
