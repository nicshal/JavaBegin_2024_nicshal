package nicshal.homework6;

public class Plate {

    private int maxPlateFilling;
    private int currentPlateFilling;

    public Plate(int maxPlateFilling, int currentPlateFilling) {
        this.maxPlateFilling = maxPlateFilling;
        this.currentPlateFilling = currentPlateFilling;
    }

    public Plate(int maxPlateFilling) {
        this(maxPlateFilling, maxPlateFilling);
    }

    public int getMaxPlateFilling() {
        return maxPlateFilling;
    }

    public void setMaxPlateFilling(int maxPlateFilling) {
        this.maxPlateFilling = maxPlateFilling;
    }

    public int getCurrentPlateFilling() {
        return currentPlateFilling;
    }

    public void setCurrentPlateFilling(int currentPlateFilling) {
        if (currentPlateFilling > 0) this.currentPlateFilling = Math.min(currentPlateFilling, getMaxPlateFilling());
        else this.currentPlateFilling = 0;
    }

    public void addFood(int foodAmount) {
        if (foodAmount > 0)
            setCurrentPlateFilling(getCurrentPlateFilling() + foodAmount);
    }

    public boolean removeFood(int foodAmount) {
        if (foodAmount <= 0) {
            return true;
        }
        if (getCurrentPlateFilling() >= foodAmount) {
            setCurrentPlateFilling(currentPlateFilling - foodAmount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Cat.class.getSimpleName() + '{' +
                "maxPlateFilling=" + maxPlateFilling +
                ", currentPlateFilling=" + currentPlateFilling +
                '}';
    }

}