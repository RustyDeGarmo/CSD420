/*
Rusty DeGarmo
Professor Payne
Advanced Java
14 November 2021
*/

/*
Instructions:
1: Write a test program that reads words from a text file and displays all 
    non-duplicate words in ascending order and then in descending order.
        *The file is to be referenced in the program, not needing to be 
            used as a command line reference.
        *The word file is to be titled collection_of_words.txt.
2: Write test code that ensures the code functions correctly
*/

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ModFiveSets {
    public static void main(String[] args) throws IOException {
        File fileOfStrings = new File("collection_of_words.txt");
        Scanner myScanner = new Scanner(fileOfStrings);
        String theWholeFileString = "";
        

        if(fileOfStrings.exists()){
            while(myScanner.hasNextLine()){
                theWholeFileString += myScanner.nextLine();
            }
            TreeSet<String> setOfStrings = 
                new TreeSet<String>(Arrays.asList(splitStringWords(theWholeFileString)));

            System.out.println("\n\nThe whole string: \n" + theWholeFileString);
            
            System.out.println("\n\nPrinting the set in sorted order:\n");
            printSet(setOfStrings);
            System.out.println("\n\nPrinting the set in reverse sorted order:\n");
            printReverseSet(setOfStrings);

            System.out.println("\n");
        }else{
            System.out.println("The file does not exist.");
        }

    }

    private static String[] splitStringWords(String s){
        //return a string array of individual words from the provided string
        if(s == null || s.equals("")){
            System.out.println("There is no string or the string is empty");
            return new String[0];
        }else{
            //characters to split the strings by
            String[] words = s.split("[ !\"\\#$%&()*+,-./:;<=>?@\\[\\]^_`{|}~]+");
            return words;
        }
    }

    private static void printSet(TreeSet set){
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }

    private static void printReverseSet(TreeSet set){
        int counter = set.size();
        for(int i = 0; i < counter; i++){
            System.out.print(set.pollLast() + " ");
        }
    }

}