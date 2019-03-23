/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	private HashMap<Integer, Set<T>> rules;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		for(int i = 0; i < rules.size() - 1; i++) {
			if(rules.get(i) == null || rules.get(i+1) == null) continue;
			if(this.rules.containsKey(rules.get(i).hashCode())) {
				this.rules.get(rules.get(i).hashCode()).add(rules.get(i+1));
			}else {
				Set<T> val = new HashSet<>();
				val.add(rules.get(i+1));
				this.rules.put(rules.get(i).hashCode(), val);
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
		 return this.rules.get(elem.hashCode()); // TODO YOUR CODE HERE
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i = 1; i < list.size(); i++) {
			if(this.rules.get(list.get(i-1).hashCode()).contains(list.get(i))) {
				list.remove(i);	i--;
			}
		}
	}
}
