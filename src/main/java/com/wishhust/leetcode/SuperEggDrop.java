package com.wishhust.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * 鸡蛋掉落 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。
 *
 * <p>每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * <p>你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * <p>每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * <p>你的目标是确切地知道 F 的值是多少。
 *
 * <p>无论F的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * <p>示例 1：
 *
 * <p>输入：K = 1, N = 2 输出：2 解释： 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。 示例 2：
 *
 * <p>输入：K = 2, N = 6 输出：3 示例 3：
 *
 * <p>输入：K = 3, N = 14 输出：4
 */
public class SuperEggDrop {

  // 递归解
  public int search(int K, int N) {
    if (K == 1 || N == 0 || N == 1) {
      return N;
    }
    int result = Integer.MAX_VALUE;
    for (int i = 1; i <= N; i++) {
      result = Math.min(result, Math.max(search(K - 1, i - 1), search(K, N - i)) + 1);
    }
    return result;
  }

  public int superEggDrop(int K, int N) {
    if (K == 1 || N == 0 || N == 1) {
      return N;
    }
    return search(K, N);
  }

  //空间换时间
  public int superEggDrop2(int K, int N) {
    if (K == 1 || N == 0 || N == 1) {
      return N;
    }
    int temp[][] = new int [K+1][N+1];
    for(int i = 1; i <= N; i++) {
      temp[1][i] = i;
    }
    int ret = 0;
    for(int i = 2; i <= K; i++) {  // i(2-K)个鸡蛋
      for (int j = 1; j <= N; j++) {  // j(1-N)层楼
        ret = Integer.MAX_VALUE;
        for(int k = 1; k <= j; k++) {  // 实际扔鸡蛋层(1-j)
          ret = Math.min(ret, Math.max(temp[i-1][k-1],temp[i][j-k])+1);
        }
        temp[i][j] = ret;
      }
    }
    return temp[K][N];
  }

  Map<Integer, Integer> cache = new HashMap<>();

  public int superEggDrop3(int K, int N) {
    if (N == 0)
      return 0;
    else if (K == 1)
      return N;

    // 记录中间结果
    Integer key = N * 1000 + K; // K <= 100
    if (cache.containsKey(key))
      return cache.get(key);

    int low = 1, high = N;
    while (low + 1 < high) {
      int middle = (low + high) / 2;
      int lowVal = superEggDrop3(K - 1, middle - 1);
      int highVal = superEggDrop3(K, N - middle);

      if (lowVal < highVal)
        low = middle;
      else if (lowVal > highVal)
        high = middle;
      else
        low = high = middle;
    }
    int minimum = 1 + Math.min(
        Math.max(superEggDrop3(K - 1, low - 1), superEggDrop3(K, N - low)),
        Math.max(superEggDrop3(K - 1, high - 1), superEggDrop3(K, N - high))
    );

    cache.put(key, minimum);

    return cache.get(key);
  }


  public static void main(String[] args) {
    int i = new SuperEggDrop().superEggDrop3(2, 6);
    System.out.println(i);
  }
}
