/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	private HashMap<Integer, Set<T>> rule;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		rule = new HashMap<>();
		for(int i = 0; i < rules.size() - 1; i++) {
			if(rules.get(i) == null || rules.get(i+1) == null) continue;
			int hash = rules.get(i).hashCode();
			if(rule.containsKey(hash)) {
				rule.get(hash).add(rules.get(i+1));
			}else {
				Set<T> val = new HashSet<>();
				val.add(rules.get(i+1));
				rule.put(hash, val); 	
			}
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		 Set<T> s = rule.get(elem.hashCode());
		 return s == null ? new HashSet<T>() :s; // TODO YOUR CODE HERE
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i) == null || list.get(i-1) == null) continue;
			int hash = list.get(i-1).hashCode();
			if(!rule.containsKey(hash)) continue;
			if(rule.get(hash).contains(list.get(i))) {
				list.remove(i);	i--;
			}
		}
	}
}
