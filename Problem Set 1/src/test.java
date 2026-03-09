import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
class test{
  public static void main(String[] args){
   try{ 
      Scanner inFile = new Scanner(new FileReader(args[0]));
      System.out.println(fileLength(inFile));
    } catch (FileNotFoundException e){
      System.out.println("Test");
    }
  }

  public static int fileLength(Scanner inFile){
    int[] lengths = new int[2];
    int count = 0;
    while(inFile.hasNext()){
      count++;
      String line = inFile.nextLine();
    }
    return count;
  }
}
