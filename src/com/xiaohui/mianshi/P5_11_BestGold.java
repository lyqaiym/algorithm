package com.xiaohui.mianshi;

public class P5_11_BestGold {

    static int times = 0;

    public static int getBestGoldMining(int w, int n, int[] p, int[] g) {
        times++;
//        System.out.println("w=" + w + ",n=" + n);
        if (w == 0 || n == 0) {
            return 0;
        }
        if (w < p[n - 1]) {
            int best = getBestGoldMining(w, n - 1, p, g);
//            System.out.println("best=" + best);
            return best;
        }
        int left = getBestGoldMining(w, n - 1, p, g);
        int right = getBestGoldMining(w - p[n - 1], n - 1, p, g) + g[n - 1];
//        System.out.println("left=" + left + ",right=" + right);
        return Math.max(left, right);
    }

    public static int getBestGoldMiningV2(int w, int[] p, int[] g) {
        int[][] resultTable = new int[g.length + 1][w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    times++;
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    int left = resultTable[i - 1][j];
                    int right = resultTable[i - 1][j - p[i - 1]] + g[i - 1];
                    times++;
                    resultTable[i][j] = Math.max(left, right);
                }
            }
        }
        return resultTable[g.length][w];
    }

    public static int getBestGoldMiningV3(int w, int[] p, int[] g) {
        int[] result = new int[w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
//                System.out.println("MiningV3:p=" + p[i - 1]);
                if (j >= p[i - 1]) {
                    times++;
                    result[j] = Math.max(result[j], result[j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return result[w];
    }

    public static void main(String[] args) {
//        int w = 100;
//        int[] p = {5, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3};
//        int[] g = {400, 500, 200, 300, 350, 400, 500, 200, 300, 350, 400, 500, 200, 300, 350, 400, 500, 200, 300, 350, 400, 500, 200, 300, 350, 400, 500, 200, 300, 350};
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        int best = getBestGoldMining(w, g.length, p, g);
        System.out.println("best=" + best + ",t=" + times);
        times = 0;
        int best2 = getBestGoldMiningV2(w, p, g);
        System.out.println("best2=" + best2 + ",t=" + times);
        times = 0;
        int best3 = getBestGoldMiningV3(w, p, g);
        System.out.println("best3=" + best3 + ",t=" + times);
    }
}
