/*
Rusty DeGarmo
Professor Payne
Advanced Java
7 November 2021
*/

/*
The purpose of this program:
1: Write a test program that stores 50,000 integers in LinkedList and test the
    time to travers the list using an iterator vs. using the get(index) method
2: Then, test your program storing 500,000 integers
3: After completing this program and having tested both values,
    in your comments, explain the results and discuss the time taken
    using both values and their difference with the get(index) approach
4: Write test code that ensures the code functions correctly
*/

/*
Results:
With 50,000 Integers the get(i) method took 2991 milliseconds and 
the Iterator method took 1653 milliseconds. The get(i) method took
almost twice the time the iterator method did.

With 500,000 Integers the get(i) method took 335,911 milliseconds
and the Iterator method took 15,815 milliseconds. The get(i) method
took over 21 times as much time as the iterator method did.

That really showcases the inefficiency of using get(i) with a linked list
when working with bigger data sets.

I turned it down to 500 Integers after testing just so it wouldn't take so 
long to run during grading. Even at 500 integers, the get(i) method took 
three times as long to run. This smaller list size also allows us to verify 
that the list hasn't been modified between timed tests.

*/

import java.util.LinkedList;
import java.util.Iterator;

public class TimedList{
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>();
        fillList(500, list);
        long startTime = time();

        printList(list);

        long endTime = time();

        int getMethodTime = (int)(endTime - startTime);
        
        System.out.println("\n");

        //run again using Iterator
        startTime = time();

        printListIterator(list);

        endTime = time();

        int getIteratorTime = (int)(endTime - startTime);

        System.out.println("\n\nExecution took " + getMethodTime + " milliseconds " + 
            "using the .get(i) method ");

        System.out.println("\n\nExecution took " + getIteratorTime + " milliseconds " + 
            "using the Iterator method ");
        System.out.println("\n");
    }


    public static LinkedList<Integer> fillList(int cap, LinkedList<Integer> list){
        //fill a list with a custom number of Integers

        for(int i = 0; i < cap; i++){
            list.add(getRandom());
        }

        return list;
    }
    public static long time(){
        return System.currentTimeMillis();
    }

    public static int getRandom(){
        return (int)(Math.random() * 50 + 1);
    }

    public static <E> void printList(LinkedList<E> list){
        //print the list using the .get(i) method
        for(int i = 0; i < list.size(); i++){
            
            if(i % 100 == 0){
                System.out.print("\n" + list.get(i) + " ");
            }else {
                System.out.print(list.get(i) + " ");
            }

        }
    
    }

    public static <E> void printListIterator(LinkedList<E> list){
        //print the list with an iterator
        Iterator<E> iterator = list.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            if(i % 100 == 0){
                System.out.print("\n" + iterator.next() + " ");
            }else {
                System.out.print(iterator.next() + " ");
            }
            i++;
        }
    
    }
}
