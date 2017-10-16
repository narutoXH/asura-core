package org.asura.core.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	public static boolean isNullOrEmpty(String string) {
		return ((string == null) || (string.trim().length() == 0));
	}

	public static String getStringFromStrings(List<String> list, String spliter) {
		return getStringFromStrings((String[]) list.toArray(new String[0]), spliter);
	}

	public static String getStringFromStrings(String[] strings, String spliter) {
		if ((strings == null) || (strings.length == 0)) {
			return "";
		}
		if (spliter == null) {
			spliter = "";
		}
		StringBuffer buf = new StringBuffer();
		for (String string : strings) {
			buf.append(string);
			buf.append(spliter);
		}

		return buf.toString().substring(0, buf.toString().length() - spliter.length());
	}

	public static boolean isEnglishCharacter(char ch) {
		String a = String.valueOf(ch).toLowerCase();
		return ((a.charAt(0) >= 'a') && (a.charAt(0) <= 'z'));
	}

	public static boolean isEnglishOrNumberCharacter(char ch) {
		return ((isEnglishCharacter(ch)) || (Character.isDigit(ch)));
	}

	public static int[] getAllIndex(String source, String rex) {
		List<Integer> list = new ArrayList<>();
		int position = 0;
		while (position < source.length()) {
			int index = source.indexOf(rex, position);
			if (index <= -1)
				break;
			list.add(source.indexOf(rex, position));
			position = index + 1;
		}

		int[] ins = new int[list.size()];
		for (int i = 0; i < ins.length; ++i) {
			ins[i] = list.get(i).intValue();
		}
		return ins;
	}

	public static String[] split(String string, String rex) {
		int[] indexs = getAllIndex(string, rex);

		List<String> result = new ArrayList<>();
		for (int i = 0; i < indexs.length; ++i) {
			if (i == 0) {
				result.add(string.substring(0, indexs[i]));
			}

			if (i < indexs.length - 1) {
				result.add(string.substring(indexs[i] + rex.length(), indexs[(i + 1)]));
			} else if (i == indexs.length - 1) {
				result.add(string.substring(indexs[i] + rex.length()));
			}
		}

		if (indexs.length == 0) {
			result.add(string);
		}

		return result.toArray(new String[0]);
	}

}
