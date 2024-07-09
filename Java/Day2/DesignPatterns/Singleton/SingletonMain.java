package Java.Day2.DesignPatterns.Singleton;

public class SingletonMain {

    public static void main(String[] args) {

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        instance1.increment();
        instance1.increment();
        instance2.increment();
        instance1.decrement();
        instance2.increment();
        instance2.increment();


        System.out.println("Instance1 count: " + instance1.getCount());
        System.out.println("Instance2 count: " + instance2.getCount());

        // prints out each object - memory addresses are the same
        System.out.println(instance1);
        System.out.println(instance2);
    }
    
}
