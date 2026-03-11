/*
 * Name: 				Jerick Gilla-Fowler
 * Problem Set: 		PS1
 * Due Date: 			March 11, 2026
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class PS1 {
	public static void main(String[] args) {
		int[][] a = fileToArray(args[0]);
		int[][] b = fileToArray(args[1]);
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}		
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b[0].length; j++){
				System.out.print(b[i][j] + " ");
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
	public static int[][] fileToArray(String file){
		/*
		 * 
		 */
	  try {
		  int length = fileLength(file);
		  Scanner newFile = new Scanner(new FileReader(file));
		  int[][] fileArray = new int[length][0];
		  while(newFile.hasNext()){
		  	for(int i = 0; i < fileArray.length; i++){
		  		String[] line = newFile.nextLine().split(" ");
		  		int[] nums = new int[line.length];
		  		for(int j = 0; j < line.length; j++){
						nums[j] = Integer.parseInt(line[j]);
		  		}
		  		fileArray[i] = nums;
		  	}
		  }
		  newFile.close();
		  return fileArray;
	  }catch(FileNotFoundException e) {
		  System.out.println("File Not Found");
		  return null;
	  }
  }
  public static int fileLength(String file){
  	/*
  	 * Separating fileLength into its own method
  	 * to keep fileToArray from becoming too bloated
  	 * Reads how many lines a file has.
  	 */
  	try{
  		Scanner filee = new Scanner(new FileReader(file));
		  int count = 0;
		  while(filee.hasNext()) {
		   	count++;
		   	filee.nextLine();
		  }
		  filee.close();
		  return count;
  	}catch(FileNotFoundException e) {
  		System.out.println("File Not Found");
  		return -1;
  	}
  }
}
