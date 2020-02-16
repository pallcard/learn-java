package com.wishhust.findoffer;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DuplicateInArray {
  // Parameters:
  //    numbers:     an array of integers
  //    length:      the length of array numbers
  //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
  //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
  //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
  // Return value:       true if the input is valid, and there are some duplications in the array number
  //                     otherwise false
  public boolean duplicate(int numbers[],int length,int [] duplication) {
    int [] array = new int[length+1];
    for (int i = 0; i < length; i++) {
      if (array[numbers[i]] == 0) {
        array[numbers[i]]++;
      } else{
        duplication[0] = numbers[i];
        return true;
      }
    }
    return false;
  }

//   优化点：直接在原数组上操作，不用开辟新空间
  public boolean duplicate2(int numbers[], int length, int [] duplication) {
    int index = 0;
    while (index < length) {
      if (numbers[index] == index) {
        index++;
      } else if (numbers[index] == numbers[numbers[index]]) {
        duplication[0] = numbers[index];
        return true;
      } else {
//        numbers[index] 已经改变了
//        int temp = numbers[index];
//        numbers[index] = numbers[numbers[index]];
//        numbers[numbers[index]] = temp;
        int temp = numbers[index];
        numbers[index] = numbers[temp];
        numbers[temp] = temp;
      }
    }
    return false;
  }

  // 剑指offer解法
  public boolean duplicate3(int numbers[], int length, int [] duplication) {
    for (int i = 0; i < length; i++) {
      while (numbers[i] != i) {
        if (numbers[i] == numbers[numbers[i]]) {
          duplication[0] = numbers[i];
          return true;
        }
        int temp = numbers[i];
        numbers[i] = numbers[temp];
        numbers[temp] = temp;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int [] result = new int[1];
    boolean duplicate = new DuplicateInArray().duplicate(new int[]{2, 4, 3, 1, 4}, 5, result);
    System.out.println(duplicate);
  }
}
