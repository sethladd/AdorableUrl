package com.adorableurl.util;

import java.util.HashMap;
import java.util.Map;

public final class AdorableConverter {

	public static final String[] TERMS = {
		"kittens",
		"pink",
		"puppies",
		"rainbows",
		"flowers",
		"cute",
		"adorable",
		"babies",
		"teddybears",
		"cupcakes",
		"ribbons",
		"lilac",
		"cat",
		"baby",
		"hugs",
		"kisses",
		"nuzzle",
		"love",
		"affection",
		"pets",
		"pandas",
		"napping",
		"kissing",
		"little",
		"tiny",
		"cuddly",
		"sweet",
		"unicorns",
		"darling",
		"delightful",
		"cats",
		"dogs",
		"kitten",
		"puppy",
		"daises",
		"roses"
	};
	
	public static final Map<String, String> CODE_TO_TERM = new HashMap<String, String>();
	public static final Map<String, String> TERM_TO_CODE = new HashMap<String, String>();
	
	static {
		for (int i = 0; i < 36; i++) {
			CODE_TO_TERM.put(Long.toString(i, 36), TERMS[i]);
			TERM_TO_CODE.put(TERMS[i], Long.toString(i, 36));
		}
	}
	
	public final static String encode(long number) {
		String base36 = Long.toString(number, 36);
		int conversionLength = Math.min(6, base36.length());
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < conversionLength) {
			sb.append(CODE_TO_TERM.get(String.valueOf(base36.charAt(i))));
			if (i < base36.length()-1) sb.append("-");
			i++;
		}
		sb.append(base36.substring(i));
		return sb.toString();
	}
	
	public final static long decode(String code) {
		String[] parts = code.split("-");
		StringBuilder sb = new StringBuilder();
		int length = parts.length;
		for (int i = 0; i < length; i++) {
			if (i < 6) {
				sb.append(TERM_TO_CODE.get(parts[i]));
			} else {
				sb.append(parts[i]);
			}
		}
		return Long.parseLong(sb.toString(), 36);
	}
}
