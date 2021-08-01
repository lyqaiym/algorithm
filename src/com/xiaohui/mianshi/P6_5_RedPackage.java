package com.xiaohui.mianshi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P6_5_RedPackage {

	public static List<Integer> divideRedPackage(Integer totalAmount, int totalPeopleNum) {
		List<Integer> amountList = new ArrayList<Integer>();
		Integer resetAmount = totalAmount;
		Integer resetPeopleNum = totalPeopleNum;
		Random random = new Random();
		for (int i = 0; i < totalPeopleNum - 1; i++) {
			int amount = random.nextInt(resetAmount / resetPeopleNum * 2 - 1) + 1;
			resetAmount -= amount;
			resetPeopleNum--;
			amountList.add(amount);
		}
		amountList.add(resetAmount);
		return amountList;
	}

	public static void main(String[] args) {
		List<Integer> amountList = divideRedPackage(1000, 10);
		for (int i = 0; i < amountList.size(); i++) {
			Integer amount = amountList.get(i);
			System.out.println("" + new BigDecimal(amount).divide(new BigDecimal(100)));
		}
	}

}
