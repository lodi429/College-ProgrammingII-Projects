/*
 * Name: 				Jerick Gilla-Fowler
 * Problem Set: 		PS1
 * Due Date: 			March 11, 2026
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class PS1Problem1{
	public static void main(String[] args) {
		// Error Handling for arguments
		if(args.length < 2 || args.length > 2){
			System.out.println("Insert 2 files into the arguments. Exiting...");
			System.exit(2);
		}
		int[][] a = fileToArray(args[0]);
		int[][] b = fileToArray(args[1]);
		int[][] c = calculateGrid(a, b);

		// Error handling for Matrix Length
		if(b.length >= a.length || b[0].length >= a[0].length){
			System.out.println("B matrix must be of smaller size than the A matrix. Exiting...");
			System.exit(3);
		}else if(b.length % 2 != 1 || b.length != b[0].length){
			System.out.println("B matrix must be a square matrix of odd length");
			System.exit(3);
		}

		System.out.println("Problem Set 1:  Low Performance Solution");
		System.out.println("Name: Jerick Gilla-Fowler");
		System.out.println("************************************************************\n");
		System.out.printf("Input File for A:\t%s\n", args[0]);
		System.out.printf("Input File for B:\t%s\n\n", args[1]);
		System.out.println("Input Array A:\n");
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				String line = String.format("%-4s", a[i][j]);
				System.out.print(line);
			}
			System.out.println();
		}
		System.out.println("\n");
		
		System.out.println("Input Array B:\n");
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b[0].length; j++){
				String line = String.format("%-4s", b[i][j]);
				System.out.print(line);
			}
			System.out.println();
		}
		System.out.println("\n************************************************************\n");
		System.out.println("Result:\n");	

		for(int i = 0; i < c.length; i++){
			for(int j = 0; j < c[0].length; j++){
				String line = String.format("%-4s", c[i][j]);
				System.out.print(line);
			}
			System.out.println();
		}

	}
	public static int[][] calculateGrid(int[][] a, int[][]b){
		int[][] c = new int[a.length][a[0].length];
		for(int i = 0; i < c.length; i++){
			for(int j = 0; j < c[0].length; j++){
				c[i][j] = weightedSum(a, b, j, i);
			}
		}
		return c;
	}
	
	public static int weightedSum(int[][] a, int[][] b, int x, int y) {
		/*
		 * Takes a spot in A matrix and in an area
		 * matching the B matrixes area, it multiplies the corner 
		 * from the spot to a corner in the B array 
		 * and adds to a sum integer. This continues until all spots
		 * in both 3x3s are multiplied and added together,
		 * at which point it returns the sum.
		 */
		int sum = 0;
		int xCount = 0; // xCount and yCount are B matrix locations
		int yCount = 0;
		
		// Moving coords up and to the left.
		x -= (b.length - 1) / 2;
		y -= (b.length - 1) / 2;
	/*
	 * Instead of setting the boundary for i and j 
	 * to b.length, I set the boundary to 
	 * y + b.length and x + b.length.
	 * Reason being is that im setting my
	 * boundaries to be as big as the B matrix
	 * is. Because I'm starting at the the
	 * upper
	 */
		for(int i = y; i < y + b.length; i++) { 
			for(int j = x; j < x + b[0].length; j++) {
				if( j < 0 || i < 0 || j >= a[0].length || i >= a.length ) {
					sum += 0 * b[yCount][xCount]; // redundant line but included to show what happens whenever outofbounds of matrix
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
		 * reads each line in file, splits it into array,
		 * reads that array and parses each part of the 
		 * array as integers and puts them in their own array,
		 * and adds that array to the 2D matrix to be returned.
		 * at the end of the method.
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
		  System.out.println("Invalid File Name. Exiting...");
		  System.exit(1);
		  return null;
	  }
  }
  public static int fileLength(String file){
  	/*
  	 * Separating fileLength into its own method
  	 * to keep fileToArray from becoming too bloated
  	 * Also in case I would like to use this
  	 * method again in other projects.
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
  		System.out.println("Invalid File Name. Exiting...");
  		System.exit(1);
  		return -1;
  	}
  }
}
