/*
 * Name: 					REDACTED
 * Problem Set: 	PS1
 * Due Date: 			March 11, 2026
 */
public class PS1 {
	public static void main(String[] args) {
		int[][] a = {
			{3, 5, 2, 7},
			{4, 1, 3, 8},
			{6, 3, 8, 2},
			{9, 6, 1, 5} };
		
		int[][] b = {
			{1, 2, 1},
			{2, 1, 2},
			{1, 1, 2} };	
		
		System.out.println(calculateGrid(a, b, 1, 1));
	}
	
	public static int calculateGrid(int[][] a, int[][] b, int x, int y) {
		int sum = 0;
		int xCount = 0;
		int yCount = 0;
		
		// Moving coords up and to the left.
		x--;
		y--;
		
		for(int i = y; i < y + 3; i++) {
			for(int j = x; j < x + 3; j++) {
				if( x == -1 || y == -1 || x == a[0].length || y == a.length ) {
					sum += 0 * b[yCount][xCount];
				}
				sum += a[i][j] * b[yCount][xCount];
				xCount++;
			}
			yCount++;
			xCount = 0;
		}
		return sum;
	}
}
