package com.xiaohui.mianshi;

import java.util.Arrays;

public class P5_8_NearNUm {

    public static int[] findNearestNumber(int[] numbers) {
        outputNumbers(numbers);
        int index = findTransferPoint(numbers);
        if (index == 0) {
            return null;
        }
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("findNearestNumber:index=" + index);
        exchangeHead(numbersCopy, index);
        outputNumbers(numbersCopy);
        reverse(numbersCopy, index);
        outputNumbers(numbersCopy);
        return numbersCopy;
    }

    static void exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                System.out.println("exchangeHead:i=" + i + ",head=" + head + ",[]=" + numbers[i]);
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
    }

    static int[] reverse(int[] numbers, int index) {
        for (int i = index, j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[i];
            System.out.println("reverse:temp=" + temp);
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    static int findTransferPoint(int[] numbers) {
        int times = 0;
        for (int i = numbers.length - 1; i > 0; i--) {
            times++;
            if (numbers[i] > numbers[i - 1]) {
                System.out.println("findTransferPoint:i=" + i + "," + numbers[i] + "," + numbers[i - 1] + ",times=" + times);
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] numbers = {1, 2, 3, 6, 7};
        int[] numbers = {1, 3, 6, 7, 5, 4};
//        int[] numbers = {5, 5, 5, 5, 5, 5};
        for (int i = 0; i < 1; i++) {
            System.out.println("------------------");
            numbers = findNearestNumber(numbers);
            if (numbers == null) {
                System.out.println("numbers=null:i=" + i);
                break;
            }
//            outputNumbers(numbers);
        }
    }

    private static void outputNumbers(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i);
        }
        System.out.println();
    }

}
