/**********************************
 *          Student Name:   REDACTED
 *          Username:       REDACTED
 *          Assignment:     PS2
 *          Due Date:       March 16, 2026
 **********************************/
import java.io.*;

class PS2Coins{
    public static void main(String[] args) {
        String fileName = "coins.txt";
        readFile(fileName);
    }
    public static void readFile(String fileName) {
        String line = "";
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        double total = 0;
        try ( BufferedReader br = new BufferedReader( new FileReader(fileName) ) ){
            while( (line = br.readLine()) != null){
                String[] coins = line.split(",");
                for(int i = 0; i < coins.length; i++){
                    int coin = Integer.parseInt(coins[i]);
                    if(coin == 25){
                        quarters += 1;
                        total += 0.25;
                    }else if(coin == 10){
                        dimes += 1;
                        total += 0.1;
                    }else if(coin == 5){
                        nickels += 1;
                        total += 0.05;
                    }else if(coin == 1){
                        pennies += 1;
                        total += 0.01;
                    }
                }

            }
            System.out.printf("Penny Count:\t%d --> %d\n", pennies, pennies);
            System.out.printf("Nickel Count:\t%d --> %d\n", nickels, nickels * 5);
            System.out.printf("Dime Count:\t%d --> %d\n", dimes, dimes * 10);
            System.out.printf("Quarter Count:\t%d --> %.2f\n", quarters, quarters * 0.25);
            System.out.printf("\t\t\t\tTotal: $%.2f", total);
        }catch(FileNotFoundException e){
            System.out.println("Error: File not Found");
        }catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
