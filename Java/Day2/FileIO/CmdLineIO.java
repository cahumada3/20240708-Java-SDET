package Java.Day2.FileIO;

import java.io.PrintWriter;
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
        System.out.println("You entered: " + textInput); 

        System.out.println("Enter a number: ");
        double numInput = scanIn.nextDouble();
        System.out.println(numInput);

        // must close your scanners!! otherwise memory leaks
        scanIn.close();

        /**
         * PRINT WRITER
         *      -> allows for better formatting for our print statements
         *      -> also allows you to queue up several prints and flush them out at once
         */

        String name = "Anthony";
        int age = 22;
        double height = 162.5;
    
        System.out.println(name + " is " + age + " years old " + "and is " + height + " cm tall");

        PrintWriter consoleOut = new PrintWriter(System.out);

        consoleOut.printf("%s is %d years old and is %f cm tall", name, age,  height);

        consoleOut.print("This is a string");
        consoleOut.append("This string is appended to the previous");

        // need to flush out to be able to print to the terminal
        consoleOut.flush();

        consoleOut.print("This is another string");

        // can flush more than once
        consoleOut.flush();

        // close() will automatically invoke flush()
        consoleOut.close();
    }
}
