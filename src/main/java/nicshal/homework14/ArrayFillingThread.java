package nicshal.homework14;

public class ArrayFillingThread extends Thread {

    private final double[] array;
    private final int startIndex;
    private final int finishIndex;

    public ArrayFillingThread(double[] array, int startIndex, int finishIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.finishIndex = finishIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < finishIndex; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

}