package com.xiaohui.mianshi;

public class P6_2_Bitmap {
	private long[] words;
	private int size;

	public P6_2_Bitmap(int size) {
		this.size = size;
		words = new long[size];
	}

	public boolean getBit(int bitIndex) {
		if (bitIndex < 0 || bitIndex > size - 1) {
			throw new IndexOutOfBoundsException(bitIndex + " 超过bitmap长度 " + size);
		}
		int wordIndex = getWordIndex(bitIndex);
		return (words[wordIndex] & (1L << bitIndex)) != 0;
	}

	public void setBit(int bitIndex) {
		if (bitIndex < 0 || bitIndex > size - 1) {
			throw new IndexOutOfBoundsException(bitIndex + " 超过bitmap长度 " + size);
		}
		int wordIndex = getWordIndex(bitIndex);
		words[wordIndex] |= 1L << bitIndex;
	}

	private int getWordIndex(int bitIndex) {
		return bitIndex >> 6;
//		return bitIndex;
	}

	public static void main(String[] args) {
		P6_2_Bitmap pBitmap = new P6_2_Bitmap(128);
		pBitmap.setBit(1126);
		pBitmap.setBit(75);
		System.out.println("getWordIndex:index1=" + pBitmap.getBit(126));
		System.out.println("getWordIndex:index2=" + pBitmap.getBit(78));
	}
}
