package Java.Day1.Collections;

import java.util.HashMap;

public class MapPractice {

    public static void main(String[] args) {
        /**
         * MAPS
         *      -> unordered and operate on key-value pairs
         *      -> key has to be 100% unique
         *      -> value can be anything
         * 
         * HASHMAPS
         *      -> these uses hashcode() to determine index location
         *          - creates constant lookup time O(1)
         * 
         *      -> built on arrays so they do have indexes, but we don't work with them 
         * 
         *      -> collisions
         *          - technically these *shouldn't* happen, but they can
         *          - happens when multiple keys have the same hashcode and get put into the same index location
         *                  java creates a linked-list at that index location
         *          - under the hood, our hashmaps are arrays of linked-lists
         */

        HashMap<String, Animal> animalMap = new HashMap<>();

        Animal lion = new Animal("leo");
        Animal dog = new Animal("kuma");
        Animal turtle = new Animal("tilly");

        animalMap.put("lion", lion);
        animalMap.put("dog", dog);
        animalMap.put("turle", turtle);

        animalMap.get("lion");
        System.out.println(animalMap);

        System.out.println(animalMap.get("dog"));

        Animal lion2 = new Animal("leonardo");
        animalMap.put("lion", lion2);
        System.out.println(animalMap);
    }
    
}
