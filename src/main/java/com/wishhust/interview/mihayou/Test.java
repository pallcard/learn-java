package com.wishhust.interview.mihayou;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        String[] split1 = s[0].split("/");
        //s[1]
        String[] split2 = s[2].split("/");
        int[] res = new int[2];
        if (s[1].equals("+")) {
            res[0] = Integer.parseInt(split1[0])*Integer.parseInt(split2[1])+Integer.parseInt(split2[0])*Integer.parseInt(split1[1]);
            res[1] = Integer.parseInt(split1[1]) * Integer.parseInt(split2[1]);
        } else if (s[1].equals("-")) {
            res[0] = Integer.parseInt(split1[0])*Integer.parseInt(split2[1])-Integer.parseInt(split2[0])*Integer.parseInt(split1[1]);
            res[1] = Integer.parseInt(split1[1]) * Integer.parseInt(split2[1]);
        } else if (s[1].equals("*")) {
            // b/a + d/c
            res[0] = Integer.parseInt(split1[0]) * Integer.parseInt(split2[0]);
            res[1] = Integer.parseInt(split1[1]) * Integer.parseInt(split2[1]);
        } else if (s[1].equals("/")) {
            res[0] = Integer.parseInt(split1[0]) * Integer.parseInt(split2[1]);
            res[1] = Integer.parseInt(split1[1]) * Integer.parseInt(split2[0]);
        }
        int gcd = gcd(res[0], res[1]);
        if (res[1]/gcd < 0) {
            System.out.println(-1*res[0]/gcd + "/" + res[1]/gcd*(-1));
        }else {
            System.out.println(res[0]/gcd + "/" +res[1]/gcd);
        }


    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
