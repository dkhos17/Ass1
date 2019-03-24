// Test cases for CharGrid -- a few basic tests are provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharGridTest {
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		CharGrid cg = new CharGrid(grid);			
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
		
		char[][] grid1 = new char[][] {
			{'a', 'b'},
			{'b', 'z'}
		};
	
		CharGrid cg1 = new CharGrid(grid1);
		assertEquals(1, cg1.charArea('a'));
		assertEquals(4, cg1.charArea('b'));
		
		char[][] grid2 = new char[][] {
			{'a'},
		};
	
		CharGrid cg2 = new CharGrid(grid2);
		assertEquals(1, cg2.charArea('a'));
		assertEquals(0, cg2.charArea('z'));
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	
	// TODO Add more tests
	
	@Test
	public void testCharArea3() {
		char[][] grid = new char[][] {
				{'a', 'b', 'c'},
				{'b', 'b', 'c'},
				{'c', 'c', 'c'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.charArea('a'));
		assertEquals(4, cg.charArea('b'));
		assertEquals(9, cg.charArea('c'));
		assertEquals(0, cg.charArea(' '));
		assertEquals(0, cg.charArea('d'));
	}
	
	@Test
	public void testCharArea4() {
		char[][] grid = new char[][] {
				{'a', 'b', ' '},
				{'b', 'a', 'b'},
				{' ', 'b', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(9, cg.charArea('a'));
		assertEquals(9, cg.charArea('b'));
		assertEquals(9, cg.charArea(' '));
		assertEquals(0, cg.charArea('c'));
	}
	
	@Test
	public void testCharArea5() {
		char[][] grid = new char[][] {
				{'a', 'b', 'c'},
				{'m', 'n', 'b'},
				{'y', 'x', 'c'},
				{'z', 'z', 'z'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.charArea('a'));
		assertEquals(4, cg.charArea('b'));
		assertEquals(1, cg.charArea('n'));
		assertEquals(1, cg.charArea('m'));
		assertEquals(3, cg.charArea('c'));
		assertEquals(1, cg.charArea('x'));
		assertEquals(1, cg.charArea('y'));
		assertEquals(3, cg.charArea('z'));
	}
	
	//countPlus() - Tests
	
	@Test
	public void testCountPlus1() {
		char[][] grid = new char[][] {
				{'a', 'm', 'b'},
				{'m', 'm', 'm'},
				{'y', 'm', 'x'}
			};
		
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus2() {
		char[][] grid = new char[][] {
				{'a', 'm', 'b', 'f', 'k'},
				{'m', 'm', 'm', 'f', 'k'},
				{'y', 'm', 'f', 'f', 'f'},
				{'b', 't', 't', 'f', 'k'}
			};
		
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
		
		char[][] grid1 = new char[][] {
			{'n', 'n', 'm', 'n', 'n'},
			{'n', 'n', 'm', 'n', 'n'},
			{'m', 'm', 'm', 'm', 'm'},
			{'k', 'k', 'm', 'k', 'k'},
			{'k', 'k', 'm', 'k', 'k'}
		};
		CharGrid cg1 = new CharGrid(grid1);
		assertEquals(1, cg1.countPlus());
		
	}
	
	@Test
	public void testCountPlus3() {
		char[][] grid = new char[][] {
			{'m', 'm', 'b', 'f', 'f'},
			{'m', 'm', 'm', 'f', 'f'},
			{'y', 'm', 't', 'f', 'f'},
			{'b', 't', 't', 't', 'k'},
			{'a', 'a', 't', 'a', 'a'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(2, cg.countPlus());
		
		char[][] grid1 = new char[][] {
			{'n', 'n', 'n', 'n', 'n'},
			{'m', 'm', 'm', 'm', 'm'},
			{'m', 'm', 'm', 'm', 'm'},
			{'m', 'm', 'm', 'm', 'm'},
			{'n', 'n', 'n', 'n', 'n'}
		};
		CharGrid cg1 = new CharGrid(grid1);
		assertEquals(0, cg1.countPlus());
	}
	
	@Test
	public void testCountPlus4() {
		char[][] grid = new char[][] {
			{'m', 'm', 'm', 'm', 'm'},
			{'m', 'm', 'm', 'm', 'm'},
			{'m', 'm', 'm', 'm', 'm'},
			{'m', 'm', 'm', 'm', 'm'},
			{'m', 'm', 'm', 'm', 'm'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
		
		char[][] grid1 = new char[][] {
			{'n', 'n', 'n', 'n', 'n'},
			{'n', 'n', 'n', 'm', 'm'},
			{'m', 'n', 'm', 'm', 'm'},
			{'n', 'm', 'm', 'm', 'n'},
			{'n', 'n', 'm', 'n', 'n'}
		};
		CharGrid cg1 = new CharGrid(grid1);
		assertEquals(3, cg1.countPlus());
	}
	
	@Test
	public void testCountPlus5() {
		char[][] grid = new char[][] {
			{' ', 'p', ' ', ' ', ' ', ' '},
			{'p', 'p', 'p', ' ', ' ', ' '},
			{' ', 'p', ' ', 'k', ' ', ' '},
			{' ', ' ', ' ', 'k', 't', ' '},
			{' ', 'k', 'k', 'k', 'k', 'k'},
			{'m', ' ', 'm', 'k', ' ', ' '},
			{' ', ' ', ' ', 'k', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' '},
			{'m', 't', 'm', ' ', ' ', ' '}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(4, cg.countPlus());
	}
}
