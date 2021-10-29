/*
Rusty DeGarmo
Professor Payne
Advanced Java Programming
28 October 2021
*/


/*
The purpose of this program is to use recursion to return
the sum of the numbers m(i) = 1/2 + 2/3 + 2/4 + 2/5 + ...  i/(i+1)
*/

import java.util.Scanner;

public class RecursiveSum {
    public static void main(String[] args){

        Scanner scanInput = new Scanner(System.in);

        //test with user input
        System.out.println("\n\nThis program sums the numbers");
        System.out.println("1/2 + 2/3 + 3/4 + ... i/(i+1).");
        System.out.println("\nEnter a positive integer.");
        double userIn = scanInput.nextDouble();

        System.out.println("\nYour result is: " + rSum(userIn));



        //test with predefined values
        System.out.println("\n\nThe results for i = 5 is: " + rSum(5));
        System.out.println("\n\nThe result for i = 10 is: " + rSum(10));
        System.out.println("\n\nThe result for i = 18 is: " + rSum(18));
        System.out.println("\n\n");

    }

    public static double rSum(double i){
            double total = 0;
            total = rSumHelper(i, total);

            return total;
        }

    public static double rSumHelper(double i, double total){
        if(i > 1){
            total += (i/(i+1));
            return rSumHelper(i-1, total);
            }
                
        else{
            return total += (i/(i+1));
        }
    }
}
