package br.com.rodison.rfprecobom.rfprecobomapi.utils;

public class StringUtils {

	public static String getStringOrEmpty(String text) {
		if (text == null) {
			return "";
		}
		return text;
	}

	public static String getString(Object value) {
		if (value == null) {
			return null;
		}
		return value.toString();
	}

	public static String trim(String text) {
		if (text == null) {
			return "";
		}
		return text.trim();
	}

}
