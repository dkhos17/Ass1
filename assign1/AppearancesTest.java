package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	
	@Test
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}
	
	@Test
	public void testSameCount3() {
		// basic List<Integer> cases
		List<Character> a = Arrays.asList('a', 'b', 'b', 'z', 'z', 'z', 'e');
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(' ')));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList('a', 'a', 'a', 'z', 't', 'z', 't', 'c', 'z')));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList('a', 'b', 'a', 'c', 'c', 'b')));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList('x', 'y', 'z', 'm', 'n', 'o', 'p')));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList('s', 's', 's', 's', 's', 's', 's')));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList('a', 'b', 'b', 'z', 'z', 'z', 'e', 'a', 'b', 'z', 'e')));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList('a', 'b', 'b', 'z', 'z', 'z', 'e', 'a', 'b', 'z')));
		assertEquals(4, Appearances.sameCount(a, Arrays.asList('b', 'b', 'z', 'z', 'z', 'a', 'e')));
	}
	
	@Test
	public void testSameCount4() {
		// basic List<Integer> cases
		List<String> a = Arrays.asList("abc", "bca", "bac", "cba", "cab", "acb", "azts");
		assertEquals(1, Appearances.sameCount(a, Arrays.asList("", "a", "ab", "ba", "abc")));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList("st", "az", "za", "ts")));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList("abc", "bca", "")));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList("", "a", "b", "abc")));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList("abc", "abb", "acc", "bca")));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList("aaa", "bbb", "ccc")));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList("a", "b", "c")));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList("abcb", "bacb", "cbab", "azst", "azts", "cbk", "bac")));
		assertEquals(5, Appearances.sameCount(a, Arrays.asList("abc", "bca", "cba", "cab", "azts", "adc")));
		List<String> c = new ArrayList<String>();
		assertEquals(0, Appearances.sameCount(c, Arrays.asList("abc", "bca", "cba", "cab", "azts", "adc")));
	}
	
	// TODO Add more tests
}
