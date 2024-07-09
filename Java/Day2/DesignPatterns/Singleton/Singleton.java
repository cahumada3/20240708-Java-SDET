package Java.Day2.DesignPatterns.Singleton;

public class Singleton {

    /**
     * SINGLETON
     *      -> when you only want ONE instance of an object
     *      -> useful whyen working with threads - every thread will be using the same object
     * 
     * 
     * EAGER vs LAZY LOADING
     * 
     *      eager loading - instantiate an  object as soon as possible 
     *              faster but could result in unnecessary memory allocation 
     * 
     *      lazy loading - only instantiate the object when it is asked for 
     *              slower but no memory is wasted
     */

    private static Singleton instance;  //THIS is an object

    private static Singleton ins = new Singleton(); // this is eager loading

    private int count = 0;

    public Singleton() { }

    public void increment() {
        this.count++;
    }

    public void decrement() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }

    public static Singleton getInstance() {

        //eager loading
        return ins;

        // lazily loading
        //if(instance == null) {
        //    instance = new Singleton();
        //} 

        //return instance;
    }
}
