package com.cat.demo.util;

import org.apache.commons.lang3.RandomUtils;

import com.cat.demo.constant.DictEnum.GridType;

public class RandomUtil {

	public static <T> T RandomEnum(Class<T> clazz) {
		T[] enums = clazz.getEnumConstants();
		if (enums == null) {
			return null;
		}
		return enums[RandomUtils.nextInt(0, enums.length)];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(RandomUtil.RandomEnum(GridType.class));
		}
	}
}
