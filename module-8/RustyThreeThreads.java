/*
Rusty DeGarmo
Professor Payne
Advanced Java
28 November 2021
*/

/*
The purpose of this program is to use multiple threads to print random characters
to a text area. Thread one is to output randm letters, thread two is to output 
random numbers 0-9, and thread three is to output random special characters. Each 
thread should display a minimum of 10,000 characters.
*/

import java.lang.Math;

public class RustyThreeThreads{

    public static void main(String[] args){

        Runnable run = () -> {
            long time = System.currentTimeMillis();
            System.out.println("Thread 1 Start");
            for(int i = 0; i <= 10000; i++){
                System.out.print((char)getRandomLetter());
            }
            long endTime = System.currentTimeMillis() - time;
            System.out.println("\n\nThread 1 Finish: " + endTime + " milliseconds");
        };

        Runnable run2 = () -> {
            long time = System.currentTimeMillis();
            System.out.println("Thread 2 Start");
            for(int i = 0; i <= 10000; i++){
                System.out.print(getRandomNumber());
            }
            long endTime = System.currentTimeMillis() - time;
            System.out.println("\n\nThread 2 Finish: " + endTime + " milliseconds");
        };

        Runnable run3 = () -> {
            long time = System.currentTimeMillis();
            System.out.println("Thread 3 Start");
            for(int i = 0; i <= 10000; i++){
                System.out.print((char)getRandomSpecial());
            }
            long endTime = System.currentTimeMillis() - time;
            System.out.println("\n\nThread 3 Finish: " + endTime + " milliseconds");
        };

        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run2);
        Thread thread3 = new Thread(run3);

        thread1.start();
        thread2.start();
        thread3.start();

/* 
Testing Area
        for(int i = 0; i < 50; i++){
            System.out.println((char)getRandomLetter());
        }  
*/
}


    private static int getRandomLetter(){
        //return the ascii code for a lower case letter
        return (int)(Math.random() * 26 + 97);
    }

    private static int getRandomNumber(){
        //return a random digit between 0 and 9
        return (int)(Math.random() * 10);
    }

    private static int getRandomSpecial(){
        //return the ascii code for a random special character

        //create an array of the special character ascii codes
        int[] chars = {33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 
            44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93,
            94, 95, 96, 123, 124, 125, 126};

        return chars[(int)(Math.random() * chars.length)];
    }

}