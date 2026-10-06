/****************************************************************
 *
 * File: dictionaryDriver.java
 * By: Jasmine Menjivar
 * Date: 11/14/25
 *
 * Description: This interactive program creates a small dictionary using enum
 * objects and copies them onto a multimap. Using the multimap,
 * these objects can be searched for by the user.
 *
 ****************************************************************/

package MyDictionary;
import com.google.common.collect.Multimap;
import java.util.*;

public class dictionaryDriver {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        //header
        System.out.println("- DICTIONARY 220 JAVA Standard -----\n" +
                "----- powered by Google Guava -\n");

        //declare and initialize multimap
        Multimap<String, String> dictionary = new CSC220Dictionary().createMultimap();
        Scanner scanner = new Scanner(System.in);


        //prompt initial input
        System.out.print("Search: ");
        String input = scanner.next();

        while(!input.equals("!q")) {
            System.out.println("    |");
            //search for entry
            search(input, dictionary);

            //repeats prompt
            System.out.print("Search: ");
            input = scanner.next();
        }
        System.out.println("\n-----THANK YOU-----");


    }

    //finds matching entry to user input
    public static void search(String input, Multimap<String, String> dict){
        String inputToKey = "-1"; //default

        //finding key
        for(String key: dict.keys()){
            if(key.equalsIgnoreCase(input)) {
                inputToKey = key;
            }
        }

        //executes if key is found
        if (!inputToKey.equals("-1")){
            String foundKey = inputToKey;
            dict.values().forEach((value) -> {
                if (dict.containsEntry(foundKey, value)) {
                    System.out.printf("     %s: %s\n", foundKey, value);
                }
            });
        } else { //executes when key isn't found
            System.out.println("     <Not Found>");
        }
        System.out.println("    |");

    }
}
