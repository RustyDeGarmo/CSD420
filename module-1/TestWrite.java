/*
Rusty DeGarmo
Professor Payne
Advanced Java Programming
23 October 2021
*/


/*
The purpose of this program is to store:
    *An array of five random integers
    *A Data objective instance using the current date
    *An array of five random double values
Then append the data in a file titled <yourname>datafile.dat
*/

import java.io.*;
import java.lang.Math;

public class TestWrite {
    public static void main(String[] args){
        int[] iArray = new int[5];
        java.util.Date bDate = new java.util.Date();
        double[] dArray = new double[5];

        //fill the arrays with random numbers
        for(int i = 0; i < iArray.length; i++){
            iArray[i] = (int)(getRandom());
        }

        for(int i = 0; i < dArray.length; i++){
            dArray[i] = getRandom();
        }

        //try with resources to create object output stream to write to the file
        try(ObjectOutputStream output =
            new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream("degarmodatafile.dat", true))); ){
            output.writeObject(iArray);
            output.writeObject(bDate);
            output.writeObject(dArray);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    static double getRandom(){
        return Math.random() * 100;
    }
}
