// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int min_len = -1, min_wid = grid.length;
		int max_len = -1, max_wid = -1;
		for(int i = 0; i < grid.length; i++) {
			int w1 = -1, w2 = -1;
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == ch) {
					if(w1 == -1)w1 = j;
					w2 = j;
				}
			}
			if(w1 != -1) {
				if(min_len == -1 )min_len = i;
				max_len = Math.max(i, max_len);	
				min_wid = Math.min(w1, min_wid);
				max_wid = Math.max(w2, max_wid);
			}
		}
		if(min_wid == -1 || max_wid == -1) return 0;
		if(min_len == -1 || max_len == -1) return 0;
		
		int area = (max_wid-min_wid+1)*(max_len-min_len+1);
		return area;
	}
	
	
	private boolean isPlus(int i, int j, int curr_len) {
		if(curr_len % 2 == 0 || curr_len < 3) return false;
		int stick = curr_len/2;
		if(i + stick >= grid.length) return false;
		if(i - stick < 0) return false;
		int up = -1, dw = -1;
		for(int k = i; k >= 0; k--) {
			if(grid[k][j-stick-1] == grid[i][j-1]) up++;
			else break;
		}
		if(up != stick) return false;
		for(int k = i; k < grid.length; k++) {
			if(grid[k][j-stick-1] == grid[i][j-1]) dw++;
			else break;
		}
		return dw == stick;
	}
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int res = 0;
		for(int i = 1; i < grid.length-1; i++) {
			char ch = grid[i][0];
			int curr_len = 1;
			for(int j = 1; j < grid[0].length; j++) {
				if(ch == grid[i][j]) {
					curr_len++;
					continue;
				}
				if(isPlus(i, j, curr_len))res++;
				ch = grid[i][j]; curr_len = 1;
			}
			if(isPlus(i, grid[0].length, curr_len)) res++;
		}
		return res;
	}
	
}
