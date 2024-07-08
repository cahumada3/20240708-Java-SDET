package Java.Day1.FourPillars;
//package - wraps up your project and the scope of certain classes

public class FourPillarsMain {

    //main is the starting point of your projects
    public static void main(String[] args) {

        // how to print to the command line in java
        // sysout is a short cut
        System.out.println("Hello World!");

        /**
         * 
         * POLYMORPHISM
         *      covariance - allows a child class to act in place of a parent class
         */

        // creates a new car object
        Vehicle car = new Car("four-cylinder", "Toyota", "Tacoma");

        // print out our car using the toString()
        System.out.println(car.toString());

        car.start();
        car.drive();

        Vehicle segway = new Segway("segway", 2, "lithium-ion");
        System.out.println(segway.toString());
        System.out.println(segway.getNumWheels());
        segway.start();
        segway.drive();
    
    }

}