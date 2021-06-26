package com.xiaohui.mianshi;

public class P5_6_MaxSort {
    public static int gettMaxSortedDistance(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        if (d == 0) {
            return 0;
        }
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
//        for (int i = 0; i < bucketNum; i++) {
//            buckets[i] = new Bucket();
//        }
        for (int i = 0; i < bucketNum; i++) {
            int index = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[index] == null) {
                buckets[index] = new Bucket();
            }
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] == null) {
//                System.out.println("min=null,max=" + buckets[i].max);
                System.out.println("buckets[" + i + "]=null");
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 6, 3, 4, 5, 10, 9};
        System.out.println(gettMaxSortedDistance(array));
    }

    private static class Bucket {
        Integer max;
        Integer min;
    }
}
