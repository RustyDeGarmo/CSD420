/*
Rusty DeGarmo
Professor Payne
Advanced Java
7 November 2021
*/

/*
The purpose of this program:
1: Write a test program that contains a static method that returns a new ArraList
    *The new ArrayList returned will contain all original values with no 
        duplicates from the original ArrayList
    *Fill the Original ArrayList with 50 random values from 1 to 20
    *public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
2: Write test code that ensures the code functions correctly
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.lang.Math;

public class MyGenericList{
    public static void main(String[] args){
        ArrayList<Integer> ranList = new ArrayList<Integer>();

        for(int i = 0; i < 50; i++){
            ranList.add(getRandom());
        }

        System.out.println("\n\nThe random ArrayList is:");
        printList(ranList);

        System.out.println("\n\nThe new list after removing duplicates is:");
        ArrayList<Integer> newList = new ArrayList<Integer>(removeDuplicates(ranList));
        printList(newList);


        //add some numbers to test with
        System.out.println("\n\nAdd 5,10 15 and 20, then print again");
        newList.add(5);
        newList.add(10);
        newList.add(15);
        newList.add(20);
        printList(newList);

        System.out.println("\n\nRemove duplicates again and print one more time");
        newList = removeDuplicates(newList);
        printList(newList);

        System.out.println("\n");

    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        HashSet<E> set = new HashSet<E>(list); //Set removes all duplicates
        ArrayList<E> newList = new ArrayList<E>(set);
        return newList;
    }

    public static int getRandom(){
        return (int)(Math.random() * 20 + 1);
    }

    public static <E> void printList(ArrayList<E> list){
        for(int i = 0; i < list.size(); i++){
            
            if(i % 10 == 0){
                System.out.print("\n" + list.get(i) + " ");
            }else {
                System.out.print(list.get(i) + " ");
            }

        }
    
    }

}