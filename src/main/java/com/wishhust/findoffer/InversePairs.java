package com.wishhust.findoffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 */
public class InversePairs {
  public int InversePairs(int [] array) {
    int index = array.length-1;
    int count = 0;
    for (; index > 0; index--) {
      for (int i = index-1; i >= 0; i--) {
        if (array[i] > array[index]) {
          count++;
        }
      }
    }
    return count;
  }

  public int InversePairs2(int [] array) {
    int [] copy = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      copy[i] = array[i];
    }
    return inversePairsPart(array, copy, 0, array.length-1)%1000000007;
  }

  private int inversePairsPart(int [] array, int [] copy, int start, int end) {
    if (start == end) {
      return 0;
    }

    int mid = start + (end-start)/2;
    // 注意：这里参数的顺序
    int left = inversePairsPart(copy, array,  start, mid);
    int right = inversePairsPart( copy, array, mid + 1, end);

    int i = mid;
    int j = end;
    int indexCopy = end;
    int count = 0;
    while (i >= start && j >= mid+1) {
      if (array[i] > array[j]) {
        copy[indexCopy--] = array[i--];
        count += j-mid;
        if (count >= 1000000007) {
          count %= 1000000007;
        }
      } else {
        copy[indexCopy--] = array[j--];
      }
    }

    for (; i >= start ; i--) {
      copy[indexCopy--] = array[i];
    }
    for (; j>=mid+1; j--) {
      copy[indexCopy--] = array[j];
    }

    return (left+right+count)%1000000007;

  }

  public static void main(String[] args) {
    int i = new InversePairs().InversePairs2(new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575});
    int j = new InversePairs().InversePairs(new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575});
    System.out.println(i);
    System.out.println(j);
  }
}
