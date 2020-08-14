package com.wishhust.arithmetic.leetcode;


/**
 * 反转字符串中的元音字母
 */
public class Leetcode345 {

    public static void main(String[] args) {
        System.out.println(new Leetcode345().reverseVowels("leetcode"));
    }
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;

        char[] strArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            strArray[i] = s.charAt(i);
        }

        while (left < right) {
            while (!isVowel(strArray[left])) {
                left++;
            }
            while (!isVowel(strArray[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            char temp = strArray[left];
            strArray[left] = strArray[right];
            strArray[right] = temp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < strArray.length; i++) {
            sb.append(strArray[i]);
        }
        return sb.toString();
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        } else {
            return false;
        }
    }
}
