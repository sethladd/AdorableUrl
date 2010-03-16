package com.adorableurl.util;

import com.adorableurl.util.AdorableConverter;

import junit.framework.TestCase;

public class AdorableConverterTest extends TestCase {
	
	public void testEncode0() {
		assertEquals("2-fluffy-bunnies-cuddle-101-adorable-unicorns", AdorableConverter.encode(0));
	}
	
	public void testEncode1() {
		assertEquals("3-fluffy-bunnies-cuddle-2-fluffy-bunnies", AdorableConverter.encode(1));
	}
	
	public void testEncodeLast() {
		assertEquals("101-adorable-unicorns-play_with-101-adorable-unicorns",
				AdorableConverter.encode(AdorableConverter.getNumCombinations()-1));
	}
	
	public void testDecode0() {
		assertEquals(0, AdorableConverter.decode("2-fluffy-bunnies-cuddle-2-fluffy-bunnies"));
	}
	
	public void testDecode1() {
		assertEquals(1, AdorableConverter.decode("3-fluffy-bunnies-cuddle-2-fluffy-bunnies"));
	}
	
	public void testDecodeLast() {
		assertEquals(AdorableConverter.getNumCombinations()-1,
				AdorableConverter.decode("101-adorable-unicorns-play_with-101-adorable-unicorns"));
	}
	
}
