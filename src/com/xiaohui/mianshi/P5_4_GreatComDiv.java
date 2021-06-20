package com.xiaohui.mianshi;

import java.util.concurrent.atomic.AtomicInteger;

public class P5_4_GreatComDiv {

    public int getGreatestCommonDivisorV2(int a, int b, AtomicInteger times) {
        times.incrementAndGet();
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisorV2(big % small, small, times);
    }

    public int getGreatestCommonDivisorV3(int a, int b, AtomicInteger times) {
        times.incrementAndGet();
        if (a == b) {
//            System.out.println("getGreatestCommonDivisorV3 11");
            return a;
        }
        int big = Math.max(a, b);
        int small = Math.min(a, b);
//        if (big % small == 0) {
//            System.out.println("getGreatestCommonDivisorV3 22");
//            return small;
//        }
        return getGreatestCommonDivisorV3(big - small, small, times);
    }

    public int getGreatestCommonDivisorV4(int a, int b, AtomicInteger times) {
        times.incrementAndGet();
        if (a == b) {
//            System.out.println("getGreatestCommonDivisorV4 11");
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisorV4(a >> 1, b >> 1, times) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGreatestCommonDivisorV4(a >> 1, b, times);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGreatestCommonDivisorV4(a, b >> 1, times);
        } else {
            int big = Math.max(a, b);
            int small = Math.min(a, b);
            return getGreatestCommonDivisorV4(big - small, small, times);
        }
    }

    public static void main(String[] args) {
        P5_4_GreatComDiv greatComDiv = new P5_4_GreatComDiv();
        System.out.println(greatComDiv.getGreatestCommonDivisorV2(25, 5, new AtomicInteger()));
        System.out.println(greatComDiv.getGreatestCommonDivisorV2(100, 80, new AtomicInteger()));
        System.out.println(greatComDiv.getGreatestCommonDivisorV2(27, 14, new AtomicInteger()));
        long before = System.currentTimeMillis();
        AtomicInteger times = new AtomicInteger();
        System.out.println(greatComDiv.getGreatestCommonDivisorV2(Integer.MAX_VALUE, 1, times));
        System.out.println("time1=" + (System.currentTimeMillis() - before) + ",times=" + times.get());
        System.out.println("------------------");
        System.out.println(greatComDiv.getGreatestCommonDivisorV3(25, 5, new AtomicInteger()));
        System.out.println(greatComDiv.getGreatestCommonDivisorV3(100, 80, new AtomicInteger()));
        System.out.println(greatComDiv.getGreatestCommonDivisorV3(27, 14, new AtomicInteger()));
        before = System.currentTimeMillis();
        times.set(0);
        System.out.println(greatComDiv.getGreatestCommonDivisorV3(20, 1, times));
        System.out.println("time2=" + (System.currentTimeMillis() - before) + ",times=" + times.get());
        System.out.println("------------------");
        System.out.println(greatComDiv.getGreatestCommonDivisorV4(25, 5, new AtomicInteger()));
        System.out.println(greatComDiv.getGreatestCommonDivisorV4(100, 80, new AtomicInteger()));
        System.out.println(greatComDiv.getGreatestCommonDivisorV4(27, 14, new AtomicInteger()));
        before = System.currentTimeMillis();
        times.set(0);
        System.out.println(greatComDiv.getGreatestCommonDivisorV4(Integer.MAX_VALUE, 1, times));
        System.out.println("time3=" + (System.currentTimeMillis() - before) + ",times=" + times.get());
    }

}
