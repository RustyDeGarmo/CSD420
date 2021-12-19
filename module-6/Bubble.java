/*
Rusty DeGarmo
Professor Payne
Advanced Java Programming
21 November 2021
*/

/*
The purpose of this program is to create two generic bubble sort methods.
One should use the comparator interface and one should use comparable. 
The methods must be:

public static <E extends Comparable<E>> void bubbleSort(E[] list)

and:

public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator)
*/

import java.lang.Math;
import java.util.Comparator;

public class Bubble{
    public static void main(String[] args){

        //create an array of integers to test my comparable method
        Integer[] intList = new Integer[20];
        for(int i = 0; i < intList.length; i++){
            intList[i] = ((int)(Math.random() * 50 + 1 ));
        }

        System.out.println("\n\nThe list of 20 random integers: ");
        printList(intList);

        //sort the integers into natural order using the compareTo method
        bubbleSort(intList);

        System.out.println("\nThe list sorted by comparable: ");
        printList(intList);

        //create an array of Strings to test my comparable method
        String[] strList = {"Java", "SQL", "Python", "NoSQL", "ECMAScript", "TypeScript"};
        
        System.out.println("The list of Strings: ");
        printList(strList);

        //sort the strings with an anonymous comparator using natural order
        bubbleSort(strList, (s1, s2) -> s1.compareTo(s2));

        System.out.println("The Strings in natural sorted order: ");
        printList(strList);
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        /*
        This works for the purposes of this assignment because I'm
        just using integers and strings, which already implement
        comparable. If I were using a custom class to create
        objects my class would have to implement Comparable<ObjectType>
        */
        bubbleSort(list, (e1, e2) -> ((Comparable<E>)e1).compareTo(e2));
    }


    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator){
        /*
        This method accepts an array and a comparator to sort by. This way
        I can feed it whatever comparator I want that works with the objects
        that the list array contains if I want to sort in a unique way. Such as 
        a collection of objects representing people that I want to sort by 
        age or tenure or whatever.
        */

        boolean stillNotSorted = true; //We don't know if the list is sorted yet

        for(int i = 1; i < list.length && stillNotSorted; i++){
            stillNotSorted = false; // we might be done
            for(int j = 0; j < list.length - i; j++){
                if(comparator.compare(list[j], list[j + 1]) > 0){
                    
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    stillNotSorted = true; //we might not be done
                }
            }
        }
    }

    public static <E> void printList(E[] list){
        for(E i : list){
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}