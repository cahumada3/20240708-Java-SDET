package Java.Day1.Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPractice {
    /**
     * LISTS
     *      -> are ordered and indexed
     *      -> Collections API in Java - all lists will inherit from the List class
     *      -> ONLY WORK WITH OBJECTS
     *          - java gives you wrapper classes for primitive types
     *              - int -> Integer
     *              - double - Double
     *              - etc.
     */

    public static void main(String[] args) {
        
        /**
         * ARRAY LISTS
         *      -> dynamic array - grows as you add more data to it 
         *      -> does not shrink dynamically - need to use trimToSize()
         *      -> the starting capacity 10, unless you say otherwise
         *      -> once it's full it grows by 50%
         *              10 -> 15 -> 23 etc.
         * 
         *      -> lookup is O(1) with the index
         *      -> insertion is constant at the end of the array, only if there is no resizing
         *              -> if resizing, then it's O(n)
         *              -> if in the middle, then it's O(n)
         * 
         */


        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("mango");
        fruits.add("apple");
        fruits.add("pineapple");
        fruits.add("mango");
        fruits.add("mango");

        fruits.add(0, "banana");    //to insert at a specific index

        System.out.println(fruits.get(0));

        System.out.println(fruits);

        fruits.remove("mango");     //removes the first instance of the object
        System.out.println(fruits);

        System.out.println(fruits.indexOf("mango"));    //returns the index location of the first instance of that object

        /**
         * LINKED-LISTS
         *      -> non-consecutive memory locations
         *      -> each node contains at least one pointer to the next node and your data at that node 
         *      -> don't have indexes - lookup is O(n)
         *      -> insertion at the front and tail is O(1)
         *          - anywhere else is O(n)
         *      -> capacity will ALWAYS equal size
         *      -> java linked-lists are ALWAYS doubly linked
         */

        LinkedList<String> names = new LinkedList<>();

        names.add("Caroline");
        names.add("Bryar");
        names.add("Bruna");

        System.out.println(names);

        System.out.println(names.get(0));

    }
}
