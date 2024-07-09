package Java.Day2.MultiThreading;

public class MultiThreadingIntro {
    
    /**
     * MULTI-THREADING 
     *      -> splitting different tasks onto multiple threads to be done concurrently
     *      -> by default we have a single Main thread that gets ran
     *      -> Doing your laundry
     *              washer -> dryer -> fold
     *              no sense in waiting for one load to be folded before putting a 2nd in the washer
     * 
     *      -> trade-off: performance speed vs power usage
     * 
     *      THREAD STATES
     *          1. NEW - created but not yet started (new Thread())
     *          2. RUNNABLE - thread has started (thread.start)
     *          3. BLOCKED - thread is waiting on some lock before continuing   
     *          4. WAITING - thread waiting indefinitely (thread.join() or thread.wait())
     *          5. TIMED-WAITING - thread waiting for a specified amount of time (thread.join(3000))
     *          6. TERMINATED - thread is finished
     * 
     */

     public static void main(String[] args) {

        RunnableTask task1 = new RunnableTask("Task 1");
        RunnableTask task2 = new RunnableTask("Task 2");
        RunnableTask task3 = new RunnableTask("Task 3");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
        
     }
}


/**
 * RUNNABLE INTERFACE
 *      -> a functional interface for defining how a thread will run
 *              - a functional interface is just an interface with 1 method 
 * 
 *      Why would you want to use the Runnable Interface over the Thread Class?
 *          - Runnable interface allows you to implement multiple and extend any other class
 *          - Thread class only lets you extend that one class
 * 
 */

class RunnableTask implements Runnable {

    private String taskName;

    public RunnableTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskName + " is running in the Thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
            System.out.println(taskName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}