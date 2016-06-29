package com.cat.demo.base;

import com.cat.demo.constant.DictEnum.GridType;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println(GridType.class.isEnum());

		System.out.println(GridType.class.getEnumConstants());

		String house = "HOUSE";
		System.out.println(Enum.valueOf(GridType.class, house));
	}
}
