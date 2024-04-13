package nicshal.homework21;

public class Printer implements Runnable {

    private final int order;
    private final String printString;
    private final Synchronizer syn;

    public Printer(String printString, Synchronizer syn) {
        this.printString = printString;
        this.syn = syn;
        syn.getFlagList().add(false);
        this.order = syn.getFlagList().size() - 1;
    }

    @Override
    public void run() {
        print();
    }

    private void print() {
        synchronized (syn.getMonitor()) {
            int i = 0;
            while (i < syn.getCount()) {
                if (syn.getFlagList().get(order)) {
                    System.out.print(printString);
                    syn.getFlagList().set(order, false);
                    syn.setNext(order, true);
                    i++;
                    syn.getMonitor().notifyAll();
                } else {
                    try {
                        syn.getMonitor().wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return Printer.class.getSimpleName() + '{' +
                "order=" + order +
                ", printString='" + printString + '\'' +
                ", syn=" + syn +
                '}';
    }

}