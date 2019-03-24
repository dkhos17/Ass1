package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		if(a.isEmpty() || b.isEmpty()) return 0;
		HashMap<Integer, Integer> cnt1 = new HashMap<>();
		HashMap<Integer, Integer> cnt2 = new HashMap<>();
		for(T e1 : a) {
			Integer h1 = e1.hashCode();
			if(cnt1.containsKey(h1))cnt1.put(h1, cnt1.get(h1)+1);
			else cnt1.put(h1, 1);
		}
		for(T e2 : b) {
			Integer h2 = e2.hashCode();
			if(cnt2.containsKey(h2))cnt2.put(h2, cnt2.get(h2)+1);
			else cnt2.put(h2, 1);
		}
		int res = 0;
		for(Integer k : cnt1.keySet()) {
			if(cnt1.get(k).equals(cnt2.get(k)))res++;
		}
		return res; 
	}
	
}
