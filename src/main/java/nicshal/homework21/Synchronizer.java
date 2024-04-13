package nicshal.homework21;

import java.util.List;

public class Synchronizer {

    private final Object monitor = new Object();
    private final List<Boolean> flagList;
    private final int count;

    public Synchronizer(List<Boolean> flagList, int count) {
        this.flagList = flagList;
        this.count = count;
    }

    public Object getMonitor() {
        return monitor;
    }

    public List<Boolean> getFlagList() {
        return flagList;
    }

    public int getCount() {
        return count;
    }

    public void setNext(int idx, Boolean flag) {
        if (idx == flagList.size() - 1) {
            flagList.set(0, flag);
        } else {
            flagList.set(idx + 1, flag);
        }
    }

    public void activatePrinting() {
        flagList.set(0, true);
    }

    @Override
    public String toString() {
        return Synchronizer.class.getSimpleName() + '{' +
                "monitor=" + monitor +
                ", flagList=" + flagList +
                ", count=" + count +
                '}';
    }

}