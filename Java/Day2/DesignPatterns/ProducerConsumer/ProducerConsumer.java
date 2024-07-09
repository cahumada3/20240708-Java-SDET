package Java.Day2.DesignPatterns.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProducerConsumer {

    /**
     * PRODUCER CONSUMER
     *      -> one entity (usally a thread) produces data (generate/recieve/read in)
     *         another entity (usally a thread) consumes that data (process/manage/manipulate)
     * 
     *      -> used in multithreading in java
     * 
     * 
     * 
     * 
     * CONCURRENT COLLECTIONS
     *      -> java.util.concurrent
     *      -> thread safe collections
     *          - they will handle synchronozation for us 
     *      -> queues are FIFO
     * 
     * 
     */

    public static void main(String[] args) {

        final Queue<Integer> buffer = new ConcurrentLinkedQueue<>();    // the size of the collection will never change
        final int CAPACITY = 5;                                         // final means the value cannot be changed - capacity will alway be 5

        Thread producerThread = new Thread(new Runnable() {

            /**
             * ANONYMOUS INNER CLASS
             *      -> a class that isn't declared but is defined
             *      -> only created with funcational interfaces
             */

            @Override
            public void run() {
                int value = 0;

                // simulating grabbing values from somewhere and putting them on the queue
                while(true) {
                    if(buffer.size() < CAPACITY) {
                        System.out.println("Producer produces: " + value);
                        buffer.add(value++);
                    }
                }

            }
        });

        /**
         * LAMBDA FUNCTIONS
         *      -> shorthand way to implement the *mehtod* of a funcational interface
         */

        Thread consumerThread = new Thread((/*any parameter for the method */) -> {

            //THIS IS THE RUN METHOD FROM THE RUNNABLE CLASS

            while(true) {
                if(!buffer.isEmpty()) {
                    int value = buffer.poll();  //poll - retrieves data from the front of the queue and removes it
                    System.out.println("Consumer consumes: " + value);
                    
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }
    
}
