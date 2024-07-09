package Java.Day2.FileIO;

import java.util.Scanner;

public class CmdLineIO {
    public static void main(String[] args) {

        // system default is the command line
        System.out.println("Hello World!");

        Scanner scanIn = new Scanner(System.in);

        /**
         * SCANNER
         *      -> all data has to be stored into a variable
         *              - specifically a primitive type OR String
         *      -> use nextLine() to read in data
         */

        System.out.println("Enter a string: ");

        String textInput = scanIn.nextLine();
    }
}
