package Java.Day1.FourPillars;


/**
 * INHERITANCE 
 *      - when a child class is given access to the variable and methods in the parents class
 *      - extends keyword for classes; can extend only 1 class
 *      - implements key word for interfaces; can implement multiple interfaces 
 */     


public class Segway extends Vehicle{
    
    private String battery;

    public Segway() {
        super(); //calls the no-arg constructor of a parent
    }


    public Segway(String type, int numWheels, String battery) {
        super(type, numWheels); //calls the parameterized constructor of the parent
        this.battery = battery; //calls another constructor in the same class
    }

    // getters and setters
    public String getBattery() {
        return battery;
    }


    public void setBattery(String battery) {
        this.battery = battery;
    }


    @Override
    public void drive(){
        System.out.println(battery + " is used to drive");
    }

    @Override
    public void start(){
        System.out.println("A button is pressed to start the segway");
        System.out.println();
    }


    @Override
    public String toString() {
        return "Segway [battery=" + battery + ", getNumWheels()=" + getNumWheels() + "]";
    }

}
