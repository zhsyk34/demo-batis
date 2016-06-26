package com.cat.demo.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ValidateUtil {

	/* Array */
	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	public static boolean isNotEmpty(Object[] array) {
		return !isEmpty(array);
	}

	/* primary key */
	public static boolean isPK(Integer key) {
		return key != null && key > 0;
	}

	/* array contains obj */// TODO
	public static boolean indexOf(Object[] array, Object obj) {
		if (isEmpty(array) || obj == null) {
			return false;
		}
		for (Object each : array) {
			if (each.equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/* date */
	public static boolean isSimpleDate(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$");
		return pattern.matcher(str).matches();
	}

	public static boolean isWholeDate(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}$");
		return pattern.matcher(str).matches();
	}

	public static boolean isDate(String str) {
		return isSimpleDate(str) || isWholeDate(str);
	}

}
