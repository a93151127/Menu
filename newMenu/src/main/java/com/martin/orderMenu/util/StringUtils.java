package com.martin.orderMenu.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtils {
	
	private static final int PAD_LIMIT = 8192;
	
	public static String leftPad(String str, int size, String padStr) {
		if(str == null) {
			return null;
		}
		if(isEmpty(padStr)) {
			padStr = " ";
		}
		
		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;
		if(pads <= 0) {
			return str;
		}
		if(padLen == 1 && pads <= PAD_LIMIT) {
			return leftPad(str, size, String.valueOf(padStr.charAt(0)));
		}
		if(pads == padLen) {
			return padStr.concat(str);
		}else if(pads < padLen) {
			return padStr.substring(0, pads).concat(str);
		}else {
			char[] padding = new char[pads];
			char[] padChars = padStr.toCharArray();
			for(int i = 0; i < pads; i++) {
				padding[i] = padChars[i % padLen];
			}
			return new String(padding).concat(str);
		}
	}
	
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
}
