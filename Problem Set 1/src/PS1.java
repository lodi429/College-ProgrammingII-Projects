/*
 * Name: 				REDACTED
 * Problem Set: 		PS1
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
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[1].length; j++) {
				System.out.print(calculateGrid(a, b, i, j) + " ");
			}
			System.out.println();
		}
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
				if( j == -1 || i == -1 || j == a[0].length || i == a.length ) {
					sum += 0 * b[yCount][xCount];
				}else {
					sum += a[i][j] * b[yCount][xCount];
				}
				xCount++;
			}
			yCount++;
			xCount = 0;
		}
		return sum;
	}
}
