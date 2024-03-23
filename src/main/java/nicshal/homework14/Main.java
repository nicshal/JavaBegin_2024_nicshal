package nicshal.homework14;

import java.time.Duration;
import java.time.Instant;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        double[] doubleArray = new double[100_000_000];

        fillArrayWithMetrics (doubleArray, 1, Main::fillArray);
        fillArrayWithMetrics (doubleArray, 4, Main::fillArray);
        fillArrayWithMetrics (doubleArray, 10, Main::fillArray);
        fillArrayWithMetrics (doubleArray, 100, Main::fillArray);
        fillArrayWithMetrics (doubleArray, 1000, Main::fillArray);
    }

    public static void fillArray(double[] doubleArray, int count) {
        int size = doubleArray.length / count;
        Thread[] threadArray = new Thread[size];
        for (int i = 0; i < count; i++) {
            threadArray[i] = new ArrayFillingThread(doubleArray, size * i, size * (i + 1));
            threadArray[i].start();
        }
        for (int i = 0; i < count; i++) {
            try {
                threadArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fillArrayWithMetrics (double[] doubleArray, int count, BiConsumer<double[], Integer> runnable) {
        System.out.println("Количество потоков: " + count);
        Instant start = Instant.now();
        runnable.accept(doubleArray, count);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Время заполнение массива, мс: " + elapsed);
    }

}