package com.xiaohui.mianshi;

import java.math.BigInteger;

public class P5_10_BigSum {
    public static String bigMumberSum(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        System.out.println("bigMumberSum:maxLength=" + maxLength);
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < a.length(); i++) {
            arrayA[i] = a.charAt(a.length() - 1 - i) - '0';
        }
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < b.length(); i++) {
            arrayB[i] = b.charAt(b.length() - 1 - i) - '0';
        }
        int[] result = new int[maxLength + 1];
        System.out.println("bigMumberSum:result=" + result.length);
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            System.out.print("" + result[i]);
            sb.append(result[i]);
        }
        System.out.println();
        return sb.toString();
    }

    public static void main(String[] args) {
//        String a = "426709752318";
//        String b = "95481253129";
        String a = "10000004695522985100000046955229";
        String b = "91000004695522985100000046955229";
        System.out.println("a.length=" + a.length());
        System.out.println("1\t" + bigMumberSum(a, b));
        System.out.println("2\t" + bigMumberSum2(a, b));
        System.out.println("3\t" + new BigInteger(a).add(new BigInteger(b)));
    }

    public static String bigMumberSum2(String a, String b) {
        int maxA = a.length();
        int maxB = b.length();
        int maxLength = Math.max(maxA, maxB);
        int num9 = maxLength / 9;
        if (maxLength % 9 != 0) {
            num9++;
        }
        int[] num9A = new int[num9];
        int[] num9B = new int[num9];
//        System.out.println("bigMumberSum2:maxLength=" + maxLength + ",num9=" + num9);
        for (int i = 0; i < num9; i++) {
            a = getString(a, num9A, i);
            b = getString(b, num9B, i);
        }
        //打印A
//        for (int i = num9 - 1; i >= 0; i--) {
//            int num = num9A[i];
//            System.out.print(num + ",");
//        }
//        System.out.println();
//        //打印B
//        for (int i = num9 - 1; i >= 0; i--) {
//            int num = num9B[i];
//            System.out.print(num + ",");
//        }
//        System.out.println();
        //add
        int last = 0;
        for (int i = 0; i < num9; i++) {
            int numa = num9A[i];
            int numb = num9B[i];
            int sum = numa + numb;
            if (last == 1) {
                sum += 1;
                last = 0;
            }
//            System.out.println("sum1=" + sum);
            if (sum > 999999999) {
                sum = sum - 999999999 - 1;
                last = 1;
            }
//            System.out.println("sum2=" + sum + ",last=" + last);
            num9A[i] = sum;
        }
        if (last == 1) {
            num9A[0] += 1;
        }
        //打印add A
        StringBuilder sb = new StringBuilder();
        for (int i = num9 - 1; i >= 0; i--) {
            int num = num9A[i];
//            System.out.println("bigMumberSum2:num=" + num);
            if (i != num9 - 1) {
                int len = ("" + num).length();
                for (int j = 0; j < 9 - len; j++) {
                    sb.append("0");
                }
            }
            sb.append(num);
        }
        return sb.toString();
    }

    private static String getString(String a, int[] num9A, int i) {
        if (a.length() > 9) {
            String s = a.substring(a.length() - 9);
            num9A[i] = Integer.parseInt(s);
            a = a.substring(0, a.length() - 9);
        } else if (a.length() > 0) {
            num9A[i] = Integer.parseInt(a);
            a = "";
        } else {
            num9A[i] = 0;
        }
        return a;
    }
}
