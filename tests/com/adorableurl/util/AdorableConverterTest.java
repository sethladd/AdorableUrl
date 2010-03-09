package com.adorableurl.util;

import com.adorableurl.util.AdorableConverter;

import junit.framework.TestCase;

public class AdorableConverterTest extends TestCase {
	
	public void testEncode1() {
		assertEquals("pink", AdorableConverter.encode(1));
	}
	
	public void testEncode12() {
		assertEquals("cat", AdorableConverter.encode(12));
	}
	
	public void testEncode123456() {
		assertEquals("puppies-little-cupcakes-cat", AdorableConverter.encode(123456));
	}
	
	public void testEncode12345678987654321() {
		assertEquals("rainbows-baby-pandas-adorable-hugs-kissing-p9i29", AdorableConverter.encode(12345678987654321L));
	}
	
	public void testDecode1() {
		assertEquals(1, AdorableConverter.decode("pink"));
	}
	
	public void testDecode12() {
		assertEquals(12, AdorableConverter.decode("cat"));
	}
	
	public void testDecode12345678987654321() {
		assertEquals(12345678987654321L, AdorableConverter.decode("rainbows-baby-pandas-adorable-hugs-kissing-p9i29"));
	}
}
