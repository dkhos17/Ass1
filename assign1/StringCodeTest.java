// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCodeTest {
	//
	// blowup
	//
	@Test
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	@Test
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	@Test
	public void testBlowup4() {
		assertEquals("233444", StringCode.blowup("1234"));
		assertEquals("", StringCode.blowup("1"));
		assertEquals("xxx", StringCode.blowup("2x"));
		assertEquals("xxyy", StringCode.blowup("1x1y2"));
		assertEquals("abcdef", StringCode.blowup("abcdef"));
		assertEquals("aaaaaaaabcdef", StringCode.blowup("7abcdef"));
		assertEquals("abcdef", StringCode.blowup("0abcdef"));
		assertEquals("abc0def", StringCode.blowup("abc10def"));
		assertEquals("aabbccc", StringCode.blowup("aabb2c"));
		assertEquals("aabbc", StringCode.blowup("aabbc3"));
		assertEquals("aabbbccccddddd", StringCode.blowup("1a2b3c4d5"));
	}
	
	
	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}
	
	@Test
	public void testRun4() {
		assertEquals(1, StringCode.maxRun("0"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(2, StringCode.maxRun("12121313122"));
		assertEquals(4, StringCode.maxRun("22111223324444"));
	}

	// TODO Need test cases for stringIntersect
	
	@Test
	public void testIntersect1() {
		assertEquals(false, StringCode.stringIntersect("", "", 1));
		assertEquals(false, StringCode.stringIntersect("a", "b", 1));
		assertEquals(true, StringCode.stringIntersect("a", "aa", 1));
		assertEquals(false, StringCode.stringIntersect("mm", "m", 2));
		assertEquals(false, StringCode.stringIntersect("abcd", "abcdef", 5));
		assertEquals(true, StringCode.stringIntersect("aaaaaa", "aaaaaa", 4));
		assertEquals(true, StringCode.stringIntersect("mnmmn", "mmnnn", 3));
	}
	
	@Test
	public void testIntersect2() {
		assertEquals(true, StringCode.stringIntersect("qwertyuio", "qwertyuio", 1));
		assertEquals(true, StringCode.stringIntersect("abcdef", "abcdef", 2));
		assertEquals(true, StringCode.stringIntersect("abcdef", "xyzca", 1));
		assertEquals(true, StringCode.stringIntersect("bacfef", "zzaaff", 1));
		assertEquals(true, StringCode.stringIntersect("aaffccdd", "afdc", 2));
		assertEquals(true, StringCode.stringIntersect("xyzeft", "afzetkxyz", 3));
		assertEquals(true, StringCode.stringIntersect("xyzeft", "zefafzetk", 3));
	}
	@Test
	public void testIntersect3() {
		assertEquals(false, StringCode.stringIntersect("abcdef", "abcdef", 7));
		assertEquals(false, StringCode.stringIntersect("xyzeft", "afzetk", 4));
		assertEquals(false, StringCode.stringIntersect("xyzeft", "afzetk", 9));
		assertEquals(false, StringCode.stringIntersect("vbnm", "mnbv", 3));
		assertEquals(false, StringCode.stringIntersect("mnmnmn", "mmnnn", 3));
		assertEquals(false, StringCode.stringIntersect("xccccx", "xccccx", 8));
	}
	@Test
	public void testIntersect4() {
		assertEquals(true, StringCode.stringIntersect("iiiiioo", "iiio", 4));
		assertEquals(false, StringCode.stringIntersect("yyyyyy", "yyyyyyy", 7));
		assertEquals(true, StringCode.stringIntersect("kkkkkkk", "kkkkkkk", 7));
		assertEquals(false, StringCode.stringIntersect("xyzeft", "xytttttx", 3));
		assertEquals(true, StringCode.stringIntersect("xyzefto", "afpzetk", 2));
	}
	
}
