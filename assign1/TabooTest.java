// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TabooTest {
	
	private <T> void fillList(List<T> elems, List<T> list) {
		for(int i = 0; i < elems.size(); i++) list.add(elems.get(i));
	}
	
	private <T> Set<T> fillSet(List<T> elems, Set<T> s) {
		s.clear();
		for(T e : elems) s.add(e);
		return s;
	}
	
	private <T> List<T> getList(Taboo<T> tb, List<T> list, List<T> elems){
		list.clear();
		fillList(elems, list);
		tb.reduce(list);
		return list;
	}
	
	@Test
	public void testTaboo1() {
		List<Integer> rules = new ArrayList<>();
		List<Integer> test = new ArrayList<>();
		fillList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), rules);
		Taboo<Integer> tb = new Taboo<Integer>(rules);
		
		assertEquals(Arrays.asList(6, 5, 4, 3, 2, 1), getList(tb, test, Arrays.asList(6, 5, 4, 3, 2, 1)));
		assertEquals(Arrays.asList(6, 5, 4, 6, 1, 0, 9), getList(tb, test, Arrays.asList(6, 5, 4, 5, 6, 7, 1, 0, 9)));
		assertEquals(Arrays.asList(0, 1, 3, 3, 2, 1, 0), getList(tb, test, Arrays.asList(0, 1, 2, 3, 4, 3, 2, 1, 0)));
		assertEquals(Arrays.asList(1, 1, 9, 9, 2, 2), getList(tb, test, Arrays.asList(1, 1, 9, 9, 0, 0, 2, 2, 3, 3)));
		assertEquals(Arrays.asList(1, 3, 5, 7, 9), getList(tb, test, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
		assertEquals(Arrays.asList(0, 1, 3, 5, 7, 9), getList(tb, test, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
		assertEquals(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), getList(tb, test, Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0)));
		
		Set<Integer> s = new HashSet<Integer>();
		assertEquals(fillSet(Arrays.asList(2), s), tb.noFollow(1));
		assertEquals(fillSet(Arrays.asList(6), s), tb.noFollow(5));
		assertEquals(fillSet(Arrays.asList(8), s), tb.noFollow(7));
		s.clear();
		assertEquals(s, tb.noFollow(0));
	}
	
	@Test
	public void testTaboo2() {
		List<String> rules = new ArrayList<>();
		List<String> test = new ArrayList<>();
		fillList(Arrays.asList("aa", "ab", "ac", "ad", "ac", "ab", "aa", null, null), rules);
		Taboo<String> tb = new Taboo<String>(rules);
		
		assertEquals(Arrays.asList("aa", "aa", "aa"), getList(tb, test, Arrays.asList("aa", "ab", "aa", "ab", "aa", "ab")));
		assertEquals(Arrays.asList("aa", "ac", "aa"), getList(tb, test, Arrays.asList("aa", "ab", "ac", "ab", "ad", "aa")));
		assertEquals(Arrays.asList("ab", "ab"), getList(tb, test, Arrays.asList("ab", "ac", "aa", "ac", "ab", "ac")));
		assertEquals(Arrays.asList("ab", "ad"), getList(tb, test, Arrays.asList("ab", "ac", "aa", "ac", "ad", "ac")));
		assertEquals(Arrays.asList("ab", "ab"), getList(tb, test, Arrays.asList("ab", "ac", "aa", "ac", "ab", "ac")));
		assertEquals(Arrays.asList("ab", "ad", "aa", "ad", "ab"), getList(tb, test, Arrays.asList("ab", "ad", "aa", "ad", "ab", "ac")));
		assertEquals(Arrays.asList("ab", "az", "ac", "ay", "ac"), getList(tb, test, Arrays.asList("ab", "ac", "az", "ac", "ay", "ac")));
		assertEquals(Arrays.asList("ba", "bac", "aba", "bac", "bab", "aac"), getList(tb, test, Arrays.asList("ba", "bac", "aba", "bac", "bab", "aac")));
		assertEquals(Arrays.asList("ab", "bac", "ac", "bab", "aac"), getList(tb, test, Arrays.asList("ab", "bac", "ac", "ab", "bab", "aac")));
		
		Set<String> s = new HashSet<String>();
		assertEquals(fillSet(Arrays.asList("ab"), s), tb.noFollow("aa"));
		assertEquals(fillSet(Arrays.asList("ac", "aa"), s), tb.noFollow("ab"));
		assertEquals(fillSet(Arrays.asList("ad", "ab"), s), tb.noFollow("ac"));
		s.clear();
		assertEquals(s, tb.noFollow("zz"));
	}
	
	@Test
	public void testTaboo3() {
		List<Double> rules = new ArrayList<>();
		List<Double> test = new ArrayList<>();
		fillList(Arrays.asList(0.11 , 0.33, 0.55, null, 0.77, 0.99, 0.33), rules);
		Taboo<Double> tb = new Taboo<Double>(rules);
		
		assertEquals(Arrays.asList(0.11, 0.55, 0.77), getList(tb, test, Arrays.asList(0.11 , 0.33, 0.55, 0.77, 0.99)));
		assertEquals(Arrays.asList(0.99, 0.77, 0.55, 0.33, 0.11), getList(tb, test, Arrays.asList(0.99, 0.77, 0.55, 0.33, 0.11)));
		assertEquals(Arrays.asList(0.2, 0.4, 0.11, 0.88), getList(tb, test, Arrays.asList(0.2, 0.4, 0.11, 0.33, 0.88)));
		assertEquals(Arrays.asList(0.11, 0.99, 0.22, 3.14), getList(tb, test, Arrays.asList(0.11, 0.33, 0.99, 0.33, 0.22, 3.14)));
		assertEquals(Arrays.asList(10.00, 0.15, 0.33, 0.99, 0.22, 3.14, 0.80, 0.99), getList(tb, test, Arrays.asList(10.00, 0.15, 0.33, 0.99, 0.33, 0.22, 3.14, 0.80, 0.99)));
	
		Set<Double> s = new HashSet<Double>();
		assertEquals(fillSet(Arrays.asList(0.33), s), tb.noFollow(0.11));
		assertEquals(fillSet(Arrays.asList(0.55), s), tb.noFollow(0.33));
		assertEquals(fillSet(Arrays.asList(0.33), s), tb.noFollow(0.99));
		s.clear();
		assertEquals(s, tb.noFollow(0.55));
	}
	
	@Test
	public void testTaboo4() {
		List<Character> rules = new ArrayList<>();
		List<Character> test = new ArrayList<>();
		fillList(Arrays.asList('a', 'b', 'c', 'z', 'x', null, 'a', 'y', 'z'), rules);
		Taboo<Character> tb = new Taboo<Character>(rules);
		
		assertEquals(Arrays.asList(null, 'a', 'c', 'x', 'b', 'a', 'z'), getList(tb, test, Arrays.asList(null, 'a', 'b', 'c', 'z', 'x', 'b', 'a', 'y', 'z')));
		assertEquals(Arrays.asList('a', 'a', 'c', 'a', 'a'), getList(tb, test, Arrays.asList('a', 'a', 'y', 'b', 'b', 'c', 'a', 'a', 'b')));
		assertEquals(Arrays.asList('b', 'x', 'z', 'z', 'a', 'z'), getList(tb, test, Arrays.asList('b', 'x', 'z', 'z', 'x', 'a', 'b', 'y', 'z')));
		assertEquals(Arrays.asList('a', 'x', null, 'a'), getList(tb, test, Arrays.asList('a', 'x', null, 'a')));
		assertEquals(Arrays.asList('a', 'x', 'y', null), getList(tb, test, Arrays.asList('a', 'x', 'y', 'z', null)));
		assertEquals(Arrays.asList('a', 'x', 't', 'm', 'x' , 'a', 'x', 'y', 'x'), getList(tb, test, Arrays.asList('a', 'x', 't', 'm', 'x' , 'a', 'x', 'y', 'z', 'x')));
		assertEquals(Arrays.asList('a', 'x', 'a'), getList(tb, test, Arrays.asList('a', 'x', 'a')));
		
		Set<Character> s = new HashSet<Character>();
		assertEquals(fillSet(Arrays.asList('b', 'y'), s), tb.noFollow('a'));
		assertEquals(fillSet(Arrays.asList('c'), s), tb.noFollow('b'));
		assertEquals(fillSet(Arrays.asList('x'), s), tb.noFollow('z'));
		s.clear();
		assertEquals(s, tb.noFollow('x'));
	}
	// TODO ADD TESTS
}
