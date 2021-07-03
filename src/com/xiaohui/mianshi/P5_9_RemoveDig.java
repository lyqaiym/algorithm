package com.xiaohui.mianshi;

public class P5_9_RemoveDig {
    public static String removeKDigits(String num, int k) {
        String numNew = num;
        for (int j = 0; j < k; j++) {
            boolean hasCut = false;
            for (int i = 0; i < numNew.length() - 1; i++) {
                char ic = numNew.charAt(i);
                char ic1 = numNew.charAt(i + 1);
                if (ic > ic1) {
                    System.out.println("removeKDigits:ic=" + ic + "," + ic1 + ",i=" + i);
                    numNew = numNew.substring(0, i) + numNew.substring(i + 1);
                    hasCut = true;
                    break;
                }
            }
            if (!hasCut) {
                numNew = numNew.substring(0, numNew.length() - 1);
            }
            numNew = removeZero(numNew);
        }
        if (numNew.length() == 0) {
            return "0";
        }
        return numNew;
    }

    public static String removeKDigits2(String num, int k) {
        int newLength = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                System.out.println("removeKDigits2:top1=" + top);
                top -= 1;
                k -= 1;
            }
            stack[top++] = c;
            System.out.println("removeKDigits2:top2=" + top + ",str=" + new String(stack));
        }
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }

    public static String removeZero(String num) {
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(0) != '0') {
                break;
            }
            num = num.substring(1);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits2("1593212", 1));
        System.out.println(removeKDigits2("30200", 2));
        System.out.println(removeKDigits2("1234567", 2));
        System.out.println(removeKDigits2("10", 2));
        System.out.println(removeKDigits2("541270936", 3));
    }

}
