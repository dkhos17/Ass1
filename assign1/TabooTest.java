// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TabooTest {
	
	@Test
	public void testTaboo1() {
		List<Integer> rules = new ArrayList<>();
		Taboo tb = new Taboo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
		//assertEquals(Arrays.asList(6, 5, 4, 3, 2, 1) ,tb.reduce(Arrays.asList(6, 5, 4, 3, 2, 1)));
		assertEquals(Arrays.asList(6, 5, 4, 1, 0, 9) ,tb.noFollow(Arrays.asList(6, 5, 4, 5, 6, 7, 1, 0, 9)));
		assertEquals(Arrays.asList(0, 1, 3, 2, 1, 0) ,tb.noFollow(Arrays.asList(0, 1, 2, 3, 4, 3, 2, 1, 0)));
		assertEquals(Arrays.asList(0, 0, 0, 0, 0, 0) ,tb.noFollow(Arrays.asList(0, 0, 0, 0, 0, 0)));
		assertEquals(Arrays.asList(1, 1, 9, 9, 2, 2) ,tb.noFollow(Arrays.asList(1, 1, 9, 9, 0, 0, 2, 2, 3, 3)));
		assertEquals(Arrays.asList() ,tb.noFollow(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
		assertEquals(Arrays.asList(0) ,tb.noFollow(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
	}
	
	@Test
	public void testTaboo2() {
		List<String> rules = new ArrayList<>();
		Taboo tb = new Taboo(Arrays.asList("aa", "ab", "ac", "ad", "ac", "ab", "aa"));
		assertEquals(Arrays.asList() ,tb.noFollow(Arrays.asList("aa", "ab", "aa", "ab", "aa", "ab")));
		assertEquals(Arrays.asList("aa", "ac", "ac", "ab", "ad", "aa") ,tb.noFollow(Arrays.asList("aa", "ab", "ac", "ab", "ad", "aa")));
		assertEquals(Arrays.asList("ab", "ab") ,tb.noFollow(Arrays.asList("ab", "ac", "aa", "ac", "ab", "ac")));
		assertEquals(Arrays.asList("ab", "ad") ,tb.noFollow(Arrays.asList("ab", "ac", "aa", "ac", "ad", "ac")));
		assertEquals(Arrays.asList("ab", "ad", "aa", "ad", "ab") ,tb.noFollow(Arrays.asList("ab", "ad", "aa", "ad", "ab", "ac")));
		assertEquals(Arrays.asList("ab", "az", "ac", "ay", "ac") ,tb.noFollow(Arrays.asList("ab", "ac", "az", "ac", "ay", "ac")));
		assertEquals(Arrays.asList("ba", "bac", "aba", "bac", "bab", "aac") ,tb.noFollow(Arrays.asList("ba", "bac", "aba", "bac", "bab", "aac")));
		assertEquals(Arrays.asList("ab", "bac", "ac", "bab", "aac") ,tb.noFollow(Arrays.asList("ab", "bac", "ac", "ab", "bab", "aac")));
	}
	
	@Test
	public void testTaboo3() {
		List<Double> rules = new ArrayList<>();
		Taboo tb = new Taboo(Arrays.asList(0.11 , 0.33, 0.55, null, 0.77, 0.99, 0.33));
		assertEquals(Arrays.asList(0.55, 0.77) ,tb.noFollow(Arrays.asList(0.11 , 0.33, 0.55, 0.77, 0.99)));
		assertEquals(Arrays.asList(0.99, 0.77, 0.55, 0.33, 0.11) ,tb.noFollow(Arrays.asList(0.99, 0.77, 0.55, 0.33, 0.11)));
		assertEquals(Arrays.asList(0.2, 0.4, 0.11, 0.88) ,tb.noFollow(Arrays.asList(0.2, 0.4, 0.11, 0.33, 0.88)));
		assertEquals(Arrays.asList(0.11, 0.99, 0.22, 3.14) ,tb.noFollow(Arrays.asList(0.11, 0.33, 0.99, 0.33, 0.22, 3.14)));
		assertEquals(Arrays.asList(10.00, 0.15, 0.33, 0.99, 0.22, 3.14, 0.80, 0.99) ,tb.noFollow(Arrays.asList(10.00, 0.15, 0.33, 0.99, 0.33, 0.22, 3.14, 0.80, 0.99)));
	}
	
	@Test
	public void testTaboo4() {
		List<Character> rules = new ArrayList<>();
		Taboo tb = new Taboo(Arrays.asList('a', 'b', 'c', 'z', 'x', null, 'a', 'y', 'z'));
		assertEquals(Arrays.asList('x', 'a') ,tb.noFollow(Arrays.asList('a', 'b', 'c', 'z', 'x', 'b', 'a', 'y', 'z')));
		assertEquals(Arrays.asList('a', 'a', 'a', 'a') ,tb.noFollow(Arrays.asList('a', 'a', 'y', 'b', 'b', 'c', 'a', 'a', 'b')));
		assertEquals(Arrays.asList('b', 'x', 'z', 'z', 'a') ,tb.noFollow(Arrays.asList('b', 'x', 'z', 'z', 'x', 'a', 'b', 'y', 'z')));
		assertEquals(Arrays.asList('a', 'x', 'a') ,tb.noFollow(Arrays.asList('a', 'x', 'a')));
		assertEquals(Arrays.asList('a', 'x', 'y') ,tb.noFollow(Arrays.asList('a', 'x', 'y', 'z')));
		assertEquals(Arrays.asList('a', 'x', 't', 'm', 'x' , 'a', 'x', 'y', 'z') ,tb.noFollow(Arrays.asList('a', 'x', 't', 'm', 'x' , 'a', 'x', 'y', 'z', 'x')));
	}
	// TODO ADD TESTS
}
