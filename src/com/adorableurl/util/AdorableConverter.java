package com.adorableurl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("unchecked")
public final class AdorableConverter {
	
	public static final List<String> NUMBERS = new ArrayList<String>(100);
	static {
		for (int i = 0; i < 100; i++) {
			NUMBERS.add(String.valueOf(i+2));
		}
	}
	
	public static final List<String> ADJECTIVES = Arrays.asList(
		"fluffy",
		"pink",
		"cuddly",
		"adorable"
	);
	
	public static final List<String> NOUNS = Arrays.asList(
		"bunnies",
		"kitties",
		"puppies",
		"unicorns"
	);
	
	public static final List<String> VERBS = Arrays.asList(
		"cuddle",
		"hug",
		"kiss",
		"smooch",
		"nap_with",
		"play_with"
	);
	
	public static final List<List<String>> TERMS = Arrays.asList(
			NUMBERS,
			ADJECTIVES,
			NOUNS,
			VERBS,
			NUMBERS,
			ADJECTIVES,
			NOUNS
	);
	
	public final static String encode(long number) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TERMS.size(); i++) {
			final List terms = TERMS.get(i);
			sb.append(terms.get((int) (number % terms.size())));
			number /= terms.size();
			
			if (i < TERMS.size()-1) {
				sb.append("-");
			}
		}
		return sb.toString();
	}
	
	public final static long decode(String slug) {
		final String[] parts = slug.split("-");
		int multiplier = 1;
		long result = 0;
		for (int i = 0; i < parts.length; i++) {
			result += TERMS.get(i).indexOf(parts[i]) * multiplier;
			multiplier *= TERMS.get(i).size();
		}
		return result;
	}
	
	public final static long getNumCombinations() {
		long answers = 1;
		for (int i = 0; i < TERMS.size(); i++) {
			answers *= TERMS.get(i).size();
		}
		return answers;
	}

}
