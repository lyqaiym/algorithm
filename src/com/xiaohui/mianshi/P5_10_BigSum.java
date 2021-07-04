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
        int maxLength = Math.max(a.length(), b.length());
        System.out.println("bigMumberSum2:maxLength=" + maxLength);
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < a.length(); i++) {
            arrayA[i] = a.charAt(a.length() - 1 - i) - '0';
        }
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < b.length(); i++) {
            arrayB[i] = b.charAt(b.length() - 1 - i) - '0';
        }
        int[] result = new int[maxLength + 1];
        System.out.println("bigMumberSum2:result=" + result.length);
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
//            System.out.print("" + result[i]);
            sb.append(result[i]);
        }
        System.out.println();
        return sb.toString();
    }
}
