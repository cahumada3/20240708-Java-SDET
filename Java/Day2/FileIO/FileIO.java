package Java.Day2.FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
    public static void main(String[] args) {

        //Relative path - use whenever you are within the same project 
        String inputFile = "Java\\Day2\\FileIO\\fileInput.txt";
        String outputFile = "Java\\Day2\\FileIO\\fileOutput.txt";

        //Path - use full path whenever you are not within the same project
        //String inputFilePath = "C:\\Users\\cahumada\\OneDrive - SkillStorm\\Java\\Batch\\20240708-Java-SDET\\Java\\Day2\\FileIO\\fileInput.txt";


        /**
         * TRY-CATCH
         *      -> put some "risky" code in the try block
         *      -> handle those errors in the catch block
         *              -> can only catch one at a time, but you can do multiple catch blocks
         */

        try {
            /**
             * FILE INPUT and OUTPUT STREAMS
             *      -> have to work with streams to have your data flow between files
             * 
             */
            
            InputStream inputStream = new FileInputStream(inputFile);   // creates a new input stream that can read fromt the inputfile
            OutputStream outputStream = new FileOutputStream(outputFile);   // creates a new output stream that can write to the outputfile

            // read in data from a file
            int byteData; // data is read in bytes

            // loops until the end of the file 
            while((byteData = inputStream.read()) != -1) {
                System.out.println(byteData);

                // write to the output file
                outputStream.write(byteData);   // will overwrite the file
            }

            inputStream.close();
            outputStream.close();

        } catch (IOException ioException) {
            System.out.println("Error with opening and closing files");
            ioException.printStackTrace();

        } catch (Exception e) {
            System.out.println("Something else went wrong");
            e.printStackTrace();

        }


        /**
         * CLASS LOADER and RESOURCE STREAM
         *      -> works similarily to FileInputStream
         *          - the difference:
         *              getResourceAsStream() grabs a static resource from your class path (ie. within your project)
         *      -> very useful for apps not running on your local machine 
         */

        // needs to be a relative path for getResourceAsStream()
        String resourcePath = "Java\\Day2\\FileIO\\fileInput.txt";
        try {
            // grabbing a static resource from our project and converting it into a stream
            InputStream inputStream = FileIO.class.getClassLoader().getResourceAsStream(resourcePath);

            // checking if we found the file
            if(inputStream != null) {

                int byteData;

                // loops until the end of the input file
                while((byteData = inputStream.read()) != -1) {

                    // converts each int into a character
                    System.out.println((char)byteData);
                }
            }
            else {
                System.out.println("Resource not found!");
            }
            inputStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         * TRY WITH RESOURCES
         *      -> still a try-catch block
         *      -> we pass in something that needs to be openeed (like a file stream)
         *         and it will automatically close it for us
         *      -> must implement the AutoClosable interface
         */
        try(FileInputStream fileInput = new FileInputStream(inputFile)) {

            int byteData;

            while((byteData = fileInput.read()) != -1){

                System.out.print((char)byteData);

            }
            //no longer need to close the inputStream

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    
}
