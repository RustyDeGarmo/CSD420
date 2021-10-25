/*
Rusty DeGarmo
Professor Payne
Advanced Java Programming
23 October 2021
*/


/*
The purpose of this program is to read and display
the data from the <yourlastname>datafile.dat
*/

import java.io.*;

public class TestRead {
    public static void main(String[] args){
        File file = new File("degarmodatafile.dat");
        int control = 0;
        
        
            //try with resources to create object output stream to write to the file
            try(ObjectInputStream input =
                new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(file))); ){
                do{
                    control++;
                    int[] inInt = (int[])(input.readObject());
                    java.util.Date inDate = (java.util.Date)(input.readObject());
                    double[] inDbl = (double[])(input.readObject());

                    System.out.println("\n\nEntry: " + control);
        
                    System.out.println("The integers are: ");
                    for(int i : inInt){System.out.print(i + ", ");}
        
                    System.out.println("\nThe Date is: " + inDate);
        
                    System.out.println("The doubles are: ");
                    for(double d : inDbl){System.out.print(d + ", ");}
        
                    System.out.println();
                    System.out.println();

                }while(control * 152 < file.length());

            }catch(IOException ex){
                ex.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
    }
}

