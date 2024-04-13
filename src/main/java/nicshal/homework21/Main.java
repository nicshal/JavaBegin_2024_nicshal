package nicshal.homework21;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final int NUMBER_REPETITIONS = 7;
    public static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        Synchronizer synchronizer = new Synchronizer(new ArrayList<>(), NUMBER_REPETITIONS);

        Printer printer1 = new Printer("A", synchronizer);
        Printer printer2 = new Printer("B", synchronizer);
        Printer printer3 = new Printer("C", synchronizer);
        Printer printer4 = new Printer("D", synchronizer);
        Printer printer5 = new Printer("E", synchronizer);

        synchronizer.activatePrinting();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        executor.execute(printer1);
        executor.execute(printer2);
        executor.execute(printer3);
        executor.execute(printer4);
        executor.execute(printer5);
        executor.shutdown();
    }

}