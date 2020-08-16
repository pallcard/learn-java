package com.wishhust.arithmetic.sort;

public class QuickSort {

    public void quickSort2(int[] nums, int left, int right) {
        if (left < right) {
            int pos = quickPart(nums, left, right);
            quickSort2(nums, left, pos-1);
            quickSort2(nums, pos+1, right);
        }
    }

    public int quickPart(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (right > left && nums[right] > temp) {
                right--;
            }
            if (right > left) {
                nums[left++] = nums[right];
            }

            while (left < right && nums[left] < temp) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }

        }
        nums[left] = temp;
        return left;
    }

    public int quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] >= base) {
                j--;
            }
            while (nums[i] <= base) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        nums[left] = nums[j];
        nums[j] = base;
        quickSort(nums, left, j-1);
        quickSort(nums, j+1, right);
        return 0;
    }

    public static void main(String[] args) {
        int[] ints = {-1,2,0};
        new QuickSort().quickSort2(ints, 0, 2);
        System.out.println(ints);
    }
}
