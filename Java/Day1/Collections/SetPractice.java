package Java.Day1.Collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetPractice {

    /**
     * SETS
     *      -> unordered
     *      -> only contain unique values - no duplicates
     *      -> no indexes - use iterators to loop through them
     */

    public static void main(String[] args) {

        HashSet<String> names = new HashSet<>();

        names.add("Jeremiah");
        names.add("Joey");
        names.add("Jesse");

        System.out.println(names);

        /**
         * HashSets are going to use hashcode to be able to determine whatever location your gonna be in
         * 
         * 
         * ITERATORS
         *      -> allow you to move through a collection, without a loop
         *      -> you can move through a collection ar your own pace 
         */

        System.out.println("ITERATOR");
        Iterator<String> nameItr = names.iterator();
        
        String name1 = nameItr.next();

        System.out.println(name1);

        System.out.println(nameItr.next());


        Iterator<String> nameItr2 = names.iterator();
        while(nameItr2.hasNext()) {
            System.out.println(nameItr2.next());
        }
        
    
    }
    
}
