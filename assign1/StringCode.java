package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if(str.isEmpty() || str.length() == 1)return str.length();
		int max_run = 0;
		int curr_run = 1;
		char ch = str.charAt(0);
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == ch)curr_run++;
			else {
				ch = str.charAt(i);
				max_run = Math.max(curr_run, max_run);
				curr_run = 1;
			}
		}
		return Math.max(max_run, curr_run);
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		if(str.isEmpty())return str;
		String res = "";
		for(int i = 0; i < str.length()-1; i++) {
			if(Character.isDigit(str.charAt(i))) {
				for(int j = 0; j < str.charAt(i) - '0'; j++) {
					res += str.charAt(i+1);
				}
			}else {
				res += str.charAt(i);
			}
		}
		char last = str.charAt(str.length()-1);
		if(!Character.isDigit(last))res += last;
		return res; // TODO ADD YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if(len > a.length() || len > b.length())return false;
		for(int i = 0; i + len <= a.length(); i++) {
			String curr_sub = a.substring(i, i + len);
			if(b.contains(curr_sub))return true;
		}
		return false; // TO DO ADD YOUR CODE HERE
	}
}
