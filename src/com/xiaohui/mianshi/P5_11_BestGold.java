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
		MinAndMax[][] resultTable = new MinAndMax[g.length + 1][w + 1];
		for (int i = 1; i <= g.length; i++) {
			for (int j = 1; j <= w; j++) {
//				System.out.println("getBestGoldMiningV2:ren=" + j + ",xuyao=" + p[i - 1]);
				if (j < p[i - 1]) {
					times++;
					if (resultTable[i - 1][j] == null) {
						MinAndMax minAndMax = new MinAndMax();
						resultTable[i - 1][j] = minAndMax;
					}
					resultTable[i][j] = resultTable[i - 1][j];
//					System.out.println("getBestGoldMiningV2:i=" + i + "," + resultTable[i - 1][j]);
				} else {
					if (resultTable[i - 1][j] == null) {
						MinAndMax minAndMax = new MinAndMax();
						resultTable[i - 1][j] = minAndMax;
					}
					if (resultTable[i - 1][j - p[i - 1]] == null) {
						MinAndMax minAndMax = new MinAndMax();
						resultTable[i - 1][j - p[i - 1]] = minAndMax;
					}
					int left = resultTable[i - 1][j].getMax();
					int right = resultTable[i - 1][j - p[i - 1]].getMax() + g[i - 1];
					if (j == 5 && p[i - 1] == 3) {
						System.out.println("getBestGoldMiningV2:ren=" + j + ",xuyao=" + p[i - 1]);
						System.out.println("getBestGoldMiningV2:i=" + i + ",p=" + p[i - 1] + "," + (j - p[i - 1])
								+ ",g=" + g[i - 1]);
						System.out.println("getBestGoldMiningV2:l=" + left + ",r=" + right);
					}
//					System.out.println("getBestGoldMiningV2:l=" + left + ",r=" + right);
					times++;
//					resultTable[i][j] = Math.max(left, right);
					MinAndMax minAndMax = new MinAndMax();
					minAndMax.v1 = left;
					minAndMax.v2 = right;
					resultTable[i][j] = minAndMax;
				}
			}
		}
		for (int i = 0; i < resultTable.length; i++) {
			for (int j = 0; j < resultTable[i].length; j++) {
				System.out.print(resultTable[i][j] + "\t");
			}
			System.out.println();
		}
		return resultTable[g.length][w].getMax();
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
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "\t");
		}
		System.out.println();
		return result[w];
	}

	public static void main(String[] args) {
//        int w = 100;
//        int[] p = {5, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3, 5, 3, 4, 3};
//        int[] g = {400, 500, 200, 300, 350, 400, 500, 200, 300, 350, 400, 500, 200, 300, 350, 400, 500, 200, 300, 350, 400, 500, 200, 300, 350, 400, 500, 200, 300, 350};
		int w = 10;
		int[] p = { 5, 5, 3, 4, 3 };
		int[] g = { 400, 500, 200, 300, 350 };
		int best = getBestGoldMining(w, g.length, p, g);
		System.out.println("best=" + best + ",t=" + times);
		times = 0;
		int best2 = getBestGoldMiningV2(w, p, g);
		System.out.println("best2=" + best2 + ",t=" + times);
		times = 0;
		int best3 = getBestGoldMiningV3(w, p, g);
		System.out.println("best3=" + best3 + ",t=" + times);
	}

	static class MinAndMax {
		int v1;
		int v2;

		int getMax() {
			return Math.max(v1, v2);
		}

		@Override
		public String toString() {
//			return "v1=" + v1 + ",v2=" + v2;
			return "" + getMax();
		}
	}
}
