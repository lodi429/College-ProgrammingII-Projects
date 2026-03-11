/*
 * this java file is primarily for me
 * testing importing txt files into arrays
 * with the same size as the amount of 
 * lines in the file without arraylists
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
class test{
  public static void main(String[] args){
    try{ 
	    Scanner inFile = new Scanner(new FileReader(args[0]));
	    String test[][] = new String[ fileLength(args[0]) ][0];
	    while( inFile.hasNext() ) {
		    for(int i = 0; i < test.length; i++) {
			    test[i] = inFile.nextLine().split(" ");
		    }
	    }
	    for(int i = 0; i < test.length; i++) {
		    for (int j = 0; j < test[i].length; j++) {
			    System.out.print(test[i][j] + " ");
		    }
		    System.out.println();
	    }
    }catch(FileNotFoundException e){
      System.out.println("Test");
    }
  }

  public static int fileLength(String file){
	  try {
		  Scanner filee = new Scanner(new FileReader(file));
		  int count = 0;
		  while(filee.hasNext()) {
		   	count++;
		   	filee.nextLine();
		  }
		  filee.close();
		  return count;
	  }catch(FileNotFoundException e) {
		  System.out.println("test");
		  return -1;
	  }
  }
}
