//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

import java.util.ArrayList;
import java.util.List;

public class TetrisGrid {
    private boolean[][] gr, res;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
        this.gr = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
        int id = 0;
        List<Integer> idx = new ArrayList<Integer>();
        this.res = new boolean[gr.length][gr[0].length];

        for(int i = 0; i < gr[0].length; i++){
            boolean isFull = gr[0][i];
            for(int j = 1; j < gr.length; j++){
                if(!isFull) break;
                isFull = isFull & gr[j][i];
            }
            if(isFull) idx.add(i); 
        }

        for(int i = 0; i < gr[0].length; i++){
            if(idx.contains(i)) continue;
            for(int j = 0; j < gr.length; j++){
                res[j][id] = gr[j][i]; 
            }
            id++;
        }
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return res; // TODO YOUR CODE HERE
	}
}
